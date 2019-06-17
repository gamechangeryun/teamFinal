package js.guestPage.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import KH.spring.jjin.DTO.BoardDTO;
import js.guestPage.service.GuestPageService;
import js.noticeboard.model.NoticeBoardDTO;
import mi.job.board.model.DTO;
import sr_model.bdDTO;
import wj.anonbd.model.AnonContentDto;

@Controller
public class GuestPageController {

	@Autowired
	private GuestPageService service;

	public void setService(GuestPageService service) {
		this.service = service;
	}
	
	@RequestMapping("/guestPage.do")
	public ModelAndView guestPage(@ModelAttribute("getNoticeBoard") List<NoticeBoardDTO> noticeBoard,
								@ModelAttribute("getJobBoard") List<DTO> jobBoard,
								@ModelAttribute("getMtmtBoard") List<DTO> mtmtBoard,
								@ModelAttribute("getFreeBoard") List<DTO> freeBoard,
								@ModelAttribute("getAnonBoard") List<DTO> anonBoard,
								HttpSession session) {
		
		int position = 3;
		String returnPage = (String)session.getAttribute("mainPage");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("guestPage");
		mav.addObject("noticeBoard", noticeBoard);
		mav.addObject("jobBoard", jobBoard);
		mav.addObject("mtmtBoard", mtmtBoard);
		mav.addObject("freeBoard", freeBoard);
		mav.addObject("anonBoard", anonBoard);
		mav.addObject("position", position);
		mav.addObject("returnPage", returnPage);
		
		return mav;
	}
	
	// 공지사항 게시판 리스트 가져오기
	@ModelAttribute("getNoticeBoard")
	public List<NoticeBoardDTO> noticeBoard() {

		List<NoticeBoardDTO> list = service.getNoticeBoard();

		return list;
	}

	// 취업 게시판 리스트 가져오기
	@ModelAttribute("getJobBoard")
	public List<DTO> jobBoard() {

		List<DTO> list = service.getJobBoard();

		return list;
	}
	
	// 취업 게시판 리스트 가져오기
	@ModelAttribute("getMtmtBoard")
	public List<bdDTO> mtmtBoard() {

		List<bdDTO> list = service.getMtmtBoard();

		return list;
	}
	
	// 자유게시판 리스트 가져오기
	@ModelAttribute("getFreeBoard")
	public List<BoardDTO> freeBoard() {

		List<BoardDTO> list = service.getFreeBoard();

		return list;
	}
	
	// 대나무숲게시판 리스트 가져오기
	@ModelAttribute("getAnonBoard")
	public List<AnonContentDto> anonBoard() {

		List<AnonContentDto> list = service.getAnonBoard();

		return list;
	}
	
	
	
	
	
	
}
