package classes.animais;

import classes.Animal;

public class Cachorro extends Animal{
    
    enum Porte {
        PEQUENO, 
        MEDIO,
        GRANDE
    }
    
    public Cachorro(String nome, int idade, String raca, double peso)
    {
        super(nome, idade, raca, peso); 
    }

}
