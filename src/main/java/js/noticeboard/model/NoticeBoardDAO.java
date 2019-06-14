package js.noticeboard.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class NoticeBoardDAO extends SqlSessionDaoSupport{
	
	// 글 목록 가져오기
	public List<NoticeBoardDTO> getList(int startRow, int endRow){
			
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
			
		List<NoticeBoardDTO> list = getSqlSession().selectList("noticeBoardMapper.getTotalList", map);

		return list;
	}

	// 서치된 글 목록 가져오기
	public List<NoticeBoardDTO> getSearchList(int options, String searchContent, int startRow, int endRow) {
			
		 List<NoticeBoardDTO> list = null;
		 Map<String, Object> map = new HashMap<String, Object>();
		 map.put("searchContent", searchContent);
		 map.put("startRow", startRow);
		 map.put("endRow", endRow);
			 
		if(options == 0) {
			if(!searchContent.equals(" ")) {
				// 제목으로 찾기
				list = getSqlSession().selectList("noticeBoardMapper.searchTitle", map);
			}
		}else if(options == 1) {
			if(!searchContent.equals(" ")) {
				// 내용으로 찾기 
				list = getSqlSession().selectList("noticeBoardMapper.searchContent", map);
			}
				
		}else {
			if(!searchContent.equals(" ")) {
				// 작성자로 찾기
				list = getSqlSession().selectList("noticeBoardMapper.searchWriter", map);
			}
		}
			
		return list;
	}
	
	// 글의 개수 가져오기
	public int count() {
				
		int count = getSqlSession().selectOne("noticeBoardMapper.countContent");
			
		return count;
	}
	
	// 서치된 글의 개수 가져오기
	public int searchCount(int options, String searchContent) {
		
		int searchCount = 0;
		String result = "";
		if(options == 0) {
			if(!searchContent.equals(" ")) {
				// 제목으로 찾기
				result = getSqlSession().selectOne("noticeBoardMapper.searchTitleCount", searchContent);
			}
		}else if(options == 1) {
			if(!searchContent.equals(" ")) {
				// 내용으로 찾기 
				result = getSqlSession().selectOne("noticeBoardMapper.searchContentCount", searchContent);
			}
				
		}else {
			if(!searchContent.equals(" ")) {
				// 작성자로 찾기
				result = getSqlSession().selectOne("noticeBoardMapper.searchWriterCount", searchContent);
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
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	// 글 추가하기
	public void insertContent(NoticeBoardDTO dto) {
			
		getSqlSession().insert("noticeBoardMapper.insertContent", dto);
			
	}
	
	// 파일업로드
	public void Fileupload(StorageDTO dto) {
			
		getSqlSession().insert("noticeBoardMapper.insertFile", dto);

	}
	///////////////////////////////////////////////////////////////////////////////////////////////////
	// 글 상세하게 찾아오기
	public NoticeBoardDTO detailContent(int num) {
			
		NoticeBoardDTO dto = getSqlSession().selectOne("noticeBoardMapper.detailContent", num);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("num", num);
		map.put("readcount", dto.getReadcount() + 1);
			
		getSqlSession().insert("noticeBoardMapper.addReadCount", map);

		dto.setReadcount(dto.getReadcount() + 1);
			
		return dto;
	}
	
	// 다운받을 파일의 이름 가져오기
	public String getFileName(int num) {
				
		String fileName = getSqlSession().selectOne("noticeBoardMapper.fileName", num);
				
		return fileName;
	}
			
	// 다운받을 파일의 경로 가져오기
	public String FileDownload(int num) {
				
		String filePath = getSqlSession().selectOne("noticeBoardMapper.downloadFilePath", num);
				
		return filePath;
	}
	///////////////////////////////////////////////////////////////////////////////////////////////
	// 글 상세하게 찾아오기
	public NoticeBoardDTO updateContentInfo(int num) {
				
		NoticeBoardDTO dto = getSqlSession().selectOne("noticeBoardMapper.detailContent", num);
				
		return dto;
	}
		
	// 글 수정하기
	public void updateContent(NoticeBoardDTO dto) {
			
		getSqlSession().update("noticeBoardMapper.updateContent", dto);
			
	}
	
	// 글 수정 파일 업로드
	public void ChangeFileupload(StorageDTO dto) {
			
		getSqlSession().update("noticeBoardMapper.changeUpdateFile", dto);
	}
	///////////////////////////////////////////////////////////////////////////////////////////
	// 글 삭제하기
	public void deleteContent(int num){
		// 삭제
		getSqlSession().delete("noticeBoardMapper.deleteFile", num);	// 파일삭제	
		getSqlSession().delete("noticeBoardMapper.deleteContent", num);	// 글 삭제
	}
	
	
	
	
}
