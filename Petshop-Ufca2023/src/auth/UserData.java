package auth;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;

public class UserData {
	public String login; 
	public String email; 
	public UserData(String login, String email)
	{
		this.login = login; 
		this.email = email;
	}
}
