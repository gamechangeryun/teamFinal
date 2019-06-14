package js.lecturerating.service;

import java.util.List;

import js.lectureapply.model.LectureApplyDTO;
import js.lecturerating.model.LectureRatingDTO;

public interface LectureRatingService {
	public List<LectureApplyDTO> getLectureList(int id);	// id를 가지고 강의 리스트 가져오기
	public void insertLectureRating(int lecture_num, int id, String totalcomment, int totalscore);	// 학생이 교수의 강의평가 하기
	////////////////////////////////////////////////////////////////////////////////////////////////
	public int getLectureRatingScore(int lecture_num);	// 교수가 선택한 과목의 강의평가 가져오기
	public List<LectureRatingDTO> getLectureRatingComment(int lecture_num);	// 교수가 선택한 과목의 강의평가 가져오기
}
