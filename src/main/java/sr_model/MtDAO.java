package sr_model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

@Component("mtDAO")
public class MtDAO extends SqlSessionDaoSupport{
	
	// 글 목록 가져오기
	public List<bdDTO> getList(int startRow, int endRow){
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		
		List<bdDTO> list = getSqlSession().selectList("Mtmapper.getList", map);
		
		return list;
	}
	
	// 글 작성할 때 가장 끝 번호 가져오기
	public int lastNum() {
		
		String receive = getSqlSession().selectOne("Mtmapper.lastNum");	// num의 최대값 가져오기
		
		if(receive == null) {
			receive = "0";
		}
		
		int num = Integer.parseInt(receive) + 1;
	
		return num;
	}
	
	// 글 추가하기
	public int insertContent(bdDTO bdDTO) {
		
		int check = getSqlSession().insert("Mtmapper.insertContent", bdDTO);
		
		return check;
	}
	
	// 글 상세하게 찾아오기
	public bdDTO detailContent(int num) {
		
		bdDTO bdDTO = getSqlSession().selectOne("Mtmapper.detailContent", num);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("num", num);
		map.put("readcount", bdDTO.getReadcount() + 1);
		
		getSqlSession().insert("Mtmapper.addReadCount", map);

		bdDTO.setReadcount(bdDTO.getReadcount() + 1);
		
		return bdDTO;
	}
	
	// 비밀번호 가져오기
	/*public String passwordCheck(int num) {
		
		String password = getSqlSession().selectOne("mapper.passwordCheck", num);
		
		return password;
	}*/
	
	// 글 수정하기
	public int updateContent(bdDTO bdDTO) {
		
		int check = getSqlSession().update("Mtmapper.updateContent", bdDTO);
		
		return check;
	}
	
	// 글 삭제하기
	public void deleteContent(int num){
		
		getSqlSession().delete("Mtmapper.deleteFile", num);	//파일삭제
		getSqlSession().delete("Mtmapper.deleteContent", num);	// 글 삭제
		// 만약, 삭제된 글번호가 3이라면 temp = 4를 저장해서 3번 다음에 4번 글의 정보를 가져와서 bdDTO에 저장하고 
		// temp의 값을 1 증가시켜서 temp = 5로 만들고 bdDTO의 num값에는 4라는 값이 저장되어있으니까 bdDTO의 num값을 - 1 해서 3으로 만들어주고 update하기
		
		/*String receive = getSqlSession().selectOne("Mtmapper.lastNum");	// num의 최대값 가져오기 -> for문을 돌리기 위해서
		int max = Integer.parseInt(receive);
		
		int temp = num + 1;	// 삭제한 글 번호 + 1
		
		for(int i=num; i<=max; i++) {
			// 삭제된 글번호 다음 글 정보 불러오기
			bdDTO bdDTO = getSqlSession().selectOne("Mtmapper.deleteNextNum", temp);
			MtFileDTO bdDTO_file = getSqlSession().selectOne("Mtmapper.deleteNextFileNum", temp);
			
			getSqlSession().update("Mtmapper.deleteFileUpdate", bdDTO_file);
			getSqlSession().update("Mtmapper.deleteUpdate", bdDTO);
			temp ++;
			
		}
		*/
	}
	
	// 서치된 글 목록 가져오기
	public List<bdDTO> getSearchList(int options, String searchContent, int startRow, int endRow) {
		
		 List<bdDTO> list = null;
		 Map<String, Object> map = new HashMap<String, Object>();
		 map.put("searchContent", searchContent);
		 map.put("startRow", startRow);
		 map.put("endRow", endRow);
		 
		 
		if(options == 0) {
			if(!searchContent.equals(" ")) {
				// 제목으로 찾기
				list = getSqlSession().selectList("Mtmapper.searchTitle", searchContent);
			}
		}else if(options == 1) {
			if(!searchContent.equals(" ")) {
				// 내용으로 찾기 
				list = getSqlSession().selectList("Mtmapper.searchContent", searchContent);
			}
			
		}else {
			if(!searchContent.equals(" ")) {
				// 작성자로 찾기
				list = getSqlSession().selectList("Mtmapper.searchWriter", searchContent);
			}
		}
		
		return list;
	}
	
	// 글의 개수 가져오기
	public int count() {
			
		int count = getSqlSession().selectOne("Mtmapper.count");
		
		return count;
	}
	
	// 서치된 글의 개수 가져오기
		public int searchCount(int options, String searchContent) {
			
			int searchCount = 0;
			String result = "";
			if(options == 0) {
				if(!searchContent.equals(" ")) {
					// 제목으로 찾기
					result = getSqlSession().selectOne("Mtmapper.searchTitleCount", searchContent);
				}
			}else if(options == 1) {
				if(!searchContent.equals(" ")) {
					// 내용으로 찾기 
					result = getSqlSession().selectOne("Mtmapper.searchContentCount", searchContent);
				}
					
			}else {
				if(!searchContent.equals(" ")) {
					// 작성자로 찾기
					result = getSqlSession().selectOne("Mtmapper.searchWriterCount", searchContent);
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
	
	//////////////////////////////////////////////////////////////////
	//파일관련
	
	// 글 수정 파일 업로드
		public int ChangeFileupload(MtFileDTO dto) {
			
			int check = getSqlSession().update("Mtmapper.changeUpdateFile", dto);
			
			return check;
		}	
	
		// 파일업로드
		public int Fileupload(MtFileDTO dto) {
			
			int check = getSqlSession().insert("Mtmapper.insertFile", dto);
			
			if(check == 0) {
				getSqlSession().rollback();
			}
			
			return check;
		}
		
		// 다운받을 파일의 이름 가져오기
		public String getFileName(int num) {
			
			String fileName = getSqlSession().selectOne("Mtmapper.fileName", num);
			
			return fileName;
		}
		
		// 다운받을 파일의 경로 가져오기
		public String FileDownload(int num) {
			
			String filePath = getSqlSession().selectOne("Mtmapper.downloadFilePath", num);
			
			return filePath;
		}	
}//
