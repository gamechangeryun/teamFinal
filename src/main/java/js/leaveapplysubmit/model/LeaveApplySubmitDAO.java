package js.leaveapplysubmit.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class LeaveApplySubmitDAO extends SqlSessionDaoSupport{
	
	// 휴학생 테이블에서 휴학생 있는지 확인
	public int checkLeaveStudent(int id) {
		
		int check = getSqlSession().selectOne("leaveApplySubmit.checkLeaveStudent", id);
		
		return check;
	}
	
	// 휴학신청 리스에 있는지 확인
	public int checkLeaveApply(int id) {
		
		int check = getSqlSession().selectOne("leaveApplySubmit.checkLeaveApply", id);
		
		return check;
	}
	
	// 휴학신청서 작성
	public void insertLeaveApply(LeaveApplySubmitDTO dto) {
		getSqlSession().insert("leaveApplySubmit.insertLeaveApply", dto);
	}
	
	/////////////////////////////////////////////////////////////
	
	// 휴학신청리스트 가져오기
	public List<LeaveApplySubmitDTO> getLeaveApplyList(int startRow, int endRow) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		
		List<LeaveApplySubmitDTO> list = getSqlSession().selectList("leaveApplySubmit.getLeaveApplyList", map);
		
		return list;
	}

	// 서치된 글 목록 가져오기
	public List<LeaveApplySubmitDTO> getSearchList(int options, String searchContent, int startRow, int endRow) {

		List<LeaveApplySubmitDTO> list = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchContent", searchContent);
		map.put("startRow", startRow);
		map.put("endRow", endRow);

		if (options == 0) {
			if (!searchContent.equals(" ")) {
				// 학번으로 찾기
				list = getSqlSession().selectList("leaveApplySubmit.searchId", map);
			}
		} else if (options == 1) {
			if (!searchContent.equals(" ")) {
				// 학과로 찾기
				list = getSqlSession().selectList("leaveApplySubmit.searchTemperName", map);
			}

		} else {
			if (!searchContent.equals(" ")) {
				// 작성자로 찾기
				list = getSqlSession().selectList("leaveApplySubmit.searchWriter", map);
			}
		}

		return list;
	}

	// 글의 개수 가져오기
	public int count() {

		int count = getSqlSession().selectOne("leaveApplySubmit.countContent");

		return count;
	}

	// 서치된 글의 개수 가져오기
	public int searchCount(int options, String searchContent) {

		int searchCount = 0;
		String result = "";
		if (options == 0) {
			if (!searchContent.equals(" ")) {
				// 학번으로 찾기
				result = getSqlSession().selectOne("leaveApplySubmit.searchIdCount", searchContent);
			}
		} else if (options == 1) {
			if (!searchContent.equals(" ")) {
				// 내용으로 찾기
				result = getSqlSession().selectOne("leaveApplySubmit.searchTemperNameCount", searchContent);
			}

		} else {
			if (!searchContent.equals(" ")) {
				// 작성자로 찾기
				result = getSqlSession().selectOne("leaveApplySubmit.searchWriterCount", searchContent);
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
	
	/////////////////////////////////////////////////////////////////////////////////////////////////
	// 휴학생 테이블에 추가하기 및 삭제하기
	public void insertLeaveStudent(LeaveApplySubmitDTO dto) {
		int check = getSqlSession().insert("leaveApplySubmit.insertLeaveStudent", dto);
		
		if(check > 0) {
			getSqlSession().delete("leaveApplySubmit.deleteLeaveApply", dto.getId());
		}
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	// 리스트 삭제
	public void deleteLeaveApply(int id) {
		getSqlSession().delete("leaveApplySubmit.deleteLeaveApply", id);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////
	// 휴학생리스트 가져오기
	public List<LeaveApplySubmitDTO> getLeaveStudentList(int startRow, int endRow) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);

		List<LeaveApplySubmitDTO> list = getSqlSession().selectList("leaveApplySubmit.getLeaveStudentList", map);

		return list;
	}

	// 휴학생 서치된 글 목록 가져오기
	public List<LeaveApplySubmitDTO> getLeaveStudentSearchList(int options, String searchContent, int startRow, int endRow) {

		List<LeaveApplySubmitDTO> list = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchContent", searchContent);
		map.put("startRow", startRow);
		map.put("endRow", endRow);

		if (options == 0) {
			if (!searchContent.equals(" ")) {
				// 학번으로 찾기
				list = getSqlSession().selectList("leaveApplySubmit.searchLeaveStudentId", map);
			}
		} else if (options == 1) {
			if (!searchContent.equals(" ")) {
				// 학과로 찾기
				list = getSqlSession().selectList("leaveApplySubmit.searchLeaveStudentTemperName", map);
			}

		} else {
			if (!searchContent.equals(" ")) {
				// 작성자로 찾기
				list = getSqlSession().selectList("leaveApplySubmit.searchLeaveStudentWriter", map);
			}
		}

		return list;
	}

	// 휴학생 인원수 가져오기
	public int LeaveStudentCount() {

		int count = getSqlSession().selectOne("leaveApplySubmit.countStudentLeavePeople");

		return count;
	}

	// 휴학생 서치된 인원수 가져오기
	public int LeaveStudentSearchCount(int options, String searchContent) {

		int searchCount = 0;
		String result = "";
		if (options == 0) {
			if (!searchContent.equals(" ")) {
				// 학번으로 찾기
				result = getSqlSession().selectOne("leaveApplySubmit.searchLeaveStudentIdCount", searchContent);
			}
		} else if (options == 1) {
			if (!searchContent.equals(" ")) {
				// 내용으로 찾기
				result = getSqlSession().selectOne("leaveApplySubmit.searchLeaveStudentTemperNameCount", searchContent);
			}

		} else {
			if (!searchContent.equals(" ")) {
				// 작성자로 찾기
				result = getSqlSession().selectOne("leaveApplySubmit.searchLeaveStudentWriterCount", searchContent);
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
	
}
