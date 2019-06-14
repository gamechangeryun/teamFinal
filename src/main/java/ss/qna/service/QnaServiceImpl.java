package ss.qna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ss.qna.model.Comment_file;
import ss.qna.model.QnaDao;
import ss.qna.model.Qna_bd;
import ss.qna.model.Qna_comment;
import ss.qna.model.Qna_file;

@Service
public class QnaServiceImpl implements QnaService {

	@Autowired
	private QnaDao dao;

	public void setDao(QnaDao dao) {
		this.dao = dao;
	}

	// 전체 글 목록 가져오기
	public List<Qna_bd> selectList(int startRow, int endRow) {

		List<Qna_bd> list = dao.getList(startRow, endRow);

		return list;
	}
	
	// 서치된 글 목록 가져오기
	public List<Qna_bd> getSearchList(int options, String searchContent) {

		List<Qna_bd> list = dao.getSearchList(options, searchContent);

		return list;
	}
	
	// 전체 글 갯수 가져오기
	public int count() {
		
		int i = dao.count();

		return i;
	}
	
	// 전체 댓글 갯수 가져오기
	public int cmcount() {
		
		int i = dao.cmcount();

		return i;
	}
	
	// 세부 글 보기
	public Qna_bd selectOne(int num) {

		Qna_bd list = dao.getListOne(num);

		return list;
	}

	// 조회수 증가
	public int readcountup(int num) {
		int i = dao.readup(num);
		return i;
	}
	
	// 전체 댓글 목록 가져오기
	public List<Qna_comment> cmselectList(int startRow, int endRow,int num) {

		List<Qna_comment> list = dao.getcmList(startRow, endRow, num);

		return list;
	}
	
	// 다운받을 파일의 이름 가져오기
	public String getFileName(int num) {

		String fileName = dao.getFileName(num);

		return fileName;
	}

	// 다운받을 파일의 경로 가져오기
	public String FileDownload(int num) {

		String filePath = dao.FileDownload(num);

		return filePath;
	}

	// 글 추가
	public int insertBoard(Qna_bd board) {
		int i = dao.insertBoard(board);
		return i;
	}
	
	// 파일업로드
	public int Fileupload(Qna_file qf) {

		int i = dao.Fileupload(qf);

		return i;
	}
	
	// 글 수정
	public int updateBoard(Qna_bd board) {

		int i = dao.updateBoard(board);

		return i;
	}
	
	// 글수정 파일 수정
	public int updateFileupload(Qna_file qf) {
		int i = dao.updateFileupload(qf);

		return i;
	}
	
	// 글 삭제하기
	public void deleteBoard(int num, int comment_num) {

		dao.deleteBoard(num, comment_num);

	}
	
	// 댓글 추가
	public int cminsert(Qna_comment cm) {
		
		int i = dao.cminsert(cm);
		
		return i;
	}

	// 댓글 파일 업로드
	public int cmFileupload(Comment_file cf) {
		
		int i = dao.replyFileupload(cf);

		return i;
	}
	
	// 세부 댓글 보기
	public Qna_comment cmselectOne(int comment_num) {   

		Qna_comment list = dao.cmselectOne(comment_num);

		return list;
	}
	
	// 댓글 수정
	public int cmupdate(Qna_comment qf) {
		
		int i = dao.cmupdate(qf);
		
		return i;
	}
	
	//댓글 파일 수정
	public int cmupdateFileupload(Comment_file qf) {
		
		int i = dao.cmupdateFileupload(qf);

		return i;
	}
	
	// 댓글 삭제
	public void cmdelete(int comment_num) {
		
		dao.cmdelete(comment_num);
		
	}
	
}
