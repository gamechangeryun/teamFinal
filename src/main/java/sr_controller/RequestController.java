package sr_controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;
import sr_model.requestDTO;
import sr_service.RequestService;

@Controller
public class RequestController {

	@Autowired
	RequestService rservice;
	
	public void setRservice(RequestService rservice) {
		this.rservice = rservice;
	}

	//신청자 등록
	@RequestMapping(value="/mtmt/addRequest.do", method=RequestMethod.POST, produces="text/plain; charset=UTF-8")
	@ResponseBody
	public String addRequest(@ModelAttribute("requestDTO")requestDTO requestDTO, HttpServletRequest request, HttpServletResponse resp)throws Exception{
		resp.setContentType("text/html; charset=UTF-8");
		
		// HttpSession session = request.getSession();
	    // LoginVO loginVO = (LoginVO)session.getAttribute("loginVO");
		
		
		try {
			System.out.println("신청자 등록:"+ requestDTO);
			rservice.requestInsert(requestDTO);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "success";
	}
	
	//신청자 불러오기
	@RequestMapping(value="/mtmt/requestList.do")
	@ResponseBody
	public String requestList(requestDTO requestDTO, HttpServletRequest request, HttpServletResponse resp)throws Exception{
		resp.setContentType("text/html; charset=UTF-8");
		
		int n = requestDTO.getNum();
		
		List<requestDTO> res = rservice.requestAll(n);
		
		System.out.println("신청자 불러오기:" + res);
		
		JSONObject jso = new JSONObject();
		jso.put("data", res);
		
		return jso.toString();
	}
	
	//신청자취소 - 삭제
	@RequestMapping(value="/mtmt/requestDelete.do")
	@ResponseBody
	private String reqeustDelete(@RequestParam("id")int id)throws Exception{
		try {
			
			System.out.println("신청자 취소:"+ id);
			rservice.requestDelete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "success";
	}
}
