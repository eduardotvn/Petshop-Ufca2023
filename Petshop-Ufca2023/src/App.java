import classes.GerenciarRegistro;
import classes.Registrar;
import classes.RegistrarAdministrador;
import java.util.Arrays;
import classes.GerenciadorDoPrograma;

import auth.*;

public class App {
    public static void main(String[] args) throws Exception 
    {
    	auth.appState.Iniciar(); 
    	GerenciadorDoPrograma gerente = new GerenciadorDoPrograma();
    	gerente.Gerir();
    	
    	GerenciarRegistro Gerenciador = new GerenciarRegistro();
        Gerenciador.CriarRegistro();
        Gerenciador.getInformacao();
	
    }
}
