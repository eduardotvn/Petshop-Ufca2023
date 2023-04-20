package auth;

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

public class login {
	public static boolean RealizarLogin()
	{
		JSONArray jsonArray;
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

			String registrosADM = new String(Files.readAllBytes(Paths.get("./src/registro/Administradores.json")));
            if (registrosADM.trim().isEmpty()) {
                jsonArray = new JSONArray();
            } else {
                jsonArray = new JSONArray(registrosADM);
            }
            
            for(int i = 0; i < jsonArray.length(); i++)
            {
            	byte[] placeholderSenha = new byte[jsonArray.getJSONObject(i).getJSONArray("senha").length()];
            	for(int j = 0; j < placeholderSenha.length; j++)
            	{
            		placeholderSenha[j] = (byte) jsonArray.getJSONObject(i).getJSONArray("senha").getInt(j);
            	}
            	if(jsonArray.getJSONObject(i).getString("login").equals(login) && auth.Authentication.autenticarSenha(senha, placeholderSenha))
            	{
            		auth.appState.Logar(2);
            		return true; 
            	}
            }
            
            
		} catch (Exception e)
		{
			System.out.println("Login falhou");
			return false; 
		}

		return false; 
	}
}
