package modelo;
import java.util.*;

import javax.swing.JOptionPane;

/**
 * Classe responsável por instanciar objetos do tipo Cliente
 * @author Matheus Costa
 *
 */
public class Cliente {
	private String nome;
	private String dtNascimento;
	private String cPF;
	private Endereco endereco;
	private Telefone telefone;
	
	public Cliente() {

	}
	
	public Cliente(String n) {
		
	}

	public Cliente(String n, String _cpf ,String dt, Endereco e, Telefone t) {
		nome = n;
		cPF = _cpf;
		dtNascimento = dt;
		endereco = e;
		telefone = t;
	}
	
	
	/**
	 * @deprecated
	 */
	@Override
	public String toString() {
		return "-Nome do cliente: " + nome + "\n-CPF: " + cPF + "\n-Data de nascimento: "
				+ dtNascimento + "\n-Endereço: " + endereco.toString() + "\n-Telefone: "+
				telefone.toString() +"\n";
	}
	
	/**
	 * Variável do tipo ArrayList que vai armazenar todos os objetos do tipo Cliente
	 */
	ArrayList<Cliente> listaDeCliente = new ArrayList<Cliente>();

	/**
	 * Cria objetos do tipo Cliente que vão servir
	 * como dados cadastrados iniciais, e os adiciona no ArrayList
	 */
	public void preCadastrosCliente(){
		Endereco end1 = new Endereco("Gama", "Brasília", "DF");
		Endereco end2 = new Endereco("Gama", "Brasília", "DF");
		
		Telefone tel1 = new Telefone(61, 76842637);
		Telefone tel2 = new Telefone(61, 992434155);
		
		Cliente cliente1 = new Cliente("Laura", "19009090100", "29/08/00", end1, tel1);
		Cliente cliente2 = new Cliente("Matheus", "19009333100", "02/01/01", end2, tel2);
		
		listaDeCliente.add(cliente1);
		listaDeCliente.add(cliente2);
		
	}	
	
	public Cliente retornaCliente(int pos) {
		return listaDeCliente.get(pos);		
	}
	
	
	/**
	 * Busca por um cliente que possua um CPF igual ao número passado como parâmetro
	 * @param cpf : é o número que será comparado com os CPFs de todos os clientes cadastrados
	 * @return retorna a posição do cliente dentro do ArrayList, caso encontre um CPF igual ou 
	 * retorna -1, indicando que o CPF não foi encontrado
	 */
	public int posicaoClienteCPF(String cpf) {
		for(int i = 0; i < listaDeCliente.size(); i ++) {
			if(cpf.equals(listaDeCliente.get(i).getcPF().replaceAll("[\\D]", ""))) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Adiciona clientes sem nenhum dado no ArrayList até a posição do
	 * cliente com o CPF encontrado, para que haja uma lista com apenas
	 * o nome do cliente com o CPF. Depois insere em um Array do tipo
	 * String o nome do cliente encontrado.
	 * @param pos : posição, dentro do ArrayList, do cliente com o CPF encontrado
	 * @return um Array do tipo String com o nome do cliente
	 */
	public String[] buscarClienteCPF(int pos) {
		String[] listaNomes = new String[200];
		Cliente c = new Cliente("");
		for(int i =0; i< pos; i++) {
			listaDeCliente.add(c);
		}
		listaNomes[pos] = listaDeCliente.get(pos).getNome();
	
		return listaNomes;
	}
	
	/**
	 * Adiciona um novo objeto Cliente no ArrayList
	 * @param cliente : objeto que será adicionado no ArrayList
	 */
	public void cadastrar(Cliente cliente) {
		listaDeCliente.add(cliente);
	}
	
	/**
	 * Busca pelo valor de um atributo específico de um
	 * objeto Cliente, dentro do ArrayList
	 * @param pos : é a posição do objeto selecionado dentro do ArrayList
	 * @param info : é o parametro que indica qual valor será buscado
	 * @return uma variável String que recebe o valor buscado
	 */
	public String retornaDado(int pos, int info) {
		String dado = "";
		
		if(info == 1) {
			dado = listaDeCliente.get(pos).getNome();
		}
		else if(info == 2) {
			dado = listaDeCliente.get(pos).getcPF();
		}
		else if(info == 3) {
			dado = listaDeCliente.get(pos).getDtNascimento();
		}
		else if(info == 4) {
			dado = listaDeCliente.get(pos).getEndereco().getEndereco();
		}
		else if(info == 5) {
			dado = listaDeCliente.get(pos).getEndereco().getCidade();
		}
		else if(info == 6) {
			dado = listaDeCliente.get(pos).getEndereco().getEstado();
		}
		else if(info == 7) {
			dado = String.valueOf(listaDeCliente.get(pos).getTelefone().getdDD());
		}
		else if(info == 8) {
			dado = String.valueOf(listaDeCliente.get(pos).getTelefone().getNumero());
		}
		
		return dado;
	}
	
	/**
	 * Altera o valor de algum atributo de um objeto Cliente já existente
	 * no ArrayList
	 * @param pos : é a posição do objeto selecionado dentro do ArrayList
	 * @param dado : o novo valor do atributo alterado
	 * @param info : é o parametro que indica qual valor será alterado
	 */
	public void editar(int pos, String dado, int info) {
		
		if(info == 1) {
			listaDeCliente.get(pos).setNome(dado);
		}
		else if(info == 2) {
			listaDeCliente.get(pos).setcPF(dado);
		}
		else if(info == 3) {
			listaDeCliente.get(pos).setDtNascimento(dado);
		}
		else if(info == 4) {
			listaDeCliente.get(pos).getEndereco().setEndereco(dado);
		}
		else if(info == 5) {
			listaDeCliente.get(pos).getEndereco().setCidade(dado);
		}
		else if(info == 6) {
			listaDeCliente.get(pos).getEndereco().setEstado(dado);
		}
		else if(info == 7) {
			listaDeCliente.get(pos).getTelefone().setdDD(Integer.parseInt(dado));
		}
		else if(info == 8) {
			listaDeCliente.get(pos).getTelefone().setNumero(Integer.parseInt(dado));
		}
	}
	
	/**
	 * Remove um objeto Cliente presente no ArrayList
	 * @param n : é a posição em que o objeto a ser removido se encontra dentro do ArrayList
	 */
	public void deletar(int n) {
		listaDeCliente.remove(listaDeCliente.get(n));
	}
	
	/**
	 * Busca pelo nome de cada objeto Cliente armazenado
	 * no ArrayList e insere em um Array do tipo String
	 * @return um Array que armazena os nomes dos clientes
	 */
	public String[] listaNomesClientes() {
		String[] listaNomes = new String[200];
		for(int i=0; i< listaDeCliente.size(); i++) {
			listaNomes[i] = listaDeCliente.get(i).getNome();
		}
		return listaNomes;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public String getcPF() {
		return cPF;
	}
	public void setcPF(String cPF) {
		this.cPF = cPF;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Telefone getTelefone() {
		return telefone;
	}
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	
	public void clienteNaoEncontrado() {
		JOptionPane.showMessageDialog(null,"CLIENTE NÃO ENCONTRADO!\n "
                + "Não há nenhum cliente que possui o CPF indicado", null,
        JOptionPane.ERROR_MESSAGE);
	}
	
}
