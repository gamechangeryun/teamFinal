package js.lecturelist.service;

import java.util.List;

import js.lecturelist.model.LectureListDTO;

public interface LectureListService {
	public List<LectureListDTO> getLectureList(int id);	// 강의리스트에서 강의들 꺼내오기
}
