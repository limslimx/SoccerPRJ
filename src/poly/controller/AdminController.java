package poly.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.UserDTO;
import poly.service.impl.AdminService;

@Controller
public class AdminController {
	
	private Logger log=Logger.getLogger(this.getClass());
	
	@Resource(name="AdminService")
	private AdminService adminService;
	
	@RequestMapping(value="userInfoList")
	public String UserInfoAdmin(ModelMap model) throws Exception{
		log.info(this.getClass().getName()+".userInfoList start!");
		
		
		List<UserDTO> uList=new ArrayList<>();
		
		try {
			uList=adminService.getUserList();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			log.info(this.getClass().getName()+".userInfoList end!");
			model.addAttribute("uList", uList);
		}
		
		
		return "/admin/userInfo/userInfoList";
	}
	
	@RequestMapping(value="userInfoDetail")
	public String UserInfoDetail(HttpServletRequest request, ModelMap model) throws Exception{
		log.info(this.getClass().getName()+".userInfoDetail start!");
		
		UserDTO uDTO=new UserDTO();
		
		String user_id=request.getParameter("user_id");
		log.info(user_id);
		
		try {
			uDTO.setId(user_id);
			
			uDTO=adminService.getUserDetail(uDTO);
			
			model.addAttribute("uDTO", uDTO);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			log.info(this.getClass().getName()+".userInfoDetail end!");
			uDTO=null;
		}
		
		return "/admin/userInfo/userInfoDetail";
	}
	
	@RequestMapping(value="userInfoDelete")
	public String UserInfoDelete(HttpServletRequest request, ModelMap model) throws Exception{
		log.info(this.getClass().getName()+".userInfoDelete start!");
		
		int res=0;
		
		UserDTO uDTO=new UserDTO();
		
		String user_id=request.getParameter("user_id");
	
		try {
			uDTO.setId(user_id);
			
			res=adminService.userInfoDelete(uDTO);
			
			if(res>0) {
				model.addAttribute("url", "/userInfoList.do");
				model.addAttribute("msg", "회원탈퇴에 성공하였습니다.");
			} else {
				model.addAttribute("url", "/userInfoList.do");
				model.addAttribute("msg", "회원탈퇴에 실패하였습니다.");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			log.info(this.getClass().getName()+".userInfoDelete end!");
			uDTO=null;
		}
		
		return "/redirect";
	}
}