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

	public static void main(String[] args) {
		System.out.println("Cadastre um Sapato");
		Scanner ler = new Scanner(System.in);
		int opc;
		while(true) {
			Bota bota = new Bota();
			System.out.println("\n1- cadastrar uma bota");
			System.out.println("2- visualzar uma bota");
			System.out.println("3- sair\nEscolha: ");
			
			opc = ler.nextInt();
			
			if(opc == 1) {
				bota.cadastrar();
			}
			else if(opc == 2) {
				bota.visualizar();
			}
			else {
				break;
			}
		}
	}




}
