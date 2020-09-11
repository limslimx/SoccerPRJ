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

import poly.dto.PlayerDTO;
import poly.dto.TeamNewsDTO;
import poly.dto.TeamRankDTO;
import poly.dto.TeamScheduleDTO;
import poly.persistance.mapper.IMyInfoMapper;
import poly.service.IMyInfoService;
import poly.util.CmmUtil;
import poly.util.DateUtil;
import poly.util.HtmlUtil;

@Service("MyInfoService")
public class MyInfoService implements IMyInfoService{

	private Logger log=Logger.getLogger(this.getClass());
	
	@Resource(name="MyInfoMapper")
	private IMyInfoMapper myInfoMapper;
	
	@Override
	public void updateLiverpoolNews(TeamNewsDTO pDTO) throws Exception {
		log.info(this.getClass().getName()+".updateLiverpoolNews start!");
		
		String url="https://www.goal.com/kr/%ED%8C%80/%EB%A6%AC%EB%B2%84%ED%92%80/c8h9bw1l82s06h77xxrelzhur";
		
		Document doc=null;
		
		doc=Jsoup.connect(url).get();
		
		Elements element=doc.select("section.widget-latest-news");
		
		Elements element2=doc.select("section.widget-latest-news article.card-type-article a.type-article");
		
		List<String> tList=new ArrayList<String>();
		
		int i=0, j=0;
		
		log.info("######################## 기사 상세 링크 저장");
		
		for(Element e2 : element2) {
			tList.add(i, e2.getElementsByAttribute("href").attr("href"));
			i++;
		}
		
		Iterator<Element> title=element.select("article.card-type-article a.type-article div.title h3").iterator();
		Iterator<Element> date=element.select("article.card-type-article footer time").iterator();
		
		while(title.hasNext()) {
			
			pDTO=new TeamNewsDTO();
			log.info("#######################DTO에 값 넣기");
			pDTO.setCollectTime(DateUtil.getDateTime("yyyyMMdd24hmmss"));
			pDTO.setTeam(CmmUtil.nvl("리버풀"));
			pDTO.setTitle(CmmUtil.nvl(title.next().text()).trim());
			pDTO.setDate(CmmUtil.nvl(date.next().text()).trim());
			pDTO.setLink(CmmUtil.nvl("https://www.goal.com"+tList.get(j)));
			
			log.info("################################################## 팀: "+pDTO.getTeam());
			log.info("################################################## 제목: "+pDTO.getTitle());
			log.info("################################################## 날짜: "+pDTO.getDate());
			log.info("################################################## 기사 상세 링크: "+pDTO.getLink());
	
			String url2=pDTO.getLink();
			
			Document doc2=null;
			
			doc2=Jsoup.connect(url2).get();
			
			Elements content=doc2.select("div.article-container div.body");
			
			pDTO.setContent(HtmlUtil.removeTag(CmmUtil.nvl(content.text()).trim()));
			
			log.info("################################################## 내용: "+pDTO.getContent());
			
			myInfoMapper.updateTeamNews(pDTO);
			
			j++;
		}
		
		log.info(this.getClass().getName()+".updateLiverpoolNews end!");
	}

	@Override
	public void updateMancityNews(TeamNewsDTO pDTO) throws Exception {
		log.info(this.getClass().getName()+".updateMancityNews start!");
		
		String url="https://www.goal.com/kr/%ED%8C%80/%EB%A7%A8%EC%B2%B4%EC%8A%A4%ED%84%B0-%EC%8B%9C%ED%8B%B0/a3nyxabgsqlnqfkeg41m6tnpp";
		
		Document doc=null;
		
		doc=Jsoup.connect(url).get();
		
		Elements element=doc.select("section.widget-latest-news");
		
		Elements element2=doc.select("section.widget-latest-news article.card-type-article a.type-article");
		
		
		List<String> tList=new ArrayList<String>();
		
		int i=0, j=0;
		
		log.info("######################## 기사 상세 링크 저장");
		
		for(Element e2 : element2) {
			tList.add(i, e2.getElementsByAttribute("href").attr("href"));
			log.info(tList.get(i));
			log.info(i);
			i++;
		}
		
		
		
		Iterator<Element> title=element.select("article.card-type-article a.type-article div.title h3").iterator();
		Iterator<Element> date=element.select("article.card-type-article footer time").iterator();
		
		while(title.hasNext()) {
			
			pDTO=new TeamNewsDTO();
			log.info("#######################DTO에 값 넣기");
			pDTO.setCollectTime(DateUtil.getDateTime("yyyyMMdd24hmmss"));
			pDTO.setTeam(CmmUtil.nvl("맨시티"));
			pDTO.setTitle(CmmUtil.nvl(title.next().text()).trim());
			pDTO.setDate(CmmUtil.nvl(date.next().text()).trim());
			pDTO.setLink(CmmUtil.nvl("https://www.goal.com"+tList.get(j)));
			
			log.info("################################################## 팀: "+pDTO.getTeam());
			log.info("################################################## 제목: "+pDTO.getTitle());
			log.info("################################################## 날짜: "+pDTO.getDate());
			log.info("################################################## 기사 상세 링크: "+pDTO.getLink());
	
			String url2=pDTO.getLink();
			
			Document doc2=null;
			
			doc2=Jsoup.connect(url2).get();
			
			Elements content=doc2.select("div.article-container div.body");
			
			pDTO.setContent(HtmlUtil.removeTag(CmmUtil.nvl(content.text()).trim()));
			
			log.info("################################################## 내용: "+pDTO.getContent());

			myInfoMapper.updateTeamNews(pDTO);
			
			j++;
		}
		
		log.info(this.getClass().getName()+".updateMancityNews end!");
	}

	@Override
	public void updateTottenhamNews(TeamNewsDTO pDTO) throws Exception {
		log.info(this.getClass().getName()+".updateTottenhamNews start!");
		
		String url="https://www.goal.com/kr/%ED%8C%80/%ED%86%A0%ED%8A%B8%EB%84%98-%ED%99%8B%EC%8A%A4%ED%8D%BC/22doj4sgsocqpxw45h607udje";
		
		Document doc=null;
		
		doc=Jsoup.connect(url).get();
		
		Elements element=doc.select("section.widget-latest-news");
		
		Elements element2=doc.select("section.widget-latest-news article.card-type-article a.type-article");
		
		
		List<String> tList=new ArrayList<String>();
		
		int i=0, j=0;
		
		log.info("######################## 기사 상세 링크 저장");
		
		for(Element e2 : element2) {
			tList.add(i, e2.getElementsByAttribute("href").attr("href"));
			log.info(tList.get(i));
			log.info(i);
			i++;
		}
		
		
		
		Iterator<Element> title=element.select("article.card-type-article a.type-article div.title h3").iterator();
		Iterator<Element> date=element.select("article.card-type-article footer time").iterator();
		
		while(title.hasNext()) {
			
			pDTO=new TeamNewsDTO();
			log.info("#######################DTO에 값 넣기");
			pDTO.setCollectTime(DateUtil.getDateTime("yyyyMMdd24hmmss"));
			pDTO.setTeam(CmmUtil.nvl("토트넘"));
			pDTO.setTitle(CmmUtil.nvl(title.next().text()).trim());
			pDTO.setDate(CmmUtil.nvl(date.next().text()).trim());
			pDTO.setLink(CmmUtil.nvl("https://www.goal.com"+tList.get(j)));
			
			log.info("################################################## 팀: "+pDTO.getTeam());
			log.info("################################################## 제목: "+pDTO.getTitle());
			log.info("################################################## 날짜: "+pDTO.getDate());
			log.info("################################################## 기사 상세 링크: "+pDTO.getLink());
	
			String url2=pDTO.getLink();
			
			Document doc2=null;
			
			doc2=Jsoup.connect(url2).get();
			
			Elements content=doc2.select("div.article-container div.body");
			
			pDTO.setContent(HtmlUtil.removeTag(CmmUtil.nvl(content.text()).trim()));
			
			log.info("################################################## 내용: "+pDTO.getContent());

			myInfoMapper.updateTeamNews(pDTO);
			
			j++;
		}
		
		log.info(this.getClass().getName()+".updateTottenhamNews end!");
	}

	@Override
	public void updateChelseaNews(TeamNewsDTO pDTO) throws Exception {
		log.info(this.getClass().getName()+".updateChelseaNews start!");
		
		String url="https://www.goal.com/kr/%ED%8C%80/%EC%B2%BC%EC%8B%9C/9q0arba2kbnywth8bkxlhgmdr";
		
		Document doc=null;
		
		doc=Jsoup.connect(url).get();
		
		Elements element=doc.select("section.widget-latest-news");
		
		Elements element2=doc.select("section.widget-latest-news article.card-type-article a.type-article");
		
		
		List<String> tList=new ArrayList<String>();
		
		int i=0, j=0;
		
		log.info("######################## 기사 상세 링크 저장");
		
		for(Element e2 : element2) {
			tList.add(i, e2.getElementsByAttribute("href").attr("href"));
			log.info(tList.get(i));
			log.info(i);
			i++;
		}
		
		
		
		Iterator<Element> title=element.select("article.card-type-article a.type-article div.title h3").iterator();
		Iterator<Element> date=element.select("article.card-type-article footer time").iterator();
		
		while(title.hasNext()) {
			
			pDTO=new TeamNewsDTO();
			log.info("#######################DTO에 값 넣기");
			pDTO.setCollectTime(DateUtil.getDateTime("yyyyMMdd24hmmss"));
			pDTO.setTeam(CmmUtil.nvl("첼시"));
			pDTO.setTitle(CmmUtil.nvl(title.next().text()).trim());
			pDTO.setDate(CmmUtil.nvl(date.next().text()).trim());
			pDTO.setLink(CmmUtil.nvl("https://www.goal.com"+tList.get(j)));
			
			log.info("################################################## 팀: "+pDTO.getTeam());
			log.info("################################################## 제목: "+pDTO.getTitle());
			log.info("################################################## 날짜: "+pDTO.getDate());
			log.info("################################################## 기사 상세 링크: "+pDTO.getLink());
	
			String url2=pDTO.getLink();
			
			Document doc2=null;
			
			doc2=Jsoup.connect(url2).get();
			
			Elements content=doc2.select("div.article-container div.body");
			
			pDTO.setContent(HtmlUtil.removeTag(CmmUtil.nvl(content.text()).trim()));
			
			log.info("################################################## 내용: "+pDTO.getContent());

			myInfoMapper.updateTeamNews(pDTO);
			
			j++;
		}
		
		log.info(this.getClass().getName()+".updateChelseaNews end!");
	}

