package classes.controllers;

import utils.Agendamento;
import java.util.Scanner;


public class adminControls {
	public static void adminControl() {
		Scanner scan = new Scanner(System.in);
		Registrar registrar = new Registrar(); 
		System.out.println("Bem vindo!");
		System.out.println("1 - Registrar novo tutor\r\n2 - Registrar novo pet\r\n3 - Realizar agendamento\r\n4 - Checar agendamentos\r\n5 - Checar compras da loja\r\n6 - Adicionar ou gerir estoque da loja\r\n7 - Enviar email\r\n8 - Registros\r\n9 - Sair");
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
				classes.controllers.GerenciarAgendamentos.checarAgendamentos(); 
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
				Getters.getInformacao();
			case 9: 
				auth.appState.Iniciar();
				break; 
		}
	}
}
