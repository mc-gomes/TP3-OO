package lojadesapato;

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

	@Override
	public String toString() {
		return "-Marca: " + marca + "\n-Preço R$ " + preco + "\n-Quantidade em estoque: "
				+ quantidade  + "\n-Cor: " + cor + "\n-Tipo do Tenis: " + tipo + "\n\n";
	}
	ArrayList<Tenis> listaDeTenis = new ArrayList<Tenis>();
	ArrayList<Chuteira> listaDeChuteira = new ArrayList<Chuteira>();
	public ArrayList<Chuteira> preencher() {

		Tenis tenis1 = new Tenis("OLYMPIKUS", "179.90", 50, "laranja", "caminhada");
		Tenis tenis2 = new Tenis("New Balance", "299.99", 50, "roxo e amarelo", "corrida");
		Tenis tenis3 = new Tenis("Balenciaga", "8144.99", 50, "verde neon", "casual");
		Tenis tenis4 = new Tenis("Vans", "379.99", 50, "preto", "skate");

		listaDeTenis.add(Tenis1);
		listaDeTenis.add(Tenis2);
		listaDeTenis.add(Tenis3);
		listaDeTenis.add(Tenis4);

		return listaDeTenis;
	}

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
		System.out.print("\nTipo do Tenis: ");
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
				
				for(int i=0; i<listaDeTenis.size(); i++) {
					if(precoMin < listaDeTenis.get(i).getPreco() && listaDeTenis.get(i).getPreco() < precoMax){
						System.out.println(listaDeTenis.get(i).toString());
					}
				}
			}
			else if(modo == 2) {
				// mostrar pela marca
				String marca;
				boolean check = false;
				System.out.print("Informe o nome da marca: ");
				marca = ler.nextLine();
				
				for(int i=0; i<listaDeTenis.size(); i++) {
					if(marca.equals(listaDeTenis.get(i).getMarca())) {
						check = true;
						System.out.println(listaDeTenis.get(i).toString());
					}
				}
				if(!check) {
					System.out.println("Marca não encontrada!");
				}
			}
			else if(modo == 3) {
				for(int i=0; i<listaDeTenis.size(); i++) {
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

	public void editar(Tenis tenis) {

		int num = 0;

		do {
			System.out.println("Selecione o que deseja alterar:\n"
					+ "1-Alterar a marca\n"
					+ "2-Alterar o preco\n"
					+ "3-Alterar a quantidade\n"
					+ "4-Alterar a cor\n"
					+ "5-Alterar tipo(casual,corrida,caminhada)\n"
					+ "6-Sair\n");

			num = input.nextInt();

			switch (num) {
				case 1:
					System.out.println("Digite a nova marca:\n");
					tenis.setMarca(input.nextLine());
					break;
				case 2:
					System.out.println("Digite o novo preco:\n");
					tenis.setPreco(input.nextLine());
					break;
				case 3:
					System.out.println("Digite a nova quantidade:\n");
					tenis.setQuantidade(input.nextLine());
					break;
				case 4:
					System.out.println("Digite a nova cor:\n");
					tenis.setCor(input.nextInt());
					break;
				case 5:
					System.out.println("Digite o tipo(casual,corrida,caminhada):\n");
					tenis.setTipo(input.nextLine());
					break;
				case 6:
					System.out.println("Retornando ao menu\n");
					break;
				default:
					System.out.println("Insira uma opção válida\n");
					break;

			}
		} while (1 > num || num > 6);

	}
	public void deletar(Tenis tenis) {
		listaDeTenis.remove(listaDeTenis.indexOf(tenis));
	}
}
