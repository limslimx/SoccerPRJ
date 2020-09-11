package poly.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import poly.dto.TeamNewsDTO;
import poly.dto.UserDTO;
import poly.service.IUserService;
import poly.service.impl.KakaoAPI;
import poly.util.CmmUtil;
import poly.util.EncryptUtil;

@Controller
public class UserController {
	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
    private KakaoAPI kakao;
	
	@Resource(name = "UserService")
	private IUserService userService;
	
	@RequestMapping(value="login")
	public String Login() throws Exception{
		log.info("accessed login");

		return "/user/signIn";
	}
	
	@RequestMapping(value="menu")
	public String Menu() throws Exception{
		log.info("accessed login");

		return "/menu";
	}
	
	
	@RequestMapping(value="index")
	public String Index(HttpSession session) {
		String userId=(String)session.getAttribute("user_id");
		log.info(this.getClass());
		
		if(userId!=null) {
			return "/home";
		}else {
			return "/user/signIn";
		}
		
	}
	
	@RequestMapping(value="/kakaoLogin", produces = "application/json", method = {RequestMethod.GET, RequestMethod.POST})
	public String login(@RequestParam("code") String code, HttpSession session) {
		
	    String access_Token = kakao.getAccessToken(code);

	    HashMap<String, Object> userInfo = kakao.getUserInfo(access_Token);
	    System.out.println("login Controller : " + userInfo);
	    
	    //    클라이언트의 이메일이 존재할 때 세션에 해당 이메일과 토큰 등록
	    if (userInfo.get("email") != null) {
	        session.setAttribute("user_id", userInfo.get("nickname"));
	        session.setAttribute("access_Token", access_Token);
	        
	        log.info("#############"+session.getAttribute("user_id"));
	    }
		return "/home";
	}
	
	@RequestMapping(value = "UserReg")
	public String UserReg(ModelMap model) throws Exception {
		log.info("accessed UserReg");
		
		return "/user/signUp";
	}

	@RequestMapping(value = "UserRegProc")
	public String UserRegProc(HttpServletRequest request, HttpServletResponse response, ModelMap model)
			throws Exception {
		String id = CmmUtil.nvl(request.getParameter("id"));
		String email = CmmUtil.nvl(request.getParameter("email"));
		String passwd = CmmUtil.nvl(request.getParameter("passwd"));
		String team=CmmUtil.nvl(request.getParameter("team"));
		String regDate = CmmUtil.nvl(request.getParameter("regDate"));
		String regNo = CmmUtil.nvl(request.getParameter("regNo"));
		String updDate = CmmUtil.nvl(request.getParameter("updDate"));
		String updNo = CmmUtil.nvl(request.getParameter("updNo"));
		
		
		log.info("#####################"+team);
		
		UserDTO uDTO = new UserDTO();
		uDTO.setEmail(EncryptUtil.encAES128CBC(email));
		uDTO.setId(id);
		uDTO.setPasswd(EncryptUtil.encHashSHA256(passwd));
		uDTO.setTeam(team);
		uDTO.setRegDate(regDate);
		uDTO.setRegNo(regNo);
		uDTO.setUpdDate(updDate);
		uDTO.setUpdNo(updNo);
		
		int result = 0;

		result = userService.userRegProc(uDTO);
		log.info("결과값 : " + result);

		if (result > 0) {
			model.addAttribute("url", "/index.do");
			model.addAttribute("msg", "가입완료");
		} else {
			model.addAttribute("url", "/user/signUp.do");
			model.addAttribute("msg", "가입실패");
		}

		return "/redirect";
	}
	
