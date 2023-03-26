import classes.GerenciarRegistro;
import classes.animais.*;


public class App {
    public static void main(String[] args) throws Exception 
    {
        GerenciarRegistro Gerenciador = new GerenciarRegistro();
        Gerenciador.CriarRegistro();
        Gerenciador.LerRegistro();
    }
}
