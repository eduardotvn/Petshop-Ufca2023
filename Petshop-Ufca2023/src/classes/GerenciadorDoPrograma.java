package classes;

import auth.appState;
import classes.controllers.Registrar;
import classes.controllers.adminControls;
import classes.controllers.clientControls;
import utils.Agendamento;
import auth.UserDataClass;
import java.util.Scanner;
import classes.controllers.RegistrarAdministrador;

public class GerenciadorDoPrograma {
	
	public void Gerir()
	{
		Scanner scan = new Scanner(System.in);
		while(auth.appState.estado.equals(appState.App_State.DESLOGADO))
		{
			System.out.println("Fazer Login? \r\n1 - Cliente\r\n2 - Administrador\r\n3 - Registrar Administrador");
			int num = scan.nextInt();
	    	if(num == 1)
	    	{
		    	UserDataClass login = classes.controllers.login.RealizarLogin(num);	    
		    	if(login != null) {
		    		System.out.println("Cliente logado com sucesso!");
		    	} 
	    	} else if(num == 2) {
		    	UserDataClass login = classes.controllers.login.RealizarLogin(num);	    		
		    	if(login != null) {
		    		System.out.println("Administrador logado com sucesso!");
		    	} 
	    	} else if(num ==3) {
	    		RegistrarAdministrador regis = new RegistrarAdministrador(); 
	    		System.out.println("Escolha um login: ");
	    		String c1 =scan.nextLine(); 
	    		System.out.println("Escolha uma senha: ");
	    		String c2 =scan.nextLine(); 
	    		System.out.println("Digite a chave gerente: ");
	    		String c3 =scan.nextLine(); 
	    		regis.Registrar(c1, c2, c3);
	    	}
	    	else
	    	{
	    		System.out.println("Tente novamente.");
	    	}
		}
		
		while(auth.appState.estado.equals(appState.App_State.ADMINISTRADORLOGADO))
		{
			adminControls.adminControl();
		}
		while(auth.appState.estado.equals(appState.App_State.CLIENTELOGADO))
		{
			clientControls.clientControl();
		}
	}
}
