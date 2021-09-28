package modelo;

public class Endereco {
	private String endereco;
	private String cidade;
	private String estado;
	
	public Endereco() {
		
	}
	
	public Endereco(String end, String c, String e) {
		endereco = end;
		cidade = c;
		estado = e;
	}
	
	@Override
	public String toString() {
		return endereco + " - " + cidade + ", " + estado;
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
