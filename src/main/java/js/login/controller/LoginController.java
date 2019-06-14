package js.login.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import js.login.model.PersonDTO;
import js.login.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService service;

	public void setService(LoginService service) {
		this.service = service;
	}
	
	// 처음 시작이 들어왔을 떄 페이지
	@RequestMapping("/start.do")
	public String mainLogin() {
		return "login/loginForm";
	}
	
	// 로그인을 눌렀을 때
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(@RequestParam("id") int id, @RequestParam("password") String password, 
						HttpSession session, Model model) {
		
		int check = -1;
		check = service.login(id, password);
		session.setAttribute("nowId", id);
		
		if(check == 1) {
			// 로그인 성공 했을 때 -> 기능을 사용 할 수 있는 페이지로 이동
			String nowId = Integer.toString(id);
			nowId = nowId.substring(6,7);
			
			int position = Integer.parseInt(nowId);
			session.setAttribute("position", position);
			
			if(position == 0) {
				// 학생메인페이지
				session.setAttribute("mainPage", "studentPage.do");
				return "redirect:studentPage.do";
			}
			else if(position == 1) {
				// 교수메인페이지
				session.setAttribute("mainPage", "professorPage.do");
				return "redirect:professorPage.do";
			}
			else if(position == 2) {
				// 교직원메인페이지
				session.setAttribute("mainPage", "facultyPage.do");
				return "redirect:facultyPage.do";
			}
			else if(position == 3){
				// 게스트메인페이지
				session.setAttribute("mainPage", "guestPage.do");
				return "redirect:guestPage.do";
			}

		}else if(check == 0) {
			// 비밀번호가 틀렸을 때
			model.addAttribute("confirm", 1);
		}else if(check == -1) {
			// 아이디가 틀렸을 때
			model.addAttribute("confirm", 2);
		}
		
		return "login/loginForm";
	}
	
	// 로그아웃을 눌렀을 때
	@RequestMapping("/logout.do")
	public String logout(HttpSession session, HttpServletResponse response) {
		
		session.invalidate();
		
		return "redirect:start.do";
	}

	// 비밀번호 변경
	@RequestMapping("/changePasswordForm.do")
	public String changePasswordForm(Model model, HttpSession session) {
		
		String returnPage = (String)session.getAttribute("mainPage");
		model.addAttribute("mainPage", returnPage);
		
		return "login/changePasswordForm";
	}
	
	// 비밀번호 변경
	@RequestMapping("/changePassword.do")
	public String changePassword(@RequestParam("nowPassword") String nowPassword, 
								@RequestParam("newPassword") String newPassword, 
								HttpSession session, HttpServletResponse response, Model model) {
		
		int nowId = (int)session.getAttribute("nowId");
		String dbPassword = service.dbPassword(nowId);
		String returnPage = (String)session.getAttribute("mainPage");
		model.addAttribute("mainPage", returnPage);
		
		if(dbPassword.equals(nowPassword)) {
			// 새로운 비밀번호를 입력
			int check = service.changePassword(nowId, newPassword);
			
			if(check > 0) {      
				// 비밀번호 변경 성공 jsp
				session.invalidate();// 세션지우기 -> 다시로그인해야하니까
				return "redirect:start.do";
			}
			else {
				// 비밀번호 변경 실패 jsp
				return "login/changePasswordFalse";
			}
		}
		
		// 비밀번호 틀림 jsp로
		return "login/notPassword";
	}
	
	// 상세정보 변경 폼 - 상세정보 불러오기
	@RequestMapping("/changeDetailForm.do")
	public ModelAndView changeDetailForm(HttpSession session) {
		
		int id = (int)session.getAttribute("nowId");
		String returnPage = (String)session.getAttribute("mainPage");
		
		PersonDTO dto = service.getDetail(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login/changeDetailForm");
		mav.addObject("detail", dto);
		mav.addObject("mainPage", returnPage);
		
		return mav;
	}
	
	// 회원정보 변경 
	@RequestMapping("/changeDetail.do")
	public String changeDetail(PersonDTO dto, HttpSession session, HttpServletResponse response, Model model) {
		
		int id = (int)session.getAttribute("nowId");
		dto.setId(id);
		String returnPage = (String)session.getAttribute("mainPage");
		model.addAttribute("mainPage", returnPage);
		
		int check = service.changeDetail(dto);
		
		if(check > 0) {
			return "redirect:"+returnPage;
		}
		
		return "login/changeDetailFalse";
	}
	
	// 아이디 찾기 폼
	@RequestMapping("/searchIdForm.do")
	public String searchIdForm() {
		return "/login/searchIdForm";
	}
	
	// 아이디 찾기
	@RequestMapping(value="/searchId.do", method=RequestMethod.POST)
	public ModelAndView searchId(@RequestParam("name") String name, @RequestParam("email") String email) {
		
		int id = service.searchId(name, email);
		
		return new ModelAndView("/login/searchIdResult", "id", id);
	}
	
	// 아이디 찾기 폼
	@RequestMapping("/searchPwForm.do")
	public String searchPwForm() {
		return "/login/searchPwForm";
	}
		
	// 아이디 찾기
	@RequestMapping(value="/searchPw.do", method=RequestMethod.POST)
	public ModelAndView searchPw(@RequestParam("id") int id, @RequestParam("email") String email) {
			
		String password = service.searchPw(id, email);
			
		return new ModelAndView("/login/searchPwResult", "password", password);
	}

}
