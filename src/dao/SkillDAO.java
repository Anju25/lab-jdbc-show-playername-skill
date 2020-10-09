package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Skill;
import utility.ConnectionManager;

public class SkillDAO
{
   public Skill getSkillByID(Long id) throws ClassNotFoundException, SQLException
   {
	   Connection con=ConnectionManager.getConnection();
		Skill s=null;
		if(con!=null)
		{
			System.out.println("Established");
			String sql="select * from skilldetails";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			System.out.println("skill details");
		
			while(rs.next())
			{
				long id1=rs.getLong(1);
				if(id1==id)
				{
					String name=rs.getString("skillname");
					System.out.printf("%1s %8s",id1,name);
					s=new Skill(id1,name);
				}
			}
		}
	   
	return s;
	 }

public void setdetails(Skill skill) throws ClassNotFoundException, SQLException {
	Connection con=ConnectionManager.getConnection();
	if(con!=null)
	{
		System.out.println("Established");
		String sql="insert into skilldetails values(?,?)";
		PreparedStatement st=con.prepareStatement(sql);
		st.setLong(1,skill.getSkillid());
		st.setNString(2, skill.getSkillname());
		st.executeUpdate();
		st.close();
	}
	
}
}