package poly.service;

import java.util.List;

import poly.dto.PlayerDTO;
import poly.dto.TeamNewsDTO;
import poly.dto.TeamRankDTO;
import poly.dto.TeamScheduleDTO;

public interface IMyInfoService {

	//뉴스 팀별 update
	void updateLiverpoolNews(TeamNewsDTO pDTO) throws Exception;
	
	void updateMancityNews(TeamNewsDTO pDTO) throws Exception;
	
	void updateTottenhamNews(TeamNewsDTO pDTO) throws Exception;
	
	void updateChelseaNews(TeamNewsDTO pDTO) throws Exception;
	
	void updateManuNews(TeamNewsDTO pDTO) throws Exception;
	
	void updateArsenalNews(TeamNewsDTO pDTO) throws Exception;
	
	void updateBarcelonaNews(TeamNewsDTO pDTO) throws Exception;
	
	void updateRealmadridNews(TeamNewsDTO pDTO) throws Exception;
	
	void updateBayernmunichNews(TeamNewsDTO pDTO) throws Exception;
	
	//뉴스 팀별 select
	List<TeamNewsDTO> selectTeamNews(TeamNewsDTO pDTO) throws Exception;
	
	TeamNewsDTO selectTeamNewsDetail(TeamNewsDTO pDTO) throws Exception;
	
	//플레이어 팀별 update
	void updatePlayer(PlayerDTO pDTO) throws Exception;
	
	//플레이어 팀별 select
	List<PlayerDTO> selectPlayer(PlayerDTO pDTO) throws Exception;
	
	//순위 팀별 update	
	void updateLiverpoolRank(TeamRankDTO pDTO) throws Exception;
	
	void updateMancityRank(TeamRankDTO pDTO) throws Exception;
	
	void updateTottenhamRank(TeamRankDTO pDTO) throws Exception;
	
	void updateChelseaRank(TeamRankDTO pDTO) throws Exception;
	
	void updateManuRank(TeamRankDTO pDTO) throws Exception;
	
	void updateArsenalRank(TeamRankDTO pDTO) throws Exception;
	
	void updateBarcelonaRank(TeamRankDTO pDTO) throws Exception;
	
	void updateRealmadridRank(TeamRankDTO pDTO) throws Exception;
	
	void updateBayernmunichRank(TeamRankDTO pDTO) throws Exception;
	
	List<TeamRankDTO> selectTeamRank(TeamRankDTO pDTO) throws Exception;
	
	//일정 팀별 update
	void updateLiverpoolSchedule(TeamScheduleDTO pDTO) throws Exception;
	
	void updateMancitySchedule(TeamScheduleDTO pDTO) throws Exception;
	
	void updateTottenhamSchedule(TeamScheduleDTO pDTO) throws Exception;
	
	void updateChelseaSchedule(TeamScheduleDTO pDTO) throws Exception;
	
	void updateManuSchedule(TeamScheduleDTO pDTO) throws Exception;
	
	void updateArsenalSchedule(TeamScheduleDTO pDTO) throws Exception;
	
	void updateBarcelonaSchedule(TeamScheduleDTO pDTO) throws Exception;
	
	void updateRealmadridSchedule(TeamScheduleDTO pDTO) throws Exception;
	
	void updateBayernmunichSchedule(TeamScheduleDTO pDTO) throws Exception;
}
