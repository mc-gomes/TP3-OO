package lojadesapato;

public class Chuteira extends Sapato{
	private String nome;
	private String tipo;
	private boolean canoAlto;
	
	// quais vairáveis colocar exatamente?
	public Chuteira(String m, double p, int q, String c, String t, boolean ca) {
		this.marca = m;
		this.preco = p;
		this.quantidade = q;
		this.cor = c;
		tipo = t;
		canoAlto = ca; // precisa disso?
	}

	// PRECISA DOS CRUDs
	
	public String toString() {
		return "Nome do produto: " + nome + "\nMarca: " + marca +
				"\nTipo: " + tipo + "\nCor: " + cor + "\nPreço R$ " +
				preco + "\nQuantidade em estoque: " + quantidade;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
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
