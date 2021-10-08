package modelo;


/**
 * Classe mãe abstrata que serve de modelo para as classes
 * concretas que herdam dela, que são: Bota, Chinelo,
 * Chuteira, Salto e Tênis.
 * @author Matheus Costa e Laura Pinos
 *
 */
public abstract class Sapato {
	protected String marca;
	protected double preco;
	protected int quantidade;
	protected String cor;
	
	/**
	 * Método que será sobrescrito pelas instâncias concretas
	 * de objetos que herdam da classe Sapato
	 */
	public void cadastrar() {
		
	}
	
	/**
	 * Método que será sobrescrito pelas instâncias concretas
	 * de objetos que herdam da classe Sapato
	 */
	public void editar() {
		
	}
	
	/**
	 * @deprecated
	 */
	public void visualizar() {
		
	}
	
	/**
	 * Método que será sobrescrito pelas instâncias concretas
	 * de objetos que herdam da classe Sapato
	 */
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