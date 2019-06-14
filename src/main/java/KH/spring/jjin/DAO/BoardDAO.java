package KH.spring.jjin.DAO;

import java.util.List;

import KH.spring.jjin.DTO.BoardDTO;

public interface BoardDAO {
public void deleteFile(String fullName);	//÷������ ����
public List<String> getAttach(int bno);		//÷������ ���
public void addAttach(String fullName);		//÷������ ����
public void updateAttach(String fullName,int bno);	//�ߺ����� ����
public void create(BoardDTO dto) throws Exception;	//�۾���
public BoardDTO read(int bno) throws Exception;		//���б�
public void update(BoardDTO dto) throws Exception;	//�ۼ���
public void delete(int bno) throws Exception;		//�ۻ���

//���(������ ������,�˻���� ����)
public List<BoardDTO> listAll(int start,int end) throws Exception;
 
//��ȸ�� ���� ó��
public void increaseViewcnt(int bno) throws Exception;
//���ƿ� ����ó��
public void increaseSweet(BoardDTO dto) throws Exception;
//���ڵ� ���� ��� 
public int countArticle() throws Exception;

}


