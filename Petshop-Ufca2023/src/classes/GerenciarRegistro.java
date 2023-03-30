package classes;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class GerenciarRegistro 
{

    public void CriarRegistro(){
    {
        try {
            File Pets = new File(new File("").getCanonicalFile().getParent() + "/src/registro/Pets.txt");
            File Tutores = new File(new File("").getCanonicalFile().getParent() + "/src/registro/Tutores.txt");
            if (Pets.createNewFile() && Tutores.createNewFile()) {
            System.out.println("Registros criados: " + Pets.getName() + " & " + Tutores.getName());
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro.");
            e.printStackTrace();
        }
        }
    }

    public void LerRegistroPets()
    {
        {
            try {
                
                File Pets = new File(new File("").getCanonicalFile().getParent() + "/src/registro/Pets.txt");
                Scanner PetsReader = new Scanner(Pets);
                while (PetsReader.hasNextLine()) {
                  String data = PetsReader.nextLine();
                  System.out.println(data);
                }
                PetsReader.close();
              } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                } catch (IOException f){
                    System.out.println("Erro ao procurar diretório");
                }   
        }
    }

    public void LerRegistroTutores()
    {
        {
            try {
                
                File Tutores = new File(new File("").getCanonicalFile().getParent() + "/src/registro/Pets.txt");
                Scanner TutoresReader = new Scanner(Tutores);
                while (TutoresReader.hasNextLine()) {
                  String data = TutoresReader.nextLine();
                  System.out.println(data);
                }
                TutoresReader.close();
              } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                } catch (IOException f){
                    System.out.println("Erro ao procurar diretório");
                }   
        }
    }

    public void RegistrarTutor(String nome, String email, String telefone)
    {
        try{

            FileWriter registrador = new FileWriter(new File("").getCanonicalFile().getParent() + "/src/registro/Tutores.txt");
            registrador.write("{" + "nome" + ":" + nome + "}," + "{" + "email" + ":" + email + "}," + "{" + "telefone" + ":" + telefone + "},");
            registrador.close(); 
            
        } catch(IOException e){
            System.out.println("Erro ao redigir arquivo");
        }
    }

    public void RegistrarPet(String nome, int idade, String raca, double peso)
    {
        try{
            
            FileWriter registrador = new FileWriter(new File("").getCanonicalFile().getParent() + "/src/registro/Pets.txt");
            registrador.write("{" + "nome" + ":" + nome + "}," + "{" + "idade" + ":" + idade + "}," + "{" + "raca" + ":" + raca + "}," + "{" + "peso" + ":" + peso + "},");
            registrador.close();

        } catch (IOException e){
            System.out.println("Erro ao redigir arquivo");
        }
    }

    public void RegistrarPetExotico(String nome, int idade, String raca, double peso, String descricao)
    {
        try{
            
            FileWriter registrador = new FileWriter(new File("").getCanonicalFile().getParent() + "/src/registro/Pets.txt");
            registrador.write("{" + "nome" + ":" + nome + "}," + "{" + "idade" + ":" + idade + "}," + "{" + "raca" + ":" + raca + "}," + "{" + "peso" + ":" + peso + "}," + "{" + "descricao" + ":" + descricao + "},");
            registrador.close();
            
        } catch (IOException e){
            System.out.println("Erro ao redigir arquivo");
        }
    }
}

