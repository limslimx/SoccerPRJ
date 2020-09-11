package poly.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import poly.dto.NewsDTO;
import poly.dto.RankDTO;
import poly.dto.ScheduleDTO;
import poly.persistance.mapper.ISoccerMapper;
import poly.service.ISoccerService;
import poly.util.CmmUtil;
import poly.util.DateUtil;

@Service("SoccerService")
public class SoccerService implements ISoccerService{

	private Logger log=Logger.getLogger(this.getClass());
	
	@Resource(name="SoccerMapper")
	private ISoccerMapper soccerMapper;
	
	@Override
	public void updateRank(RankDTO pDTO) throws Exception {

		log.info(this.getClass().getName()+".updateResult start!");
		
		int i=0, j=0;
		
		List<String> tList=new ArrayList<>();
		
		String url="https://www.goal.com/kr/%ED%94%84%EB%A6%AC%EB%AF%B8%EC%96%B4-%EB%A6%AC%EA%B7%B8/%EC%88%9C%EC%9C%84/2kwbbcootiqqgmrzs6o5inle5";
		
		Document doc=null;
		
		doc=Jsoup.connect(url).get();
		
		Elements element=doc.select("table.p0c-competition-tables__table");
		
		Elements image=doc.select("table.p0c-competition-tables__table tbody tr td:nth-child(3) a");
		
		Iterator<Element> rank=element.select("tbody tr td:nth-child(1)").iterator();
		Iterator<Element> team=element.select("tbody td.p0c-competition-tables__team span").iterator();
		Iterator<Element> total_match=element.select("tbody td.p0c-competition-tables__matches-played").iterator();
		Iterator<Element> won_match=element.select("tbody td.p0c-competition-tables__matches-won").iterator();
		Iterator<Element> draw_match=element.select("tbody td.p0c-competition-tables__matches-drawn").iterator();
		Iterator<Element> lost_match=element.select("tbody td.p0c-competition-tables__matches-lost").iterator();
		Iterator<Element> goal=element.select("tbody td.p0c-competition-tables__goals-for").iterator();
		Iterator<Element> lost=element.select("tbody td.p0c-competition-tables__goals-against").iterator();
		Iterator<Element> diff=element.select("tbody td.p0c-competition-tables__goals-diff").iterator();
		Iterator<Element> point=element.select("tbody td.p0c-competition-tables__pts").iterator();
		Iterator<Element> match=element.select("tbody td.p0c-competition-tables__last5").iterator();
		
		for(Element e : image) {
			tList.add(i, e.getElementsByAttribute("data-srcset").attr("data-srcset"));
			i++;
		}
		
		while(rank.hasNext()) {
			
			pDTO=new RankDTO();
			
			pDTO.setCollectTime(DateUtil.getDateTime("yyyyMMdd24hmmss"));
			
			pDTO.setRank(CmmUtil.nvl(rank.next().text()).trim());
			pDTO.setImage(CmmUtil.nvl(tList.get(j)));
			pDTO.setTeam(CmmUtil.nvl(team.next().text()).trim());
			pDTO.setTotalMatch(CmmUtil.nvl(total_match.next().text()).trim());
			pDTO.setWonMatch(CmmUtil.nvl(won_match.next().text()).trim());
			pDTO.setDrawMatch(CmmUtil.nvl(draw_match.next().text()).trim());
			pDTO.setLostMatch(CmmUtil.nvl(lost_match.next().text()).trim());
			pDTO.setGoal(CmmUtil.nvl(goal.next().text()).trim());
			pDTO.setLost(CmmUtil.nvl(lost.next().text()).trim());
			pDTO.setDiff(CmmUtil.nvl(diff.next().text()).trim());
			pDTO.setPoints(CmmUtil.nvl(point.next().text()).trim());
			pDTO.setGame(CmmUtil.nvl(match.next().text()).trim());
			pDTO.setRegNo("admin");
			
			log.info("##################################################"+pDTO.getRank());
			log.info("##################################################"+pDTO.getTeam());
			log.info("##################################################"+pDTO.getImage());
			log.info("##################################################"+pDTO.getTotalMatch());
			log.info("##################################################"+pDTO.getWonMatch());
			log.info("##################################################"+pDTO.getDrawMatch());
			log.info("##################################################"+pDTO.getLostMatch());
			log.info("##################################################"+pDTO.getGoal());
			log.info("##################################################"+pDTO.getLost());
			log.info("##################################################"+pDTO.getDiff());
			log.info("##################################################"+pDTO.getPoints());
			log.info("##################################################"+pDTO.getGame());
			
			soccerMapper.updateRank(pDTO);
			j++;
		}
		log.info(this.getClass().getName()+".updateRank end!");
	}

