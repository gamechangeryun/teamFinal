package sr_controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import sr_model.MtFileDTO;
import sr_model.bdDTO;
import sr_service.MtService;

@Controller
public class mt_cotroller {

	@Autowired
	MtService service;

	public void setService(MtService service) {
		this.service = service;
	}

	// 글 보기
	@RequestMapping("/mtmt/mtmtlist.do")
	public ModelAndView mainPage(@RequestParam(value="options", defaultValue="0") int options, 
								@RequestParam(value="searchContent", defaultValue=" ") String searchContent,
								@RequestParam(value="pageNum", defaultValue="1" ) String pageNum,
								HttpSession session) {
		
		int pageSize = 5;		// 한페이지당 보여줄 글의 수
		int currentPage = Integer.parseInt(pageNum);	// 현재 페이지 
		int startRow = (currentPage - 1) * pageSize + 1;	// 시작번호
		int endRow = currentPage * pageSize;	// 끝 번호
		//int count = service.count();	// 전체 글의 개수
		// int number = count-(currentPage - 1) * 10;	// 글 목록에 표시할 글 번호
		/*
		 * System.out.println("===="); System.out.println("카운트:"+count);
		 * System.out.println("시작번호:"+startRow); System.out.println("끝번호:"+endRow);
		 */
		
		//아이디 세션부분
		//int nowId = (int)session.getAttribute("nowId");
		//String returnPage = (String)session.getAttribute("mainPage");
		
		
		int count = 0;
		//List<bdDTO> mainList = service.getList(startRow, endRow);	// 리스트 전부 가져오기
		//List<bdDTO> searchList = service.getSearchList(options, searchContent);	// 서치값 가져오기

		List<bdDTO> mainList = new ArrayList<bdDTO>();
		List<bdDTO> searchList = new ArrayList<bdDTO>();
		
		if(searchContent.equals(" ")) {
			mainList = service.getList(startRow, endRow);	// 페이지에 맞는 리스트 가져오기
			count = service.count();	// 전체 글의 개수
		}
		else {
			searchList = service.getSearchList(options, searchContent, startRow, endRow);	// 서치값 가져오기
			count = service.searchCount(options, searchContent);	// 서치된 글의 개수
		}
		
		
		//System.out.println(mainList);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mtmt/Mtmain");
		mav.addObject("mainList", mainList);
		mav.addObject("searchList", searchList);
		
		//mav.addObject("nowId", nowId);
		//mav.addObject("returnPage", returnPage);
		
		mav.addObject("options", options);
		mav.addObject("searchContent", searchContent);
		
		mav.addObject("pageSize", pageSize);
		mav.addObject("count", count);//
		mav.addObject("currentPage", currentPage);
		return mav;
	}
	
	// 글 작성 폼
	@RequestMapping("/mtmt/insertContentForm.do")
	public ModelAndView insertContentForm() {
		
		//int nowId = (int)session.getAttribute("nowId");
		//ModelAndView mav = new ModelAndView();
		//mav.setViewName("mtmt/insertContentForm");
		//mav.addObject("nowId", nowId);
		
		int num = service.lastNum();
		
		return new ModelAndView("mtmt/insertContentForm", "lastNum", num);
	}
	
	// 글 작성
	@RequestMapping(value="/mtmt/insertContent.do", method=RequestMethod.POST)
	public String insertContent(bdDTO dto, @RequestParam("file") MultipartFile file) {
		System.out.println("확인1");
		
		int check = service.insertContent(dto);
		
		//파일테이블이 notnull이라서 파일이 없을 경우 파일 메서드 실행을 안하게 조건을 걸어준다.
		System.out.println("file :: "+ file);
		if(file != null) {
			System.out.println("파일 첨부 널 확인");
			printInfo(file, dto.getNum());	// 파일 업로드 메서드 호출
		}
		
		if(check > 0) {
			return "mtmt/insertContentSuccess";
		}
		
		return "mtmt/insertContentFalse";
	}
	
