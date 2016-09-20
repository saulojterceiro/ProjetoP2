package Checkouts;

import java.time.LocalDate;

import Estadia.Estadia;

public class Checkout {
	private LocalDate horario;
	private String nomeDoHospede;
	private Estadia estadia;
	
	public Checkout(String nomeDoHospede,Estadia estadia){
		this.horario = LocalDate.now();
		this.estadia = estadia;
		this.nomeDoHospede = nomeDoHospede;
	}
	
	public LocalDate getHorario(){
		return this.horario;
	}
	
	public String getNomeDoHospede(){
		return this.nomeDoHospede;
	}
	
	public double getPago(){
		return estadia.getPrecoEstadia();
	}
	

}
