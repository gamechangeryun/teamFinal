package KH.spring.jjin.DAO;

import java.util.List;

import KH.spring.jjin.DTO.CclsDTO;

public interface CclsDAO {
	
		public List<CclsDTO> CclsList();
		public void insertCcls(CclsDTO vo);
		public CclsDTO viewCcls(int id);
		public void deleteCcls(int id);
		public void updateCcls(CclsDTO vo);

		
}
