package lojadesapato;

public class Main {
	
	static void sleep(int seg) {
		// MÉTODO CRIADO PARA EVITAR A ESCRITA CONSTANTE DA LINHA DE CÓDIGO ABAIXO
		try { Thread.sleep(seg); } catch (InterruptedException ex) {}
	}
	
	// RECEBE UMA CHAR ESPECÍFICA PARA SER IMPRIMIDA NA TELA
	static void linhas(char linha) {
		for(int i = 0; i < 60; i++) {
			System.out.print(linha);		
		}
		System.out.println();
	}
	
	static void titulo(String titulo) {
//		MÉTODO QUE IMPRIME UM CABECALHO, ONDE O TÍTULO
//		É A STRING PASSADA COMO PARÂMETRO E CENTRALIZA
//		A STRING RECEBIDA DE ACORDO COM O SEU TAMANHO 
		int tam = 60 - titulo.length();
		
		linhas('=');
		for(int i = 0; i < (tam/2); i++) {
			System.out.print(" ");
		}
		System.out.println(titulo); 
		linhas('=');
	}

	public static void main(String[] args) {
		System.out.println("olá mundo");
	}

	//DADOS DOS CLIENTES

	public static ArrayList<Cliente> preencher(){
		String[]nomeCadastrado= {"Freddy Krueger","Michael Myers","Caleb Quinn" ,"Anna Bear", "Lisa Sherwood","Max Thompson Jr","Amanda Young","Kazan Yamaoka","Kenneth Chase","Philip Ojomo","Herman Carter","Sally Smithson"};
		String[]dtnascimentoCadastrado= {"02/09/1938","30/01/1962","09/10/1985","06/08/1974","13/04/1968","20/01/1998","07/08/1997","10/04/1999","25/11/1948","27/12/1967","02/07/2000","910/07/1974"};
		String[]cPFCadastrado= {"967.225.900-03","874.924.710-76","048.903.320-22","571.187.900-60","256.821.750-26","207.341.720-52","890.732.520-08","288.476.990-02","373.145.760-17","163.577.560-40","096.772.450-31","604.775.830-40"};
		String[]enderecoCadastrado= {"Elm Street, Escola Primaria de Badham","Haddonfield, Travessa Lampkin","Tumulo de Glenvale,Salao Dead Dawg","Floresta Vermelha, Refugio da Cacadora","Pantano do Remanso, Despensa Cruel","Fazenda Coldwind, Abatedouro Asqueroso","Fabrica de Embalagem de Carnes Gideon","Propriedade dos Yamaoka,Santuario da Ira","Hospicio Crotus Prenn,Capela do Padre Campbell","Ferro Velho Autohaven, Abrigo Sangrento","Instituto Memorial Lery,Centro de Tratamento","Hospicio Crotus Prenn, Enfermeira Conturbada"};
		String[]CEPCadastrado= {"61942-330","69265-970","78659-970","98385-970","71258-135","58475-972","79442-970","76940-970","72545-509","35200-970","68633-971","45657-308"};
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

}
