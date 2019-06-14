package KH.spring.jjin.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import KH.spring.jjin.DTO.MemberGDTO;
import KH.spring.jjin.DTO.WolDTO;




@Repository
public class WolDAOImpl implements WolDAO {
private static final Logger logger=LoggerFactory.getLogger(WolDAOImpl.class);
	
@Autowired
SqlSession sqlSession;

@Override
	public List<WolDTO>  List() {
	
	return sqlSession.selectList("wol.List1");
	
	}

	public WolDTO view(String id) {
		return sqlSession.selectOne("wol.view",id);
	} 

	@Override
	public void update (WolDTO vo) {
		System.out.println(vo);
		sqlSession.update("wol.update",vo);
	}




}
