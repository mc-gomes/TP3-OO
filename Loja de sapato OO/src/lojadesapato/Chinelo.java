package lojadesapato;

import java.util.ArrayList;
import java.util.Scanner;

public class Chinelo extends Sapato{
	private String estilo;
	
	public Chinelo(String m, double p, int q, String c, String e) {
		this.marca = m;
		this.preco = p;
		this.quantidade = q;
		this.cor = c;
		estilo = e;
	}

	@Override
	public String toString() {
		return "-Marca: " + marca + "\n-Preço R$ " + preco + "\n-Quantidade em estoque: "
				+ quantidade  + "\n-Cor: " + cor + "\n-Estilo da tira: " + estilo + "\n\n";
	}
	// PRECISA DOS CRUDs
	ArrayList<Chinelo> listaDeChinelo = new ArrayList<Chinelo>();
	Scanner ler = new Scanner (System.in);
	
	
	public void cadastrar() {
		String marca, cor, estilo;
		double preco;
		int qtd;
				
		System.out.print("Marca: ");
		marca = ler.nextLine();
		System.out.print("\nPreço R$ ");
		preco = ler.nextDouble();
		System.out.print("\nQuantidade a ser cadastrada: ");
		qtd = ler.nextInt();
		ler.nextLine();
		System.out.print("\nCor: ");
		cor = ler.nextLine();
		System.out.print("\nEstilo do chinelo: ");
		estilo = ler.nextLine();
		
		Chinelo chinelo = new Chinelo(marca, preco, qtd, cor, estilo);
		listaDeChinelo.add(chinelo);
		
	}

	public void visualizar() {
		int modo;
		
		do {
			System.out.println("Deseja visualizar por:"
					+ "1- Faixa de preço"
					+ "2- Marca"
					+ "3- Sem filtro"
					+ "4- Sair da visualização\n");
			System.out.print(">> ");
			modo = ler.nextInt();
			
			
			if(modo == 1) {
				// mostrar faixa de preco
				int precoMin, precoMax;
				System.out.print("Informe o preço mínimo (valor inteiro): ");
				precoMin = ler.nextInt();
				System.out.print("\nInforme o preço máximo (valor inteiro): ");
				precoMax = ler.nextInt();
				
				for(int i=0; i<listaDeChinelo.size(); i++) {
					if(precoMin < listaDeChinelo.get(i).getPreco() && listaDeChinelo.get(i).getPreco() < precoMax){
						System.out.println(listaDeChinelo.get(i).toString());
					}
				}
			}
			else if(modo == 2) {
				// mostrar pela marca
				String marca;
				boolean check = false;
				System.out.print("Informe o nome da marca: ");
				marca = ler.nextLine();
				
				for(int i=0; i<listaDeChinelo.size(); i++) {
					if(marca.equals(listaDeChinelo.get(i).getMarca())) {
						check = true;
						System.out.println(listaDeChinelo.get(i).toString());
					}
				}
				if(!check) {
					System.out.println("Marca não encontrada!");
				}
			}
			else if(modo == 3) {
				for(int i=0; i<listaDeChinelo.size(); i++) {
					System.out.println(listaDeChinelo.get(i).toString());
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
