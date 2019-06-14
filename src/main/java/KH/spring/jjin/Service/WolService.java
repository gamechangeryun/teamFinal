package KH.spring.jjin.Service;

import java.util.List;

import KH.spring.jjin.DTO.WolDTO;

public interface WolService {
public List<WolDTO> List();
public WolDTO view(String id); 
public void update(WolDTO dto);
 
} 
 