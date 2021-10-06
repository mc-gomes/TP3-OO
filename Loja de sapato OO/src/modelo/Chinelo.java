package modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Chinelo extends Sapato{
	private String estilo;
	
	public Chinelo() {
		
	}
	
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
				+ quantidade  + "\n-Cor: " + cor + "\n-Estilo da tira: " + estilo + "\n";
	}
	
	public void preCadastrosChinelo() {
		Chinelo chinelo1 = new Chinelo("Chinelo Nike",159.90, 50, "Preto","slide");
		Chinelo chinelo2 = new Chinelo("Chinelo Colcci", 79.90, 50, "Preto e vermelho","normal");
		Chinelo chinelo3 = new Chinelo("Chinelo Reserva",64.99, 50, "branco","normal");
		Chinelo chinelo4 = new Chinelo("Chinelo Vans", 179.99, 50, "Xadrez","slide");

		listaDeChinelo.add(chinelo1);
		listaDeChinelo.add(chinelo2);
		listaDeChinelo.add(chinelo3);
		listaDeChinelo.add(chinelo4);
	}
	
	public String retornaDado(int pos, int info) {
		String dado = "";
		
		if(info == 1) {
			dado = listaDeChinelo.get(pos).getMarca();
		}
		else if(info == 2) {
			dado = String.valueOf(listaDeChinelo.get(pos).getPreco());
		}
		else if(info == 3) {
			dado = String.valueOf(listaDeChinelo.get(pos).getQuantidade());
		}
		else if(info == 4) {
			dado = listaDeChinelo.get(pos).getCor();
		}
		else if(info == 5) {
			dado = listaDeChinelo.get(pos).getEstilo();
		}
		
		return dado;
	}
	
	
	ArrayList<Chinelo> listaDeChinelo = new ArrayList<Chinelo>();
	Scanner ler = new Scanner (System.in);
	
	
	public void cadastrar(Chinelo chinelo) {
//		String marca, cor, estilo;
//		double preco;
//		int qtd;
//
//		System.out.println("-> CADASTRO DE CHINELO");
//		System.out.print("Marca: ");
//		marca = ler.nextLine();
//		System.out.print("Preço R$ ");
//		preco = ler.nextDouble();
//		System.out.print("Quantidade a ser cadastrada: ");
//		qtd = ler.nextInt();
//		ler.nextLine();
//		System.out.print("Cor: ");
//		cor = ler.nextLine();
//		System.out.print("Estilo da tira: ");
//		estilo = ler.nextLine();
//		
//		Chinelo chinelo = new Chinelo(marca, preco, qtd, cor, estilo);
		listaDeChinelo.add(chinelo);
		
	}

	public void visualizar() {
		int modo;
		
		if(listaDeChinelo.size() == 0) System.out.print("\nNão há nenhum chinelo cadastrado.\n");
		
		else {
			do {
				boolean check = false;
				System.out.println("-> VISUALIZAÇÃO DE CHINELO");
				System.out.println("\nDeseja visualizar por:"
						+ "\n1- Faixa de preço"
						+ "\n2- Marca"
						+ "\n3- Visualizar todos"
						+ "\n4- Sair da visualização");
				System.out.print(">> ");
				modo = ler.nextInt();
				ler.nextLine();
				
				
				if(modo == 1) {
					int precoMin, precoMax;
					System.out.print("\nInforme o preço mínimo (valor inteiro): ");
					precoMin = ler.nextInt();
					System.out.print("Informe o preço máximo (valor inteiro): ");
					precoMax = ler.nextInt();
					
					for(int i=0; i<listaDeChinelo.size(); i++) {
						if(precoMin < listaDeChinelo.get(i).getPreco() && listaDeChinelo.get(i).getPreco() < precoMax){
							check = true;
							System.out.println("\n-> PRODUTO " + (i+1));
							System.out.println(listaDeChinelo.get(i).toString());
						}
					}
					
					if(!check) {
						System.out.println("Não há nenhum produto nessa faixa de preço!\n");
					}
				}
				else if(modo == 2) {
					String marca;
					System.out.print("\nInforme o nome da marca: ");
					marca = ler.nextLine();
					
					
					for(int i=0; i<listaDeChinelo.size(); i++) {
						if(marca.equals(listaDeChinelo.get(i).getMarca())) {
							check = true;
							System.out.println("\n-> PRODUTO " + (i+1));
							System.out.println(listaDeChinelo.get(i).toString());
						}
					}
					if(!check) {
						System.out.println("Marca não encontrada!");
					}
				}
				else if(modo == 3) {
					for(int i=0; i<listaDeChinelo.size(); i++) {
						System.out.println("\n-> PRODUTO " + (i+1));
						System.out.println(listaDeChinelo.get(i).toString());
					}
				}
				else if(modo == 4) {
					System.out.println("\nEncerrando visualização...");
					break;
				}
				else {
					System.out.println("Opção inválida!");
				}
				
			}while(modo != 4);	
		}
	}
	
	public void editar(int pos, String dado, int info) {
		
		if(info == 1) {
			listaDeChinelo.get(pos).setMarca(dado);
		}
		else if(info == 2) {
			listaDeChinelo.get(pos).setPreco(Double.parseDouble(dado));
		}
		else if(info == 3) {
			listaDeChinelo.get(pos).setQuantidade(Integer.parseInt(dado));
		}
		else if(info == 4) {
			listaDeChinelo.get(pos).setCor(dado);
		}
		else if(info == 5) {
			listaDeChinelo.get(pos).setEstilo(dado);
		}	
	}
	
	public void deletar(int n) {
		listaDeChinelo.remove(listaDeChinelo.get(n));
	}
	
	public String[] listaNomesSapatos() {
		String[] listaNomes = new String[200];
		for(int i=0; i< listaDeChinelo.size(); i++) {
			listaNomes[i] = listaDeChinelo.get(i).getMarca();
		}
		return listaNomes;
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
