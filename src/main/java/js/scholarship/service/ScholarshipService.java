package js.scholarship.service;

import java.util.List;

import js.scholarship.model.ScholarshipDTO;

public interface ScholarshipService {
	public List<ScholarshipDTO> getScholarship(int startRow, int endRow);	// 장학금 내역 가져오기
	public int count();	// 글의 개수 가져오기
	public List<ScholarshipDTO> getScholarshipSelect(int temper_num, int startRow, int endRow);	// 학과별 장학금 내역 가져오기
}
