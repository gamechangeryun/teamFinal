package sr.attend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sr.attend.model.AttenDAO;
import sr.attend.model.AttenDTO;

@Service
public class AttenServiceImpl implements AttenService {

	@Autowired
	private AttenDAO adao;
	
	public void setAdao(AttenDAO adao) {
		this.adao = adao;
	}

	@Override
	public List<AttenDTO> allList(int id) throws Exception {
		return adao.allList(id);
	}

	@Override
	public void attenInsert(AttenDTO dto) throws Exception {
		adao.attenInsert(dto);
	}

	@Override
	public List<AttenDTO> idList(int n) throws Exception {
		return adao.idList(n);
	}

	@Override
	public List<AttenDTO> studentList(int n) throws Exception {
		return adao.studentList(n);
	}

	@Override
	public void attenCheck(AttenDTO dto) throws Exception {
		adao.attenCheck(dto);
	}

	@Override
	public List<AttenDTO> daycheck(int id) throws Exception {
		return adao.daycheck(id);
	}

}
