package auth;

public class AppState {
	public static enum App_State{
		DESLOGADO, 
		CLIENTELOGADO,
		ADMINISTRADORLOGADO
	}
	
	public static App_State estado; 
	
	public static void Iniciar()
	{
		estado = App_State.DESLOGADO; 
	}
	
	public static void Logar(int i)
	{
		if(i == 1)
		{
			estado = App_State.CLIENTELOGADO; 
		} else if(i == 2)
		{
			estado = App_State.ADMINISTRADORLOGADO; 
		}
	}
	
}
