package modelo;
import java.util.*;

public class Cliente {
	private String nome;
	private String dtNascimento;
	private String cPF;
	private Endereco endereco;
	private Telefone telefone;
	
	public Cliente() {

	}
	
	
	public Cliente(String n, String dt, String _cpf, Endereco e, Telefone t) {
		nome = n;
		dtNascimento = dt;
		cPF = _cpf;
		endereco = e;
		telefone = t;
	}
	
	@Override
	public String toString() {
		return "-Nome do cliente: " + nome + "\n-CPF: " + cPF + "\n-Data de nascimento: "
				+ dtNascimento + "\n-Endereço: " + endereco.toString() + "\n-Telefone: "+
				telefone.toString() +"\n";
	}
	
	ArrayList<Cliente> listaDeCliente = new ArrayList<Cliente>();

	
	public void preCadastrosCliente(){
		Endereco end1 = new Endereco("Gama", "Brasília", "DF");
		Endereco end2 = new Endereco("Gama", "Brasília", "DF");
		
		Telefone tel1 = new Telefone(61, 76842637);
		Telefone tel2 = new Telefone(61, 992434155);
		
		Cliente cliente1 = new Cliente("Laura", "29/08/00", "19009090100", end1, tel1);
		Cliente cliente2 = new Cliente("Matheus", "02/01/01", "19009333100", end2, tel2);
		
		listaDeCliente.add(cliente1);
		listaDeCliente.add(cliente2);
		
	}
	
	public void cadastrar(Cliente cliente) {
		listaDeCliente.add(cliente);
	}
	
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
	
	
//	public void visualizar() {
//		int modo;
//		
//		do {
//			boolean check = false;
//			System.out.println("Deseja visualizar por:"
//					+ "\n1- Nome"
//					+ "\n2- CPF"
//					+ "\n3- Sair da visualização");
//			System.out.print(">> ");
//			modo = ler.nextInt();
//			ler.nextLine();
//			
//			
//			if(modo == 1) {
//				String nome;
//				System.out.print("\nInforme o nome completo do cliente: ");
//				nome = ler.nextLine();
//				
//				for(int i=0; i<listaDeCliente.size(); i++) {
//					if(nome.equals(listaDeCliente.get(i).getNome())){
//						check = true;
//						System.out.println();
//						System.out.println(listaDeCliente.get(i).toString());
//						break;
//					}
//				}
//				
//				if(!check) {
//					System.out.println("Cliente não encontrado!\n");
//				}
//			}
//			else if(modo == 2) {
//				String cpf;
//				System.out.print("\nInforme o CPF (apenas números): ");
//				cpf = ler.nextLine();
//				
//
//				for(int i=0; i<listaDeCliente.size(); i++) {
//					if(cpf.equals(listaDeCliente.get(i).getcPF())) {
//						check = true;
//						System.out.println();
//						System.out.println(listaDeCliente.get(i).toString());
//					}
//				}
//				if(!check) {
//					System.out.println("Cliente não encontrado!\n");
//				}
//			}
//			else if(modo == 3) {
//				System.out.println("\nEncerrando visualização...");
//				break;
//			}
//			else {
//				System.out.println("Opção inválida!");
//			}
//			
//		}while(modo != 3);
//	}
	
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
	
	public void deletar(int n) {
		listaDeCliente.remove(listaDeCliente.get(n));
	}

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
	
}
