package lojadesapato;
import java.util.*;

public class Endereco {
	private int cEP;
	private String bairro;
	private int numero;
	private String cidade;
	private String estado;
	
	public Endereco(int _cep, String b, int n, String c, String e) {
		cEP = _cep;
		bairro = b;
		numero = n;
		cidade = c;
		estado = e;
	}
	
	// PRECISA DOS CRUDs
	
	public int getcEP() {
		return cEP;
	}
	public void setcEP(int cEP) {
		this.cEP = cEP;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
