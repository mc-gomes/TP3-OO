package lojadesapato;

import java.util.ArrayList;
import java.util.Scanner;

public class Chuteira extends Sapato{
	private String nome;
	private String tipo;
	private String cano;
	
	// quais vairáveis colocar exatamente?
	public Chuteira(String n, String m, double p, int q,  String c, String t, String ca) {
		nome = n;
		this.marca = m;
		this.preco = p;
		this.quantidade = q;
		this.cor = c;
		tipo = t;
		cano = ca;
	}

	@Override
	public String toString() {
		return "-Nome da chuteira: " + nome + "-\nMarca: " + marca + "Tipo: " + tipo +
				"\n-Preço R$ " + preco + "\n-Quantidade em estoque: " + quantidade  +
				"\n-Cor: " + cor + "\n-Altura do cano: " + cano + "\n\n";
	}
	ArrayList<Chuteira> listaDeChuteira = new ArrayList<Chuteira>();
	public ArrayList<Chuteira> preencher(){
		
		Chuteira chuteira1 = new Chuteira("Beco 2 TF", "Nike", 139.90, 50, "Vermelha", "Society", "cano baixo");
		Chuteira chuteira2 = new Chuteira("Predator 19.4", "Adidas", 139.90, 50, "Preta", "Campo", "cano alto");
		Chuteira chuteira3 = new Chuteira("Morelia Club IN", "Mizuno", 109.99, 50, "Preta", "Futsal", "cano baixo");
		Chuteira chuteira4 = new Chuteira("Deportivo", "Adidas", 169.99, 50, "Verde", "Futsal", "cano baixo");
		
		listaDeChuteira.add(chuteira1);
		listaDeChuteira.add(chuteira2);
		listaDeChuteira.add(chuteira3);
		listaDeChuteira.add(chuteira4);	

		return listaDeChuteira;
	}
	
	Scanner ler = new Scanner (System.in);
	
	// PRECISA DOS CRUDs
	
	public void cadastrar() {
		String nome, marca, cor, cano, tipo;
		double preco;
		int qtd;
		
		System.out.print("Nome da chuteira: ");
		nome = ler.nextLine();
		System.out.print("Marca: ");
		marca = ler.nextLine();
		System.out.print("Tipo da chuteira: ");
		tipo = ler.nextLine();
		System.out.print("\nPreço R$ ");
		preco = ler.nextDouble();
		System.out.print("\nQuantidade a ser cadastrada: ");
		qtd = ler.nextInt();
		ler.nextLine();
		System.out.print("\nCor: ");
		cor = ler.nextLine();
		System.out.print("\nAltura do cano: ");
		cano = ler.nextLine();
		
		Chuteira chuteira = new Chuteira(nome, marca, preco, qtd, cor, tipo, cano);
		listaDeChuteira.add(chuteira);
		
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
			
			
			if(modo == 1) {
				// mostrar faixa de preco
				int precoMin, precoMax;
				System.out.print("Informe o preço mínimo (valor inteiro): ");
				precoMin = ler.nextInt();
				System.out.print("\nInforme o preço máximo (valor inteiro): ");
				precoMax = ler.nextInt();
				
				for(int i=0; i<listaDeChuteira.size(); i++) {
					if(precoMin < listaDeChuteira.get(i).getPreco() && listaDeChuteira.get(i).getPreco() < precoMax){
						System.out.println(listaDeChuteira.get(i).toString());
					}
				}
			}
			else if(modo == 2) {
				// mostrar pela marca
				String marca;
				boolean check = false;
				System.out.print("Informe o nome da marca: ");
				marca = ler.nextLine();
				
				for(int i=0; i<listaDeChuteira.size(); i++) {
					if(marca.equals(listaDeChuteira.get(i).getMarca())) {
						check = true;
						System.out.println(listaDeChuteira.get(i).toString());
					}
				}
				if(!check) {
					System.out.println("Marca não encontrada!");
				}
			}
			else if(modo == 3) {
				for(int i=0; i<listaDeChuteira.size(); i++) {
					System.out.println(listaDeChuteira.get(i).toString());
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
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
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

	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
