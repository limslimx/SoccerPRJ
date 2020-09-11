package poly.service;

import poly.dto.UserDTO;

public interface IUserService {

	int userRegProc(UserDTO uDTO) throws Exception;

	UserDTO idCheck(String id) throws Exception;

	UserDTO getLogin(UserDTO uDTO) throws Exception;

	String findID(UserDTO pDTO) throws Exception;

	UserDTO emailCheck(String email) throws Exception;

	int findPw(UserDTO pDTO) throws Exception;
	
	UserDTO pwCheck(UserDTO pDTO) throws Exception;

	int updateEmail(UserDTO pDTO) throws Exception;
	
	int updatePw(UserDTO pDTO) throws Exception;
}