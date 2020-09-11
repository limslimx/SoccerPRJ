package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.NotiDTO;
import poly.dto.UserDTO;
import poly.persistance.mapper.AdminMapper;
import poly.persistance.mapper.UserMapper;
import poly.service.IAdminService;

@Service("AdminService")
public class AdminService implements IAdminService {

	@Resource(name="AdminMapper")
	private AdminMapper adminMapper;

	@Override
	public List<UserDTO> getUserList() throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.getUserList();
	}

	@Override
	public UserDTO getUserDetail(UserDTO uDTO) throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.getUserDetail(uDTO);
	}

	@Override
	public int userInfoDelete(UserDTO uDTO) throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.userInfoDelete(uDTO);
	}

	@Override
	public List<NotiDTO> getNotiList() throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.getNotiList();
	}

	@Override
	public int insertNotiInfo(NotiDTO nDTO) throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.insertNotiInfo(nDTO);
	}

	@Override
	public NotiDTO getNotiDetail(NotiDTO nDTO) throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.getNotiDetail(nDTO);
	}

	@Override
	public int updateNotiInfo(NotiDTO nDTO) throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.updateNotiInfo(nDTO);
	}

	@Override
	public int deleteNotiInfo(NotiDTO nDTO) throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.deleteNotiInfo(nDTO);
	}

}
