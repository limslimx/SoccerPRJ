package poly.service.impl;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import poly.dto.NewsDTO;
import poly.service.IPapagoAPIService;

@Service("PapagoAPI")
public class PapagoAPIService implements IPapagoAPIService{

	private Logger log=Logger.getLogger(this.getClass());
	
	@Override
	public String translateTitle(NewsDTO pDTO) throws Exception {

		String clientId = "aGrQZgZZ6pruyWUmiOki"; //애플리케이션 클라이언트 아이디값";
        String clientSecret = "jXgakJTu87"; //애플리케이션 클라이언트 시크릿값";
        StringBuffer response=null;
        
        try {
            String text = URLEncoder.encode(pDTO.getTitle(), "UTF-8");
            String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            // post request
            String postParams = "source=en&target=ko&text=" + text;
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            log.info(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
		return response.toString();
	}

	@Override
	public String translateContent(NewsDTO pDTO) throws Exception {
		
		String clientId = "aGrQZgZZ6pruyWUmiOki"; //애플리케이션 클라이언트 아이디값";
        String clientSecret = "jXgakJTu87"; //애플리케이션 클라이언트 시크릿값";
        StringBuffer response=null;
        
        try {
            String text = URLEncoder.encode(pDTO.getContent(), "UTF-8");
            String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            // post request
            String postParams = "source=en&target=ko&text=" + text;
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            log.info(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
		return response.toString();
	}

	@Override
	public String translateTitleDetail(NewsDTO pDTO) throws Exception {
		
		String clientId = "aGrQZgZZ6pruyWUmiOki"; //애플리케이션 클라이언트 아이디값";
        String clientSecret = "jXgakJTu87"; //애플리케이션 클라이언트 시크릿값";
        StringBuffer response=null;
        try {
            String text = URLEncoder.encode(pDTO.getTitleDetail(), "UTF-8");
            String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            // post request
            String postParams = "source=en&target=ko&text=" + text;
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            log.info(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
		return response.toString();
	}

	@Override
	public String translateContentDetail(NewsDTO pDTO) throws Exception {
		
		String clientId = "aGrQZgZZ6pruyWUmiOki"; //애플리케이션 클라이언트 아이디값";
        String clientSecret = "jXgakJTu87"; //애플리케이션 클라이언트 시크릿값";
        StringBuffer response=null;
        
        try {
            String text = URLEncoder.encode(pDTO.getContentDetail(), "UTF-8");
            String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            // post request
            String postParams = "source=en&target=ko&text=" + text;
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            log.info(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
		return response.toString();
	}
    
}