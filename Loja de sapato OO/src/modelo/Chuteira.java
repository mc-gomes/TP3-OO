package modelo;

import java.util.ArrayList;

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

	@Override
	public String toString() {
		return "-Nome da chuteira: " + nome + "\n-Marca: " + marca + "\n-Tipo: " + tipo +
				"\n-Preço R$ " + preco + "\n-Quantidade em estoque: " + quantidade  +
				"\n-Cor: " + cor + "\n-Altura do cano: " + cano + "\n";
	}
	
	ArrayList<Chuteira> listaDeChuteira = new ArrayList<Chuteira>();
	
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
	
	public void cadastrar(Chuteira chuteira) {
		listaDeChuteira.add(chuteira);	
	}
	
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
	
	public void deletar(int n) {
		listaDeChuteira.remove(listaDeChuteira.get(n));
	}

	
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
