package Quarto;

public class Simples implements Quarto{
	private double DIARIA = 100;
	private String id;
	
	public Simples(String id){
		this.id = id;
	}
	
	public double getDiaria(){
		return DIARIA;
	}
	
	public String getId(){
		return id;
	}
}
