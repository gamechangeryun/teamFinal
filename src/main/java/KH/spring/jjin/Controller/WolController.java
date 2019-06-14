package KH.spring.jjin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import KH.spring.jjin.DTO.WolDTO;
import KH.spring.jjin.Service.WolService;

@Controller
public class WolController {

	@Autowired
	WolService wolService;

	public void setWolService(WolService wolService) {
		this.wolService = wolService;
	}

	@RequestMapping("/wol/list.do")
	public String List(Model model) {
		List<WolDTO> listv = wolService.List();

		model.addAttribute("list1", listv);
		return "wol/wol_list1";
	}    

	@RequestMapping("/wol/write.do")
	public String write() {
		return "wol/wol_write";
	}

	@RequestMapping("/wol/view.do")
	public String view(@RequestParam String id, Model model) {
		model.addAttribute("dto", wolService.view(id));
		return "wol/wol_view";
	}

	@RequestMapping("/wol/update.do")
	public String update(@ModelAttribute WolDTO dto, Model model) {
		System.out.println(dto);
		wolService.update(dto);

		return "redirect:/wol/list.do";
	}


}