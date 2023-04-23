package routes;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import org.json.JSONArray;

public class GerenciarAgendamentos {

		private static JSONArray jsonArray;
		private static Scanner scan = new Scanner(System.in);

		public static void checarAgendamentos()
		{
			System.out.println("1 - Checar todos os agendamentos\r\n2 - Checar agenda para hoje");
			int opcao = scan.nextInt();
			try {
				String agendamentosData = new String(Files.readAllBytes(Paths.get("./src/registro/Agendamentos.json")));
	            if (agendamentosData.trim().isEmpty()) {
	                jsonArray = new JSONArray();
	            } else {
	                jsonArray = new JSONArray(agendamentosData);
	            } 
	            if(opcao == 1)
	            {
	            	for(int i = 0; i < jsonArray.length(); i++)
	            	{
	            		System.out.println(jsonArray.getJSONObject(i)); 
	            	}
	            } else if(opcao == 2)
	            {
	            	for(int i = 0; i < jsonArray.length(); i++)
	            	{
	            		if(jsonArray.getJSONObject(i).getString("data").contains(LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE)))
	            		{
		            		System.out.println(jsonArray.getJSONObject(i)); 	            			
	            		}
	            	}
	            }
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
		public static void checarAgendamentosCliente()
		{
			try {
				String agendamentosData = new String(Files.readAllBytes(Paths.get("./src/registro/Agendamentos.json")));
	            if (agendamentosData.trim().isEmpty()) {
	                jsonArray = new JSONArray();
	            } else {
	                jsonArray = new JSONArray(agendamentosData);
	            } 
	            
	            for(int i = 0; i < jsonArray.length(); i++)
	            {
	            	if(jsonArray.getJSONObject(i).getString("cliente").contains(auth.login.getUser()))
	            	{
	            		System.out.println(jsonArray.getJSONObject(i));
	            	}
	            }
			} catch(Exception e)
			{
				e.printStackTrace();
			}

		}
}
