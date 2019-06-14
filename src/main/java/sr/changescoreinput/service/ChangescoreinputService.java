package sr.changescoreinput.service;

import java.util.List;

import sr.changescoreinput.model.ChangescoreinputDTO;
import sr.scoreinput.model.ScoreinputDTO;

public interface ChangescoreinputService {
	public List<ChangescoreinputDTO> allList()throws Exception;
	
	public void reasonInsert(ChangescoreinputDTO dto)throws Exception;
	
	public void changeDelete(ChangescoreinputDTO dto)throws Exception;
	
	public void scoreUpdate(ScoreinputDTO dto)throws Exception;
}
