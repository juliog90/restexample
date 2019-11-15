package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import pojo.UserV0;

public class LoginHandler 
{
	public static ArrayList<UserV0> getAllusers(Connection connection) throws Exception
	{
		ArrayList<UserV0> userList = new ArrayList<UserV0>();
		try
		{
			// String uname  request.getParameter("uname");
			String sql = "select * from user";
			PreparedStatement ps = connection.prepareStatement(sql);
			// ps.setString(1.uname);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				UserV0 uservo = new UserV0();
				uservo.setUserName(rs.getString("username"));
				uservo.setPassword(rs.getString("password"));
				userList.add(uservo);
			}
			
			return userList;
		}
		catch(Exception e)
		{
			throw e;
		}
		
	}
}
