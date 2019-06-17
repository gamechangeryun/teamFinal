package js.guestinput.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import js.guestinput.model.GuestInputDAO;
import js.guestinput.model.GuestInputDTO;
import js.noticeboard.model.StorageDTO;

@Service
public class GuestInputServiceImpl implements GuestInputService{

	@Autowired
	private GuestInputDAO dao;

	public void setDao(GuestInputDAO dao) {
		this.dao = dao;
	}
	
	// 게스트 글 쓰기 허용 요청
	@Override
	public void insertGuestInput(GuestInputDTO dto) {
		dao.insertGuestInput(dto);
	}
	
	// 파일업로드
	@Override
	public void Fileupload(StorageDTO dto) {

		dao.Fileupload(dto);

	}
	/////////////////////////////////////////////////////////////
	// mainPage에 글 정보 찾아오기
	@Override
	public List<GuestInputDTO> getList(int startRow, int endRow) {

		List<GuestInputDTO> list = dao.getList(startRow, endRow);

		return list;
	}

	// 서치된 글 목록 가져오기
	@Override
	public List<GuestInputDTO> getSearchList(int options, String searchContent, int startRow, int endRow) {

		List<GuestInputDTO> list = dao.getSearchList(options, searchContent, startRow, endRow);

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
	////////////////////////////////////////////////////////////////////////////////
	// 글 상세하게 찾아오기
	@Override
	public GuestInputDTO detailContent(int num) {

		GuestInputDTO dto = dao.detailContent(num);

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
	/////////////////////////////////////////////////////////////////////////////////
	
}
