package js.totalscore.model;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import js.semesterscore.model.SemesterScoreDTO;

public class TotalScoreDAO extends SqlSessionDaoSupport{

	// 학기별성적 테이블에서 학기 개수 가져오기
	public int countSemester(int id) {
		
		int countSemester = getSqlSession().selectOne("totalScore.countSemester", id);
		
		return countSemester;
	}
	
	// 이수학점들과 학기평점들을 가져오기
	public List<SemesterScoreDTO> getSemesterInfo(int id) {
		
		List<SemesterScoreDTO> getSemesterInfo = getSqlSession().selectList("totalScore.getSemesterInfo", id);
		
		return getSemesterInfo;
	}
	
	// 총학기성적 테이블에 현재 아이디의 데이터가 저장되어 있는지 확인
	public int getTotalScoreInfo(int id) {
		
		int check = getSqlSession().selectOne("totalScore.getTotalScoreInfo", id);
		
		return check;
	}
	
	// 총학기 성적 테이블에 입력
	public void insertTotalScore(TotalScoreDTO dto) {
		getSqlSession().insert("totalScore.insertTotalScore", dto);
	}
	
	// 총학기 성적 테이블 수정
	public void updateTotalScore(TotalScoreDTO dto) {
		getSqlSession().update("totalScore.updateTotalScore", dto);
	}
	//////////////////////////////////////////////////////////////////////////////////////
	// 총학기 성적 테이블의 데이터 가져오기
	public TotalScoreDTO getTotalScore(int id) {
		
		TotalScoreDTO dto = getSqlSession().selectOne("totalScore.getTotalScore", id);
		
		return dto;
	}
}
