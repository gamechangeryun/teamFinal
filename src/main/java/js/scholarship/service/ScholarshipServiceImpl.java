package js.scholarship.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import js.scholarship.model.ScholarshipDAO;
import js.scholarship.model.ScholarshipDTO;

@Service
public class ScholarshipServiceImpl implements ScholarshipService{

	@Autowired
	private ScholarshipDAO dao;

	public void setDao(ScholarshipDAO dao) {
		this.dao = dao;
	}
	
	// 장학금 내역 가져오기
	@Override
	public List<ScholarshipDTO> getScholarship(int startRow, int endRow) {
			
		List<ScholarshipDTO> list = dao.getScholarship(startRow, endRow);
			
		return list;
	}
	
	// 글의 개수 가져오기
	@Override
	public int count() {
				
		int count = dao.count();
				
		return count;
	}
	
	// 학과별 장학금 내역 가져오기
	@Override
	public List<ScholarshipDTO> getScholarshipSelect(int temper_num, int startRow, int endRow) {
				
		List<ScholarshipDTO> list = dao.getScholarshipSelect(temper_num, startRow, endRow);
				
		return list;
	}
	
	
	
}
