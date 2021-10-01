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
		return "-Marca: " + marca + "\n-PreÃ§o R$ " + preco + "\n-Quantidade em estoque: "
				+ quantidade  + "\n-Cor: " + cor + "\n-Altura do salto (cm): " + tamDoSalto +
				"\n-Tipo do salto: " + tipoDoSalto + "\n";
	}
	ArrayList<Salto> listaDeSalto = new ArrayList<Salto>();
	public void preCadastrosSalto(){

		Salto salto1 = new Salto("Salto Loja Reversa", "", 309.90, 50, "Preta", "15", "grosso");
		Salto salto2 = new Salto("Salto Vizzano ", 119.90, 50, "Rosa", "12", "tratorado");
		Salto salto3 = new Salto("Salto Aquazzura", 4084.99, 50, "Dourado", "10", "agulha");
		Salto salto4 = new Salto("Salto LE LIS BLANC", 195.96, 50, "Prata", "12", "fino");

		listaDeSalto.add(salto1);
		listaDeSalto.add(salto2);
		listaDeSalto.add(salto3);
		listaDeSalto.add(salto4);

	}
	Scanner ler = new Scanner (System.in);


	public void cadastrar() {
		String marca, cor, tipo;
		double preco;
		int qtd, tam;

		System.out.println("-> CADASTRO DE SALTO");
		System.out.print("Marca: ");
		marca = ler.nextLine();
		System.out.print("PreÃ§o R$ ");
		preco = ler.nextDouble();
		System.out.print("Quantidade a ser cadastrada: ");
		qtd = ler.nextInt();
		ler.nextLine();
		System.out.print("Cor: ");
		cor = ler.nextLine();
		System.out.print("Altura do salto (cm): ");
		tam = ler.nextInt();
		ler.nextLine();
		System.out.print("Tipo do salto: ");
		tipo = ler.nextLine();

		Salto salto = new Salto(marca, preco, qtd, cor, tam, tipo);
		listaDeSalto.add(salto);

	}

	public void visualizar() {
		int modo;

		if(listaDeSalto.size() == 0) System.out.print("\nNÃ£o hÃ¡ nenhum salto cadastrado.\n");

		else {
			do {
				boolean check = false;
				System.out.println("-> VISUALIZAÃ‡ÃƒO DE SALTO");
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

					for(int i=0; i<listaDeSalto.size(); i++) {
						if(precoMin < listaDeSalto.get(i).getPreco() && listaDeSalto.get(i).getPreco() < precoMax){
							check = true;
							System.out.println("\n-> PRODUTO " + (i+1));
							System.out.println(listaDeSalto.get(i).toString());
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


					for(int i=0; i<listaDeSalto.size(); i++) {
						if(marca.equals(listaDeSalto.get(i).getMarca())) {
							check = true;
							System.out.println("\n-> PRODUTO " + (i+1));
							System.out.println(listaDeSalto.get(i).toString());
						}
					}
					if(!check) {
						System.out.println("Marca nÃ£o encontrada!");
					}
				}
				else if(modo == 3) {
					for(int i=0; i<listaDeSalto.size(); i++) {
						System.out.println("\n-> PRODUTO " + (i+1));
						System.out.println(listaDeSalto.get(i).toString());
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
