package sr_service;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class MtDownView extends AbstractView{

	public MtDownView() {
		setContentType("application/download; charset=UTF-8");
	}
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)throws Exception{
		System.out.println("다운로드 테스트");
		File file = (File)model.get("downloadFile");	// controller에서 얻어진 파일을 저장한다.
		
		response.setContentType(getContentType());		// 응답정보가 어떤 타입인지 알려준다 -> application/download현재는 이렇게 지정되어 있다.
		response.setContentLength((int)file.length());	// 다운로드 받을 크기를 알려준다
		
		String userAgent = request.getHeader("User-Agent");	// 브라우저 확인
		
		boolean ie = userAgent.indexOf("MSIE") > -1;		// microsoft인지 아닌지
		
		String fileName = null;
		if(ie) {
			fileName = URLEncoder.encode(file.getName(), "UTF-8");	// 파일 이름을 저장한다.
		}else {
			fileName = new String(file.getName().getBytes("UTF-8"), "iso-8859-1");	// 바이트 배열로 바꿔서 서버의 기본 인코딩으로 변환한다.
		}
		response.setHeader("Content-diposition", "attachment filename=\"" + fileName + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		OutputStream out = response.getOutputStream();
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, out);	// inputstream으로 파일을 읽어와서 outputstream으로 다시 저장한다.
		} finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		out.flush();	// 마지막 남아있는거까지 보내기 위해서
	}
}
