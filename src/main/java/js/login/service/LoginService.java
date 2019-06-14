package js.login.service;

import js.login.model.PersonDTO;

public interface LoginService {
	public int login(int id, String password);	// 로그인 id와 password를 구해옴
	//////////////////////////////////////////////////////////////////////
	public String dbPassword(int id);	// 현재 로그인 된 계정의 비밀번호 가져오기
	public int changePassword(int id, String newPassword);	// 비밀번호 변경
	//////////////////////////////////////////////////////////////////////
	public PersonDTO getDetail(int id);	// 현재 로그인된 계정의 상세정보 가져오기  
	public int changeDetail(PersonDTO dto);	// 계정 정보 변경
	//////////////////////////////////////////////////////////////////////
	public int searchId(String name, String email);	// 아이디 찾기
	public String searchPw(int id, String email);	// 비밀번호 찾기
}