	@ResponseBody
	@RequestMapping(value="/idCheck.do", method = RequestMethod.POST)
	public int idCheck(HttpServletRequest request) throws Exception {
		log.info("idCheck");

		String id = request.getParameter("id");
		log.info(id);
		UserDTO uDTO = userService.idCheck(id);

		int result = 0;

		if (uDTO != null) {
			result = 1;
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/emailCheck.do", method = RequestMethod.POST)
	public int emailCheck(HttpServletRequest request) throws Exception {
		log.info("emailCheck");

		String email = CmmUtil.nvl(request.getParameter("email"));
		log.info(email);
		UserDTO uDTO = userService.emailCheck(EncryptUtil.encAES128CBC(email));

		int result = 0;

		if (uDTO != null) {
			result = 1;
		}
		return result;
	}
	
	@RequestMapping(value="UserLogin")
	public String login(ModelMap model, HttpServletRequest request, HttpSession session) throws Exception{
		log.info("UserLogin");
		
		String id = CmmUtil.nvl(request.getParameter("id"));
		String passwd = CmmUtil.nvl(request.getParameter("passwd"));
		
		UserDTO uDTO = new UserDTO();
		
		uDTO.setId(id);
		uDTO.setPasswd(EncryptUtil.encHashSHA256(passwd));
		
		uDTO = userService.getLogin(uDTO);
		
		if(uDTO==null) {
			model.addAttribute("url", "/index.do");
			model.addAttribute("msg", "로그인에 실패하였습니다.");
		}else {
			model.addAttribute("url", "/index.do");
			model.addAttribute("msg", "로그인 성공");
			session.setAttribute("user_id", uDTO.getId());
			session.setAttribute("authority", uDTO.getAuthority());
			session.setAttribute("myTeam", uDTO.getTeam());
			
		}
		
		return "redirect";
	}
	
	@RequestMapping(value="logout")
	public String logout(HttpSession session, ModelMap model) throws Exception{
		
		session.invalidate();
		model.addAttribute("msg", "로그아웃했습니다.");
		model.addAttribute("url", "/index.do");
		return "/redirect";
	}
	
	@RequestMapping(value="FindUserID")
	public String findUserID() throws Exception{
		log.info("Request FindUserID");
		return "user/findUserId";
	}

	@RequestMapping(value = "FindUserIDProc")
	public String findUserIDProc(HttpServletRequest request, ModelMap model) throws Exception {
		log.info(this.getClass().getName()+".FindUserIDProc start!");
		UserDTO pDTO = null;
		String id="";
		
		try {
			String email=CmmUtil.nvl(request.getParameter("email"));
			log.info(email);
			
			pDTO = new UserDTO();
			pDTO.setEmail(EncryptUtil.encAES128CBC(email));
			
			id=userService.findID(pDTO);
			log.info(id);
			
			if(id!=null) {
				model.addAttribute("msg","찾으시는 아이디는 "+id+"입니다.");
				model.addAttribute("url","/login.do");
			} else {
				model.addAttribute("msg","입력하신 이메일에 일치하는 id가 없습니다.");
				model.addAttribute("url","/FindUserID.do");
			}
			
		} catch(Exception e) {
			log.info(e.toString());
		} finally {
			log.info(this.getClass().getName()+".findUserIdProc end!");
			pDTO=null;
			log.info(id);
		}
		return "/redirect"; 
	}
	
	@RequestMapping(value="FindUserPw")
	public String findUserPw() throws Exception{
		log.info("Request FindUserID");
		return "user/findUserPw";
	}
	
	@RequestMapping(value = "FindUserPwProc")
	public String findUserPwProc(HttpServletRequest request, ModelMap model) throws Exception {
		log.info(this.getClass().getName()+".findUserPwProc start!");
		
		char[] charSet=new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		
		int idx=0;
		StringBuffer sb=new StringBuffer();
		
		for(int i=0;i<8;i++) {
			idx=(int)(charSet.length*Math.random());
			sb.append(charSet[idx]);
		}
		
		UserDTO pDTO = null;
		
		int res=0;
		
		String pw=sb.toString();
		try {
			
			//passwd는 랜덤함수를 이용한 임시비밀번호를 암호화하기 전의 비밀번호를 나타냄
			//password는 랜덤함수를 이용한 임시비밀번호를 암호화한 후의 비밀번호를 나타냄
			String user_id=CmmUtil.nvl(request.getParameter("id"));
			String passwd=CmmUtil.nvl(pw);
			String password=CmmUtil.nvl(EncryptUtil.encHashSHA256(pw));
			log.info(user_id);
			log.info(password);
			
			pDTO = new UserDTO();
			pDTO.setId(user_id);
			pDTO.setPasswd(passwd);
			pDTO.setPasswd2(password);
			
			res=userService.findPw(pDTO);
			log.info(res);
			
			if(res==0) {
				model.addAttribute("msg","입력하신 Id는 회원이 아닙니다.");
				model.addAttribute("url","/FindUserPw.do");
			} else {
				model.addAttribute("msg","이메일로 임시비밀번호를 보내드렸습니다.");
				model.addAttribute("url","/login.do");
			}
			
		} catch(Exception e) {
			log.info(e.toString());
		} finally {
			log.info(this.getClass().getName()+".findUserPwProc end!");
			pDTO=null;
			
		}
		return "/redirect"; 
	}
	
	@RequestMapping(value="checkPw")
	public String CheckPw() throws Exception{
		log.info(this.getClass().getName()+".checkPw start!");
		
		return "/user/checkPw";
	}
	
	@RequestMapping(value="checkPwProc")
	public String CheckPw(HttpSession session, HttpServletRequest request, ModelMap model) throws Exception{
log.info(this.getClass().getName()+".checkPwProc start!");
		
		UserDTO uDTO=new UserDTO();
		
		String id=CmmUtil.nvl((String)session.getAttribute("user_id"));
		String password=CmmUtil.nvl(EncryptUtil.encHashSHA256(request.getParameter("passwd")));
		
		try {
			uDTO.setId(id);
			uDTO.setPasswd(password);
			
			uDTO=userService.pwCheck(uDTO);
			
			if(uDTO.getPasswd().equals(password)) {
				model.addAttribute("url", "/UserEdit.do");
				model.addAttribute("msg", "해당 회원정보페이지로 이동합니다.");
			} else {
				log.info("######################cjtqjsWo2");
				model.addAttribute("url", "/checkPw.do");
				model.addAttribute("msg", "입력하신 비밀번호에 해당하는 회원정보가 존재하지 않습니다.");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			log.info(this.getClass().getName()+".checkPwProc end!");
			uDTO=null;
		}
		
		return "/redirect";
	}
	
	// 회원정보 수정
	@RequestMapping(value = "UserEdit")
	public String userEdit() throws Exception{
		log.info("UserEdit");
		return "user/UserEdit";
	}
	
	@RequestMapping(value="updateEmail")
	public String UpdateEmail(HttpSession session, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		log.info(this.getClass().getName()+".updateEmail start!");
	
		int res=0;
		
		UserDTO pDTO=new UserDTO();
		
		String user_id=(String)session.getAttribute("user_id");
		String email=CmmUtil.nvl(request.getParameter("email"));
		String team=CmmUtil.nvl(request.getParameter("team"));
		
		try {
			pDTO.setId(user_id);
			pDTO.setEmail(EncryptUtil.encAES128CBC(email));
			pDTO.setTeam(team);
			res=userService.updateEmail(pDTO);
			
			if(res>0) {
				session.setAttribute("myTeam", team);
				model.addAttribute("url", "/UserEdit.do");
				model.addAttribute("msg", "이메일이 변경되었습니다.");
			} else {
				model.addAttribute("url", "/UserEdit.do");
				model.addAttribute("msg", "이메일 변경에 실패하였습니다.");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			log.info(this.getClass().getName()+".updateEmail end!");
			pDTO=null;
		}
		
		return "/redirect";
	}
	
	@RequestMapping(value="updatePw")
	public String UpdatePw(HttpSession session, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		log.info(this.getClass().getName()+".updatePw start!");
	
		int res=0;
		
		UserDTO pDTO=new UserDTO();
		
		String user_id=(String)session.getAttribute("user_id");
		String password=CmmUtil.nvl(request.getParameter("passwd"));
		
		try {
			pDTO.setId(user_id);
			pDTO.setPasswd(EncryptUtil.encHashSHA256(password));
			res=userService.updatePw(pDTO);
			
			if(res>0) {
				model.addAttribute("url", "/UserEdit.do");
				model.addAttribute("msg", "비밀번호가 변경되었습니다.");
			} else {
				model.addAttribute("url", "/UserEdit.do");
				model.addAttribute("msg", "비밀번호 변경에 실패하였습니다.");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			log.info(this.getClass().getName()+".updatePw end!");
			pDTO=null;
		}
		
		return "/redirect";
	}

}