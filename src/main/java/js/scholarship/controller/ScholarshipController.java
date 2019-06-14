package js.scholarship.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import js.scholarship.model.ScholarshipDTO;
import js.scholarship.service.ScholarshipService;

@Controller
public class ScholarshipController {

	@Autowired
	private ScholarshipService serivce;

	public void setSerivce(ScholarshipService serivce) {
		this.serivce = serivce;
	}
	
	@RequestMapping("/scholarship.do")
	public ModelAndView scholarshipGet(@RequestParam(value="pageNum", defaultValue="1" ) String pageNum, 
										HttpSession session) {
		
		int pageSize = 5;		// 한페이지당 보여줄 글의 수
		int currentPage = Integer.parseInt(pageNum);	// 현재 페이지 
		int startRow = (currentPage - 1) * pageSize + 1;	// 시작번호
		int endRow = currentPage * pageSize;	// 끝 번호
		int count = serivce.count();	// 전체 글의 개수
		int check = 1;	// 학과선택안했을 때
		
		String returnPage = (String)session.getAttribute("mainPage");
		
		List<ScholarshipDTO> list = serivce.getScholarship(startRow, endRow);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("scholarship/scholarship");
		mav.addObject("scholarship", list);
		mav.addObject("returnPage", returnPage);
		
		mav.addObject("check", check);
		mav.addObject("pageSize", pageSize);
		mav.addObject("count", count);//
		mav.addObject("currentPage", currentPage);
		
		return mav;
	}
	
	@RequestMapping("/scholarshipSelect.do")
	public ModelAndView scholarshipPost(@RequestParam(value="temper", defaultValue="1") int temper, 
										@RequestParam(value="pageNum", defaultValue="1" ) String pageNum, 
										HttpServletResponse response) {
		
		int pageSize = 5;		// 한페이지당 보여줄 글의 수
		int currentPage = Integer.parseInt(pageNum);	// 현재 페이지 
		int startRow = (currentPage - 1) * pageSize + 1;	// 시작번호
		int endRow = currentPage * pageSize;	// 끝 번호
		int count = serivce.count();	// 전체 글의 개수
		int check = 2;	// 학과선택했을 때
		
		ModelAndView mav = new ModelAndView();
		
		if(temper == 0) {
			mav.setViewName("redirect:scholarship.do");
			return mav;
		}
		
		List<ScholarshipDTO> list = serivce.getScholarshipSelect(temper, startRow, endRow);

		mav.setViewName("scholarship/scholarship");
		mav.addObject("scholarship", list);
		
		mav.addObject("check", check);
		mav.addObject("pageSize", pageSize);
		mav.addObject("count", count);//
		mav.addObject("currentPage", currentPage);
		
		return mav;
	}
	
	
	
	
}
