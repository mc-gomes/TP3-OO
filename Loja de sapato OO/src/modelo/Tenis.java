package modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Tenis extends Sapato{
	private String tipo;

	public Tenis() {
		
	}
	
	public Tenis(String m, double p, int q, String c, String t){
		this.marca = m;
		this.preco = p;
		this.quantidade = q;
		this.cor = c;
		this.tipo = t;
	}
	
	@Override
	public String toString() {
		return "-Marca: " + marca + "\n-Preço R$ " + preco + "\n-Quantidade em estoque: "
				+ quantidade  + "\n-Cor: " + cor + "\n-Tipo do Tenis: " + tipo + "\n";
	}
	ArrayList<Tenis> listaDeTenis = new ArrayList<Tenis>();
	
	public void preCadastrosTenis(){

		Tenis tenis1 = new Tenis("Tenis Vans", 349.90, 50, "Preto","casual");
		Tenis tenis2 = new Tenis("Tenis Andrade Iate ", 69.90, 50, "Azul marinho","social");
		Tenis tenis3 = new Tenis("Tenis New Balance", 349.99, 50, "Rosa","esportivo");
		Tenis tenis4 = new Tenis("Tenis Nike", 229.99, 50, "Preto","esportivo");

		listaDeTenis.add(tenis1);
		listaDeTenis.add(tenis2);
		listaDeTenis.add(tenis3);
		listaDeTenis.add(tenis4);

	}
	
	
	public void cadastrar(Tenis tenis) {
		listaDeTenis.add(tenis);	
	}
	
	public void editar(int pos, String dado, int info) {
		
		if(info == 1) {
			listaDeTenis.get(pos).setMarca(dado);
		}
		else if(info == 2) {
			listaDeTenis.get(pos).setPreco(Double.parseDouble(dado));
		}
		else if(info == 3) {
			listaDeTenis.get(pos).setQuantidade(Integer.parseInt(dado));
		}
		else if(info == 4) {
			listaDeTenis.get(pos).setCor(dado);
		}
		else if(info == 5) {
			listaDeTenis.get(pos).setTipo(dado);
		}
		
	}
	
	public String retornaDado(int pos, int info) {
		String dado = "";
		
		if(info == 1) {
			dado = listaDeTenis.get(pos).getMarca();
		}
		else if(info == 2) {
			dado = String.valueOf(listaDeTenis.get(pos).getPreco());
		}
		else if(info == 3) {
			dado = String.valueOf(listaDeTenis.get(pos).getQuantidade());
		}
		else if(info == 4) {
			dado = listaDeTenis.get(pos).getCor();
		}
		else if(info == 5) {
			dado = String.valueOf(listaDeTenis.get(pos).getTipo());
		}
		
		return dado;
	}
	
	public void deletar(int n) {
		listaDeTenis.remove(listaDeTenis.get(n));
	}
	
	public String[] listaNomesSapatos() {
		String[] listaNomes = new String[200];
		for(int i=0; i< listaDeTenis.size(); i++) {
			listaNomes[i] = listaDeTenis.get(i).getMarca();
		}
		return listaNomes;
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

}
