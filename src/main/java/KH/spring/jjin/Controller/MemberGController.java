package KH.spring.jjin.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import KH.spring.jjin.DTO.MemberGDTO;
import KH.spring.jjin.Service.MemberGService;


@Controller
public class MemberGController {
private static final Logger logger=
LoggerFactory.getLogger(MemberGController.class);


@Autowired
MemberGService memberService;

@RequestMapping("member/list.do")
public String memberList(Model model) {
	List<MemberGDTO> listv=memberService.memberList();
	logger.info("회원목록:"+listv);
	model.addAttribute("list1",listv);
	return "member/member_list";
}
 
@RequestMapping("member/write.do") 
public String write() {
	return "member/write";
}

@RequestMapping("member/insert.do")
public String insert(@ModelAttribute MemberGDTO dto,Model model) {
	memberService.insertMember(dto);
	return "redirect:/member/list.do"; //목록갱신
}

@RequestMapping("member/view.do")
public String view(@RequestParam String userid,Model model) {
model.addAttribute("dto",memberService.viewMember(userid));
return "member/view";
} 

	
	  @RequestMapping("member/update.do") 
	  public String update(@ModelAttribute  MemberGDTO dto,Model model)
	  { boolean  result=memberService.checkPw(dto.getId());
	  logger.info("비밀번호확인:"+result); 
	  if(result) { memberService.updateMember(dto);
	  return"redirect:/member/list.do"; 
	  }else { 
	MemberGDTO dto2=memberService.viewMember(dto.getId());
	  dto.setSub_date(dto2.getSub_date()); 
	  model.addAttribute("dto",dto);
	  model.addAttribute("message","비밀번호 불일치"); 
	  return "member/view";
	  } 
	  }
	  
	  @RequestMapping("member/delete.do")
public String delete(@RequestParam String userid,Model model) { 
		  boolean  result=memberService.checkPw(userid); 
		  if(result) {
	  memberService.deleteMember(userid); 
	  return "redirect:/member/list.do"; 
	  }else  {
	  model.addAttribute("message","비번불일치" );
	  model.addAttribute("dto",memberService.viewMember(userid));
	  return "member/view"; 
	  }
		  }
	 

 

}