package sr.learn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sr.learn.model.LearnDTO;
import sr.learn.service.LearnService;

@Controller
public class LearnController {

	@Autowired
	LearnService service;

	public void setService(LearnService service) {
		this.service = service;
	}
	
	//처음시작페이지
	@RequestMapping("/learn/LearnMain.do")
	public ModelAndView learnMain(@RequestParam("lecture_num") int lecture_num)throws Exception{
		
		ModelAndView mav = new ModelAndView();
		
		List<LearnDTO> list = service.allList(lecture_num);
		
		System.out.println("list ::" + list);
		
		mav.setViewName("learn/LearnMain");
		mav.addObject("mainList", list);
		mav.addObject("lecture_num", lecture_num);
		
		return mav;
	}
	
	//카드하나 삭제
	@RequestMapping("/learn/learnDelete.do")
	public String delete(LearnDTO dto)throws Exception{
		
		System.out.println("삭제 dto :: " + dto);
		
		service.delete(dto);
		
		return "redirect:LearnMain.do?lecture_num="+Integer.valueOf(dto.getLecture_num());
	}
	
	//현재단계추가
	@RequestMapping(value="/learn/addNow.do")
	@ResponseBody
	public String addNow(LearnDTO dto,HttpServletRequest request, HttpServletResponse resp)throws Exception{
		resp.setContentType("text/html; charset=UTF-8");
		
		System.out.println("단계추가 ::"+dto);
		
		service.addNow(dto);
		
		return "success";
	}
	
	//단계감소
	@RequestMapping(value="/learn/deleteNow.do")
	@ResponseBody
	public String deleteNow(LearnDTO dto,HttpServletRequest request, HttpServletResponse resp)throws Exception{
		resp.setContentType("text/html; charset=UTF-8");
		System.out.println("단계감소 ::"+dto);
		
		service.disNow(dto);
		
		return "success";
	}
	
	//내용입력폼
	@RequestMapping("/learn/LearnInsertForm.do")
	public String insertForm(@RequestParam("lecture_num") int lecture_num, Model model) {
		
		model.addAttribute("lecture_num", lecture_num);
		
		return "learn/learnInsertForm";
	}
	
	//내용입력
	@RequestMapping(value = "learn/LearnInsert.do")
	public String learnInsert(@ModelAttribute("LearnDTO")LearnDTO dto)throws Exception{
		
		System.out.println("내용입력: " +dto);
		
		service.learnInsert(dto);
		
		return "redirect:LearnMain.do?lecture_num="+Integer.valueOf(dto.getLecture_num());
		
	}
	
}
