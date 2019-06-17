package mi.gra.board.service;

import java.util.List;

import mi.gra.board.model.graDTO;

public interface graService {
	
	public List<graDTO> getList(int startRow, int endRow);	// 글 목록 가져오기
	public List<graDTO> getSearchList(int options, String searchContent, int startRow, int endRow);	// 서치된 글 목록 가져오기
	public int searchCount(int options, String searchContent);	// 서치된 글의 개수 가져오기
	public int count();	// 글의 개수 가져오기
	
	
}
