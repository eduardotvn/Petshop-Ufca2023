package classes;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Scanner; 
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

class Produto {
	public String name; 
	public double preco; 
	public String descricao; 
	public int estoque; 
	public Produto(String name, double preco, String descricao, int estoque){
		this.name = name; 
		this.preco = preco;
		this.descricao = descricao;
		this.estoque = estoque;
	}
}

class Compra { 
	public Produto produto; 
	public LocalDate data;
}

class Carrinho {
    public List<Produto> produtos;
    public double total;

    public Carrinho() {
        produtos = new ArrayList<>();
        total = 0.0;
    }
    
    public double precoTotal() {
    	double temp = 0.0; 
    	for(int i = 0; i < produtos.size(); i++) {
    		temp += produtos.get(i).preco;
    	}
    	total = temp;
    	return total; 
    }
}
public class GerenciarLoja {
	static Scanner scan = new Scanner(System.in);
	public static void checarCompras() {
		JSONArray jsonArray = new JSONArray(); 
		try {
        	String ComprasJson = new String(Files.readAllBytes(Paths.get("./src/registro/Compras.json")));
            if (ComprasJson.trim().isEmpty()) {
                jsonArray = new JSONArray();
            } else {
                jsonArray = new JSONArray(ComprasJson);
            } 
		} catch (Exception e)
		{
			System.out.println(e);
		}
		
		for(int i = 0; i < jsonArray.length(); i++) {
			System.out.println(jsonArray.getJSONObject(i));
		}
	}
	
	public static void checarLoja() {
		JSONArray jsonArray = new JSONArray(); 
		try {
        	String LojaJson = new String(Files.readAllBytes(Paths.get("./src/registro/Loja.json")));
            if (LojaJson.trim().isEmpty()) {
                jsonArray = new JSONArray();
            } else {
                jsonArray = new JSONArray(LojaJson);
            } 
		} catch (Exception e)
		{
			System.out.println(e);
		}
		for(int i = 0; i < jsonArray.length(); i++) {
			System.out.println("Produto: " + jsonArray.getJSONObject(i).getString("nome") +"\r\nDescricão: " + jsonArray.getJSONObject(i).getString("descricao") + "\r\nPreço: " + jsonArray.getJSONObject(i).getDouble("preco") + "\r\nEstoque: " + jsonArray.getJSONObject(i).getInt("estoque"));
			System.out.println("\r\n----------------------\r\n");
		}
	}
	
