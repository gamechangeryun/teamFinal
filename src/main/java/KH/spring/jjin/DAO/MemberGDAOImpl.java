package KH.spring.jjin.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import KH.spring.jjin.DTO.MemberGDTO;




@Repository
public class MemberGDAOImpl implements MemberGDAO {
private static final Logger logger=LoggerFactory.getLogger(MemberGDAOImpl.class);
	
@Autowired
SqlSession sqlSession;

@Override
	public List<MemberGDTO> memberList() {
	System.out.println(sqlSession);
	return sqlSession.selectList("member.memberList");
	
	}

	@Override
	public void insertMember(MemberGDTO vo) {
		sqlSession.insert("member.insertMember",vo);
	}

	@Override
	public MemberGDTO viewMember(String id) {
		return sqlSession.selectOne("member.viewMember",id);
	} 

	@Override
	public void deleteMember(String id) {
		sqlSession.delete("member.deleteMember",id);
	}

	@Override
	public void updateMember(MemberGDTO vo) {
		sqlSession.update("member.updateMember",vo);
	}

	@Override
	public boolean checkPw(String id) {
		boolean result=true; 
		/*
		 * Map<String,String> map =new HashMap<>(); map.put("userid", userid);
		 * map.put("password",password); int
		 * count=sqlSession.selectOne("member.checkPw",map); if(count==1) result=true;
		 */
		return result;
	}


}
