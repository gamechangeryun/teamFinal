package sr.scoreinput.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import sr.scoreinput.model.ScoreinputDAO;
import sr.scoreinput.model.ScoreinputDTO;

@Service
public class ScoreinputServiceImpl implements ScoreinputService{

	@Autowired
	@Qualifier("scoreinputDAO")
	private ScoreinputDAO idao;
	
	public void setIdao(ScoreinputDAO idao) {
		this.idao = idao;
	}

	@Override
	public List<ScoreinputDTO> allList(int id) throws Exception {
		return idao.allList(id);
	}

	@Override
	public List<ScoreinputDTO> snameList(String snum) throws Exception {
		return idao.snameList(snum);
	}

	@Override
	public void inputScore(ScoreinputDTO dto) throws Exception {
		idao.inputScore(dto);
	}
	
}
