package lojadesapato;

import java.util.ArrayList;
import java.util.Scanner;

public class Bota extends Sapato{
	private String genero;
	private String cano;
	
	public Bota(String m, double p, int q, String c, String ca, String g) {
		this.marca = m;
		this.preco = p;
		this.quantidade = q;
		this.cor = c;
		cano = ca;
		genero = g;
	}
	
	// PRECISA DOS CRUDs
	ArrayList<Bota> listaDeBota = new ArrayList<Bota>();
	Scanner ler = new Scanner (System.in);
	
	@Override
	public String toString() {
		return "-Marca: " + marca + "\n-Preço R$ " + preco + "\nQuantidade em estoque: "
				+ quantidade  + "\n-Gênero: " + genero + "\n-Altura do cano: " + cano;
	}
	
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
		
		System.out.println("Deseja visualizar por:"
				+ "1- Faixa de preço"
				+ "2- Marca\n");
		System.out.print(">> ");
		modo = ler.nextInt();
		
		
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
		if(modo == 2) {
			// mostrar pela marca
			String marca;
			boolean check = false;
			System.out.print("Informe o nome da marca: ");
			marca = ler.nextLine();
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


	public void preencher(){
		String[]marcaCadastrado= {"MADALE","WorldColors","Tricae" ,"Sapatofran"};
		Double[]precoCadastrado= {199.60, 89.90, 35.99, 139.90};
		int[]quantidadeCadastrado= {10, 5, 13, 3};
		String[]corCadastrado= {"preto","transparente","branco","marrom"};
		String[]generoCadastrado= {"feminino","infantil","infantil","masculino"};
		String[]canoCadastrado= {"cano alto","cano alto","cano alto","cano alto"};

		for (int i=0;i<4;i++){
			Bota bota = new Bota(marcaCadastrado[i],precoCadastrado[i],quantidadeCadastrado[i], corCadastrado[i],generoCadastrado[i],canoCadastrado[i]);

			listaDeBota.add(bota);
		}
		return listaDeBota;
	}
}