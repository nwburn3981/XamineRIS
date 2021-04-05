
public class Team {
	private String teamID;
	private String teamName;
	
	public Team(String id, String name) {
		this.teamID = id;
		this.teamName = name;
		
	}
	public String getTeamID() {
		return teamID;
	}
	public void setTeamID(String teamID) {
		this.teamID = teamID;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

}
