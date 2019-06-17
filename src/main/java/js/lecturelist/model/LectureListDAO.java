package js.lecturelist.model;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class LectureListDAO extends SqlSessionDaoSupport{

	// 강의리스트 꺼내오기
	public List<LectureListDTO> getLectureList(int id) {
		
		List<LectureListDTO> list = getSqlSession().selectList("lectureList.getLectureList", id);
		
		return list;
	}
	
}
