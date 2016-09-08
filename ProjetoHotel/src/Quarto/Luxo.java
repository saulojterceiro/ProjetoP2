package Quarto;

public class Luxo implements Quarto{
	private double DIARIA = 250;
	private String id;
	
	public Luxo(String id){
		this.id = id;
	}
	
	public double getDiaria(){
		return DIARIA;
	}
	
	public String getId(){
		return id;
	}
}
