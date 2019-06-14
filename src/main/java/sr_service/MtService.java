package sr_service;

import java.util.List;

import sr_model.MtFileDTO;
import sr_model.bdDTO;

public interface MtService {
	public List<bdDTO> getList(int startRow, int endRow);	// 글 목록 가져오기
	public List<bdDTO> getSearchList(int options, String searchContent, int startRow, int endRow);	// 서치된 글 목록 가져오기
	public int searchCount(int options, String searchContent); //서치된 글의 개수
	public int lastNum();	// 마지막 글의 번호 가져오기
	public int insertContent(bdDTO dto);	// 글 추가하기
	public bdDTO detailContent(int num);	// 글 상세하게 찾아오기, 수정에서 현재 정보를 보여주기 위해서 한번 더 사용
	public int updateContent(bdDTO dto);	// 글 수정하기
	public void deleteContent(int num);	// 글 삭제하기
	public int count();	// 글의 개수 가져오기
	
	//파일관련
	public int Fileupload(MtFileDTO dto);	// 파일업로드
	public int ChangeFileupload(MtFileDTO dto);	// 파일업로드
	public String getFileName(int num);		// 다운받을 파일이름 가져오기
	public String FileDownload(int num);	// 다운받을 파일경로 가져오기
}
