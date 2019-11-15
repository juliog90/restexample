package webservice;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import model.SecurityManager;
import pojo.UserV0;

@Path("WebService")
public class LoginService 
{
	@POST
	@Path("login")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String login(@FormParam("username") String userName,
			@FormParam("password") String password)
	{
		return getAllUsersList(userName, password);
	}
	
	public String getAllUsersList(String username, String password)
	{
		ArrayList<UserV0> userList = null;
		try {
			userList = SecurityManager.getAllUsersList();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try
		{
			System.out.println(userList.get(0).getUserName());
			
			for(UserV0 userV0 : userList)
			{
				if(userV0.getUserName().contentEquals(username))
				{
					if(userV0.getPassword().contentEquals(password))
					{
						return "Looged in User" + userList.get(0);
					}
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("error" + userList.get(0).getUserName());
		}
		
		return "You are not a Valid User";
	}
}
