package js.guestinput.service;

import java.util.List;

import js.guestinput.model.GuestInputDTO;
import js.noticeboard.model.StorageDTO;

public interface GuestInputService {
	public void insertGuestInput(GuestInputDTO dto);	// 게스트 글 쓰기 허용
	public void Fileupload(StorageDTO dto);	// 파일업로드
	////////////////////////////////////////////////////////////////////
	public List<GuestInputDTO> getList(int startRow, int endRow);	// 글 목록 가져오기
	public List<GuestInputDTO> getSearchList(int options, String searchContent, int startRow, int endRow);	// 서치된 글 목록 가져오기
	public int count();	// 글의 개수 가져오기
	public int searchCount(int options, String searchContent);	// 서치된 글의 개수 가져오기
	////////////////////////////////////////////////////////////////////
	public GuestInputDTO detailContent(int num);	// 글 상세하게 찾아오기, 허용버튼을 눌렀을 때 한번 더 사용
	public String getFileName(int num);		// 다운받을 파일이름 가져오기
	public String FileDownload(int num);	// 다운받을 파일경로 가져오기
	/////////////////////////////////////////////////////////////////////
}
