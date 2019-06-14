package js.lectureapply.service;

import java.util.List;

import js.lectureapply.model.LectureApplyDTO;

public interface LectureApplyService {
	public void insertLecture(LectureApplyDTO dto);	// 강의개설신청서 작성
	//////////////////////////////////////////////////////////////////
	public List<LectureApplyDTO> getList(int startRow, int endRow);	// 글 목록 가져오기
	public List<LectureApplyDTO> getSearchList(int options, String searchContent, int startRow, int endRow);	// 서치된 글 목록 가져오기
	public int count();	// 글의 개수 가져오기
	public int searchCount(int options, String searchContent);	// 서치된 글의 개수 가져오기
	//////////////////////////////////////////////////////////////////
	public int getLecture_num(int nowId);	// 학과번호 가져오기
	public int lectureApplySubmit(LectureApplyDTO dto);	// 강의개설신청 허용
	//////////////////////////////////////////////////////////////////
	public void lectureApplyRefuse(int id, String lecture_title);	// 강의개설거절되면 해당 리스트 삭제
}
