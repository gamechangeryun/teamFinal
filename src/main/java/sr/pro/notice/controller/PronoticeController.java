package sr.pro.notice.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sr.pro.notice.model.PronoticeDTO;
import sr.pro.notice.service.PronoticeService;

@Controller
public class PronoticeController {

	@Autowired
	private PronoticeService service;

	public void setService(PronoticeService service) {
		this.service = service;
	}

	// 글 보기
	@RequestMapping("/PronoticeboardMain.do")
	public ModelAndView mainPage(@RequestParam(value = "options", defaultValue = "0") int options,
			@RequestParam(value = "searchContent", defaultValue = " ") String searchContent,
			@RequestParam(value = "pageNum", defaultValue = "1") String pageNum, HttpSession session) {

		System.out.println("공지사항 글보기 진입 체크");

		int pageSize = 5; // 한페이지당 보여줄 글의 수
		int currentPage = Integer.parseInt(pageNum); // 현재 페이지
		int startRow = (currentPage - 1) * pageSize + 1; // 시작번호
		int endRow = currentPage * pageSize; // 끝 번호

		// int nowId = (int)session.getAttribute("nowId");
		String returnPage = (String) session.getAttribute("mainPage");

		int count = 0;
		List<PronoticeDTO> mainList = new ArrayList<PronoticeDTO>();
		List<PronoticeDTO> searchList = new ArrayList<PronoticeDTO>();

		if (searchContent.equals(" ")) {
			mainList = service.getList(startRow, endRow); // 페이지에 맞는 리스트 가져오기
			count = service.count(); // 전체 글의 개수
		} else {
			searchList = service.getSearchList(options, searchContent, startRow, endRow); // 서치값 가져오기
			count = service.searchCount(options, searchContent); // 서치된 글의 개수
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("pronotice/pronoticeMain");
		mav.addObject("mainList", mainList);
		mav.addObject("searchList", searchList);
		// mav.addObject("nowId", nowId);
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
	@RequestMapping("/ProinsertContentForm.do")
	public ModelAndView insertContentForm(HttpSession session) {
		// int nowId = (int)session.getAttribute("nowId");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("pronotice/ProinsertContentForm");
		// mav.addObject("nowId", nowId);

		return mav;
	}

	// 글 작성
	@RequestMapping(value = "/ProinsertContent.do", method = RequestMethod.POST)
	public String insertContent(PronoticeDTO dto, HttpServletResponse response) {

		service.insertContent(dto);

		return "redirect:PronoticeboardMain.do";
	}

	// 글 상세보기
	@RequestMapping("/ProdetailContent.do")
	public ModelAndView detailContent(@RequestParam("num") int num) {

		PronoticeDTO dto = service.detailContent(num);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("pronotice/ProdetailContent");
		modelAndView.addObject("detailContent", dto);

		return modelAndView;
	}

	// 글 수정 폼 -> 글의 내용을 value에 넣어주기 위해서 선언
	@RequestMapping("/ProupdateContentForm.do")
	public ModelAndView updateContentForm(@RequestParam("num") int num, HttpSession session) {

		PronoticeDTO dto = service.updateContentInfo(num);

		// int nowId = (int)session.getAttribute("nowId");

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("pronotice/ProupdateContentForm");
		modelAndView.addObject("detailContent", dto);
		// modelAndView.addObject("nowId", nowId);

		return modelAndView;
	}

	// 글 수정
	@RequestMapping(value = "/ProupdateContent.do", method = RequestMethod.POST)
	public String updateContent(PronoticeDTO dto, HttpServletResponse response) {
		service.updateContent(dto);

		return "redirect:PronoticeboardMain.do";
	}

	// 글 삭제
	@RequestMapping("/ProdeleteContent.do")
	public String deleteContent(@RequestParam("num") int num, HttpServletResponse response) {

		service.deleteContent(num);

		return "redirect:PronoticeboardMain.do";
	}

}
