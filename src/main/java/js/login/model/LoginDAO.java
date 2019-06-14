package js.login.model;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

@Component
public class LoginDAO extends SqlSessionDaoSupport{
	
	// 로그인 id와 password를 구해옴
	public String login(int id){
		
		String dbPassword = getSqlSession().selectOne("login.loginData", id);
		
		return dbPassword;
	}
	
	// 아이디 중복확인
	public String idCheck(String id) {
		
		String dbId = getSqlSession().selectOne("login.idCheck", id);
		
		return dbId;
	}
	
	// 현재 로그인된 계정의 비밀번호 찾아오기
	public String dbPassword(int id) {
		
		String dbPassword = getSqlSession().selectOne("login.dbPassword", id);
		
		return dbPassword;
	}
	
	// 비밀번호 변경
	public int changePassword(int id, String newPassword) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("password", newPassword);
		
		int check = getSqlSession().update("login.changePassword", map);

		return check;
	}
	
	// 현재 로그인된 아이디의 상세정보 가져오기
	public PersonDTO getDetail(int id) {
		
		PersonDTO dto = getSqlSession().selectOne("login.getDetail", id);
		
		return dto;
	}
	
	// 계정정보변경 
	public int changeDetail(PersonDTO dto) {
		
		int check = getSqlSession().update("login.changeDetail", dto);

		return check;
	}
	
	// 아이디 찾아오기
	public int searchId(String name, String email) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("email", email);
		
		String receive = getSqlSession().selectOne("login.searchId", map);
		int id = 0;
		
		if(receive == null) {
			id = 0;
		}else {
			id = Integer.parseInt(receive);
		}
		
		return id;
	}
	
	// 비밀번호 찾기
	public String searchPw(int id, String email) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("email", email);
		
		String password = getSqlSession().selectOne("login.searchPw", map);
		
		return password;
	}
	
}//
