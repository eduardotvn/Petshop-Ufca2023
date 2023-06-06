package classes;

import auth.AppState;
import classes.controllers.Registrar;
import classes.controllers.AdminControls;
import classes.controllers.ClientControls;
import utils.Agendamento;
import auth.UserData;
import java.util.Scanner;
import classes.controllers.RegistrarAdministrador;

public class GerenciadorDoPrograma {
	
	public static void Gerir()
	{
		Scanner scan = new Scanner(System.in);
		while(auth.AppState.estado.equals(AppState.App_State.DESLOGADO))
		{
			System.out.println("Fazer Login? \r\n1 - Cliente\r\n2 - Administrador\r\n3 - Registrar Administrador");
			int num = scan.nextInt();
	    	if(num == 1)
	    	{
		    	UserData login = classes.controllers.Login.RealizarLogin(num);	    
		    	if(login != null) {
		    		System.out.println("Cliente logado com sucesso!");
		    	} 
	    	} else if(num == 2) {
		    	UserData login = classes.controllers.Login.RealizarLogin(num);	    		
		    	if(login != null) {
		    		System.out.println("Administrador logado com sucesso!");
		    	} 
	    	} else if(num == 3) {
	    		RegistrarAdministrador regis = new RegistrarAdministrador();
	    		scan.nextLine();
	    		System.out.println("Escolha um login: ");
	    		String c1 =scan.nextLine(); 
	    		System.out.println("Escolha uma senha: ");
	    		scan.nextLine();
	    		String c2 =scan.nextLine(); 
	    		System.out.println("Digite a chave gerente: ");
	    		scan.nextLine();
	    		String c3 =scan.nextLine(); 
	    		regis.Registrar(c1, c2, c3);
	    	} 
	    	else
	    	{
	    		System.out.println("Tente novamente.");
	    	}
		}
		
		while(auth.AppState.estado.equals(AppState.App_State.ADMINISTRADORLOGADO))
		{
			AdminControls.adminControl();
		}
		while(auth.AppState.estado.equals(AppState.App_State.CLIENTELOGADO))
		{
			ClientControls.clientControl();
		}
	}
}
