package poly.service;

import poly.dto.NewsDTO;

public interface IPapagoAPIService {

	String translateTitle(NewsDTO pDTO) throws Exception;
	
	String translateContent(NewsDTO pDTO) throws Exception;
	
	String translateTitleDetail(NewsDTO pDTO) throws Exception;
	
	String translateContentDetail(NewsDTO pDTO) throws Exception;
}
