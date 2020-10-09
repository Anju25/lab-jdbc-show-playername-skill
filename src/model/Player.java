package model;
public class Player
{
	private long playerid;
	private String country;
	Skill skill;
	
	public Player(long playerid, String country, Skill skill) {
		super();
		this.playerid = playerid;
		this.country = country;
		this.skill = skill;
	}
	public long getPlayerid() {
		return playerid;
	}
	public void setPlayerid(long playerid) {
		this.playerid = playerid;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	
}