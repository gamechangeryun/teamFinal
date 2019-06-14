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
		public List<graDTO> getSearchList(int options, String searchContent) {

			List<graDTO> list = null;

			if (options == 0) {
				if (searchContent != " ") {
					// 이름으로 찾기
					list = getSqlSession().selectList("migramapper.searchName", searchContent);
				}
			} 

			return list;
		}
		
		// 글의 개수 가져오기
		public int count() {

			int count = getSqlSession().selectOne("migramapper.count");

			return count;
		}

}
