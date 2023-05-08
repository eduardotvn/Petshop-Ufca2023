package classes.controllers;

import java.util.Arrays;
import java.util.Scanner; 
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import org.json.JSONObject;
import org.json.JSONArray;
import auth.Authentication;
import auth.UserDataClass;

public class login {
	
	public static UserDataClass user; 
	
	public static UserDataClass RealizarLogin(int num)
	{
		JSONArray jsonArray;
		String registros; 
		Scanner scan = new Scanner(System.in);
		System.out.println("Login:");
		String login = "";
		  if(scan.hasNextLine()) {
		        login = scan.nextLine(); 
		    }
		System.out.println("Senha: ");
		String senha = "";
		  if(scan.hasNextLine()) {
		        senha = scan.nextLine(); 
		    }
		try{
			if(num == 1) 
			{
				registros = new String(Files.readAllBytes(Paths.get("./src/registro/Tutores.json")));
			} else if (num == 2) {
				registros = new String(Files.readAllBytes(Paths.get("./src/registro/Administradores.json")));
			} else
			{
				return null; 
			}
            if (registros.trim().isEmpty()) {
                jsonArray = new JSONArray();
            } else {
                jsonArray = new JSONArray(registros);
            }
            
            for(int i = 0; i < jsonArray.length(); i++)
            {
            	byte[] placeholderSenha = new byte[jsonArray.getJSONObject(i).getJSONArray("senha").length()];
            	for(int j = 0; j < placeholderSenha.length; j++)
            	{
            		placeholderSenha[j] = (byte) jsonArray.getJSONObject(i).getJSONArray("senha").getInt(j);
            	}
            	if(jsonArray.getJSONObject(i).getString("login").equals(login) && auth.Authentication.autenticarSenha(senha, placeholderSenha) && num == 2)
            	{
            		auth.appState.Logar(2);
            		user = new UserDataClass(login);
            		return user; 
            	} else if(jsonArray.getJSONObject(i).getString("login").equals(login) && auth.Authentication.autenticarSenha(senha, placeholderSenha) && num == 1)
            	{
            		auth.appState.Logar(1);
            		user = new UserDataClass(login);
            		return user; 
            	}
            }
            
            
		} catch (Exception e)
		{
			System.out.println("Login falhou");
			return null; 
		}

		return null; 
	}
	
	public static String getUser()
	{
		return user.login; 
	}
}
