package js.lecturelist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import js.lecturelist.model.LectureListDAO;
import js.lecturelist.model.LectureListDTO;

@Service
public class LectureListServiceImpl implements LectureListService{

	@Autowired
	private LectureListDAO dao;

	public void setDao(LectureListDAO dao) {
		this.dao = dao;
	}
	
	// 강의리스트 꺼내오기
	@Override
	public List<LectureListDTO> getLectureList(int id) {
		
		List<LectureListDTO> list = dao.getLectureList(id);
		
		return list;
	}
	
	
	
	
}
