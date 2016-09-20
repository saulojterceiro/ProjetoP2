package Quarto;

public class Quarto {
	private double diaria;
	private String id;
	
	public Quarto(String id){
		this.id = id;
	}
	
	public double getDiaria(){
		return diaria;
	}
	
	public String getId(){
		return id;
	}
	
	public void setDiaria(double diaria){
		this.diaria = diaria;
	}
	
	public Quarto defineQuarto(String quartoStr,String numero){
		if (quartoStr.equals("presidencial")){
			Quarto quarto = new Presidencial(numero);
			return quarto;
		}else if(quartoStr.equals("luxo")){
			Quarto quarto = new Luxo(numero);
			return quarto;
		}else{
			Quarto quarto = new Simples(numero);
			return quarto;
		}
	}
}
