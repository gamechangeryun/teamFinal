package js.professorPage.service;

import java.util.List;

import KH.spring.jjin.DTO.WolDTO;
import js.noticeboard.model.NoticeBoardDTO;
import js.studentPage.model.PrivacyDTO;

public interface ProfessorPageService {
	public String getPicture(int id);	// 개인의 사진 경로 와 이름 가져오기
	public PrivacyDTO getPrivacy(int id);	// 개인정보 가져오기 
	public List<NoticeBoardDTO> getNoticeBoard();	// 공지사항 가져오기
	public List<WolDTO> getMonthPay(int id);	// 교수 월급 가져오기
}
