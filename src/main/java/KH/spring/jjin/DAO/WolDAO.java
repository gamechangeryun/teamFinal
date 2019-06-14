package KH.spring.jjin.DAO;

import java.util.List;

import KH.spring.jjin.DTO.WolDTO;

public interface WolDAO {
public List<WolDTO>  List();
public WolDTO view (String id);
public void update (WolDTO vo);

}
