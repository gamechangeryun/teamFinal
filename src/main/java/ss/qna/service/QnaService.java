package ss.qna.service;

import java.util.List;

import ss.qna.model.Comment_file;
import ss.qna.model.Qna_bd;
import ss.qna.model.Qna_comment;
import ss.qna.model.Qna_file;

public interface QnaService {

	public List<Qna_bd> selectList(int startRow,int endRow); 	// 전체글 가져오기
	public int count();											// 전체 글 갯수 가져오기
	public int cmcount();					// 전체 댓글 갯수 가져오기
	public List<Qna_bd> getSearchList(int options, String searchContent);	// 서치된 글 목록 가져오기
	//////////////////////////////////////////////////////////////////////
	public Qna_bd selectOne(int num); 		// 세부글 보기
	public List<Qna_comment> cmselectList(int startRow,int endRow,int num); 	// 전체 댓글 가져오기
	public int readcountup(int num);		// 조회수 증가
	public String getFileName(int num);		// 다운받을 파일이름 가져오기
	public String FileDownload(int num);	// 다운받을 파일경로 가져오기
    //////////////////////////////////////////////////////////////////////
	public int insertBoard(Qna_bd board); 	// 글추가	
	public int Fileupload(Qna_file qf);		// 파일업로드
	public int updateBoard(Qna_bd board); 	// 글수정
	public int updateFileupload(Qna_file qf);	//글수정 파일 수정
	public void deleteBoard(int num, int comment_num); 		// 글삭제
	//////////////////////////////////////////////////////////////////////
	public int cminsert(Qna_comment cm);		  //댓글추가
	public int cmFileupload(Comment_file cf);	  	  //댓글 파일 업로드
	public Qna_comment cmselectOne(int comment_num);	//수정 할 댓글 가져오기
	public int cmupdate(Qna_comment qf);		  //댓글 수정
	public int cmupdateFileupload(Comment_file cf);	//댓글 수정 파일 업로드
	public void cmdelete(int comment_num);				  //댓글 삭제
	//////////////////////////////////////////////////////////////////////
	
	
}
