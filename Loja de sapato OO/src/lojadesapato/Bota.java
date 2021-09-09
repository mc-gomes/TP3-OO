package lojadesapato;

public class Bota extends Sapato{
	private boolean cano;
	private String genero;
	
	public Bota(String m, double p, int q, String c, String g, boolean ca) {
		this.marca = m;
		this.preco = p;
		this.quantidade = q;
		this.cor = c;
		genero = g;
		cano = ca; // trocar só pra "cano'?
	}
	
	// PRECISA DOS CRUDs
	
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

	public String getGenero() {

		return genero;
	}
	public void setTipo(String genero) {
		this.genero = genero;
	}
	
	public boolean isCano() {
		return cano;
	}
	public void setCano(boolean cano) {
		this.cano = cano;
	}
	
}

,