package lojadesapato;

import java.util.Scanner;

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
		// MÉTODO QUE IMPRIME UM CABECALHO, ONDE O TÍTULO
		// É A STRING PASSADA COMO PARÂMETRO E CENTRALIZA
		// A STRING RECEBIDA DE ACORDO COM O SEU TAMANHO 
		int tam = 60 - titulo.length();
		
		linhas('=');
		for(int i = 0; i < (tam/2); i++) {
			System.out.print(" ");
		}
		System.out.println(titulo); 
		linhas('=');
	}
	
	static void menu() {
		titulo("Loja de Sapatos");
		
		System.out.println("Menu de opções:"
				+ "\n1 - Cadastro de novo cliente"
				+ "\n2 - Busca por cliente"
				+ "\n3 - Editar dados de um cliente"
				+ "\n4 - Deletar cliente"
				+ "\n5 - Cadastro de novo produto"
				+ "\n6 - Busca por produto"
				+ "\n7 - Editar dados de um produto"
				+ "\n8 - Deletar produto"
				+ "\n9 - Cadastrar uma venda"
				+ "\n10 - Sair do programa");
	}

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		int opc, escolha, index;
		
		Cliente cliente = new Cliente();
		cliente.preCadastrosCliente();
		Bota bota = new Bota();
		bota.preCadastrosBota();
		Chinelo chinelo = new Chinelo();
		Chuteira chuteira = new Chuteira();
		chuteira.preCadastrosChuteira();
		Salto salto = new Salto();
		Tenis tenis = new Tenis();
		
		
		do{
			menu();
			linhas('-');
			
			System.out.println("Digite sua opção");
			System.out.print(">> ");
			
			opc = ler.nextInt();
			ler.nextLine();
			
			switch (opc) {
			case 1: {
				titulo("Cadastro de Novo Cliente");
				cliente.cadastrar();
				System.out.println("\nVoltando ao menu principal...");
				sleep(1500);
				break;
			}
			case 2: {
				titulo("Busca por Cliente");
				cliente.visualizar();
				System.out.println("Voltando ao menu principal...");
				sleep(1500);
				break;
			}
			case 3: {
				titulo("Editar Cliente");
				index = cliente.selecionaCliente();
				cliente.editar(index-1);
				break;
			}
			case 4: {
				titulo("Deletar Cliente");
				index = cliente.selecionaCliente();
				cliente.deletar(index-1);
				break;
			}
			case 5: {
				titulo("Cadastro de Novo Produto");
				
				System.out.println("Que tipo de sapato deseja cadastrar?");
				System.out.println("1 - Bota"
						+ "\n2 - Chinelo"
						+ "\n3 - Chuteira"
						+ "\n4 - Salto"
						+ "\n5 - Tênis");
				System.out.print(">> ");
				
				escolha = ler.nextInt();
				ler.nextLine();
				linhas('-');
				
				if(escolha == 1)
					bota.cadastrar();
				else if(escolha == 2)
					chinelo.cadastrar();
				else if(escolha == 3)
					chuteira.cadastrar();
				else if(escolha == 4)
					salto.cadastrar();
				else if(escolha == 5)
					tenis.cadastrar();
				else
					System.out.print("Opção inválida!");
				
				System.out.println("\nVoltando ao menu principal...");
				sleep(1500);
				break;
			}
			case 6: {
				titulo("Busca por Produto");
				
				System.out.println("Qual tipo de sapato deseja encontrar?");
				System.out.println("1 - Bota"
						+ "\n2 - Chinelo"
						+ "\n3 - Chuteira"
						+ "\n4 - Salto"
						+ "\n5 - Tênis");
				System.out.print(">> ");
				
				escolha = ler.nextInt();
				ler.nextLine();
				linhas('-');
				
				if(escolha == 1)
					bota.visualizar();
				else if(escolha == 2)
					chinelo.visualizar();
				else if(escolha == 3)
					chuteira.visualizar();
				else if(escolha == 4)
					salto.visualizar();
				else if(escolha == 5)
					tenis.visualizar();
				else
					System.out.print("Opção inválida!");
				
				System.out.println("Voltando ao menu principal...");
				sleep(1500);
				break;
			}
			case 7:{
				titulo("Editar Produto");
				// por enquanto só funciona com a classe Bota
				index = bota.selecionaProduto();
				bota.editar(index-1);
				break;
			}
			case 8:{
				titulo("Deletar Produto");
				// por enquanto só funciona com a classe Bota
				index = bota.selecionaProduto();
				bota.deletar(index-1);
				break;
			}
			case 10:{
				System.out.println("\nEncerrando o programa...");
				sleep(1500);
				System.out.println("FIM");
				break;
			}
			default: {
				linhas('~');
				System.out.println("Opção inválida! Voltando ao menu principal...");
				linhas('~');
				sleep(1000);
				break;
			}
			
			} // FIM DO SWITCH
			
		}while(opc != 10);
	}

}
