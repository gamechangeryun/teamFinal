package wj.person.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONObject;
import wj.person.model.PersonDto;
import wj.person.model.PictureDto;
import wj.person.model.TemperDto;
import wj.person.service.PersonService;

@Controller
public class PersonController {
	@Autowired
	private PersonService service;

	public void setService(PersonService service) {
		this.service = service;
	}

	@RequestMapping("/person/main.do")
	public ModelAndView showAllPerson(
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "searchOption", defaultValue = "-1") int searchOption,
			@RequestParam(value = "searchString", defaultValue = "") String searchString,
							HttpSession session) {
		
		String returnPage = (String)session.getAttribute("mainPage");
		
		ModelAndView mav = new ModelAndView();

		mav.setViewName("person/mainForm");
		mav.addObject("returnPage", returnPage);
		
		List<PersonDto> AllPersons = null;
		List<PersonDto> persons = null;
		if(searchOption == -1) {
			AllPersons = service.getPersonList();
			persons = service.getPersonList(page);
			mav.addObject("persons", persons);
		} else {
			System.out.println("여기");
			mav.addObject("searchOption", searchOption);
			mav.addObject("searchString", searchString);
			AllPersons = service.getPersonList(searchOption, searchString);
			persons = service.getPersonList(page, searchOption, searchString);
			mav.addObject("persons", persons);
			System.out.println("여기1");
		}
		int pageSize = 5;
		mav.addObject("pageSize", pageSize);
		int totalPage = ((AllPersons.size()-1) / pageSize) + 1;
		mav.addObject("totalPage", totalPage);
		
		return mav;
	}

	@RequestMapping("/person/write.do")
	public String write() throws Exception {
		return "person/writeForm";
	}

	@RequestMapping("/person/insertPerson.do")
	public String insertPerson(
			@RequestParam(value = "options1", defaultValue = "0") int i,
			@RequestParam("file") MultipartFile file,
			@RequestParam("options2") String temper_name,
			PersonDto person,
			HttpServletResponse response) throws Exception {
		int temper_num = service.selectTemper_num(temper_name);
		
		person.setTemper_num(temper_num);
		
		Date from = new Date();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy");
		String year = transFormat.format(from);

		String option = "0";
		String grade = "";
		if (i == 0) {
			// 학생
			option = "0";
			grade = "1학년";
		} else if (i == 1) {
			// 교수
			option = "1";
			grade = "교수";
		} else if (i == 2) {
			option = "2";
			grade = "교직원";
		}

		String id = year + temper_num + option;
		int maxId = service.getMaxId(Integer.parseInt(id));

		if (maxId < 10) {
			id = id + "0" + String.valueOf(maxId);
		} else {
			id = id + String.valueOf(maxId);
		}
		person.setId(Integer.parseInt(id));

		String bir = person.getBirthday();
		person.setPassword(bir);

		person.setGrade(grade);

		service.insertPerson(person);
		
		printInfo(file, Integer.parseInt(id));
		
		return "redirect:/person/main.do";
	}
	
	private void printInfo(MultipartFile file, int id) {
		Date time = new Date();
		File new_f = new File("c:\\Users\\jinse\\Desktop\\진성\\프로그래밍 언어\\HTML - 이젠컴퓨터아카데미\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\FinalProject\\picture\\" +time.getTime()+ file.getOriginalFilename());
		// File new_f = new File("c://FinalProgect//picture//" +time.getTime()+ file.getOriginalFilename());
		try {
			// 실제 경로에 저장을 하는 MultipartFile메서드
			file.transferTo(new_f);
		}catch (IllegalStateException e) {
		}catch (IOException e1) {}
		
		PictureDto dto = new PictureDto();
		dto.setId(id);
		dto.setRealname(file.getOriginalFilename());
		dto.setRealpath(new_f.getPath());
		dto.setRealsize(file.getSize());
		
		service.insertPicture(dto);
	}
	
	@RequestMapping(value="/person/getTemper.do", method=RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String getTemper(HttpServletResponse resp, @RequestParam(value = "options1", defaultValue = "-1") int options1 ) {
		
		resp.setContentType("text/html; charset=UTF-8");
		List<TemperDto> dto = null;
		if (options1 != -1) {
			dto = service.getTemper(options1);
		} else {
			dto = null;
		}
		JSONObject jso = new JSONObject();
		jso.put("data1", dto);
		return jso.toString();
	}

}