	public static void inserirProduto() {
		try{
		System.out.println("Digite os dados do produto:\r\nNome:");
		String nome = scan.nextLine(); 
		scan.nextLine();
		System.out.println("Descricao:");
		String descricao = scan.nextLine();
		System.out.println("Preco:");
		double preco = scan.nextDouble();
		scan.nextLine();
		System.out.println("Estoque:");
		int estoque = scan.nextInt();
		scan.nextLine();
		Produto produto = new Produto(nome, preco, descricao, estoque);
		JSONArray jsonArray; 
    	String LojaJson = new String(Files.readAllBytes(Paths.get("./src/registro/Loja.json")));
        if (LojaJson.trim().isEmpty()) {
            jsonArray = new JSONArray();
        } else {
            jsonArray = new JSONArray(LojaJson);
        }

        JSONObject json = new JSONObject(); 
        json.put("nome", produto.name);
        json.put("preco", produto.preco);
        json.put("descricao", produto.descricao);
        json.put("estoque", produto.estoque);
        
        jsonArray.put(json); 
        
        String DadosLoja = jsonArray.toString(); 

        FileWriter registrador = new FileWriter("./src/registro/Loja.json");
        registrador.write(DadosLoja);
        registrador.close(); 
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void alterarProduto() {
		checarLoja(); 
		System.out.println("Digite o nome do produto a ser alterado: ");
		String nome = scan.nextLine(); 
		System.out.println("O que alterar?\r\n1 - Nome\r\n2 - Preco\r\n3 - Descricao\r\n4 - Estoque");
		int opcao = scan.nextInt(); 
		JSONArray jsonArray = new JSONArray(); 
		switch(opcao) {
		case 1:
			try {
	        	String LojaJson = new String(Files.readAllBytes(Paths.get("./src/registro/Loja.json")));
	            if (LojaJson.trim().isEmpty()) {
	                jsonArray = new JSONArray();
	            } else {
	                jsonArray = new JSONArray(LojaJson);
	            } 
			} catch (Exception e)
			{
				System.out.println(e);
			}
			for(int i = 0; i < jsonArray.length(); i++) {
				if(jsonArray.getJSONObject(i).getString("nome").equals(nome)) {
					System.out.println("Digite o novo nome:");
					String novoNome = scan.nextLine(); 
					jsonArray.getJSONObject(i).put("name", novoNome);
				}
			}
			break;
		case 2:
			try {
	        	String LojaJson = new String(Files.readAllBytes(Paths.get("./src/registro/Loja.json")));
	            if (LojaJson.trim().isEmpty()) {
	                jsonArray = new JSONArray();
	            } else {
	                jsonArray = new JSONArray(LojaJson);
	            } 
			} catch (Exception e)
			{
				System.out.println(e);
			}
			for(int i = 0; i < jsonArray.length(); i++) {
				if(jsonArray.getJSONObject(i).getString("nome").equals(nome)) {
					System.out.println("Digite o novo preco:");
					double novoPreco = scan.nextDouble(); 
					jsonArray.getJSONObject(i).put("preco", novoPreco);
				}
			}
			break; 
		case 3:
			try {
	        	String LojaJson = new String(Files.readAllBytes(Paths.get("./src/registro/Loja.json")));
	            if (LojaJson.trim().isEmpty()) {
	                jsonArray = new JSONArray();
	            } else {
	                jsonArray = new JSONArray(LojaJson);
	            } 
			} catch (Exception e)
			{
				System.out.println(e);
			}
			for(int i = 0; i < jsonArray.length(); i++) {
				if(jsonArray.getJSONObject(i).getString("nome").equals(nome)) {
					System.out.println("Digite a nova descricao:");
					String novaDescricao = scan.nextLine(); 
					jsonArray.getJSONObject(i).put("descricao", novaDescricao);
				}
			}
			break; 
		case 4:
			try {
	        	String LojaJson = new String(Files.readAllBytes(Paths.get("./src/registro/Loja.json")));
	            if (LojaJson.trim().isEmpty()) {
	                jsonArray = new JSONArray();
	            } else {
	                jsonArray = new JSONArray(LojaJson);
	            } 
			} catch (Exception e)
			{
				System.out.println(e);
			}
			for(int i = 0; i < jsonArray.length(); i++) {
				if(jsonArray.getJSONObject(i).getString("nome").equals(nome)) {
					System.out.println("Digite o estoque atual:");
					int estoqueAtual = scan.nextInt(); 
					jsonArray.getJSONObject(i).put("estoque", estoqueAtual);
				}
			}
			break; 
		}
	}
	
	public static void Comprar() {
		checarLoja(); 
		JSONArray jsonArray = new JSONArray(); 
		boolean comprando = true; 
		try {
        	String LojaJson = new String(Files.readAllBytes(Paths.get("./src/registro/Loja.json")));
            if (LojaJson.trim().isEmpty()) {
                jsonArray = new JSONArray();
            } else {
                jsonArray = new JSONArray(LojaJson);
            } 
		} catch (Exception e)
		{
			System.out.println(e);
		}
		
		Carrinho carrinho = new Carrinho();
		
		while(comprando){
			try {
				scan.nextLine();
				System.out.println("Escolha um produto: ");
				String nome = scan.nextLine();
				System.out.println("Escolha uma quantidade: ");
				int quantidade = scan.nextInt();
				scan.nextLine();
				for(int i = 0; i < jsonArray.length(); i++) {
					if(jsonArray.getJSONObject(i).getString("nome").equals(nome)) {
						for(int j = 0; j < quantidade; j++) {
							carrinho.produtos.add(new Produto(jsonArray.getJSONObject(i).getString("nome"),jsonArray.getJSONObject(i).getDouble("preco"), jsonArray.getJSONObject(i).getString("descricao"), jsonArray.getJSONObject(i).getInt("estoque")));	
							}
						}
					}
				for(int i = 0; i < carrinho.produtos.size(); i++) {
					System.out.println(carrinho.produtos.get(i).name);
				}
				double total = carrinho.precoTotal();
				System.out.println("Total:" + total +"\r\n");
				System.out.println("Continuar comprando?\r\n1- Continuar\r\n2 - Finalizar compra");
				int opcao = scan.nextInt();
				scan.nextLine();
				if (opcao != 1) {
					LancarCompra(carrinho);
					carrinho.total = 0.0;
					break;  
					} 
				}catch ( java.util.InputMismatchException e){
					System.out.println("Apenas números em preço ou quantidade.");
					Comprar();
			}
		}
	}
	
	public static void LancarCompra(Carrinho carrinho) {
		JSONArray jsonArray = new JSONArray(); 
		try {
        	String ComprasJson = new String(Files.readAllBytes(Paths.get("./src/registro/Compras.json")));
            if (ComprasJson.trim().isEmpty()) {
                jsonArray = new JSONArray();
            } else {
                jsonArray = new JSONArray(ComprasJson);
            } 
            JSONObject json = new JSONObject(); 
            json.put("Lista", convertProdutosToJsonArray(carrinho.produtos));
            json.put("Total", carrinho.precoTotal());
            json.put("Data", LocalDate.now());
            json.put("Cliente", classes.controllers.Login.getUser());
            jsonArray.put(json); 
            
            String DadosCompra = jsonArray.toString(); 

            FileWriter registrador = new FileWriter("./src/registro/Compras.json");
            registrador.write(DadosCompra);
            registrador.close(); 
            
		} catch (Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	public static void ChecarCompras() {
		JSONArray jsonArray = new JSONArray(); 
		try {
        	String ComprasJson = new String(Files.readAllBytes(Paths.get("./src/registro/Compras.json")));
            if (ComprasJson.trim().isEmpty()) {
                jsonArray = new JSONArray();
            } else {
                jsonArray = new JSONArray(ComprasJson);
            }
       for(int i = 0; i < jsonArray.length(); i++) {
    	   System.out.println("Compras: " + jsonArray.getJSONObject(i).getJSONArray("Lista") + "\r\nTotal: " + jsonArray.getJSONObject(i).getInt("Total") + "\r\nCliente: " + jsonArray.getJSONObject(i).getString("Cliente") + "\r\nData: " + jsonArray.getJSONObject(i).getString("Data"));
    	   System.out.println("\r\n----------------------\r\n");
       }
	} catch(Exception e) {
		System.out.println(e);
		}
	}
	
    private static JSONArray convertProdutosToJsonArray(List<Produto> produtos) {
        JSONArray jsonArray = new JSONArray();
        for (Produto produto : produtos) {
            JSONObject produtoJson = new JSONObject();
            produtoJson.put("Nome", produto.name);
            produtoJson.put("Preco", produto.preco);
            produtoJson.put("Descricao", produto.descricao);
            jsonArray.put(produtoJson);
        }
        return jsonArray;
    }
}

