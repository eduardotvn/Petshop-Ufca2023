package classes;

import auth.appState;
import routes.Agendamento;
import auth.UserDataClass;
import java.util.Scanner;


public class GerenciadorDoPrograma {
	
	public void Gerir()
	{
		Scanner scan = new Scanner(System.in);
		while(auth.appState.estado.equals(appState.App_State.DESLOGADO))
		{
			System.out.println("Fazer Login? \r\n1 - Cliente\r\n2 - Administrador");
			int num = scan.nextInt();
	    	UserDataClass login = auth.login.RealizarLogin(num);
	    	if(login != null && num == 1)
	    	{
	    		System.out.println("Cliente logado com sucesso!");
	    	} else if(login != null && num == 2) {
	    		System.out.println("Administrador logado com sucesso!");
	    	} else
	    	{
	    		System.out.println("Tente novamente.");
	    	}
		}
		
		while(auth.appState.estado.equals(appState.App_State.ADMINISTRADORLOGADO))
		{
			Registrar registrar = new Registrar(); 
			System.out.println("Bem vindo!");
			System.out.println("1 - Registrar novo tutor\r\n2 - Registrar novo pet\r\n3 - Realizar agendamento\r\n4 - Checar agendamentos\r\n5 - Checar compras da loja\r\n6 - Adicionar ou gerir estoque da loja\r\n7 - Enviar email\r\n8 - Deslogar");
			int opcao = scan.nextInt(); 
			switch(opcao)
			{
				case 1:
					scan.nextLine(); 
					System.out.println("Digite a senha do email: ");
					String senhaEmail = scan.nextLine(); 
					registrar.Registro(opcao, senhaEmail);
					break; 
				case 2: 
					registrar.Registro(opcao, "");
					break; 
				case 3: 
			    	Agendamento data = new Agendamento();
			    	data.agendar();
					break; 
				case 4: 
					routes.GerenciarAgendamentos.checarAgendamentos(); 
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
		while(auth.appState.estado.equals(appState.App_State.CLIENTELOGADO))
		{
			System.out.println("1 - Registrar novo pet\r\n2 - Loja\r\n3 - Agendar procedimento\r\n4 - Checar meus agendamentos\r\n5 - Sair");
			Registrar registrar = new Registrar(); 
			int opcao = scan.nextInt(); 
			switch(opcao)
			{
				case 1:
					registrar.Registro(2, "");
					break; 
				case 2:
					//Rota loja
					break; 
				case 3: 
					Agendamento data = new Agendamento();
					data.agendar();
					break;
				case 4:
					routes.GerenciarAgendamentos.checarAgendamentosCliente();
					break; 
				case 5:
					auth.appState.Iniciar();
					break; 
			}
		}
	}
}
