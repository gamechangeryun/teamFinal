package js.lectureapply.service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import js.lectureapply.model.LectureApplyDAO;
import js.lectureapply.model.LectureApplyDTO;

@Service
public class LectureApplyServiceImpl implements LectureApplyService{

	@Autowired
	private LectureApplyDAO dao;

	public void setDao(LectureApplyDAO dao) {
		this.dao = dao;
	}

	// 강의개설신청서 작성
	@Override
	public void insertLecture(LectureApplyDTO dto) {
		dao.insertLecture(dto);
	}
	/////////////////////////////////////////////////////////////////
	// mainPage에 글 정보 찾아오기
	@Override
	public List<LectureApplyDTO> getList(int startRow, int endRow) {

		List<LectureApplyDTO> list = dao.getList(startRow, endRow);

		return list;
	}

	// 서치된 글 목록 가져오기
	@Override
	public List<LectureApplyDTO> getSearchList(int options, String searchContent, int startRow, int endRow) {

		List<LectureApplyDTO> list = dao.getSearchList(options, searchContent, startRow, endRow);

		return list;
	}

	// 글의 개수 가져오기
	@Override
	public int count() {

		int count = dao.count();

		return count;
	}

	// 서치된 글의 개수 가져오기
	@Override
	public int searchCount(int options, String searchContent) {

		int searchCount = dao.searchCount(options, searchContent);

		return searchCount;
	}
	////////////////////////////////////////////////////////////////////////////////////////
	// 학과번호 가져오기
	@Override
	public int getLecture_num(int nowId) {

		String temper_num = dao.getTemper_num(nowId); // 학과번호 가져오기
		String getMaxNum = dao.getMaxNum(temper_num); // 가장 마지막 번호 두자리 가져오기

		// 만약, 마지막 번호가 null일 때 -> 0일때
		if (getMaxNum == null) {
			getMaxNum = "00";
		}

		String result = temper_num + getMaxNum;
		int temp = Integer.parseInt(result) + 1;

		return temp;
	}
		
	// 강의개설신청허용
	@Override
	public int lectureApplySubmit(LectureApplyDTO dto) {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String writedate = format.format(dto.getWritedate());
		String temp = writedate.substring(5, 7);
		
		int cast = Integer.parseInt(temp);
		
		temp = writedate.substring(0, 4);
		
		String semester = temp;
		
		if(cast <= 6) {
			semester += "년도 1학기";
		}else {
			semester += "년도 2학기";
		}
		
		dto.setSemester(semester);
		
		int check = dao.lectureApplySubmit(dto);
		
		return check;
	}
	/////////////////////////////////////////////////////////////////////////////////////////

	// 강의개설신청리스트에서 삭제하기
	@Override
	public void lectureApplyRefuse(int id, String lecture_title) {
		dao.lectureApplyRefuse(id, lecture_title);
	}
	
}
