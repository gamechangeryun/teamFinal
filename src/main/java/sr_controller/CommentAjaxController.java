package sr_controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.ServerCookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import sr_model.commentDTO;
import sr_service.CommentService;

@Controller
public class CommentAjaxController {

	@Autowired
	CommentService service;
	
	public void setService(CommentService service) {
		this.service = service;
	}

	//댓글등록
	@RequestMapping(value="/mtmt/addComment.do", method=RequestMethod.POST, produces="text/plain; charset=UTF-8")
    @ResponseBody
    public String ajax_addComment(@ModelAttribute("coDTO") commentDTO coDTO, HttpServletRequest request, HttpServletResponse resp) throws Exception{
		resp.setContentType("text/html; charset=UTF-8");
		
		
       // HttpSession session = request.getSession();
       // LoginVO loginVO = (LoginVO)session.getAttribute("loginVO");
        
        try{
        	System.out.println("댓글입력:"+coDTO);
        	
        	service.commmentInsert(coDTO);
        	
            //boardVO.setWriter(loginVO.getUser_id());        
            
        } catch (Exception e){
            e.printStackTrace();
        }
        
        return "success";
    }
	
	//댓글 불러오기
	@RequestMapping(value="/mtmt/commentList.do", produces="application/json; charset=utf8")
	@ResponseBody
	public String commentList(@ModelAttribute("coDTO")commentDTO coDTO, HttpServletRequest request, HttpServletResponse resp)throws Exception{
		resp.setContentType("text/html; charset=UTF-8");
		
		//HttpHeaders responseHeaders = new HttpHeaders();
        //ArrayList<HashMap> hmlist = new ArrayList<HashMap>();
		
		//글번호마다 지정된 댓글을 불러온다.
		int n = coDTO.getNum();
		System.out.println(coDTO.getNum());
				
        // 해당 게시물 댓글
        List<commentDTO> comment = service.commentList(n);
        
        System.out.println("코멘트리스트 :" + comment);
        
        //json date 형식을 표현하기 위한 string 변환
		DateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ArrayList<String> ary = new ArrayList<String>();
		for(int i=0; i<comment.size(); i++) {
			Date nowDate = new Date();
			nowDate = comment.get(i).getWritedate();
			String tempDate = sdFormat.format(nowDate);
			ary.add(tempDate);
		}
        
        
        
        
        //json객체로 넘겨준다.
        JSONObject jso = new JSONObject();
        jso.put("data", comment);
        jso.put("date", ary);
        
        return jso.toString();
        
        //주석처리된 부분은 해시맵으로 시도한 부분인데 값처리에 에러가있어서 보류
        /*if(comment.size() > 0){
            for(int i=0; i<comment.size(); i++){
                HashMap hm = new HashMap();
                hm.put("comment_num", comment.get(i).getComment_num());
                hm.put("content", comment.get(i).getContent());
                hm.put("id", comment.get(i).getId());
                
                hmlist.add(hm);
            }
        }
        
        System.out.println("hmList:" + hmlist);*/
        
        //JSONArray json = new JSONArray();
        //json.add(hmlist);
        //return new ResponseEntity(json.toString(), responseHeaders, HttpStatus.CREATED);
	}
	
	//댓글 수정
	@RequestMapping(value="/mtmt/commentUpdate.do", method=RequestMethod.POST, produces="text/plain; charset=UTF-8")
	@ResponseBody
	private String commentUpdate(commentDTO coDTO, HttpServletRequest request, HttpServletResponse resp)throws Exception{
		
		System.out.println("댓글수정 체크:" + coDTO);
		
		try {
			service.commentUpdate(coDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "success";
	}
	
	//댓글 삭제
	@RequestMapping(value="/mtmt/commentDelete.do")
	@ResponseBody
	private String commentDelete(@RequestParam("comment_num") int comment_num)throws Exception{
		
		try {
			service.commentDelete(comment_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "success";
	}
	
	
}//class