package KH.spring.jjin.DAO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import KH.spring.jjin.DTO.CclsDTO;
@Repository
public class CclsDAOImpl implements CclsDAO {

	@Autowired 
	SqlSession sqlSession;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}

	@Override
	public List<CclsDTO> CclsList() {

return sqlSession.selectList("ccls.cclsList");
	} 

	@Override
	public void insertCcls(CclsDTO vo) {
sqlSession.insert("ccls.insertccls",vo);
	}

	@Override
	public CclsDTO viewCcls(int id) {
		return sqlSession.selectOne("ccls.viewccls",id);
	}

	@Override
	public void deleteCcls(int id) {
sqlSession.delete("ccls.deleteccls",id);
	}

	@Override
	public void updateCcls(CclsDTO vo) {
sqlSession.update("ccls.updateccls",vo);
	}


	
	

}
