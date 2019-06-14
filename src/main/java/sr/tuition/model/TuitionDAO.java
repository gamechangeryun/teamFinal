package sr.tuition.model;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

@Component
public class TuitionDAO extends SqlSessionDaoSupport{

		
	//납부자 미납자 조회
	public List<TuitionDTO> inputList(JoinDTO jdto)throws Exception{
		System.out.println("dao에서 jdto:"+jdto);
		List<TuitionDTO> list = getSqlSession().selectList("tuition.Input", jdto);
		System.out.println("dao : "+ list);
		return list;
	}
	
	//카운트수
	public int count()throws Exception{
		return getSqlSession().selectOne("tuition.Count");
	}
	
	//학과 리스트
	public List<TemperDTO> allList()throws Exception{
		return getSqlSession().selectList("tuition.temperList");
	}

}
