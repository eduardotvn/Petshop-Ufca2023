import classes.controllers.GerenciarRegistro;
import classes.controllers.Registrar;
import classes.controllers.RegistrarAdministrador;

import java.util.Arrays;
import classes.GerenciadorDoPrograma;

import auth.*;

public class App {
    public static void main(String[] args) throws Exception 
    {
    	auth.AppState.Iniciar(); 
    	GerenciadorDoPrograma gerente = new GerenciadorDoPrograma();
    	gerente.Gerir();
	
    }
}
