package sr.pro.notice.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

@Component("pronoticeDAO")
public class PronoticeDAO extends SqlSessionDaoSupport {

	// 글목록
	public List<PronoticeDTO> getList(int startRow, int endRow) throws Exception {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);

		List<PronoticeDTO> list = getSqlSession().selectList("ProNoticeBoardMapper.getTotalList", map);

		return list;
	}

	// 검색 글 목록
	public List<PronoticeDTO> getSearchList(int options, String searchContent, int startRow, int endRow)
			throws Exception {
		List<PronoticeDTO> list = null;

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchContent", searchContent);
		map.put("startRow", startRow);
		map.put("endRow", endRow);

		if (options == 0) {
			if (!searchContent.equals(" ")) {
				// 제목으로 찾기
				System.out.println("제목::" + map);
				list = getSqlSession().selectList("ProNoticeBoardMapper.searchTitle", map);
			}
		} else if (options == 1) {
			if (!searchContent.equals(" ")) {
				// 내용으로 찾기
				System.out.println("내용::" + map);
				list = getSqlSession().selectList("ProNoticeBoardMapper.searchContent", map);
			}

		} else {
			if (searchContent != " ") {
				// 강의번호로 찾기
				System.out.println("강의번호::" + map);
				list = getSqlSession().selectList("ProNoticeBoardMapper.searchWriter", map);
			}
		}

		return list;
	}

	// 글의 개수 가져오기
	public int count() {

		int count = getSqlSession().selectOne("ProNoticeBoardMapper.countContent");

		return count;
	}

	// 서치된 글의 개수 가져오기
	public int searchCount(int options, String searchContent) {

		int searchCount = 0;
		String result = "";
		if (options == 0) {
			if (!searchContent.equals(" ")) {
				// 제목으로 찾기
				result = getSqlSession().selectOne("ProNoticeBoardMapper.searchTitleCount", searchContent);
			}
		} else if (options == 1) {
			if (!searchContent.equals(" ")) {
				// 내용으로 찾기
				result = getSqlSession().selectOne("ProNoticeBoardMapper.searchContentCount", searchContent);
			}

		} else {
			if (!searchContent.equals(" ")) {
				// 작성자로 찾기
				result = getSqlSession().selectOne("ProNoticeBoardMapper.searchWriterCount", searchContent);
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

	// 글 추가하기
	public void insertContent(PronoticeDTO dto) {

		getSqlSession().insert("ProNoticeBoardMapper.insertContent", dto);

	}

	// 글 상세하게 찾아오기
	public PronoticeDTO detailContent(int num) {
		
		System.out.println("글상세보기 넘값 ::"+ num);
		
		PronoticeDTO dto = getSqlSession().selectOne("ProNoticeBoardMapper.detailContent", num);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("num", num);

		int n = dto.getReadcount() + 1;
		map.put("readcount", n);

		getSqlSession().insert("ProNoticeBoardMapper.addReadCount", map);

		dto.setReadcount(n);

		return dto;
	}

	// 글 상세하게 찾아오기
	public PronoticeDTO updateContentInfo(int num) {

		PronoticeDTO dto = getSqlSession().selectOne("ProNoticeBoardMapper.detailContent", num);

		return dto;
	}

	// 글 수정하기
	public void updateContent(PronoticeDTO dto) {

		getSqlSession().update("ProNoticeBoardMapper.updateContent", dto);

	}

	// 글 삭제하기
	public void deleteContent(int num) {
		getSqlSession().delete("ProNoticeBoardMapper.deleteContent", num); // 글 삭제
	}

}
