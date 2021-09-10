package lojadesapato;
import java.util.*;

public class Cliente {
	private String nome;
	private Date dtNascimento;
	private int cPF;// mudar pra String
	private Endereco endereco;
	private Telefone telefone;
	
	public Cliente(String n, Date dt, int _cpf, Endereco e, Telefone t) {
		nome = n;
		dtNascimento = dt; // DateFormat dfm = DateFormat.getDateInstance(DateFormat.MEDIUM);
		//System.out.println(dfm.format(data)); // 14/03/2016
		cPF = _cpf;
		endereco = e;
		telefone = t;
	}
	
	// PRECISA DOS CRUDs
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public int getcPF() {
		return cPF;
	}
	public void setcPF(int cPF) {
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
	
	public static ArrayList<Cliente> preencher(){
		String[]nomeCadastrado= {"Freddy Krueger","Michael Myers","Caleb Quinn" ,"Anna Bear", "Lisa Sherwood","Max Thompson Jr","Amanda Young","Kazan Yamaoka","Kenneth Chase","Philip Ojomo","Herman Carter","Sally Smithson"};
		Date[]dtnascimentoCadastrado= {"02/09/1938","30/01/1962","09/10/1985","06/08/1974","13/04/1968","20/01/1998","07/08/1997","10/04/1999","25/11/1948","27/12/1967","02/07/2000","910/07/1974"};
		String[]cPFCadastrado= {"96722590003","87492471076","04890332022","57118790060","25682175026","20734172052","89073252008","28847699002","37314576017","16357756040","09677245031","60477583040"};
		String[]enderecoCadastrado= {"Elm Street, Escola Primaria de Badham","Haddonfield, Travessa Lampkin","Tumulo de Glenvale,Salao Dead Dawg","Floresta Vermelha, Refugio da Cacadora","Pantano do Remanso, Despensa Cruel","Fazenda Coldwind, Abatedouro Asqueroso","Fabrica de Embalagem de Carnes Gideon","Propriedade dos Yamaoka,Santuario da Ira","Hospicio Crotus Prenn,Capela do Padre Campbell","Ferro Velho Autohaven, Abrigo Sangrento","Instituto Memorial Lery,Centro de Tratamento","Hospicio Crotus Prenn, Enfermeira Conturbada"};
		String[]CEPCadastrado= {"61942330","69265970","78659970","98385970","71258135","58475972","79442970","76940970","72545509","35200970","68633971","45657308"};
		String[]bairroCadastrado= {"Outra Banda","Centro","Centro Metropolitano","Areal","Setor Norte (Vila Estrutural - Guará)","Mandacaru","Bom Fim","Cruzeiro","Vargem","Centro A","Interlagos","Lourdes"};
		String[]numeroCadastrado= {"20","547","68","32","785","346","81","1242","5789","101","13","1501"};
		String[]cidadeCadastrado= {"Maranguape","Apuí","Nova Primavera","Dois Irmãos das Missões","Brasília","Queimadas","Bom Fim","Rolim de Moura","Santa Maria","Aimorés","Dom Eliseu","Ilhéus"};
		String[]estadoCadastrado= {"CE","AM","MT","RS","DF","PB","MS","BA","DF","MG","PA","BA"};
		String[]telefoneCadastrado= {"954214507","945874632","985652366","987452136","985846521","963625415","912451232","985263140","915487542","926598653","931649746","939281795"};
		String[]dDDCadastrado= {"92","68","65","27","41","53","49","61","41","77","34","68"};

		ArrayList<Cliente> listaDeCliente = new Arraylist<Cliente>();
		for (int i=0;i<12;i++){
			Cliente cliente = new Cliente(nomeCadastrado[i],dtnascimentoCadastrado[i],cPFCadastrado[i], enderecoCadastrado[i],CEPCadastrado[i],bairroCadastrado[i],numeroCadastrado[i],cidadeCadastrado[i],estadoCadastrado[i],telefoneCadastrado[i],dDDCadastrado[i]);

			listaDeCliente.add(cliente);
		}
		return listaDeCliente;
	}
	// FUNCOES RELACIONADAS AO CLIENTE

	public static ArrayList<Cliente> cadastraCliente(ArrayList<Cliente> listaDeCliente, String nome, Date dtnascimento, String cPF, String endereco, String CEP, String bairro,int numero, String cidade, String estado, String telefone, String dDD) {
		Cliente novoCliente= new Cliente(nome,dtnascimento,cPF, endereco,CEP,bairro,numero, cidade, estado,telefone,dDD);
		listaDeCliente.add(novoCliente);
		return listaDeCliente;
	}
}
//Dados dos Clientes
	public static ArrayList<Cliente> preencher(){
		String[]nomeCadastrado= {"Freddy Krueger","Michael Myers","Caleb Quinn" ,"Anna Bear", "Lisa Sherwood","Max Thompson Jr","Amanda Young","Kazan Yamaoka","Kenneth Chase","Philip Ojomo","Herman Carter","Sally Smithson"};
		Date[]dtnascimentoCadastrado= {"02/09/1938","30/01/1962","09/10/1985","06/08/1974","13/04/1968","20/01/1998","07/08/1997","10/04/1999","25/11/1948","27/12/1967","02/07/2000","910/07/1974"};
		String[]cPFCadastrado= {"96722590003","87492471076","04890332022","57118790060","25682175026","20734172052","89073252008","28847699002","37314576017","16357756040","09677245031","60477583040"};
		String[]enderecoCadastrado= {"Elm Street, Escola Primaria de Badham","Haddonfield, Travessa Lampkin","Tumulo de Glenvale,Salao Dead Dawg","Floresta Vermelha, Refugio da Cacadora","Pantano do Remanso, Despensa Cruel","Fazenda Coldwind, Abatedouro Asqueroso","Fabrica de Embalagem de Carnes Gideon","Propriedade dos Yamaoka,Santuario da Ira","Hospicio Crotus Prenn,Capela do Padre Campbell","Ferro Velho Autohaven, Abrigo Sangrento","Instituto Memorial Lery,Centro de Tratamento","Hospicio Crotus Prenn, Enfermeira Conturbada"};
		String[]CEPCadastrado= {"61942330","69265970","78659970","98385970","71258135","58475972","79442970","76940970","72545509","35200970","68633971","45657308"};
		String[]bairroCadastrado= {"Outra Banda","Centro","Centro Metropolitano","Areal","Setor Norte (Vila Estrutural - Guará)","Mandacaru","Bom Fim","Cruzeiro","Vargem","Centro A","Interlagos","Lourdes"};
		int[]numeroCadastrado= {"20","547","68","32","785","346","81","1242","5789","101","13","1501"};
		String[]cidadeCadastrado= {"Maranguape","Apuí","Nova Primavera","Dois Irmãos das Missões","Brasília","Queimadas","Bom Fim","Rolim de Moura","Santa Maria","Aimorés","Dom Eliseu","Ilhéus"};
		String[]estadoCadastrado= {"CE","AM","MT","RS","DF","PB","MS","BA","DF","MG","PA","BA"};
		String[]telefoneCadastrado= {"954214507","945874632","985652366","987452136","985846521","963625415","912451232","985263140","915487542","926598653","931649746","939281795"};
		String[]dDDCadastrado= {"92","68","65","27","41","53","49","61","41","77","34","68"};

		ArrayList<Cliente> listaDeCliente = new Arraylist<Cliente>();
		for (int i=0;i<12;i++){
			Cliente cliente = new Cliente(nomeCadastrado[i],dtnascimentoCadastrado[i],cPFCadastrado[i], enderecoCadastrado[i],CEPCadastrado[i],bairroCadastrado[i],numeroCadastrado[i],cidadeCadastrado[i],estadoCadastrado[i],telefoneCadastrado[i],dDDCadastrado[i]);

			listaDeCliente.add(cliente);
		}
		return listaDeCliente;
	}
	// FUNCOES RELACIONADAS AO CLIENTE

	public static ArrayList<Cliente> cadastraCliente(ArrayList<Cliente> listaDeCliente, String nome, Date dtnascimento, String cPF, String endereco, String CEP, String bairro,int numero, String cidade, String estado, String telefone, String dDD) {
		Cliente novoCliente= new Cliente(nome,dtnascimento,cPF, endereco,CEP,bairro,numero, cidade, estado,telefone,dDD);
		listaDeCliente.add(novoCliente);
		return listaDeCliente;
	}