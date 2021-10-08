package modelo;

import java.util.ArrayList;

/**
 * Classe responsável por instanciar objetos do tipo Chuteira
 * @author Matheus Costa e Laura Pinos
 *
 */
public class Chuteira extends Sapato{
	private String nome;
	private String tipo;
	private String cano;
	
	public Chuteira() {
		
	}
	
	public Chuteira(String n, String m, double p, int q,  String c, String t, String ca) {
		nome = n;
		this.marca = m;
		this.preco = p;
		this.quantidade = q;
		this.cor = c;
		tipo = t;
		cano = ca;
	}
	
	/**
	 * @deprecated
	 */
	@Override
	public String toString() {
		return "-Nome da chuteira: " + nome + "\n-Marca: " + marca + "\n-Tipo: " + tipo +
				"\n-Preço R$ " + preco + "\n-Quantidade em estoque: " + quantidade  +
				"\n-Cor: " + cor + "\n-Altura do cano: " + cano + "\n";
	}
	
	/**
	 * Variável do tipo ArrayList que vai armazenar todos os objetos do tipo Chuteira
	 */
	ArrayList<Chuteira> listaDeChuteira = new ArrayList<Chuteira>();
	
	/**
	 * Cria objetos do tipo Chuteira que vão servir
	 * como dados cadastrados iniciais, e os adiciona no ArrayList
	 */
	public void preCadastrosChuteira(){
		
		Chuteira chuteira1 = new Chuteira("Beco 2 TF", "Nike", 139.90, 50, "Vermelha", "Society", "baixo");
		Chuteira chuteira2 = new Chuteira("Predator 19.4", "Adidas", 139.90, 50, "Preta", "Campo", "alto");
		Chuteira chuteira3 = new Chuteira("Morelia Club IN", "Mizuno", 109.99, 50, "Preta", "Futsal", "baixo");
		Chuteira chuteira4 = new Chuteira("Deportivo", "Adidas", 169.99, 50, "Verde", "Futsal", "baixo");
		
		listaDeChuteira.add(chuteira1);
		listaDeChuteira.add(chuteira2);
		listaDeChuteira.add(chuteira3);
		listaDeChuteira.add(chuteira4);	

	}
	
	/**
	 * Método que retorna um objeto Chuteira específico
	 * @param pos a posição do objeto específico no ArrayList
	 * @return um objeto Chuteira
	 */
	public Chuteira retornaChuteira(int pos) {
		return listaDeChuteira.get(pos);		
	}
	
	/**
	 * Adiciona um novo objeto Chuteira no ArrayList
	 * @param chuteira : objeto que será adicionado no ArrayList
	 */
	public void cadastrar(Chuteira chuteira) {
		listaDeChuteira.add(chuteira);	
	}
	
	/**
	 * Busca pelo valor de um atributo específico de um
	 * objeto Chuteira, dentro do ArrayList
	 * @param pos : é a posição do objeto selecionado dentro do ArrayList
	 * @param info : é o parametro que indica qual valor será buscado
	 * @return uma variável String que recebe o valor buscado
	 */
	public String retornaDado(int pos, int info) {
		String dado = "";
		
		if(info == 1) {
			dado = listaDeChuteira.get(pos).getNome();
		}
		else if(info == 2) {
			dado = listaDeChuteira.get(pos).getMarca();
		}
		else if(info == 3) {
			dado = String.valueOf(listaDeChuteira.get(pos).getPreco());
		}
		else if(info == 4) {
			dado = String.valueOf(listaDeChuteira.get(pos).getQuantidade());
		}
		else if(info == 5) {
			dado = listaDeChuteira.get(pos).getCor();
		}
		else if(info == 6) {
			dado = listaDeChuteira.get(pos).getCano();
		}
		else if(info == 7) {
			dado = listaDeChuteira.get(pos).getTipo();
		}
		
		return dado;
	}
	
	/**
	 * Altera o valor de algum atributo de um objeto Chuteira já existente
	 * no ArrayList
	 * @param pos : é a posição do objeto selecionado dentro do ArrayList
	 * @param dado : o novo valor do atributo alterado
	 * @param info : é o parametro que indica qual valor será alterado
	 */
	public void editar(int pos, String dado, int info) {
		
		if(info == 1) {
			listaDeChuteira.get(pos).setMarca(dado);
		}
		else if(info == 2) {
			listaDeChuteira.get(pos).setPreco(Double.parseDouble(dado));
		}
		else if(info == 3) {
			listaDeChuteira.get(pos).setQuantidade(Integer.parseInt(dado));
		}
		else if(info == 4) {
			listaDeChuteira.get(pos).setCor(dado);
		}
		else if(info == 5) {
			listaDeChuteira.get(pos).setCano(dado);
		}
		else if(info == 6) {
			listaDeChuteira.get(pos).setTipo(dado);
		}
		
	}
	
	/**
	 * Remove um objeto Chuteira presente no ArrayList
	 * @param n : é a posição em que o objeto a ser removido se encontra dentro do ArrayList
	 */
	public void deletar(int n) {
		listaDeChuteira.remove(listaDeChuteira.get(n));
	}

	/**
	 * Busca pelo nome da marca de cada objeto Chuteira armazenado
	 * no ArrayList e insere em um Array do tipo String
	 * @return um Array que armazena os nomes das chuteiras
	 */
	public String[] listaNomesSapatos() {
		String[] listaNomes = new String[200];
		for(int i=0; i< listaDeChuteira.size(); i++) {
			listaNomes[i] = listaDeChuteira.get(i).getNome();
		}
		return listaNomes;
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

	public String getCano() {
		return cano;
	}

	public void setCano(String cano) {
		this.cano = cano;
	}

	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
