package lojadesapato;

public class Venda {
	private double valorDaVenda;
	private Cliente cliente;
	private Sapato produto;
	
	public Venda(double v, Cliente c, Sapato s) {
		valorDaVenda = v;
		cliente = c;
		produto = s;
	}
	
	
	//PRECISA TER OS CRUDs
	

	public double getValorDaVenda() {
		return valorDaVenda;
	}

	public void setValorDaVenda(double valorDaVenda) {
		this.valorDaVenda = valorDaVenda;
	}

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Sapato getProduto() {
		return produto;
	}
	public void setProduto(Sapato produto) {
		this.produto = produto;
	}
	
}
