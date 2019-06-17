package js.guestPage.service;

import java.util.List;

import KH.spring.jjin.DTO.BoardDTO;
import js.noticeboard.model.NoticeBoardDTO;
import mi.job.board.model.DTO;
import sr_model.bdDTO;
import wj.anonbd.model.AnonContentDto;

public interface GuestPageService {
	public List<NoticeBoardDTO> getNoticeBoard();	// 공지사항 가져오기
	public List<DTO> getJobBoard();	// 취업게시판 가져오기
	public List<bdDTO> getMtmtBoard();	// 멘토멘티게시판 가져오기
	public List<BoardDTO> getFreeBoard();	// 자유게시판 가져오기
	public List<AnonContentDto> getAnonBoard();	// 자유게시판 가져오기
}
