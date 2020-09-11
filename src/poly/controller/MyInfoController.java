package poly.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.PlayerDTO;
import poly.dto.TeamNewsDTO;
import poly.dto.TeamRankDTO;
import poly.dto.TeamScheduleDTO;
import poly.service.IMyInfoService;
import poly.util.CmmUtil;

@Controller
public class MyInfoController {

	private Logger log=Logger.getLogger(this.getClass());
	
	@Resource(name="MyInfoService")
	private IMyInfoService myInfoService;
	
	@Scheduled(cron="0 0/5 * * * *")
	@RequestMapping(value="myNewsUpdate")
	public String MyTeam() throws Exception{
		log.info(this.getClass().getName()+".myNewsUpdate start!");
		
		TeamNewsDTO pDTO=new TeamNewsDTO();
		
		try {
			myInfoService.updateLiverpoolNews(pDTO);
			myInfoService.updateMancityNews(pDTO);
			myInfoService.updateTottenhamNews(pDTO);
			myInfoService.updateChelseaNews(pDTO);
			myInfoService.updateManuNews(pDTO);
			myInfoService.updateArsenalNews(pDTO);
			myInfoService.updateBarcelonaNews(pDTO);
			myInfoService.updateRealmadridNews(pDTO);
			myInfoService.updateBayernmunichNews(pDTO);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			pDTO=null;
			log.info(this.getClass().getName()+".myNewsUpdate end!");
		}
		return null;
	}
	
	@RequestMapping(value="selectMyNews")
	public String SelectMyNews(HttpSession session, ModelMap model) throws Exception{
		log.info(this.getClass().getName()+".selectMyNews start!");
		
		TeamNewsDTO pDTO=new TeamNewsDTO();
		
		List<TeamNewsDTO> nList=new ArrayList<TeamNewsDTO>();
		
		String team=CmmUtil.nvl((String)session.getAttribute("myTeam"));
		try {
			pDTO.setTeam(team);
			nList=myInfoService.selectTeamNews(pDTO);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			model.addAttribute("nList", nList);
			log.info(this.getClass().getName()+".selectMyNews end!");
		}
		
		return "/myInfo/myNews";
	}
	
	@RequestMapping(value="selectMyNewsDetail")
	public String selectMyNewsDetail(HttpServletRequest request, ModelMap model) throws Exception{
		log.info(this.getClass().getName()+".selectMyNewsDetail start!");
		
		String newsNo=request.getParameter("seq");
		
		TeamNewsDTO pDTO=new TeamNewsDTO();
		
		pDTO.setNewsNo(newsNo);
		try {
			pDTO=myInfoService.selectTeamNewsDetail(pDTO);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			model.addAttribute("nDTO", pDTO);
			pDTO=null;
			log.info(this.getClass().getName()+".selectMyNewsDetail end!");
		}
		
		return "/myInfo/myNewsDetail";
	}
	
	@RequestMapping(value="myPlayerUpdate")
	public String MyPlayerUpdate(HttpSession session) throws Exception{
		log.info(this.getClass().getName()+".myPlayerUpdate start!");
		
		PlayerDTO pDTO=new PlayerDTO();
		
		String team=CmmUtil.nvl((String)session.getAttribute("myTeam"));
		
		pDTO.setTeam(team);
		
		try {
			myInfoService.updatePlayer(pDTO);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			pDTO=null;
			log.info(this.getClass().getName()+".myPlayerUpdate end!");
		}
		return null;
	}
	
	@RequestMapping(value="myPlayerSelect")
	public String MyPlayerSelect(HttpSession session, ModelMap model) throws Exception{
		log.info(this.getClass().getName()+".myPlayerSelect start!");
		
		PlayerDTO pDTO=new PlayerDTO();
		
		List<PlayerDTO> nList=new ArrayList<PlayerDTO>();
		
		String team=CmmUtil.nvl((String)session.getAttribute("myTeam"));
		try {
			pDTO.setTeam(team);
			nList=myInfoService.selectPlayer(pDTO);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			model.addAttribute("nList", nList);
			log.info(this.getClass().getName()+".myPlayerSelect end!");
		}
		
		return "/myInfo/myPlayer";
	}
	
	@Scheduled(cron="0 0/5 * * * *")
	@RequestMapping(value="myRankUpdate")
	public String MyRankUpdate() throws Exception{
		log.info(this.getClass().getName()+".myRankUpdate start!");
		
		TeamRankDTO pDTO=new TeamRankDTO();
		
		try {
			myInfoService.updateLiverpoolRank(pDTO);
			myInfoService.updateMancityRank(pDTO);
			myInfoService.updateTottenhamRank(pDTO);
			myInfoService.updateChelseaRank(pDTO);
			myInfoService.updateManuRank(pDTO);
			myInfoService.updateArsenalRank(pDTO);
			myInfoService.updateBarcelonaRank(pDTO);
			myInfoService.updateRealmadridRank(pDTO);
			myInfoService.updateBayernmunichRank(pDTO);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			pDTO=null;
			log.info(this.getClass().getName()+".myRankUpdate end!");
		}
		return null;
	}
	
	@RequestMapping(value="myRankSelect")
	public String MyRankSelect(HttpSession session, ModelMap model) throws Exception{
		log.info(this.getClass().getName()+".myRankSelect start!");
		
		TeamRankDTO pDTO=new TeamRankDTO();
		
		List<TeamRankDTO> rList=new ArrayList<TeamRankDTO>();
		
		String team=CmmUtil.nvl((String)session.getAttribute("myTeam"));
		pDTO.setTeam(team);
		try {
			rList=myInfoService.selectTeamRank(pDTO);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			model.addAttribute("rList", rList);
			log.info(this.getClass().getName()+".myRankSelect end!");
		}
		
		return "/myInfo/myRank";
	}
	
	@RequestMapping(value="myScheduleUpdate")
	public String MyScheduleUpdate() throws Exception{
		log.info(this.getClass().getName()+"myScheduleUpdate start!");
		
		TeamScheduleDTO pDTO=new TeamScheduleDTO();
		
		try {
			myInfoService.updateLiverpoolSchedule(pDTO);
			myInfoService.updateMancitySchedule(pDTO);
			myInfoService.updateTottenhamSchedule(pDTO);
			myInfoService.updateChelseaSchedule(pDTO);
			myInfoService.updateManuSchedule(pDTO);
			myInfoService.updateArsenalSchedule(pDTO);
			myInfoService.updateBarcelonaSchedule(pDTO);
			myInfoService.updateRealmadridSchedule(pDTO);
			myInfoService.updateBayernmunichSchedule(pDTO);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			pDTO=null;
			log.info(this.getClass().getName()+".myScheduleUpdate end!");
		}
		return null;
	}
}
