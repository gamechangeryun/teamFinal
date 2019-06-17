package mi.gra.board.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mi.gra.board.model.graDTO;
import mi.gra.board.service.graService;

@Controller
public class GraController {

	@Autowired
	graService service;
	
	public void setService(graService service) {
		this.service = service;
	}
	
	// 글 보기
	@RequestMapping("/gra/graboard.do")
	public ModelAndView mainPage(@RequestParam(value = "options", defaultValue = "0") int options,
			@RequestParam(value = "searchContent", defaultValue = " ") String searchContent,
			@RequestParam(value = "pageNum", defaultValue = "1") String pageNum, HttpSession session) {

		int pageSize = 10; // 한페이지당 보여줄 글의 수
		int currentPage = Integer.parseInt(pageNum); // 현재 페이지
		int startRow = (currentPage - 1) * pageSize + 1; // 시작번호
		int endRow = currentPage * pageSize; // 끝 번호
		int nowId = (int) session.getAttribute("nowId");
		String returnPage = (String) session.getAttribute("mainPage");
		int count = 0; // 전체 글의 개수
		// int number = count-(currentPage - 1) * 10; // 글 목록에 표시할 글 번호

		List<graDTO> maingra = new ArrayList<graDTO>(); // 리스트 전부 가져오기
		List<graDTO> searchList = new ArrayList<graDTO>(); // 서치값 가져오기

		if (searchContent.equals(" ")) {
			maingra = service.getList(startRow, endRow);
			count = service.count();
		} else {
			searchList = service.getSearchList(options, searchContent, startRow, endRow);
			count = service.searchCount(options, searchContent);
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("gra/gra_Main");
		mav.addObject("mainList", maingra);
		mav.addObject("searchList", searchList);
		mav.addObject("nowId", nowId);
		mav.addObject("returnPage", returnPage);
		mav.addObject("options", options);
		mav.addObject("searchContent", searchContent);

		mav.addObject("pageSize", pageSize);
		mav.addObject("count", count);
		mav.addObject("currentPage", currentPage);
		return mav;
	}
	
}
