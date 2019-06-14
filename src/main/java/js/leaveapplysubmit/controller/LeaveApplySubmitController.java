package js.leaveapplysubmit.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import js.leaveapplysubmit.model.LeaveApplySubmitDTO;
import js.leaveapplysubmit.service.LeaveApplySubmitService;

@Controller
public class LeaveApplySubmitController {
	
	@Autowired
	private LeaveApplySubmitService service;

	public void setService(LeaveApplySubmitService service) {
		this.service = service;
	}
	
	// 학생이 휴학신청을 할 떄 
	@RequestMapping("/leaveApplyForm.do")
	public String leaveApplyForm(HttpSession session, Model model) {
		
		int id = (int)session.getAttribute("nowId");
		String returnPage = (String)session.getAttribute("mainPage");
		
		model.addAttribute("nowId", id);
		model.addAttribute("returnPage", returnPage);
		
		int check1 = service.checkLeaveStudent(id);	// 휴학생 테이블에 있는지 확인
		int check2 = service.checkLeaveApply(id);	// 휴학신청서 확인
		
		if(check1 == 0) {
			if(check2 == 0) {
				// 휴학생이 아니고, 휴학신청서를 작성하지 않았다면
				return "leaveapplysubmit/leaveApply";
			}
			else if(check2 > 0){
				// 휴학신청서가 접수 상태라면
				model.addAttribute("confirm", 1);
			}
		}
		else if(check1 > 0) {
			// 이미 휴학생이라면
			model.addAttribute("confirm", 2);
		}
		
		return "leaveapplysubmit/leaveApply";
	}
	
	// 휴학신청서 DB에 저장
	@RequestMapping("/leaveApply.do")
	public String leaveApply(LeaveApplySubmitDTO dto, HttpSession session) {
		
		String returnPage = (String)session.getAttribute("mainPage");
		
		service.insertLeaveApply(dto);
		
		return "redirect:"+returnPage;
	}
	
	///////////////////////////////////////////////////////////////////////
	// 교직원이 휴학신청자 확인
	@RequestMapping("/leaveApplySubmit.do")
	public String leaveApplySubmit(@RequestParam(value="options", defaultValue="0") int options, 
									@RequestParam(value="searchContent", defaultValue= " ") String searchContent,
									@RequestParam(value="pageNum", defaultValue="1" ) String pageNum,
									HttpSession session, Model model) {
		
		int pageSize = 5;		// 한페이지당 보여줄 글의 수
		int currentPage = Integer.parseInt(pageNum);	// 현재 페이지 
		int startRow = (currentPage - 1) * pageSize + 1;	// 시작번호
		int endRow = currentPage * pageSize;	// 끝 번호
		
		int count = 0;
		String returnPage = (String)session.getAttribute("mainPage");
		
		List<LeaveApplySubmitDTO> mainList = new ArrayList<LeaveApplySubmitDTO>();
		List<LeaveApplySubmitDTO> searchList = new ArrayList<LeaveApplySubmitDTO>();
		
		if(searchContent.equals(" ")) {
			mainList = service.getLeaveApplyList(startRow, endRow);	// 페이지에 맞는 리스트 가져오기
			count = service.count();	// 전체 글의 개수
		}
		else {
			searchList = service.getSearchList(options, searchContent, startRow, endRow);	// 서치값 가져오기
			count = service.searchCount(options, searchContent);	// 서치된 글의 개수
		}
		
		model.addAttribute("mainList", mainList);
		model.addAttribute("searchList", searchList);
		model.addAttribute("options", options);
		model.addAttribute("searchContent", searchContent);
		model.addAttribute("returnPage", returnPage);
		
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("count", count);
		model.addAttribute("currentPage", currentPage);
		
		return "leaveapplysubmit/leaveapplylist";
	}
	
	// 휴학신청 승인
	@RequestMapping("/leaveSubmit.do")
	public String leaveSubmit(LeaveApplySubmitDTO dto) {
		
		service.insertLeaveStudent(dto);
		
		return "redirect:leaveApplySubmit.do";
	}
	
	// 휴학신청 기각
	@RequestMapping("/leaveRefus.do")
	public String leaveRefus(@RequestParam("id") int id) {
		
		service.deleteLeaveApply(id);
		
		return "redirect:leaveApplySubmit.do";
	}
	
	// 휴학생 확인
	@RequestMapping("/leaveStudent.do")
	public String leaveStudent(@RequestParam(value="options", defaultValue="0") int options, 
								@RequestParam(value="searchContent", defaultValue= " ") String searchContent,
								@RequestParam(value="pageNum", defaultValue="1" ) String pageNum,
								HttpSession session, Model model) {
		
		int pageSize = 5;		// 한페이지당 보여줄 글의 수
		int currentPage = Integer.parseInt(pageNum);	// 현재 페이지 
		int startRow = (currentPage - 1) * pageSize + 1;	// 시작번호
		int endRow = currentPage * pageSize;	// 끝 번호
		
		int count = 0;
		String returnPage = (String)session.getAttribute("mainPage");
		
		List<LeaveApplySubmitDTO> mainList = new ArrayList<LeaveApplySubmitDTO>();
		List<LeaveApplySubmitDTO> searchList = new ArrayList<LeaveApplySubmitDTO>();
		
		if(searchContent.equals(" ")) {
			mainList = service.getLeaveStudentList(startRow, endRow);	// 페이지에 맞는 리스트 가져오기
			count = service.LeaveStudentCount();	// 전체 글의 개수
		}
		else {
			searchList = service.getLeaveStudentSearchList(options, searchContent, startRow, endRow);	// 서치값 가져오기
			count = service.LeaveStudentSearchCount(options, searchContent);	// 서치된 글의 개수
		}
		
		model.addAttribute("mainList", mainList);
		model.addAttribute("searchList", searchList);
		model.addAttribute("options", options);
		model.addAttribute("searchContent", searchContent);
		model.addAttribute("returnPage", returnPage);
		
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("count", count);
		model.addAttribute("currentPage", currentPage);
		
		
		return "leaveapplysubmit/leaveStudent";
	}
	
	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
}
