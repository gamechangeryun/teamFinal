package js.studentPage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import js.noticeboard.model.NoticeBoardDTO;
import js.scholarship.model.ScholarshipDTO;
import js.studentPage.model.PrivacyDTO;
import js.studentPage.model.StudentPageDAO;
import mi.job.board.model.DTO;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentPageDAO dao;
	
	public void setDao(StudentPageDAO dao) {
		this.dao = dao;
	}
	
	// 개인의 사진의 경로와 이름 가져오기
	@Override
	public String getPicture(int id) {
		
		String picture = dao.getPicture(id);
		
		return picture;
	}

	// 개인정보 가져오기
	@Override
	public PrivacyDTO getPrivacy(int id) {
		
		PrivacyDTO dto = dao.getPrivacy(id);
		
		return dto;
	}
	
	// 장학금 내역 가져오기
	@Override
	public List<ScholarshipDTO> getScholarship(int id) {
		
		List<ScholarshipDTO> list = dao.getScholarship(id);
		
		return list;
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
	
}
