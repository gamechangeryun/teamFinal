package sr.tuition.controller;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;
import sr.tuition.model.JoinDTO;
import sr.tuition.model.TemperDTO;
import sr.tuition.model.TuitionDTO;
import sr.tuition.service.TuitionService;

@Controller
public class TuitionController {

	@Autowired
	private TuitionService tuitionservice;
	
	public void setTuitionservice(TuitionService tuitionservice) {
		this.tuitionservice = tuitionservice;
	}

	//메인페이지
	@RequestMapping(value = "/tuition/main.do")
	public String tu_main() throws Exception{
		return "tuition/tu_main";
	}
	
	//학과리스트
	@RequestMapping(value = "/tuition/temperList.do", method = RequestMethod.GET)
	public void sidoList(HttpServletResponse resp)throws Exception{	
		List<TemperDTO> list = tuitionservice.allList();
		System.out.println("학과리스트:"+list);
		
		JSONObject jso = new JSONObject();
		jso.put("data", list);
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();	//Writer - 스트림 -> 2바이트씩 
		out.print(jso.toString());
	}
	
	//조회버튼
	@RequestMapping(value="/tuition/temperCheck.do", produces="application/json; charset=utf8")
	@ResponseBody
	public String commentList(@RequestParam("temper_name") String t_name,@RequestParam("inputmoney") String n, HttpServletRequest request, HttpServletResponse resp)throws Exception{
		resp.setContentType("text/html; charset=UTF-8");
		
		System.out.println("학과 이름:"+t_name);
		System.out.println("납부미납조회:" + n);
		
		JoinDTO jdto = new JoinDTO();
		jdto.setTemper_name(t_name);
		jdto.setInputmoney(n);
		
        List<TuitionDTO> list = tuitionservice.inputList(jdto);
        
        System.out.println("납부자조회리스트 :" + list);

        //json date 형식을 표현하기 위한 string 변환
		DateFormat sdFormat = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		ArrayList<String> ary = new ArrayList<String>();
		for(int i=0; i<list.size(); i++) {
			Date nowDate = new Date();
			nowDate = list.get(i).getInputdate();
			String tempDate = sdFormat.format(nowDate);
			ary.add(tempDate);
		}
		
        //json객체로 넘겨준다.
        JSONObject jso = new JSONObject();
        jso.put("date", ary);
        jso.put("data", list);
        
        return jso.toString();
	
	}

}
