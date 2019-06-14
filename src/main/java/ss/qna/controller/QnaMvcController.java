package ss.qna.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ss.qna.model.Comment_file;
import ss.qna.model.Qna_bd;
import ss.qna.model.Qna_comment;
import ss.qna.model.Qna_file;
import ss.qna.service.QnaService;

@Controller
public class QnaMvcController {

	@Autowired
	private QnaService service;

	public void setBoardService(QnaService service) {
		this.service = service;
	}

	private static Random random = new Random();

	// 리스트 출력
	@RequestMapping(value = "/qna/list.do")
	public ModelAndView mainList(@RequestParam(value = "options", defaultValue = "0") int options,
			@RequestParam(value = "searchContent", defaultValue = " ") String searchContent,
			@RequestParam(value = "pageNum", defaultValue = "1") String pageNum) {
		
		int pageSize = 5;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;
		int count = service.count();
		int cmcount = service.cmcount();

		List<Qna_bd> list = service.selectList(startRow, endRow);
		List<Qna_bd> searchList = service.getSearchList(options, searchContent);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("qnaBoard/list");
		mav.addObject("mainList", list);
		mav.addObject("searchList", searchList);
		
		mav.addObject("count", count);
		mav.addObject("cmcount", cmcount);
		mav.addObject("currentPage", currentPage);
		mav.addObject("pageSize", pageSize);

		return mav;
	}

	// 세부 글보기
	@RequestMapping("/qna/detail.do")
	public ModelAndView detailBoard(@RequestParam("num") int num,
			@RequestParam(value = "pageNum", defaultValue = "1") String pageNum) {
		Qna_bd list = service.selectOne(num);
		String name = service.getFileName(num);

		service.readcountup(num);

		int pageSize = 5;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;
		int count = service.cmcount();

		List<Qna_comment> list1 = service.cmselectList(startRow, endRow, num);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("qnaBoard/detailList");
		mav.addObject("cmList", list1);
		System.out.println("list1::" + list1);
		mav.addObject("cmcount", count);
		mav.addObject("currentPage", currentPage);
		mav.addObject("pageSize", pageSize);
		mav.addObject("list", list);
		mav.addObject("name", name);

		return mav;
	}

	// 파일다운로드
	@RequestMapping("/qna/Download.do")
	public ModelAndView download(@RequestParam("num") int num) throws Exception {

		String path = service.FileDownload(num);
		File downloadFile = getFile(path);

		return new ModelAndView("download", "downloadFile", downloadFile);
	}

	private File getFile(String path) {

		return new File(path);
	}

	// 글 작성 폼
	@RequestMapping(value = "/qna/writeForm.do")
	public String insertBoardForm(HttpSession session, Model model) {
		int id = (int)session.getAttribute("nowId");
		model.addAttribute("id", id);
		return "qnaBoard/writeForm";
	}

	// 글 작성
	@RequestMapping(value = "/qna/writePro.do", method = RequestMethod.POST)
	public String writePro(Qna_bd board, @RequestParam("file") MultipartFile file, HttpServletResponse response) {
		
		service.insertBoard(board);
		writeprintInfo(file, board.getNum());
		return "redirect:list.do";
	}

	// 파일 업로드
	private void writeprintInfo(MultipartFile file, int num) {
		System.out.println(num + "가 업로드한 파일:" + file.getOriginalFilename());
		long now = System.currentTimeMillis();

		File file_1 = new File("C:\\Users\\jinse\\Desktop\\진성\\프로그래밍 언어\\HTML - 이젠컴퓨터아카데미\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\FinalProject\\qnaBoard\\" + (now + "_" + random.nextInt(100) + "_") + file.getOriginalFilename());
		try {
			file.transferTo(file_1);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalStateException e2) {
			e2.printStackTrace();
		}

		Qna_file fileup = new Qna_file();
		fileup.setRealname(file.getOriginalFilename());
		fileup.setRealpath(file_1.getPath());
		fileup.setRealsize(String.valueOf(file.getSize()));
		service.Fileupload(fileup);
	}

	// 글 수정폼
	@RequestMapping("/qna/updateForm.do")
	public ModelAndView updateBoardForm(@RequestParam("num") int num) {

		Qna_bd list = service.selectOne(num);

		return new ModelAndView("qnaBoard/updateForm", "list", list);
	}

	// 글 수정
	@RequestMapping(value = "/qna/updatePro.do", method = RequestMethod.POST)
	public String updatePro(Qna_bd board, @RequestParam("file") MultipartFile file) {

		service.updateBoard(board);
		updateprintInfo(file, board.getNum());

		return "redirect:list.do";
	}

	// 수정 파일 업로드
	private void updateprintInfo(MultipartFile file, int num) {
		System.out.println(num + "가 업로드한 파일:" + file.getOriginalFilename());
		long now = System.currentTimeMillis();

		File file_1 = new File("C:\\Users\\jinse\\Desktop\\진성\\프로그래밍 언어\\HTML - 이젠컴퓨터아카데미\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\FinalProject\\qnaBoard\\" + (now + "_" + random.nextInt(100) + "_") + file.getOriginalFilename());
		try {
			file.transferTo(file_1);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalStateException e2) {
			e2.printStackTrace();
		}

		Qna_file fileup = new Qna_file();
		fileup.setRealname(file.getOriginalFilename());
		fileup.setRealpath(file_1.getPath());
		fileup.setRealsize(String.valueOf(file.getSize()));
		service.updateFileupload(fileup);
	}

