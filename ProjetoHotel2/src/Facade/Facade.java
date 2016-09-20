package Facade;
import java.util.ArrayList;

import Controller.Controller;
import Hospede.Hospede;
import Quarto.Quarto;
import easyaccept.EasyAccept;
import Hotel.Hotel;
import Pratos.Prato;

public class Facade {
	Controller con;
	ArrayList<Hospede> hospedes;

	public static void main(String[] args) {
		args = new String[] { "Facade.Facade", "acceptance_test/testes_uc1.txt", "EasyAccept/testes_uc2.txt","EasyAccept/testes_uc3.txt", "EasyAccept/testes_uc4.txt","EasyAccept/testes_uc4_exception.txt" };
		EasyAccept.main(args);
 
	}
	
	public String cadastraHospede(String nome,String email,String ano){
		return con.cadastraHospede(nome, email, ano);
	}
	
	public boolean realizaCheckin(String email,int dias,String numQuarto,String tipoQuarto){
		return con.checkinHospedeCadastrado(email, dias, numQuarto, tipoQuarto);
	}
	
	public String getInfoHospede(String email,String atributo){
		Hospede novo = con.procuraHospedeEmail(email);
		if (atributo == "nome"){
			return novo.getNome();
		}else{
			return novo.getAno();
		}
	}
	
	public void atualizaCadastro(String email, String atributo, String valor){
		con.atualizaCadastro(email, atributo, valor);
	}
	
	public void removeHospede(String email){
		con.removeHospede(email);
	}
	
	public boolean checkinHospedeCadastrado(String email,int dias,String numQuarto,String tipoQuarto){
		return con.checkinHospedeCadastrado(email, dias, numQuarto, tipoQuarto);
	}
	
	public double realizaCheckout(String email,String numQuarto){
		return con.realizaCheckout(email, numQuarto);
	}
	
	public String consultaTransacoes(String atributo){
		return con.consultaTransacoes(atributo);
	}
	
	public String consultaTransacoes(String atributo, int indice){
		return con.consultaTransacoes(atributo, indice);
	}
	
	public void cadastraPrato(String nome,double preco, String descricao){
		con.cadastraPrato(nome, preco, descricao);
	}
	
	public void cadastraRefeicao(String nome, double preco, String descricao,ArrayList<Prato> pratos){
		con.cadastraRefeicao(nome, preco, descricao,pratos);
	}
	
	public String consultaRestaurante(String prato,String atributo){
		return con.consultaRestaurante(prato, atributo);
	}
	
}
