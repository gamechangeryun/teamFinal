package mi.job.board.service;

import java.util.List;

import mi.job.board.model.DTO;

public interface Service {
	public List<DTO> getList(int startRow, int endRow);	// 글 목록 가져오기
	public List<DTO> getSearchList(int options, String searchContent);	// 서치된 글 목록 가져오기
	public void insertContent(DTO dto);	// 글 추가하기
	public DTO detailContent(int num);	// 글 상세하게 찾아오기, 수정에서 현재 정보를 보여주기 위해서 한번 더 사용
	public DTO updateContentInfo(int num);
	public void updateContent(DTO dto);	// 글 수정하기
	public void deleteContent(int num);	// 글 삭제하기
	public void Fileupload(DTO dto);	// 파일업로드
	public void ChangeFileupload(DTO dto);	// 파일업로드
	public String getFileName(int num);		// 다운받을 파일이름 가져오기
	public String FileDownload(int num);	// 다운받을 파일경로 가져오기
	public int count();	// 글의 개수 가져오기
	public String getFileFakename(int num);	// 다운받을 파일 경로이름 가져오기
	
}
    