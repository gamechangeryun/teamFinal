package js.reinapplysubmit.service;

import java.util.Date;
import java.util.List;

import js.reinapplysubmit.model.ReinApplySubmitDTO;

public interface ReinApplySubmitService {
	public int checkLeaveStudent(int id);	// 휴학생에 현재 아이디가 있는지 확인
	public int checkReinApplyList(int id);	// 이미 복학신청을 한 아이디인지 확인
	public void insertReinApply(int id, Date startreindate);	// 복학신청
	/////////////////////////////////////////////////////////////////////
	public List<ReinApplySubmitDTO> getReinApplyList(int startRow, int endRow);	// 휴학신청리스트 가져오기
	public List<ReinApplySubmitDTO> getSearchList(int options, String searchContent, int startRow, int endRow);	// 서치된 글 목록 가져오기
	public int count();	// 글의 개수 가져오기
	public int searchCount(int options, String searchContent);	// 서치된 글의 개수 가져오기
	///////////////////////////////////////////////////////////////////////
	public void reinSubmit(int id);		// 복학허용
	public void reinRefus(int id);		// 복학기각
}
