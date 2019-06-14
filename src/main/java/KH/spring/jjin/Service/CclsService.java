package KH.spring.jjin.Service;

import java.util.List;

import KH.spring.jjin.DTO.CclsDTO;



public interface CclsService {
	
public List<CclsDTO> CclsList();
public void insertCcls(CclsDTO dto);
public CclsDTO viewCcls(int id);
public void deleteCcls(int id);
public void updateCcls(CclsDTO dto);

 
} 
 