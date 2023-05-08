package classes.controllers;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import org.json.JSONArray;

public class Getters {

    public static JSONArray getRegistro(int a)
    {
    	JSONArray jsonArray = new JSONArray(); 
    	switch(a)
    	{
    	case 1:
    		try {
	        	String tutoresData = new String(Files.readAllBytes(Paths.get("./src/registro/Tutores.json")));
	            if (tutoresData.trim().isEmpty()) {
	                jsonArray = new JSONArray();
	            } else {
	                jsonArray = new JSONArray(tutoresData);
	            }
	            return jsonArray; 
    		} catch (Exception e)
    		{
    			break;
    		}
    	case 2: 
    		try {
	        	String PetsData = new String(Files.readAllBytes(Paths.get("./src/registro/Pets.json")));
	            if (PetsData.trim().isEmpty()) {
	                jsonArray = new JSONArray();
	            } else {
	                jsonArray = new JSONArray(PetsData);
	            }
	            return jsonArray; 
    		} catch (Exception e)
    		{
    			break;
    		}
    	case 3:
    		try {
	        	String PetsExoticosData = new String(Files.readAllBytes(Paths.get("./src/registro/PetsExoticos.json")));
	            if (PetsExoticosData.trim().isEmpty()) {
	                jsonArray = new JSONArray();
	            } else {
	                jsonArray = new JSONArray(PetsExoticosData);
	            }
	            return jsonArray; 
    		} catch (Exception e)
    		{
    			break;
    		}
    	}
    	
    	return jsonArray; 
    }
    
    public static void getInformacao()
    {
    	System.out.println("Escolha qual registro acessar:");
    	System.out.println("1 - Tutores \r\n 2 - Pets \r\n 3 - Pets Exoticos");
        Scanner scan = new Scanner(System.in);
        int opcao = scan.nextInt();
        JSONArray json = getRegistro(opcao); 
        switch(opcao)
        {
        case 1:
            System.out.println("Procurar por chave? \r\n1 - Telefone \r\n2 - Email");
            int numChave = scan.nextInt(); 
            scan.nextLine();
            System.out.println("Digite o valor da chave: ");
            String valorChave = scan.nextLine(); 
            int temp = 0; 
            for(int i = 0; i < json.length(); i++)
            {   
            	temp++; 
            	if (numChave == 1 && json.getJSONObject(i).getString("telefone").contains(valorChave))
            	{
            		System.out.println(json.getJSONObject(i));
            		break; 
            	} 	else if (numChave == 2 && json.getJSONObject(i).getString("email").contains(valorChave))
            	{
            		System.out.println(json.getJSONObject(i));
            		break;
            	}
            	if (temp == json.length() - 1) 
            	{
            		System.out.println("Tutor não encontrado.");
            	}
            }
            break; 
        case 2: 
        	System.out.println("Procurar por chave? \r\n1 - Nome \r\n2 - Raça");
            numChave = scan.nextInt(); 
            scan.nextLine(); 
            valorChave = scan.nextLine(); 
            for(int i = 0; i < json.length(); i++)
            {
            	if(numChave == 1 && json.getJSONObject(i).getString("nome").contains(valorChave))
            	{
            		System.out.println(json.getJSONObject(i));
            	} else if (numChave == 2 && json.getJSONObject(i).getString("raca").contains(valorChave))
            	{
            		System.out.println(json.getJSONObject(i));
            	} 
            }
            break; 
        case 3: 
        	System.out.println("Procurar por chave? \r\n1 - Nome \r\n2 - Raça");
            numChave = scan.nextInt(); 
            scan.nextLine();
            valorChave = scan.nextLine(); 
            for(int i = 0; i < json.length(); i++)
            {
            	if(numChave == 1 && json.getJSONObject(i).getString("nome").contains(valorChave))
            	{
            		System.out.println(json.getJSONObject(i));
            	} else if (numChave == 2 && json.getJSONObject(i).getString("raca").contains(valorChave))
            	{
            		System.out.println(json.getJSONObject(i));
            	} 
            }
            break; 
        }
    }
}
