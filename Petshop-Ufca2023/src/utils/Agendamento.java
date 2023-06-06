package utils;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Scanner; 
import org.json.JSONArray;
import org.json.JSONObject;

import auth.AppState;

public class Agendamento {
	public void agendar()
	{
		JSONArray jsonArray; 
		Scanner scan = new Scanner(System.in);
		int dia; 
		int mes; 
		int ano; 
		String cliente; 
		String procedimento; 
		boolean emergencia; 
		
		try {
			String agendamentosData = new String(Files.readAllBytes(Paths.get("./src/registro/Agendamentos.json")));
			JSONObject json = new JSONObject(); 
            if (agendamentosData.trim().isEmpty()) {
                jsonArray = new JSONArray();
            } else {
                jsonArray = new JSONArray(agendamentosData);
            }
            
            System.out.println("Escolha um dia para o agendamento: ");
            dia = scan.nextInt();
            System.out.println("Escolha um mês: ");
            mes = scan.nextInt();
            System.out.println("Escolha um ano: ");
            ano = scan.nextInt();
            LocalDate dataMarcada = LocalDate.of(ano, mes, dia);
            scan.nextLine();
            if(auth.AppState.estado.equals(AppState.App_State.ADMINISTRADORLOGADO))
            {
            	System.out.println("Digite o nome do cliente: ");
            	cliente = scan.nextLine(); 
            	System.out.println("Qual o procedimento? ");
            	procedimento = scan.nextLine(); 
            	System.out.println("Emergencia?"); 
            	String bool = scan.nextLine(); 
            	if(bool == "y" || bool == "Y")
            	{	
            		emergencia = true; 
            	} else
            	{
            		emergencia = false; 
            	}
            } else 
            {
            	cliente = classes.controllers.Login.getUser();
            	System.out.println("Qual o procedimento?");
            	procedimento = scan.nextLine(); 
            	System.out.println("Emergencia?");
            	String bool = scan.nextLine(); 
            	if(bool == "y" || bool == "Y")
            	{	
            		emergencia = true; 
            	} else
            	{
            		emergencia = false; 
            	}
            }
            
            
            json.put("cliente", cliente);
            json.put("data", dataMarcada);
            json.put("procedimento", procedimento);
            json.put("emergencia", emergencia);
            
            jsonArray.put(json);
            agendamentosData = jsonArray.toString(); 
            
            FileWriter registrador = new FileWriter("./src/registro/Agendamentos.json"); 
            registrador.write(agendamentosData);
            registrador.close();
            
            
            
		} catch (Exception e)
		{
			
		}
	}
}
