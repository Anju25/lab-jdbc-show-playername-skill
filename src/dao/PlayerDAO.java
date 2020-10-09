package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Player;
import model.Skill;
import utility.ConnectionManager;

public class PlayerDAO
{
	public static List<Player> list=new ArrayList<Player>();
	public List<Player> getAllPlayers() throws SQLException, ClassNotFoundException
	{
		Connection con=ConnectionManager.getConnection();
		if(con!=null)
		{
	System.out.println("Established");
   // String sql="select playerskill.playerid, playerskill.country, skilldetails.skillname from playerskill,skilldetails where playerskill.playerid=skilldetails.skillid";
	String sql="select * from playerskill join  skilldetails on playerskill.playerid=skilldetails.skillid";
    Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				long id=rs.getLong("playerid");
				String country=rs.getString("country");
				String skillname=rs.getString("skillname");
				long id1=rs.getLong("skillid");
				Skill s=new Skill(id1,skillname);
				Player p=new Player(id,country,s);
				list.add(p);
			}
		}
		return list;
	}
	public void setdetails(Player player) throws SQLException, ClassNotFoundException {
		Connection con=ConnectionManager.getConnection();
		if(con!=null)
		{
			System.out.println("Established");
			String sql="insert into playerskill values(?,?)";
			PreparedStatement st=con.prepareStatement(sql);
			st.setLong(1,player.getPlayerid());
			st.setString(2, player.getCountry());
			st.executeUpdate();
			st.close();
		}
		
	}
}