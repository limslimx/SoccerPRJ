package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.NotiDTO;
import poly.dto.UserDTO;

@Mapper("AdminMapper")
public interface AdminMapper {

	List<UserDTO> getUserList() throws Exception;
	UserDTO getUserDetail(UserDTO uDTO) throws Exception;
	int userInfoDelete(UserDTO uDTO) throws Exception;
	List<NotiDTO> getNotiList() throws Exception;
	int insertNotiInfo(NotiDTO nDTO) throws Exception;
	NotiDTO getNotiDetail(NotiDTO nDTO) throws Exception;
	int updateNotiInfo(NotiDTO nDTO) throws Exception;
	int deleteNotiInfo(NotiDTO nDTO) throws Exception;
}
