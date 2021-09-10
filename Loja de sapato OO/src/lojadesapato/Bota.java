package lojadesapato;

import java.util.ArrayList;

public class Bota extends Sapato{
	private String cano;
	private String genero;
	
	public Bota(String m, double p, int q, String c, String g, String ca) {
		this.marca = m;
		this.preco = p;
		this.quantidade = q;
		this.cor = c;
		this.genero = g;
		this.cano = ca; // trocar só pra "cano'?
	}
	
	ArrayList<Bota> listaDeBota = new ArrayList<Bota>();
	
	@Override
	public String toString() {
		return "-Marca: " + marca + "\n-Preço R$ " + preco + "\nQuantidade em estoque: "
				+ quantidade + "\n-Altura do cano: " + cano + "\n-Gênero: " + genero;
	}

	public void visualizar(int modo) {
		if(modo == 1) {
			// mostrar faixa de preco
		}
		if(modo == 2) {
			// mostrar pela marca
		}
		int i;
		boolean encontrado = false;
				
		for(i=0; i<listaDeBota.size(); i++) {
			if(listaDeBota.get(i).getMarca() == marca) {
				System.out.println(listaDeBota.get(i).toString());
				//encontrado = true;
				//return vLivro.get(i);
			}
		}
//		int i;
//		System.out.println("Marca: " + botas.get(i).getMarca());
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
