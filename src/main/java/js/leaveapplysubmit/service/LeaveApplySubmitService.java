package js.leaveapplysubmit.service;

import java.util.List;

import js.leaveapplysubmit.model.LeaveApplySubmitDTO;

public interface LeaveApplySubmitService {
	public int checkLeaveStudent(int id);	// 휴학생테이블에 있는지 확인
	public int checkLeaveApply(int id);		// 휴학신청리스트에 있는지 확인
	public void insertLeaveApply(LeaveApplySubmitDTO dto);	// 휴학신청서 작성
	/////////////////////////////////////////////////////////////////////
	public List<LeaveApplySubmitDTO> getLeaveApplyList(int startRow, int endRow);	// 휴학신청리스트 가져오기
	public List<LeaveApplySubmitDTO> getSearchList(int options, String searchContent, int startRow, int endRow);	// 서치된 글 목록 가져오기
	public int count();	// 글의 개수 가져오기
	public int searchCount(int options, String searchContent);	// 서치된 글의 개수 가져오기
	//////////////////////////////////////////////////////////////////////
	public void insertLeaveStudent(LeaveApplySubmitDTO dto);	// 휴학생 테이블에 추가하기
	//////////////////////////////////////////////////////////////////////
	public void deleteLeaveApply(int id);	// 신청리스트 삭제
	//////////////////////////////////////////////////////////////////////
	public List<LeaveApplySubmitDTO> getLeaveStudentList(int startRow, int endRow);	// 휴학생리스트 가져오기
	public List<LeaveApplySubmitDTO> getLeaveStudentSearchList(int options, String searchContent, int startRow, int endRow);	// 서치된 휴학생 목록 가져오기
	public int LeaveStudentCount();	// 휴학생 인원수 가져오기
	public int LeaveStudentSearchCount(int options, String searchContent);	// 서치된 휴학생 인원수 가져오기
	
	
}
