package js.facultyPage.model;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import KH.spring.jjin.DTO.WolDTO;
import js.noticeboard.model.NoticeBoardDTO;
import js.studentPage.model.PrivacyDTO;

public class FacultyPageDAO extends SqlSessionDaoSupport{

	// 개인정보 가져오기
	public PrivacyDTO getPrivacy(int id) {

		PrivacyDTO dto = getSqlSession().selectOne("FacultyPage.getPrivacy", id);

		return dto;
	}
	
	// 공지사항 가져오기
	public List<NoticeBoardDTO> getNoticeBoard() {
			
		List<NoticeBoardDTO> list = getSqlSession().selectList("FacultyPage.getNoticeBoard");

		return list;
	}

	// 월급 가져오기
	public List<WolDTO> getMonthPay(int id) {

		List<WolDTO> list = getSqlSession().selectList("ProfessorPage.getMonthPay", id);

		return list;
	}
	
	
}