	@Override
	public List<RankDTO> selectRank() throws Exception {

		return soccerMapper.selectRank();
	}

	@Override
	public List<ScheduleDTO> updateSchedule(ScheduleDTO pDTO) throws Exception {

		log.info(this.getClass().getName()+".updateSchedule start!");
		
		List<ScheduleDTO> sList=new ArrayList<ScheduleDTO>();
		
		String url="https://www.goal.com/kr/%ED%94%84%EB%A6%AC%EB%AF%B8%EC%96%B4-%EB%A6%AC%EA%B7%B8/%EC%9D%BC%EC%A0%95-%EA%B2%B0%EA%B3%BC/"+pDTO.getDate()+"/2kwbbcootiqqgmrzs6o5inle5";
		
		Document doc=null;
		
		doc=Jsoup.connect(url).get();
		
		Elements element=doc.select("div.match-main-data");
		Elements element2=doc.select("div.match-main-data div.match-teams div.team-home span.crest");
		Elements element3=doc.select("div.match-main-data div.match-teams div.team-away span.crest");
		
		Iterator<Element> time=element.select("div.match-status time").iterator();
		Iterator<Element> teamHome=element.select("div.match-teams div.team-home span.team-name").iterator();
		Iterator<Element> teamAway=element.select("div.match-teams div.team-away span.team-name").iterator();
		Iterator<Element> scoreHome=element.select("div.match-teams div.team-home span.goals").iterator();
		Iterator<Element> scoreAway=element.select("div.match-teams div.team-away span.goals").iterator();
		
		List<String> hList=new ArrayList<String>();
		List<String> aList=new ArrayList<String>();
		
		int i=0, j=0, k=0;
		
		for(Element e : element2) {
			hList.add(i, e.getElementsByAttribute("src").attr("src"));
			i++;
		}
		for(Element e2: element3) {
			aList.add(k, e2.getElementsByAttribute("src").attr("src"));
			k++;
		}
		
		while(teamHome.hasNext()) {
			
			ScheduleDTO rDTO = new ScheduleDTO();
			
			rDTO.setCollectTime(DateUtil.getDateTime("yyyyMMdd24hmmss"));
			
			rDTO.setTime(CmmUtil.nvl(time.next().text()).trim());
			rDTO.setTeamHome(CmmUtil.nvl(teamHome.next().text()).trim());
			rDTO.setTeamAway(CmmUtil.nvl(teamAway.next().text()).trim());
			rDTO.setScoreHome(CmmUtil.nvl(scoreHome.next().text()).trim());
			rDTO.setScoreAway(CmmUtil.nvl(scoreAway.next().text()).trim());
			rDTO.setImageHome(CmmUtil.nvl(hList.get(j)));
			rDTO.setImageAway(CmmUtil.nvl(aList.get(j)));
			
			log.info("##################################################"+rDTO.getTime());
			log.info("##################################################"+rDTO.getTeamHome());
			log.info("##################################################"+rDTO.getTeamAway());
			log.info("##################################################"+rDTO.getScoreHome());
			log.info("##################################################"+rDTO.getScoreAway());
			
			sList.add(rDTO);
			rDTO=null;
			j++;
		}
		
		log.info(this.getClass().getName()+".updateSchedule end!");
		return sList;
	}

	@Override
	public List<ScheduleDTO> selectSchedule() throws Exception {
		// TODO Auto-generated method stub
		return soccerMapper.selectSchedule();
	}

