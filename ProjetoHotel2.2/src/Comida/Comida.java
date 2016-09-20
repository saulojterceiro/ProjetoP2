package Comida;

public class Comida {
	private String nome;
	private double preco;
	private String descricao;
	
	public Comida(String nome, double preco, String descricao){
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
	}

	public String getNome(){
		return this.nome;
	}
	
	public double getPreco(){
		return this.preco;
	}
	
	public String getDescricao(){
		return this.descricao;
	}
}


