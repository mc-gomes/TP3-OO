package modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Bota extends Sapato{
	private String cano;
	private String genero;
	
	public Bota() {
		//preCadastrosBota();
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
				"\n-Altura do cano: " + cano + "\n";
	}
	
	ArrayList<Bota> listaDeBota = new ArrayList<Bota>();
	public void preCadastrosBota(){
		
		Bota bota1 = new Bota("Bota MADALE", 199.60, 10, "Preto", "alto", "feminino");
		Bota bota2 = new Bota("Bota WorldColors", 89.90, 5, "Transparente", "alto", "infantil");
		Bota bota3 = new Bota("Bota Tricae", 35.99, 13, "Branco", "alto", "infantil");
		Bota bota4 = new Bota("Bota MADALE", 194.90, 10, "Marrom", "alto", "masculino");
		
		listaDeBota.add(bota1);
		listaDeBota.add(bota2);
		listaDeBota.add(bota3);
		listaDeBota.add(bota4);

	}
	
	public String retornaDado(int pos, int info) {
		String dado = "";
		
		if(info == 1) {
			dado = listaDeBota.get(pos).getMarca();
		}
		else if(info == 2) {
			dado = String.valueOf(listaDeBota.get(pos).getPreco());
		}
		else if(info == 3) {
			dado = String.valueOf(listaDeBota.get(pos).getQuantidade());
		}
		else if(info == 4) {
			dado = listaDeBota.get(pos).getCor();
		}
		else if(info == 5) {
			dado = listaDeBota.get(pos).getCano();
		}
		else if(info == 6) {
			dado = listaDeBota.get(pos).getGenero();
		}
		
		return dado;
	}

	Scanner ler = new Scanner (System.in);
	
	public void cadastrar(Bota bota) {
		listaDeBota.add(bota);
		
	}

	public void visualizar() {
		int modo;
		
		if(listaDeBota.size() == 0) System.out.print("\nNão há nenhuma bota cadastrada.\n");
		
		else {
			do {
				boolean check = false;
				System.out.println("-> VISUALIZAÇÃO DE BOTA");
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
					
					for(int i=0; i<listaDeBota.size(); i++) {
						if(precoMin < listaDeBota.get(i).getPreco() && listaDeBota.get(i).getPreco() < precoMax){
							check = true;
							System.out.println("\n-> PRODUTO " + (i+1));
							System.out.println(listaDeBota.get(i).toString());
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
					
					
					for(int i=0; i<listaDeBota.size(); i++) {
						if(marca.equals(listaDeBota.get(i).getMarca())) {
							check = true;
							System.out.println("\n-> PRODUTO " + (i+1));
							System.out.println(listaDeBota.get(i).toString());
						}
					}
					if(!check) {
						System.out.println("Marca não encontrada!");
					}
				}
				else if(modo == 3) {
					for(int i=0; i<listaDeBota.size(); i++) {
						System.out.println("\n-> PRODUTO " + (i+1));
						System.out.println(listaDeBota.get(i).toString());
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
			listaDeBota.get(pos).setMarca(dado);
		}
		else if(info == 2) {
			listaDeBota.get(pos).setPreco(Double.parseDouble(dado));
		}
		else if(info == 3) {
			listaDeBota.get(pos).setQuantidade(Integer.parseInt(dado));
		}
		else if(info == 4) {
			listaDeBota.get(pos).setCor(dado);
		}
		else if(info == 5) {
			listaDeBota.get(pos).setCano(dado);
		}
		else if(info == 6) {
			listaDeBota.get(pos).setGenero(dado);
		}

		
	}
	
	public void deletar(int n) {
		listaDeBota.remove(listaDeBota.get(n));
		System.out.printf("Produto %d deletado com sucesso!\n", (n+1));
	}
	
	public String[] listaNomesSapatos() {
		String[] listaNomes = new String[200];
		for(int i=0; i< listaDeBota.size(); i++) {
			listaNomes[i] = listaDeBota.get(i).getMarca();
		}
		return listaNomes;
	}
	
	public int selecionaProduto() {
		int num;
		System.out.println("<<BOTAS CADASTRADAS>>\n");
		for(int i=0; i<listaDeBota.size(); i++) {
			System.out.println("-> PRODUTO " + (i+1));
			System.out.println(listaDeBota.get(i).toString());
		}
		
		do {
			System.out.print("Selecione um produto: ");
			num = ler.nextInt();
			
			if(num < 1 || num > listaDeBota.size())
				System.out.println("Opção inválida, informe novamente.\n");
			
		}while (num < 1 || num > listaDeBota.size());
		
		return num;
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
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getCano() {
		return cano;
	}
	public void setCano(String cano) {
		this.cano = cano;
	}

}