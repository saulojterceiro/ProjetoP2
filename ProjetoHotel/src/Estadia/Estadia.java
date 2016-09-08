package Estadia;
import Quarto.Quarto;

public class Estadia {
	
	private Quarto quarto;
	private int dias;
	
	public Estadia(Quarto quarto, int dias){
		this.dias = dias;
		this.quarto = quarto;
	}
	
	public double getPrecoEstadia(){
		return dias*quarto.getDiaria();
	}

	public Quarto getTipoDeQuarto(){
		return quarto;
	}
	

	
}
