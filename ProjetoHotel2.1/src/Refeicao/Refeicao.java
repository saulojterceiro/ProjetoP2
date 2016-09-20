package Refeicao;

import java.util.ArrayList;

import Comida.Comida;
import Pratos.Prato;

public class Refeicao extends Comida{
	private ArrayList<Prato> pratos;
	
	public Refeicao(String nome, double preco, String descricao,ArrayList<Prato> pratos ) {
		super(nome, preco, descricao);
		this.pratos = pratos;
		preco = this.getPreco();
	}

	
	public boolean adicionarPrato(Prato prato){
		pratos.add(prato);
		return true;
	}
	
	public double calculaPreco(){
		double total = 0;
		for (int i = 0; i < pratos.size();i++){
			total = total + pratos.get(i).getPreco();
		}
		return total;
	}
}
