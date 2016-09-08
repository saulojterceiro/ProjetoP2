package Quarto;

public class Presidencial implements Quarto{
	private double diaria = 450;
	private String id;
	
	public Presidencial(String id){
		this.id = id;
	}
	
	public double getDiaria(){
		return diaria;
	}
	
	public String getId(){
		return id;
	}
}
