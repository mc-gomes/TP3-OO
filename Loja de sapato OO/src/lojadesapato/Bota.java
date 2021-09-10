package lojadesapato;

import java.util.ArrayList;

public class Bota extends Sapato{
	private String cano;
	private String genero;
	
	public Bota(String m, double p, int q, String c, String g, String ca) {
		this.marca = m;
		this.preco = p;
		this.quantidade = q;
		this.cor = c;
		genero = g;
		cano = ca;
	}
	
	// PRECISA DOS CRUDs
	ArrayList<Bota> listaDeBota = new ArrayList<Bota>();
	
	@Override
	public String toString() {
		return "-Marca: " + marca + "\n-Preço R$ " + preco + "\nQuantidade em estoque: "
				+ quantidade + "\n-Altura do cano: " + cano + "\n-Gênero: " + genero;
	}

	public void visualizar(int modo) {
		if(modo == 1) {
			// mostrar faixa de preco
		}
		if(modo == 2) {
			// mostrar pela marca
		}
		int i;
		boolean encontrado = false;
				
		for(i=0; i<listaDeBota.size(); i++) {
			if(listaDeBota.get(i).getMarca() == marca) {
				System.out.println(listaDeBota.get(i).toString());
				//encontrado = true;
				//return vLivro.get(i);
			}
		}
//		int i;
//		System.out.println("Marca: " + botas.get(i).getMarca());
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


	public static ArrayList<Bota> preencher(){
		String[]marcaCadastrado= {"MADALE","WorldColors","Tricae" ,"Sapatofran"};
		Double[]precoCadastrado= {"199.60","89.90","35.99","139.90"};
		int[]quantidadeCadastrado= {10,5,13,3};
		String[]corCadastrado= {"preto","transparente","branco","marrom"};
		String[]generoCadastrado= {"feminino","infantil","infantil","masculino"};
		String[]canoCadastrado= {"cano alto","cano alto","cano alto","cano alto"};

		ArrayList<Bota> listaDeBota = new Arraylist<Bota>();
		for (int i=0;i<4;i++){
			Bota bota = new Bota(marcaCadastrado[i],precoCadastrado[i],quantidadeCadastrado[i], corCadastrado[i],generoCadastrado[i],canoCadastrado[i]);

			listaDeBota.add(bota);
		}
		return listaDeBota;
	}
	public void editar(Bota bota) {

		int num = 0;

		do {
			System.out.println("Selecione o que deseja alterar:\n"
					+ "1-Aterar a marca\n"
					+ "2-Aterar o preco\n"
					+ "3-Aterar a quantidade\n"
					+ "4-Aterar a cor\n"
					+ "5-Aterar genero(masculino,feminino ou infantil)\n"
					+ "6-Aterar a altura do cano(baixo ou alto)\n"
					+ "7-Sair\n");

			num = input.nextInt();

			switch (num) {

				case 1:
					System.out.println("Digite a nova marca:\n");
					bota.setMarca(input.nextLine());
					break;
				case 2:
					System.out.println("Digite o novo preco:\n");
					bota.setPreco(input.nextLine());
					break;
				case 3:
					System.out.println("Digite a nova quantidade:\n");
					bota.setQuantidade(input.nextLine());
					break;
				case 4:
					System.out.println("Digite a nova cor:\n");
					bota.setCor(input.nextInt());
					break;
				case 5:
					System.out.println("Digite o novo genero(masculino,feminino ou infantil):\n");
					bota.setGenero(input.nextLine());
					break;
				case 6:
					System.out.println("Digite a nova altura do cano(alto ou baixo:\n");
					bota.setCano(input.nextInt());
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