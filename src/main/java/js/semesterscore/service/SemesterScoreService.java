package js.semesterscore.service;

import java.util.List;

import js.semesterscore.model.SemesterScoreDTO;

public interface SemesterScoreService {
	public List<String> semesters();	// 학기 가져오기
	public List<SemesterScoreDTO> dataList(String semester, int id);	// 수강리스트에서 강의번호를 뽑아와서 강의리스트에서 조회
	public List<Integer> score(List<Integer> lecture_num, int id);	// 성적가져오기
	public int selectSemesterScore(int id, String semester);	// 학기별 성적 테이블에 해당 아이디와 학기로 저장된 데이터가 없는지 확인
	public void semesterscore(int id, String semester, int semesterpoint, int semesteraverage);	// 학기별 성적 테이블에 학기와 학기 평점 등록하기
}