	@Override
	public void updateManuNews(TeamNewsDTO pDTO) throws Exception {
		log.info(this.getClass().getName()+".updateManuNews start!");
		
		String url="https://www.goal.com/kr/%ED%8C%80/%EB%A7%A8%EC%B2%B4%EC%8A%A4%ED%84%B0-%EC%9C%A0%EB%82%98%EC%9D%B4%ED%8B%B0%EB%93%9C/6eqit8ye8aomdsrrq0hk3v7gh";
		
		Document doc=null;
		
		doc=Jsoup.connect(url).get();
		
		Elements element=doc.select("section.widget-latest-news");
		
		Elements element2=doc.select("section.widget-latest-news article.card-type-article a.type-article");
		
		
		List<String> tList=new ArrayList<String>();
		
		int i=0, j=0;
		
		log.info("######################## 기사 상세 링크 저장");
		
		for(Element e2 : element2) {
			tList.add(i, e2.getElementsByAttribute("href").attr("href"));
			log.info(tList.get(i));
			log.info(i);
			i++;
		}
		
		
		
		Iterator<Element> title=element.select("article.card-type-article a.type-article div.title h3").iterator();
		Iterator<Element> date=element.select("article.card-type-article footer time").iterator();
		
		while(title.hasNext()) {
			
			pDTO=new TeamNewsDTO();
			log.info("#######################DTO에 값 넣기");
			pDTO.setCollectTime(DateUtil.getDateTime("yyyyMMdd24hmmss"));
			pDTO.setTeam(CmmUtil.nvl("맨유"));
			pDTO.setTitle(CmmUtil.nvl(title.next().text()).trim());
			pDTO.setDate(CmmUtil.nvl(date.next().text()).trim());
			pDTO.setLink(CmmUtil.nvl("https://www.goal.com"+tList.get(j)));
			
			log.info("################################################## 팀: "+pDTO.getTeam());
			log.info("################################################## 제목: "+pDTO.getTitle());
			log.info("################################################## 날짜: "+pDTO.getDate());
			log.info("################################################## 기사 상세 링크: "+pDTO.getLink());
	
			String url2=pDTO.getLink();
			
			Document doc2=null;
			
			doc2=Jsoup.connect(url2).get();
			
			Elements content=doc2.select("div.article-container div.body");
			
			pDTO.setContent(HtmlUtil.removeTag(CmmUtil.nvl(content.text()).trim()));
			
			log.info("################################################## 내용: "+pDTO.getContent());

			myInfoMapper.updateTeamNews(pDTO);
			
			j++;
		}
		
		log.info(this.getClass().getName()+".updateManuNews end!");
	}

	@Override
	public void updateArsenalNews(TeamNewsDTO pDTO) throws Exception {
		log.info(this.getClass().getName()+".updateArsenalNews start!");
		
		String url="https://www.goal.com/kr/%ED%8C%80/%EC%95%84%EC%8A%A4%EB%84%90/4dsgumo7d4zupm2ugsvm4zm4d";
		
		Document doc=null;
		
		doc=Jsoup.connect(url).get();
		
		Elements element=doc.select("section.widget-latest-news");
		
		Elements element2=doc.select("section.widget-latest-news article.card-type-article a.type-article");
		
		
		List<String> tList=new ArrayList<String>();
		
		int i=0, j=0;
		
		log.info("######################## 기사 상세 링크 저장");
		
		for(Element e2 : element2) {
			tList.add(i, e2.getElementsByAttribute("href").attr("href"));
			log.info(tList.get(i));
			log.info(i);
			i++;
		}
		
		
		
		Iterator<Element> title=element.select("article.card-type-article a.type-article div.title h3").iterator();
		Iterator<Element> date=element.select("article.card-type-article footer time").iterator();
		
		while(title.hasNext()) {
			
			pDTO=new TeamNewsDTO();
			log.info("#######################DTO에 값 넣기");
			pDTO.setCollectTime(DateUtil.getDateTime("yyyyMMdd24hmmss"));
			pDTO.setTeam(CmmUtil.nvl("아스널"));
			pDTO.setTitle(CmmUtil.nvl(title.next().text()).trim());
			pDTO.setDate(CmmUtil.nvl(date.next().text()).trim());
			pDTO.setLink(CmmUtil.nvl("https://www.goal.com"+tList.get(j)));
			
			log.info("################################################## 팀: "+pDTO.getTeam());
			log.info("################################################## 제목: "+pDTO.getTitle());
			log.info("################################################## 날짜: "+pDTO.getDate());
			log.info("################################################## 기사 상세 링크: "+pDTO.getLink());
	
			String url2=pDTO.getLink();
			
			Document doc2=null;
			
			doc2=Jsoup.connect(url2).get();
			
			Elements content=doc2.select("div.article-container div.body");
			
			pDTO.setContent(HtmlUtil.removeTag(CmmUtil.nvl(content.text()).trim()));
			
			log.info("################################################## 내용: "+pDTO.getContent());

			myInfoMapper.updateTeamNews(pDTO);
			
			j++;
		}
		
		log.info(this.getClass().getName()+".updateArsenalNews end!");
	}

	@Override
	public void updateBarcelonaNews(TeamNewsDTO pDTO) throws Exception {
		log.info(this.getClass().getName()+".updateBarcelonaNews start!");
		
		String url="https://www.goal.com/kr/%ED%8C%80/%EB%B0%94%EB%A5%B4%EC%85%80%EB%A1%9C%EB%82%98/agh9ifb2mw3ivjusgedj7c3fe";
		
		Document doc=null;
		
		doc=Jsoup.connect(url).get();
		
		Elements element=doc.select("section.widget-latest-news");
		
		Elements element2=doc.select("section.widget-latest-news article.card-type-article a.type-article");
		
		
		List<String> tList=new ArrayList<String>();
		
		int i=0, j=0;
		
		log.info("######################## 기사 상세 링크 저장");
		
		for(Element e2 : element2) {
			tList.add(i, e2.getElementsByAttribute("href").attr("href"));
			log.info(tList.get(i));
			log.info(i);
			i++;
		}
		
		
		
		Iterator<Element> title=element.select("article.card-type-article a.type-article div.title h3").iterator();
		Iterator<Element> date=element.select("article.card-type-article footer time").iterator();
		
		while(title.hasNext()) {
			
			pDTO=new TeamNewsDTO();
			log.info("#######################DTO에 값 넣기");
			pDTO.setCollectTime(DateUtil.getDateTime("yyyyMMdd24hmmss"));
			pDTO.setTeam(CmmUtil.nvl("바르셀로나"));
			pDTO.setTitle(CmmUtil.nvl(title.next().text()).trim());
			pDTO.setDate(CmmUtil.nvl(date.next().text()).trim());
			pDTO.setLink(CmmUtil.nvl("https://www.goal.com"+tList.get(j)));
			
			log.info("################################################## 팀: "+pDTO.getTeam());
			log.info("################################################## 제목: "+pDTO.getTitle());
			log.info("################################################## 날짜: "+pDTO.getDate());
			log.info("################################################## 기사 상세 링크: "+pDTO.getLink());
	
			String url2=pDTO.getLink();
			
			Document doc2=null;
			
			doc2=Jsoup.connect(url2).get();
			
			Elements content=doc2.select("div.article-container div.body");
			
			pDTO.setContent(HtmlUtil.removeTag(CmmUtil.nvl(content.text()).trim()));
			
			log.info("################################################## 내용: "+pDTO.getContent());

			myInfoMapper.updateTeamNews(pDTO);
			
			j++;
		}
		
		log.info(this.getClass().getName()+".updateBarcelonaNews end!");
	}

	@Override
	public void updateRealmadridNews(TeamNewsDTO pDTO) throws Exception {
		log.info(this.getClass().getName()+".updateRealmadridNews start!");
		
		String url="https://www.goal.com/kr/%ED%8C%80/%EB%A0%88%EC%95%8C-%EB%A7%88%EB%93%9C%EB%A6%AC%EB%93%9C/3kq9cckrnlogidldtdie2fkbl";
		
		Document doc=null;
		
		doc=Jsoup.connect(url).get();
		
		Elements element=doc.select("section.widget-latest-news");
		
		Elements element2=doc.select("section.widget-latest-news article.card-type-article a.type-article");
		
		
		List<String> tList=new ArrayList<String>();
		
		int i=0, j=0;
		
		log.info("######################## 기사 상세 링크 저장");
		
		for(Element e2 : element2) {
			tList.add(i, e2.getElementsByAttribute("href").attr("href"));
			log.info(tList.get(i));
			log.info(i);
			i++;
		}
		
		
		
		Iterator<Element> title=element.select("article.card-type-article a.type-article div.title h3").iterator();
		Iterator<Element> date=element.select("article.card-type-article footer time").iterator();
		
		while(title.hasNext()) {
			
			pDTO=new TeamNewsDTO();
			log.info("#######################DTO에 값 넣기");
			pDTO.setCollectTime(DateUtil.getDateTime("yyyyMMdd24hmmss"));
			pDTO.setTeam(CmmUtil.nvl("레알마드리드"));
			pDTO.setTitle(CmmUtil.nvl(title.next().text()).trim());
			pDTO.setDate(CmmUtil.nvl(date.next().text()).trim());
			pDTO.setLink(CmmUtil.nvl("https://www.goal.com"+tList.get(j)));
			
			log.info("################################################## 팀: "+pDTO.getTeam());
			log.info("################################################## 제목: "+pDTO.getTitle());
			log.info("################################################## 날짜: "+pDTO.getDate());
			log.info("################################################## 기사 상세 링크: "+pDTO.getLink());
	
			String url2=pDTO.getLink();
			
			Document doc2=null;
			
			doc2=Jsoup.connect(url2).get();
			
			Elements content=doc2.select("div.article-container div.body");
			
			pDTO.setContent(HtmlUtil.removeTag(CmmUtil.nvl(content.text()).trim()));
			
			log.info("################################################## 내용: "+pDTO.getContent());

			myInfoMapper.updateTeamNews(pDTO);
			
			j++;
		}
		
		log.info(this.getClass().getName()+".updateRealmadridNews end!");
	}

	@Override
	public void updateBayernmunichNews(TeamNewsDTO pDTO) throws Exception {
		log.info(this.getClass().getName()+".updateBayernmunichNews start!");
		
		String url="https://www.goal.com/kr/%ED%8C%80/%EB%B0%94%EC%9D%B4%EC%97%90%EB%A5%B8-%EB%AE%8C%ED%97%A8/apoawtpvac4zqlancmvw4nk4o";
		
		Document doc=null;
		
		doc=Jsoup.connect(url).get();
		
		Elements element=doc.select("section.widget-latest-news");
		
		Elements element2=doc.select("section.widget-latest-news article.card-type-article a.type-article");
		
		
		List<String> tList=new ArrayList<String>();
		
		int i=0, j=0;
		
		log.info("######################## 기사 상세 링크 저장");
		
		for(Element e2 : element2) {
			tList.add(i, e2.getElementsByAttribute("href").attr("href"));
			log.info(tList.get(i));
			log.info(i);
			i++;
		}
		
		
		
		Iterator<Element> title=element.select("article.card-type-article a.type-article div.title h3").iterator();
		Iterator<Element> date=element.select("article.card-type-article footer time").iterator();
		
		while(title.hasNext()) {
			
			pDTO=new TeamNewsDTO();
			log.info("#######################DTO에 값 넣기");
			pDTO.setCollectTime(DateUtil.getDateTime("yyyyMMdd24hmmss"));
			pDTO.setTeam(CmmUtil.nvl("바이에른뮌헨"));
			pDTO.setTitle(CmmUtil.nvl(title.next().text()).trim());
			pDTO.setDate(CmmUtil.nvl(date.next().text()).trim());
			pDTO.setLink(CmmUtil.nvl("https://www.goal.com"+tList.get(j)));
			
			log.info("################################################## 팀: "+pDTO.getTeam());
			log.info("################################################## 제목: "+pDTO.getTitle());
			log.info("################################################## 날짜: "+pDTO.getDate());
			log.info("################################################## 기사 상세 링크: "+pDTO.getLink());
	
			String url2=pDTO.getLink();
			
			Document doc2=null;
			
			doc2=Jsoup.connect(url2).get();
			
			Elements content=doc2.select("div.article-container div.body");
			
			pDTO.setContent(HtmlUtil.removeTag(CmmUtil.nvl(content.text()).trim()));
			
			log.info("################################################## 내용: "+pDTO.getContent());

			myInfoMapper.updateTeamNews(pDTO);
			
			j++;
		}
		
		log.info(this.getClass().getName()+".updateBayernmunichNews end!");
	}

	@Override
	public List<TeamNewsDTO> selectTeamNews(TeamNewsDTO pDTO) throws Exception {

		return myInfoMapper.selectTeamNews(pDTO);
	}

	@Override
	public TeamNewsDTO selectTeamNewsDetail(TeamNewsDTO pDTO) throws Exception {

		return myInfoMapper.selectTeamNewsDetail(pDTO);
	}

