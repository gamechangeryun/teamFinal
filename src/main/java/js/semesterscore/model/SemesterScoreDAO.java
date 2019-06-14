package js.semesterscore.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;


public class SemesterScoreDAO extends SqlSessionDaoSupport{

	// 학기 가져오기
	public List<String> semesters() {
		
		List<String> semesters = getSqlSession().selectList("semesterScore.getSemester");
		
		return semesters;
	}
	
	// 수강리스트에서 강의번호를 뽑아와서 강의리스트에서 조회
	public List<SemesterScoreDTO> dataList(String semester, int id) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("semester", semester);
		map.put("id", id);
		
		List<SemesterScoreDTO> dataList = getSqlSession().selectList("semesterScore.dateList", map);

		return dataList;
	}

	// 성적가져오기
	public List<Integer> score(List<Integer> lecture_num, int id) {
		
		List<Integer> score = new ArrayList<Integer>();
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("id", id);
		
		for(int i=0; i<lecture_num.size(); i++) {
			map.put("lecture_num", lecture_num.get(i));
			score.add(getSqlSession().selectOne("semesterScore.score", map));
		}
		
		return score;
	}
	
	// 학기별 성적 테이블에 해당 아이디와 학기로 저장된 데이터가 없는지 확인
	public int selectSemesterScore(int id, String semester) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("semester", semester);
		
		int check = getSqlSession().selectOne("semesterScore.selectSemesterCheck", map);
		
		return check;
	}
		
	// 학기별성적테이블에 값 넣기
	public void semesterscore(int id, String semester, int semesterpoint, int semesteraverage) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("semester", semester);
		map.put("semesterpoint", semesterpoint);
		map.put("semesteraverage", semesteraverage);
		
		getSqlSession().insert("semesterScore.semesterscore", map);
		
	}

}
