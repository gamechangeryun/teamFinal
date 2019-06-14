package js.lecturerating.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import js.lectureapply.model.LectureApplyDTO;
import js.lecturerating.model.LectureRatingDAO;
import js.lecturerating.model.LectureRatingDTO;

@Service
public class LectureRatingServiceImpl implements LectureRatingService{

	@Autowired
	private LectureRatingDAO dao;

	public void setDao(LectureRatingDAO dao) {
		this.dao = dao;
	}
	
	// 강의리스트 가져오기
	@Override
	public List<LectureApplyDTO> getLectureList(int id) {

		List<LectureApplyDTO> lectureList = dao.getLectureList(id);
		
		return lectureList;
	}

	// 학생이 교수의 강의평가 하기
	@Override
	public void insertLectureRating(int lecture_num, int id, String totalcomment, int totalscore) {
		dao.insertLectureRating(lecture_num, id, totalcomment, totalscore);
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////
	
	// 교수가 선택한 과목의 강의평가에서 총점평균 가져오기
	@Override
	public int getLectureRatingScore(int lecture_num) {
		
		int average = dao.getLectureRatingScore(lecture_num);
		
		return average;
	}
	
	// 교수가 선택한 과목의 강의평가에서 코멘트들 가져오기
	@Override
	public List<LectureRatingDTO> getLectureRatingComment(int lecture_num) {
		
		List<LectureRatingDTO> list = dao.getLectureRatingComment(lecture_num);
		
		return list;
	}
	
	
	
	
	
	
}