	@Override
	public void updatePlayer(PlayerDTO pDTO) throws Exception {
		log.info(this.getClass().getName()+".updatePlayer start!");
		
		int i1=0, i2=0, i3=0, i4=0, j1=0, j2=0, j3=0, j4=0;
		
		String url="";
		
		List<String> rList1=new ArrayList<String>();
		List<String> rList2=new ArrayList<String>();
		List<String> rList3=new ArrayList<String>();
		List<String> rList4=new ArrayList<String>();
		
		String team=pDTO.getTeam();
		
		if(pDTO.getTeam().equals("리버풀")) {
			url="https://www.goal.com/kr/%ED%8C%80/%EB%A6%AC%EB%B2%84%ED%92%80/c8h9bw1l82s06h77xxrelzhur";
		}else if(pDTO.getTeam().equals("맨시티")) {
			url="https://www.goal.com/kr/%ED%8C%80/%EB%A7%A8%EC%B2%B4%EC%8A%A4%ED%84%B0-%EC%8B%9C%ED%8B%B0/a3nyxabgsqlnqfkeg41m6tnpp";
		}else if(pDTO.getTeam().equals("토트넘")) {
			url="https://www.goal.com/kr/%ED%8C%80/%ED%86%A0%ED%8A%B8%EB%84%98-%ED%99%8B%EC%8A%A4%ED%8D%BC/22doj4sgsocqpxw45h607udje";
		}else if(pDTO.getTeam().equals("첼시")) {
			url="https://www.goal.com/kr/%ED%8C%80/%EC%B2%BC%EC%8B%9C/9q0arba2kbnywth8bkxlhgmdr";
		}else if(pDTO.getTeam().equals("맨유")) {
			url="https://www.goal.com/kr/%ED%8C%80/%EB%A7%A8%EC%B2%B4%EC%8A%A4%ED%84%B0-%EC%9C%A0%EB%82%98%EC%9D%B4%ED%8B%B0%EB%93%9C/6eqit8ye8aomdsrrq0hk3v7gh";
		}else if(pDTO.getTeam().equals("아스널")) {
			url="https://www.goal.com/kr/%ED%8C%80/%EC%95%84%EC%8A%A4%EB%84%90/4dsgumo7d4zupm2ugsvm4zm4d";
		}else if(pDTO.getTeam().equals("바르셀로나")) {
			url="https://www.goal.com/kr/%ED%8C%80/%EB%B0%94%EB%A5%B4%EC%85%80%EB%A1%9C%EB%82%98/agh9ifb2mw3ivjusgedj7c3fe";
		}else if(pDTO.getTeam().equals("레알마드리드")) {
			url="https://www.goal.com/kr/%ED%8C%80/%EB%A0%88%EC%95%8C-%EB%A7%88%EB%93%9C%EB%A6%AC%EB%93%9C/3kq9cckrnlogidldtdie2fkbl";
		}else if(pDTO.getTeam().equals("바이에른뮌헨")) {
			url="https://www.goal.com/kr/%ED%8C%80/%EB%B0%94%EC%9D%B4%EC%97%90%EB%A5%B8-%EB%AE%8C%ED%97%A8/apoawtpvac4zqlancmvw4nk4o";
		}
		
		Document doc=null;
		
		doc=Jsoup.connect(url).get();
		
		Elements element1=doc.select("div.p0c-team-squad__body ul.p0c-team-squad__list:nth-child(2)");
		Elements element2=doc.select("div.p0c-team-squad__body ul.p0c-team-squad__list:nth-child(4)");
		Elements element3=doc.select("div.p0c-team-squad__body ul.p0c-team-squad__list:nth-child(6)");
		Elements element4=doc.select("div.p0c-team-squad__body ul.p0c-team-squad__list:nth-child(8)");
		
		Elements image1=element1.select("li.p0c-team-squad__member span.p0c-team-squad__member-photo");
		Elements image2=element2.select("li.p0c-team-squad__member span.p0c-team-squad__member-photo");
		Elements image3=element3.select("li.p0c-team-squad__member span.p0c-team-squad__member-photo");
		Elements image4=element4.select("li.p0c-team-squad__member span.p0c-team-squad__member-photo");
		
		for(Element e : image1) {
			rList1.add(i1, e.getElementsByAttribute("src").attr("src"));
			i1++;
		}
		for(Element e : image2) {
			rList2.add(i2, e.getElementsByAttribute("src").attr("src"));
			i2++;
		}
		for(Element e : image3) {
			rList3.add(i3, e.getElementsByAttribute("src").attr("src"));
			i3++;
		}
		for(Element e : image4) {
			rList4.add(i4, e.getElementsByAttribute("src").attr("src"));
			i4++;
		}
		
		Iterator<Element> gkName=element1.select("li.p0c-team-squad__member span.p0c-team-squad__member-name").iterator();
		Iterator<Element> gkAge=element1.select("li.p0c-team-squad__member span.p0c-team-squad__member-age").iterator();
		
		while(gkName.hasNext()) {
			
			pDTO=new PlayerDTO();

			pDTO.setCollectTime(DateUtil.getDateTime("yyyyMMdd24hmmss"));
			pDTO.setTeam(team);
			pDTO.setPosition(CmmUtil.nvl("골키퍼"));
			pDTO.setImage(CmmUtil.nvl(rList1.get(j1)));
			pDTO.setName(CmmUtil.nvl(gkName.next().text()).trim());
			pDTO.setAge(CmmUtil.nvl(gkAge.next().text()).trim());
			
			log.info("골키퍼이름: "+pDTO.getName());
			log.info("팀명: "+team);
			log.info("이미지 경로: "+pDTO.getImage());
			
			myInfoMapper.updatePlayer(pDTO);
			j1++;
		}
		
		Iterator<Element> dfName=element2.select("li.p0c-team-squad__member span.p0c-team-squad__member-name").iterator();
		Iterator<Element> dfAge=element2.select("li.p0c-team-squad__member span.p0c-team-squad__member-age").iterator();
		
		while(dfName.hasNext()) {

			pDTO=new PlayerDTO();

			pDTO.setCollectTime(DateUtil.getDateTime("yyyyMMdd24hmmss"));
			pDTO.setTeam(team);
			pDTO.setPosition(CmmUtil.nvl("수비수"));
			pDTO.setImage(CmmUtil.nvl(rList2.get(j2)));
			pDTO.setName(CmmUtil.nvl(dfName.next().text()).trim());
			pDTO.setAge(CmmUtil.nvl(dfAge.next().text()).trim());
			
			log.info("수비수이름: "+pDTO.getName());
			log.info("팀명: "+team);
			log.info("이미지 경로: "+pDTO.getImage());
			
			myInfoMapper.updatePlayer(pDTO);
			j2++;
		}
		
		Iterator<Element> mdName=element3.select("li.p0c-team-squad__member span.p0c-team-squad__member-name").iterator();
		Iterator<Element> mdAge=element3.select("li.p0c-team-squad__member span.p0c-team-squad__member-age").iterator();
		
		while(mdName.hasNext()) {
		
			pDTO=new PlayerDTO();

			pDTO.setCollectTime(DateUtil.getDateTime("yyyyMMdd24hmmss"));
			pDTO.setTeam(team);
			pDTO.setPosition(CmmUtil.nvl("미드필더"));
			pDTO.setImage(CmmUtil.nvl(rList3.get(j3)));
			pDTO.setName(CmmUtil.nvl(mdName.next().text()).trim());
			pDTO.setAge(CmmUtil.nvl(mdAge.next().text()).trim());
			
			log.info("미드필더이름: "+pDTO.getName());
			log.info("팀명: "+team);
			log.info("이미지 경로: "+pDTO.getImage());
			
			myInfoMapper.updatePlayer(pDTO);
			j3++;
		}
		
		Iterator<Element> fwName=element4.select("li.p0c-team-squad__member span.p0c-team-squad__member-name").iterator();
		Iterator<Element> fwAge=element4.select("li.p0c-team-squad__member span.p0c-team-squad__member-age").iterator();
		
		while(fwName.hasNext()) {
			
			pDTO=new PlayerDTO();

			pDTO.setCollectTime(DateUtil.getDateTime("yyyyMMdd24hmmss"));
			pDTO.setTeam(team);
			pDTO.setPosition(CmmUtil.nvl("공격수"));
			pDTO.setImage(CmmUtil.nvl(rList4.get(j4)));
			pDTO.setName(CmmUtil.nvl(fwName.next().text()).trim());
			pDTO.setAge(CmmUtil.nvl(fwAge.next().text()).trim());
			
			log.info("공격수이름: "+pDTO.getName());
			log.info("팀이름: "+team);
			log.info("이미지 경로: "+pDTO.getImage());
			
			myInfoMapper.updatePlayer(pDTO);
			j4++;
		}
		
		log.info(this.getClass().getName()+".updatePlayer end!");	
	}

	@Override
	public List<PlayerDTO> selectPlayer(PlayerDTO pDTO) throws Exception {
		// TODO Auto-generated method stub
		return myInfoMapper.selectPlayer(pDTO);
	}

