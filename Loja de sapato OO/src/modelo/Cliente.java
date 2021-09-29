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
	private String[] listaNomes = new String[200];
	
	public void preCadastrosCliente(){
		Endereco end1 = new Endereco("Gama", "Brasília", "DF");
		Endereco end2 = new Endereco("Gama", "Brasília", "DF");
		
		Telefone tel1 = new Telefone("61", "76842637");
		Telefone tel2 = new Telefone("61", "992434155");
		
		Cliente cliente1 = new Cliente("Laura", "29/08/00", "19009090100", end1, tel1);
		Cliente cliente2 = new Cliente("Matheus", "02/01/01", "19009333100", end2, tel2);
		
		listaDeCliente.add(cliente1);
		listaDeCliente.add(cliente2);
		
	}
	
	Scanner ler = new Scanner (System.in);
	
	public String retornaDado(int pos, int dado) {
		if(dado == 1) return listaDeCliente.get(pos).getNome();
	}
	
	public void cadastrar(Cliente cliente) {
		String nome, dtNasc, cpf;
		Endereco ender = new Endereco();
		Telefone tel = new Telefone();
				
//		System.out.print("Nome do cliente: ");
//		nome = ler.nextLine();
//		System.out.print("CPF do cliente (apenas números): ");
//		cpf = ler.nextLine();
//		System.out.print("Data de nascimento (DD/MM/AA): ");
//		dtNasc = ler.nextLine();
//		System.out.print("Endereço: ");
//		ender.setEndereco(ler.nextLine());
//		System.out.print("Cidade: ");
//		ender.setCidade(ler.nextLine());
//		System.out.print("Estado (UF): ");
//		ender.setEstado(ler.nextLine());
//		System.out.print("DDD do telefone: ");
//		tel.setdDD(ler.nextLine());
//		System.out.print("Número de telefone: ");
//		tel.setNumero(ler.nextLine());
		
		//Cliente cliente = new Cliente(nome, dtNasc, cpf, ender, tel);
		listaDeCliente.add(cliente);
		
		//System.out.printf("Novo cliente '%s' cadastrado com sucesso!\n", nome);
		
	}
	
	public void visualizar() {
		int modo;
		
		do {
			boolean check = false;
			System.out.println("Deseja visualizar por:"
					+ "\n1- Nome"
					+ "\n2- CPF"
					+ "\n3- Sair da visualização");
			System.out.print(">> ");
			modo = ler.nextInt();
			ler.nextLine();
			
			
			if(modo == 1) {
				String nome;
				System.out.print("\nInforme o nome completo do cliente: ");
				nome = ler.nextLine();
				
				for(int i=0; i<listaDeCliente.size(); i++) {
					if(nome.equals(listaDeCliente.get(i).getNome())){
						check = true;
						System.out.println();
						System.out.println(listaDeCliente.get(i).toString());
						break;
					}
				}
				
				if(!check) {
					System.out.println("Cliente não encontrado!\n");
				}
			}
			else if(modo == 2) {
				String cpf;
				System.out.print("\nInforme o CPF (apenas números): ");
				cpf = ler.nextLine();
				

				for(int i=0; i<listaDeCliente.size(); i++) {
					if(cpf.equals(listaDeCliente.get(i).getcPF())) {
						check = true;
						System.out.println();
						System.out.println(listaDeCliente.get(i).toString());
					}
				}
				if(!check) {
					System.out.println("Cliente não encontrado!\n");
				}
			}
			else if(modo == 3) {
				System.out.println("\nEncerrando visualização...");
				break;
			}
			else {
				System.out.println("Opção inválida!");
			}
			
		}while(modo != 3);
	}
	
	public void editar(int n) {
		int num = 0;
		String nome = listaDeCliente.get(n).getNome();
		
		System.out.println("\n<<Alterar dados de '" + nome + "'>>");

		do {
			System.out.println("\nSelecione o que deseja alterar:"
					+ "\n1- Nome do cliente (Atual: "+listaDeCliente.get(n).getNome()+")"
					+ "\n2- CPF do cliente (Atual: "+listaDeCliente.get(n).getcPF()+")"
					+ "\n3- Data de nascimento (Atual: "+listaDeCliente.get(n).getDtNascimento()+")"
					+ "\n4- Endereço (Atual: "+listaDeCliente.get(n).getEndereco().toString()+")"
					+ "\n5- Telefone (Atual: "+listaDeCliente.get(n).getTelefone().toString()+")"
					+ "\n6- Sair");
			System.out.print(">> ");
			num = ler.nextInt();
			ler.nextLine();

			switch (num) {
				case 1:
					System.out.println("\nNovo nome do cliente: ");
					listaDeCliente.get(n).setNome(ler.nextLine());
					break;
				case 2:
					System.out.println("\nInforme o novo CPF: ");
					listaDeCliente.get(n).setcPF(ler.nextLine());;
					break;
				case 3:
					System.out.println("\nNova data de nascimento (DD/MM/AA): ");
					listaDeCliente.get(n).setDtNascimento(ler.nextLine());
					break;
				case 4:
					System.out.println("\nNovo enderço: ");
					listaDeCliente.get(n).endereco.setEndereco(ler.nextLine());
					System.out.println("\nNova cidade: ");
					listaDeCliente.get(n).endereco.setCidade(ler.nextLine());
					System.out.println("\nNovo estado (UF): ");
					listaDeCliente.get(n).endereco.setEstado(ler.nextLine());
					break;
				case 5:
					System.out.println("\nNovo DDD: ");
					listaDeCliente.get(n).telefone.setdDD(ler.nextLine());
					System.out.println("\nNovo número: ");
					listaDeCliente.get(n).telefone.setNumero(ler.nextLine());
					break;
				case 6:
					System.out.println("Retornando ao menu...\n");
					break;
				default:
					System.out.println("Opção inválida!\n");
					break;

			}
		} while (num != 6);

	}
	
	public void deletar(int n) {
		System.out.printf("Cliente '%s' deletado com sucesso!\n", listaDeCliente.get(n).getNome());
		listaDeCliente.remove(listaDeCliente.get(n));
	}

	public String[] listaNomesClientes() {
		//preCadastrosCliente();
		for(int i=0; i< listaDeCliente.size(); i++) {
			listaNomes[i] = listaDeCliente.get(i).getNome();
		}
		return listaNomes;
	}
	
	public int selecionaCliente() {
		int num;
		
		System.out.println("\nLista de clientes:");
		for(int i=0; i<listaDeCliente.size(); i++) {
			System.out.println("" + (i+1) + "- " +  listaDeCliente.get(i).getNome());
		}
		
		do {
			System.out.print("\nSelecione um cliente: ");
			num = ler.nextInt();
			
			if(num < 1 || num > listaDeCliente.size())
				System.out.println("Opção inválida, informe novamente.");
			
		}while (num < 1 || num > listaDeCliente.size());
		
		return num;
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