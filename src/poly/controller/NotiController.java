package poly.controller;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.NotiDTO;
import poly.dto.pagingDTO;
import poly.service.INotiService;
import poly.util.CmmUtil;


@Controller
public class NotiController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="NotiService")
	private INotiService notiService;
	
	@RequestMapping(value="/notiReg")
	public String NotiReg(HttpSession session,ModelMap model) {
		String userId=(String)session.getAttribute("user_id");
		log.info(userId);
		if(userId==null) {
			model.addAttribute("msg","로그인이 필요한 서비스 입니다.");
			model.addAttribute("url","/index.do");
			return "/redirect";
		}

		return "/noti/notiRegOriginal";
	}
	@RequestMapping(value="/notiRegProc")
	public String NotiRegProc(HttpSession session, HttpServletRequest request, Model model) {
		
		String title = CmmUtil.nvl(request.getParameter("title"));
		String content = CmmUtil.nvl(request.getParameter("content"));
		String regNo=CmmUtil.nvl((String)session.getAttribute("user_id"));
		
		NotiDTO pDTO = new NotiDTO();
		pDTO.setTitle(title);
		pDTO.setContent(content);
		pDTO.setRegNo(regNo);
		
		int result = 0;
				
		try {
			result = notiService.insertNotiInfo(pDTO);
		} catch(Exception e) {
			e.printStackTrace();
		}
		if(result>0) {
			model.addAttribute("url","/notiList.do");
			model.addAttribute("msg", "등록 성공");
		} else {
			model.addAttribute("url","/notiReg.do");
			model.addAttribute("msg", "등록 실패");
		}
		return "/redirect";
	}
	
	@RequestMapping(value="/notiList")
	public String NotiList(HttpSession session,Model model,HttpServletRequest request) throws Exception {
		String userId=(String)session.getAttribute("user_id");
		log.info(userId);
		if(userId==null) {
			model.addAttribute("msg","로그인이 필요한 서비스 입니다.");
			model.addAttribute("url","/index.do");
			return "/redirect";
		}
		//현재 페이지 번호 받기
		int pgNum = 1;
		if(request.getParameter("pgNum")!=null&&!request.getParameter("pgNum").equals("")) {
			pgNum = Integer.parseInt(request.getParameter("pgNum"));
		}
		int total = notiService.getNotiTotal();
		int startNum = (pgNum-1)*10+1;
		int endNum = pgNum*10;
		pagingDTO pDTO = new pagingDTO();
		pDTO.setEndNum(endNum);
		pDTO.setStartNum(startNum);
		
		List<NotiDTO> nList = new ArrayList<>();
		
		try {
			nList = notiService.getNotiList(pDTO);
		} catch(Exception e) {
			e.printStackTrace();
		}
		if(nList==null) {
			nList = new ArrayList<NotiDTO>();
		}else {
			for(int i = 0; i<nList.size();i++) {
				NotiFilter(nList.get(i));
			}
		}
		model.addAttribute("nList", nList);
		model.addAttribute("pgNum", pgNum);
		model.addAttribute("total", total);
		return "/noti/notiList";
	}
	@RequestMapping(value="/noti/notiDetail")
	public String NotiDetail(HttpSession session,HttpServletRequest request, Model model)  throws Exception {
		String userId=(String)session.getAttribute("user_id");
		if(userId==null) {
			model.addAttribute("msg","로그인이 필요한 서비스 입니다.");
			model.addAttribute("url","/index.do");
			return "/redirect";
		}
		String notiNo = request.getParameter("seq");
		
		log.info(notiNo);
		
		notiService.viewcount(notiNo);
		
		String seq = request.getParameter("seq");
		
		log.info(seq);
		
		NotiDTO nDTO = new NotiDTO();
		
		try {
			nDTO = notiService.getNotiDetail(notiNo);
		} catch(Exception e) {
			e.printStackTrace();
		}
		if(nDTO==null) {
			nDTO = new NotiDTO();
		}else {
			NotiFilter(nDTO);
		}
		model.addAttribute("nDTO", nDTO);
		
		return "/noti/notiDetail";	
	}
	@RequestMapping(value="/noti/notiModify")
	public String NotiModify(HttpSession session,HttpServletRequest request, Model model) {
		String userId=(String)session.getAttribute("user_id");
		if(userId==null) {
			model.addAttribute("msg","로그인이 필요한 서비스 입니다.");
			model.addAttribute("url","/index.do");
			return "/redirect";
		}
		String seq = request.getParameter("seq");
		
		log.info(seq);
		NotiDTO nDTO = new NotiDTO();
		try {
			nDTO = notiService.getNotiDetail(seq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(nDTO==null) {
			nDTO = new NotiDTO();
		}else {
			NotiFilter(nDTO);
		}
		model.addAttribute("nDTO", nDTO);
		
		return "/noti/notiModify";
	}
	@RequestMapping(value="/notiModifyProc")
	public String NotiModifyProc(HttpServletRequest request, Model model) {
		
		log.info(this.getClass().getName()+".notiModifyProc Start!");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String seq = request.getParameter("seq");
		
		log.info(seq);
		
		NotiDTO nDTO = new NotiDTO();
		nDTO.setTitle(title);
		nDTO.setContent(content);
		nDTO.setNotiNo(seq);
		
		int result = 0;
		
		try {
			result = notiService.updateNoti(nDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(result>0) {
			model.addAttribute("url","/noti/notiDetail.do?seq="+seq);
			model.addAttribute("msg","수정 성공");
		} else {
			model.addAttribute("url","/noti/notiModify.do?seq="+seq);
			model.addAttribute("msg","수정 실패");
		}
		
		return "/redirect";
	}
	@RequestMapping(value="/notiDelete")
	public String NotiDelete(HttpServletRequest request, Model model) {
		NotiDTO nDTO = new NotiDTO();
		
		String seq = request.getParameter("seq");
		
		log.info(seq);
		
		int result = 0;
		
		try {
			result = notiService.deleteNoti(seq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(result>0) {
			model.addAttribute("url","/notiList.do");
			model.addAttribute("msg", "삭제 성공");
		} else {
			model.addAttribute("url","/noti/notiDetail.do");
			model.addAttribute("msg","삭제 실패");
		}
		
		return "/redirect";
	}
	
	public NotiDTO NotiFilter(NotiDTO pDTO) {
		if(pDTO.getTitle()!=null) {
			pDTO.setTitle(pDTO.getTitle().replaceAll("scr!pt", "script"));
			pDTO.setTitle(pDTO.getTitle().replaceAll("& lt;", "&lt;").replaceAll("& gt;", "&gt;"));
			pDTO.setTitle(pDTO.getTitle().replaceAll("& #40;", "(").replaceAll("& #41;", ")"));
			pDTO.setTitle(pDTO.getTitle().replaceAll("& #39;", "&#39;"));
		}
		if(pDTO.getContent()!=null) {
			pDTO.setContent(pDTO.getContent().replaceAll("scr!pt", "script"));
			pDTO.setContent(pDTO.getContent().replaceAll("& lt;", "<").replaceAll("& gt;", ">"));
			pDTO.setContent(pDTO.getContent().replaceAll("<script", "&lt;script"));
			pDTO.setContent(pDTO.getContent().replaceAll("& #40;", "(").replaceAll("& #41;", ")"));
			pDTO.setContent(pDTO.getContent().replaceAll("& #39;", "&#39;"));
		}
		return pDTO;
	}
}