	@Override
	public void updateLiverpoolRank(TeamRankDTO pDTO) throws Exception {

		log.info(this.getClass().getName()+".updateLiverpoolRank start!");
		
		int i=1, j=6, k=0, t=0, p=0, l=0;
		
		List<String> tList=new ArrayList<>();
		List<String> rList=new ArrayList<>();
		
		String url="https://www.goal.com/kr/%ED%8C%80/%EB%A6%AC%EB%B2%84%ED%92%80/%EC%88%9C%EC%9C%84/c8h9bw1l82s06h77xxrelzhur";
		
		Document doc=null;
		
		doc=Jsoup.connect(url).get();
		
		Elements element1=doc.select("div.main-content div.p0c-competition-tables:nth-child(1)");
		Elements element2=doc.select("div.main-content div.p0c-competition-tables:nth-child(3)");
		Elements image=doc.select("div.main-content div.p0c-competition-tables:nth-child(1) table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(2) a");
		Elements image2=doc.select("div.main-content div.p0c-competition-tables:nth-child(3) table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(2) a");
		
		Iterator<Element> rank=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(1)").iterator();
		Iterator<Element> team=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row a.p0c-competition-tables__link abbr").iterator();
		Iterator<Element> totalMatch=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(4)").iterator();
		Iterator<Element> winMatch=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(5)").iterator();
		Iterator<Element> drawMatch=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(6)").iterator();
		Iterator<Element> lostMatch=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(7)").iterator();
		Iterator<Element> diff=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(8)").iterator();
		Iterator<Element> points=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(9)").iterator();
		
		Iterator<Element> rank2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(1)").iterator();
		Iterator<Element> team2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row a.p0c-competition-tables__link abbr").iterator();
		Iterator<Element> totalMatch2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(4)").iterator();
		Iterator<Element> winMatch2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(5)").iterator();
		Iterator<Element> drawMatch2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(6)").iterator();
		Iterator<Element> lostMatch2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(7)").iterator();
		Iterator<Element> diff2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(8)").iterator();
		Iterator<Element> points2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(9)").iterator();
		
		for(Element e : image) {
			tList.add(k, e.getElementsByAttribute("data-srcset").attr("data-srcset"));
			k++;
		}
		
		for(Element e2 : image2) {
			rList.add(p, e2.getElementsByAttribute("data-srcset").attr("data-srcset"));
			p++;
		}
			
		while(rank.hasNext()) {
			pDTO=new TeamRankDTO();
			log.info("########################자국 리그 크롤링");
			pDTO.setCollectTime(DateUtil.getDateTime("yyyyMMdd24hmmss"));
			pDTO.setLeague(CmmUtil.nvl("프리미어리그"));
			pDTO.setLink(CmmUtil.nvl(url));
			pDTO.setImage(CmmUtil.nvl(tList.get(t)));
			pDTO.setMyTeam("리버풀");
			pDTO.setTeamName(CmmUtil.nvl("리버풀"+i++));
			pDTO.setRank(CmmUtil.nvl(rank.next().text()).trim());
			pDTO.setTeam(CmmUtil.nvl(team.next().text()).trim());
			pDTO.setTotalMatch(CmmUtil.nvl(totalMatch.next().text()).trim());
			pDTO.setWonMatch(CmmUtil.nvl(winMatch.next().text()).trim());
			pDTO.setDrawMatch(CmmUtil.nvl(drawMatch.next().text()).trim());
			pDTO.setLostMatch(CmmUtil.nvl(lostMatch.next().text()).trim());
			pDTO.setDiff(CmmUtil.nvl(diff.next().text()).trim());
			pDTO.setPoints(CmmUtil.nvl(points.next().text()).trim());
			
			log.info("##################################################"+pDTO.getLeague());
			log.info("##################################################"+pDTO.getRank());
			log.info("##################################################"+pDTO.getImage());
			log.info("##################################################"+pDTO.getTeam());
			log.info("##################################################"+pDTO.getTotalMatch());
			log.info("##################################################"+pDTO.getWonMatch());
			log.info("##################################################"+pDTO.getDrawMatch());
			log.info("##################################################"+pDTO.getLostMatch());
			log.info("##################################################"+pDTO.getDiff());
			log.info("##################################################"+pDTO.getPoints());
			
			myInfoMapper.updateTeamRank(pDTO);
			t++;
		}
		
		while(rank2.hasNext()) {

			pDTO=new TeamRankDTO();
			log.info("########################챔피언스 리그 크롤링");
			pDTO.setCollectTime(DateUtil.getDateTime("yyyyMMdd24hmmss"));
			pDTO.setLeague(CmmUtil.nvl("챔피언스리그"));
			pDTO.setLink(CmmUtil.nvl(url));
			pDTO.setImage(CmmUtil.nvl(rList.get(l)));
			pDTO.setMyTeam("리버풀");
			pDTO.setTeamName(CmmUtil.nvl("리버풀"+j++));
			pDTO.setRank(CmmUtil.nvl(rank2.next().text()).trim());
			pDTO.setTeam(CmmUtil.nvl(team2.next().text()).trim());
			pDTO.setTotalMatch(CmmUtil.nvl(totalMatch2.next().text()).trim());
			pDTO.setWonMatch(CmmUtil.nvl(winMatch2.next().text()).trim());
			pDTO.setDrawMatch(CmmUtil.nvl(drawMatch2.next().text()).trim());
			pDTO.setLostMatch(CmmUtil.nvl(lostMatch2.next().text()).trim());
			pDTO.setDiff(CmmUtil.nvl(diff2.next().text()).trim());
			pDTO.setPoints(CmmUtil.nvl(points2.next().text()).trim());
			
			log.info("##################################################"+pDTO.getLeague());
			log.info("##################################################"+pDTO.getRank());
			log.info("##################################################"+pDTO.getImage());
			log.info("##################################################"+pDTO.getTeam());
			log.info("##################################################"+pDTO.getTotalMatch());
			log.info("##################################################"+pDTO.getWonMatch());
			log.info("##################################################"+pDTO.getDrawMatch());
			log.info("##################################################"+pDTO.getLostMatch());
			log.info("##################################################"+pDTO.getDiff());
			log.info("##################################################"+pDTO.getPoints());

			myInfoMapper.updateTeamRank(pDTO);
			l++;
		}
		
		log.info(this.getClass().getName()+".updateLiverpoolRank end!");
	}

	@Override
	public void updateMancityRank(TeamRankDTO pDTO) throws Exception {

		log.info(this.getClass().getName()+".updateMancityRank start!");
		
		int i=1, j=6, k=0, t=0, p=0, l=0;
		
		List<String> tList=new ArrayList<>();
		List<String> rList=new ArrayList<>();
		
		String url="https://www.goal.com/kr/%ED%8C%80/%EB%A7%A8%EC%B2%B4%EC%8A%A4%ED%84%B0-%EC%8B%9C%ED%8B%B0/%EC%88%9C%EC%9C%84/a3nyxabgsqlnqfkeg41m6tnpp";
		
		Document doc=null;
		
		doc=Jsoup.connect(url).get();
		
		Elements element1=doc.select("div.main-content div.p0c-competition-tables:nth-child(1)");
		Elements element2=doc.select("div.main-content div.p0c-competition-tables:nth-child(3)");
		Elements image=doc.select("div.main-content div.p0c-competition-tables:nth-child(1) table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(2) a");
		Elements image2=doc.select("div.main-content div.p0c-competition-tables:nth-child(3) table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(2) a");
		
		Iterator<Element> rank=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(1)").iterator();
		Iterator<Element> team=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row a.p0c-competition-tables__link abbr").iterator();
		Iterator<Element> totalMatch=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(4)").iterator();
		Iterator<Element> winMatch=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(5)").iterator();
		Iterator<Element> drawMatch=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(6)").iterator();
		Iterator<Element> lostMatch=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(7)").iterator();
		Iterator<Element> diff=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(8)").iterator();
		Iterator<Element> points=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(9)").iterator();
		
		Iterator<Element> rank2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(1)").iterator();
		Iterator<Element> team2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row a.p0c-competition-tables__link abbr").iterator();
		Iterator<Element> totalMatch2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(4)").iterator();
		Iterator<Element> winMatch2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(5)").iterator();
		Iterator<Element> drawMatch2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(6)").iterator();
		Iterator<Element> lostMatch2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(7)").iterator();
		Iterator<Element> diff2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(8)").iterator();
		Iterator<Element> points2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(9)").iterator();
		
		for(Element e : image) {
			tList.add(k, e.getElementsByAttribute("data-srcset").attr("data-srcset"));
			k++;
		}
		
		for(Element e2 : image2) {
			rList.add(p, e2.getElementsByAttribute("data-srcset").attr("data-srcset"));
			p++;
		}
		
		while(rank.hasNext()) {
			
			pDTO=new TeamRankDTO();
			log.info("########################자국 리그 크롤링");
			pDTO.setCollectTime(DateUtil.getDateTime("yyyyMMdd24hmmss"));
			pDTO.setLeague(CmmUtil.nvl("프리미어리그"));
			pDTO.setLink(CmmUtil.nvl(url));
			pDTO.setImage(CmmUtil.nvl(tList.get(t)));
			pDTO.setMyTeam("맨시티");
			pDTO.setTeamName(CmmUtil.nvl("맨시티"+i++));
			pDTO.setRank(CmmUtil.nvl(rank.next().text()).trim());
			pDTO.setTeam(CmmUtil.nvl(team.next().text()).trim());
			pDTO.setTotalMatch(CmmUtil.nvl(totalMatch.next().text()).trim());
			pDTO.setWonMatch(CmmUtil.nvl(winMatch.next().text()).trim());
			pDTO.setDrawMatch(CmmUtil.nvl(drawMatch.next().text()).trim());
			pDTO.setLostMatch(CmmUtil.nvl(lostMatch.next().text()).trim());
			pDTO.setDiff(CmmUtil.nvl(diff.next().text()).trim());
			pDTO.setPoints(CmmUtil.nvl(points.next().text()).trim());
			
			log.info("##################################################"+pDTO.getLeague());
			log.info("##################################################"+pDTO.getRank());
			log.info("##################################################"+pDTO.getImage());
			log.info("##################################################"+pDTO.getTeam());
			log.info("##################################################"+pDTO.getTotalMatch());
			log.info("##################################################"+pDTO.getWonMatch());
			log.info("##################################################"+pDTO.getDrawMatch());
			log.info("##################################################"+pDTO.getLostMatch());
			log.info("##################################################"+pDTO.getDiff());
			log.info("##################################################"+pDTO.getPoints());

			myInfoMapper.updateTeamRank(pDTO);
			t++;
		}
		
		while(rank2.hasNext()) {
			
			pDTO=new TeamRankDTO();
			log.info("########################챔피언스 리그 크롤링");
			pDTO.setCollectTime(DateUtil.getDateTime("yyyyMMdd24hmmss"));
			pDTO.setLeague(CmmUtil.nvl("챔피언스리그"));
			pDTO.setLink(CmmUtil.nvl(url));
			pDTO.setImage(CmmUtil.nvl(rList.get(l)));
			pDTO.setMyTeam("맨시티");
			pDTO.setTeamName(CmmUtil.nvl("맨시티"+j++));
			pDTO.setRank(CmmUtil.nvl(rank2.next().text()).trim());
			pDTO.setTeam(CmmUtil.nvl(team2.next().text()).trim());
			pDTO.setTotalMatch(CmmUtil.nvl(totalMatch2.next().text()).trim());
			pDTO.setWonMatch(CmmUtil.nvl(winMatch2.next().text()).trim());
			pDTO.setDrawMatch(CmmUtil.nvl(drawMatch2.next().text()).trim());
			pDTO.setLostMatch(CmmUtil.nvl(lostMatch2.next().text()).trim());
			pDTO.setDiff(CmmUtil.nvl(diff2.next().text()).trim());
			pDTO.setPoints(CmmUtil.nvl(points2.next().text()).trim());
			
			log.info("##################################################"+pDTO.getLeague());
			log.info("##################################################"+pDTO.getRank());
			log.info("##################################################"+pDTO.getImage());
			log.info("##################################################"+pDTO.getTeam());
			log.info("##################################################"+pDTO.getTotalMatch());
			log.info("##################################################"+pDTO.getWonMatch());
			log.info("##################################################"+pDTO.getDrawMatch());
			log.info("##################################################"+pDTO.getLostMatch());
			log.info("##################################################"+pDTO.getDiff());
			log.info("##################################################"+pDTO.getPoints());

			myInfoMapper.updateTeamRank(pDTO);
			l++;
		}
		
		log.info(this.getClass().getName()+".updateMancityRank end!");
	}

