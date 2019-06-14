package sr.changescoreinput.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import sr.changescoreinput.model.ChangescoreinputDAO;
import sr.changescoreinput.model.ChangescoreinputDTO;
import sr.scoreinput.model.ScoreinputDTO;

@Service
public class ChangescoreinputServiceImpl implements ChangescoreinputService {

	@Autowired
	@Qualifier("ChangescoreinputDAO")
	private ChangescoreinputDAO cdao;
	
	public void setCdao(ChangescoreinputDAO cdao) {
		this.cdao = cdao;
	}

	@Override
	public List<ChangescoreinputDTO> allList() throws Exception {
		return cdao.allList();
	}

	@Override
	public void reasonInsert(ChangescoreinputDTO dto) throws Exception {
		cdao.reasonInsert(dto);
	}

	@Override
	public void changeDelete(ChangescoreinputDTO dto) throws Exception {
		cdao.changeDelete(dto);
	}

	@Override
	public void scoreUpdate(ScoreinputDTO dto) throws Exception {
		cdao.scoreUpdate(dto);
	}

}