	@Override
	public void updateNews(NewsDTO pDTO) throws Exception {
		
		log.info(this.getClass().getName()+".updateNews start!");
		
		String url="https://www.bbc.com/sport/football/premier-league";
		
		List<NewsDTO> rList = soccerMapper.selectNews();
		if(rList==null) {
			rList = new ArrayList<NewsDTO>();
		}
		
		Document doc=null;
		
		doc=Jsoup.connect(url).get();
		
		Elements element=doc.select("section#top-stories");
		
		Elements element2=doc.select("section#top-stories div.lakeside__body h3.lakeside__title");
		
		Elements element3=doc.select("section#top-stories article.lakeside--has-media div.gel-responsive-image");
		
		List<String> tList=new ArrayList<>();
		List<String> iList=new ArrayList<>();
		int i=0, j=0, k=0, t=0;
		
		
		for(Element e : element2) {
			tList.add(i, e.getElementsByAttribute("href").attr("href"));
			i++;
		}
		for(Element e2: element3) {
			iList.add(k, e2.getElementsByAttribute("data-srcset").attr("data-srcset"));
			k++;
		}
		
		Iterator<Element> title=element.select("span.lakeside__title-text").iterator();
		Iterator<Element> content=element.select("p.lakeside__summary").iterator();
		
		while(content.hasNext()) {
			
			pDTO=new NewsDTO();
			
			pDTO.setCollectTime(DateUtil.getDateTime("yyyyMMdd24hmmss"));
			
			pDTO.setImage(CmmUtil.nvl(iList.get(t)));
			pDTO.setTitle(CmmUtil.nvl(title.next().text()).trim());
			pDTO.setContent(CmmUtil.nvl(content.next().text()).trim());
			pDTO.setLink(CmmUtil.nvl("https://www.bbc.com"+tList.get(j)));
			
			log.info("##################################################"+pDTO.getImage());
			log.info("##################################################"+pDTO.getTitle());
			log.info("##################################################"+pDTO.getContent());
			log.info("##################################################"+pDTO.getLink());
	
			String url2=pDTO.getLink();
			
			Document doc2=null;
			
			doc2=Jsoup.connect(url2).get();
			
			Elements element4=doc2.select("article.component");
			
			Elements titleDetail=element4.select("h1.story-headline");
			Elements contentDetail=element4.select("div.story-body");
			
			pDTO.setTitleDetail(CmmUtil.nvl(titleDetail.text()).trim());
			pDTO.setContentDetail(CmmUtil.nvl(contentDetail.text()).trim());
			
			log.info("##################################################"+pDTO.getTitleDetail());
			log.info("##################################################"+pDTO.getContentDetail());
//			
//			String translatedTitle=papagoApi.translateTitle(pDTO);
//			String translatedContent=papagoApi.translateContent(pDTO);
//			String translatedTitleDetail=papagoApi.translateTitleDetail(pDTO);
//			String translatedContentDetail=papagoApi.translateContentDetail(pDTO);
//			
//			pDTO.setTranslatedTitle(CmmUtil.nvl(translatedTitle));
//			pDTO.setTranslatedContent(CmmUtil.nvl(translatedContent));
//			pDTO.setTranslatedTitleDetail(CmmUtil.nvl(translatedTitleDetail));
//			pDTO.setTranslatedContentDetail(CmmUtil.nvl(translatedContentDetail));
			int temp = 0;
			for(int x = 0; x<rList.size();x++) {
				if(pDTO.getTitle().equals(rList.get(x).getTitle())) {
					temp=1;
					break;
				}
			}
			if(temp==0) {
				soccerMapper.updateNews(pDTO);
			}
			
			j++;
			t++;
		}
		log.info(this.getClass().getName()+".updateNews end!");
	}

	@Override
	public List<NewsDTO> selectNews() throws Exception {
		// TODO Auto-generated method stub
		return soccerMapper.selectNews();
	}

	@Override
	public NewsDTO selectNewsDetail(NewsDTO pDTO) throws Exception {
		// TODO Auto-generated method stub
		return soccerMapper.selectNewsDetail(pDTO);
	}

	
}