	@Override
	public void updateTottenhamRank(TeamRankDTO pDTO) throws Exception {
		
		log.info(this.getClass().getName()+".updateTottenhamRank start!");
		
		int i=1, j=6, k=0, t=0, p=0, l=0;
		
		List<String> tList=new ArrayList<>();
		List<String> rList=new ArrayList<>();
		
		String url="https://www.goal.com/kr/%ED%8C%80/%ED%86%A0%ED%8A%B8%EB%84%98-%ED%99%8B%EC%8A%A4%ED%8D%BC/%EC%88%9C%EC%9C%84/22doj4sgsocqpxw45h607udje";
		
		Document doc=null;
		
		doc=Jsoup.connect(url).get();
		
		Elements element1=doc.select("div.main-content div.p0c-competition-tables:nth-child(1)");
		Elements element2=doc.select("div.main-content div.p0c-competition-tables:nth-child(3)");
		Elements image=doc.select("div.main-content div.p0c-competition-tables:nth-child(1) table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(2) a");
		Elements image2=doc.select("div.main-content div.p0c-competition-tables:nth-child(3) table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(2) a");
		
		Iterator<Element> rank=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(1)").iterator();
		Iterator<Element> team=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row a.p0c-competition-tables__link abbr").iterator();
		Iterator<Element> totalMatch=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(4)").iterator();
		Iterator<Element> winMatch=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(5)").iterator();
		Iterator<Element> drawMatch=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(6)").iterator();
		Iterator<Element> lostMatch=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(7)").iterator();
		Iterator<Element> diff=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(8)").iterator();
		Iterator<Element> points=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(9)").iterator();
		
		Iterator<Element> rank2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(1)").iterator();
		Iterator<Element> team2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row a.p0c-competition-tables__link abbr").iterator();
		Iterator<Element> totalMatch2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(4)").iterator();
		Iterator<Element> winMatch2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(5)").iterator();
		Iterator<Element> drawMatch2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(6)").iterator();
		Iterator<Element> lostMatch2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(7)").iterator();
		Iterator<Element> diff2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(8)").iterator();
		Iterator<Element> points2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(9)").iterator();
		
		for(Element e : image) {
			tList.add(k, e.getElementsByAttribute("data-srcset").attr("data-srcset"));
			k++;
		}
		
		for(Element e2 : image2) {
			rList.add(p, e2.getElementsByAttribute("data-srcset").attr("data-srcset"));
			p++;
		}
		
		while(rank.hasNext()) {
			
			pDTO=new TeamRankDTO();
			log.info("########################자국 리그 크롤링");
			pDTO.setCollectTime(DateUtil.getDateTime("yyyyMMdd24hmmss"));
			pDTO.setLeague(CmmUtil.nvl("프리미어리그"));
			pDTO.setLink(CmmUtil.nvl(url));
			pDTO.setImage(CmmUtil.nvl(tList.get(t)));
			pDTO.setMyTeam("토트넘");
			pDTO.setTeamName(CmmUtil.nvl("토트넘"+i++));
			pDTO.setRank(CmmUtil.nvl(rank.next().text()).trim());
			pDTO.setTeam(CmmUtil.nvl(team.next().text()).trim());
			pDTO.setTotalMatch(CmmUtil.nvl(totalMatch.next().text()).trim());
			pDTO.setWonMatch(CmmUtil.nvl(winMatch.next().text()).trim());
			pDTO.setDrawMatch(CmmUtil.nvl(drawMatch.next().text()).trim());
			pDTO.setLostMatch(CmmUtil.nvl(lostMatch.next().text()).trim());
			pDTO.setDiff(CmmUtil.nvl(diff.next().text()).trim());
			pDTO.setPoints(CmmUtil.nvl(points.next().text()).trim());
			
			log.info("##################################################"+pDTO.getLeague());
			log.info("##################################################"+pDTO.getRank());
			log.info("##################################################"+pDTO.getImage());
			log.info("##################################################"+pDTO.getTeam());
			log.info("##################################################"+pDTO.getTotalMatch());
			log.info("##################################################"+pDTO.getWonMatch());
			log.info("##################################################"+pDTO.getDrawMatch());
			log.info("##################################################"+pDTO.getLostMatch());
			log.info("##################################################"+pDTO.getDiff());
			log.info("##################################################"+pDTO.getPoints());

			myInfoMapper.updateTeamRank(pDTO);
			t++;
		}
		
		while(rank2.hasNext()) {
			
			pDTO=new TeamRankDTO();
			log.info("########################챔피언스 리그 크롤링");
			pDTO.setCollectTime(DateUtil.getDateTime("yyyyMMdd24hmmss"));
			pDTO.setLeague(CmmUtil.nvl("챔피언스리그"));
			pDTO.setLink(CmmUtil.nvl(url));
			pDTO.setImage(CmmUtil.nvl(rList.get(l)));
			pDTO.setMyTeam("토트넘");
			pDTO.setTeamName(CmmUtil.nvl("토트넘"+j++));
			pDTO.setRank(CmmUtil.nvl(rank2.next().text()).trim());
			pDTO.setTeam(CmmUtil.nvl(team2.next().text()).trim());
			pDTO.setTotalMatch(CmmUtil.nvl(totalMatch2.next().text()).trim());
			pDTO.setWonMatch(CmmUtil.nvl(winMatch2.next().text()).trim());
			pDTO.setDrawMatch(CmmUtil.nvl(drawMatch2.next().text()).trim());
			pDTO.setLostMatch(CmmUtil.nvl(lostMatch2.next().text()).trim());
			pDTO.setDiff(CmmUtil.nvl(diff2.next().text()).trim());
			pDTO.setPoints(CmmUtil.nvl(points2.next().text()).trim());
			
			log.info("##################################################"+pDTO.getLeague());
			log.info("##################################################"+pDTO.getRank());
			log.info("##################################################"+pDTO.getImage());
			log.info("##################################################"+pDTO.getTeam());
			log.info("##################################################"+pDTO.getTotalMatch());
			log.info("##################################################"+pDTO.getWonMatch());
			log.info("##################################################"+pDTO.getDrawMatch());
			log.info("##################################################"+pDTO.getLostMatch());
			log.info("##################################################"+pDTO.getDiff());
			log.info("##################################################"+pDTO.getPoints());

			myInfoMapper.updateTeamRank(pDTO);
			l++;
		}
		
		log.info(this.getClass().getName()+".updateTottenhamRank end!");
	}

	@Override
	public void updateChelseaRank(TeamRankDTO pDTO) throws Exception {
		
		log.info(this.getClass().getName()+".updateChelseaRank start!");
		
		int i=1, j=6, k=0, t=0, p=0, l=0;
		
		List<String> tList=new ArrayList<>();
		List<String> rList=new ArrayList<>();
		
		String url="https://www.goal.com/kr/%ED%8C%80/%EC%B2%BC%EC%8B%9C/%EC%88%9C%EC%9C%84/9q0arba2kbnywth8bkxlhgmdr";
		
		Document doc=null;
		
		doc=Jsoup.connect(url).get();
		
		Elements element1=doc.select("div.main-content div.p0c-competition-tables:nth-child(1)");
		Elements element2=doc.select("div.main-content div.p0c-competition-tables:nth-child(3)");
		Elements image=doc.select("div.main-content div.p0c-competition-tables:nth-child(1) table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(2) a");
		Elements image2=doc.select("div.main-content div.p0c-competition-tables:nth-child(3) table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(2) a");
		
		Iterator<Element> rank=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(1)").iterator();
		Iterator<Element> team=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row a.p0c-competition-tables__link abbr").iterator();
		Iterator<Element> totalMatch=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(4)").iterator();
		Iterator<Element> winMatch=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(5)").iterator();
		Iterator<Element> drawMatch=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(6)").iterator();
		Iterator<Element> lostMatch=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(7)").iterator();
		Iterator<Element> diff=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(8)").iterator();
		Iterator<Element> points=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(9)").iterator();
		
		Iterator<Element> rank2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(1)").iterator();
		Iterator<Element> team2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row a.p0c-competition-tables__link abbr").iterator();
		Iterator<Element> totalMatch2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(4)").iterator();
		Iterator<Element> winMatch2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(5)").iterator();
		Iterator<Element> drawMatch2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(6)").iterator();
		Iterator<Element> lostMatch2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(7)").iterator();
		Iterator<Element> diff2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(8)").iterator();
		Iterator<Element> points2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(9)").iterator();
		
		for(Element e : image) {
			tList.add(k, e.getElementsByAttribute("data-srcset").attr("data-srcset"));
			k++;
		}
		
		for(Element e2 : image2) {
			rList.add(p, e2.getElementsByAttribute("data-srcset").attr("data-srcset"));
			p++;
		}
		
		while(rank.hasNext()) {
			
			pDTO=new TeamRankDTO();
			log.info("########################자국 리그 크롤링");
			pDTO.setCollectTime(DateUtil.getDateTime("yyyyMMdd24hmmss"));
			pDTO.setLeague(CmmUtil.nvl("프리미어리그"));
			pDTO.setLink(CmmUtil.nvl(url));
			pDTO.setImage(CmmUtil.nvl(tList.get(t)));
			pDTO.setMyTeam("첼시");
			pDTO.setTeamName(CmmUtil.nvl("첼시"+i++));
			pDTO.setRank(CmmUtil.nvl(rank.next().text()).trim());
			pDTO.setTeam(CmmUtil.nvl(team.next().text()).trim());
			pDTO.setTotalMatch(CmmUtil.nvl(totalMatch.next().text()).trim());
			pDTO.setWonMatch(CmmUtil.nvl(winMatch.next().text()).trim());
			pDTO.setDrawMatch(CmmUtil.nvl(drawMatch.next().text()).trim());
			pDTO.setLostMatch(CmmUtil.nvl(lostMatch.next().text()).trim());
			pDTO.setDiff(CmmUtil.nvl(diff.next().text()).trim());
			pDTO.setPoints(CmmUtil.nvl(points.next().text()).trim());
			
			log.info("##################################################"+pDTO.getLeague());
			log.info("##################################################"+pDTO.getRank());
			log.info("##################################################"+pDTO.getImage());
			log.info("##################################################"+pDTO.getTeam());
			log.info("##################################################"+pDTO.getTotalMatch());
			log.info("##################################################"+pDTO.getWonMatch());
			log.info("##################################################"+pDTO.getDrawMatch());
			log.info("##################################################"+pDTO.getLostMatch());
			log.info("##################################################"+pDTO.getDiff());
			log.info("##################################################"+pDTO.getPoints());

			myInfoMapper.updateTeamRank(pDTO);
			t++;
		}
		
		while(rank2.hasNext()) {
			
			pDTO=new TeamRankDTO();
			log.info("########################챔피언스 리그 크롤링");
			pDTO.setCollectTime(DateUtil.getDateTime("yyyyMMdd24hmmss"));
			pDTO.setLeague(CmmUtil.nvl("챔피언스리그"));
			pDTO.setLink(CmmUtil.nvl(url));
			pDTO.setImage(CmmUtil.nvl(rList.get(l)));
			pDTO.setMyTeam("첼시");
			pDTO.setTeamName(CmmUtil.nvl("첼시"+j++));
			pDTO.setRank(CmmUtil.nvl(rank2.next().text()).trim());
			pDTO.setTeam(CmmUtil.nvl(team2.next().text()).trim());
			pDTO.setTotalMatch(CmmUtil.nvl(totalMatch2.next().text()).trim());
			pDTO.setWonMatch(CmmUtil.nvl(winMatch2.next().text()).trim());
			pDTO.setDrawMatch(CmmUtil.nvl(drawMatch2.next().text()).trim());
			pDTO.setLostMatch(CmmUtil.nvl(lostMatch2.next().text()).trim());
			pDTO.setDiff(CmmUtil.nvl(diff2.next().text()).trim());
			pDTO.setPoints(CmmUtil.nvl(points2.next().text()).trim());
			
			log.info("##################################################"+pDTO.getLeague());
			log.info("##################################################"+pDTO.getRank());
			log.info("##################################################"+pDTO.getImage());
			log.info("##################################################"+pDTO.getTeam());
			log.info("##################################################"+pDTO.getTotalMatch());
			log.info("##################################################"+pDTO.getWonMatch());
			log.info("##################################################"+pDTO.getDrawMatch());
			log.info("##################################################"+pDTO.getLostMatch());
			log.info("##################################################"+pDTO.getDiff());
			log.info("##################################################"+pDTO.getPoints());

			myInfoMapper.updateTeamRank(pDTO);
			l++;
		}
		
		log.info(this.getClass().getName()+".updateChelseaRank end!");
	}

