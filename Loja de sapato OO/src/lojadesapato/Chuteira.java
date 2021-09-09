package lojadesapato;
import java.util.*;

public class Chuteira extends Sapato{
	private String tipo;
	private boolean canoAlto;
	
	public Chuteira(String m, double p, int q, String c, String t, boolean ca) {
		marca = m;
		preco = p;
		quantidade = q;
		cor = c;
		tipo = t;
		canoAlto = ca;
	}
	
	public String toString() {
		return "";
	}
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public boolean isCanoAlto() {
		return canoAlto;
	}
	public void setCanoAlto(boolean canoAlto) {
		this.canoAlto = canoAlto;
	}
	
}
