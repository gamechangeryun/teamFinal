package js.professorPage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KH.spring.jjin.DTO.WolDTO;
import js.noticeboard.model.NoticeBoardDTO;
import js.professorPage.model.ProfessorPageDAO;
import js.studentPage.model.PrivacyDTO;
import mi.job.board.model.DTO;

@Service
public class ProfessorPageServiceImpl implements ProfessorPageService{
	
	@Autowired
	private ProfessorPageDAO dao;

	public void setDao(ProfessorPageDAO dao) {
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
	
	// 취업게시판 가져오기
	@Override
	public List<DTO> getJobBoard() {

		List<DTO> list = dao.getJobBoard();

		return list;
	}
	
	
	
}
