package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.NewsDTO;
import poly.dto.RankDTO;
import poly.dto.ScheduleDTO;

@Mapper("SoccerMapper")
public interface ISoccerMapper {

	void updateRank(RankDTO pDTO) throws Exception;
	
	List<RankDTO> selectRank() throws Exception;
	
	void updateSchedule(ScheduleDTO pDTO) throws Exception;
	
	List<ScheduleDTO> selectSchedule() throws Exception;
	
	void updateNews(NewsDTO pDTO) throws Exception;
	
	List<NewsDTO> selectNews() throws Exception;
	
	NewsDTO selectNewsDetail(NewsDTO pDTO) throws Exception;
}