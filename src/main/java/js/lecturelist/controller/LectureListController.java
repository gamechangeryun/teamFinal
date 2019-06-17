package js.lecturelist.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import js.lecturelist.model.LectureListDTO;
import js.lecturelist.service.LectureListService;

@Controller
public class LectureListController {
	
	@Autowired
	private LectureListService service;

	public void setService(LectureListService service) {
		this.service = service;
	}
	
	@RequestMapping("/lectureList.do")
	public String lectureList(HttpSession session, Model model) {
		
		int id = (int)session.getAttribute("nowId");
		String returnPage = (String)session.getAttribute("mainPage");
		
		List<LectureListDTO> list = service.getLectureList(id);
		
		model.addAttribute("lectureList", list);
		model.addAttribute("returnPage", returnPage);
		
		return "lecturelist/lecturelist";
	}
	
	
	
	
}
