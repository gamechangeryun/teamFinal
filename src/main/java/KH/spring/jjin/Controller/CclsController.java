package KH.spring.jjin.Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import KH.spring.jjin.DTO.CclsDTO;
import KH.spring.jjin.Service.CclsService;

@RequestMapping("/Ccls/*")
@Controller
public class CclsController {
private static final Logger logger=
LoggerFactory.getLogger(CclsController.class);



@Autowired
CclsService cclsService;
@InitBinder
protected void initBinder(WebDataBinder binder) {
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	binder.registerCustomEditor(Date.class, new CustomDateEditor(
			dateFormat, true));
}
@RequestMapping("list.do")
public String List(Model model) {

		
	List<CclsDTO> listv=cclsService.CclsList();
	logger.info("회원목록:"+listv);
	model.addAttribute("list1",listv);
	return "Ccls/ccls_list";
}
 
@RequestMapping("write.do") 
public String write() {
	return "Ccls/ccls_write";
}

@RequestMapping("insert.do")
public String insert(CclsDTO dto,Model model) {
	
	System.out.println("fdsfsadafdaffa"+dto);
	cclsService.insertCcls(dto);
	return "redirect:/Ccls/list.do"; //목록갱신
}

@RequestMapping("view.do")
public String view(@RequestParam int id, Model model) {
model.addAttribute("dto",cclsService.viewCcls(id));
return "Ccls/ccls_view";
} 

	
	  @RequestMapping("update.do") 
	  public String update(@ModelAttribute  CclsDTO dto,Model model) {
	 	  cclsService.updateCcls(dto);
	  return"redirect:/Ccls/list.do"; 
}
	  
	  @RequestMapping("delete.do")
public String delete(@RequestParam int id,Model model) { 
	  cclsService.deleteCcls(id); 
	  return "redirect:/Ccls/list.do"; 
	 

	  }

}