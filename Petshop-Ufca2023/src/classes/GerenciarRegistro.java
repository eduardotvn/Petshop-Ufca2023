package classes;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import org.json.JSONObject;
import org.json.JSONArray;

public class GerenciarRegistro 
{
    private FileWriter registrador;

    public void CriarRegistro(){
    {
        try {
            File Pets = new File("./src/registro/Pets.json");
            File Tutores = new File("./src/registro/Tutores.json");
            File PetsExoticos = new File("./src/registro/PetsExoticos.json");
            if (Pets.createNewFile() && Tutores.createNewFile() && PetsExoticos.createNewFile()) {
            System.out.println("Registros criados");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro.");
            e.printStackTrace();
        		}
        }
    }

    public void LerRegistroPets()
    {
        {
            try {
                
                File Pets = new File("./src/registro/Pets.json");
                Scanner PetsReader = new Scanner(Pets);
                while (PetsReader.hasNextLine()) {
                  String data = PetsReader.nextLine();
                  System.out.println(data);
                }
                PetsReader.close();
              } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
        }
    }
    
    public void LerRegistroPetsExoticos()
    {
        {
            try {
                
                File PetsExoticos = new File("./src/registro/PetsExoticos.json");
                Scanner PetsReader = new Scanner(PetsExoticos);
                while (PetsReader.hasNextLine()) {
                  String data = PetsReader.nextLine();
                  System.out.println(data);
                }
                PetsReader.close();
              } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
        }
    }

    public void LerRegistroTutores()
    {
        {
            try {
                
                File Tutores = new File("./src/registro/Tutores.json");
                Scanner TutoresReader = new Scanner(Tutores);
                while (TutoresReader.hasNextLine()) {
                  String data = TutoresReader.nextLine();
                  System.out.println(data);
                }
                TutoresReader.close();
              } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
        }
    }

    public void RegistrarTutor(String nome, String email, String telefone)
    {
    	System.out.println("Teste");
        try{
        	JSONArray jsonArray; 
        	String tutoresData = new String(Files.readAllBytes(Paths.get("./src/registro/Tutores.json")));
            if (tutoresData.trim().isEmpty()) {
                jsonArray = new JSONArray();
            } else {
                jsonArray = new JSONArray(tutoresData);
            }

            JSONObject json = new JSONObject(); 
            json.put("nome", nome);
            json.put("email", email);
            json.put("telefone", telefone);
            jsonArray.put(json); 
            
            String dadosTutor = jsonArray.toString(); 

            registrador = new FileWriter("./src/registro/Tutores.json");
            registrador.write(dadosTutor);
            registrador.close(); 
            
        } catch(Exception e){
        	e.printStackTrace();
        	System.out.println("Falhou");
        }
    }

    public void RegistrarPet(String nome, int idade, String raca, double peso)
    {
    	System.out.println("Cheguei aqui");
        try{
        	JSONArray jsonArray; 
        	String petsData = new String(Files.readAllBytes(Paths.get("./src/registro/Pets.json")));
            if (petsData.trim().isEmpty()) {
                jsonArray = new JSONArray();
            } else {
                jsonArray = new JSONArray(petsData);
            }
        	System.out.println("Cheguei aqui 2");
            JSONObject json = new JSONObject();
            json.put("nome", nome);
            json.put("idade", idade);
            json.put("raca", raca);
            json.put("peso", peso);
            jsonArray.put(json);
        	System.out.println("Cheguei aqui 3");
            String dadosPets = jsonArray.toString();
            
            registrador = new FileWriter("./src/registro/Pets.json");
            registrador.write(dadosPets);
            registrador.close();

        } catch (Exception e){
        	e.printStackTrace();
        }
    }

    public void RegistrarPetExotico(String nome, int idade, String raca, double peso, String descricao)
    {
        try{
            
        	JSONArray jsonArray; 
        	String petsExoticosData = new String(Files.readAllBytes(Paths.get("./src/registro/Pets.json")));
            if (petsExoticosData.trim().isEmpty()) {
                jsonArray = new JSONArray();
            } else {
                jsonArray = new JSONArray(petsExoticosData);
            }
            
            JSONObject json = new JSONObject();
            json.put("nome", nome);
            json.put("idade", idade);
            json.put("raca", raca);
            json.put("peso", peso);
            json.put("descricao", descricao);
            jsonArray.put(json);
            
            String dadosPetsExoticos = jsonArray.toString();
            
            registrador = new FileWriter("./src/registro/PetsExoticos.json");
            registrador.write(dadosPetsExoticos);
            registrador.close();
            
        } catch (IOException e){
            System.out.println("Erro ao redigir arquivo");
        }
    }
    
    public JSONArray getRegistro(int a)
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
    
    public void getInformacao()
    {
    	System.out.println("Escolha qual registro acessar:");
    	System.out.println("1 - Tutores \r\n 2 - Pets \r\n 3 - Pets Exoticos");
        Scanner scan = new Scanner(System.in);
        int opcao = scan.nextInt();
        JSONArray json = getRegistro(opcao); 
        
    }
}