	// 글삭제 확인
	@RequestMapping("/qna/deletePro.do")
	public String deletePro(@RequestParam("num") int num, @RequestParam("comment_num") int comment_num) {

		service.deleteBoard(num, comment_num);

		return "redirect:list.do";
	}

	// 답변 댓글 작성
	@RequestMapping(value = "/qna/cminsert.do", method = RequestMethod.POST)
	public ModelAndView replyBoardPro(Qna_comment cm, @RequestParam("file") MultipartFile file,
			@RequestParam("num") int num, @RequestParam(value = "pageNum", defaultValue = "1") String pageNum) {

		service.cminsert(cm);
		cmuploadprintInfo(file, cm.getNum());

		Qna_bd list = service.selectOne(num);
		String name = service.getFileName(num);

		int pageSize = 5;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;
		int count = service.cmcount();

		List<Qna_comment> list1 = service.cmselectList(startRow, endRow, num);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("qnaBoard/detailList");
		mav.addObject("cmList", list1);
		System.out.println("list1::" + list1);
		mav.addObject("cmcount", count);
		mav.addObject("currentPage", currentPage);
		mav.addObject("pageSize", pageSize);
		mav.addObject("list", list);
		mav.addObject("name", name);

		return mav;
	}

	// 댓글 파일 업로드
	private void cmuploadprintInfo(MultipartFile file, int num) {
		System.out.println(num + "가 업로드한 파일:" + file.getOriginalFilename());
		long now = System.currentTimeMillis();

		File file_1 = new File("C:\\Users\\jinse\\Desktop\\진성\\프로그래밍 언어\\HTML - 이젠컴퓨터아카데미\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\FinalProject\\qnaBoard\\" + (now + "_" + random.nextInt(100) + "_") + file.getOriginalFilename());
		try {
			file.transferTo(file_1);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalStateException e2) {
			e2.printStackTrace();
		}

		Comment_file fileup = new Comment_file();
		fileup.setRealname(file.getOriginalFilename());
		fileup.setRealpath(file_1.getPath());
		fileup.setRealsize(String.valueOf(file.getSize()));
		service.cmFileupload(fileup);
	}

	// 댓글 수정 폼
	@RequestMapping("/qna/cmupdate.do")
	public ModelAndView cmupdate(int comment_num) {
		System.out.println("comment_num::" + comment_num);
		Qna_comment list = service.cmselectOne(comment_num);
		
		System.out.println("name::" + list.getComment_num());
		System.out.println("name::" + list.getNum());
		System.out.println("name::" + list.getName());
		System.out.println("name::" + list.getContent());

		ModelAndView mav = new ModelAndView();
		mav.setViewName("qnaBoard/cmupdateForm");
		mav.addObject("cmlist", list);
		System.out.println("name::" + list.getComment_num());
		System.out.println("name::" + list.getNum());
		System.out.println("name::" + list.getName());
		System.out.println("name::" + list.getContent());
		return mav;
	}

	// 댓글 수정
	@RequestMapping("/qna/cmupdatePro.do")
	public ModelAndView cmupdatePro(Qna_comment qf, @RequestParam("comment_num") int comment_num,
			@RequestParam("num") int num, @RequestParam(value = "pageNum", defaultValue = "1") String pageNum,
			@RequestParam("file") MultipartFile file) throws Exception {

		service.cmupdate(qf);
		cmupdateprintInfo(file, comment_num);

		Qna_bd list = service.selectOne(num);
		String name = service.getFileName(num);

		int pageSize = 5;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;
		int count = service.cmcount();

		List<Qna_comment> list1 = service.cmselectList(startRow, endRow, num);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("qnaBoard/detailList");
		mav.addObject("cmList", list1);
		System.out.println("list1::" + list1);
		mav.addObject("cmcount", count);
		mav.addObject("currentPage", currentPage);
		mav.addObject("pageSize", pageSize);
		mav.addObject("list", list);
		mav.addObject("name", name);

		return mav;
	}

	// 댓글 수정 업로드
	private void cmupdateprintInfo(MultipartFile file, int comment_num) {
		long now = System.currentTimeMillis();

		File file_1 = new File("C:\\Users\\jinse\\Desktop\\진성\\프로그래밍 언어\\HTML - 이젠컴퓨터아카데미\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\FinalProject\\qnaBoard\\" + (now + "_" + random.nextInt(100) + "_") + file.getOriginalFilename());
		try {
			file.transferTo(file_1);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalStateException e2) {
			e2.printStackTrace();
		}

		Comment_file fileup = new Comment_file();
		fileup.setRealname(file.getOriginalFilename());
		fileup.setRealpath(file_1.getPath());
		fileup.setRealsize(String.valueOf(file.getSize()));
		service.cmupdateFileupload(fileup);
	}

	// 댓글 삭제
	@RequestMapping("/qna/cmdelete.do")
	public ModelAndView cmdelete(HttpServletResponse resp, int comment_num, int num,
			@RequestParam(value = "pageNum", defaultValue = "1") String pageNum) throws Exception {
		service.cmdelete(comment_num);
		System.out.println("/detail.do요청 실행");
		Qna_bd list = service.selectOne(num);
		String name = service.getFileName(num);

		int pageSize = 5;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;
		int count = service.cmcount();

		List<Qna_comment> list1 = service.cmselectList(startRow, endRow, num);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("qnaBoard/detailList");
		mav.addObject("cmList", list1);
		System.out.println("list1::" + list1);
		mav.addObject("cmcount", count);
		mav.addObject("currentPage", currentPage);
		mav.addObject("pageSize", pageSize);
		mav.addObject("list", list);
		mav.addObject("name", name);

		return mav;
	}

}
