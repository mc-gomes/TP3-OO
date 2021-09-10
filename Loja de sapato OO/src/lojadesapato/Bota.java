package lojadesapato;

import java.util.ArrayList;
import java.util.Scanner;

public class Bota extends Sapato{
	private String cano;
	private String genero;
	
	public Bota() {
		
	}
	
	public Bota(String m, double p, int q, String c, String ca, String g) {
		this.marca = m;
		this.preco = p;
		this.quantidade = q;
		this.cor = c;
		cano = ca;
		genero = g;
	}
	
	@Override
	public String toString() {
		return "-Marca: " + marca + "\n-Preço R$ " + preco + "\n-Quantidade em estoque: "
				+ quantidade  + "\n-Cor: " + cor + "\n-Gênero: " + genero +
				"\n-Altura do cano: " + cano + "\n\n";
	}
	
	ArrayList<Bota> listaDeBota = new ArrayList<Bota>();
	public void preencheBota(){
		
		Bota bota1 = new Bota("MADALE", 199.60, 10, "Preto", "cano alto", "feminino");
		Bota bota2 = new Bota("WorldColors", 89.90, 5, "Transparente", "cano alto", "infantil");
		Bota bota3 = new Bota("Tricae", 35.99, 13, "Branco", "cano alto", "infantil");
		Bota bota4 = new Bota("MADALE", 199.60, 10, "Marrom", "cano alto", "masculino");
		
		listaDeBota.add(bota1);
		listaDeBota.add(bota2);
		listaDeBota.add(bota3);
		listaDeBota.add(bota4);	

		//return listaDeBota;
	}

	
	
	Scanner ler = new Scanner (System.in);
	
	
	public void cadastrar() {
		String marca, cor, cano, genero;
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
		System.out.print("Altura do cano: ");
		cano = ler.nextLine();
		System.out.print("Gênero [M/F]: ");
		genero = ler.nextLine();
		
		Bota bota = new Bota(marca, preco, qtd, cor, cano, genero);
		listaDeBota.add(bota);
		
	}

	public void visualizar() {
		int modo;
		
		do {
			System.out.println("Deseja visualizar por:"
					+ "\n1- Faixa de preço"
					+ "\n2- Marca"
					+ "\n3- Sem filtro"
					+ "\n4- Sair da visualização\n");
			System.out.print(">> ");
			modo = ler.nextInt();
			ler.nextLine();
			
			
			if(modo == 1) {
				// mostrar faixa de preco
				int precoMin, precoMax;
				System.out.print("Informe o preço mínimo (valor inteiro): ");
				precoMin = ler.nextInt();
				System.out.print("\nInforme o preço máximo (valor inteiro): ");
				precoMax = ler.nextInt();
				
				for(int i=0; i<listaDeBota.size(); i++) {
					if(precoMin < listaDeBota.get(i).getPreco() && listaDeBota.get(i).getPreco() < precoMax){
						System.out.println(listaDeBota.get(i).toString());
					}
				}
			}
			else if(modo == 2) {
				// mostrar pela marca
				String marca;
				boolean check = false;
				System.out.print("Informe o nome da marca: ");
				marca = ler.nextLine();
				
				System.out.println(listaDeBota.size());
				for(int i=0; i<listaDeBota.size(); i++) {
					if(marca.equals(listaDeBota.get(i).getMarca())) {
						check = true;
						System.out.println(listaDeBota.get(i).toString());
					}
				}
				if(!check) {
					System.out.println("Marca não encontrada!");
				}
			}
			else if(modo == 3) {
				for(int i=0; i<listaDeBota.size(); i++) {
					System.out.println(listaDeBota.get(i).toString());
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

	public String getGenero() {
		return genero;
	}
	public void setTipo(String genero) {
		this.genero = genero;
	}
	
	public String getcano() {
		return cano;
	}
	public void setCano(String cano) {
		this.cano = cano;
	}

}