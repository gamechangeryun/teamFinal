package mi.hw.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import mi.hw.board.model.hwDTO;
import mi.hw.board.service.hwService;

@Controller
public class hwController {
	
	@Autowired
	hwService service;
 
	public void setService(hwService service) {
		this.service = service;
	}
	
	// 글 보기
	@RequestMapping("/hw_bd/board.do")
	public ModelAndView mainPage(@RequestParam(value="options", defaultValue="0") int options, 
								@RequestParam(value="searchContent", defaultValue=" ") String searchContent,
								@RequestParam(value="pageNum", defaultValue="1" ) String pageNum,
								HttpSession session) {
		
		int pageSize = 10;		// 한페이지당 보여줄 글의 수
		int currentPage = Integer.parseInt(pageNum);	// 현재 페이지 
		int startRow = (currentPage - 1) * pageSize + 1;	// 시작번호
		int endRow = currentPage * pageSize;	// 끝 번호
		
		int nowId = (int)session.getAttribute("nowId");
		String returnPage = (String)session.getAttribute("mainPage");
		int position = (int)session.getAttribute("position");
		
		int count = 0;	// 전체 글의 개수
		// int number = count-(currentPage - 1) * 10;	// 글 목록에 표시할 글 번호
		
		List<hwDTO> mainList = new ArrayList<hwDTO>();	// 리스트 전부 가져오기
		List<hwDTO> searchList = new ArrayList<hwDTO>();	// 서치값 가져오기

		if(searchContent.equals(" ")) {
			mainList = service.getList(startRow, endRow);
			count = service.count();
		}
		else {
			searchList = service.getSearchList(options, searchContent, startRow, endRow);
			count = service.searchCount(options, searchContent);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hw_bd/mainPage");
		mav.addObject("mainList", mainList);
		mav.addObject("searchList", searchList);
		mav.addObject("nowId", nowId);
		mav.addObject("returnPage", returnPage);
		mav.addObject("position", position);
		mav.addObject("options", options);
		mav.addObject("searchContent", searchContent);
		
		mav.addObject("pageSize", pageSize);
		mav.addObject("count", count);//
		mav.addObject("currentPage", currentPage);
		return mav;
	}
	
	// 글 작성 폼
	@RequestMapping("/hw_bd/insertContentForm.do")
	public ModelAndView insertContentForm(HttpSession session) {
		
		int nowId = (int)session.getAttribute("nowId");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hw_bd/insertContentForm");
		mav.addObject("nowId", nowId);
		
		
		return mav;
	}
	
	// 글 작성
	@RequestMapping(value="/hw_bd/insertContent.do", method=RequestMethod.POST)
	public String insertContent(hwDTO dto, @RequestParam("file") MultipartFile file, HttpServletResponse response) {
		
		service.insertContent(dto);
		printInfo(file, dto.getHomework_num());	// 파일 업로드 메서드 호출
		
		return "redirect:board.do";
	}

	// 글 상세보기
	@RequestMapping("/hw_bd/detailContent.do")
	public ModelAndView detailContent(@RequestParam("num") int num, HttpServletRequest request) {
		
		hwDTO dto = service.detailContent(num);
		
		String name = service.getFileName(num);
		String path = service.FileDownload(num);
		
		System.out.println(num);
		System.out.println(name);
		System.out.println(path);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("hw_bd/detailContent");
		modelAndView.addObject("detailContent", dto);
		modelAndView.addObject("name", name);
		modelAndView.addObject("path", path);
		
		return modelAndView;
	}

	// 파일 업로드
	private void printInfo(MultipartFile report, int num){
		// 현재시간 구하기
		Date time = new Date();
		
		File new_f = new File("D:\\01_java\\newspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp4\\wtpwebapps\\SpringProject\\hw_bd\\resource\\" + time.getTime() + report.getOriginalFilename());
										// time.getTime()은 밀리세컨드로 시간을 받는다 inTime으로 해도 된다.
		try {

			// 실제 경로에 저장을 하는 MultipartFile메서드
			report.transferTo(new_f);
		}catch (IllegalStateException e) {
		}catch (IOException e1) {}
		
		System.out.println(num);
		
		// DTO에 저장
		hwDTO dto = new hwDTO();
		dto.setHomework_num(num);
		dto.setLecture_num(num);
		dto.setRealname(report.getOriginalFilename());
		dto.setRealpath(new_f.getPath());
		dto.setRealsize(report.getSize());
			
		service.Fileupload(dto);
	}
	
	// 파일다운로드
	@RequestMapping("/hw_bd/fileDownload.do")  
	public ModelAndView download(HttpServletRequest request, @RequestParam("num") int num) throws Exception{
		
		
//		String name = service.getFileName(num);
		
//		String rnpath = context.getServletContext().getRealPath("/") + name;
		
		String rnpath = service.FileDownload(num);
		
		System.out.println(rnpath);
		
		File downloadFile = getFile(rnpath);
		
		
		return new ModelAndView("download", "downloadFile", downloadFile);
	}
	
	
	// 파일이 저장되는 경로
	private File getFile(String rnpath) {
		
		
		return new File(rnpath);	// 파일 객체를 리턴한다.
	}
	// 파일 다운로드 끝
	
	// 글 수정 폼 -> 글의 내용을 value에 넣어주기 위해서 선언
	@RequestMapping("/hw_bd/updateContentForm.do")
	public ModelAndView updateContentForm(@RequestParam("num") int num, HttpSession session) {
		
		hwDTO dto = service.detailContent(num);
		String name=service.getFileName(num);
		int nowId = (int)session.getAttribute("nowId");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("hw_bd/updateContentForm");
		modelAndView.addObject("detailContent", dto);
		modelAndView.addObject("nowId", nowId);
		modelAndView.addObject("name", name);
		
		System.out.println(num);
		
		return modelAndView;
	}
	
	// 글 수정
	@RequestMapping(value="/hw_bd/updateContent.do", method=RequestMethod.POST)
	public String updateContent(hwDTO dto, @RequestParam("file") MultipartFile file) {
		
		service.updateContent(dto);
		ChangeprintInfo(file, dto.getHomework_num());	// 파일 업로드 메서드 호출
		
		return "redirect:board.do";
		
	}
	
	// 과제 제출 확인을 위해서
	@RequestMapping(value="/hw_bd/hwsubon.do")
	public String hwsubon(@RequestParam("num") int num, HttpServletRequest request, HttpSession session) {
		
		service.hwsubon(num);
		
		System.out.println(num);

		return "redirect:board.do";
	}
	
	
	private void ChangeprintInfo(MultipartFile report, int num){
		// 현재시간 구하기
		Date time = new Date();
		
		File new_f = new File("D:\\01_java\\newspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp4\\wtpwebapps\\SpringProject\\hw_bd\\resource\\" +time.getTime()+ report.getOriginalFilename());
										// time.getTime()은 밀리세컨드로 시간을 받는다 inTime으로 해도 된다.
		
		try {
			// 실제 경로에 저장을 하는 MultipartFile메서드
			report.transferTo(new_f);
		}catch (IllegalStateException e) {
		}catch (IOException e1) {}
		
		// DTO에 저장
		hwDTO dto = new hwDTO();
		dto.setHomework_num(num);
		dto.setLecture_num(num);
		dto.setRealname(report.getOriginalFilename());
		dto.setRealpath(new_f.getPath());
		dto.setRealsize(report.getSize());
		
		service.ChangeFileupload(dto);
	}
	
	// 글 삭제
	@RequestMapping(value="/hw_bd/deleteContent.do")
	public String deleteContent(@RequestParam("num") int num, HttpServletResponse response) {
			
		service.deleteContent(num);
		
		return "redirect:board.do";	
	}
	  
}