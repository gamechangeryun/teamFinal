package mi.hw.board.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;


@Component
public class hwDAO extends SqlSessionDaoSupport {

	// 글 목록 가져오기
	public List<hwDTO> getList(int startRow, int endRow) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);

		List<hwDTO> list = getSqlSession().selectList("mihwmapper.getList", map);

		return list;
	}


	// 글 추가하기
	public void insertContent(hwDTO dto) {

		getSqlSession().insert("mihwmapper.insertContent", dto);

	}

	// 글 상세하게 찾아오기
	public hwDTO detailContent(int num) {

		hwDTO dto = getSqlSession().selectOne("mihwmapper.detailContent", num);

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("num", num);

		return dto;
	}

	// 글 수정하기
	public void updateContent(hwDTO dto) {

		getSqlSession().update("mihwmapper.updateContent", dto);

	}
	
	// 제출 확인하기
	public hwDTO hwsubon(int num) {
			
		hwDTO dto = getSqlSession().selectOne("mihwmapper.hwsubon", num);
		
		return dto;
			
	}
	
	// 글 수정 파일 업로드
	public void ChangeFileupload(hwDTO dto) {

		getSqlSession().update("mihwmapper.changeUpdateFile", dto);
	}

	// 글 삭제하기
	public void deleteContent(int num) {

		// 삭제
		getSqlSession().delete("mihwmapper.deleteFile", num); // 파일삭제
		getSqlSession().delete("mihwmapper.deleteContent", num); // 글 삭제
	}

	// 파일업로드
	public void Fileupload(hwDTO dto) {

		getSqlSession().insert("mihwmapper.insertFile", dto);

	}

	// 다운받을 파일의 이름 가져오기
	public String getFileName(int num) {

		String fileName = getSqlSession().selectOne("mihwmapper.fileName", num);

		return fileName;
	}
	
	// 다운받을 파일의 경로이름 가져오기
		public String getFileFakename(int num) {

			String fileFakename = getSqlSession().selectOne("mihwmapper.filefakeName", num);

			return fileFakename;
		}

	// 다운받을 파일의 경로 가져오기
	public String FileDownload(int num) {

		String filePath = getSqlSession().selectOne("mihwmapper.downloadFilePath", num);

		return filePath;
	}
	
	// 다운받을 파일의 임시경로 가져오기
	public String FileDownloadpath(int num) {

		String fileDownpath = getSqlSession().selectOne("mihwmapper.downloadRealPath", num);

		return fileDownpath;
	}

	// 서치된 글 목록 가져오기
	public List<hwDTO> getSearchList(int options, String searchContent, int startRow, int endRow) {

		List<hwDTO> list = null;
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("searchContent", searchContent);
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		
		
		if (options == 0) {
			if (!searchContent.equals(" ")) {
				// 제목으로 찾기
				list = getSqlSession().selectList("mihwmapper.searchTitle", map);
			}
		} else if (options == 1) {
			if (!searchContent.equals(" ")) {
				// 내용으로 찾기
				list = getSqlSession().selectList("mihwmapper.searchContent", map);
			}

		} else {
			if (!searchContent.equals(" ")) {
				// 작성자로 찾기
				list = getSqlSession().selectList("mihwmapper.searchWriter", map);
			}
		}

		return list;
	}

	// 글의 개수 가져오기
	public int count() {

		int count = getSqlSession().selectOne("mihwmapper.count");

		return count;
	}
	
	// 서치된 글의 개수 가져오기
		public int searchCount(int options, String searchContent) {
			
			int searchCount = 0;
			String result = "";
			if(options == 0) {
				if(!searchContent.equals(" ")) {
					// 제목으로 찾기
					result = getSqlSession().selectOne("mihwmapper.searchTitleCount", searchContent);
				}
			}else if(options == 1) {
				if(!searchContent.equals(" ")) {
					// 내용으로 찾기 
					result = getSqlSession().selectOne("mihwmapper.searchContentCount", searchContent);
				}
					
			}else {
				if(!searchContent.equals(" ")) {
					// 작성자로 찾기
					result = getSqlSession().selectOne("mihwmapper.searchWriterCount", searchContent);
				}
			}
			
			if(result == null) {
				result = "0";
				searchCount = Integer.parseInt(result);
			}else {
				searchCount = Integer.parseInt(result);
			}

			return searchCount;
		}
	
	// 글 상세하게 찾아오기
		public hwDTO updateContentInfo(int num) {
					
			hwDTO dto = getSqlSession().selectOne("mihwmapper.detailContent", num);
					
			return dto;
		}


		


}
