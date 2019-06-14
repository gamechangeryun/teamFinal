package js.scholarship.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class ScholarshipDAO extends SqlSessionDaoSupport{
	
	// 장학금 내역 가져오기
	public List<ScholarshipDTO> getScholarship(int startRow, int endRow) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		
		List<ScholarshipDTO> list= getSqlSession().selectList("scholarship.getScholarship", map);
		
		return list;
	}
	
	// 글의 개수 가져오기
	public int count() {
					
		int count = getSqlSession().selectOne("scholarship.countContent");
				
		return count;
	}
	
	// 학과별 장학금 내역 가져오기
	public List<ScholarshipDTO> getScholarshipSelect(int temper_num, int startRow, int endRow) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("temper_num", temper_num);
		map.put("startRow", startRow);
		map.put("endRow", endRow);
					
		List<ScholarshipDTO> list = getSqlSession().selectList("scholarship.getScholarshipSelect", map);
					
		return list;
	}
}