	//파일 업로드
	private void printInfo(MultipartFile report, int num){
		// 현재시간 구하기
		Date time = new Date();
		
		File new_f = new File("C:\\Users\\jinse\\Desktop\\진성\\프로그래밍 언어\\HTML - 이젠컴퓨터아카데미\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\FinalProject\\mtmtBoard\\" +time.getTime()+ report.getOriginalFilename());
										// time.getTime()은 밀리세컨드로 시간을 받는다 inTime으로 해도 된다.
		try {
			// 실제 경로에 저장을 하는 MultipartFile메서드
			report.transferTo(new_f);
		}catch (IllegalStateException e) {
		}catch (IOException e1) {}
		
		
		// DTO에 저장
		MtFileDTO dto = new MtFileDTO();
		dto.setNum(num);
		dto.setRealname(report.getOriginalFilename());
		dto.setRealpath(new_f.getPath());
		dto.setRealsize(report.getSize());
		
		service.Fileupload(dto);
	}
	
	// 글 상세보기
	@RequestMapping("/mtmt/detailContent.do")
	public ModelAndView detailContent(@RequestParam("num") int num) {
		
		bdDTO dto = service.detailContent(num);
		String name=service.getFileName(num);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("mtmt/detailContent");
		modelAndView.addObject("detailContent", dto);
		modelAndView.addObject("name", name);
		
		return modelAndView;
	}
	
	// 파일다운로드
		@RequestMapping("/mtmt/fileDownload.do")  
		public ModelAndView download(@RequestParam("num") int num) throws Exception{
			System.out.println("다운로드 체크");
			String path = service.FileDownload(num);
			File downloadFile = getFile(path);
			
			return new ModelAndView("download", "downloadFile", downloadFile);
		}
		
		private File getFile(String path) {
			System.out.println("path :: " + path);
			
			return new File(path);	// 파일 객체를 리턴한다.
		}
		// 파일 다운로드 끝
	
	// 글 수정 폼 -> 글의 내용을 value에 넣어주기 위해서 선언
	@RequestMapping("/mtmt/updateContentForm.do")
	public ModelAndView updateContentForm(@RequestParam("num") int num) {
		
		bdDTO dto = service.detailContent(num);
		String name=service.getFileName(num);
		//int nowId = (int)session.getAttribute("nowId");
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("mtmt/updateContentForm");
		modelAndView.addObject("detailContent", dto);
		modelAndView.addObject("name", name);
		//modelAndView.addObject("nowId", nowId);
		return modelAndView;
	}
	
	// 글 수정
	@RequestMapping(value="/mtmt/updateContent.do", method=RequestMethod.POST)
	public String updateContent(bdDTO dto, @RequestParam("file") MultipartFile file, HttpServletResponse response) {
		
		int num = dto.getNum();
		String name = service.getFileName(num);
		
		int check = service.updateContent(dto);
		
		if(file != null) {
			ChangeprintInfo(file, dto.getNum());	// 파일 업로드 메서드 호출
		}
		
		return "redirect:mtmtlist.do";
		
	}
	
	private void ChangeprintInfo(MultipartFile report, int num){
		// 현재시간 구하기
		Date time = new Date();
		
		File new_f = new File("C:\\Users\\jinse\\Desktop\\진성\\프로그래밍 언어\\HTML - 이젠컴퓨터아카데미\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\FinalProject\\mtmtBoard\\" +time.getTime()+ report.getOriginalFilename());
										// time.getTime()은 밀리세컨드로 시간을 받는다 inTime으로 해도 된다.
		try {
			// 실제 경로에 저장을 하는 MultipartFile메서드
			report.transferTo(new_f);
		}catch (IllegalStateException e) {
		}catch (IOException e1) {}
		
		// DTO에 저장
		MtFileDTO dto = new MtFileDTO();
		dto.setNum(num);
		dto.setRealname(report.getOriginalFilename());
		dto.setRealpath(new_f.getPath());
		dto.setRealsize(report.getSize());
		
		service.ChangeFileupload(dto);
	}
	
	// 글 삭제 폼
	/*@RequestMapping("/mtmt/deleteContentForm.do")
	public ModelAndView deleteContentForm(@RequestParam("num") int num) {
		return new ModelAndView("deleteContentForm", "deleteNum", num);
	}*/
	
	// 글 삭제
	@RequestMapping(value="/mtmt/deleteContent.do", method=RequestMethod.POST)
	public String deleteContent(@RequestParam("num") int num, HttpServletResponse response) {
			
		service.deleteContent(num);
			
		
		return "redirect:mtmtlist.do";
		
		/*if(check > 0) {
			return "deleteContentSuccess";
		}else {
			return "deleteContentFalse";	
		}*/
	}
}// end
