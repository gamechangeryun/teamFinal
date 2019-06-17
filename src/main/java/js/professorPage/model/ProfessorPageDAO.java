package js.professorPage.model;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import KH.spring.jjin.DTO.WolDTO;
import js.noticeboard.model.NoticeBoardDTO;
import js.studentPage.model.PrivacyDTO;
import mi.job.board.model.DTO;

public class ProfessorPageDAO extends SqlSessionDaoSupport{
	
	// 개인의 사진의 경로와 이름 가져오기
	public String getPicture(int id) {
		
		String picture = getSqlSession().selectOne("ProfessorPage.getPicture", id);
		
		return picture;
	}
	
	// 개인정보 가져오기
	public PrivacyDTO getPrivacy(int id) {
			
		PrivacyDTO dto = getSqlSession().selectOne("ProfessorPage.getPrivacy", id);
		
		return dto;
	}
	
	// 공지사항 가져오기
	public List<NoticeBoardDTO> getNoticeBoard() {

		List<NoticeBoardDTO> list = getSqlSession().selectList("ProfessorPage.getNoticeBoard");

		return list;
	}

	// 월급 가져오기
	public List<WolDTO> getMonthPay(int id) {
		
		List<WolDTO> list = getSqlSession().selectList("ProfessorPage.getMonthPay", id);

		return list;
	}
	
	// 취업게시판 가져오기
	public List<DTO> getJobBoard() {

		List<DTO> list = getSqlSession().selectList("ProfessorPage.getJobBoard");

		return list;
	}
	
	
}
