package classes;

import auth.appState;
import classes.controllers.Registrar;
import classes.controllers.adminControls;
import classes.controllers.clientControls;
import utils.Agendamento;
import auth.UserDataClass;
import java.util.Scanner;


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
	    		System.out.println("Cliente logado com sucesso!");
	    	} else if(num == 2) {
		    	UserDataClass login = classes.controllers.login.RealizarLogin(num);
	    		System.out.println("Administrador logado com sucesso!");
	    	} else if(num ==3) {
	    		
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
