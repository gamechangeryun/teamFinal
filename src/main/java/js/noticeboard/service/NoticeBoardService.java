package js.noticeboard.service;

import java.util.List;

import js.noticeboard.model.NoticeBoardDTO;
import js.noticeboard.model.StorageDTO;

public interface NoticeBoardService {
	public List<NoticeBoardDTO> getList(int startRow, int endRow);	// 글 목록 가져오기
	public List<NoticeBoardDTO> getSearchList(int options, String searchContent, int startRow, int endRow);	// 서치된 글 목록 가져오기
	public int count();	// 글의 개수 가져오기
	public int searchCount(int options, String searchContent);	// 서치된 글의 개수 가져오기
	///////////////////////////////////////////////////////////////////////////////////////////////////
	public void insertContent(NoticeBoardDTO dto);	// 글 추가하기
	public void Fileupload(StorageDTO dto);	// 파일업로드
	//////////////////////////////////////////////////////////////////////////////////////////////////
	public NoticeBoardDTO detailContent(int num);	// 글 상세하게 찾아오기
	public String getFileName(int num);		// 다운받을 파일이름 가져오기
	public String FileDownload(int num);	// 다운받을 파일경로 가져오기
	/////////////////////////////////////////////////////////////////////////////////////////////////
	public NoticeBoardDTO updateContentInfo(int num);	// 수정할 글의 정보 가져오기
	public void updateContent(NoticeBoardDTO dto);	// 글 수정하기
	public void ChangeFileupload(StorageDTO dto);	// 파일업로드
	//////////////////////////////////////////////////////////////////////////////////////////////////
	public void deleteContent(int num);	// 글 삭제하기
}
