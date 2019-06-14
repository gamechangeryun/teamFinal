package sr_service;

import java.util.List;

import sr_model.commentDTO;

public interface CommentService {
	//댓글 개수
	public int commentCnt()throws Exception;
	
	//댓글 목록
	public List<commentDTO> commentList(int num)throws Exception;
	
	//댓글 작성
	public int commmentInsert(commentDTO comment)throws Exception;
	
	//댓글 수정
	public int commentUpdate(commentDTO comment)throws Exception;
	
	//댓글 삭제
	public int commentDelete(int comment)throws Exception;
}
