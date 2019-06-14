package KH.spring.jjin.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import KH.spring.jjin.DTO.BoardDTO;
@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	SqlSession sqlSession;
	 
	
	@Override
	public void deleteFile(String fullName) {
		// TODO Auto-generated method stub

	}
	@Override
	public List<String> getAttach(int bno) {
		
		return sqlSession.selectList("board.getAttach",bno);
	}

	@Override
	public void addAttach(String fullName) {
sqlSession.insert("board.addAttach",fullName);
	}

	@Override
	public void updateAttach(String fullName, int bno) {
Map<String,Object> map=new HashMap<>();
map.put("fullName",fullName);
map.put("bno",bno);
sqlSession.insert("board.updateAttach",map);
	}

	@Override
	public void create(BoardDTO dto) throws Exception {
sqlSession.insert("board.insert",dto);
	}

	@Override
	public BoardDTO read(int bno) throws Exception {
		return sqlSession.selectOne("board.view",bno);
	}

	@Override
	public void update(BoardDTO dto) throws Exception {
sqlSession.update("board.updateArticle",dto);
	}

	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete("board.deleteArticle",bno);
	}

	//게시물목록
	@Override
	public List<BoardDTO> listAll(int start, int end) throws Exception {
Map<String,Object> map=new HashMap<>();
map.put("start",start);
map.put("end",end);
//mapper에는 2개 이상의 값을 전달할 수 없음 (dto 또는 map사용)
		return sqlSession.selectList("board.listAll",map);
	}

	@Override
	public void increaseViewcnt(int bno) throws Exception {
sqlSession.update("board.increaseViewcnt",bno);
	}
	@Override
	public void increaseSweet(BoardDTO dto) throws Exception {
sqlSession.update("board.increaseSweet",dto);		
	}

	@Override
	public int countArticle() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("board.countArticle");
	}


}
