package KH.spring.jjin.Service;

import java.util.List;

import KH.spring.jjin.DTO.MemberGDTO;



public interface MemberGService {
public List<MemberGDTO> memberList();
public void insertMember(MemberGDTO dto);
public MemberGDTO viewMember(String id);
public void deleteMember(String id);
public void updateMember(MemberGDTO dto);
public boolean checkPw(String id);
 
} 
 