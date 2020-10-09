package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PlayerDAO;
import dao.SkillDAO;
import model.Player;
import model.Skill;

public class Main
{
 public static List<Player> list=new ArrayList<Player>();
  public static void main(String args[]) throws NumberFormatException, IOException, ClassNotFoundException, SQLException
  {
	  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	  System.out.println("Enter the player id(primary key)");
	  long id=Long.parseLong(br.readLine());
	  System.out.println("Enter the country name");
	  String country=br.readLine();
	  System.out.println("Enter the skill id(foreign key of player id)");
	  long skillid=Long.parseLong(br.readLine());
	  System.out.println("Enter the skill name");
	  String skillname=br.readLine();
	  Skill skill=new Skill(skillid,skillname);
	  Player player=new Player(id,country,skill);
	  
	  PlayerDAO playerdao=new PlayerDAO();
	  playerdao.setdetails(player);
	  
	  SkillDAO skilldao=new SkillDAO();
	  skilldao.setdetails(skill);
	  
	  list=playerdao.getAllPlayers();
	  Skill s=(Skill) player.getSkill();
	  for(Player p:list)
	  {
		  System.out.println(p.getPlayerid());
		  System.out.println(p.getCountry());
		  System.out.println(s.getSkillname());
		  System.out.println(s.getSkillid());
	  }
	  
  }      
}


//id name country skill output