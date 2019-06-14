package js.guestinput.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import js.guestinput.model.GuestInputDTO;
import js.guestinput.service.GuestInputService;
import js.noticeboard.model.StorageDTO;

@Controller
public class GuestInputController {

	@Autowired
	private GuestInputService service;

	public void setService(GuestInputService service) {
		this.service = service;
	}
	
	@RequestMapping(value="/guestInputForm.do", method=RequestMethod.GET)
	public String guestInputForm(HttpSession session, Model model) {
		
		int nowId = (int)session.getAttribute("nowId");
		model.addAttribute("nowId", nowId);
		
		return "guestInput/guestInputForm";
	}
	
	@RequestMapping(value="/guestInputForm.do", method=RequestMethod.POST)
	public String guestInput(GuestInputDTO dto, @RequestParam("file") MultipartFile file, 
							HttpServletResponse response) {
		
		System.out.println(dto);
		service.insertGuestInput(dto);
		printInfo(file, dto.getNum());	// 파일 업로드 메서드 호출
		
		return "guestInput/guestInputForm";// "redirect:guestPage.do";
	}
	
	// 파일 업로드
	private void printInfo(MultipartFile report, int num) {
		// 현재시간 구하기
		Date time = new Date();

		File new_f = new File("c://FinalProgect//guestInput//" + time.getTime() + report.getOriginalFilename());
		// time.getTime()은 밀리세컨드로 시간을 받는다 inTime으로 해도 된다.
		try {
			// 실제 경로에 저장을 하는 MultipartFile메서드
			report.transferTo(new_f);
		} catch (IllegalStateException e) {
		} catch (IOException e1) {
		}
		System.out.println("여기까지는 온다.");
		// DTO에 저장
		StorageDTO dto = new StorageDTO();
		dto.setNum(num);
		dto.setRealname(report.getOriginalFilename());
		dto.setRealpath(new_f.getPath());
		dto.setRealsize(report.getSize());

		service.Fileupload(dto);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping("/guestInputSubmit.do")
	public ModelAndView guestInputSubmit(@RequestParam(value="options", defaultValue="0") int options, 
										@RequestParam(value="searchContent", defaultValue=" ") String searchContent,
										@RequestParam(value="pageNum", defaultValue="1" ) String pageNum,
										HttpSession session) {

		int pageSize = 5;		// 한페이지당 보여줄 글의 수
		int currentPage = Integer.parseInt(pageNum);	// 현재 페이지 
		int startRow = (currentPage - 1) * pageSize + 1;	// 시작번호
		int endRow = currentPage * pageSize;	// 끝 번호
		
		int nowId = (int)session.getAttribute("nowId");
		String returnPage = (String)session.getAttribute("mainPage");
		
		int count = 0;
		List<GuestInputDTO> mainList = new ArrayList<GuestInputDTO>();
		List<GuestInputDTO> searchList = new ArrayList<GuestInputDTO>();
		
		if(searchContent.equals(" ")) {
			mainList = service.getList(startRow, endRow);	// 페이지에 맞는 리스트 가져오기
			count = service.count();	// 전체 글의 개수
		}
		else {
			searchList = service.getSearchList(options, searchContent, startRow, endRow);	// 서치값 가져오기
			count = service.searchCount(options, searchContent);	// 서치된 글의 개수
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("guestInput/guestInputSubmit");
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
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// 글 상세보기
	@RequestMapping("/guestInputDetail.do")
	public ModelAndView detailContent(@RequestParam("num") int num) {

		GuestInputDTO dto = service.detailContent(num);
		String name = service.getFileName(num);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("guestInput/guestInputDetail");
		modelAndView.addObject("detailContent", dto);
		modelAndView.addObject("name", name);

		return modelAndView;
	}

	// 파일다운로드
	@RequestMapping("/guestInputDetailFileDownload.do")
	public ModelAndView download(@RequestParam("num") int num) throws Exception {

		String path = service.FileDownload(num);
		File downloadFile = getFile(path);

		return new ModelAndView("download", "downloadFile", downloadFile);
	}

	private File getFile(String path) {

		return new File(path); // 파일 객체를 리턴한다.
	}
	//////////////////////////////////////////////////////////////////////////////////
	@RequestMapping("/addBoard.do")
	public void addBoard() {
		
	}
	
	
	
}
