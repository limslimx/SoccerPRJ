package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.NotiDTO;
import poly.dto.pagingDTO;

@Mapper("NotiMapper")
public interface NotiMapper {

	int insertNotiInfo(NotiDTO nDTO) throws Exception;

	List<NotiDTO> getNotiList(pagingDTO pDTO) throws Exception;

	NotiDTO getNotiDetail(String seq) throws Exception;

	int updateNoti(NotiDTO nDTO) throws Exception;

	int deleteNoti(String seq) throws Exception;
	
	void viewcount(String notiNo) throws Exception;

	int getNotiTotal() throws Exception;

}
