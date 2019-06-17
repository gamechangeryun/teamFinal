package js.guestPage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KH.spring.jjin.DTO.BoardDTO;
import js.guestPage.model.GuestPageDAO;
import js.noticeboard.model.NoticeBoardDTO;
import mi.job.board.model.DTO;
import sr_model.bdDTO;
import wj.anonbd.model.AnonContentDto;

@Service
public class GuestPageServiceImpl implements GuestPageService{

	@Autowired
	private GuestPageDAO dao;

	public void setDao(GuestPageDAO dao) {
		this.dao = dao;
	}
	
	// 공지사항 가져오기
	@Override
	public List<NoticeBoardDTO> getNoticeBoard() {

		List<NoticeBoardDTO> list = dao.getNoticeBoard();

		return list;
	}

	// 취업게시판 가져오기
	@Override
	public List<DTO> getJobBoard() {

		List<DTO> list = dao.getJobBoard();

		return list;
	}
	
	// 멘토멘티 게시판 가져오기
	@Override
	public List<bdDTO> getMtmtBoard() {
		
		List<bdDTO> list = dao.getMtmtBoard();
		
		return list;
	}
	
	// 자유게시판 가져오기
	@Override
	public List<BoardDTO> getFreeBoard() {
		
		List<BoardDTO> list = dao.getFreeBoard();
		
		return list;
	}
	
	// 자유게시판 가져오기
	@Override
	public List<AnonContentDto> getAnonBoard() {

		List<AnonContentDto> list = dao.getAnonBoard();

		return list;
	}
	
	
	
	
}
