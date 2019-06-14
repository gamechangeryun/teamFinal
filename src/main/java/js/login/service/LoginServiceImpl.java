package js.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import js.login.model.LoginDAO;
import js.login.model.PersonDTO;  

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginDAO dao;

	public void setDao(LoginDAO dao) {
		this.dao = dao;
	}
	
	// 로그인 id와 password를 구해옴
	@Override
	public int login(int id, String password) {
		
		String dbPassword = dao.login(id);
		int check = -1;	// -1 : 아이디 틀림, 0 : 비밀번호 틀림, 1 : 아이디와 비밀번호 일치
		
		// 아이디가 틀렸을 때
		if(dbPassword == null) {
			return check;
		}
		
		// db에 저장된 비밀번호와 내가 친 비밀번호가 같을 때 
		if(dbPassword.equals(password)) {
			check = 1;
		}else{
			check = 0;
		}
		
		return check;
	}

	// 현재 로그인된 계정의 비밀번호 찾아오기
	@Override
	public String dbPassword(int id) {
		
		String dbPassword = dao.dbPassword(id);
		
		return dbPassword;
	}

	// 비밀번호 변경
	@Override
	public int changePassword(int id, String newPassword) {
		
		int check = dao.changePassword(id, newPassword);
		
		return check;
	}
	
	// 현재 로그인된 계정의 상세정보 가져오기
	@Override
	public PersonDTO getDetail(int id) {

		PersonDTO dto = dao.getDetail(id);
		
		return dto;
	}
	
	// 계정정보변경 
	@Override
	public int changeDetail(PersonDTO dto) {

		int check = dao.changeDetail(dto);
		
		return check;
	}

	// 아이디 찾아오기
	@Override
	public int searchId(String name, String email) {
		
		int id = dao.searchId(name, email);
		
		return id;
	}
	
	// 비밀번호 찾기
	@Override
	public String searchPw(int id, String email) {
		
		String password = dao.searchPw(id, email);
		
		return password;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
