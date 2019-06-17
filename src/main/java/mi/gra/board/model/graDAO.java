package mi.gra.board.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

@Component
public class graDAO extends SqlSessionDaoSupport {

	// 글 목록 가져오기
		public List<graDTO> getList(int startRow, int endRow) {

			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("startRow", startRow);
			map.put("endRow", endRow);

			List<graDTO> list = getSqlSession().selectList("migramapper.getList", map);

			return list;
		}
	   
	// 서치된 글 목록 가져오기
		public List<graDTO> getSearchList(int options, String searchContent, int startRow, int endRow) {

			List<graDTO> list = null;
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("searchContent", searchContent);
			map.put("startRow", startRow);
			map.put("endRow", endRow);

			if (options == 0) {
				if (searchContent != " ") {
					// 이름으로 찾기
					list = getSqlSession().selectList("migramapper.searchName", map);
				}
			} 

			return list;
		}
		
		// 글의 개수 가져오기
		public int count() {

			int count = getSqlSession().selectOne("migramapper.count");

			return count;
		}
		
		// 서치된 글의 개수 가져오기
				public int searchCount(int options, String searchContent) {
					
					int searchCount = 0;
					String result = "";
					if(options == 0) {
						if(!searchContent.equals(" ")) {
							// 제목으로 찾기
							result = getSqlSession().selectOne("migramapper.searchNameCount", searchContent);
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

}
