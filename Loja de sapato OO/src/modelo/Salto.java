package modelo;

import java.util.ArrayList;

/**
 * Classe responsável por instanciar objetos do tipo Salto
 * @author Matheus Costa e Laura Pinos
 *
 */
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
	
	/**
	 * @deprecated
	 */
	@Override
	public String toString() {
		return "-Marca: " + marca + "\n-Preço R$ " + preco + "\n-Quantidade em estoque: "
				+ quantidade  + "\n-Cor: " + cor + "\n-Altura do salto (cm): " + tamDoSalto + 
				"\n-Tipo do salto: " + tipoDoSalto + "\n";
	}
	
	/**
	 * Variável do tipo ArrayList que vai armazenar todos os objetos do tipo Salto
	 */
	ArrayList<Salto> listaDeSalto = new ArrayList<Salto>();
	
	/**
	 * Cria objetos do tipo Salto que vão servir
	 * como dados cadastrados iniciais, e os adiciona no ArrayList
	 */
	public void preCadastrosSalto(){

		Salto salto1 = new Salto("Salto Loja Reversa", 309.90, 50, "Preta", 15, "grosso");
		Salto salto2 = new Salto("Salto Vizzano", 119.90, 50, "Rosa", 12, "tratorado");
		Salto salto3 = new Salto("Salto Aquazzura", 4084.99, 50, "Dourado", 10, "agulha");
		Salto salto4 = new Salto("Salto LE LIS BLANC", 195.96, 50, "Prata", 12, "fino");

		listaDeSalto.add(salto1);
		listaDeSalto.add(salto2);
		listaDeSalto.add(salto3);
		listaDeSalto.add(salto4);

	}
	
	/**
	 * Método que retorna um objeto Salto específico
	 * @param pos a posição do objeto específico no ArrayList
	 * @return um objeto Salto
	 */
	public Salto retornaSalto(int pos) {
		return listaDeSalto.get(pos);		
	}
	
	/**
	 * Adiciona um novo objeto Salto no ArrayList
	 * @param salto : objeto que será adicionado no ArrayList
	 */
	public void cadastrar(Salto salto) {
		listaDeSalto.add(salto);	
	}
	
	/**
	 * Busca pelo valor de um atributo específico de um
	 * objeto Salto, dentro do ArrayList
	 * @param pos : é a posição do objeto selecionado dentro do ArrayList
	 * @param info : é o parametro que indica qual valor será buscado
	 * @return uma variável String que recebe o valor buscado
	 */
	public String retornaDado(int pos, int info) {
		String dado = "";
		
		if(info == 1) {
			dado = listaDeSalto.get(pos).getMarca();
		}
		else if(info == 2) {
			dado = String.valueOf(listaDeSalto.get(pos).getPreco());
		}
		else if(info == 3) {
			dado = String.valueOf(listaDeSalto.get(pos).getQuantidade());
		}
		else if(info == 4) {
			dado = listaDeSalto.get(pos).getCor();
		}
		else if(info == 5) {
			dado = String.valueOf(listaDeSalto.get(pos).getTamDoSalto());
		}
		else if(info == 6) {
			dado = listaDeSalto.get(pos).getTipoDoSalto();
		}
		
		return dado;
	}
	
	/**
	 * Altera o valor de algum atributo de um objeto Salto já existente
	 * no ArrayList
	 * @param pos : é a posição do objeto selecionado dentro do ArrayList
	 * @param dado : o novo valor do atributo alterado
	 * @param info : é o parametro que indica qual valor será alterado
	 */
	public void editar(int pos, String dado, int info) {
		
		if(info == 1) {
			listaDeSalto.get(pos).setMarca(dado);
		}
		else if(info == 2) {
			listaDeSalto.get(pos).setPreco(Double.parseDouble(dado));
		}
		else if(info == 3) {
			listaDeSalto.get(pos).setQuantidade(Integer.parseInt(dado));
		}
		else if(info == 4) {
			listaDeSalto.get(pos).setCor(dado);
		}
		else if(info == 5) {
			listaDeSalto.get(pos).setTamDoSalto(Integer.parseInt(dado));
		}
		else if(info == 6) {
			listaDeSalto.get(pos).setTipoDoSalto(dado);
		}
		
	}
	
	/**
	 * Remove um objeto Salto presente no ArrayList
	 * @param n : é a posição em que o objeto a ser removido se encontra dentro do ArrayList
	 */
	public void deletar(int n) {
		listaDeSalto.remove(listaDeSalto.get(n));
	}
	
	/**
	 * Busca pelo nome da marca de cada objeto Salto armazenado
	 * no ArrayList e insere em um Array do tipo String
	 * @return um Array que armazena os nomes das marcas dos saltos
	 */
	public String[] listaNomesSapatos() {
		String[] listaNomes = new String[200];
		for(int i=0; i< listaDeSalto.size(); i++) {
			listaNomes[i] = listaDeSalto.get(i).getMarca();
		}
		return listaNomes;
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

}
