package lojadesapato;

import java.util.ArrayList;
import java.util.Scanner;

public class Salto extends Sapato{
	private int tamDoSalto;
	private String tipoDoSalto;

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
				"\n-Tipo do salto: " + tipoDoSalto + "\n\n";
	}
	ArrayList<Salto> listaDeSalto = new ArrayList<Salto>();
	Scanner ler = new Scanner (System.in);
	
	// PRECISA DOS CRUDs
	
	public void cadastrar() {
		String marca, cor, tipo;
		double preco;
		int qtd, tam;
		
		System.out.print("Marca: ");
		marca = ler.nextLine();
		System.out.print("\nPreço R$ ");
		preco = ler.nextDouble();
		System.out.print("\nQuantidade a ser cadastrada: ");
		qtd = ler.nextInt();
		ler.nextLine();
		System.out.print("\nCor: ");
		cor = ler.nextLine();
		System.out.print("\nAltura do salto (cm): ");
		tam = ler.nextInt();
		System.out.print("\nTipo do salto: ");
		tipo = ler.nextLine();
		
		Salto salto = new Salto(marca, preco, qtd, cor, tam, tipo);
		listaDeSalto.add(salto);
		
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
				
				for(int i=0; i<listaDeSalto.size(); i++) {
					if(precoMin < listaDeSalto.get(i).getPreco() && listaDeSalto.get(i).getPreco() < precoMax){
						System.out.println(listaDeSalto.get(i).toString());
					}
				}
			}
			else if(modo == 2) {
				// mostrar pela marca
				String marca;
				boolean check = false;
				System.out.print("Informe o nome da marca: ");
				marca = ler.nextLine();
				
				for(int i=0; i<listaDeSalto.size(); i++) {
					if(marca.equals(listaDeSalto.get(i).getMarca())) {
						check = true;
						System.out.println(listaDeSalto.get(i).toString());
					}
				}
				if(!check) {
					System.out.println("Marca não encontrada!");
				}
			}
			else if(modo == 3) {
				for(int i=0; i<listaDeSalto.size(); i++) {
					System.out.println(listaDeSalto.get(i).toString());
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
