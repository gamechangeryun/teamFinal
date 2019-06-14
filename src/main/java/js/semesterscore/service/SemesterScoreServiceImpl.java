package js.semesterscore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import js.semesterscore.model.SemesterScoreDAO;
import js.semesterscore.model.SemesterScoreDTO;

@Service
public class SemesterScoreServiceImpl implements SemesterScoreService{

	@Autowired
	private SemesterScoreDAO dao;

	public void setDao(SemesterScoreDAO dao) {
		this.dao = dao;
	}
	
	// 학기 가져오기
	@Override
	public List<String> semesters() {

		List<String> semesters = dao.semesters();
		
		return semesters;
	}
	
	// 수강리스트에서 강의번호를 뽑아와서 강의리스트에서 조회
	@Override
	public List<SemesterScoreDTO> dataList(String semester, int id) {
		
		List<SemesterScoreDTO> dataList = dao.dataList(semester, id);
		
		return dataList;
	}
	
	// 성적가져오기
	@Override
	public List<Integer> score(List<Integer> lecture_num, int id) {
		
		List<Integer> score = dao.score(lecture_num, id);
		
		return score;
	}
	
	// 학기별 성적 테이블에 해당 아이디와 학기로 저장된 데이터가 없는지 확인
	@Override
	public int selectSemesterScore(int id, String semester) {
		
		int check = dao.selectSemesterScore(id, semester);
		
		return check;
	}

	// 학기별성적테이블에 값 넣기
	@Override
	public void semesterscore(int id, String semester, int semesterpoint, int semesteraverage) {
		dao.semesterscore(id, semester, semesterpoint, semesteraverage);
	}
	
	
	
	
	
	
	
	
}
