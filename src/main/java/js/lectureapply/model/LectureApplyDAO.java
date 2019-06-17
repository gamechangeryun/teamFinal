package js.lectureapply.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class LectureApplyDAO extends SqlSessionDaoSupport {
		
	// 강의개설신청서 작성
	public void insertLecture(LectureApplyDTO dto) {
		getSqlSession().insert("lectureapply.insertLectureApply", dto);
	}

	//////////////////////////////////////////////////////////////////
	// 글 목록 가져오기
	public List<LectureApplyDTO> getList(int startRow, int endRow) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);

		List<LectureApplyDTO> list = getSqlSession().selectList("lectureapply.getTotalList", map);

		return list;
	}

	// 서치된 글 목록 가져오기
	public List<LectureApplyDTO> getSearchList(int options, String searchContent, int startRow, int endRow) {

		List<LectureApplyDTO> list = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchContent", searchContent);
		map.put("startRow", startRow);
		map.put("endRow", endRow);

		if (options == 0) {
			if (!searchContent.equals(" ")) {
				// 제목으로 찾기
				list = getSqlSession().selectList("lectureapply.searchTitle", map);
			}
		} else if (options == 1) {
			if (!searchContent.equals(" ")) {
				// 작성자로 찾기
				list = getSqlSession().selectList("lectureapply.searchWriter", map);
			}

		} 

		return list;
	}

	// 글의 개수 가져오기
	public int count() {

		int count = getSqlSession().selectOne("lectureapply.countContent");

		return count;
	}

	// 서치된 글의 개수 가져오기
	public int searchCount(int options, String searchContent) {

		int searchCount = 0;
		String result = "";
		if (options == 0) {
			if (!searchContent.equals(" ")) {
				// 제목으로 찾기
				result = getSqlSession().selectOne("lectureapply.searchTitleCount", searchContent);
			}
		} else if (options == 1) {
			if (!searchContent.equals(" ")) {
				// 작성자로 찾기
				result = getSqlSession().selectOne("lectureapply.searchWriterCount", searchContent);
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
	////////////////////////////////////////////////////////////////////////////////////////////////////	
	// 마지막 번호 가져오기
	public String getMaxNum() {

		String max_num = getSqlSession().selectOne("lectureapply.getMaxNum");

		return max_num;
	}
		
	// 강의개설신청허용
	public int lectureApplySubmit(LectureApplyDTO dto) {
		System.out.println(dto);
		int check1 = getSqlSession().insert("lectureapply.insertLecture", dto);
		int check2 = getSqlSession().insert("lectureapply.insertSchedule", dto);
		
		int check = 0;
		if(check1 > 0 && check2 > 0) {
			check = 1;
		}
		
		return check;
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	// 강의개설신청리스트에서 삭제하기
	public void lectureApplyRefuse(int id, String lecture_title) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("lecture_title", lecture_title);
		
		getSqlSession().delete("lectureapply.deleteLectureApply", map);
	}
}
