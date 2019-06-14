package js.totalscore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import js.semesterscore.model.SemesterScoreDTO;
import js.totalscore.model.TotalScoreDAO;
import js.totalscore.model.TotalScoreDTO;

@Service
public class TotalScoreServiceImpl implements TotalScoreService{

	@Autowired
	private TotalScoreDAO dao;

	public void setDao(TotalScoreDAO dao) {
		this.dao = dao;
	}
	
	// 학기별성적 테이블에서 학기 개수 가져오기
	@Override
	public int countSemester(int id) {
		
		int countSemester = dao.countSemester(id);
		
		return countSemester;
	}
	
	// 이수학점들과 학기평점들을 가져오기
	@Override
	public List<SemesterScoreDTO> getSemesterInfo(int id) {
		
		List<SemesterScoreDTO> getSemesterInfo = dao.getSemesterInfo(id);
		
		return getSemesterInfo;
	}
	
	// 총학기성적 테이블에 현재 아이디의 데이터가 저장되어 있는지 확인
	@Override
	public int getTotalScoreInfo(int id) {
		
		int check = dao.getTotalScoreInfo(id);
		
		return check;
	}

	// 총학기 성적 테이블에 입력
	@Override
	public void insertTotalScore(TotalScoreDTO dto) {
		dao.insertTotalScore(dto);
	}
	
	// 총학기 성적 테이블 수정
	@Override
	public void updateTotalScore(TotalScoreDTO dto) {
		dao.updateTotalScore(dto);
	}

	////////////////////////////////////////////////////////////////
	
	// 총학기 성적 테이블의 데이터 가져오기
	@Override
	public TotalScoreDTO getTotalScore(int id) {
	
		TotalScoreDTO dto = dao.getTotalScore(id);
		
		return dto;
	}
	
	
	
	
	
	
	
}
