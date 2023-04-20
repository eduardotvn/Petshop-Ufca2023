package classes;

import auth.appState;
import java.util.Scanner;


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
		
		while(auth.appState.estado.equals(appState.App_State.ADMINISTRADORLOGADO))
		{
			Registrar registrar = new Registrar(); 
			System.out.println("Bem vindo!");
			System.out.println("1 - Registrar novo tutor\r\n2 - Registrar novo pet\r\n3 - Realizar agendamento\r\n4 - Checar agendamentos\r\n5 - Checar compras da loja\r\n6 - Adicionar ou gerir estoque da loja\r\n7 - Enviar email\r\n8 - Deslogar");
			Scanner scan = new Scanner(System.in);
			int opcao = scan.nextInt(); 
			switch(opcao)
			{
				case 1:
					registrar.Registro(opcao);
					break; 
				case 2: 
					registrar.Registro(opcao);
					break; 
				case 3: 
					//Rota agendar
					break; 
				case 4: 
					//Rota checar agendamentos
					break; 
				case 5: 
					//Rota checar compras
					break; 
				case 6: 
					//Gerir estoque da loja
					break;
				case 7: 
					System.out.println("Digite o email do cliente: ");
					scan.nextLine();
					String emailCliente = scan.nextLine(); 
					System.out.println("Digite a senha do email empresarial: ");
					String senha = scan.nextLine(); 
					System.out.println("Digite o assunto do email: ");
					String assunto = scan.nextLine();
					System.out.println("Digite o corpo da mensagem: ");
					String mensagem = scan.nextLine(); 
			    	internetConnectionAPIs.javaMail.sendMail(emailCliente, senha, assunto, mensagem);
					break; 
				case 8: 
					auth.appState.Iniciar();
					break; 
			}
		}
	}
}
