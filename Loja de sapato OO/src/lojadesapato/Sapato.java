package lojadesapato;

public abstract class Sapato {
	protected String marca;
	protected double preco;
	protected int quantidade;
	protected String cor;
	
	public void cadastrar() {
		
	}
	public void editar() {
		
	}
	public void visualizar() {
		
	}
	public void deletar() {
		
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