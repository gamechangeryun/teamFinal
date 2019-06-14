package KH.spring.jjin.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KH.spring.jjin.DAO.MemberGDAO;
import KH.spring.jjin.DTO.MemberGDTO;


@Service
public class MemberGServiceImpl implements MemberGService {

	@Autowired
	MemberGDAO memberDao;

	@Override
	public List<MemberGDTO> memberList() {
		return memberDao.memberList();
	}
 
	@Override
	public void insertMember(MemberGDTO dto) {

	memberDao.insertMember(dto);    
	} 

	@Override
	public MemberGDTO viewMember(String id) {
		return memberDao.viewMember(id);
	}

	@Override 
	public void deleteMember(String id) {
memberDao.deleteMember(id);
	}

	@Override
	public void updateMember(MemberGDTO dto) {
memberDao.updateMember(dto);
	}

	@Override
	public boolean checkPw(String id) {
		return memberDao.checkPw(id);  
	}
 

}
