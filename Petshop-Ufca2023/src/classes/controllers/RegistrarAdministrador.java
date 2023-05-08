package classes.controllers;
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

public class RegistrarAdministrador {
	
	private byte[] chaveGerente; 
	private FileWriter registrador; 
	
	public void Registrar(String login, String senha, String chaveGerente)
	{
		this.chaveGerente = auth.Authentication.getChaveGerente(); 
		try {
			JSONArray jsonArray; 
			String admData = new String(Files.readAllBytes(Paths.get("./src/registro/Administradores.json")));
            if (admData.trim().isEmpty()) {
                jsonArray = new JSONArray();
            } else {
                jsonArray = new JSONArray(admData);
            }
            JSONObject json = new JSONObject();
            
            if(auth.Authentication.autenticarSenha(chaveGerente, this.chaveGerente))
            {
            	json.put("login", login);
            	json.put("senha", auth.Encryption.encryptPassword(senha));
            	jsonArray.put(json);
            	
            	admData = jsonArray.toString(); 
            	
            	registrador = new FileWriter("./src/registro/Administradores.json");
            	registrador.write(admData);
            	registrador.close(); 
            } else {
            	System.out.println("Chave Gerente errada");
            }
            
            
            
		} catch(Exception e)
		{
			System.out.println("Erro ao registrar");
			e.printStackTrace();
		}
	}
}
