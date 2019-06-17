package sr.attend.model;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

@Component
public class AttenDAO extends SqlSessionDaoSupport{
	
	//전체목록조회
	public List<AttenDTO> allList(int id)throws Exception{
		List<AttenDTO> li = getSqlSession().selectList("atten.allList", id);
		return li;
	}
	
	//강의번호에 맞는 학생들 조회
	public List<AttenDTO> idList(int n)throws Exception{
		return getSqlSession().selectList("atten.lecturelist", n);
	}
	
	//출석부 입력
	public void attenInsert(AttenDTO dto)throws Exception{
		getSqlSession().insert("atten.Insert", dto);
	}
	
	public List<AttenDTO> studentList(int n) throws Exception {
		return getSqlSession().selectList("atten.studentInfo", n);
	}
	
	//학생이 출결 체크
	public List<AttenDTO> daycheck(int id) throws Exception{
		return getSqlSession().selectList("atten.daycheck", id);
	}
	
	//출석체크
	public void attenCheck(AttenDTO dto)throws Exception{
		getSqlSession().update("atten.check", dto);
	}
}
