package js.reinapplysubmit.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class ReinApplySubmitDAO extends SqlSessionDaoSupport{
	
	// 휴학생에 현재 아이디가 있는지 확인
	public int checkLeaveStudent(int id) {

		int check = getSqlSession().selectOne("ReinApplySubmit.checkLeaveStudent", id);
		
		return check;
	}
	
	// 복학신청을 이미 한 아이디인지 확인
	public int checkReinApplyList(int id) {
		
		int check = getSqlSession().selectOne("ReinApplySubmit.checkReinApplyList", id);
		
		return check;
	}
	
	// 복학신청
	public void insertReinApply(int id, Date startreindate) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("startreindate", startreindate);
		
		getSqlSession().insert("ReinApplySubmit.insertReinApply", map);
	}
	//////////////////////////////////////////////////////////////////////
	// 휴학신청리스트 가져오기
	public List<ReinApplySubmitDTO> getReinApplyList(int startRow, int endRow) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);

		List<ReinApplySubmitDTO> list = getSqlSession().selectList("ReinApplySubmit.getReinApplyList", map);

		return list;
	}

	// 서치된 글 목록 가져오기
	public List<ReinApplySubmitDTO> getSearchList(int options, String searchContent, int startRow, int endRow) {

		List<ReinApplySubmitDTO> list = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchContent", searchContent);
		map.put("startRow", startRow);
		map.put("endRow", endRow);

		if (options == 0) {
			if (!searchContent.equals(" ")) {
				// 학번으로 찾기
				list = getSqlSession().selectList("ReinApplySubmit.searchId", map);
			}
		} else if (options == 1) {
			if (!searchContent.equals(" ")) {
				// 학과로 찾기
				list = getSqlSession().selectList("ReinApplySubmit.searchTemperName", map);
			}

		} else {
			if (!searchContent.equals(" ")) {
				// 작성자로 찾기
				list = getSqlSession().selectList("ReinApplySubmit.searchWriter", map);
			}
		}

		return list;
	}

	// 글의 개수 가져오기
	public int count() {

		int count = getSqlSession().selectOne("ReinApplySubmit.countContent");

		return count;
	}

	// 서치된 글의 개수 가져오기
	public int searchCount(int options, String searchContent) {

		int searchCount = 0;
		String result = "";
		if (options == 0) {
			if (!searchContent.equals(" ")) {
				// 학번으로 찾기
				result = getSqlSession().selectOne("ReinApplySubmit.searchIdCount", searchContent);
			}
		} else if (options == 1) {
			if (!searchContent.equals(" ")) {
				// 내용으로 찾기
				result = getSqlSession().selectOne("ReinApplySubmit.searchTemperNameCount", searchContent);
			}

		} else {
			if (!searchContent.equals(" ")) {
				// 작성자로 찾기
				result = getSqlSession().selectOne("ReinApplySubmit.searchWriterCount", searchContent);
			}
		}

		if (result == null) {
			result = "0";
			searchCount = Integer.parseInt(result);
		} else {
			searchCount = Integer.parseInt(result);
		}

		return searchCount;
	}
	///////////////////////////////////////////////////////////////////////////////
	// 복학허용
	public void reinSubmit(int id) {
		// 휴학생테이블에서 삭제
		getSqlSession().delete("ReinApplySubmit.reinSubmit", id);
		
		// 복학신청테이블에서 삭제
		getSqlSession().delete("ReinApplySubmit.deleteReinList", id);
	}
	
	// 복학기각
	public void reinRefus(int id) {
		getSqlSession().delete("ReinApplySubmit.deleteReinList", id);
	}
		
		
}
