package js.canceledlecture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import js.canceledlecture.model.CanceledLectureDAO;
import js.canceledlecture.model.CanceledLectureDTO;
import js.lectureapply.model.LectureApplyDTO;

@Service
public class CanceledLectureServiceImpl implements CanceledLectureService{

	@Autowired
	private CanceledLectureDAO dao;

	public void setDao(CanceledLectureDAO dao) {
		this.dao = dao;
	}
	
	// 해당 아이디에 강의 리스트 받아오기
	@Override
	public List<LectureApplyDTO> getLectureList(int id) {
		
		List<LectureApplyDTO> list = dao.getLectureList(id);
		
		return list;
	}
	
	// 휴강신청 제출
	@Override
	public void insertCanceledLecture(CanceledLectureDTO dto) {
		dao.insertCanceledLecture(dto);
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////
	
	// 휴학신청리스트 가져오기
	@Override
	public List<CanceledLectureDTO> getCanceledList(int startRow, int endRow) {

		List<CanceledLectureDTO> list = dao.getCanceledList(startRow, endRow);

		return list;
	}

	// 서치된 글 목록 가져오기
	@Override
	public List<CanceledLectureDTO> getSearchList(int options, String searchContent, int startRow, int endRow) {

		List<CanceledLectureDTO> list = dao.getSearchList(options, searchContent, startRow, endRow);

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

	///////////////////////////////////////////////////////////////
	// 휴강테이블에 추가
	@Override
	public void insertCanceledList(CanceledLectureDTO dto) {
		dao.insertCanceledList(dto);
	}
	
	// 휴강신청테이블에서 삭제
	@Override
	public void deleteCanceleListSupply(int id) {
		dao.deleteCanceleListSupply(id);
	}
	///////////////////////////////////////////////////////////////
	// 교수가 휴강리스트 확인하기
	@Override
	public List<CanceledLectureDTO> getSubmitCanceledList(int id) {
		
		List<CanceledLectureDTO> list = dao.getSubmitCanceledList(id);
		
		return list;
	}
	
	
	
	
	
}
