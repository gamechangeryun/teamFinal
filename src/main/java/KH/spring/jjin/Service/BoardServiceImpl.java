package KH.spring.jjin.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import KH.spring.jjin.DAO.BoardDAO;
import KH.spring.jjin.DTO.BoardDTO;
@Service
public class BoardServiceImpl implements BoardService {
@Autowired
BoardDAO boardDao;

	@Override
	public void deleteFile(String fullName) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<String> getAttach(int bno) {
		// TODO Auto-generated method stub
		return boardDao.getAttach(bno); 
	}

	@Override
	public void addAttach(String fullName) { 
		// TODO Auto-generated method stub

	}
	@Override
	public void updateAttach(String fullName, int bno) {
		// TODO Auto-generated method stub

	}

	@Override
	public void create(BoardDTO dto) throws Exception {
boardDao.create(dto);
	}

	@Override
	public BoardDTO read(int bno) throws Exception {
		return boardDao.read(bno);
	}
@Transactional
	@Override
	public void update(BoardDTO dto) throws Exception {
boardDao.update(dto);
String[] files=dto.getFiles();
System.out.println("Ã·ºÎÆÄÀÏ:"+files);
if(files==null) return;
for(String name: files) {
	boardDao.updateAttach(name, dto.getBno());
}
	}

	@Override
	public void delete(int bno) throws Exception {
boardDao.delete(bno);
	}

	@Override
	public List<BoardDTO> listAll(int start, int end) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.listAll(start,end);
	}

	@Override 
	public void increaseViewcnt(int bno/*HttpSession session*/) throws Exception {
boardDao.increaseViewcnt(bno);
	}
	@Override
	public void increaseSweet(BoardDTO dto) throws Exception {
boardDao.increaseSweet(dto);		
	} 

	@Override 
	public int countArticle() throws Exception {
		return boardDao.countArticle();
	}



}
