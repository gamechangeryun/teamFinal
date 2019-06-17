package sr.pro.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sr.pro.model.ProDTO;
import sr.pro.service.ProService;

@Controller
public class ProController {

	@Autowired
	ProService service;

	public void setService(ProService service) {
		this.service = service;
	}
	
	//교수 메인페이지
	@RequestMapping("/pro/promain.do")
	public String proMain(@RequestParam("lecture_num")int lecture_num, Model model, HttpSession session) throws Exception{
		System.out.println("메인페이지 체크");
		
		int id = (int)session.getAttribute("nowId");
		String returnPage = (String)session.getAttribute("mainPage");
		int position = (int)session.getAttribute("position");
		
		ProDTO proDto = service.allList(lecture_num);
		String picture = service.picture(id);
		picture = picture.substring(138);
		System.out.println(position);
		
		model.addAttribute("proInfo", proDto);
		model.addAttribute("picture", picture);
		model.addAttribute("returnPage", returnPage);
		model.addAttribute("lecture_num", lecture_num);
		model.addAttribute("position", position);
		
		return "professor/promain";
	}
	
	
}
