package mi.gra.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mi.gra.board.model.graDAO;
import mi.gra.board.model.graDTO;

@Service
public class graServiceImpl implements mi.gra.board.service.graService {

	@Autowired
	private graDAO dao;
	
	public void setDao(graDAO dao) {
		this.dao = dao;
	}
	
	// mainPage에 글 정보 찾아오기
		@Override
		public List<graDTO> getList(int startRow, int endRow) {
			
			List<graDTO> list = dao.getList(startRow, endRow);
			
			return list;
		}
		
		// 서치된 글 목록 가져오기
		@Override
		public List<graDTO> getSearchList(int options, String searchContent) {
			    
			List<graDTO> list = dao.getSearchList(options, searchContent);
			
			return list;    
		}
		
		// 글의 개수 가져오기
		@Override
		public int count() {
			int count = dao.count();
			return count;
		}
		
}
