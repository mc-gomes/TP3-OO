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
	
	ArrayList<Cliente> listaDeCliente = new ArrayList<Cliente>();
	Scanner ler = new Scanner (System.in);
	
	public void cadastrar() {
		String nome, dtNasc, cpf;
		Endereco ender = new Endereco();
		Telefone tel = new Telefone();
				
		System.out.print("Nome do cliente: ");
		nome = ler.nextLine();
		System.out.print("Data de nascimento (D/M/AA): ");
		dtNasc = ler.nextLine();
		System.out.print("Informe o CPF: ");
		cpf = ler.nextLine();
		System.out.print("Endereço: ");
		ender.setEndereco(ler.nextLine());
		System.out.print("Cidade: ");
		ender.setCidade(ler.nextLine());
		System.out.print("Estado: ");
		ender.setEstado(ler.nextLine());
		System.out.print("DDD do telefone: ");
		tel.setdDD(ler.nextLine());
		System.out.print("Número de telefone: ");
		tel.setNumero(ler.nextLine());
		
		Cliente cliente = new Cliente(nome, dtNasc, cpf, ender, tel);
		listaDeCliente.add(cliente);
		
	}
	
	//Dados dos Clientes
//	public ArrayList<Cliente> preencher(){
//		String[]nomeCadastrado= {"Freddy Krueger","Michael Myers","Caleb Quinn" ,"Anna Bear", "Lisa Sherwood","Max Thompson Jr","Amanda Young","Kazan Yamaoka","Kenneth Chase","Philip Ojomo","Herman Carter","Sally Smithson"};
//		String[]dtnascimentoCadastrado= {"02/09/1938","30/01/1962","09/10/1985","06/08/1974","13/04/1968","20/01/1998","07/08/1997","10/04/1999","25/11/1948","27/12/1967","02/07/2000","910/07/1974"};
//		String[]cPFCadastrado= {"96722590003","87492471076","04890332022","57118790060","25682175026","20734172052","89073252008","28847699002","37314576017","16357756040","09677245031","60477583040"};
//		String[]enderecoCadastrado= {"Elm Street, Escola Primaria de Badham","Haddonfield, Travessa Lampkin","Tumulo de Glenvale,Salao Dead Dawg","Floresta Vermelha, Refugio da Cacadora","Pantano do Remanso, Despensa Cruel","Fazenda Coldwind, Abatedouro Asqueroso","Fabrica de Embalagem de Carnes Gideon","Propriedade dos Yamaoka,Santuario da Ira","Hospicio Crotus Prenn,Capela do Padre Campbell","Ferro Velho Autohaven, Abrigo Sangrento","Instituto Memorial Lery,Centro de Tratamento","Hospicio Crotus Prenn, Enfermeira Conturbada"};
//		String[]CEPCadastrado= {"61942330","69265970","78659970","98385970","71258135","58475972","79442970","76940970","72545509","35200970","68633971","45657308"};
//		String[]bairroCadastrado= {"Outra Banda","Centro","Centro Metropolitano","Areal","Setor Norte (Vila Estrutural - Guará)","Mandacaru","Bom Fim","Cruzeiro","Vargem","Centro A","Interlagos","Lourdes"};
//		int[]numeroCadastrado= {20,547,68,32,785,346,81,1242,5789,101,13,1501};
//		String[]cidadeCadastrado= {"Maranguape","Apuí","Nova Primavera","Dois Irmãos das Missões","Brasília","Queimadas","Bom Fim","Rolim de Moura","Santa Maria","Aimorés","Dom Eliseu","Ilhéus"};
//		String[]estadoCadastrado= {"CE","AM","MT","RS","DF","PB","MS","BA","DF","MG","PA","BA"};
//		String[]telefoneCadastrado= {"954214507","945874632","985652366","987452136","985846521","963625415","912451232","985263140","915487542","926598653","931649746","939281795"};
//		String[]dDDCadastrado= {"92","68","65","27","41","53","49","61","41","77","34","68"};
//
//		for (int i=0;i<12;i++){
//			Cliente cliente = new Cliente(nomeCadastrado[i],dtnascimentoCadastrado[i],cPFCadastrado[i], enderecoCadastrado[i],CEPCadastrado[i],bairroCadastrado[i],numeroCadastrado[i],cidadeCadastrado[i],estadoCadastrado[i],telefoneCadastrado[i],dDDCadastrado[i]);
//
//			listaDeCliente.add(cliente);
//		}
//		return listaDeCliente;
//	}
//		
//	// FUNCOES RELACIONADAS AO CLIENTE
//	public static ArrayList<Cliente> cadastraCliente(ArrayList<Cliente> listaDeCliente, String nome, Date dtnascimento, String cPF, String endereco, String CEP, String bairro,int numero, String cidade, String estado, String telefone, String dDD) {
//		Cliente novoCliente= new Cliente(nome,dtnascimento,cPF, endereco,CEP,bairro,numero, cidade, estado,telefone,dDD);
//		listaDeCliente.add(novoCliente);
//		return listaDeCliente;
//	}
	
	
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
