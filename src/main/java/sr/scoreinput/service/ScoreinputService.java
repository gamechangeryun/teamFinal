package sr.scoreinput.service;

import java.util.List;

import sr.scoreinput.model.ScoreinputDTO;

public interface ScoreinputService {

	public List<ScoreinputDTO> allList(int id)throws Exception;	// 학과 리스트 가져오기
	
	public List<ScoreinputDTO> snameList(String snum)throws Exception;	// 학생리스트 가져오기
	
	public void inputScore(ScoreinputDTO list)throws Exception;
}
