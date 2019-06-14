package js.reinapplysubmit.controller;

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

import js.reinapplysubmit.model.ReinApplySubmitDTO;
import js.reinapplysubmit.service.ReinApplySubmitService;

@Controller
public class ReinApplySubmitController {
	@Autowired
	private ReinApplySubmitService service;

	public void setService(ReinApplySubmitService service) {
		this.service = service;
	}
	
	// 학생이 복학신청을 했을 때
	@RequestMapping("/reinApplyForm.do")
	public String reinApplyForm(HttpSession session, Model model) {
		
		int id = (int)session.getAttribute("nowId");
		String returnPage = (String)session.getAttribute("mainPage");
		
		model.addAttribute("returnPage", returnPage);
		
		int check1 = service.checkLeaveStudent(id);	// 휴학생 테이블에 있는지 확인
		int check2 = service.checkReinApplyList(id);	// 이미 복학신청한 학생인지 확인
		
		if(check1 > 0) {
			if(check2 == 0) {
				// 휴학생 테이블에 없고 복학신청하지 않은 상태일 때
				return "reinapplysubmit/reinApply";
			}
			else if(check2 > 0) {
				// 이미 복학신청한 상태일 때
				model.addAttribute("confirm", 1);
			}
		}
		else if(check1 == 0){
			// 휴학생 테이블에 없을 때
			model.addAttribute("confirm", 2);
		}
		
		return "reinapplysubmit/reinApply";
	}
	
	// 복학신청
	@RequestMapping("/reinApply.do")
	public String reinApply(@RequestParam("startreindate") Date startreindate, HttpSession session) {
		
		int id = (int)session.getAttribute("nowId");
		String returnPage = (String)session.getAttribute("mainPage");
		
		service.insertReinApply(id, startreindate);
		
		return "redirect:"+returnPage;
	}
	
	// 복학신청 리스트 가져오기
	@RequestMapping("/reinApplyList.do")
	public String reinApplyList(@RequestParam(value="options", defaultValue="0") int options, 
								@RequestParam(value="searchContent", defaultValue= " ") String searchContent,
								@RequestParam(value="pageNum", defaultValue="1" ) String pageNum,
								HttpSession session, Model model) {
		
		int pageSize = 5;		// 한페이지당 보여줄 글의 수
		int currentPage = Integer.parseInt(pageNum);	// 현재 페이지 
		int startRow = (currentPage - 1) * pageSize + 1;	// 시작번호
		int endRow = currentPage * pageSize;	// 끝 번호
		
		int count = 0;
		String returnPage = (String)session.getAttribute("mainPage");
		
		List<ReinApplySubmitDTO> mainList = new ArrayList<ReinApplySubmitDTO>();
		List<ReinApplySubmitDTO> searchList = new ArrayList<ReinApplySubmitDTO>();
		
		if(searchContent.equals(" ")) {
			mainList = service.getReinApplyList(startRow, endRow);	// 페이지에 맞는 리스트 가져오기
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
		
		return "reinapplysubmit/reinApplyList";
	}
	
	// 복학허용
	@RequestMapping("reinSubmit.do")
	public String reinSubmit(@RequestParam("id") int id) {
		service.reinSubmit(id);
		return "redirect:reinApplyList.do";
	}
	
	// 복학기각
	@RequestMapping("reinRefus.do")
	public String reinRefus(@RequestParam("id") int id) {
		service.reinRefus(id);
		return "redirect:reinApplyList.do";
	}
	
	
	
	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
