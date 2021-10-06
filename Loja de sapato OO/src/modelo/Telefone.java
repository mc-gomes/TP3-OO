package modelo;

public class Telefone {

	private int DDD;
	private int numero;
	
	public Telefone() {
		
	}
	
	public Telefone(int cod, int num) {
		DDD = cod;
		numero = num;
	}
	
	@Override
	public String toString() {
		return "(" + DDD + ") " + numero;
	}
	
	public int getdDD() {
		return DDD;
	}
	public void setdDD(int dDD) {
		this.DDD = dDD;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
}
