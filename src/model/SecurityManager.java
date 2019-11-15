package model;

import java.sql.Connection;
import java.util.ArrayList;

import dao.DbConnection;
import dao.LoginHandler;
import pojo.UserV0;

public class SecurityManager {
	public static ArrayList<UserV0> getAllUsersList() throws Exception
	{
		ArrayList<UserV0> userList = null;
		try
		{
			Connection connection = DbConnection.getConnection();
			userList = LoginHandler.getAllusers(connection);
		}
		catch(Exception e)
		{
			throw e;
		}
		
		return userList;
	}
}
