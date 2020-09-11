package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.PlayerDTO;
import poly.dto.TeamNewsDTO;
import poly.dto.TeamRankDTO;
import poly.dto.TeamScheduleDTO;

@Mapper("MyInfoMapper")
public interface IMyInfoMapper {

	void updateTeamNews(TeamNewsDTO pDTO) throws Exception;
	
	void updatePlayer(PlayerDTO pDTO) throws Exception;
	
	List<PlayerDTO> selectPlayer(PlayerDTO pDTO) throws Exception;
	
	List<TeamNewsDTO> selectTeamNews(TeamNewsDTO pDTO) throws Exception;
	
	TeamNewsDTO selectTeamNewsDetail(TeamNewsDTO pDTO) throws Exception;
	
	void updateTeamRank(TeamRankDTO pDTO) throws Exception;
	
	List<TeamRankDTO> selectTeamRank(TeamRankDTO pDTO) throws Exception;
	
	void updateTeamSchedule(TeamScheduleDTO pDTO) throws Exception;
}
