package sr_model;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

@Component("requestDAO")
public class requestDAO extends SqlSessionDaoSupport{

	//카운트
	public int count()throws Exception{
		return getSqlSession().selectOne("Mtmapper.requestCount");
	}
	
	//신청자 목록
	public List<requestDTO> requestAll(int num)throws Exception{
		return getSqlSession().selectList("Mtmapper.requestAll", num);
	}
	
	//신청자 삽입
	public int requestInsert(requestDTO res)throws Exception{
		return getSqlSession().insert("Mtmapper.requestInsert", res);
	}
	
	//신청자 삭제
	public int requestDelete(int id)throws Exception{
		return getSqlSession().delete("Mtmapper.requestDelete", id);
	}
}
