import classes.GerenciarRegistro;
import classes.Registrar;
import classes.RegistrarAdministrador;
import classes.GerenciadorDoPrograma;
import java.util.Arrays;

import auth.*;

public class App {
    public static void main(String[] args) throws Exception 
    {
    	auth.appState.Iniciar(); 
    	GerenciadorDoPrograma gerenciadorDoPrograma = new GerenciadorDoPrograma();
    	gerenciadorDoPrograma.Gerir();
    	
    	/*GerenciarRegistro Gerenciador = new GerenciarRegistro();
        Gerenciador.CriarRegistro();
        Registrar registro = new Registrar(); 
        registro.Registro(); 
        Gerenciador.getInformacao();*/
	
    }
}
