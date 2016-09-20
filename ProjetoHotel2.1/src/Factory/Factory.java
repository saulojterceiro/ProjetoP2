package Factory;
import Hospede.Hospede;
public class Factory {
	
	public Hospede cadastraHospede(String nome,String email,String ano)throws Exception{
		return new Hospede(nome,email,ano);
	}

}
