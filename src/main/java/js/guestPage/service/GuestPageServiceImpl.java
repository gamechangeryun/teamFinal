package js.guestPage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import js.guestPage.model.GuestPageDAO;

@Service
public class GuestPageServiceImpl implements GuestPageService{

	@Autowired
	private GuestPageDAO dao;

	public void setDao(GuestPageDAO dao) {
		this.dao = dao;
	}
	
	
}
