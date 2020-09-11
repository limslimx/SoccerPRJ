package poly.service;

import java.util.List;

import poly.dto.NotiDTO;
import poly.dto.pagingDTO;

public interface INotiService {

	int insertNotiInfo(NotiDTO nDTO) throws Exception;

	List<NotiDTO> getNotiList(pagingDTO pDTO) throws Exception;

	NotiDTO getNotiDetail(String seq) throws Exception;

	int updateNoti(NotiDTO nDTO) throws Exception;

	int deleteNoti(String seq) throws Exception;
	
	void viewcount(String notiNo) throws Exception;

	int getNotiTotal() throws Exception;

}
