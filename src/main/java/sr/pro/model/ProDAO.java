package sr.pro.model;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

@Component("proDAO")
public class ProDAO extends SqlSessionDaoSupport{
	
	public ProDTO allList(int lecture_num)throws Exception{
		
		return getSqlSession().selectOne("proInfo.professorInfo", lecture_num);
	}
	
	public String picture(int id) {
		return getSqlSession().selectOne("proInfo.picture", id);
	}
	
}
