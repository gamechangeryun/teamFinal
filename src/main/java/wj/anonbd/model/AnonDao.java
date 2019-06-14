package wj.anonbd.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class AnonDao extends SqlSessionDaoSupport{
	// 게시글 리스트
	public List<AnonContentDto> getList(String sql) {
		List<AnonContentDto> contents = getSqlSession().selectList(sql);
		return contents;
	}
	
	// 게시글보기 page
	public List<AnonContentDto> getPageList(String sql, int page) {
		int start = 1+(5*(page-1));
		List<AnonContentDto> contents = getSqlSession().selectList(sql, start);
		return contents;
	}
	

	// 게시글 찾기 전체
	public List<AnonContentDto> getSearchList(String sql, String searchStr) {
		List<AnonContentDto> contents = getSqlSession().selectList(sql, searchStr);
		return contents;
	}
	
	// 게시글 찾기 page
	public List<AnonContentDto> getSearchList(String sql, String searchStr, int page) {
		int start = 1+(5*(page-1));
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("searchStr", searchStr);
		map.put("start", start);
		
		List<AnonContentDto> contents = getSqlSession().selectList(sql, map);
		return contents;
	}
	
	// 게시글 보기
	public AnonContentDto getContent(String sql, int i) {
		AnonContentDto content = getSqlSession().selectOne(sql, i);
		return content;
	}
	
	// 게시글 수정
	public void updateContent(String sql, AnonContentDto dto) {
		int i = getSqlSession().update(sql, dto);
		if (i != 0) {
			System.out.println("게시글 수정 완료.");
		} else {
			System.out.println("게시글 수정 실패.");
		}
	}
	
	// 게시글 삭제
	public void deleteContent(String sql, AnonContentDto dto) {
		int i = getSqlSession().delete(sql, dto);
		if (i != 0) {
			System.out.println("게시글 삭제 완료.");
		} else {
			System.out.println("게시글 삭제 실패.");
		}
	}
	
	public void deleteComment(String sql, int comment_num) {
		int i = getSqlSession().delete(sql, comment_num);
		if (i != 0) {
			System.out.println("댓글 삭제 완료.");
		} else {
			System.out.println("댓글 삭제 실패.");
		}
	}
	
	// 조회수 올리기
	public void upReadcount(String sql, AnonContentDto dto) {
		int i = getSqlSession().update(sql,dto);
		if (i != 0) {
			System.out.println("조회수 완료.");
		} else {
			System.out.println("조회수 실패.");
		}
	}
	
	// 게시글 작성
	public void insertContent(String sql, AnonContentDto dto) {
		int i = getSqlSession().insert(sql,dto);
		if (i != 0) {
			System.out.println("게시글 저장 완료.");
		} else {
			System.out.println("게시글 저장 실패.");
		}
	}
	
	// 댓글 출력
	public List<AnonCommentDto> getCommentList(String sql, int i) {
		List<AnonCommentDto> comments = getSqlSession().selectList(sql, i);
		return comments;
	}
	
	// 댓글 추가
	public void insertComment(String sql, AnonCommentDto dto) {
		int i = getSqlSession().insert(sql,dto);
		if (i != 0) {
			System.out.println("댓글추가 완료.");
		} else {
			System.out.println("댓글추가 실패.");
		}
	}
}
