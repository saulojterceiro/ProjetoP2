package Hotel;
import java.util.ArrayList;
import Comida.Comida;
import Quarto.Quarto;
import Hospede.Hospede;
import Pratos.Prato;
import Estadia.Estadia;
import Checkouts.Checkout;
import Restaurante.Restaurante;

public class Hotel {
	
	private String nome;
	private Restaurante restauranteHotel = new Restaurante();
	private ArrayList<Hospede> hospedes;
	private ArrayList<Checkout> checkouts;
	
	public Hotel(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public Hospede procuraHospedeEmail(String email){
		for (int i = 0; i < hospedes.size(); i++){
			if (hospedes.get(i).getEmail() == email){
				return hospedes.get(i);
			}
		}
		System.out.println("Nao existe hospede com esse email");
		return null;
	}
	
	public boolean checkin(Hospede hospede,int dias,String quartoNum, String quartoStr){
		Quarto quarto = new Quarto(quartoNum);
		Estadia estadia = new Estadia(quarto.defineQuarto(quartoStr, quartoNum),dias);
		hospede.checkinEstadia(estadia);
		return true;
	}
	
	public double checkoutHospede(String email,String numQuarto){
		Hospede hospede = this.procuraHospedeEmail(email);
		Checkout checkout = new Checkout(hospede.getNome(),hospede.getEstadiaQuarto(numQuarto));
		checkouts.add(checkout);
		hospede.adicionaGasto(checkout.getPago());
		hospede.removeEstadia(numQuarto);
		if (hospede.getNumEstadias()<=0){
			hospedes.remove(hospede);
		}
		return checkout.getPago();
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
			total = total + checkouts.get(i).getPago();
		}
		return total;
	}

	
	public int getNumHospedagens(){
		return this.checkouts.size();
	}
	
	public String getNomesHospedes(){
		String str = "";
		for (int i = 0;i<checkouts.size();i++){
			str = str + checkouts.get(i).getNomeDoHospede();
		}return str;
	}

	public String getComidaNome(String nome){
		return this.restauranteHotel.getComidaNome(nome);
	}
	
	public String getComidaDescricao(String nome){
		return this.restauranteHotel.getComidaDescricao(nome);
	}
	
	public double getComidaPreco(String nome){
		return this.restauranteHotel.getComidaPreco(nome);
	}
	
	public void cadastraPrato(String nome,Double preco,String descricao){
		this.restauranteHotel.cadastraPrato(nome,preco,descricao);
	}
	
	public String getNomeIndice(int indice){
		return this.hospedes.get(indice).getNome();
	}
	
	public double getTotal(int indice){
		return this.hospedes.get(indice).getEstadiasGasto();
	}
	
	public void cadastraRefeicao(String nome, double preco, String descricao,ArrayList<Prato> pratos){
		this.restauranteHotel.cadastraRefeicao(nome, preco, descricao,pratos);
	}
}
