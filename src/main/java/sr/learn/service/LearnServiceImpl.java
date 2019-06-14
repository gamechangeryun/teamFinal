package sr.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import sr.learn.model.LearnDAO;
import sr.learn.model.LearnDTO;

@Service
public class LearnServiceImpl implements LearnService {

	@Autowired
	@Qualifier("LearnDAO")
	private LearnDAO ldao;
	
	public void setLdao(LearnDAO ldao) {
		this.ldao = ldao;
	}

	@Override
	public List<LearnDTO> allList() throws Exception {
		return ldao.allList();
	}

	@Override
	public void delete(LearnDTO dto) throws Exception {
		ldao.delete(dto);
	}

	@Override
	public List<LearnDTO> nowList(LearnDTO dto) throws Exception {
		return ldao.nowList(dto);
	}
	
	//학습진행증가
	@Override
	public void addNow(LearnDTO dto) throws Exception {
		int n = dto.getNow_study() + 1; 
		System.out.println("학습진행증가::"+dto);
		dto.setNow_study(n);
		
		ldao.addNow(dto);
	}
	
	//학습진행감소
	@Override
	public void disNow(LearnDTO dto) throws Exception {
		int n = dto.getNow_study() - 1;
		if(n >= 0) {
			System.out.println("진행감소::"+n);
			dto.setNow_study(n);
			ldao.disNow(dto);
		}
	}

	@Override
	public void learnInsert(LearnDTO dto) throws Exception {
		ldao.learnInsert(dto);
	}

}
