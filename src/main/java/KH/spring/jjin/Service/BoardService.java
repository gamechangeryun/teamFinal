package KH.spring.jjin.Service;

import java.util.List;

import org.springframework.ui.Model;

import KH.spring.jjin.DTO.BoardDTO;

public interface BoardService {
	
		public void deleteFile(String fullName);	//첨부파일 삭제
		public List<String> getAttach(int bno);		//첨부파일 목록
		public void addAttach(String fullName);		//첨부파일 저장
		public void updateAttach(String fullName,int bno);	//펌부파일 수정
		public void create(BoardDTO dto) throws Exception;	//글쓰기
		public BoardDTO read(int bno) throws Exception;		//글읽기
		public void update(BoardDTO dto) throws Exception;	//글수정
		public void delete(int bno) throws Exception;		//글삭제
		//
		public List<BoardDTO> listAll(int start,int end	) throws Exception;
//
		public void increaseViewcnt(int bno) throws Exception;
		/*public void increaseViewcnt(int bno,) throws Exception;*/
		
public void increaseSweet(BoardDTO dto) throws Exception;
		//		
		public int countArticle()throws Exception;
		
		


}
