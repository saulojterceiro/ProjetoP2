package Controller;

import java.util.ArrayList;

import Hospede.Hospede;
import Hotel.Hotel;
import Pratos.Prato;
import Factory.Factory;

public class Controller {

	private Factory fac;
	private ArrayList<Hospede> hospedes;
	private Hotel hotel;
	
	
	
	public String cadastraHospede(String nome,String email, String ano)throws Exception{
		hospedes.add(fac.cadastraHospede(nome, email, ano));
		return hospedes.get(hospedes.size()-1).getEmail();
	}
	
	public Hospede procuraHospedeEmail(String email)throws Exception{
		for (int i = 0; i < hospedes.size(); i++){
			if (hospedes.get(i).getEmail() == email){
				return hospedes.get(i);
			}
		}throw new Exception("Erro na consulta de hospede. Hospede de email "+email+" nao foi cadastrado(a).");
	}
	
	public void atualizaCadastro(String email,String atributo,String valor)throws Exception{
		for (int i = 0; i < hospedes.size(); i++){
			if (hospedes.get(i).getEmail() == email){
				if(atributo == "nome"){
					if (valor.equals("")){
						throw new Exception("Erro na atualizacao do cadastro de Hospede. Nome do(a) hospede nao pode ser vazio.");
					}
					hospedes.get(i).setAno(valor);
				}else if (atributo == "Data de Nascimento"){
					if (valor.equals("")){
						throw new Exception("Erro na atualizacao do cadastro de Hospede. Data de Nascimento do(a) hospede nao pode ser vazio.");
					}if (valor.equals("")){
						throw new Exception("Erro na atualizacao do cadastro de Hospede. A idade do(a) hospede deve ser maior que 18 anos.");
					}
					hospedes.get(i).setNome(valor);
				}else{
					if (valor.equals("")){
						throw new Exception("Erro na atualizacao do cadastro de Hospede. Email do(a) hospede nao pode ser vazio.");
					}
					hospedes.get(i).setEmail(valor);
				}
			}
		}
	}
	
	public void removeHospede(String email){
		for (int i = 0; i < hospedes.size(); i++){
			if (hospedes.get(i).getEmail() == email){
				hospedes.remove(i);
			}
		}
	}
	
	public boolean checkinHospedeCadastrado(String email,int dias,String numQuarto,String tipoQuarto)throws Exception{
			return hotel.checkin(this.procuraHospedeEmail(email), dias, numQuarto,tipoQuarto);
	}

	public String getInfoHospedagem(String email,String info)throws Exception{
		if (info.equals("Hospedagens ativas")){
			if ( this.procuraHospedeEmail(email).getNumEstadias()==0){
				return "Erro na consulta de hospedagem. Hospede "+this.procuraHospedeEmail(email).getNome()+" nao esta hospedado(a).";
			}else{
				String str =""+ this.procuraHospedeEmail(email).getNumEstadias();
				return str;
			}
		}else if (info.equals("Quarto")){
			return this.procuraHospedeEmail(email).getQuartos();
		}else if(info.equals("Total")){
			String str = "R$";
			str = str +this.procuraHospedeEmail(email).getEstadiasGasto();
			return str;
		}else{

			return "EXCEPTION N�O TEM ESSE ATRIBUTO";
		}
	}

	public String getInfoHospede(String email,String atributo)throws Exception{
		Hospede novo = this.procuraHospedeEmail(email);
		if (atributo == "nome"){
			return novo.getNome();
		}else{
			return novo.getAno();
		}
	}
	
	public double realizaCheckout(String email,String numQuarto)throws Exception{
		return hotel.checkoutHospede(email,numQuarto);
	}

	public String consultaTransacoes(String atributo){
		String str = "";
		if(atributo.equals("Quantidade")){
			return str = str+hotel.getNumHospedagens();
		}else if(atributo.equals("Total")){
			return str = str+hotel.getTotalLucro();
		}else if(atributo.equals("Nome")){
			return hotel.getNomesHospedes();
		}else{
			return "n�o existe tal atributo";
		}
	}
	
	public String consultaTransacoes(String atributo, int indice){
		String str = "";
		if(atributo.equals("Nome")){
			return str = str+hotel.getNomeIndice(indice);
		}else if(atributo.equals("Total")){
			return str = str+hotel.getTotal(indice);
		}else{
			return "n�o existe tal atributo";
		}
	}

	public void cadastraPrato(String nome,double preco, String descricao){
		hotel.cadastraPrato(nome, preco, descricao);
	}
	
	public void cadastraRefeicao(String nome, double preco, String descricao,ArrayList<Prato> pratos){
		hotel.cadastraRefeicao(nome, preco, descricao,pratos);
	}
	
	public String consultaRestaurante(String prato,String atributo){
		String str = "";
		if(atributo.equals("Preco")){
			return str = str+hotel.getComidaPreco(prato);
		}else if(atributo.equals("Descricao")){
			return str = str+hotel.getComidaDescricao(prato);
		}else if(atributo.equals("Nome")){
			return hotel.getComidaNome(prato);
		}else{
			return "n�o existe tal atributo";
		}
	}
}
