package lojadesapato;

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

	@Override
	public String toString() {
		return "-Marca: " + marca + "\n-Preço R$ " + preco + "\n-Quantidade em estoque: "
				+ quantidade  + "\n-Cor: " + cor + "\n-Estilo da tira: " + estilo + "\n\n";
	}

	ArrayList<Chinelo> listaDeChinelo = new ArrayList<Chinelo>();
	public ArrayList<Chinelo> preencher(){

		Chinelo chinelo1 = new Chinelo("Ipanema", 25.90, 10, "amarela", "slide");
		Chinelo chinelo2 = new Chinelo("Havaianas", 26.99, 10, "pink", "de dedo");
		Chinelo chinelo3 = new Chinelo("Nike", 69.90, 10, "preto", "slide");
		Chinelo chinelo4 = new Chinelo("Colcci", 34.99, 10, "verde neon", "de dedo");

		listaDeChinelo.add(chinelo1);
		listaDeChinelo.add(chinelo2);
		listaDeChinelo.add(chinelo3);
		listaDeChinelo.add(chinelo4);

		return listaDeChinelo;
	}
	Scanner ler = new Scanner (System.in);
	// PRECISA DOS CRUDs
	
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


	public void editar(Chinelo chinelo) {

		int num = 0;

		do {
			System.out.println("Selecione o que deseja alterar:\n"
					+ "1-Alterar o nome\n"
					+ "2-Alterar a marca\n"
					+ "3-Alterar o preco\n"
					+ "4-Alterar a quantidade\n"
					+ "5-Alterar a cor\n"
					+ "6-Alterar estilo(de dedo ou slide)\n"
					+ "7-Sair\n");

			num = input.nextInt();

			switch (num) {
				case 1:
					System.out.println("Digite o novo nome:\n");
					chuteira.setNome(input.nextLine());
					break;
				case 2:
					System.out.println("Digite a nova marca:\n");
					chuteira.setMarca(input.nextLine());
					break;
				case 3:
					System.out.println("Digite o novo preco:\n");
					chuteira.setPreco(input.nextLine());
					break;
				case 4:
					System.out.println("Digite a nova quantidade:\n");
					chuteira.setQuantidade(input.nextLine());
					break;
				case 5:
					System.out.println("Digite a nova cor:\n");
					chuteira.setCor(input.nextInt());
					break;
				case 6:
					System.out.println("Digite o estilo(de dedo ou slide):\n");
					chuteira.setEstilo(input.nextLine());
					break;
				case 7:
					System.out.println("Retornando ao menu\n");
					break;
				default:
					System.out.println("Insira uma opção válida\n");
					break;

			}
		} while (1 > num || num > 7);

	}
}
