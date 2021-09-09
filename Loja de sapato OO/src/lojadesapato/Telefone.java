package lojadesapato;
import java.util.*;

public class Telefone {

	private String dDD;
	private String numero;
	
	public Telefone(String cod, String num) {
		dDD = cod;
		numero = num;
	}
	
	@Override
	public String toString() {
		return "Telefone: (" + dDD + ") " + numero;
	}
	
	public String getdDD() {
		return dDD;
	}
	public void setdDD(String dDD) {
		this.dDD = dDD;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
}
