package poly.dto;

public class TeamRankDTO {

	private String collectTime;
	private String league;
	private String link; //sql update시에 중복값 처리 방지용 데이터
	private String image;
	private String myTeam;
	private String teamName;
	private String rank;
	private String team;
	private String totalMatch;
	private String wonMatch;
	private String drawMatch;
	private String lostMatch;
	private String diff;
	private String points;
	
	
	
	public String getCollectTime() {
		return collectTime;
	}
	public void setCollectTime(String collectTime) {
		this.collectTime = collectTime;
	}
	public String getLeague() {
		return league;
	}
	public void setLeague(String league) {
		this.league = league;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getMyTeam() {
		return myTeam;
	}
	public void setMyTeam(String myTeam) {
		this.myTeam = myTeam;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getTotalMatch() {
		return totalMatch;
	}
	public void setTotalMatch(String totalMatch) {
		this.totalMatch = totalMatch;
	}
	public String getWonMatch() {
		return wonMatch;
	}
	public void setWonMatch(String wonMatch) {
		this.wonMatch = wonMatch;
	}
	public String getDrawMatch() {
		return drawMatch;
	}
	public void setDrawMatch(String drawMatch) {
		this.drawMatch = drawMatch;
	}
	public String getLostMatch() {
		return lostMatch;
	}
	public void setLostMatch(String lostMatch) {
		this.lostMatch = lostMatch;
	}
	public String getDiff() {
		return diff;
	}
	public void setDiff(String diff) {
		this.diff = diff;
	}
	public String getPoints() {
		return points;
	}
	public void setPoints(String points) {
		this.points = points;
	}

	
}
