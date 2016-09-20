package Hospede;
import java.util.ArrayList;

import Estadia.Estadia;

public class Hospede {
	
	private String email;
	private String nome;
	private String ano;
	private double gasto;//fidelidade
	ArrayList<Estadia> estadias;
	
	public Hospede(String email,String nome,String ano){
		this.email = email;
		this.nome = nome;
		this.ano = ano;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public void setAno(String ano){
		this.ano = ano;
	}
	
	public void setNome(String nome){
		this.nome = nome;
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
	
	public double getEstadiasGasto(){
		double lucro = 0;
		for (int i = 0; i<estadias.size();i++){
			lucro = lucro + estadias.get(i).getPrecoEstadia();
		}
		return lucro;
	}
	
	public Estadia getEstadiaQuarto(String numQuarto){
		for (int i = 0; i < estadias.size();i++){
			if (estadias.get(i).getId().equals(numQuarto)){
				return estadias.get(i);
			}
		}return null;
		
	}
	
	public void removeEstadia(String numQuarto){
		for (int i = 0; i < estadias.size();i++){
			if (estadias.get(i).getId().equals(numQuarto)){
				estadias.remove(i);
			}
		}
		
	}
	
	public void adicionaGasto(double gasto){
		this.gasto = this.gasto + gasto;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public int getNumEstadias(){
		return this.estadias.size();
	}
	
	public String getQuartos(){
		String str = "";
		for (int i = 0;i<estadias.size();i++){
			str = str + estadias.get(i).getId();
		}
		return str;
	}
	
}
