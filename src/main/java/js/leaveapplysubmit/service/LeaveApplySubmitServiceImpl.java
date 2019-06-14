package js.leaveapplysubmit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import js.leaveapplysubmit.model.LeaveApplySubmitDAO;
import js.leaveapplysubmit.model.LeaveApplySubmitDTO;

@Service
public class LeaveApplySubmitServiceImpl implements LeaveApplySubmitService{

	@Autowired
	private LeaveApplySubmitDAO dao;

	public void setDao(LeaveApplySubmitDAO dao) {
		this.dao = dao;
	}
	
	// 휴학생 테이블에서 휴학생 있는지 확인
	@Override
	public int checkLeaveStudent(int id) {
		
		int check = dao.checkLeaveStudent(id);
		
		return check;
	}
	
	// 휴학신청 리스에 있는지 확인
	@Override
	public int checkLeaveApply(int id) {
		
		int check = dao.checkLeaveApply(id);
		
		return check;
	}

	// 휴학신청서 작성
	@Override
	public void insertLeaveApply(LeaveApplySubmitDTO dto) {
		dao.insertLeaveApply(dto);
	}
	
	////////////////////////////////////////////////////////////////
	// 휴학신청리스트 가져오기
	@Override
	public List<LeaveApplySubmitDTO> getLeaveApplyList(int startRow, int endRow) {
		
		List<LeaveApplySubmitDTO> list = dao.getLeaveApplyList(startRow, endRow);
		
		return list;
	}
	
	// 서치된 글 목록 가져오기
	@Override
	public List<LeaveApplySubmitDTO> getSearchList(int options, String searchContent, int startRow, int endRow) {

		List<LeaveApplySubmitDTO> list = dao.getSearchList(options, searchContent, startRow, endRow);

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
	
	///////////////////////////////////////////////////////////////////
	// 휴학생 테이블에 추가하기
	@Override
	public void insertLeaveStudent(LeaveApplySubmitDTO dto) {
		dao.insertLeaveStudent(dto);
	}
	///////////////////////////////////////////////////////////////////
	// 리스트 삭제
	@Override
	public void deleteLeaveApply(int id) {
		dao.deleteLeaveApply(id);
	}
	///////////////////////////////////////////////////////////////////
	// 휴학생리스트 가져오기
	@Override
	public List<LeaveApplySubmitDTO> getLeaveStudentList(int startRow, int endRow) {
		
		List<LeaveApplySubmitDTO> list = dao.getLeaveStudentList(startRow, endRow);
		
		return list;
	}
	
	// 서치된 휴학생 목록 가져오기
	@Override
	public List<LeaveApplySubmitDTO> getLeaveStudentSearchList(int options, String searchContent, int startRow, int endRow) {

		List<LeaveApplySubmitDTO> list = dao.getLeaveStudentSearchList(options, searchContent, startRow, endRow);

		return list;
	}

	// 휴학생 인원수 가져오기
	@Override
	public int LeaveStudentCount() {

		int count = dao.LeaveStudentCount();

		return count;
	}

	// 서치된 휴학생 인원수 가져오기
	@Override
	public int LeaveStudentSearchCount(int options, String searchContent) {

		int searchCount = dao.LeaveStudentSearchCount(options, searchContent);

		return searchCount;
	}
	
	
	
	
	
	
}
