package poly.persistance.mapper;

import config.Mapper;
import poly.dto.UserDTO;

@Mapper("UserMapper")
public interface UserMapper {

	int userRegProc(UserDTO uDTO) throws Exception;

	UserDTO idCheck(String id) throws Exception;

	UserDTO getLogin(UserDTO uDTO) throws Exception;

	UserDTO findID(UserDTO pDTO) throws Exception;

	UserDTO emailCheck(String email) throws Exception;

	UserDTO getUserInfo(UserDTO pDTO) throws Exception;
	
	void changePw(UserDTO pDTO) throws Exception;
	
	UserDTO pwCheck(UserDTO pDTO) throws Exception;
	
	int updateEmail(UserDTO pDTO) throws Exception;
	
	int updatePw(UserDTO pDTO) throws Exception;

}