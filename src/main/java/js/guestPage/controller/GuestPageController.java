package js.guestPage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import js.guestPage.service.GuestPageService;

@Controller
public class GuestPageController {

	@Autowired
	private GuestPageService service;

	public void setService(GuestPageService service) {
		this.service = service;
	}
	
	@RequestMapping("/guestPage.do")
	public String guestPage() {
		return "guestPage";
	}
	
	
	
	
	
}
