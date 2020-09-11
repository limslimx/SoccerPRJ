package poly.service;

import java.util.List;

import poly.dto.NewsDTO;
import poly.dto.RankDTO;
import poly.dto.ScheduleDTO;

public interface ISoccerService {

	void updateRank(RankDTO pDTO) throws Exception;
	
	List<RankDTO> selectRank() throws Exception;
	
	List<ScheduleDTO> updateSchedule(ScheduleDTO pDTO) throws Exception;
	
	List<ScheduleDTO> selectSchedule() throws Exception;
	
	void updateNews(NewsDTO pDTO) throws Exception;
	
	List<NewsDTO> selectNews() throws Exception;
	
	NewsDTO selectNewsDetail(NewsDTO pDTO) throws Exception;
}
