package KH.spring.jjin.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import KH.spring.jjin.DTO.BoardDTO;
import KH.spring.jjin.Pager.Pager;
import KH.spring.jjin.Service.BoardService;



@Controller("wolboard")
@RequestMapping("/board/*")
public class BoardController {
@Autowired
BoardService boardService;

@RequestMapping("write.do")
public String write() {
	return "board/write";
} 

	/*
	 * @RequestMapping("view.do") public ModelAndView read(@RequestParam int bno,
	 * HttpSession session) throws Exception {
	 * boardService.increaseViewcnt(bno,session); ModelAndView mav = new
	 * ModelAndView(); mav.setViewName("board/view"); //�������� ���� �̸�
	 * mav.addObject("dto",boardService.read(bno)); //�ڷ� ���� return mav;
	 * //view/board/view.jsp �� �Ѿ�� ��µ� }
	 */

@RequestMapping("view.do")
public ModelAndView read(@RequestParam int bno) throws Exception{
	BoardDTO dto = boardService.read(bno);
	ModelAndView mav = new ModelAndView(); 
	mav.setViewName("board/view");
	mav.addObject("dto",boardService.read(bno));
	
	return mav;
	
}

@RequestMapping("insert.do")
public String insert(BoardDTO dto,HttpSession session) throws Exception{
	//�α����� ������� ���̵�
	String writer=(String)session.getAttribute("userid");
	dto.setWriter(writer);
	//���ڵ尡 �����
	boardService.create(dto);
	return "redirect:/board/list.do";
}
@RequestMapping("update.do")
public String update(@ModelAttribute  BoardDTO dto,Model model) throws Exception{
	boardService.update(dto);
	return "redirect:/board/list.do";
}
@RequestMapping("delete.do")
public String delete(@RequestParam int bno,Model model) throws Exception {
	boardService.delete(bno);
	return "redirect:/board/list.do";
}


@RequestMapping("sweet.do")
public String sweet(BoardDTO dto) throws Exception{
	boardService.increaseSweet(dto); 
	return "redirect:/board/list.do";
}

@RequestMapping("getAttach/bno")
@ResponseBody
public List<String> getAttach(@PathVariable("bno") int bno){
	return boardService.getAttach(bno);
} 

@RequestMapping("list.do")
public ModelAndView list(@RequestParam(defaultValue="1")int curPage) throws Exception{
	int count = boardService.countArticle();
	Pager pager=new Pager(count,curPage);
	int start = pager.getPageBegin();
	int end = pager.getPageEnd();
	
	List<BoardDTO> list=boardService.listAll(start,end); //���
	ModelAndView mav=new ModelAndView();
	Map<String,Object> map=new HashMap<>();
	map.put("list",list); 	////�ʿ� �ڷ� ����
	map.put("count",count); 	////�ʿ� �ڷ� ����
	map.put("pager",pager); //������ �׺���̼��� ���� ����
	mav.setViewName("board/list");  //�̵��� ������ ����
	mav.addObject("map",map);	//������ ����
	return mav;	//������ �̵�(���)
	 
	 
}
	
}
