package sr_service;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import sr_model.CommentDAO;
import sr_model.commentDTO;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	@Qualifier("commentDAO")
	private CommentDAO mdao;

	public void setMdao(CommentDAO mdao) {
		this.mdao = mdao;
	}

	@Override
	public int commentCnt() throws Exception {
		
		return mdao.commentCnt();
	}

	@Override
	public List<commentDTO> commentList(int num) throws Exception {
		return mdao.commentList(num);
	}

	@Override
	public int commmentInsert(commentDTO comment) throws Exception {
		
		Date date = new Date();
		comment.setWritedate(date);
		int check = mdao.commentInsert(comment);
		
		return check;
	}

	@Override
	public int commentUpdate(commentDTO comment) throws Exception {
		
		Date date = new Date();
		comment.setWritedate(date);
		int check = mdao.commentUpdate(comment);
		
		return check;
	}

	@Override
	public int commentDelete(int comment_num) throws Exception {
		return mdao.commentDelete(comment_num);
	}

}
