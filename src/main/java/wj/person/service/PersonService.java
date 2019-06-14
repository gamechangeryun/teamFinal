package wj.person.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wj.person.model.PersonDao;
import wj.person.model.PersonDto;
import wj.person.model.PictureDto;
import wj.person.model.TemperDto;

@Service
public class PersonService {
	@Autowired
	private PersonDao dao; 

	public void setDao(PersonDao dao) {
		this.dao = dao;
	}
	
	// show All person
	public List<PersonDto> getPersonList() {
		List<PersonDto> persons = null;
		try {
			persons = dao.getPersonList("personSql.selectAllPerson");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return persons;
	}
	// show page person
	public List<PersonDto> getPersonList(int page) {
		List<PersonDto> persons = null;
		try {
			persons = dao.getPersonPageList("personSql.selectPagePerson", page);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return persons;
	}
	// show search person
	public List<PersonDto> getPersonList(int searchOption, String searchString) {
		List<PersonDto> persons = null;
		try {
			persons = dao.getPersonList("personSql.selectAllSearchPerson", searchOption, searchString);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return persons;
	}
	
	// show search page person
		public List<PersonDto> getPersonList(int page, int searchOption, String searchString) {
			List<PersonDto> persons = null;
			try {
				persons = dao.getPersonPageList("personSql.selectPageSearchPerson", page, searchOption, searchString);
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			return persons;
		}
	
	// add Person
	public void insertPerson(PersonDto person) {
		try {
			dao.addPerson("personSql.insertPerson", person);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	// find maxId
	public int getMaxId(int i) {
		int maxId = 0;
		try {
			maxId = dao.searchMaxId("personSql.selectMaxId", i);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return maxId;
	}
	
	// get temper
	public List<TemperDto> getTemper(int options) {
		List<TemperDto> list = null;
		if (options == 0 || options == 1) {
			list = dao.searchTemper("personSql.selectTemperForStudentAndProfessor");
		} else if (options == 2) {
			list = dao.searchTemper("personSql.selectTemperForFaculty");
		}
		return list;
	}
	
	// add Picture
	public void insertPicture(PictureDto picture) {
		dao.addPicture("personSql.insertPicture", picture);
	}
	
	// get temper_num
	public int selectTemper_num(String temper_name) {
		int temper_num = 0;
		try {
			temper_num = dao.getTemper_num("personSql.selectTemper_num", temper_name);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return temper_num;
	}
}
