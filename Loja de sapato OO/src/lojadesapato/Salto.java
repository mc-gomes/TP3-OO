package lojadesapato;

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

	public static ArrayList<Salto> preencher(){
		String[]marcaCadastrado= {"Bella Chic Shoes","Vizzano","V. STYLO" ,"Amorelle"};
		Double[]precoCadastrado= {"129.90","84.99","64.90","154.99"};
		int[]quantidadeCadastrado= {5,5,5,5};
		String[]corCadastrado= {"preto e dourado","nude","branco","branco e dourado"};
		int[]tamDoSaltoCadastrado= {5,14,12,10};
		String[]tipoDoSaltoCadastrado= {"salto tratorado","salto grosso","salto agulha","salto quadrado"};


		ArrayList<Salto> listaDeSalto = new Arraylist<Salto>();
		for (int i=0;i<4;i++){
			Salto salto = new Salto(nomeCadastrado[i], marcaCadastrado[i],precoCadastrado[i],quantidadeCadastrado[i], corCadastrado[i],tamDoSaltoCadastrado[i],tipoDoSaltoCadastrado[i]);

			listaDeSalto.add(salto);
		}
		return listaDeSalto;
	}
}