	@Override
	public void updateManuRank(TeamRankDTO pDTO) throws Exception {
		
		log.info(this.getClass().getName()+".updateManuRank start!");
		
		int i=1, j=6, k=0, t=0, p=0, l=0;
		
		List<String> tList=new ArrayList<>();
		List<String> rList=new ArrayList<>();
		
		String url="https://www.goal.com/kr/%ED%8C%80/%EB%A7%A8%EC%B2%B4%EC%8A%A4%ED%84%B0-%EC%9C%A0%EB%82%98%EC%9D%B4%ED%8B%B0%EB%93%9C/%EC%88%9C%EC%9C%84/6eqit8ye8aomdsrrq0hk3v7gh";
		
		Document doc=null;
		
		doc=Jsoup.connect(url).get();
		
		Elements element1=doc.select("div.main-content div.p0c-competition-tables:nth-child(1)");
		Elements element2=doc.select("div.main-content div.p0c-competition-tables:nth-child(3)");
		Elements image=doc.select("div.main-content div.p0c-competition-tables:nth-child(1) table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(2) a");
		Elements image2=doc.select("div.main-content div.p0c-competition-tables:nth-child(3) table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(2) a");
		
		Iterator<Element> rank=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(1)").iterator();
		Iterator<Element> team=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row a.p0c-competition-tables__link abbr").iterator();
		Iterator<Element> totalMatch=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(4)").iterator();
		Iterator<Element> winMatch=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(5)").iterator();
		Iterator<Element> drawMatch=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(6)").iterator();
		Iterator<Element> lostMatch=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(7)").iterator();
		Iterator<Element> diff=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(8)").iterator();
		Iterator<Element> points=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(9)").iterator();
		
		Iterator<Element> rank2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(1)").iterator();
		Iterator<Element> team2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row a.p0c-competition-tables__link abbr").iterator();
		Iterator<Element> totalMatch2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(4)").iterator();
		Iterator<Element> winMatch2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(5)").iterator();
		Iterator<Element> drawMatch2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(6)").iterator();
		Iterator<Element> lostMatch2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(7)").iterator();
		Iterator<Element> diff2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(8)").iterator();
		Iterator<Element> points2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(9)").iterator();
		
		for(Element e : image) {
			tList.add(k, e.getElementsByAttribute("data-srcset").attr("data-srcset"));
			k++;
		}
		
		for(Element e2 : image2) {
			rList.add(p, e2.getElementsByAttribute("data-srcset").attr("data-srcset"));
			p++;
		}
		
		while(rank.hasNext()) {
			
			pDTO=new TeamRankDTO();
			log.info("########################자국 리그 크롤링");
			pDTO.setCollectTime(DateUtil.getDateTime("yyyyMMdd24hmmss"));
			pDTO.setLeague(CmmUtil.nvl("프리미어리그"));
			pDTO.setLink(CmmUtil.nvl(url));
			pDTO.setImage(CmmUtil.nvl(tList.get(t)));
			pDTO.setMyTeam("맨유");
			pDTO.setTeamName(CmmUtil.nvl("맨유"+i++));
			pDTO.setRank(CmmUtil.nvl(rank.next().text()).trim());
			pDTO.setTeam(CmmUtil.nvl(team.next().text()).trim());
			pDTO.setTotalMatch(CmmUtil.nvl(totalMatch.next().text()).trim());
			pDTO.setWonMatch(CmmUtil.nvl(winMatch.next().text()).trim());
			pDTO.setDrawMatch(CmmUtil.nvl(drawMatch.next().text()).trim());
			pDTO.setLostMatch(CmmUtil.nvl(lostMatch.next().text()).trim());
			pDTO.setDiff(CmmUtil.nvl(diff.next().text()).trim());
			pDTO.setPoints(CmmUtil.nvl(points.next().text()).trim());
			
			log.info("##################################################"+pDTO.getLeague());
			log.info("##################################################"+pDTO.getRank());
			log.info("##################################################"+pDTO.getImage());
			log.info("##################################################"+pDTO.getTeam());
			log.info("##################################################"+pDTO.getTotalMatch());
			log.info("##################################################"+pDTO.getWonMatch());
			log.info("##################################################"+pDTO.getDrawMatch());
			log.info("##################################################"+pDTO.getLostMatch());
			log.info("##################################################"+pDTO.getDiff());
			log.info("##################################################"+pDTO.getPoints());

			myInfoMapper.updateTeamRank(pDTO);
			t++;
		}
		
		while(rank2.hasNext()) {
			
			pDTO=new TeamRankDTO();
			log.info("########################챔피언스 리그 크롤링");
			pDTO.setCollectTime(DateUtil.getDateTime("yyyyMMdd24hmmss"));
			pDTO.setLeague(CmmUtil.nvl("챔피언스리그"));
			pDTO.setLink(CmmUtil.nvl(url));
			pDTO.setImage(CmmUtil.nvl(rList.get(l)));
			pDTO.setMyTeam("맨유");
			pDTO.setTeamName(CmmUtil.nvl("맨유"+j++));
			pDTO.setRank(CmmUtil.nvl(rank2.next().text()).trim());
			pDTO.setTeam(CmmUtil.nvl(team2.next().text()).trim());
			pDTO.setTotalMatch(CmmUtil.nvl(totalMatch2.next().text()).trim());
			pDTO.setWonMatch(CmmUtil.nvl(winMatch2.next().text()).trim());
			pDTO.setDrawMatch(CmmUtil.nvl(drawMatch2.next().text()).trim());
			pDTO.setLostMatch(CmmUtil.nvl(lostMatch2.next().text()).trim());
			pDTO.setDiff(CmmUtil.nvl(diff2.next().text()).trim());
			pDTO.setPoints(CmmUtil.nvl(points2.next().text()).trim());
			
			log.info("##################################################"+pDTO.getLeague());
			log.info("##################################################"+pDTO.getRank());
			log.info("##################################################"+pDTO.getImage());
			log.info("##################################################"+pDTO.getTeam());
			log.info("##################################################"+pDTO.getTotalMatch());
			log.info("##################################################"+pDTO.getWonMatch());
			log.info("##################################################"+pDTO.getDrawMatch());
			log.info("##################################################"+pDTO.getLostMatch());
			log.info("##################################################"+pDTO.getDiff());
			log.info("##################################################"+pDTO.getPoints());

			myInfoMapper.updateTeamRank(pDTO);
			l++;
		}
		
		log.info(this.getClass().getName()+".updateManuRank end!");
	}

	@Override
	public void updateArsenalRank(TeamRankDTO pDTO) throws Exception {
		
		log.info(this.getClass().getName()+".updateArsenalRank start!");
		
		int i=1, j=6, k=0, t=0, p=0, l=0;
		
		List<String> tList=new ArrayList<>();
		List<String> rList=new ArrayList<>();
		
		String url="https://www.goal.com/kr/%ED%8C%80/%EC%95%84%EC%8A%A4%EB%84%90/%EC%88%9C%EC%9C%84/4dsgumo7d4zupm2ugsvm4zm4d";
		
		Document doc=null;
		
		doc=Jsoup.connect(url).get();
		
		Elements element1=doc.select("div.main-content div.p0c-competition-tables:nth-child(1)");
		Elements element2=doc.select("div.main-content div.p0c-competition-tables:nth-child(3)");
		Elements image=doc.select("div.main-content div.p0c-competition-tables:nth-child(1) table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(2) a");
		Elements image2=doc.select("div.main-content div.p0c-competition-tables:nth-child(3) table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(2) a");
		
		Iterator<Element> rank=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(1)").iterator();
		Iterator<Element> team=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row a.p0c-competition-tables__link abbr").iterator();
		Iterator<Element> totalMatch=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(4)").iterator();
		Iterator<Element> winMatch=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(5)").iterator();
		Iterator<Element> drawMatch=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(6)").iterator();
		Iterator<Element> lostMatch=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(7)").iterator();
		Iterator<Element> diff=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(8)").iterator();
		Iterator<Element> points=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(9)").iterator();
		
		Iterator<Element> rank2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(1)").iterator();
		Iterator<Element> team2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row a.p0c-competition-tables__link abbr").iterator();
		Iterator<Element> totalMatch2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(4)").iterator();
		Iterator<Element> winMatch2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(5)").iterator();
		Iterator<Element> drawMatch2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(6)").iterator();
		Iterator<Element> lostMatch2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(7)").iterator();
		Iterator<Element> diff2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(8)").iterator();
		Iterator<Element> points2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(9)").iterator();
		
		for(Element e : image) {
			tList.add(k, e.getElementsByAttribute("data-srcset").attr("data-srcset"));
			k++;
		}
		
		for(Element e2 : image2) {
			rList.add(p, e2.getElementsByAttribute("data-srcset").attr("data-srcset"));
			p++;
		}
		
		while(rank.hasNext()) {
			
			pDTO=new TeamRankDTO();
			log.info("########################자국 리그 크롤링");
			pDTO.setCollectTime(DateUtil.getDateTime("yyyyMMdd24hmmss"));
			pDTO.setLeague(CmmUtil.nvl("프리미어리그"));
			pDTO.setLink(CmmUtil.nvl(url));
			pDTO.setImage(CmmUtil.nvl(tList.get(t)));
			pDTO.setMyTeam("아스널");
			pDTO.setTeamName(CmmUtil.nvl("아스널"+i++));
			pDTO.setRank(CmmUtil.nvl(rank.next().text()).trim());
			pDTO.setTeam(CmmUtil.nvl(team.next().text()).trim());
			pDTO.setTotalMatch(CmmUtil.nvl(totalMatch.next().text()).trim());
			pDTO.setWonMatch(CmmUtil.nvl(winMatch.next().text()).trim());
			pDTO.setDrawMatch(CmmUtil.nvl(drawMatch.next().text()).trim());
			pDTO.setLostMatch(CmmUtil.nvl(lostMatch.next().text()).trim());
			pDTO.setDiff(CmmUtil.nvl(diff.next().text()).trim());
			pDTO.setPoints(CmmUtil.nvl(points.next().text()).trim());
			
			log.info("##################################################"+pDTO.getLeague());
			log.info("##################################################"+pDTO.getRank());
			log.info("##################################################"+pDTO.getImage());
			log.info("##################################################"+pDTO.getTeam());
			log.info("##################################################"+pDTO.getTotalMatch());
			log.info("##################################################"+pDTO.getWonMatch());
			log.info("##################################################"+pDTO.getDrawMatch());
			log.info("##################################################"+pDTO.getLostMatch());
			log.info("##################################################"+pDTO.getDiff());
			log.info("##################################################"+pDTO.getPoints());

			myInfoMapper.updateTeamRank(pDTO);
			t++;
		}
		
		while(rank2.hasNext()) {
			
			pDTO=new TeamRankDTO();
			log.info("########################챔피언스 리그 크롤링");
			pDTO.setCollectTime(DateUtil.getDateTime("yyyyMMdd24hmmss"));
			pDTO.setLeague(CmmUtil.nvl("챔피언스리그"));
			pDTO.setLink(CmmUtil.nvl(url));
			pDTO.setImage(CmmUtil.nvl(rList.get(l)));
			pDTO.setMyTeam("아스널");
			pDTO.setTeamName(CmmUtil.nvl("아스널"+j++));
			pDTO.setRank(CmmUtil.nvl(rank2.next().text()).trim());
			pDTO.setTeam(CmmUtil.nvl(team2.next().text()).trim());
			pDTO.setTotalMatch(CmmUtil.nvl(totalMatch2.next().text()).trim());
			pDTO.setWonMatch(CmmUtil.nvl(winMatch2.next().text()).trim());
			pDTO.setDrawMatch(CmmUtil.nvl(drawMatch2.next().text()).trim());
			pDTO.setLostMatch(CmmUtil.nvl(lostMatch2.next().text()).trim());
			pDTO.setDiff(CmmUtil.nvl(diff2.next().text()).trim());
			pDTO.setPoints(CmmUtil.nvl(points2.next().text()).trim());
			
			log.info("##################################################"+pDTO.getLeague());
			log.info("##################################################"+pDTO.getRank());
			log.info("##################################################"+pDTO.getImage());
			log.info("##################################################"+pDTO.getTeam());
			log.info("##################################################"+pDTO.getTotalMatch());
			log.info("##################################################"+pDTO.getWonMatch());
			log.info("##################################################"+pDTO.getDrawMatch());
			log.info("##################################################"+pDTO.getLostMatch());
			log.info("##################################################"+pDTO.getDiff());
			log.info("##################################################"+pDTO.getPoints());

			myInfoMapper.updateTeamRank(pDTO);
			l++;
		}
		
		log.info(this.getClass().getName()+".updateArsenalRank end!");
	}

