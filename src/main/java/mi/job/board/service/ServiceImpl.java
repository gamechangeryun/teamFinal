package mi.job.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mi.job.board.model.DAO;
import mi.job.board.model.DTO;


@Service
public class ServiceImpl implements mi.job.board.service.Service {
   
	@Autowired
	private DAO dao;   

	public void setDao(DAO dao) { 
		this.dao = dao;
	}

	// mainPage에 글 정보 찾아오기
	@Override
	public List<DTO> getList(int startRow, int endRow) {
		List<DTO> list = dao.getList(startRow, endRow);
		return list;
	}

	// 서치된 글 목록 가져오기
	@Override
	public List<DTO> getSearchList(int options, String searchContent, int startRow, int endRow) {
		List<DTO> list = dao.getSearchList(options, searchContent, startRow, endRow);
		return list;
	}

	// 글 추가하기
	@Override
	public void insertContent(DTO dto) {
		dao.insertContent(dto);
		
	}
	
	// 서치된 글의 개수 가져오기
		@Override
		public int searchCount(int options, String searchContent) {
			
			int searchCount = dao.searchCount(options, searchContent);
			
			return searchCount;
		}

	// 글 상세하게 찾아오기
	@Override
	public DTO detailContent(int num) {
		DTO dto = dao.detailContent(num);
		return dto;
	}

	// 글 상세하게 찾아오기
	@Override
	public DTO updateContentInfo(int num) {
		DTO dto = dao.updateContentInfo(num);
		return dto;
	}

	// 글 수정하기
	@Override
	public void updateContent(DTO dto) {
		
		dao.updateContent(dto);
		
	}

	// 글 삭제하기
	@Override
	public void deleteContent(int num) {
		dao.deleteContent(num);
		
	}

	// 파일업로드
	@Override
	public void Fileupload(DTO dto) {
		dao.Fileupload(dto);
		
	}  

	// 글 수정 파일 업로드
	@Override
	public void ChangeFileupload(DTO dto) {
		dao.ChangeFileupload(dto);
		
	}  

	// 다운받을 파일의 이름 가져오기
	@Override
	public String getFileName(int num) {
		String fileName = dao.getFileName(num);
		return fileName;
	}
	
	// 다운받을 파일의 경로이름 가져오기
		@Override
		public String getFileFakename(int num) {
			String fileFakename = dao.getFileFakename(num);
			return fileFakename;
		}

	// 다운받을 파일의 경로 가져오기
	@Override
	public String FileDownload(int num) {
		
		String filePath = dao.FileDownload(num);
		return filePath;
	}
	
	// 글의 개수 가져오기
	@Override
	public int count() {
		int count = dao.count();
		return count;
	}
}