package classes;

import auth.appState;

public class GerenciadorDoPrograma {
	
	public void Gerir()
	{
		while(auth.appState.estado.equals(appState.App_State.DESLOGADO))
		{
	    	boolean login = auth.login.RealizarLogin();
	    	if(login)
	    	{
	    		System.out.println("Administrador logado com sucesso!");
	    	} else {
	    		System.out.println("Tente novamente");
	    	}
		}
	}
}
