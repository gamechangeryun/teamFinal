package wj.anonbd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import wj.anonbd.model.AnonCommentDto;
import wj.anonbd.model.AnonContentDto;
import wj.anonbd.service.AnonService;

@Controller
public class AnonController {
	@Autowired
	private AnonService service;

	public void setService(AnonService service) {
		this.service = service;
	}

	@RequestMapping("/anon/list.do")
	public ModelAndView list(@RequestParam(value="page", defaultValue="1") int page) {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("anonbd/mainForm");

		List<AnonContentDto> allList = service.showList();

		List<AnonContentDto> list = service.showPageList(page);
		mav.addObject("contents", list);

		int pageSize = 5;
		mav.addObject("pageSize", pageSize);
		int totalPage = ((allList.size() - 1) / pageSize) + 1;
		mav.addObject("totalPage", totalPage);

		return mav;
	}

	@RequestMapping(value = "/anon/searchList.do")
	public ModelAndView searchList(@RequestParam(value = "options", defaultValue = "0") int i,
			@RequestParam(value = "searchString", defaultValue = " ") String searchStr,
			@RequestParam(value = "page", defaultValue = "1") int page) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("anonbd/mainForm");

		mav.addObject("searchString", searchStr);
		mav.addObject("options", i);

		List<AnonContentDto> allList = service.showSearchList(i, searchStr);

		List<AnonContentDto> list = service.showSearchList(i, searchStr, page);

		mav.addObject("contents", list);

		int pageSize = 5;
		mav.addObject("pageSize", pageSize);
		int totalPage = ((allList.size() - 1) / pageSize) + 1;
		mav.addObject("totalPage", totalPage);

		return mav;
	}

	@RequestMapping(value = "/anon/showContent.do", method = RequestMethod.GET)
	public ModelAndView showContent(@RequestParam("num") int num) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("anonbd/contentForm");

		AnonContentDto content = service.getContent(num);
		mav.addObject("content", content);

		List<AnonCommentDto> comments = service.showCommentList(num);
		mav.addObject("comments", comments);

		return mav;
	}

	@RequestMapping(value = "/anon/modifyContent.do", method = RequestMethod.GET)
	public ModelAndView modifyContent(@RequestParam("num") int num) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("anonbd/modifyForm");

		AnonContentDto content = service.getContent(num);
		mav.addObject("content", content);

		return mav;
	}

	@RequestMapping(value = "/anon/modifyContent.do", method = RequestMethod.POST)
	public String updateContent(AnonContentDto content) throws Exception {
		service.modifyContent(content);
		return "redirect:/anon/list.do?page=1";
	}

	@RequestMapping(value = "/anon/deleteComment.do", method = RequestMethod.GET)
	public String deleteConmment(@RequestParam("num") int num, @RequestParam("comment_num") int comment_num) {
		service.deleteComment(comment_num);
		return "redirect:/anon/showContent.do?num=" + num;
	}

	@RequestMapping(value = "/anon/deleteContent.do", method = RequestMethod.POST)
	public String deleteContent(AnonContentDto content) throws Exception {
		System.out.println(content);
		service.deleteContent(content);
		return "redirect:/anon/list.do?page=1";
	}

	@RequestMapping("/anon/write.do")
	public String write() throws Exception {
		return "/anonbd/writeForm";
	}

	@RequestMapping(value = "/anon/insertComment.do")
	public String insertComment(@RequestParam("num") int num, AnonCommentDto comment) throws Exception {
		System.out.println(comment);
		service.addComment(comment);
		return "redirect:/anon/showContent.do?num=" + num;
	}

	@RequestMapping(value = "/anon/insertContent.do")
	public String insertContent(AnonContentDto content) throws Exception {
		service.insertContent(content);
		return "redirect:/anon/list.do?page=1";
	}
}
