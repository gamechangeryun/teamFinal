package js.lecturerating.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import js.lectureapply.model.LectureApplyDTO;

public class LectureRatingDAO extends SqlSessionDaoSupport{
	
	// 강의리스트 가져오기
	public List<LectureApplyDTO> getLectureList(int id) {
		
		List<LectureApplyDTO> lectureList = getSqlSession().selectList("LectureRating.getLectureList", id);

		return lectureList;
	}
		
	// 학생이 교수의 강의평가 하기
	public void insertLectureRating(int lecture_num, int id, String totalcomment, int totalscore) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lecture_num", lecture_num);
		map.put("id", id);
		map.put("totalcomment", totalcomment);
		map.put("totalscore", totalscore);
		
		getSqlSession().insert("LectureRating.insertLectureRating", map);
		
	}
	//////////////////////////////////////////////////////////////////////////////////////////////
	// 교수가 선택한 과목의 강의평가에서 총점 가져오기
	public int getLectureRatingScore(int lecture_num) {
		int average = getSqlSession().selectOne("LectureRating.getLectureRatingScore", lecture_num);
		
		return average;
	}
	
	// 교수가 선택한 과목의 강의평가에서 총점 가져오기
	public List<LectureRatingDTO> getLectureRatingComment(int lecture_num) {
		List<LectureRatingDTO> list = getSqlSession().selectList("LectureRating.getLectureRatingComment", lecture_num);

		return list;
	}
		
		
		
		
}
