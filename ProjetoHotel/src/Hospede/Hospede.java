package Hospede;
import java.util.ArrayList;

import Estadia.Estadia;

public class Hospede {
	
	private String email;
	private String nome;
	private String ano;

	ArrayList<Estadia> estadias;
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public void setAno(String ano){
		this.ano = ano;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public String getAno(){
		return this.ano;
	}
	
	public boolean checkinEstadia(Estadia estadia){
		this.estadias.add(estadia);
		return true;
	}
	
	public double getEstadiasLucro(){
		double lucro = 0;
		for (int i = 0; i<estadias.size();i++){
			lucro = lucro + estadias.get(i).getPrecoEstadia();
		}
		return lucro;
	}
	
	public String getNome(){
		return this.nome;
	}
	
}
