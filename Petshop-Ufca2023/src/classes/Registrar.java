package classes;

import java.util.Scanner; 


public class Registrar {
    
    public void Registro()
    {
        try{
            GerenciarRegistro Registrar = new GerenciarRegistro(); 
            System.out.println("Escolha uma opcao:");
            Scanner scan = new Scanner(System.in);
            int opcao = scan.nextInt();
            switch(opcao)
            {
                case 1: 
                    System.out.println("Nome do Tutor: ");
                    String nomeTutor = scan.nextLine(); 
                    System.out.println("Email: ");
                    String email = scan.nextLine(); 
                    System.out.println("Telefone: ");
                    String telefone = scan.nextLine(); 
                    scan.close();
                    Registrar.RegistrarTutor(nomeTutor, email, telefone);
                    break; 
                case 2: 
                    System.out.println("Nome do animal: ");
                    String nome = scan.nextLine();
                    System.out.println("Idade do animal: "); 
                    int idade = scan.nextInt();
                    System.out.println("Raca do animal: ");
                    String raca = scan.nextLine();
                    System.out.println("Peso do animal: ");
                    double peso = Double.parseDouble(scan.nextLine());
                    System.out.println("Selecione a espécie: ");
                    int especie = scan.nextInt();
                    switch(especie)
                    {
                        case 1: 
                            Registrar.RegistrarPet(nome, idade, raca, peso);
                            break; 
                        case 2: 
                            Registrar.RegistrarPet(nome, idade, raca, peso);
                            break; 
                        case 3: 
                            Registrar.RegistrarPet(nome, idade, raca, peso);
                            break; 
                        case 4: 
                            System.out.println("Descreva o animal e a situacao: ");
                            String descricao = scan.nextLine(); 
                            Registrar.RegistrarPetExotico(nome, idade, raca, peso, descricao);
                            break;
                    }
                    scan.close();
                    break; 
            }


        } catch(Exception e){
            
        }
    }
}
