package sr.changescoreinput.model;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import sr.scoreinput.model.ScoreinputDTO;

@Component("ChangescoreinputDAO")
public class ChangescoreinputDAO extends SqlSessionDaoSupport{
	
	@Resource
	public void setSqlSEssionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	//리스트불러오기
	public List<ChangescoreinputDTO> allList()throws Exception{
		return getSqlSession().selectList("changescore.allList");
	}
	
	//성적정정사유입력
	public void reasonInsert(ChangescoreinputDTO dto)throws Exception{
		getSqlSession().insert("changescore.insert", dto);
	}
	
	//기각
	public void changeDelete(ChangescoreinputDTO dto)throws Exception{
		getSqlSession().delete("changescore.delete", dto);
	}
	
	//성적수정 다른테이블
	public void scoreUpdate(ScoreinputDTO dto)throws Exception{
		getSqlSession().update("changescore.scoreUpdate", dto);
	}
}
