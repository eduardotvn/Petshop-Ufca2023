package classes;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;  
import java.util.Scanner;

public class GerenciarRegistro 
{
    public void CriarRegistro(){
    {
        try {
            File myObj = new File("./registro/Pets.txt");
            if (myObj.createNewFile()) {
            System.out.println("Registro criado: " + myObj.getName());
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro.");
            e.printStackTrace();
        }
        }
    }

    public void LerRegistro()
    {
        {
            try {
                File Pets = new File("./registro/Pets.txt");
                Scanner myReader = new Scanner(Pets);
                while (myReader.hasNextLine()) {
                  String data = myReader.nextLine();
                  System.out.println(data);
                }
                myReader.close();
              } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }   
        }
    }
}

