package auth;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;

public class BuildUserData {
	static String placeholderLogin;
	static String placeholderEmail;
	static JSONArray jsonArray;
	static private String registros;
	public static UserData fetchData(String login, int num) {
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
            
            for(int i = 0; i < jsonArray.length(); i++) {
            	if (jsonArray.getJSONObject(i).getString("login").equals(login)) {
            		placeholderLogin = jsonArray.getJSONObject(i).getString("login");
            		if(jsonArray.getJSONObject(i).has("email")) {
            			placeholderEmail = jsonArray.getJSONObject(i).getString("email");
            		}
            	}
            }
            if (placeholderLogin == null) {
            	System.out.print("Erro instanciando dados do usuário");
            }
            UserData logged = new UserData(placeholderLogin, placeholderEmail);
            return logged; 
            
		} catch(Exception e) {
			System.out.print(e);
			return null;
		}
	}
}