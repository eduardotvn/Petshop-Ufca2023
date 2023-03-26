package classes;

public abstract class Animal {
    private String nome; 
    private int idade; 
    private String raca; 
    private double peso; 

    public Animal(String nome, int idade, String raca, double peso)
    {
        this.nome = nome; 
        this.idade = idade; 
        this.raca = raca;
        this.peso = peso; 
        Sucesso();
    }

    public String getNome()
    {
        return this.nome; 
    }

    public int getIdade()
    {
        return this.idade;
    }

    public String getRaca()
    {
        return this.raca;
    }

    public double getPeso()
    {
        return this.peso;
    }

    private void Sucesso()
    {
        System.out.println("Pet registrado!");
        System.out.println(this.getNome());
    }
}
