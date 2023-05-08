package classes.controllers;

import utils.Agendamento;
import java.util.Scanner;

public class clientControls {
	public static void clientControl() {
		Scanner scan = new Scanner(System.in);
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
				classes.controllers.GerenciarAgendamentos.checarAgendamentosCliente();
				break; 
			case 5:
				auth.appState.Iniciar();
				break; 
		}
	}
}
