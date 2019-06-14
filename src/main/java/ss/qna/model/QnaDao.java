package ss.qna.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class QnaDao extends SqlSessionDaoSupport {

	// 글 목록 가져오기
	public List<Qna_bd> getList(int startRow, int endRow) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);

		List<Qna_bd> list = getSqlSession().selectList("ex.selectAll", map);
		return list;
	}

	// 댓글 목록 가져오기
	public List<Qna_comment> getcmList(int startRow, int endRow, int num) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("num", num);

		List<Qna_comment> list = getSqlSession().selectList("ex.selectcm", map);

		return list;
	}

	// 글 세부내용 가져오기
	public Qna_bd getListOne(int num) {

		Qna_bd list = getSqlSession().selectOne("ex.detailBoard", num);
		System.out.println("list::" + list);
		return list;
	}

	// 조회수 증가
	public int readup(int num) {

		int i = getSqlSession().update("ex.readcountup", num);

		return i;
	}

	// 글 추가하기
	public int insertBoard(Qna_bd board) {
		System.out.println(board);
		int i = getSqlSession().insert("ex.insertBoard", board);
		return i;
	}

	// 댓글 추가하기
	public int insertreplyBoard(Qna_bd board) {
		int i = getSqlSession().insert("ex.replyinsertBoard", board);
		return i;
	}

	// 글 수정
	public int updateBoard(Qna_bd board) {

		int i = getSqlSession().update("ex.updateBoard", board);

		return i;
	}

	// 글 삭제하기
	public void deleteBoard(int num, int comment_num) {
		getSqlSession().delete("ex.deleteFile", num);
		getSqlSession().delete("ex.deleteBoard", num);
		getSqlSession().delete("ex.deletecmfile", comment_num);
		getSqlSession().delete("ex.deletecm", comment_num);
	}

	// 서치된 글 목록 가져오기
	public List<Qna_bd> getSearchList(int options, String searchContent) {

		List<Qna_bd> list = null;

		if (options == 0) {
			if (searchContent != " ") {
				list = getSqlSession().selectList("ex.searchTitle", searchContent);
			}
		} else if (options == 1) {
			if (searchContent != " ") {
				list = getSqlSession().selectList("ex.searchContent", searchContent);
			}

		} else {
			if (searchContent != " ") {
				list = getSqlSession().selectList("ex.searchWriter", searchContent);
			}
		}

		return list;
	}

	// 글의 개수 가져오기
	public int count() {

		int count = getSqlSession().selectOne("ex.count");

		return count;
	}

	// 댓글의 개수 가져오기
	public int cmcount() {

		int count = getSqlSession().selectOne("ex.cmcount");

		return count;
	}

	// 파일업로드
	public int Fileupload(Qna_file qf) {
	
		int i = getSqlSession().insert("ex.insertFile", qf);

		return i;
	}

	// 다운받을 파일의 이름 가져오기
	public String getFileName(int num) {

		String fileName = getSqlSession().selectOne("ex.fileName", num);

		return fileName;
	}

	// 다운받을 파일의 경로 가져오기
	public String FileDownload(int num) {

		String filePath = getSqlSession().selectOne("ex.downloadFilePath", num);

		return filePath;
	}

	// 수정 파일업로드
	public int updateFileupload(Qna_file qf) {
		
		int i = getSqlSession().update("ex.changefile", qf);

		return i;
	}

	// 댓글 파일업로드
	public int replyFileupload(Comment_file cf) {

		int i = getSqlSession().insert("ex.replyinsertFile", cf);

		return i;
	}

	// 댓글 추가
	public int cminsert(Qna_comment cm) {

		int i = getSqlSession().insert("ex.insertcm", cm);

		return i;
	}

	// 댓글 수정
	public int cmupdate(Qna_comment qf) {

		int i = getSqlSession().update("ex.updatecm", qf);
		
		return i;
	}

	// 댓글 수정 파일업로드
	public int cmupdateFileupload(Comment_file cf) {

		int i = getSqlSession().update("ex.changecmfile", cf);

		return i;
	}

	// 댓글 삭제
	public void cmdelete(int comment_num) {
		getSqlSession().delete("ex.deletecmfile", comment_num);
		getSqlSession().delete("ex.deletecm", comment_num);

	}

	// 수정 할 댓글 가져오기
	public Qna_comment cmselectOne(int comment_num) {

		Qna_comment list = getSqlSession().selectOne("ex.cmdetailBoard", comment_num);

		return list;
	}

}
