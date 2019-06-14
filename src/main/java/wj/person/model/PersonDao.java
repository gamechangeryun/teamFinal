package wj.person.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class PersonDao extends SqlSessionDaoSupport{
	// person All list
	public List<PersonDto> getPersonList(String sql){
		List<PersonDto> persons = getSqlSession().selectList(sql);
		return persons;
	}
	// person Page list
	public List<PersonDto> getPersonPageList(String sql, int page) {
		int start = 1+(5*(page-1));
		List<PersonDto> persons = getSqlSession().selectList(sql, start);
		return persons;
	}
	// person Search All List
	public List<PersonDto> getPersonList(String sql, int searchOption, String searchString ){
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("searchString", searchString);
		List<PersonDto> persons = getSqlSession().selectList(sql, map);
		return persons;
	}
	
	// person Search Page List
	public List<PersonDto> getPersonPageList(String sql, int page, int searchOption, String searchString) {
		int start = 1+(5*(page-1));
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("searchString", searchString);
		map.put("start", start);
		List<PersonDto> persons = getSqlSession().selectList(sql, map);
		return persons;
	}
	
	// person add
	public void addPerson(String sql, PersonDto person) {
		int i = getSqlSession().insert(sql, person);
		if (i != 0) {
			System.out.println("person 저장 완료.");
		} else {
			System.out.println("person 저장 실패.");
		}
	}
	
	// MaxId search
	public int searchMaxId(String sql, int i) {
		int maxId = 1;
		if(getSqlSession().selectOne(sql,i) != null) {
			maxId = getSqlSession().selectOne(sql, i);
			maxId++;
		}
		return maxId;
	}
	
	// temper search
	public List<TemperDto> searchTemper(String sql) {
		List<TemperDto> list = null;
		try {
			list = getSqlSession().selectList(sql);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return list;
	}
	
	// picture insert
	public void addPicture(String sql, PictureDto picture) {
		int i = getSqlSession().insert(sql, picture);
		if(i == 1) {
			System.out.println("picture 성공");
		} else {
			System.out.println("picture 실패");
		}
	}
	
	// temper_num get
	public int getTemper_num(String sql, String temper_name) {
		int temper_num = 0;
		try {
			temper_num = getSqlSession().selectOne(sql, temper_name);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return temper_num;
	}
}
