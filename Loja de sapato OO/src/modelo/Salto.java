package modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Salto extends Sapato{
	private int tamDoSalto;
	private String tipoDoSalto;

	public Salto() {
		
	}
	
	public Salto(String m, double p, int q, String c, int tam, String tipo){
		this.marca = m;
		this.preco = p;
		this.quantidade = q;
		this.cor = c;
		this.tamDoSalto = tam;
		this.tipoDoSalto = tipo;
	}
	
	@Override
	public String toString() {
		return "-Marca: " + marca + "\n-Preço R$ " + preco + "\n-Quantidade em estoque: "
				+ quantidade  + "\n-Cor: " + cor + "\n-Altura do salto (cm): " + tamDoSalto + 
				"\n-Tipo do salto: " + tipoDoSalto + "\n";
	}
	ArrayList<Salto> listaDeSalto = new ArrayList<Salto>();
	
	public void preCadastrosSalto(){

		Salto salto1 = new Salto("Salto Loja Reversa", 309.90, 50, "Preta", 15, "grosso");
		Salto salto2 = new Salto("Salto Vizzano ", 119.90, 50, "Rosa", 12, "tratorado");
		Salto salto3 = new Salto("Salto Aquazzura", 4084.99, 50, "Dourado", 10, "agulha");
		Salto salto4 = new Salto("Salto LE LIS BLANC", 195.96, 50, "Prata", 12, "fino");

		listaDeSalto.add(salto1);
		listaDeSalto.add(salto2);
		listaDeSalto.add(salto3);
		listaDeSalto.add(salto4);

	}
	
	public void cadastrar(Salto salto) {
		listaDeSalto.add(salto);	
	}
	
	public void editar(int pos, String dado, int info) {
		
		if(info == 1) {
			listaDeSalto.get(pos).setMarca(dado);
		}
		else if(info == 2) {
			listaDeSalto.get(pos).setPreco(Double.parseDouble(dado));
		}
		else if(info == 3) {
			listaDeSalto.get(pos).setQuantidade(Integer.parseInt(dado));
		}
		else if(info == 4) {
			listaDeSalto.get(pos).setCor(dado);
		}
		else if(info == 5) {
			listaDeSalto.get(pos).setTamDoSalto(Integer.parseInt(dado));
		}
		else if(info == 6) {
			listaDeSalto.get(pos).setTipoDoSalto(dado);
		}
		
	}
	
	public String retornaDado(int pos, int info) {
		String dado = "";
		
		if(info == 1) {
			dado = listaDeSalto.get(pos).getMarca();
		}
		else if(info == 2) {
			dado = String.valueOf(listaDeSalto.get(pos).getPreco());
		}
		else if(info == 3) {
			dado = String.valueOf(listaDeSalto.get(pos).getQuantidade());
		}
		else if(info == 4) {
			dado = listaDeSalto.get(pos).getCor();
		}
		else if(info == 5) {
			dado = String.valueOf(listaDeSalto.get(pos).getTamDoSalto());
		}
		else if(info == 6) {
			dado = listaDeSalto.get(pos).getTipoDoSalto();
		}
		
		return dado;
	}
	
	public void deletar(int n) {
		listaDeSalto.remove(listaDeSalto.get(n));
	}
	
	public String[] listaNomesSapatos() {
		String[] listaNomes = new String[200];
		for(int i=0; i< listaDeSalto.size(); i++) {
			listaNomes[i] = listaDeSalto.get(i).getMarca();
		}
		return listaNomes;
	}
	
	public int getTamDoSalto() {
		return tamDoSalto;
	}

	public void setTamDoSalto(int tamDoSalto) {
		this.tamDoSalto = tamDoSalto;
	}

	public String getTipoDoSalto() {
		return tipoDoSalto;
	}

	public void setTipoDoSalto(String tipoDoSalto) {
		this.tipoDoSalto = tipoDoSalto;
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
