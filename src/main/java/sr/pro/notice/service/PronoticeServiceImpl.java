package sr.pro.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import sr.pro.notice.model.PronoticeDAO;
import sr.pro.notice.model.PronoticeDTO;

@Service
public class PronoticeServiceImpl implements PronoticeService {

	@Autowired
	@Qualifier("pronoticeDAO")
	private PronoticeDAO pdao;
	
	public void setPdao(PronoticeDAO pdao) {
		this.pdao = pdao;
	}

	// mainPage에 글 정보 찾아오기
		@Override
		public List<PronoticeDTO> getList(int startRow, int endRow) {
				
			List<PronoticeDTO> list = null;
			
			try {
				list = pdao.getList(startRow, endRow);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}

		// 서치된 글 목록 가져오기
		@Override
		public List<PronoticeDTO> getSearchList(int options, String searchContent, int startRow, int endRow) {
			List<PronoticeDTO> list = null;
			
			try {
				list = pdao.getSearchList(options, searchContent, startRow, endRow);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		
		// 글의 개수 가져오기
		@Override
		public int count() {
				
			int count = pdao.count();
				
			return count;
		}
		// 서치된 글의 개수 가져오기
		@Override
		public int searchCount(int options, String searchContent) {
			
			int searchCount = pdao.searchCount(options, searchContent);
			
			return searchCount;
		}
		
		/////////////////////////////////////////////////////////////////////////////
		// 글 추가하기
		@Override
		public void insertContent(PronoticeDTO dto) {

			pdao.insertContent(dto);
				
		}
		// 글 상세하게 찾아오기
		@Override
		public PronoticeDTO detailContent(int num) {
				
			PronoticeDTO dto = pdao.detailContent(num);
				
			return dto;
		}
		
		// 글 상세하게 찾아오기
		@Override
		public PronoticeDTO updateContentInfo(int num) {
					
			PronoticeDTO dto = pdao.updateContentInfo(num);
					
			return dto;
		}
			
		// 글 수정하기
		@Override
		public void updateContent(PronoticeDTO dto) {
				
			pdao.updateContent(dto);
				
		}
		
		// 글 삭제하기
		@Override
		public void deleteContent(int num) {
			
			pdao.deleteContent(num);
			
		}

}
