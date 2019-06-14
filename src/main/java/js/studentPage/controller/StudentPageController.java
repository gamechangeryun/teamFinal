package js.studentPage.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import js.noticeboard.model.NoticeBoardDTO;
import js.scholarship.model.ScholarshipDTO;
import js.studentPage.model.PrivacyDTO;
import js.studentPage.service.StudentService;

@Controller
public class StudentPageController {
	
	@Autowired
	private StudentService service;

	public void setService(StudentService service) {
		this.service = service;
	}
	
	@RequestMapping("/studentPage")
	public ModelAndView studentPageForm(@ModelAttribute("getPicture") String picture,
										@ModelAttribute("getPrivacy") PrivacyDTO privacyDto,
										@ModelAttribute("getNoticeBoard") List<NoticeBoardDTO> noticeBoard,
										@ModelAttribute("getScholarship") List<ScholarshipDTO> scholarshipDto) {
		
		int position = 0;
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("studentPage");
		mav.addObject("picture", picture);
		mav.addObject("privacy", privacyDto);
		mav.addObject("scholarship", scholarshipDto);
		mav.addObject("noticeBoard", noticeBoard);
		mav.addObject("position", position);
		
		return mav;
	}
	
	// 학생 개인사진 가져오기
	@ModelAttribute("getPicture")
	public String getPicture(HttpSession session) {

		int nowId = (int) session.getAttribute("nowId"); // 현재 로그인 중인 아이디

		String picture= service.getPicture(nowId); // 사진의 경로와 실제 이름 가져오기
		picture = picture.substring(138);

		return picture;
	}
		
	// 학생 개인정보 가져오기
	@ModelAttribute("getPrivacy")
	public PrivacyDTO privacy(HttpSession session){
		
		int nowId = (int)session.getAttribute("nowId");	// 현재 로그인 중인 아이디
		
		PrivacyDTO dto = service.getPrivacy(nowId);	// 개인정보 가져오기
		
		return dto;
	}
	
	// 장학금 내역 가져오기
	@ModelAttribute("getScholarship")
	public List<ScholarshipDTO> scholarship(HttpSession session) {
		
		int nowId = (int)session.getAttribute("nowId");
		List<ScholarshipDTO> list = service.getScholarship(nowId);
		
		return list;
	}
	
	// 공지사항 게시판 리스트 가져오기
	@ModelAttribute("getNoticeBoard")
	public List<NoticeBoardDTO> noticeBoard(){
		
		List<NoticeBoardDTO> list = service.getNoticeBoard();
		
		return list;
	}
	
}
