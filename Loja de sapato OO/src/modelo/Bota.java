package modelo;

import java.util.ArrayList;

/**
 * Classe responsável por instanciar objetos do tipo Bota
 * @author Matheus Costa e Laura Pinos
 *
 */
public class Bota extends Sapato{
	private String cano;
	private String genero;
	
	public Bota() {
		
	}
	
	public Bota(String m, double p, int q, String c, String ca, String g) {
		this.marca = m;
		this.preco = p;
		this.quantidade = q;
		this.cor = c;
		cano = ca;
		genero = g;
	}
	
	/**
	 * @deprecated
	 */
	@Override
	public String toString() {
		return "-Marca: " + marca + "\n-Preço R$ " + preco + "\n-Quantidade em estoque: "
				+ quantidade  + "\n-Cor: " + cor + "\n-Gênero: " + genero +
				"\n-Altura do cano: " + cano + "\n";
	}
	
	/**
	 * Variável do tipo ArrayList que vai armazenar todos os objetos do tipo Bota
	 */
	ArrayList<Bota> listaDeBota = new ArrayList<Bota>();
	
	/**
	 * Cria objetos do tipo Bota que vão servir
	 * como dados cadastrados iniciais, e os adiciona no ArrayList
	 */
	public void preCadastrosBota(){
		
		Bota bota1 = new Bota("MADALE", 199.60, 10, "Preto", "alto", "feminino");
		Bota bota2 = new Bota("WorldColors", 89.90, 5, "Transparente", "alto", "infantil");
		Bota bota3 = new Bota("Tricae", 35.99, 13, "Branco", "alto", "infantil");
		Bota bota4 = new Bota("MADALE", 194.90, 10, "Marrom", "alto", "masculino");
		
		listaDeBota.add(bota1);
		listaDeBota.add(bota2);
		listaDeBota.add(bota3);
		listaDeBota.add(bota4);

	}
	
	/**
	 * Adiciona um novo objeto Bota no ArrayList
	 * @param bota : objeto que será adicionado no ArrayList
	 */
	public void cadastrar(Bota bota) {
		listaDeBota.add(bota);
	}
	
	/**
	 * Busca pelo valor de um atributo específico de um
	 * objeto Bota, dentro do ArrayList
	 * @param pos : é a posição do objeto selecionado dentro do ArrayList
	 * @param info : é o parametro que indica qual valor será buscado
	 * @return uma variável String que recebe o valor buscado
	 */
	public String retornaDado(int pos, int info) {
		String dado = "";
		
		if(info == 1) {
			dado = listaDeBota.get(pos).getMarca();
		}
		else if(info == 2) {
			dado = String.valueOf(listaDeBota.get(pos).getPreco());
		}
		else if(info == 3) {
			dado = String.valueOf(listaDeBota.get(pos).getQuantidade());
		}
		else if(info == 4) {
			dado = listaDeBota.get(pos).getCor();
		}
		else if(info == 5) {
			dado = listaDeBota.get(pos).getCano();
		}
		else if(info == 6) {
			dado = listaDeBota.get(pos).getGenero();
		}
		
		return dado;
	}
	
	/**
	 * Altera o valor de algum atributo de um objeto Bota já existente
	 * no ArrayList
	 * @param pos : é a posição do objeto selecionado dentro do ArrayList
	 * @param dado : o novo valor do atributo alterado
	 * @param info : é o parametro que indica qual valor será alterado
	 */
	public void editar(int pos, String dado, int info) {
		
		if(info == 1) {
			listaDeBota.get(pos).setMarca(dado);
		}
		else if(info == 2) {
			listaDeBota.get(pos).setPreco(Double.parseDouble(dado));
		}
		else if(info == 3) {
			listaDeBota.get(pos).setQuantidade(Integer.parseInt(dado));
		}
		else if(info == 4) {
			listaDeBota.get(pos).setCor(dado);
		}
		else if(info == 5) {
			listaDeBota.get(pos).setCano(dado);
		}
		else if(info == 6) {
			listaDeBota.get(pos).setGenero(dado);
		}
	}
	
	/**
	 * Remove um objeto Bota presente no ArrayList
	 * @param n : é a posição em que o objeto a ser removido se encontra dentro do ArrayList
	 */
	public void deletar(int n) {
		listaDeBota.remove(listaDeBota.get(n));
	}
	
	/**
	 * Busca pelo nome da marca de cada objeto Bota armazenado
	 * no ArrayList e insere em um Array do tipo String
	 * @return um Array que armazena os nomes das marcas das botas
	 */
	public String[] listaNomesSapatos() {
		String[] listaNomes = new String[200];
		for(int i=0; i< listaDeBota.size(); i++) {
			listaNomes[i] = listaDeBota.get(i).getMarca();
		}
		return listaNomes;
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
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getCano() {
		return cano;
	}
	public void setCano(String cano) {
		this.cano = cano;
	}

}