package sr.changescoreinput.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sr.changescoreinput.model.ChangescoreinputDTO;
import sr.changescoreinput.service.ChangescoreinputService;
import sr.scoreinput.model.ScoreinputDTO;

@Controller
public class ChangescoreinputController {
	
	@Autowired
	private ChangescoreinputService service;

	public void setService(ChangescoreinputService service) {
		this.service = service;
	}
	
	//메인화면 - 성적정정신청확인
	@RequestMapping("/changescore/ChangescoreinputMain.do")
	public ModelAndView changescoreinputMain()throws Exception{
		System.out.println("성적정정진입확인");
		List<ChangescoreinputDTO> list = service.allList();
		System.out.println("메인화면 list" + list);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("changescore/ChangescoreinputMain");
		mav.addObject("mainList", list);
		return mav;
	}
	
	////// 학생이 정정 신청을 할 때
	//학생사유 입력폼
	@RequestMapping("/changescore/ChangescoreinputInsert.do")
	public String changescoreinputInsert(HttpSession session, Model model, @RequestParam("lecture_num")int lecture_num)throws Exception{
		System.out.println("성적정정입력 진입확인");
		System.out.println(lecture_num);
		
		int id = (int)session.getAttribute("nowId");
		String returnPage = (String)session.getAttribute("mainPage");
		
		ChangescoreinputDTO dto = service.personInfo(id, lecture_num);
		int confirm = service.checkChangeScore(id, lecture_num);
		System.out.println("confirm :: " + confirm);
		model.addAttribute("dto", dto);
		model.addAttribute("returnPage", returnPage);
		model.addAttribute("confirm", confirm);
		
		return "changescore/ChangescoreinputInsert";
	}
	
	//학생사유 DB입력
	@RequestMapping("/ChangescoreinputInsertPro.do")
	public String changescoreinputInsertPro(ChangescoreinputDTO dto)throws Exception{
		System.out.println("성적디비 입력");
		service.reasonInsert(dto);
		return "redirect:semesterScore.do";
	}
	
	//기각
	@RequestMapping(value="/changescore/ChangescoreinputDelete.do", method=RequestMethod.GET)
	public String changeDelete(ChangescoreinputDTO dto)throws Exception{
		System.out.println("기각진입확인");
		service.changeDelete(dto);
		
		return "redirect:ChangescoreinputMain.do";
	}
	
	//성적수정 - 다른테이블
	@RequestMapping("/changescore/ChangescoreinputUpdate.do")
	@ResponseBody
	public String scoreUpdate(ScoreinputDTO dto)throws Exception{
		System.out.println("성적수정진입확인");
		System.out.println("성적수정체크::"+dto);
		service.scoreUpdate(dto);
		return "success";
	}
	
}
