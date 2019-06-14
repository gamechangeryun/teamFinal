package sr.learn.model;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

@Component("LearnDAO")
public class LearnDAO extends SqlSessionDaoSupport{

	@Resource
	public void setSqlSEssionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	//시작 목록
	public List<LearnDTO> allList()throws Exception{
		
		return getSqlSession().selectList("LearnMapper.allList");
	}
	
	//종료버튼
	public void delete(LearnDTO dto) throws Exception{
		getSqlSession().delete("LearnMapper.delete", dto);
	}
	
	//현재단계 목록
	public List<LearnDTO> nowList(LearnDTO dto)throws Exception{
		return getSqlSession().selectList("LearnMapper.nowList", dto);
	}
	
	//단계추가
	public void addNow(LearnDTO dto)throws Exception{
		getSqlSession().update("LearnMapper.addNow", dto);
	}
	
	//단계감소
	public void disNow(LearnDTO dto)throws Exception{
		getSqlSession().update("LearnMapper.deleteNow", dto);
	}
	
	//내용입력
	public void learnInsert(LearnDTO dto)throws Exception{
		getSqlSession().insert("LearnMapper.learnInsert", dto);
	}
	
}