	@Override
	public void updateBarcelonaRank(TeamRankDTO pDTO) throws Exception {
		
		log.info(this.getClass().getName()+".updateBarcelonaRank start!");
		
		int i=1, j=6, k=0, t=0, p=0, l=0;
		
		List<String> tList=new ArrayList<>();
		List<String> rList=new ArrayList<>();
		
		String url="https://www.goal.com/kr/%ED%8C%80/%EB%B0%94%EB%A5%B4%EC%85%80%EB%A1%9C%EB%82%98/%EC%88%9C%EC%9C%84/agh9ifb2mw3ivjusgedj7c3fe";
		
		Document doc=null;
		
		doc=Jsoup.connect(url).get();
		
		Elements element1=doc.select("div.main-content div.p0c-competition-tables:nth-child(1)");
		Elements element2=doc.select("div.main-content div.p0c-competition-tables:nth-child(3)");
		Elements image=doc.select("div.main-content div.p0c-competition-tables:nth-child(1) table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(2) a");
		Elements image2=doc.select("div.main-content div.p0c-competition-tables:nth-child(3) table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(2) a");
		
		Iterator<Element> rank=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(1)").iterator();
		Iterator<Element> team=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row a.p0c-competition-tables__link abbr").iterator();
		Iterator<Element> totalMatch=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(4)").iterator();
		Iterator<Element> winMatch=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(5)").iterator();
		Iterator<Element> drawMatch=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(6)").iterator();
		Iterator<Element> lostMatch=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(7)").iterator();
		Iterator<Element> diff=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(8)").iterator();
		Iterator<Element> points=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(9)").iterator();
		
		Iterator<Element> rank2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(1)").iterator();
		Iterator<Element> team2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row a.p0c-competition-tables__link abbr").iterator();
		Iterator<Element> totalMatch2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(4)").iterator();
		Iterator<Element> winMatch2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(5)").iterator();
		Iterator<Element> drawMatch2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(6)").iterator();
		Iterator<Element> lostMatch2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(7)").iterator();
		Iterator<Element> diff2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(8)").iterator();
		Iterator<Element> points2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(9)").iterator();
		
		for(Element e : image) {
			tList.add(k, e.getElementsByAttribute("data-srcset").attr("data-srcset"));
			k++;
		}
		
		for(Element e2 : image2) {
			rList.add(p, e2.getElementsByAttribute("data-srcset").attr("data-srcset"));
			p++;
		}
		
		while(rank.hasNext()) {
			
			pDTO=new TeamRankDTO();
			log.info("########################자국 리그 크롤링");
			pDTO.setCollectTime(DateUtil.getDateTime("yyyyMMdd24hmmss"));
			pDTO.setLeague(CmmUtil.nvl("라리가"));
			pDTO.setLink(CmmUtil.nvl(url));
			pDTO.setImage(CmmUtil.nvl(tList.get(t)));
			pDTO.setMyTeam("바르셀로나");
			pDTO.setTeamName(CmmUtil.nvl("바르셀로나"+i++));
			pDTO.setRank(CmmUtil.nvl(rank.next().text()).trim());
			pDTO.setTeam(CmmUtil.nvl(team.next().text()).trim());
			pDTO.setTotalMatch(CmmUtil.nvl(totalMatch.next().text()).trim());
			pDTO.setWonMatch(CmmUtil.nvl(winMatch.next().text()).trim());
			pDTO.setDrawMatch(CmmUtil.nvl(drawMatch.next().text()).trim());
			pDTO.setLostMatch(CmmUtil.nvl(lostMatch.next().text()).trim());
			pDTO.setDiff(CmmUtil.nvl(diff.next().text()).trim());
			pDTO.setPoints(CmmUtil.nvl(points.next().text()).trim());
			
			log.info("##################################################"+pDTO.getLeague());
			log.info("##################################################"+pDTO.getRank());
			log.info("##################################################"+pDTO.getImage());
			log.info("##################################################"+pDTO.getTeam());
			log.info("##################################################"+pDTO.getTotalMatch());
			log.info("##################################################"+pDTO.getWonMatch());
			log.info("##################################################"+pDTO.getDrawMatch());
			log.info("##################################################"+pDTO.getLostMatch());
			log.info("##################################################"+pDTO.getDiff());
			log.info("##################################################"+pDTO.getPoints());

			myInfoMapper.updateTeamRank(pDTO);
			t++;
		}
		
		while(rank2.hasNext()) {
			
			pDTO=new TeamRankDTO();
			log.info("########################챔피언스 리그 크롤링");
			pDTO.setCollectTime(DateUtil.getDateTime("yyyyMMdd24hmmss"));
			pDTO.setLeague(CmmUtil.nvl("챔피언스리그"));
			pDTO.setLink(CmmUtil.nvl(url));
			pDTO.setImage(CmmUtil.nvl(rList.get(l)));
			pDTO.setMyTeam("바르셀로나");
			pDTO.setTeamName(CmmUtil.nvl("바르셀로나"+j++));
			pDTO.setRank(CmmUtil.nvl(rank2.next().text()).trim());
			pDTO.setTeam(CmmUtil.nvl(team2.next().text()).trim());
			pDTO.setTotalMatch(CmmUtil.nvl(totalMatch2.next().text()).trim());
			pDTO.setWonMatch(CmmUtil.nvl(winMatch2.next().text()).trim());
			pDTO.setDrawMatch(CmmUtil.nvl(drawMatch2.next().text()).trim());
			pDTO.setLostMatch(CmmUtil.nvl(lostMatch2.next().text()).trim());
			pDTO.setDiff(CmmUtil.nvl(diff2.next().text()).trim());
			pDTO.setPoints(CmmUtil.nvl(points2.next().text()).trim());
			
			log.info("##################################################"+pDTO.getLeague());
			log.info("##################################################"+pDTO.getRank());
			log.info("##################################################"+pDTO.getImage());
			log.info("##################################################"+pDTO.getTeam());
			log.info("##################################################"+pDTO.getTotalMatch());
			log.info("##################################################"+pDTO.getWonMatch());
			log.info("##################################################"+pDTO.getDrawMatch());
			log.info("##################################################"+pDTO.getLostMatch());
			log.info("##################################################"+pDTO.getDiff());
			log.info("##################################################"+pDTO.getPoints());

			myInfoMapper.updateTeamRank(pDTO);
			l++;
		}
		
		log.info(this.getClass().getName()+".updateBarcelonaRank end!");
	}

	@Override
	public void updateRealmadridRank(TeamRankDTO pDTO) throws Exception {
		
		log.info(this.getClass().getName()+".updateRealmadridRank start!");
		
		int i=1, j=6, k=0, t=0, p=0, l=0;
		
		List<String> tList=new ArrayList<>();
		List<String> rList=new ArrayList<>();
		
		String url="https://www.goal.com/kr/%ED%8C%80/%EB%A0%88%EC%95%8C-%EB%A7%88%EB%93%9C%EB%A6%AC%EB%93%9C/%EC%88%9C%EC%9C%84/3kq9cckrnlogidldtdie2fkbl";
		
		Document doc=null;
		
		doc=Jsoup.connect(url).get();
		
		Elements element1=doc.select("div.main-content div.p0c-competition-tables:nth-child(1)");
		Elements element2=doc.select("div.main-content div.p0c-competition-tables:nth-child(3)");
		Elements image=doc.select("div.main-content div.p0c-competition-tables:nth-child(1) table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(2) a");
		Elements image2=doc.select("div.main-content div.p0c-competition-tables:nth-child(3) table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(2) a");
		
		Iterator<Element> rank=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(1)").iterator();
		Iterator<Element> team=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row a.p0c-competition-tables__link abbr").iterator();
		Iterator<Element> totalMatch=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(4)").iterator();
		Iterator<Element> winMatch=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(5)").iterator();
		Iterator<Element> drawMatch=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(6)").iterator();
		Iterator<Element> lostMatch=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(7)").iterator();
		Iterator<Element> diff=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(8)").iterator();
		Iterator<Element> points=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(9)").iterator();
		
		Iterator<Element> rank2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(1)").iterator();
		Iterator<Element> team2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row a.p0c-competition-tables__link abbr").iterator();
		Iterator<Element> totalMatch2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(4)").iterator();
		Iterator<Element> winMatch2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(5)").iterator();
		Iterator<Element> drawMatch2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(6)").iterator();
		Iterator<Element> lostMatch2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(7)").iterator();
		Iterator<Element> diff2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(8)").iterator();
		Iterator<Element> points2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(9)").iterator();
		
		for(Element e : image) {
			tList.add(k, e.getElementsByAttribute("data-srcset").attr("data-srcset"));
			k++;
		}
		
		for(Element e2 : image2) {
			rList.add(p, e2.getElementsByAttribute("data-srcset").attr("data-srcset"));
			p++;
		}
		
		while(rank.hasNext()) {
			
			pDTO=new TeamRankDTO();
			log.info("########################자국 리그 크롤링");
			pDTO.setCollectTime(DateUtil.getDateTime("yyyyMMdd24hmmss"));
			pDTO.setLeague(CmmUtil.nvl("라리가"));
			pDTO.setLink(CmmUtil.nvl(url));
			pDTO.setImage(CmmUtil.nvl(tList.get(t)));
			pDTO.setMyTeam("레알마드리드");
			pDTO.setTeamName(CmmUtil.nvl("레알마드리드"+i++));
			pDTO.setRank(CmmUtil.nvl(rank.next().text()).trim());
			pDTO.setTeam(CmmUtil.nvl(team.next().text()).trim());
			pDTO.setTotalMatch(CmmUtil.nvl(totalMatch.next().text()).trim());
			pDTO.setWonMatch(CmmUtil.nvl(winMatch.next().text()).trim());
			pDTO.setDrawMatch(CmmUtil.nvl(drawMatch.next().text()).trim());
			pDTO.setLostMatch(CmmUtil.nvl(lostMatch.next().text()).trim());
			pDTO.setDiff(CmmUtil.nvl(diff.next().text()).trim());
			pDTO.setPoints(CmmUtil.nvl(points.next().text()).trim());
			
			log.info("##################################################"+pDTO.getLeague());
			log.info("##################################################"+pDTO.getRank());
			log.info("##################################################"+pDTO.getImage());
			log.info("##################################################"+pDTO.getTeam());
			log.info("##################################################"+pDTO.getTotalMatch());
			log.info("##################################################"+pDTO.getWonMatch());
			log.info("##################################################"+pDTO.getDrawMatch());
			log.info("##################################################"+pDTO.getLostMatch());
			log.info("##################################################"+pDTO.getDiff());
			log.info("##################################################"+pDTO.getPoints());

			myInfoMapper.updateTeamRank(pDTO);
			t++;
		}
		
		while(rank2.hasNext()) {
			
			pDTO=new TeamRankDTO();
			log.info("########################챔피언스 리그 크롤링");
			pDTO.setCollectTime(DateUtil.getDateTime("yyyyMMdd24hmmss"));
			pDTO.setLeague(CmmUtil.nvl("챔피언스리그"));
			pDTO.setLink(CmmUtil.nvl(url));
			pDTO.setImage(CmmUtil.nvl(rList.get(l)));
			pDTO.setMyTeam("레알마드리드");
			pDTO.setTeamName(CmmUtil.nvl("레알마드리드"+j++));
			pDTO.setRank(CmmUtil.nvl(rank2.next().text()).trim());
			pDTO.setTeam(CmmUtil.nvl(team2.next().text()).trim());
			pDTO.setTotalMatch(CmmUtil.nvl(totalMatch2.next().text()).trim());
			pDTO.setWonMatch(CmmUtil.nvl(winMatch2.next().text()).trim());
			pDTO.setDrawMatch(CmmUtil.nvl(drawMatch2.next().text()).trim());
			pDTO.setLostMatch(CmmUtil.nvl(lostMatch2.next().text()).trim());
			pDTO.setDiff(CmmUtil.nvl(diff2.next().text()).trim());
			pDTO.setPoints(CmmUtil.nvl(points2.next().text()).trim());
			
			log.info("##################################################"+pDTO.getLeague());
			log.info("##################################################"+pDTO.getRank());
			log.info("##################################################"+pDTO.getImage());
			log.info("##################################################"+pDTO.getTeam());
			log.info("##################################################"+pDTO.getTotalMatch());
			log.info("##################################################"+pDTO.getWonMatch());
			log.info("##################################################"+pDTO.getDrawMatch());
			log.info("##################################################"+pDTO.getLostMatch());
			log.info("##################################################"+pDTO.getDiff());
			log.info("##################################################"+pDTO.getPoints());

			myInfoMapper.updateTeamRank(pDTO);
			l++;
		}
		
		log.info(this.getClass().getName()+".updateRealmadridRank end!");	
	}

