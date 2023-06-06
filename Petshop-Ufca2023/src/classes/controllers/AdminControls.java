package classes.controllers;

import utils.Agendamento;
import java.util.Scanner;

public class AdminControls {
	public static void adminControl() {
		Scanner scan = new Scanner(System.in);
		Registrar registrar = new Registrar(); 
		System.out.println("Bem vindo!");
		System.out.println("1 - Registrar novo tutor\r\n2 - Registrar novo pet\r\n3 - Realizar agendamento\r\n4 - Checar agendamentos\r\n5 - Checar compras da loja\r\n6 - Adicionar ou gerir estoque da loja\r\n7 - Enviar email\r\n8 - Registros\r\n9 - Ver todos os clientes\r\n10 - Remover cliente\r\n11 - Sair");
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
				classes.GerenciarLoja.ChecarCompras();
				break; 
			case 6: 
				System.out.println("1 - Checar loja\r\n2 - Adicionar produto\r\n3 - Alterar produto");
				opcao = scan.nextInt();
				switch(opcao) {
				case 1: 
					classes.GerenciarLoja.checarLoja();
					break;
				case 2:
					classes.GerenciarLoja.inserirProduto();
					break;
				case 3:
					classes.GerenciarLoja.alterarProduto();
					break; 
				}
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
		    	internetConnectionAPIs.JavaMail.sendMail(emailCliente, senha, assunto, mensagem);
				break; 
			case 8:
				Getters.getInformacao();
				break; 
			case 9: 
				classes.controllers.Getters.VerTodosOsClientes();
				break; 
			case 10:
				System.out.println("Digite o email do cliente a ser removido:");
				String email = scan.nextLine();
				scan.nextLine();
				classes.controllers.GerenciarRegistro.RemoverUsuario(email);
				break; 
			case 11:
				auth.AppState.Iniciar();
				classes.GerenciadorDoPrograma.Gerir();
				break; 
		}
	}
}
