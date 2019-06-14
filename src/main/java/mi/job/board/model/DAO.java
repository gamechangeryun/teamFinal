package mi.job.board.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;


@Component
public class DAO extends SqlSessionDaoSupport {

	// 글 목록 가져오기
	public List<DTO> getList(int startRow, int endRow) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);

		List<DTO> list = getSqlSession().selectList("mijobmapper.getList", map);

		return list;
	}


	// 글 추가하기
	public void insertContent(DTO dto) {

		getSqlSession().insert("mijobmapper.insertContent", dto);

	}

	// 글 상세하게 찾아오기
	public DTO detailContent(int num) {

		DTO dto = getSqlSession().selectOne("mijobmapper.detailContent", num);

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("num", num);
		map.put("readcount", dto.getReadcount() + 1);

		getSqlSession().insert("mijobmapper.addReadCount", map);

		dto.setReadcount(dto.getReadcount() + 1);

		return dto;
	}

	// 글 수정하기
	public void updateContent(DTO dto) {

		getSqlSession().update("mijobmapper.updateContent", dto);

	}

	// 글 수정 파일 업로드
	public void ChangeFileupload(DTO dto) {

		getSqlSession().update("mijobmapper.changeUpdateFile", dto);
	}

	// 글 삭제하기
	public void deleteContent(int num) {

		// 삭제
		getSqlSession().delete("mijobmapper.deleteFile", num); // 파일삭제
		getSqlSession().delete("mijobmapper.deleteContent", num); // 글 삭제
		// 만약, 삭제된 글번호가 3이라면 temp = 4를 저장해서 3번 다음에 4번 글의 정보를 가져와서 dto에 저장하고
		// temp의 값을 1 증가시켜서 temp = 5로 만들고 dto의 num값에는 4라는 값이 저장되어있으니까 dto의 num값을 - 1 해서
		// 3으로 만들어주고 update하기
	}

	// 파일업로드
	public void Fileupload(DTO dto) {

		getSqlSession().insert("mijobmapper.insertFile", dto);

	}

	// 다운받을 파일의 이름 가져오기
	public String getFileName(int num) {

		String fileName = getSqlSession().selectOne("mijobmapper.fileName", num);

		return fileName;
	}
	
	// 다운받을 파일의 경로이름 가져오기
		public String getFileFakename(int num) {

			String fileFakename = getSqlSession().selectOne("mijobmapper.filefakeName", num);

			return fileFakename;
		}

	// 다운받을 파일의 경로 가져오기
	public String FileDownload(int num) {

		String filePath = getSqlSession().selectOne("mijobmapper.downloadFilePath", num);

		return filePath;
	}
	
	// 다운받을 파일의 임시경로 가져오기
	public String FileDownloadpath(int num) {

		String fileDownpath = getSqlSession().selectOne("mijobmapper.downloadRealPath", num);

		return fileDownpath;
	}

	// 서치된 글 목록 가져오기
	public List<DTO> getSearchList(int options, String searchContent) {

		List<DTO> list = null;

		if (options == 0) {
			if (searchContent != " ") {
				// 제목으로 찾기
				list = getSqlSession().selectList("mijobmapper.searchTitle", searchContent);
			}
		} else if (options == 1) {
			if (searchContent != " ") {
				// 내용으로 찾기
				list = getSqlSession().selectList("mijobmapper.searchContent", searchContent);
			}

		} else {
			if (searchContent != " ") {
				// 작성자로 찾기
				list = getSqlSession().selectList("mijobmapper.searchWriter", searchContent);
			}
		}

		return list;
	}

	// 글의 개수 가져오기
	public int count() {

		int count = getSqlSession().selectOne("mijobmapper.count");

		return count;
	}
	
	// 글 상세하게 찾아오기
		public DTO updateContentInfo(int num) {
					
			DTO dto = getSqlSession().selectOne("mijobMapper.detailContent", num);
					
			return dto;
		}

}
