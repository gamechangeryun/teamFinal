package js.studentPage.model;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import js.noticeboard.model.NoticeBoardDTO;
import js.scholarship.model.ScholarshipDTO;

public class StudentPageDAO extends SqlSessionDaoSupport{

	// 개인의 사진의 경로와 이름 가져오기
	public String getPicture(int id) {
		
		String picture = getSqlSession().selectOne("studentPage.getPicture", id);
		
		return picture;
	}

	// 개인정보 가져오기
	public PrivacyDTO getPrivacy(int id) {
			
		PrivacyDTO dto = getSqlSession().selectOne("studentPage.getPrivacy", id);
		
		return dto;
	}
	
	// 장학금 내역 가져오기
	public List<ScholarshipDTO> getScholarship(int id) {
		
		List<ScholarshipDTO> list= getSqlSession().selectList("studentPage.getScholarship", id);
		
		return list;
	}
	
	// 공지사항 가져오기
	public List<NoticeBoardDTO> getNoticeBoard() {
		
		List<NoticeBoardDTO> list = getSqlSession().selectList("studentPage.getNoticeBoard");

		return list;
	}
	
	
	
	
}//
