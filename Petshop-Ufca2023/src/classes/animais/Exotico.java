package classes.animais;

public class Exotico extends Animal{
    
    public String descricao; 

    public Exotico(String nome, int idade, String raca, double peso, String descricao)
    {
        super(nome, idade, raca, peso);
        this.descricao = descricao; 
    }

}
