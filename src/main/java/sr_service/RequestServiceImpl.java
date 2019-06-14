package sr_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import sr_model.requestDAO;
import sr_model.requestDTO;

@Service
public class RequestServiceImpl implements RequestService {

	@Autowired
	@Qualifier("requestDAO")
	private requestDAO rdao;
	
	@Override
	public int count() throws Exception {
		return rdao.count();
	}

	@Override
	public List<requestDTO> requestAll(int num) throws Exception {
		return rdao.requestAll(num);
	}

	@Override
	public int requestInsert(requestDTO res) throws Exception {
		return rdao.requestInsert(res);
	}

	@Override
	public int requestDelete(int id) throws Exception {
		return rdao.requestDelete(id);
	}

}
