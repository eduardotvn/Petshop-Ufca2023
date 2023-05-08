package classes.animais;

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

    public void setNome(String nome)
    {
        this.nome = nome; 
    }

    public int getIdade()
    {
        return this.idade;
    }

    public void setIdade(int idade)
    {
        this.idade = idade;
    }

    public String getRaca()
    {
        return this.raca;
    }

    public void setRaca(String raca)
    {
        this.raca = raca; 
    }

    public double getPeso()
    {
        return this.peso;
    }

    public void setPeso(double peso)
    {
        this.peso = peso; 
    }

    private void Sucesso()
    {
        System.out.println("Pet registrado!");
        System.out.println(this.getNome());
    }
}
