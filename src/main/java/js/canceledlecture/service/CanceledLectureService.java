package js.canceledlecture.service;

import java.util.List;

import js.canceledlecture.model.CanceledLectureDTO;
import js.lectureapply.model.LectureApplyDTO;

public interface CanceledLectureService {
	public List<LectureApplyDTO> getLectureList(int id);// 접속한 아이디의 강의리스트 찾아오기
	public void insertCanceledLecture(CanceledLectureDTO dto);	// 휴강신청 제출
	//////////////////////////////////////////////////////////////////////////////
	public List<CanceledLectureDTO> getCanceledList(int startRow, int endRow);	// 휴학신청리스트 가져오기
	public List<CanceledLectureDTO> getSearchList(int options, String searchContent, int startRow, int endRow);	// 서치된 글 목록 가져오기
	public int count();	// 글의 개수 가져오기
	public int searchCount(int options, String searchContent);	// 서치된 글의 개수 가져오기
	/////////////////////////////////////////////////////////////////////////////////
	public void insertCanceledList(CanceledLectureDTO dto);	//	휴강테이블에 추가
	public void deleteCanceleListSupply(int id);			// 휴강신청테이블에서 삭제
	//////////////////////////////////////////////////////////////////////////////
	public List<CanceledLectureDTO> getSubmitCanceledList(int id);	// 교수가 휴강리스트 확인하기
	
}
