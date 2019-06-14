package sr.learn.service;

import java.util.List;

import sr.learn.model.LearnDTO;

public interface LearnService {

	public List<LearnDTO> allList()throws Exception;
	
	public void delete(LearnDTO dto) throws Exception;
	
	public List<LearnDTO> nowList(LearnDTO dto)throws Exception;
	
	public void addNow(LearnDTO dto)throws Exception;
	
	public void disNow(LearnDTO dto)throws Exception;
	
	public void learnInsert(LearnDTO dto)throws Exception;
}
