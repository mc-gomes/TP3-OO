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
		return "-Marca: " + marca + "\n-PreÃ§o R$ " + preco + "\n-Quantidade em estoque: "
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
	Scanner ler = new Scanner (System.in);



	public void cadastrar() {
		String marca, cor, tipo;
		double preco;
		int qtd;

		System.out.println("-> CADASTRO DE TÃŠNIS");
		System.out.print("Marca: ");
		marca = ler.nextLine();
		System.out.print("PreÃ§o R$ ");
		preco = ler.nextDouble();
		System.out.print("Quantidade a ser cadastrada: ");
		qtd = ler.nextInt();
		ler.nextLine();
		System.out.print("Cor: ");
		cor = ler.nextLine();
		System.out.print("Tipo do tÃªnis: ");
		tipo = ler.nextLine();

		Tenis Tenis = new Tenis(marca, preco, qtd, cor, tipo);
		listaDeTenis.add(Tenis);

	}

	public void visualizar() {
		int modo;

		if(listaDeTenis.size() == 0) System.out.print("\nNÃ£o hÃ¡ nenhum tÃªnis cadastrado.\n");

		else {
			do {
				boolean check = false;
				System.out.println("-> VISUALIZAÃ‡ÃƒO DE TÃŠNIS");
				System.out.println("\nDeseja visualizar por:"
						+ "\n1- Faixa de preÃ§o"
						+ "\n2- Marca"
						+ "\n3- Visualizar todos"
						+ "\n4- Sair da visualizaÃ§Ã£o");
				System.out.print(">> ");
				modo = ler.nextInt();
				ler.nextLine();


				if(modo == 1) {
					int precoMin, precoMax;
					System.out.print("\nInforme o preÃ§o mÃ­nimo (valor inteiro): ");
					precoMin = ler.nextInt();
					System.out.print("Informe o preÃ§o mÃ¡ximo (valor inteiro): ");
					precoMax = ler.nextInt();

					for(int i=0; i<listaDeTenis.size(); i++) {
						if(precoMin < listaDeTenis.get(i).getPreco() && listaDeTenis.get(i).getPreco() < precoMax){
							check = true;
							System.out.println("\n-> PRODUTO " + (i+1));
							System.out.println(listaDeTenis.get(i).toString());
						}
					}

					if(!check) {
						System.out.println("NÃ£o hÃ¡ nenhum produto nessa faixa de preÃ§o!\n");
					}
				}
				else if(modo == 2) {
					String marca;
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
						System.out.println("Marca nÃ£o encontrada!");
					}
				}
				else if(modo == 3) {
					for(int i=0; i<listaDeTenis.size(); i++) {
						System.out.println("\n-> PRODUTO " + (i+1));
						System.out.println(listaDeTenis.get(i).toString());
					}
				}
				else if(modo == 4) {
					System.out.println("\nEncerrando visualizaÃ§Ã£o...");
					break;
				}
				else {
					System.out.println("OpÃ§Ã£o invÃ¡lida!");
				}

			}while(modo != 4);
		}
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
