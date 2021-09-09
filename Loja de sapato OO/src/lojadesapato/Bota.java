package lojadesapato;

public class Bota extends Sapato{
	private boolean canoAlto;
	private String genero;
	
	public Bota(String m, double p, int q, String c, String g, boolean ca) {
		marca = m;
		preco = p;
		quantidade = q;
		cor = c;
		genero = g;
		canoAlto = ca; // trocar só pra "cano'?
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
	
	public boolean isCanoAlto() {
		return canoAlto;
	}
	public void setCanoAlto(boolean canoAlto) {
		this.canoAlto = canoAlto;
	}
	
}
