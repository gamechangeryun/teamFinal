package js.semesterscore.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import js.semesterscore.model.SemesterScoreDTO;
import js.semesterscore.service.SemesterScoreService;

@Controller
public class SemesterScoreController {

	@Autowired
	private SemesterScoreService service;

	public void setService(SemesterScoreService service) {
		this.service = service;
	}
	
	// 처음화면에서 select박스의 과목을 선택
	@RequestMapping("/semesterScore.do")
	public String semesterScore(Model model) {
		
		List<String> semesters = service.semesters();	// 학기 찾아오기
	
		model.addAttribute("semesters", semesters);
		
		return "semesterScore/semesterScore";
	}
	
	@RequestMapping("/selectSemester.do")
	public String selectSemester(@RequestParam("selectSemester") String semester, HttpSession session,
								Model model) {
		
		int id = (int)session.getAttribute("nowId");	// 접속중이 아이디 찾아오기
		String returnPage = (String)session.getAttribute("mainPage");	// 돌아갈 메인페이지
		
		List<String> semesters = service.semesters();	// 학기 찾아오기
		List<SemesterScoreDTO> dataList = service.dataList(semester, id);	// 수강리스트에서 강의번호를 뽑아와서 강의리스트에서 조회
		
		List<Integer> lecture_num = new ArrayList<Integer>();
		
		// 강의번호를 따로 뽑아오기 위해서
		for(int i=0; i<dataList.size(); i++) {
			lecture_num.add(dataList.get(i).getLecture_num());
		}
		
		List<Integer> score = service.score(lecture_num, id);	// 강의번호와 id를 보내서 성적 알아오기 
		
		// 성적을 view에서 보여주기 위해서 dateList에 추가
		for(int i=0; i<score.size(); i++) {
			dataList.get(i).setScore(score.get(i));
		}
		
		int semesterPoint = 0;
		// 해당학기 이수학점 저장하기
		for(int i=0; i<dataList.size(); i++) {
			semesterPoint += dataList.get(i).getLecture_grade();
		}
		
		// 평균구하기
		int total = 0;
		for(int i=0; i<score.size(); i++) {
			total += score.get(i);
		}
		
		// db에 저장할때는 int형으로 저장하고 보여줄때는 double형으로 보여주자
		double average = total / score.size();
		
		int check = service.selectSemesterScore(id, semester);	// 학기별 성적에 해당 id와 학기로 저장된 데이터가 없다면
		
		if(check == 0){
			service.semesterscore(id, semester, semesterPoint, (int)average); // 학기별 성적 테이블에 저장하기
		}
		
		model.addAttribute("semesters", semesters);	// 학기
		model.addAttribute("dataList", dataList);	// 학기별 성적 정보
		model.addAttribute("average", average);		// 평균
		model.addAttribute("returnPage", returnPage);
		
		return "semesterScore/semesterScore";
	}
	
}
