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
	private ArrayList<String> quartosOcupados;
	
	
	public String cadastraHospede(String nome,String email, String ano){
		hospedes.add(fac.cadastraHospede(nome, email, ano));
		return hospedes.get(hospedes.size()-1).getEmail();
	}
	
	public boolean checaQuarto(String quartoId){
		for (int i = 0; i < quartosOcupados.size();i++){
			if (quartoId.equals(quartosOcupados.get(i))){
				return false;
			}
		}
		return true;
	}
	
	public Hospede procuraHospedeEmail(String email){
		for (int i = 0; i < hospedes.size(); i++){
			if (hospedes.get(i).getEmail() == email){
				return hospedes.get(i);
			}
		}
		System.out.println("Erro na consulta de hospede. Hospede de email robyn@sverige.se nao foi cadastrado(a).");
		return null;
	}
	
	public void atualizaCadastro(String email,String atributo,String valor){
		for (int i = 0; i < hospedes.size(); i++){
			if (hospedes.get(i).getEmail() == email){
				if(atributo == "nome"){
					hospedes.get(i).setAno(valor);
				}else if (atributo == "Data de Nascimento"){
					hospedes.get(i).setNome(valor);
				}else{
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
	
	public boolean checkinHospedeCadastrado(String email,int dias,String numQuarto,String tipoQuarto){
		if (this.checaQuarto(numQuarto)){
			return false;
		}else{
			this.quartosOcupados.add(numQuarto);
			return hotel.checkin(this.procuraHospedeEmail(email), dias, numQuarto,tipoQuarto);
		}
	}

	public String getInfoHospede(String email,String info){
		if (info.equals("Hospedagens ativas")){
			if ( this.procuraHospedeEmail(email).getNumEstadias()==0){
				return "";
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

			return "EXCEPTION NÃO TEM ESSE ATRIBUTO";
		}
	}
	
	public double realizaCheckout(String email,String numQuarto){
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
			return "não existe tal atributo";
		}
	}
	
	public String consultaTransacoes(String atributo, int indice){
		String str = "";
		if(atributo.equals("Nome")){
			return str = str+hotel.getNomeIndice(indice);
		}else if(atributo.equals("Total")){
			return str = str+hotel.getTotal(indice);
		}else{
			return "não existe tal atributo";
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
			return "não existe tal atributo";
		}
	}
}
