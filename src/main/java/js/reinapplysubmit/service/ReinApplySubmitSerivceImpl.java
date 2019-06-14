package js.reinapplysubmit.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import js.reinapplysubmit.model.ReinApplySubmitDAO;
import js.reinapplysubmit.model.ReinApplySubmitDTO;

@Service
public class ReinApplySubmitSerivceImpl implements ReinApplySubmitService{
	
	@Autowired
	private ReinApplySubmitDAO dao;

	public void setDao(ReinApplySubmitDAO dao) {
		this.dao = dao;
	}
	
	// 휴학생에 현재 아이디가 있는지 확인
	@Override
	public int checkLeaveStudent(int id) {
		
		int check = dao.checkLeaveStudent(id);
		
		return check;
	}
	
	// 복학신청을 이미 한 아이디인지 확인
	@Override
	public int checkReinApplyList(int id) {
		
		int check = dao.checkReinApplyList(id);
		
		return check;
	}

	// 복학신청
	@Override
	public void insertReinApply(int id, Date startreindate) {
		dao.insertReinApply(id, startreindate);
	}
	///////////////////////////////////////////////////////////
	// 휴학신청리스트 가져오기
	@Override
	public List<ReinApplySubmitDTO> getReinApplyList(int startRow, int endRow) {

		List<ReinApplySubmitDTO> list = dao.getReinApplyList(startRow, endRow);

		return list;
	}

	// 서치된 글 목록 가져오기
	@Override
	public List<ReinApplySubmitDTO> getSearchList(int options, String searchContent, int startRow, int endRow) {

		List<ReinApplySubmitDTO> list = dao.getSearchList(options, searchContent, startRow, endRow);

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
	//////////////////////////////////////////////////////////////////////////
	
	// 복학허용
	@Override
	public void reinSubmit(int id) {
		dao.reinSubmit(id);
	}
	
	// 복학기각
	@Override
	public void reinRefus(int id) {
		dao.reinRefus(id);
	}
	
}
