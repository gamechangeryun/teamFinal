package js.canceledlecture.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import js.lectureapply.model.LectureApplyDTO;

public class CanceledLectureDAO extends SqlSessionDaoSupport{

	// 해당 아이디에 강의 리스트 받아오기
	public List<LectureApplyDTO> getLectureList(int id) {
		
		List<LectureApplyDTO> list = getSqlSession().selectList("canceledLecture.getLectureList", id);
		
		return list;
	}
	
	// 휴강신청 제출
	public void insertCanceledLecture(CanceledLectureDTO dto) {
		getSqlSession().insert("canceledLecture.insertCanceledLecture", dto);
	}
	
	// 휴강신청리스트 가져오기
	public List<CanceledLectureDTO> canceledList() {

		List<CanceledLectureDTO> canceledList = getSqlSession().selectList("canceledLecture.getCanceledList");
		
		return canceledList;
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	// 휴학신청리스트 가져오기
	public List<CanceledLectureDTO> getCanceledList(int startRow, int endRow) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);

		List<CanceledLectureDTO> list = getSqlSession().selectList("canceledLecture.getCanceledLectureList", map);
		
		for (CanceledLectureDTO canceledLectureDTO : list) {
			System.out.println(canceledLectureDTO);
		}

		return list;
	}

	// 서치된 글 목록 가져오기
	public List<CanceledLectureDTO> getSearchList(int options, String searchContent, int startRow, int endRow) {

		List<CanceledLectureDTO> list = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchContent", searchContent);
		map.put("startRow", startRow);
		map.put("endRow", endRow);

		if (options == 0) {
			if (!searchContent.equals(" ")) {
				// 학번으로 찾기
				list = getSqlSession().selectList("canceledLecture.searchId", map);
			}
		} else if (options == 1) {
			if (!searchContent.equals(" ")) {
				// 학과로 찾기
				list = getSqlSession().selectList("canceledLecture.searchTemperName", map);
			}

		} else {
			if (!searchContent.equals(" ")) {
				// 작성자로 찾기
				list = getSqlSession().selectList("canceledLecture.searchWriter", map);
			}
		}

		return list;
	}

	// 글의 개수 가져오기
	public int count() {

		int count = getSqlSession().selectOne("canceledLecture.countContent");

		return count;
	}

	// 서치된 글의 개수 가져오기
	public int searchCount(int options, String searchContent) {

		int searchCount = 0;
		String result = "";
		if (options == 0) {
			if (!searchContent.equals(" ")) {
				// 학번으로 찾기
				result = getSqlSession().selectOne("canceledLecture.searchIdCount", searchContent);
			}
		} else if (options == 1) {
			if (!searchContent.equals(" ")) {
				// 내용으로 찾기
				result = getSqlSession().selectOne("canceledLecture.searchTemperNameCount", searchContent);
			}

		} else {
			if (!searchContent.equals(" ")) {
				// 작성자로 찾기
				result = getSqlSession().selectOne("canceledLecture.searchWriterCount", searchContent);
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
	//////////////////////////////////////////////////////////////////////////////////////////////////
	// 휴강테이블에 추가
	public void insertCanceledList(CanceledLectureDTO dto) {
		
		int check = getSqlSession().insert("canceledLecture.insertCanceled", dto);
		
		if(check > 0) {
			getSqlSession().delete("canceledLecture.deleteCanceledList", dto.getId());
		}
	}
	
	// 휴강신청테이블에서 삭제
	public void deleteCanceleListSupply(int id) {
		getSqlSession().delete("canceledLecture.deleteCanceledList", id);
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////
	// 교수가 휴강리스트 확인하기
	public List<CanceledLectureDTO> getSubmitCanceledList(int id) {
		
		List<CanceledLectureDTO> list = getSqlSession().selectList("canceledLecture.getSubmitCanceledList", id);
	
		return list;
	}
	
	
}
