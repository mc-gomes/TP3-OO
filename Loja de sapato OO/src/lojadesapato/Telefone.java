package lojadesapato;

public class Telefone {

	private String DDD;
	private String numero;
	
	public Telefone() {
		
	}
	
	public Telefone(String cod, String num) {
		DDD = cod;
		numero = num;
	}
	
	
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
