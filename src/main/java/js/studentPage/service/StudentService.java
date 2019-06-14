package js.studentPage.service;

import java.util.List;

import js.noticeboard.model.NoticeBoardDTO;
import js.scholarship.model.ScholarshipDTO;
import js.studentPage.model.PrivacyDTO;

public interface StudentService {
	public String getPicture(int id);	// 개인의 사진 경로 와 이름 가져오기
	public PrivacyDTO getPrivacy(int id);	// 개인정보 가져오기 
	public List<ScholarshipDTO> getScholarship(int id);	// 장학금 내역 가져오기
	public List<NoticeBoardDTO> getNoticeBoard();	// 공지사항 가져오기
}
