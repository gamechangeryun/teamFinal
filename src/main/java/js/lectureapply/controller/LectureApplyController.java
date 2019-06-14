package js.lectureapply.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import js.lectureapply.model.LectureApplyDTO;
import js.lectureapply.service.LectureApplyService;

@Controller
public class LectureApplyController {

	@Autowired
	private LectureApplyService service;

	public void setService(LectureApplyService service) {
		this.service = service;
	}
	
	@RequestMapping(value="/lectureapply.do", method=RequestMethod.GET)
	public String lectureApplyForm(HttpSession session, Model model) {
		
		int id = (int)session.getAttribute("nowId");
		String returnPage = (String) session.getAttribute("mainPage");
		
		model.addAttribute("nowId", id);
		model.addAttribute("returnPage", returnPage);
		
		return "lectureapply/lectureapplyForm";
	}
	
	@RequestMapping(value="/lectureapply.do", method=RequestMethod.POST)
	public String lectureApply(LectureApplyDTO dto, HttpSession session, HttpServletResponse response) {
		
		String returnPage = (String)session.getAttribute("mainPage");
		
		service.insertLecture(dto);
		
		return "redirect:"+returnPage;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping("/lectureapplyList.do")
	public ModelAndView lectureapplyList(@RequestParam(value = "options", defaultValue = "0") int options,
			@RequestParam(value = "searchContent", defaultValue = " ") String searchContent,
			@RequestParam(value = "pageNum", defaultValue = "1") String pageNum, HttpSession session) {

		int pageSize = 5; // 한페이지당 보여줄 글의 수
		int currentPage = Integer.parseInt(pageNum); // 현재 페이지
		int startRow = (currentPage - 1) * pageSize + 1; // 시작번호 
		int endRow = currentPage * pageSize; // 끝 번호

		int nowId = (int) session.getAttribute("nowId");
		String returnPage = (String) session.getAttribute("mainPage");

		int count = 0;
		List<LectureApplyDTO> mainList = new ArrayList<LectureApplyDTO>();
		List<LectureApplyDTO> searchList = new ArrayList<LectureApplyDTO>();

		if (searchContent.equals(" ")) {
			mainList = service.getList(startRow, endRow); // 페이지에 맞는 리스트 가져오기
			count = service.count(); // 전체 글의 개수
		} else {
			searchList = service.getSearchList(options, searchContent, startRow, endRow); // 서치값 가져오기
			count = service.searchCount(options, searchContent); // 서치된 글의 개수
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("lectureapply/lectureapplyList");
		mav.addObject("mainList", mainList);
		mav.addObject("searchList", searchList);
		mav.addObject("nowId", nowId);
		mav.addObject("returnPage", returnPage);
		mav.addObject("options", options);
		mav.addObject("searchContent", searchContent);

		mav.addObject("pageSize", pageSize);
		mav.addObject("count", count);//
		mav.addObject("currentPage", currentPage);

		return mav;
	}
	//////////////////////////////////////////////////////////////////////////
	@RequestMapping("/lectureapplySubmit.do")
	public String lectureApplySubmit(LectureApplyDTO dto, HttpServletResponse response) {
		
		int lecture_num = service.getLecture_num(dto.getId());	// 학과번호 가져오기
		
		dto.setLecture_num(lecture_num);
		
		// 정보를 해당 교수의 강의 리스트에 저장하기
		int check = service.lectureApplySubmit(dto);
		
		// 만약, 저장이 성공적으로 됬다면 강의신청리스트에서 삭제하기
		if(check > 0) {
			service.lectureApplyRefuse(dto.getId(), dto.getLecture_title());
		}
		
		return "redirect:lectureapplyList.do";
	}
	/////////////////////////////////////////////////////////////////////////////////
	@RequestMapping("/lectureapplyRefus.do")
	public String lectureapplyRefus(@RequestParam("id") int id, @RequestParam("lecture_title") String lecture_title,
									HttpServletResponse response){
		
		service.lectureApplyRefuse(id, lecture_title);
		
		return "redirect:lectureapplyList.do";
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
