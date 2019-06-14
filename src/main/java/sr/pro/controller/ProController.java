package sr.pro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String proMain() throws Exception{
		System.out.println("메인페이지 체크");
		return "professor/promain";
	}
	
	
}
