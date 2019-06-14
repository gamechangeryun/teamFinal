package KH.spring.jjin.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KH.spring.jjin.DAO.CclsDAO;
import KH.spring.jjin.DTO.CclsDTO;


@Service
public class CclsServiceImpl implements CclsService {

	@Autowired
	CclsDAO cclsDao;

	@Override
	public List<CclsDTO> CclsList() {
		return cclsDao.CclsList();
	}
 
	@Override
	public void insertCcls(CclsDTO dto) {

	cclsDao.insertCcls(dto);    
	} 

	@Override
	public CclsDTO viewCcls(int id) {
		return cclsDao.viewCcls(id);
	}

	@Override 
	public void deleteCcls(int id) {
cclsDao.deleteCcls(id);
	}

	@Override
	public void updateCcls(CclsDTO dto) {
cclsDao.updateCcls(dto);
	}


 

}
