package lojadesapato;

public class Chinelo extends Sapato{
	private String estilo;
	
	public Chinelo(String m, double p, int q, String c, String e) {
		marca = m;
		preco = p;
		quantidade = q;
		cor = c;
		estilo = e;
	}

	// PRECISA DOS CRUDs
	
	public String getEstilo() {
		return estilo;
	}
	public void setEstilo(String estilo) {
		this.estilo = estilo;
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
	
}
