package model;
public class Skill
{
private long skillid;
private String skillname;

public Skill(long skillid, String skillname) {
	super();
	this.skillid = skillid;
	this.skillname = skillname;
}
public long getSkillid() {
	return skillid;
}
public void setSkillid(long skillid) {
	this.skillid = skillid;
}
public String getSkillname() {
	return skillname;
}
public void setSkillname(String skillname) {
	this.skillname = skillname;
}

}
