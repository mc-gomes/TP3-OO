package lojadesapato;

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

	@Override
	public String toString() {
		return "-Marca: " + marca + "\n-Preço R$ " + preco + "\n-Quantidade em estoque: "
				+ quantidade  + "\n-Cor: " + cor + "\n-Altura do salto (cm): " + tamDoSalto + 
				"\n-Tipo do salto: " + tipoDoSalto + "\n\n";
	}
	ArrayList<Salto> listaDeSalto = new ArrayList<Salto>();
	public ArrayList<Salto> preencher(){

		Salto salto1 = new Salto("Bella Chic Shoes", "129.90", 10, "preto e dourado", 5, "salto tratorado");
		Salto salto2 = new Salto("Vizzano", "84.99", 10, "nude", 14, "salto grosso");
		Salto salto3 = new Salto("V. STYLO", "64.90", 10, "branco", 12, "salto agulha");
		Salto salto4 = new Salto("Amorelle", "154.99", 10, "branco e dourado", 10, "salto quadrado");

		listaDeSalto.add(salto1);
		listaDeSalto.add(salto2);
		listaDeSalto.add(salto3);
		listaDeSalto.add(salto4);

		return listaDeSalto;
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

	public void editar(Salto salto) {

		int num = 0;

		do {
			System.out.println("Selecione o que deseja alterar:\n"
					+ "1-Alterar a marca\n"
					+ "2-Alterar o preco\n"
					+ "3-Alterar a quantidade\n"
					+ "4-Alterar a cor\n"
					+ "5-Alterar tamanho do salto (em cm)\n"
					+ "6-Alterar tipo do salto(agulha,grosso,fino)\n"
					+ "7-Sair\n");

			num = input.nextInt();

			switch (num) {
				case 1:
					System.out.println("Digite a nova marca:\n");
					salto.setMarca(input.nextLine());
					break;
				case 2:
					System.out.println("Digite o novo preco:\n");
					salto.setPreco(input.nextLine());
					break;
				case 3:
					System.out.println("Digite a nova quantidade:\n");
					salto.setQuantidade(input.nextLine());
					break;
				case 4:
					System.out.println("Digite a nova cor:\n");
					salto.setCor(input.nextInt());
					break;
				case 5:
					System.out.println("Digite o tamanho do salto (em cm):\n");
					salto.setTamDoSalto(input.nextLine());
					break;
				case 6:
					System.out.println("Digite o tipo do salto (agulha,grosso,fino):\n");
					salto.setTipoDoSalto(input.nextLine());
					break;
				case 7:
					System.out.println("Retornando ao menu\n");
					break;
				default:
					System.out.println("Insira uma opção válida\n");
					break;

			}
		} while (1 > num || num > 6);

	}
	public void deletar(Salto salto) {
		listaDeSalto.remove(listaDeSalto.indexOf(salto));
	}
}
