package sr.pro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import sr.pro.model.ProDAO;
import sr.pro.model.ProDTO;

@Service
public class ProServiceImpl implements ProService {

	@Autowired
	@Qualifier(value="proDAO")
	ProDAO pdao;

	public void setDao(ProDAO dao) {
		this.pdao = dao;
	}

	@Override
	public ProDTO allList(int lecture_num) throws Exception {
		return pdao.allList(lecture_num);
	}

	@Override
	public String picture(int id) {
		return pdao.picture(id);
	}
	
	
	
}
