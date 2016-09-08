package Checkouts;

import java.time.LocalDate;

public class Checkout {
	private LocalDate horario;
	private String nomeDoHospede;
	private double totalPago;
	
	public Checkout(String nomeDoHospede, double totalPago){
		this.horario = LocalDate.now();
	}
	
	public LocalDate getHorario(){
		return this.horario;
	}
	
	public String getNomeDoHospede(){
		return this.nomeDoHospede;
	}
	
	public double getTotalPago(){
		return totalPago;
	}
}
