package js.professorPage.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import KH.spring.jjin.DTO.WolDTO;
import js.noticeboard.model.NoticeBoardDTO;
import js.professorPage.service.ProfessorPageService;
import js.studentPage.model.PrivacyDTO;
import mi.job.board.model.DTO;

@Controller
public class ProfessorPageController {

	@Autowired
	private ProfessorPageService service;

	public void setService(ProfessorPageService service) {
		this.service = service;
	}
	
	@RequestMapping("/professorPage")
	public ModelAndView professorPage(@ModelAttribute("getPicture") String picture,
										@ModelAttribute("getPrivacy") PrivacyDTO privacyDto,
										@ModelAttribute("getNoticeBoard") List<NoticeBoardDTO> noticeBoard,
										@ModelAttribute("getJobBoard") List<DTO> jobBoard,
										@ModelAttribute("getMonthPay") List<WolDTO> getMonthPay,
										HttpSession session) {
		
		int position = 1;
		String returnPage = (String)session.getAttribute("mainPage");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("professorPage");
		mav.addObject("picture", picture);
		mav.addObject("privacy", privacyDto);
		mav.addObject("noticeBoard", noticeBoard);
		mav.addObject("jobBoard", jobBoard);
		mav.addObject("monthpay", getMonthPay);
		mav.addObject("position", position);
		mav.addObject("returnPage", returnPage);
		
		return mav;
	}
	
	// 교수 개인사진 가져오기
	@ModelAttribute("getPicture")
	public String getPicture(HttpSession session) {

		int nowId = (int) session.getAttribute("nowId"); // 현재 로그인 중인 아이디

		String picture = service.getPicture(nowId); // 사진의 경로와 실제 이름 가져오기
		picture = picture.substring(138);

		return picture;
	}
		
	// 교수 개인정보 가져오기
	@ModelAttribute("getPrivacy")
	public PrivacyDTO privacy(HttpSession session) {

		int nowId = (int) session.getAttribute("nowId");
		PrivacyDTO dto = service.getPrivacy(nowId);
		
		return dto;
	}
	
	// 공지사항 게시판 리스트 가져오기
	@ModelAttribute("getNoticeBoard")
	public List<NoticeBoardDTO> noticeBoard() {

		List<NoticeBoardDTO> list = service.getNoticeBoard();

		return list;
	}
	
	// 교수 월급 가져오기
	@ModelAttribute("getMonthPay")
	public List<WolDTO> getMonthPay(HttpSession session){
		
		int id = (int)session.getAttribute("nowId");
		
		List<WolDTO> list = service.getMonthPay(id);
		
		return list;
	}
	
	// 공지사항 게시판 리스트 가져오기
	@ModelAttribute("getJobBoard")
	public List<DTO> jobBoard() {

		List<DTO> list = service.getJobBoard();

		return list;
	}
	
	
}
