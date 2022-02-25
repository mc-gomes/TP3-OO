package modelo;

/**
 * Classe que possui funções que verificam se os dados
 * informados estão em um formato válido
 * @author Matheus Costa e Laura Pinos
 *
 */
public class Validacao {

	/**
	 * Verifica se o CPF fornecido está num formato adequado. São realizadas as seguintes verificações:
	 * (1) se o CPF tem apenas 11 caracteres
	 * (2) se os caracteres numéricos não são todos repetidos
	 * (3) se há alguma letra no CPF informado
	 * (4) se há um CPF com todos os números repetidos
	 * @param cpf uma string que representa um CPF a ser verificado
	 * @return um boolean true ou false, a depender se passou em todos os testes ou não passou em pelo menos um
	 */
	public boolean validacaoCPF(String cpf) {
		
		// Tamanho da string de CPF
		if (cpf.length() != 11) 
			return false;
		
		// Verifica se existem ".", "-", "/" ou " " no CPF
		if (cpf.contains(".") && cpf.contains("-") && cpf.contains("/") && cpf.contains(" ")) 
			return false;
		
		// Verifica se há alguma letra no CPF
		for (int i = 0; i < cpf.length(); i++) {
		    char c = cpf.charAt(i);
		    if (!Character.isDigit(c)) {
		        return false;
		   }
		}
		
		// Verifica se o CPF não tem todos os números repetidos
		if (cpf.replaceAll("[\\D]", "").equals("00000000000") && cpf.replaceAll("[\\D]", "").equals("11111111111") &&
				cpf.replaceAll("[\\D]", "").equals("22222222222") && cpf.replaceAll("[\\D]", "").equals("33333333333") &&
				cpf.replaceAll("[\\D]", "").equals("44444444444") && cpf.replaceAll("[\\D]", "").equals("55555555555") &&
				cpf.replaceAll("[\\D]", "").equals("66666666666") && cpf.replaceAll("[\\D]", "").equals("77777777777") &&
				cpf.replaceAll("[\\D]", "").equals("88888888888") && cpf.replaceAll("[\\D]", "").equals("99999999999"))
			return false;
		
		return true;
	}
	
	/**
	 * Verifica se a data fornecida está num formato adequado. São realizadas as seguintes verificações:
	 * (1) se a data tem 10 caracteres (formato DD/MM/AAA)
	 * (2) se a data tem 8 caracteres (formato DDMMAAAA)
	 * (3) se há uma / na posição correta (formato DD/MM/AAA)
	 * (4) se o primeiro caractere de dias está entre 0 e 3
	 * (5) se o primeiro caracter de meses está entre 0 e 1
	 * (6) se o primeiro caractere de anos está entre 1 e 2
	 * (7) se os caracteres de dias estão entre 1 e 31
	 * (8) se os caracteres de meses estão entre 1 e 12
	 * (9) se os caracteres de ano estão entre 1900 e 2021
	 * @param data uma string que representa uma data a ser verificada
	 * @return um boolean true ou false, a depender se passou em todos os testes ou não passou em pelo menos um
	 */
	public boolean validacaoData(String data) {
		// Verifica se data tem 10 caracteres (formato DD/MM/AAA)
		if (data.length() != 10) { 
			return false;
		}
		
		// Verifica se tem 8 caracteres (formato DDMMAAAA)
		if (data.replaceAll("[\\D]", "").length() != 8) { 
			return false;
		}
		
		// Verifica se existem 2 "/" na posição correta (formato DD/MM/AAA)
		if (data.substring(2, 3).indexOf("/") != 0 || data.substring(5, 6).indexOf("/") != 0) { 
			return false;
		}
		
		// Verifica se os dias estão entre 1 e 31
		if (Integer.parseInt(data.substring(0, 2)) < 1 || Integer.parseInt(data.substring(0, 2)) > 31) { 
			return false;
		}
		// Verifica se os meses estão entre 1 e 12
		if (Integer.parseInt(data.substring(3, 5)) < 1 || Integer.parseInt(data.substring(3, 5)) > 12) {
			return false;
		}
		
		// Verifica se o ano está entre 1900 e 2021
		if (Integer.parseInt(data.substring(6, 10)) < 1900 || Integer.parseInt(data.substring(6, 10)) > 2021) { 
			return false;
		}

		return true;
	}
	
	/**
	 * Verifica se o estado informado se encontra em um formato válido e 
	 * se está dentro das possibilidades possíveis. São realizadas as seguintes verificações:
	 * (1) se a String tem mais ou menos de 2 letras
	 * (2) se a sigla está com as letras em maiúsculo
	 * (3) se a sigla está é uma das siglas predefinidas
	 * @param estado variável String com a sigla de alguma unidade federativa 
	 * @return um boolean true ou false, a depender se passou em todos os testes ou não passou em pelo menos um
	 */
	public boolean validacaoEstado(String estado) {
		// Verifica se tem mais ou menos de 2 letras
		if(estado.length() != 2) {
			return false;
		}
		
		// Verifica se está em maiúsculo
		if(!estado.toUpperCase().equals(estado)) {
			return false;
		}
		
		
		// Verifica se está entre os estados possíveis
		if(!estado.equals("AC") && !estado.equals("AL") && !estado.equals("AP") &&  !estado.equals("AM") && 
				!estado.equals("BA") && !estado.equals("CE") && !estado.equals("DF") && !estado.equals("ES") && 
				!estado.equals("GO") && !estado.equals("MA") && !estado.equals("MT") && !estado.equals("MS") && 
				!estado.equals("MG") && !estado.equals("PA") && !estado.equals("PB") && !estado.equals("PR") && 
				!estado.equals("PE") && !estado.equals("PI") && !estado.equals("RJ") && !estado.equals("RN") && 
				!estado.equals("RS") && !estado.equals("RO") && !estado.equals("RR") && !estado.equals("SC") && 
				!estado.equals("SP") && !estado.equals("SE") && !estado.equals("TO") ) {
			return false;
		}
		
		return true;
	}

}
