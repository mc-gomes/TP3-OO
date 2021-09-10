package lojadesapato;

public class Tenis extends Sapato{
	private String tipo;

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

	public static ArrayList<Tenis> preencher(){;
		String[]marcaCadastrado= {"OLYMPIKUS","New Balance","Balenciaga" ,"Vans"};
		Double[]precoCadastrado= {"179.90","299.99","8144.99","379.99"};
		int[]quantidadeCadastrado= {10,10,10,10};
		String[]corCadastrado= {"laranja","roxo e amarelo","verde neon","branco"};
		String[]tipoCadastrado= {"caminhada","corrida","casual","skate"};


		ArrayList<Tenis> listaDeTenis = new Arraylist<Chuteira>();
		for (int i=0;i<4;i++){
			Tenis tenis = new Tenis(nomeCadastrado[i], marcaCadastrado[i],precoCadastrado[i],quantidadeCadastrado[i], corCadastrado[i],tipoCadastrado[i]);

			listaDeTenis.add(tenis);
		}
		return listaDeTenis;
	}
	public void editar(Tenis tenis) {

		int num = 0;

		do {
			System.out.println("Selecione o que deseja alterar:\n"
					+ "1-Aterar a marca\n"
					+ "2-Aterar o preco\n"
					+ "3-Aterar a quantidade\n"
					+ "4-Aterar a cor\n"
					+ "5-Aterar tipo(casual,corrida,caminhada)\n"
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
}
