package sr_model;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

@Component("commentDAO")
public class CommentDAO extends SqlSessionDaoSupport{
	//댓글 카운트
	public int commentCnt()throws Exception{
		return getSqlSession().selectOne("comment.Count");
	}
	
	//댓글 목록
	public List<commentDTO> commentList(int num) throws Exception{
		
		return getSqlSession().selectList("comment.List", num);
	}
	
	//댓글 입력
	public int commentInsert(commentDTO comment)throws Exception{
		return getSqlSession().insert("comment.Insert", comment);
	}
	
	//댓글 수정
	public int commentUpdate(commentDTO comment)throws Exception{
		return getSqlSession().update("comment.Update", comment);
	}
	
	//댓글 삭제
	public int commentDelete(int comment_num)throws Exception{
		return getSqlSession().delete("comment.Delete", comment_num);
	}
}
