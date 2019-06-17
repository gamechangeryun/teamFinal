package mi.hw.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mi.hw.board.model.hwDAO;
import mi.hw.board.model.hwDTO;


@Service
public class hwServiceImpl implements mi.hw.board.service.hwService {
   
	@Autowired
	private hwDAO dao;   

	public void setDao(hwDAO dao) { 
		this.dao = dao;
	}

	// mainPage에 글 정보 찾아오기
	@Override
	public List<hwDTO> getList(int startRow, int endRow) {
		List<hwDTO> list = dao.getList(startRow, endRow);
		return list;
	}

	// 서치된 글 목록 가져오기
	@Override
	public List<hwDTO> getSearchList(int options, String searchContent, int startRow, int endRow) {
		List<hwDTO> list = dao.getSearchList(options, searchContent, startRow, endRow);
		return list;
	}

	// 글 추가하기
	@Override
	public void insertContent(hwDTO dto) {
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
	public hwDTO detailContent(int num) {
		hwDTO dto = dao.detailContent(num);
		return dto;
	}

	// 글 상세하게 찾아오기
	@Override
	public hwDTO updateContentInfo(int num) {
		hwDTO dto = dao.updateContentInfo(num);
		return dto;
	}

	// 글 수정하기
	@Override
	public void updateContent(hwDTO dto) {
		
		dao.updateContent(dto);
		
	}
	
	// 제출 확인하기
	@Override
	public hwDTO hwsubon(int num) {
		
		hwDTO dto = dao.hwsubon(num);
		return dto;
	}

	// 글 삭제하기
	@Override
	public void deleteContent(int num) {
		dao.deleteContent(num);
		
	}

	// 파일업로드
	@Override
	public void Fileupload(hwDTO dto) {
		dao.Fileupload(dto);
		
	}  

	// 글 수정 파일 업로드
	@Override
	public void ChangeFileupload(hwDTO dto) {
		dao.ChangeFileupload(dto);
		
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
	
	// 글의 개수 가져오기
	@Override
	public int count() {
		int count = dao.count();
		return count;
	}
}