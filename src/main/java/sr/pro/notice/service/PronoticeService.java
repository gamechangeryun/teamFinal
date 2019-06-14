package sr.pro.notice.service;

import java.util.List;

import sr.pro.notice.model.PronoticeDTO;

public interface PronoticeService {
	public List<PronoticeDTO> getList(int startRow, int endRow);	// 글 목록 가져오기
	public List<PronoticeDTO> getSearchList(int options, String searchContent, int startRow, int endRow);	// 서치된 글 목록 가져오기
	public int count();	// 글의 개수 가져오기
	public int searchCount(int options, String searchContent);	// 서치된 글의 개수 가져오기
	public void insertContent(PronoticeDTO dto);	// 글 추가하기
	public PronoticeDTO detailContent(int num);	// 글 상세하게 찾아오기
	public PronoticeDTO updateContentInfo(int num);	// 수정할 글의 정보 가져오기
	public void updateContent(PronoticeDTO dto);	// 글 수정하기
	public void deleteContent(int num);	// 글 삭제하기
	
}
