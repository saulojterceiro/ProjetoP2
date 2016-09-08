package Hotel;
import java.util.ArrayList;
import Quarto.Quarto;
import Hospede.Hospede;
import Estadia.Estadia;
import Checkouts.Checkout;

public class Hotel {

	private ArrayList<Hospede> hospedes;
	private ArrayList<Checkout> checkouts;
	
	public Hospede procuraHospedeEmail(String email){
		for (int i = 0; i < hospedes.size(); i++){
			if (hospedes.get(i).getEmail() == email){
				return hospedes.get(i);
			}
		}
		System.out.println("Não existe hospede com esse email");
		return null;
	}
	
	public boolean checkin(Hospede hospede,int dias, Quarto tipoQuarto){
		Estadia estadia = new Estadia(tipoQuarto,dias);
		hospede.checkinEstadia(estadia);
		return true;
	}
	
	public boolean checkoutHospede(String email){
		Hospede hospede = this.procuraHospedeEmail(email);
		Checkout checkout = new Checkout(hospede.getNome(),hospede.getEstadiasLucro());
		checkouts.add(checkout);
		this.removeHospede(email);
		return true;
	}
	
	public boolean removeHospede(String email){
		for (int i = 0; i < hospedes.size(); i++){
			if (hospedes.get(i).getEmail() == email){
				hospedes.remove(i);
				return true;
			}
		}return false;
	}
		
	public double getTotalLucro(){
		double total = 0;
		for (int i = 0;i<checkouts.size();i++){
			total = total + checkouts.get(i).getTotalPago();
		}
		return total;
	}
}
