package classes.controllers;

import utils.Agendamento;
import java.util.Scanner;

public class ClientControls {
	public static void clientControl() {
		Scanner scan = new Scanner(System.in);
		System.out.println("1 - Registrar novo pet\r\n2 - Ver meus Pets\r\n3 - Loja\r\n4 - Agendar procedimento\r\n5 - Checar meus agendamentos\r\n6 - Sair\r\n7 - Excluir minha conta");
		Registrar registrar = new Registrar(); 
		int opcao = scan.nextInt(); 
		switch(opcao)
		{
			case 1:
				registrar.Registro(2, "");
				break; 
			case 2:
				classes.controllers.Getters.VerMeusPets(classes.controllers.Login.getUserEmail());
				break;
			case 3:
				classes.GerenciarLoja.Comprar();
				break; 
			case 4: 
				Agendamento data = new Agendamento();
				data.agendar();
				break;
			case 5:
				classes.controllers.GerenciarAgendamentos.checarAgendamentosCliente();
				break; 
			case 6:
				auth.AppState.Iniciar();
				classes.GerenciadorDoPrograma.Gerir();
				break; 
			case 7:
				classes.controllers.GerenciarRegistro.RemoverUsuario(classes.controllers.Login.getUserEmail());
				auth.AppState.Iniciar();
				classes.GerenciadorDoPrograma.Gerir();
				break; 
		}
	}
}
