package sr.pro.service;

import sr.pro.model.ProDTO;

public interface ProService {
	ProDTO allList(int lecture_num)throws Exception;
	String picture(int id);
}
