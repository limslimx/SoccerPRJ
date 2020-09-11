package poly.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import poly.dto.MailDTO;
import poly.dto.UserDTO;
import poly.persistance.mapper.UserMapper;
import poly.service.IMailService;
import poly.service.IUserService;
import poly.util.CmmUtil;
import poly.util.EncryptUtil;

@Service("UserService")
public class UserService implements IUserService{

	private Logger log=Logger.getLogger(getClass());
	
	@Resource(name="UserMapper")
	private UserMapper userMapper;
	
	@Resource(name="MailService")
	private IMailService mailService;
	
	@Override
	public int userRegProc(UserDTO uDTO) throws Exception {
		return userMapper.userRegProc(uDTO);
	}

	@Override
	public UserDTO idCheck(String id) throws Exception {
		return userMapper.idCheck(id);
	}

	@Override
	public UserDTO getLogin(UserDTO uDTO) throws Exception {
		return userMapper.getLogin(uDTO);
	}

	@Override
	public String findID(UserDTO pDTO) throws Exception {
		int res=0;
		
		UserDTO fDTO=userMapper.findID(pDTO);
		
		if(fDTO==null) {
			fDTO=new UserDTO();
		}

		if(CmmUtil.nvl(fDTO.getId()).length()>0) {
			res=1;
		}
		
		return fDTO.getId();
	}

	@Override
	public UserDTO emailCheck(String email) throws Exception {
		return userMapper.emailCheck(email);
	}

	@Override
	public int findPw(UserDTO pDTO) throws Exception {

		int res=0;
		String passwd=pDTO.getPasswd();
		
		userMapper.changePw(pDTO);
		
		UserDTO uDTO=userMapper.getUserInfo(pDTO);
		
		if(uDTO!=null) {
			res=1;
			
			log.info("################메일 발송 성공");
			//mail 발송 로직 추가
			MailDTO mDTO=new MailDTO();
			
			mDTO.setToMail(EncryptUtil.decAES128CBC(CmmUtil.nvl(uDTO.getEmail())));
			mDTO.setTitle("Socsche의 임시비밀번호입니다.");
			mDTO.setContents("임시비밀번호는 "+CmmUtil.nvl(passwd)+"입니다.");
			
			
			mailService.doSendMail(mDTO);
			
		} else {
			res=0;
		}
		return res;
	}

	@Override
	public UserDTO pwCheck(UserDTO pDTO) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.pwCheck(pDTO);
	}

	@Override
	public int updateEmail(UserDTO pDTO) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.updateEmail(pDTO);
	}

	@Override
	public int updatePw(UserDTO pDTO) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.updatePw(pDTO);
	}

}