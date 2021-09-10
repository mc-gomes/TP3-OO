package lojadesapato;

public class Chuteira extends Sapato{
	private String nome;
	private String tipo;
	private String cano;
	
	// quais vairáveis colocar exatamente?
	public Chuteira(String m, double p, int q, String c, String t, String ca) {
		this.marca = m;
		this.preco = p;
		this.quantidade = q;
		this.cor = c;
		tipo = t;
	}

	// PRECISA DOS CRUDs
	
	public String toString() {
		return "Nome do produto: " + nome + "\nMarca: " + marca +
				"\nTipo: " + tipo + "\nCor: " + cor + "\nPreço R$ " +
				preco + "\nQuantidade em estoque: " + quantidade;
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


	public static ArrayList<Chuteira> preencher(){
		String[]nomeCadastrado= {"Goletto","Artilheira III","Boleiro" ,"Predator"};
		String[]marcaCadastrado= {"Adidas","Adidas","Topper" ,"Adidas"};
		Double[]precoCadastrado= {"149.90","159.90","39.99","154.99"};
		int[]quantidadeCadastrado= {100,7,63,15};
		String[]corCadastrado= {"rosa e preto","preta e branco","branco","branco e dourado"};
		String[]tipoCadastrado= {"campo","society","futsal","salao"};


		ArrayList<Chuteira> listaDeChuteira = new Arraylist<Chuteira>();
		for (int i=0;i<4;i++){
			Chuteira chuteira = new Chuteira(nomeCadastrado[i], marcaCadastrado[i],precoCadastrado[i],quantidadeCadastrado[i], corCadastrado[i],tipoCadastrado[i]);

			listaDeChuteira.add(chuteira);
		}
		return listaDeChuteira;
	}
	public void editar(Chuteira chuteira) {

		int num = 0;

		do {
			System.out.println("Selecione o que deseja alterar:\n"
					+ "1-Aterar o nome\n"
					+ "2-Aterar a marca\n"
					+ "3-Aterar o preco\n"
					+ "4-Aterar a quantidade\n"
					+ "5-Aterar a cor\n"
					+ "6-Aterar tipo(campo, society ou futsal)\n"
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
					System.out.println("Digite o tipo(campo, society ou futsal):\n");
					chuteira.setTipo(input.nextLine());
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
