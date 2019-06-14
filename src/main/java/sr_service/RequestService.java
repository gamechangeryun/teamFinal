package sr_service;

import java.util.List;

import sr_model.requestDTO;

public interface RequestService {

	//카운트
	public int count()throws Exception;
	
	//신청자 목록
	public List<requestDTO> requestAll(int num)throws Exception;
	
	//신청자 삽입
	public int requestInsert(requestDTO res)throws Exception;
	
	//신청자 삭제
	public int requestDelete(int id)throws Exception;
	
}
