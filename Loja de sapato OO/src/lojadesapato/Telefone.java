package lojadesapato;
import java.util.*;

public class Telefone {

	private String DDD;
	private String numero;
	
	public Telefone(String cod, String num) {
		this.DDD = cod;
		this.numero = num;
	}
	
	// PRECISA DOS CRUDs
	
	@Override
	public String toString() {
		return "Telefone: (" + DDD + ") " + numero;
	}
	
	public String getdDD() {
		return DDD;
	}
	public void setdDD(String dDD) {
		this.DDD = dDD;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
}
