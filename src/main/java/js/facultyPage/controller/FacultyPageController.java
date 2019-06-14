package js.facultyPage.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import KH.spring.jjin.DTO.WolDTO;
import js.facultyPage.service.FacultyPageService;
import js.noticeboard.model.NoticeBoardDTO;
import js.studentPage.model.PrivacyDTO;

@Controller
public class FacultyPageController {

	@Autowired
	FacultyPageService service;

	public void setService(FacultyPageService service) {
		this.service = service;
	}

	@RequestMapping("/facultyPage")
	public ModelAndView facultyPageForm(@ModelAttribute("getPrivacy") PrivacyDTO privacyDto,
										@ModelAttribute("getNoticeBoard") List<NoticeBoardDTO> noticeBoard,
										@ModelAttribute("getMonthPay") List<WolDTO> getMonthPay) {
		
		int position = 2;
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("facultyPage");
		mav.addObject("privacy", privacyDto);
		mav.addObject("noticeBoard", noticeBoard);
		mav.addObject("monthpay", getMonthPay);
		
		mav.addObject("position", position);
		
		return mav;
	}
	
	// 교직원 개인정보 가져오기
	@ModelAttribute("getPrivacy")
	public PrivacyDTO privacy(HttpSession session){
		
		int nowId = (int)session.getAttribute("nowId");
		PrivacyDTO dto = service.getPrivacy(nowId);
		
		return dto;
	}
	
	// 공지사항 게시판 리스트 가져오기
	@ModelAttribute("getNoticeBoard")
	public List<NoticeBoardDTO> noticeBoard(){
			
		List<NoticeBoardDTO> list = service.getNoticeBoard();
			
		return list;
	}
	
	// 교직원 월급 가져오기
	@ModelAttribute("getMonthPay")
	public List<WolDTO> getMonthPay(HttpSession session) {

		int id = (int) session.getAttribute("nowId");

		List<WolDTO> list = service.getMonthPay(id);

		return list;
	}
	
	
	
	
	
}
