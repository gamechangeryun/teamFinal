package sr_service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import sr_model.MtDAO;
import sr_model.MtFileDTO;
import sr_model.bdDTO;

@Service
public class MtServiceImpl implements sr_service.MtService{
	
	@Autowired
	@Qualifier("mtDAO")
	private MtDAO dao;

	public void setDao(MtDAO dao) {
		this.dao = dao;
	}
	
	// mainPage에 글 정보 찾아오기
	@Override
	public List<bdDTO> getList(int startRow, int endRow) {
		
		List<bdDTO> list = dao.getList(startRow, endRow);
		
		return list;
	}
	
	// 서치된 글 목록 가져오기
	@Override
	public List<bdDTO> getSearchList(int options, String searchContent,int startRow, int endRow) {
		
		List<bdDTO> list = dao.getSearchList(options, searchContent, startRow, endRow);
		
		return list;
	}
	
	// 서치된 글의 개수 가져오기
		@Override
		public int searchCount(int options, String searchContent) {
			
			int searchCount = dao.searchCount(options, searchContent);
			
			return searchCount;
		}
	
	// 마지막 글의 번호 가져오기
	@Override
	public int lastNum() {
		
		int num = dao.lastNum();

		return num;
	}
	 
	// 글 추가하기
	@Override
	public int insertContent(bdDTO bdDTO) {
		
		Date date = new Date();	// 현재 시간을 구해준다.
		bdDTO.setWritedate(date);
		
		int check = dao.insertContent(bdDTO);
		
		return check;
	}
	
	// 글 상세하게 찾아오기
	@Override
	public bdDTO detailContent(int num) {
		
		bdDTO bdDTO = dao.detailContent(num);
		
		return bdDTO;
	}
	
	// 글 수정하기
	@Override
	public int updateContent(bdDTO bdDTO) {
		// 수정을 한 날짜로 적용되도록
		Date date = new Date();
		bdDTO.setWritedate(date);
		
		int check = dao.updateContent(bdDTO);
		
		return check;
	}
	
	// 글 삭제하기
	@Override
	public void deleteContent(int num) {
		
		dao.deleteContent(num);
		
	}

	// 글의 개수 가져오기
	@Override
	public int count() {
		
		int count = dao.count();
		
		return count;
	}

	
	//파일관련
	@Override
	public int Fileupload(MtFileDTO dto) {
		int check = dao.Fileupload(dto);
		
		return check;
	}

	@Override
	public int ChangeFileupload(MtFileDTO dto) {
		int check = dao.ChangeFileupload(dto);
		
		return check;
	}

	@Override
	public String getFileName(int num) {
		String fileName = dao.getFileName(num);

		return fileName;
	}

	@Override
	public String FileDownload(int num) {
		String filePath = dao.FileDownload(num);
		
		return filePath;
	}
	
}
