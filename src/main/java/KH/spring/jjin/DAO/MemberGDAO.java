package KH.spring.jjin.DAO;

import java.util.List;

import KH.spring.jjin.DTO.MemberGDTO;



public interface MemberGDAO {
public List<MemberGDTO> memberList();
public void insertMember(MemberGDTO vo);
public MemberGDTO viewMember(String id);
public void deleteMember(String id);
public void updateMember(MemberGDTO vo);

boolean checkPw(String id);

}
