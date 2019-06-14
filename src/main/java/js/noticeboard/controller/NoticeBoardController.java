package js.noticeboard.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import js.noticeboard.model.NoticeBoardDTO;
import js.noticeboard.model.StorageDTO;
import js.noticeboard.service.NoticeBoardService;

@Controller
public class NoticeBoardController {
	
	@Autowired
	private NoticeBoardService service;

	public void setService(NoticeBoardService service) {
		this.service = service;
	}

	// 글 보기
	@RequestMapping("/noticeBoardMain.do")
	public ModelAndView mainPage(@RequestParam(value="options", defaultValue="0") int options, 
								@RequestParam(value="searchContent", defaultValue= " ") String searchContent,
								@RequestParam(value="pageNum", defaultValue="1" ) String pageNum,
								HttpSession session) {
		
		int pageSize = 5;		// 한페이지당 보여줄 글의 수
		int currentPage = Integer.parseInt(pageNum);	// 현재 페이지 
		int startRow = (currentPage - 1) * pageSize + 1;	// 시작번호
		int endRow = currentPage * pageSize;	// 끝 번호
		
		int nowId = (int)session.getAttribute("nowId");
		String returnPage = (String)session.getAttribute("mainPage");
		
		int count = 0;
		List<NoticeBoardDTO> mainList = new ArrayList<NoticeBoardDTO>();
		List<NoticeBoardDTO> searchList = new ArrayList<NoticeBoardDTO>();
		
		if(searchContent.equals(" ")) {
			mainList = service.getList(startRow, endRow);	// 페이지에 맞는 리스트 가져오기
			count = service.count();	// 전체 글의 개수
		}
		else {
			searchList = service.getSearchList(options, searchContent, startRow, endRow);	// 서치값 가져오기
			count = service.searchCount(options, searchContent);	// 서치된 글의 개수
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("noticeBoard/noticeBoardMain");
		mav.addObject("mainList", mainList);
		mav.addObject("searchList", searchList);
		mav.addObject("nowId", nowId);
		mav.addObject("returnPage", returnPage);
		mav.addObject("options", options);
		mav.addObject("searchContent", searchContent);
			
		mav.addObject("pageSize", pageSize);
		mav.addObject("count", count);//
		mav.addObject("currentPage", currentPage);
		
		return mav;
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////
	// 글 작성 폼
	@RequestMapping("/insertContentForm.do")
	public ModelAndView insertContentForm(HttpSession session) {
		int nowId = (int)session.getAttribute("nowId");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("noticeBoard/insertContentForm");
		mav.addObject("nowId", nowId);
		
		return mav;
	}
		
	// 글 작성
	@RequestMapping(value="/insertContent.do", method=RequestMethod.POST)
	public String insertContent(NoticeBoardDTO dto, @RequestParam("file") MultipartFile file, HttpServletResponse response) {

		service.insertContent(dto);
		printInfo(file, dto.getNum());	// 파일 업로드 메서드 호출
			
		return "redirect:noticeBoardMain.do";
	}
		
	// 파일 업로드
	private void printInfo(MultipartFile report, int num){
		// 현재시간 구하기
		Date time = new Date();
			
		File new_f = new File("c:\\Users\\jinse\\Desktop\\진성\\프로그래밍 언어\\HTML - 이젠컴퓨터아카데미\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\FinalProject\\noticeBoard\\" +time.getTime()+ report.getOriginalFilename());
										// time.getTime()은 밀리세컨드로 시간을 받는다 inTime으로 해도 된다.
		try {
			// 실제 경로에 저장을 하는 MultipartFile메서드
			report.transferTo(new_f);
		}catch (IllegalStateException e) {
		}catch (IOException e1) {}
			
		// DTO에 저장
		StorageDTO dto = new StorageDTO();
		dto.setNum(num);
		dto.setRealname(report.getOriginalFilename());
		dto.setRealpath(new_f.getPath());
		dto.setRealsize(report.getSize());
			
		service.Fileupload(dto);
	}
	////////////////////////////////////////////////////////////////////////////////
	// 글 상세보기
	@RequestMapping("/detailContent.do")
	public ModelAndView detailContent(@RequestParam("num") int num) {
			
		NoticeBoardDTO dto = service.detailContent(num);
		String name=service.getFileName(num);
			
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("noticeBoard/detailContent");
		modelAndView.addObject("detailContent", dto);
		modelAndView.addObject("name", name);
			
		return modelAndView;
	}
		
	// 파일다운로드
	@RequestMapping("/fileDownload.do")  
	public ModelAndView download(@RequestParam("num") int num) throws Exception{
		
		String path = service.FileDownload(num);
		File downloadFile = getFile(path);
			
		return new ModelAndView("download", "downloadFile", downloadFile);
	}
		
	private File getFile(String path) {
			
		return new File(path);	// 파일 객체를 리턴한다.
	}
	// 파일 다운로드 끝
	/////////////////////////////////////////////////////////////////////////////////////////
	// 글 수정 폼 -> 글의 내용을 value에 넣어주기 위해서 선언
	@RequestMapping("/updateContentForm.do")
	public ModelAndView updateContentForm(@RequestParam("num") int num, HttpSession session) {
		
		NoticeBoardDTO dto = service.updateContentInfo(num);
		String name=service.getFileName(num);
		int nowId = (int)session.getAttribute("nowId");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("noticeBoard/updateContentForm");
		modelAndView.addObject("detailContent", dto);
		modelAndView.addObject("nowId", nowId);
		modelAndView.addObject("name", name);
			
		return modelAndView;
	}
		
	// 글 수정
	@RequestMapping(value="/updateContent.do", method=RequestMethod.POST)
	public String updateContent(NoticeBoardDTO dto, @RequestParam("file") MultipartFile file,
								HttpServletResponse response) {
		
		service.updateContent(dto);
		ChangeprintInfo(file, dto.getNum());	// 파일 업로드 메서드 호출

		return "redirect:noticeBoardMain.do";
	}
		
	private void ChangeprintInfo(MultipartFile report, int num){
		// 현재시간 구하기
		Date time = new Date();
			
		File new_f = new File("c:\\Users\\jinse\\Desktop\\진성\\프로그래밍 언어\\HTML - 이젠컴퓨터아카데미\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\FinalProject\\noticeBoard\\" +time.getTime()+ report.getOriginalFilename());
										// time.getTime()은 밀리세컨드로 시간을 받는다 inTime으로 해도 된다.
		try {
			// 실제 경로에 저장을 하는 MultipartFile메서드
			report.transferTo(new_f);
		}catch (IllegalStateException e) {
		}catch (IOException e1) {}
			
		// DTO에 저장
		StorageDTO dto = new StorageDTO();
		dto.setNum(num);
		dto.setRealname(report.getOriginalFilename());
		dto.setRealpath(new_f.getPath());
		dto.setRealsize(report.getSize());
			
		service.ChangeFileupload(dto);
	}
	/////////////////////////////////////////////////////////////////////////////////////////////
	// 글 삭제
	@RequestMapping("/deleteContent.do")
	public String deleteContent(@RequestParam("num") int num, HttpServletResponse response) {
		
			service.deleteContent(num);

			return "redirect:noticeBoardMain.do";
		}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

}
