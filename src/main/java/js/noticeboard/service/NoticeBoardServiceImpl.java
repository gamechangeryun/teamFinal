package js.noticeboard.service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import js.noticeboard.model.NoticeBoardDAO;
import js.noticeboard.model.NoticeBoardDTO;
import js.noticeboard.model.StorageDTO;

@Service
public class NoticeBoardServiceImpl implements NoticeBoardService{

	@Autowired
	private NoticeBoardDAO dao;

	public void setDao(NoticeBoardDAO dao) {
		this.dao = dao;
	}

	// mainPage에 글 정보 찾아오기
	@Override
	public List<NoticeBoardDTO> getList(int startRow, int endRow) {
			
		List<NoticeBoardDTO> list = dao.getList(startRow, endRow);
		
		return list;
	}

	// 서치된 글 목록 가져오기
	@Override
	public List<NoticeBoardDTO> getSearchList(int options, String searchContent, int startRow, int endRow) {
			
		List<NoticeBoardDTO> list = dao.getSearchList(options, searchContent, startRow, endRow);
			
		return list;
	}
	
	// 글의 개수 가져오기
	@Override
	public int count() {
			
		int count = dao.count();
			
		return count;
	}
	
	// 서치된 글의 개수 가져오기
	@Override
	public int searchCount(int options, String searchContent) {
		
		int searchCount = dao.searchCount(options, searchContent);
		
		return searchCount;
	}

	/////////////////////////////////////////////////////////////////////////////
	// 글 추가하기
	@Override
	public void insertContent(NoticeBoardDTO dto) {

		dao.insertContent(dto);
			
	}
	
	// 파일업로드
	@Override
	public void Fileupload(StorageDTO dto) {
			
		dao.Fileupload(dto);
			
	}
	//////////////////////////////////////////////////////////////////////////////////////
	// 글 상세하게 찾아오기
	@Override
	public NoticeBoardDTO detailContent(int num) {
			
		NoticeBoardDTO dto = dao.detailContent(num);
			
		return dto;
	}
	
	// 다운받을 파일의 이름 가져오기
	@Override
	public String getFileName(int num) {
				
		String fileName = dao.getFileName(num);

		return fileName;
	}

	// 다운받을 파일의 경로 가져오기
	@Override
	public String FileDownload(int num) {
				
		String filePath = dao.FileDownload(num);
				
		return filePath;
	}
	////////////////////////////////////////////////////////////////////////////////////////////
	// 글 상세하게 찾아오기
	@Override
	public NoticeBoardDTO updateContentInfo(int num) {
				
		NoticeBoardDTO dto = dao.updateContentInfo(num);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String temp = sdf.format(dto.getWritedate());
		dto.setWritedate(java.sql.Date.valueOf(temp));
		
		return dto;
	}
		
	// 글 수정하기
	@Override
	public void updateContent(NoticeBoardDTO dto) {
			
		dao.updateContent(dto);
			
	}
	
	// 글 수정 파일 업로드
	@Override
	public void ChangeFileupload(StorageDTO dto) {
			
		dao.ChangeFileupload(dto);
			
	}
	/////////////////////////////////////////////////////////////////////////////////////
	// 글 삭제하기
	@Override
	public void deleteContent(int num) {
		
		dao.deleteContent(num);
		
	}
	
	
}
