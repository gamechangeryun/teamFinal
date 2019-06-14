package js.facultyPage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KH.spring.jjin.DTO.WolDTO;
import js.facultyPage.model.FacultyPageDAO;
import js.noticeboard.model.NoticeBoardDTO;
import js.studentPage.model.PrivacyDTO;

@Service
public class FacultyPageServiceImpl implements FacultyPageService{

	@Autowired
	private FacultyPageDAO dao;

	public void setDao(FacultyPageDAO dao) {
		this.dao = dao;
	}
	
	// 개인정보 가져오기
	@Override
	public PrivacyDTO getPrivacy(int id) {

		PrivacyDTO dto = dao.getPrivacy(id);

		return dto;
	}
	
	// 공지사항 가져오기
	@Override
	public List<NoticeBoardDTO> getNoticeBoard() {
			
		List<NoticeBoardDTO> list = dao.getNoticeBoard();
			
		return list;
	}
	
	// 월급 가져오기
	@Override
	public List<WolDTO> getMonthPay(int id) {

		List<WolDTO> list = dao.getMonthPay(id);

		return list;
	}
	
	
}
