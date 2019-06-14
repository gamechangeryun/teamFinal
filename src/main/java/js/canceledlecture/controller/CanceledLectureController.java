package js.canceledlecture.controller;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import js.canceledlecture.model.CanceledLectureDTO;
import js.canceledlecture.service.CanceledLectureService;
import js.lectureapply.model.LectureApplyDTO;

@Controller
public class CanceledLectureController {

	@Autowired
	private CanceledLectureService service;

	public void setService(CanceledLectureService service) {
		this.service = service;
	}
	
	// 휴강신청서 작성
	@RequestMapping("/canceledlectureForm.do")
	public String canceledlectureForm(HttpSession session, Model model) {
		int id = (int)session.getAttribute("nowId");
		String returnPage = (String)session.getAttribute("mainPage");
		
		List<LectureApplyDTO> lectureList = service.getLectureList(id); 	// 해당 아이디의 강의리스트 가져오기
		
		model.addAttribute("id", id);
		model.addAttribute("returnPage", returnPage);
		model.addAttribute("lectureList", lectureList);
		
		return "canceledlecture/canceledLectureForm";
	}
	
	// 휴강신청서 제출
	@RequestMapping(value="/canceledlecture.do", method=RequestMethod.POST)
	public String canceledlecture(CanceledLectureDTO dto, HttpSession session) {
		
		String returnPage = (String)session.getAttribute("mainPage");
		
		service.insertCanceledLecture(dto);
		
		return "redirect:"+returnPage;
	}
	
	// 교직원이 보기 위해서 휴강신청서 리스트 가져오기
	@RequestMapping("/canceledList.do")
	public String canceledList(@RequestParam(value="options", defaultValue="0") int options, 
								@RequestParam(value="searchContent", defaultValue= " ") String searchContent,
								@RequestParam(value="pageNum", defaultValue="1" ) String pageNum,
								HttpSession session, Model model) {
		
		int pageSize = 5;		// 한페이지당 보여줄 글의 수
		int currentPage = Integer.parseInt(pageNum);	// 현재 페이지 
		int startRow = (currentPage - 1) * pageSize + 1;	// 시작번호
		int endRow = currentPage * pageSize;	// 끝 번호
		
		int count = 0;
		String returnPage = (String)session.getAttribute("mainPage");
		
		List<CanceledLectureDTO> mainList = new ArrayList<CanceledLectureDTO>();
		List<CanceledLectureDTO> searchList = new ArrayList<CanceledLectureDTO>();
		
		if(searchContent.equals(" ")) {
			mainList = service.getCanceledList(startRow, endRow);	// 페이지에 맞는 리스트 가져오기
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
		
		return "canceledlecture/canceledLectureList";
	}
	
	// 휴강허용
	@RequestMapping("/canceledlistSubmit.do")
	public String canceledlistSubmit(CanceledLectureDTO dto){
		
		service.insertCanceledList(dto);// 휴강 리스트에 추가하기
		
		return "redirect:canceledList.do";
	}
	
	// 휴강기각
	@RequestMapping("/canceledListRefus.do")
	public String canceledListRefus(@RequestParam("id") int id) {
		
		service.deleteCanceleListSupply(id);
		
		return "redirect:canceledList.do";
	}

	// 교수가 휴강리스트 확인
	@RequestMapping("/submitCanceledList.do")
	public String submitCanceledList(HttpSession session, Model model) {
		
		int id = (int)session.getAttribute("nowId");
		String returnPage = (String)session.getAttribute("mainPage");
		
		List<CanceledLectureDTO> list = service.getSubmitCanceledList(id);
		int count = list.size();
		
		model.addAttribute("count", count);
		model.addAttribute("CanceledList", list);
		model.addAttribute("returnPage", returnPage);
		
		return "canceledlecture/submitCanceledList";
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
}
