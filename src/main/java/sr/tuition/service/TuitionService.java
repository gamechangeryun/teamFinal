package sr.tuition.service;

import java.util.List;

import sr.tuition.model.JoinDTO;
import sr.tuition.model.TemperDTO;
import sr.tuition.model.TuitionDTO;

public interface TuitionService {

	//학과 전체목록
	public List<TemperDTO> allList()throws Exception;
	
	//카운트횟수
	public int count()throws Exception;
	
	//납부 미납자 조회
	public List<TuitionDTO> inputList(JoinDTO jdto)throws Exception;
	
}
