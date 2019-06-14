package wj.anonbd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wj.anonbd.model.AnonCommentDto;
import wj.anonbd.model.AnonContentDto;
import wj.anonbd.model.AnonDao;

@Service
public class AnonService {
	@Autowired
	private AnonDao dao;

	public void setDao(AnonDao dao) {
		this.dao = dao;
	}

	// 전체 글 보기
	public List<AnonContentDto> showList() {
		List<AnonContentDto> list = null;
		try {
			list = dao.getList("anonSql.showAll");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return list;
	}
	 
	// page 전체 글 보기
	public List<AnonContentDto> showPageList(int page) {
		List<AnonContentDto> list = null;
		try {
			list = dao.getPageList("anonSql.showPage", page);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return list;
	}

	// 상세 글 보기 + 조회수올리기
	public AnonContentDto getContent(int num) {
		AnonContentDto dto = null;
		try {
			dto = dao.getContent("anonSql.showContent", num);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		int cnt = dto.getReadcount();
		dto.setReadcount(cnt + 1);
		try {
			dao.upReadcount("anonSql.upReadcount", dto);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return dto;
	}

	// 글 수정하기
	public void modifyContent(AnonContentDto dto) {
		try {
			dao.updateContent("anonSql.modifyContent", dto);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	// 글 삭제하기
	public void deleteContent(AnonContentDto dto) {
		try {
			dao.deleteContent("anonSql.deleteContent", dto);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	// 댓글 삭제하기
	public void deleteComment(int comment_num) {
		try {
			dao.deleteComment("anonSql.deleteComment", comment_num);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	// 글 작성하기
	public void insertContent(AnonContentDto dto) {
		try {
			dao.insertContent("anonSql.insertContent", dto);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	// 글 찾기 전체
	public List<AnonContentDto> showSearchList(int i, String searchStr) {
		List<AnonContentDto> list = null;
		System.out.println("i ::: " +i+", searchStr ::: " +searchStr);
		if (i == 0) {
			try {
				list = dao.getSearchList("anonSql.searchForWriter", searchStr);
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		} else if (i == 1) {
			try {
				list = dao.getSearchList("anonSql.searchForContent", searchStr);
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		} else if (i == 2) {
			try {
				list = dao.getSearchList("anonSql.searchForTitle", searchStr);
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
		return list;
	}
	 
	//글 찾기 page
	public List<AnonContentDto> showSearchList(int i, String searchStr, int page) {
		List<AnonContentDto> list = null;
		System.out.println("i ::: " +i+", searchStr ::: " +searchStr +", page ::: " +page);
		if (i == 0) {
			try {
				list = dao.getSearchList("anonSql.searchPageForWriter", searchStr, page);
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		} else if (i == 1) {
			try {
				list = dao.getSearchList("anonSql.searchPageForContent", searchStr, page);
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		} else if (i == 2) {
			try {
				list = dao.getSearchList("anonSql.searchPageForTitle", searchStr, page);
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
		return list;
	}
	
	
	public List<AnonCommentDto> showCommentList(int num) {
		List<AnonCommentDto> comments = null;
		try {
			comments = dao.getCommentList("anonSql.searchComment", num);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return comments;
	}
	
	public void addComment(AnonCommentDto dto) {
		try {
			dao.insertComment("anonSql.insertComment", dto);
		} catch (Exception e) {	
			System.out.println(e.toString());
		}
	}
}
