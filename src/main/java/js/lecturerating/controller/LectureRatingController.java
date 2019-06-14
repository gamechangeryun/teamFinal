package js.lecturerating.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import js.lectureapply.model.LectureApplyDTO;
import js.lecturerating.model.LectureRatingDTO;
import js.lecturerating.service.LectureRatingService;

@Controller
public class LectureRatingController {
	
	@Autowired
	private LectureRatingService service;

	public void setService(LectureRatingService service) {
		this.service = service;
	}
	
	@RequestMapping("/lectureRating.do")
	public String lectureRating(HttpSession session, Model model) {
		
		String returnPage = (String)session.getAttribute("mainPage");	// 현재 로그인중인 아이디에서 뒤로 가기를 눌렀을 떄 알맞은 메인페이지로 이동하기 위해서
		
		model.addAttribute("returnPage", returnPage);
		
		// 아이디를 자르기 위해서 문자형으로 변환 후 잘라서 학생과 교수를 분리
		int id = (int)session.getAttribute("nowId");
		String nowId = Integer.toString(id);
		nowId = nowId.substring(6,7);
		int position = Integer.parseInt(nowId);
		
		List<LectureApplyDTO> lectureList = service.getLectureList(id);	// 과목 리스트 가져오기
		model.addAttribute("LectureList", lectureList);
		
		if(position == 0) {
			// 학생이 교수강의평가
			//session.setAttribute("mainPage", "studentPage.do");
			return "/lectureRating/studentLectureRating";
		}
		else if(position == 1) {
			// 교수가 학생이 한 강의평가 확인
			//session.setAttribute("mainPage", "professorPage.do");
			return "/lectureRating/professorLectureRating";
		}
		
		return "redirect:"+returnPage;
	}
	
	@RequestMapping(value="/insertLectureRating.do", method=RequestMethod.POST)
	public String insertLectureRating(@RequestParam("q1")int q1, @RequestParam("q2")int q2,
									@RequestParam("q3")int q3, @RequestParam("q4")int q4,
									@RequestParam("q5")int q5, @RequestParam("q6")int q6,
									@RequestParam("q7")int q7, @RequestParam("q8")int q8,
									@RequestParam("q9")int q9, @RequestParam("q10")int q10,
									@RequestParam("totalcomment")String totalcomment, 
									@RequestParam("selectLecture") int lecture_num,
									HttpSession session){
		
		int totalscore = q1 + q2 + q3 + q4 + q5 + q6 + q7 + q8 + q9 + q10;	// 교수들의 평가점수
		
		int id = (int)session.getAttribute("nowId");
		String returnPage = (String)session.getAttribute("mainPage");
		
		service.insertLectureRating(lecture_num, id, totalcomment, totalscore);
		
		return "redirect:"+returnPage;
	}
	
	// 과목선택하기
	@RequestMapping("/selectLecture.do")
	public String selectLecture(@RequestParam("selectLecture") int lecture_num, Model model,
								HttpSession session) {
		
		int id = (int)session.getAttribute("nowId");
		String returnPage = (String)session.getAttribute("mainPage");
		List<LectureApplyDTO> lectureList = service.getLectureList(id);	// 과목 리스트 가져오기
		
		model.addAttribute("returnPage", returnPage);
		model.addAttribute("LectureList", lectureList);
		
		// 선택된 과목의 강의평가 총합평점 가져오기
		int average = service.getLectureRatingScore(lecture_num);
		// 선택된 과목의 강의평가 코멘트들 가져오기
		List<LectureRatingDTO> dto = service.getLectureRatingComment(lecture_num);
		
		model.addAttribute("average", average);
		model.addAttribute("comment", dto);
		
		return "/lectureRating/professorLectureRating";
	}
	
	
}
