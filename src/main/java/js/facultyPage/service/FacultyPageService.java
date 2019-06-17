package js.facultyPage.service;

import java.util.List;

import KH.spring.jjin.DTO.WolDTO;
import js.noticeboard.model.NoticeBoardDTO;
import js.studentPage.model.PrivacyDTO;
import mi.job.board.model.DTO;

public interface FacultyPageService {
	public PrivacyDTO getPrivacy(int id);	// 개인정보 가져오기 
	public List<NoticeBoardDTO> getNoticeBoard();	// 공지사항 가져오기
	public List<WolDTO> getMonthPay(int id);	// 교직원 월급 가져오기
	public List<DTO> getJobBoard();	// 취업게시판 가져오기
}
