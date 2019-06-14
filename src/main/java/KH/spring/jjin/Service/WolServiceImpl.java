package KH.spring.jjin.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KH.spring.jjin.DAO.WolDAO;
import KH.spring.jjin.DTO.WolDTO;


@Service
public class WolServiceImpl implements WolService {

	@Autowired
	WolDAO wolDao;

	@Override
	public List<WolDTO> List() {
		return wolDao.List();
	}
 
	@Override
	public WolDTO view(String id) {
		return wolDao.view(id);
	}

	@Override
	public void update (WolDTO dto) {
		wolDao.update  (dto);
	}
 
	
}
