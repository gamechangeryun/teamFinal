package js.guestPage.model;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import KH.spring.jjin.DTO.BoardDTO;
import js.noticeboard.model.NoticeBoardDTO;
import mi.job.board.model.DTO;
import sr_model.bdDTO;
import wj.anonbd.model.AnonContentDto;

public class GuestPageDAO extends SqlSessionDaoSupport {

	// 공지사항 가져오기
	public List<NoticeBoardDTO> getNoticeBoard() {

		List<NoticeBoardDTO> list = getSqlSession().selectList("guestPage.getNoticeBoard");

		return list;
	}

	// 취업게시판 가져오기
	public List<DTO> getJobBoard() {

		List<DTO> list = getSqlSession().selectList("guestPage.getJobBoard");

		return list;
	}

	// 멘토멘티 게시판 가져오기
	public List<bdDTO> getMtmtBoard() {

		List<bdDTO> list = getSqlSession().selectList("guestPage.getMtmtBoard");

		return list;
	}

	// 자유게시판 가져오기
	public List<BoardDTO> getFreeBoard() {

		List<BoardDTO> list = getSqlSession().selectList("guestPage.getFreeBoard");

		return list;
	}

	// 자유게시판 가져오기
	public List<AnonContentDto> getAnonBoard() {

		List<AnonContentDto> list = getSqlSession().selectList("guestPage.getAnonBoard");

		return list;
	}

}
