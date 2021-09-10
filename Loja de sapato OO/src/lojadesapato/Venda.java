package lojadesapato;

import java.util.ArrayList;
import java.util.Scanner;

public class Venda {
	private Cliente cliente;
	private Sapato produto;
	private double valorDaVenda;
	
	public Venda(Cliente c, Sapato s, double v){
		this.cliente = c;
		this.produto = s;
		this.valorDaVenda = v;
	}
	
	
	//PRECISA TER OS CRUDs
	ArrayList<Venda> vendas = new ArrayList<Venda>();
	
	public void cadastrarVenda(Cliente client, Sapato produt, int qtd){
//		Scanner ler = new Scanner(System.in);
//		
//		String nomeCliente = client.getNome();
		
		double valor = produt.getPreco() * qtd;
		
		Venda novaVenda = new Venda(client, produt, valor);
		vendas.add(novaVenda);
	}
	
	public void editarVenda() {
		Scanner ler = new Scanner(System.in);
		// mostra lista de clientes
		for(int i=0; i< vendas.size(); i++) {
			System.out.printf("%d- %s\n", (i+1), vendas.get(i).getCliente().getNome());
		}
		System.out.print("Escolha o cliente: ");
		int pos = ler.nextInt();
		
		String nomeCliente = vendas.get(pos-1).getCliente().getNome();
		
		
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
	public double getValorDaVenda() {
		return valorDaVenda;
	}
	
	public void setValorDaVenda(double valorDaVenda) {
		this.valorDaVenda = valorDaVenda;
	}
	
}
