import classes.GerenciarRegistro;
import classes.Registrar;

public class App {
    public static void main(String[] args) throws Exception 
    {
        GerenciarRegistro Gerenciador = new GerenciarRegistro();
        Gerenciador.CriarRegistro();
        Registrar registro = new Registrar(); 
        registro.Registro(); 
        Gerenciador.LerRegistroPets();
    }
}
