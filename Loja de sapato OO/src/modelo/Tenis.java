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
	Scanner ler = new Scanner (System.in);
	
	
	
	public void cadastrar() {
		String marca, cor, tipo;
		double preco;
		int qtd;
		
		System.out.print("Marca: ");
		marca = ler.nextLine();
		System.out.print("Preço R$ ");
		preco = ler.nextDouble();
		System.out.print("Quantidade a ser cadastrada: ");
		qtd = ler.nextInt();
		ler.nextLine();
		System.out.print("Cor: ");
		cor = ler.nextLine();
		System.out.print("Tipo do Tenis: ");
		tipo = ler.nextLine();
		
		Tenis Tenis = new Tenis(marca, preco, qtd, cor, tipo);
		listaDeTenis.add(Tenis);
		
	}

	public void visualizar() {
		int modo;
		
		do {
			System.out.println("Deseja visualizar por:"
					+ "\n1- Faixa de preço"
					+ "\n2- Marca"
					+ "\n3- Visualizar todos"
					+ "\n4- Sair da visualização");
			System.out.print(">> ");
			modo = ler.nextInt();
			
			
			if(modo == 1) {
				// mostrar faixa de preco
				int precoMin, precoMax;
				System.out.print("\nInforme o preço mínimo (valor inteiro): ");
				precoMin = ler.nextInt();
				System.out.print("Informe o preço máximo (valor inteiro): ");
				precoMax = ler.nextInt();
				
				for(int i=0; i<listaDeTenis.size(); i++) {
					if(precoMin < listaDeTenis.get(i).getPreco() && listaDeTenis.get(i).getPreco() < precoMax){
						System.out.println("\n-> PRODUTO " + (i+1));
						System.out.println(listaDeTenis.get(i).toString());
					}
				}
			}
			else if(modo == 2) {
				// mostrar pela marca
				String marca;
				boolean check = false;
				System.out.print("\nInforme o nome da marca: ");
				marca = ler.nextLine();
				
				for(int i=0; i<listaDeTenis.size(); i++) {
					if(marca.equals(listaDeTenis.get(i).getMarca())) {
						check = true;
						System.out.println("\n-> PRODUTO " + (i+1));
						System.out.println(listaDeTenis.get(i).toString());
					}
				}
				if(!check) {
					System.out.println("Marca não encontrada!");
				}
			}
			else if(modo == 3) {
				for(int i=0; i<listaDeTenis.size(); i++) {
					System.out.println("\n-> PRODUTO " + (i+1));
					System.out.println(listaDeTenis.get(i).toString());
				}
			}
			else if(modo == 4) {
				System.out.println("Encerrando visualização...");
				break;
			}
			else {
				System.out.println("Opção inválida!");
			}
			
		}while(modo != 4);
		
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
