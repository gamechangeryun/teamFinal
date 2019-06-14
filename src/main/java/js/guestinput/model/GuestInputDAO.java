package js.guestinput.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import js.noticeboard.model.StorageDTO;

public class GuestInputDAO extends SqlSessionDaoSupport{

	// 게스트 글 쓰기 허용 요청
	public void insertGuestInput(GuestInputDTO dto) {
		getSqlSession().insert("guestInput.insertContent", dto);
	}
	
	// 파일업로드
	public void Fileupload(StorageDTO dto) {
		System.out.println(dto);
		getSqlSession().insert("guestInput.insertFile", dto);

	}
	////////////////////////////////////////////////////////////////
	// 글 목록 가져오기
	public List<GuestInputDTO> getList(int startRow, int endRow) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);

		List<GuestInputDTO> list = getSqlSession().selectList("guestInput.getTotalList", map);

		return list;
	}

	// 서치된 글 목록 가져오기
	public List<GuestInputDTO> getSearchList(int options, String searchContent, int startRow, int endRow) {

		List<GuestInputDTO> list = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchContent", searchContent);
		map.put("startRow", startRow);
		map.put("endRow", endRow);

		if (options == 0) {
			if (!searchContent.equals(" ")) {
				// 제목으로 찾기
				list = getSqlSession().selectList("guestInput.searchTitle", map);
			}
		} else if (options == 1) {
			if (!searchContent.equals(" ")) {
				// 내용으로 찾기
				list = getSqlSession().selectList("guestInput.searchContent", map);
			}

		} else {
			if (!searchContent.equals(" ")) {
				// 작성자로 찾기
				list = getSqlSession().selectList("guestInput.searchWriter", map);
			}
		}

		return list;
	}

	// 글의 개수 가져오기
	public int count() {

		int count = getSqlSession().selectOne("guestInput.countContent");

		return count;
	}

	// 서치된 글의 개수 가져오기
	public int searchCount(int options, String searchContent) {

		int searchCount = 0;
		String result = "";
		if (options == 0) {
			if (!searchContent.equals(" ")) {
				// 제목으로 찾기
				result = getSqlSession().selectOne("guestInput.searchTitleCount", searchContent);
			}
		} else if (options == 1) {
			if (!searchContent.equals(" ")) {
				// 내용으로 찾기
				result = getSqlSession().selectOne("guestInput.searchContentCount", searchContent);
			}

		} else {
			if (!searchContent.equals(" ")) {
				// 작성자로 찾기
				result = getSqlSession().selectOne("guestInput.searchWriterCount", searchContent);
			}
		}

		if (result == null) {
			result = "0";
			searchCount = Integer.parseInt(result);
		} else {
			searchCount = Integer.parseInt(result);
		}

		return searchCount;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////
	// 글 상세하게 찾아오기
	public GuestInputDTO detailContent(int num) {

		GuestInputDTO dto = getSqlSession().selectOne("guestInput.detailContent", num);

		return dto;
	}

	// 다운받을 파일의 이름 가져오기
	public String getFileName(int num) {

		String fileName = getSqlSession().selectOne("guestInput.fileName", num);

		return fileName;
	}

	// 다운받을 파일의 경로 가져오기
	public String FileDownload(int num) {

		String filePath = getSqlSession().selectOne("guestInput.downloadFilePath", num);

		return filePath;
	}
	
}
