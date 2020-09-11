package poly.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.NewsDTO;
import poly.dto.RankDTO;
import poly.dto.ScheduleDTO;
import poly.service.ISoccerService;

@Controller
public class SoccerController {

	private Logger log=Logger.getLogger(this.getClass());
	
	@Resource(name="SoccerService")
	private ISoccerService soccerService;
	
	@Scheduled(cron="0 0/5 * * * *")
	@RequestMapping(value="updateRank")
	public String UpdateRank() throws Exception{
		log.info(this.getClass().getName()+".updateRank start!");
		
		RankDTO pDTO=null;
		
		soccerService.updateRank(pDTO);
		
		return null;
	}
	
	@RequestMapping(value="selectRank")
	public String SelectRank(ModelMap model) throws Exception{
		log.info(this.getClass().getName()+"selectRank start!");
		
		List<RankDTO> rList=new ArrayList<RankDTO>();
		
		try {
			rList=soccerService.selectRank();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			model.addAttribute("rList", rList);
			log.info(this.getClass().getName()+".selectRank end!");
		}
		
		return "/soccer/rank";
	}
	
	@RequestMapping(value="updateSchedule")
	public String UpdateSchedule(HttpServletRequest request, ModelMap model) throws Exception{
		
		log.info(this.getClass().getName()+".updateSchedule start!");
		
		List<ScheduleDTO> sList=new ArrayList<ScheduleDTO>();
		
		String date=request.getParameter("date");
		
		log.info("date: "+date);
		
		ScheduleDTO pDTO=new ScheduleDTO();	
		pDTO.setDate(date);
		
		try {
			sList=soccerService.updateSchedule(pDTO);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			model.addAttribute("sList", sList);
			model.addAttribute("date",date);
			log.info(this.getClass().getName()+".updateSchedule end!");
		}
		return "/soccer/schedule";
	}
	
	@RequestMapping(value="selectSchedule")
	public String SelectSchedule(ModelMap model) throws Exception{
		log.info(this.getClass().getName()+".selectSchedule start!");
		
		List<ScheduleDTO> sList=new ArrayList<ScheduleDTO>();
		
		try {
			sList=soccerService.selectSchedule();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			model.addAttribute("sList", sList);
			log.info(this.getClass().getName()+".selectSchedule end!");
		}
		
		return "/soccer/schedule";
	}

	@Scheduled(cron="0 0/5 * * * *")
	@RequestMapping(value="updateNews")
	public String UpdateNews() throws Exception{
		log.info(this.getClass().getName()+".updateNews start!");
		
		NewsDTO pDTO=null;
		
		soccerService.updateNews(pDTO);
		
		return null;
	}
	
	@RequestMapping(value="selectNews")
	public String SelectNews(ModelMap model) throws Exception{
		log.info(this.getClass().getName()+".selectNews start!");
		
		List<NewsDTO> nList=new ArrayList<NewsDTO>();
		
		try {
			nList=soccerService.selectNews();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			model.addAttribute("nList", nList);
			log.info(this.getClass().getName()+".selectNews end!");
		}
		
		return "/soccer/news";
	}
	
	@RequestMapping(value="showSoccerNewsDetail")
	public String ShowSoccerNewsDetail(HttpServletRequest request, ModelMap model) throws Exception{
		log.info(this.getClass().getName()+".showSoccerNewsDetail");
		
		String newsNo=request.getParameter("seq");
		
		NewsDTO pDTO=new NewsDTO();
		
		pDTO.setNewsNo(newsNo);
		try {
			pDTO=soccerService.selectNewsDetail(pDTO);
		} catch(Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("nDTO", pDTO);
		
		return "/soccer/newsDetail";
	}
}
