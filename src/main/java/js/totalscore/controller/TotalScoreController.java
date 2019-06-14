package js.totalscore.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import js.semesterscore.model.SemesterScoreDTO;
import js.totalscore.model.TotalScoreDTO;
import js.totalscore.service.TotalScoreService;

@Controller
public class TotalScoreController {

	@Autowired
	private TotalScoreService service;

	public void setService(TotalScoreService service) {
		this.service = service;
	}
	
	// 총 학기 성적을 눌렀을 때 총학기 성적테이블에 값 입력
	@RequestMapping("/totalScore.do")
	public String totalScore(HttpSession session) {
		
		int id = (int)session.getAttribute("nowId");	// 현재 로그인중인 아이디
		
		int countSemester =  service.countSemester(id);	// 전체학기 평점을 구해오기 위해서 학기 개수 구해오기
		
		List<SemesterScoreDTO> getSemesterInfo = service.getSemesterInfo(id);	// 학기별성적테이블에서 이수학점들과 학기평점을 들고오기
		
		int nowPoint = 0;	// 현재까지 이수학점 합
		int score = 0;		// 모든 평점 합
		for(int i=0; i<getSemesterInfo.size(); i++) {
			nowPoint += getSemesterInfo.get(i).getSemesterpoint();
			score += getSemesterInfo.get(i).getSemesteraverage();
		}
		
		System.out.println("이수학점 :: " + nowPoint);
		System.out.println("모든평점 합 :: " + score);
		
		int totalAverage = score / countSemester;	// 전체학기평점
		
		// 총학기 성적에 입력 될 데이터
		TotalScoreDTO dto = new TotalScoreDTO();
		dto.setId(id);
		dto.setTotalaverage(totalAverage);
		dto.setMaxpoint(140);
		dto.setNowpoint(nowPoint);
		
		System.out.println(dto);
		
		// 총학기 성적 테이블에 현재 아이디로 정보가 저장되어 있는지 확인
		int check = service.getTotalScoreInfo(id);
		
		if(check == 0) {
			// 총학기 성적 테이블에 입력
			service.insertTotalScore(dto);
		}else {
			// 총학기 성적 테이블 수정
			service.updateTotalScore(dto);
		}
		
		return "redirect:totalScoreView.do";
	}
	
	@RequestMapping("/totalScoreView.do")
	public String totalScoreView(HttpSession session, Model model) {
		
		int id = (int)session.getAttribute("nowId");
		String returnPage = (String)session.getAttribute("mainPage");
		
		TotalScoreDTO dto = service.getTotalScore(id);
		
		model.addAttribute("dto", dto);
		model.addAttribute("returnPage", returnPage);
		
		return "totalScore/totalScore";
	}
	
	
}
