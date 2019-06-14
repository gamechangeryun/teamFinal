package sr.tuition.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sr.tuition.model.JoinDTO;
import sr.tuition.model.TemperDTO;
import sr.tuition.model.TuitionDAO;
import sr.tuition.model.TuitionDTO;

@Service
public class TuitionServiceImpl implements TuitionService {

	@Autowired
	private TuitionDAO tdao;

	public void setTdao(TuitionDAO tdao) {
		this.tdao = tdao;
	}

	@Override
	public int count() throws Exception{
		return tdao.count();
	}
	
	//납부 미납자조회
	@Override
	public List<TuitionDTO> inputList(JoinDTO jdto) throws Exception {
		
		List<TuitionDTO> list = tdao.inputList(jdto);
		return list;
	}

	//학과리스트
	@Override
	public List<TemperDTO> allList() throws Exception {
		return tdao.allList();
	}

	
}
