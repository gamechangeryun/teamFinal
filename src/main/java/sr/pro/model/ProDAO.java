package sr.pro.model;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

@Component("proDAO")
public class ProDAO extends SqlSessionDaoSupport{
	
	public List<ProDTO> allList()throws Exception{
		List<ProDTO> list = getSqlSession().selectList("");
		
		return list;
	}
	
	
}
