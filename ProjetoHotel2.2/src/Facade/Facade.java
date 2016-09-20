package Facade;
import java.util.ArrayList;

import Controller.Controller;
import Hospede.Hospede;
import easyaccept.EasyAccept;
import Pratos.Prato;

public class Facade {
	Controller con;
	ArrayList<Hospede> hospedes;

	public static void main(String[] args) {
		args = new String[] {"Facade.Facade","EasyAccept/testes_uc1.txt"};
		EasyAccept.main(args);
	}
	
	public String cadastraHospede(String nome,String email,String ano)throws Exception{
		return con.cadastraHospede(nome, email, ano);
	}
	
	public boolean realizaCheckin(String email,int dias,String numQuarto,String tipoQuarto)throws Exception{
		return con.checkinHospedeCadastrado(email, dias, numQuarto, tipoQuarto);
	}
	
	public String getInfoHospede(String email,String atributo)throws Exception{
		return con.getInfoHospede(email, atributo);
	}
	
	public String getInfoHospedagem(String email,String atributo)throws Exception{
		return this.con.getInfoHospedagem(email, atributo);
	}
	
	public void atualizaCadastro(String email, String atributo, String valor)throws Exception{
		con.atualizaCadastro(email, atributo, valor);
	}
	
	public void removeHospede(String email){
		con.removeHospede(email);
	}
	
	public boolean checkinHospedeCadastrado(String email,int dias,String numQuarto,String tipoQuarto)throws Exception{
		return con.checkinHospedeCadastrado(email, dias, numQuarto, tipoQuarto);
	}
	
	public double realizaCheckout(String email,String numQuarto)throws Exception{
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
