package sr.scoreinput.model;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

@Component("scoreinputDAO")
public class ScoreinputDAO extends SqlSessionDaoSupport{
	//리스트
	public List<ScoreinputDTO> allList(int id)throws Exception{
		return getSqlSession().selectList("scoreinputMapper.allList", id);
	}
	
	//학생목록
	public List<ScoreinputDTO> snameList(String snum)throws Exception{
		System.out.println("학생목록 뽑으러 왔음" + snum);
		return getSqlSession().selectList("scoreinputMapper.sname", snum);
	}
	
	//성적입력
	public void inputScore(ScoreinputDTO dto)throws Exception{
		getSqlSession().insert("scoreinputMapper.inputscore", dto);
	}
		
}