	@Override
	public void updateBayernmunichRank(TeamRankDTO pDTO) throws Exception {
		
		log.info(this.getClass().getName()+".updateBayernmunichRank start!");
		
		int i=1, j=6, k=0, t=0, p=0, l=0;
		
		List<String> tList=new ArrayList<>();
		List<String> rList=new ArrayList<>();
		
		String url="https://www.goal.com/kr/%ED%8C%80/%EB%B0%94%EC%9D%B4%EC%97%90%EB%A5%B8-%EB%AE%8C%ED%97%A8/%EC%88%9C%EC%9C%84/apoawtpvac4zqlancmvw4nk4o";
		
		Document doc=null;
		
		doc=Jsoup.connect(url).get();
		
		Elements element1=doc.select("div.main-content div.p0c-competition-tables:nth-child(1)");
		Elements element2=doc.select("div.main-content div.p0c-competition-tables:nth-child(3)");
		Elements image=doc.select("div.main-content div.p0c-competition-tables:nth-child(1) table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(2) a");
		Elements image2=doc.select("div.main-content div.p0c-competition-tables:nth-child(3) table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(2) a");
		
		Iterator<Element> rank=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(1)").iterator();
		Iterator<Element> team=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row a.p0c-competition-tables__link abbr").iterator();
		Iterator<Element> totalMatch=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(4)").iterator();
		Iterator<Element> winMatch=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(5)").iterator();
		Iterator<Element> drawMatch=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(6)").iterator();
		Iterator<Element> lostMatch=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(7)").iterator();
		Iterator<Element> diff=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(8)").iterator();
		Iterator<Element> points=element1.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(9)").iterator();
		
		Iterator<Element> rank2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(1)").iterator();
		Iterator<Element> team2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row a.p0c-competition-tables__link abbr").iterator();
		Iterator<Element> totalMatch2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(4)").iterator();
		Iterator<Element> winMatch2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(5)").iterator();
		Iterator<Element> drawMatch2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(6)").iterator();
		Iterator<Element> lostMatch2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(7)").iterator();
		Iterator<Element> diff2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(8)").iterator();
		Iterator<Element> points2=element2.select("table.p0c-competition-tables__table tbody tr.p0c-competition-tables__row td:nth-child(9)").iterator();
		
		for(Element e : image) {
			tList.add(k, e.getElementsByAttribute("data-srcset").attr("data-srcset"));
			k++;
		}
		
		for(Element e2 : image2) {
			rList.add(p, e2.getElementsByAttribute("data-srcset").attr("data-srcset"));
			p++;
		}
		
		while(rank.hasNext()) {
			
			pDTO=new TeamRankDTO();
			log.info("########################자국 리그 크롤링");
			pDTO.setCollectTime(DateUtil.getDateTime("yyyyMMdd24hmmss"));
			pDTO.setLeague(CmmUtil.nvl("분데스리그"));
			pDTO.setLink(CmmUtil.nvl(url));
			pDTO.setImage(CmmUtil.nvl(tList.get(t)));
			pDTO.setMyTeam("바이에른뮌헨");
			pDTO.setTeamName(CmmUtil.nvl("바이에른뮌헨"+i++));
			pDTO.setRank(CmmUtil.nvl(rank.next().text()).trim());
			pDTO.setTeam(CmmUtil.nvl(team.next().text()).trim());
			pDTO.setTotalMatch(CmmUtil.nvl(totalMatch.next().text()).trim());
			pDTO.setWonMatch(CmmUtil.nvl(winMatch.next().text()).trim());
			pDTO.setDrawMatch(CmmUtil.nvl(drawMatch.next().text()).trim());
			pDTO.setLostMatch(CmmUtil.nvl(lostMatch.next().text()).trim());
			pDTO.setDiff(CmmUtil.nvl(diff.next().text()).trim());
			pDTO.setPoints(CmmUtil.nvl(points.next().text()).trim());
			
			log.info("##################################################"+pDTO.getLeague());
			log.info("##################################################"+pDTO.getRank());
			log.info("##################################################"+pDTO.getImage());
			log.info("##################################################"+pDTO.getTeam());
			log.info("##################################################"+pDTO.getTotalMatch());
			log.info("##################################################"+pDTO.getWonMatch());
			log.info("##################################################"+pDTO.getDrawMatch());
			log.info("##################################################"+pDTO.getLostMatch());
			log.info("##################################################"+pDTO.getDiff());
			log.info("##################################################"+pDTO.getPoints());

			myInfoMapper.updateTeamRank(pDTO);
			t++;
		}
		
		while(rank2.hasNext()) {
			
			pDTO=new TeamRankDTO();
			log.info("########################챔피언스 리그 크롤링");
			pDTO.setCollectTime(DateUtil.getDateTime("yyyyMMdd24hmmss"));
			pDTO.setLeague(CmmUtil.nvl("챔피언스리그"));
			pDTO.setLink(CmmUtil.nvl(url));
			pDTO.setImage(CmmUtil.nvl(rList.get(l)));
			pDTO.setMyTeam("바이에른뮌헨");
			pDTO.setTeamName(CmmUtil.nvl("바이에른뮌헨"+j++));
			pDTO.setRank(CmmUtil.nvl(rank2.next().text()).trim());
			pDTO.setTeam(CmmUtil.nvl(team2.next().text()).trim());
			pDTO.setTotalMatch(CmmUtil.nvl(totalMatch2.next().text()).trim());
			pDTO.setWonMatch(CmmUtil.nvl(winMatch2.next().text()).trim());
			pDTO.setDrawMatch(CmmUtil.nvl(drawMatch2.next().text()).trim());
			pDTO.setLostMatch(CmmUtil.nvl(lostMatch2.next().text()).trim());
			pDTO.setDiff(CmmUtil.nvl(diff2.next().text()).trim());
			pDTO.setPoints(CmmUtil.nvl(points2.next().text()).trim());
			
			log.info("##################################################"+pDTO.getLeague());
			log.info("##################################################"+pDTO.getRank());
			log.info("##################################################"+pDTO.getImage());
			log.info("##################################################"+pDTO.getTeam());
			log.info("##################################################"+pDTO.getTotalMatch());
			log.info("##################################################"+pDTO.getWonMatch());
			log.info("##################################################"+pDTO.getDrawMatch());
			log.info("##################################################"+pDTO.getLostMatch());
			log.info("##################################################"+pDTO.getDiff());
			log.info("##################################################"+pDTO.getPoints());

			myInfoMapper.updateTeamRank(pDTO);
			l++;
		}
		
		log.info(this.getClass().getName()+".updateBayernmunichRank end!");
	}

	@Override
	public List<TeamRankDTO> selectTeamRank(TeamRankDTO pDTO) throws Exception {

		return myInfoMapper.selectTeamRank(pDTO);
	}

	@Override
	public void updateLiverpoolSchedule(TeamScheduleDTO pDTO) throws Exception {

		log.info(this.getClass().getName()+".updateLiverpoolSchedule start!");
		
		int i=1, j=6, k=0, t=0, p=0, l=0;
		
		List<String> tList=new ArrayList<>();
		List<String> rList=new ArrayList<>();
		
		String url="https://www.goal.com/kr/%ED%8C%80/%EB%A6%AC%EB%B2%84%ED%92%80/%EC%9D%BC%EC%A0%95-%EA%B2%B0%EA%B3%BC/c8h9bw1l82s06h77xxrelzhur";
		
		Document doc=null;
		
		doc=Jsoup.connect(url).get();
		
		Elements element=doc.select("div.main-content div.widget-entity-matches div.widget-entity-matches__list div.match-row");
		Elements imageHome=element.select("div.team-home div.crest");
		Elements imageAway=element.select("div.team-away div.crest");
		
		Iterator<Element> day=element.select("div.match-main-data div.match-status time").iterator();
		Iterator<Element> teamHome=element.select("div.match-main-data div.match-status time").iterator();
		Iterator<Element> scoreHome=element.select("div.match-main-data div.match-teams div.match-data div.team-home span.goals").iterator();
		Iterator<Element> teamAway=element.select("div.match-main-data div.match-teams div.match-data div.team-away span.team-name").iterator();
		Iterator<Element> scoreAway=element.select("div.match-main-data div.match-teams div.match-data div.team-away span.goals").iterator();
		Iterator<Element> league=element.select("div.match-additional-data span.match-additional-data__competition-name").iterator();
		
		for(Element e : imageHome) {
			tList.add(k, e.getElementsByAttribute("src").attr("src"));
			k++;
		}
		
		for(Element e2 : imageAway) {
			rList.add(p, e2.getElementsByAttribute("src").attr("src"));
			p++;
		}
			
		while(day.hasNext()) {
			
			pDTO=new TeamScheduleDTO();
			pDTO.setCollectTime(DateUtil.getDateTime("yyyyMMdd24hmmss"));
			pDTO.setTeamName("리버풀");
			pDTO.setDay(CmmUtil.nvl(day.next().text()).trim());
			pDTO.setTeamHome(CmmUtil.nvl(teamHome.next().text()).trim());
			pDTO.setTeamAway(CmmUtil.nvl(teamAway.next().text()).trim());
			pDTO.setScoreHome(CmmUtil.nvl(scoreHome.next().text()).trim());
			pDTO.setScoreAway(CmmUtil.nvl(scoreAway.next().text()).trim());
			pDTO.setImageHome(CmmUtil.nvl(tList.get(t)));
			pDTO.setImageAway(CmmUtil.nvl(rList.get(l)));
			pDTO.setLeague(CmmUtil.nvl(league.next().text()).trim());
			
			log.info("##################################################"+pDTO.getTeamName());
			log.info("##################################################"+pDTO.getDay());
			log.info("##################################################"+pDTO.getTeamHome());
			log.info("##################################################"+pDTO.getTeamAway());
			log.info("##################################################"+pDTO.getScoreHome());
			log.info("##################################################"+pDTO.getScoreAway());
			log.info("##################################################"+pDTO.getImageHome());
			log.info("##################################################"+pDTO.getImageAway());
			log.info("##################################################"+pDTO.getLeague());
			
			myInfoMapper.updateTeamSchedule(pDTO);
			t++;
			l++;
		}
		
		log.info(this.getClass().getName()+".updateLiverpoolSchedule end!");
	}

	@Override
	public void updateMancitySchedule(TeamScheduleDTO pDTO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTottenhamSchedule(TeamScheduleDTO pDTO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateChelseaSchedule(TeamScheduleDTO pDTO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateManuSchedule(TeamScheduleDTO pDTO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateArsenalSchedule(TeamScheduleDTO pDTO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBarcelonaSchedule(TeamScheduleDTO pDTO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRealmadridSchedule(TeamScheduleDTO pDTO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBayernmunichSchedule(TeamScheduleDTO pDTO) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
