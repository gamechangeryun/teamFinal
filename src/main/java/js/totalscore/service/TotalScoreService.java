package js.totalscore.service;

import java.util.List;

import js.semesterscore.model.SemesterScoreDTO;
import js.totalscore.model.TotalScoreDTO;

public interface TotalScoreService {
	public int countSemester(int id);	// 학기별성적 테이블에서 학기 개수 가져오기
	public List<SemesterScoreDTO> getSemesterInfo(int id);	// 이수학점들과 학기평점들을 가져오기
	public int getTotalScoreInfo(int id);	// 총학기성적 테이블에 현재 아이디의 데이터가 저장되어 있는지 확인
	public void insertTotalScore(TotalScoreDTO dto);	// 총학기 성적 테이블에 입력
	public void updateTotalScore(TotalScoreDTO dto);	// 총학기 성적 테이블 수정
	//////////////////////////////////////////////////////////////////////////
	public TotalScoreDTO getTotalScore(int id);			// 총학기 성적 테이블의 데이터 가져오기
}
