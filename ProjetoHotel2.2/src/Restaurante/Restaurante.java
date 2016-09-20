	package Restaurante;

import java.util.ArrayList;

import Comida.Comida;
import Pratos.Prato;
import Refeicao.Refeicao;

public class Restaurante {

	private ArrayList<Comida> comidas;
	
	public boolean adicionarComida(Comida comida){
		this.comidas.add(comida);
		return true;
	}
	
	public boolean removerComida (Comida comida){
		if (comidas.contains(comida)){
			comidas.remove(comida);
			return true;
		}else{
			System.out.println("Não existe tal prato no cardapio");
			return false;
		}
	}
	
	public Comida procuraComida(String nome){
		for (int i = 0;i < comidas.size();i++){
			if (comidas.get(i).getNome().equals(nome)){
				return comidas.get(i);
			}
		}return null;
	}
	
	public String getComidaDescricao(String nome){
		return this.procuraComida(nome).getDescricao();
	}
	
	public String getComidaNome(String nome){
		return this.procuraComida(nome).getNome();
	}
	
	public double getComidaPreco(String nome){
		return this.procuraComida(nome).getPreco();
	}
	
	public void cadastraPrato(String nome,double preco,String descricao){
		Prato prato = new Prato(nome,preco,descricao);
		this.comidas.add(prato);
	}
	
	public void cadastraRefeicao(String nome, double preco, String descricao,ArrayList<Prato> pratos){
		Refeicao refeicao = new Refeicao(nome, preco, descricao,pratos);
		this.comidas.add(refeicao);
	}
}
