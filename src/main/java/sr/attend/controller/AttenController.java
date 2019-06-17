package sr.attend.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONObject;
import sr.attend.model.AttenDTO;
import sr.attend.model.AttenListDTO;
import sr.attend.service.AttenService;

@Controller
public class AttenController {

	@Autowired
	private AttenService service;

	public void setService(AttenService service) {
		this.service = service;
	}
	
	//출석관리 메인화면
	@RequestMapping("/atten/attenMain.do")
	public String attenMain()throws Exception{
		
		return "atten/attenMain";
	}
	
	//출석부입력폼으로 이동
	@RequestMapping("/atten/attenInsertForm.do")
	public String attenInsrtForm()throws Exception{
		return "atten/attenInsertFormAjax";
	}
	
	//출석부입력폼이동
	@RequestMapping("/atten/attenInsertFormAjax.do")
	public void attenInsertFormAjax(@RequestParam("lecture_num") int lecture_num, HttpServletResponse resp)throws Exception{
		
		//강의번호로 조회한 수강생들 목록
		List<AttenDTO> dto = service.studentList(lecture_num);
		System.out.println("입력폼진입확인 및 dto"+dto);
	
		resp.setContentType("text/html; charset=UTF-8");
		
		JSONObject jso = new JSONObject();
		jso.put("data", dto);
		
		PrintWriter out = resp.getWriter();
		out.print(jso.toString());
	}
	
	//출석부 입력폼에서 입력한것 입력처리
	@RequestMapping(value="/atten/attenInsertPro.do", method = RequestMethod.POST)
	@ResponseBody
	public void attenInsert(AttenListDTO attenListDTO)throws Exception{
		
		List<AttenDTO> l = attenListDTO.getAttenListDTO();
		
		for(AttenDTO dto : l) {
			System.out.println("출석부 입력 for문::"+dto);
			service.attenInsert(dto);
		}
	}
	
	//처음 메인화면 시작시 학과조회리스트
	@RequestMapping(value="/atten/attenList.do", method=RequestMethod.POST)
	public void attenList(HttpServletResponse resp, HttpSession session)throws Exception{
		
		int id = (int)session.getAttribute("nowId");
		List<AttenDTO> list = service.allList(id);
		
		resp.setContentType("text/html; charset=UTF-8");
		
		JSONObject jso = new JSONObject();
		jso.put("data", list);
		
		PrintWriter out = resp.getWriter();
		out.print(jso.toString());
	}
	
	//체크한 강의번호에 맞는  id리스트 - 수강생리스트
	@RequestMapping("/atten/attenIDList")
	public void attenIdList(@RequestParam("lecture_num") int lecture_num,@RequestParam("day") String day ,HttpServletResponse resp)throws Exception{
		System.out.println("데이::"+day);
		
		//List<AttenDTO> list = service.idList(lecture_num);
		
		List<AttenDTO> studentList = service.studentList(lecture_num);
		
		resp.setContentType("text/html; charset=UTF-8");
		
		JSONObject jso = new JSONObject();
		jso.put("data", studentList);
		
		PrintWriter out = resp.getWriter();
		out.println(jso.toString());
	}
	
	//교수가 출석 체크 한 것 입력 - DB에 입력
	@RequestMapping(value="/atten/attenCheck.do",method = RequestMethod.POST)
	@ResponseBody
	public void inputScore(HttpServletResponse resp,HttpServletRequest res, AttenListDTO attenlist)throws Exception{
		
		List<AttenDTO> l = attenlist.getAttenListDTO();
		for(AttenDTO dt : l) {
			System.out.println("출석for문::"+dt);
			service.attenCheck(dt);
		}
	}
	
	//출석확인페이지로 이동
	@RequestMapping("/atten/daypage.do")
	public ModelAndView daypage(HttpSession session)throws Exception{
		
		int id = (int)session.getAttribute("nowId");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("id", id);
		mav.setViewName("atten/daycheck");
		return mav;
	}
	
	//학생이 출결 체크확인하기
	@RequestMapping(value="/atten/attendaycheck.do", method=RequestMethod.POST)
	public void daycheck(@RequestParam("id") int id,HttpServletResponse resp, HttpSession session)throws Exception{

		List<AttenDTO> list = service.daycheck(id);
		
		resp.setContentType("text/html; charset=UTF-8");
		
		JSONObject jso = new JSONObject();
		jso.put("data", list);
		
		PrintWriter out = resp.getWriter();
		out.print(jso.toString());
	}
	
}
