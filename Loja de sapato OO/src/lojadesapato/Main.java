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
				+ "\n3 - Cadastro de novo sapato"
				+ "\n4 - Busca por sapato"
				+ "\n5 - Cadastrar uma venda"
				+ "\n6 - Sair do programa");
	}

	public static void main(String[] args) {
		System.out.println("Cadastre um Sapato");
		Scanner ler = new Scanner(System.in);
		int opc, escolha;
		Cliente cliente = new Cliente();
		
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
			/*case 2: {
				titulo("Busca por Cliente");
				boolean check = false;
				int pos = 0, son = 1, opc;
				String alteraNome, alteraEnd, alteraTel;

				System.out.print("Nome completo do cliente que deseja encontrar: ");
				nome = ler.nextLine();
				
				// CHECA SE O CLIENTE INFORMADO ESTÁ ENTRE OS CADASTRADOS
				for (int i = 0; i < clientes.size(); i++) {
					if (nome.equals(clientes.get(i).get(0))) {
						check = true;
						pos = i;
						break;
					}else {
						if(i == clientes.size()-1) {
							sleep(1500);
							System.out.println("\nCliente não encontrado!");
							check = false;
						}
					}
				}
				sleep(1000);
				
				if (check) {
					
//					 * CASO O CLIENTE ESTEJA CADASTRADO, O PROGRAMA INFORMA
//					 * SEUS DADOS E PERGUNTA SE DESEJA ALTERAR ALGUM DESSES DADOS
					
					do {
						System.out.println("\n<< DADOS DO CLIENTE >>");
						System.out.println("- Nome: " + clientes.get(pos).get(0));
						System.out.println("- Endereço: " + clientes.get(pos).get(1));
						System.out.println("- Telefone: " + clientes.get(pos).get(2));
						linhas('-');
						System.out.print("Deseja alterar algum dado? [1-SIM | 2-NÃO]: ");
						son = ler.nextInt();
						
						if(son == 2) {
							sleep(1000);
						}
						else if (son == 1) {
							System.out.println("\n<< ALTERAR DADOS DO CLIENTE >>"
									+ "\n1- Nome"
									+ "\n2- Endereço"
									+ "\n3- Telefone");
							System.out.print("\n>> Informe qual dado deseja alterar: ");
							opc = ler.nextInt();
							ler.nextLine();
							
							if(opc == 1) {
								linhas('-');
								System.out.print("Novo nome do cliente: ");
								alteraNome = ler.nextLine();
								
								clientes.get(pos).set(0, toTitleCase(alteraNome));
								
								linhas('-');
								System.out.println("Atualizando...");
								sleep(1000);
							}
							else if(opc == 2) {
								linhas('-');
								System.out.print("Novo endereço do cliente: ");
								alteraEnd = ler.nextLine();
			
								clientes.get(pos).set(1, toTitleCase(alteraEnd));
								
								linhas('-');
								System.out.println("Atualizando...");
								sleep(1000);
							}
							else if(opc == 3) {
								linhas('-');
								System.out.print("Novo telefone do cliente: ");
								alteraTel = ler.nextLine();
								
								clientes.get(pos).set(2, alteraTel);
								
								linhas('-');
								System.out.println("Atualizando...");
								sleep(1000);
							}
							else {
								linhas('~');
								System.out.println("Opção inválida! Tente novamente.");
								linhas('~');
								sleep(1000);
							}
						}
						else {
							son = 1;
							linhas('~');
							System.out.println("Opção não identificada! Informe novamente.");
							linhas('~');
						}
					}while(son == 1);
				}
				System.out.println("Voltando ao menu principal...");
				sleep(1500);
				
				break;
			}
			case 3: {
				titulo("Cadastro de Novo Produto");
				System.out.print("Quantos produtos deseja cadastrar? ");
				qtd = ler.nextInt();
				ler.nextLine();
				
				for(int i = 0; i < qtd; i++) {
					System.out.printf("\n-> %d° PRODUTO", (i+1));
					System.out.print("\nInforme o nome do novo produto: ");
					nomeProd = ler.nextLine();
					produto.add(toTitleCase(nomeProd));
					
					System.out.print("Informe uma descrição para o novo produto: ");
					descricao = ler.nextLine();
					produto.add(toTitleCase(descricao));
					
					System.out.print("Informe o preço do novo produto (centavos separados por vírgula): R$ ");
					preco = ler.nextLine();
					produto.add(preco);
					
					System.out.print("Informe a porcentagem de lucro do novo produto (apenas números): ");
					porcent = ler.nextLine();
					produto.add(porcent);
					
					System.out.print("Informe a quantidade em estoque do novo produto: ");
					estoque = ler.nextLine();
					produto.add(estoque);
					
					produtos.add((ArrayList<String>) produto.clone());
					System.out.printf("Novo produto '%s' cadastrado com sucesso!\n", produto.get(0));
					produto.removeAll(produto);
					sleep(500);
					
				}				
				
				System.out.println("\nVoltando ao menu principal...");
				sleep(1500);
				break;
			}
			case 4: {
				titulo("Busca por Produto");
				boolean check = false;
				int pos = 0, son, opc;
				String alteraNomeProd, alteraDescricao, alteraPreco, alteraPorcent, alteraEstoque;

				System.out.print("Informe corretamente o nome completo do produto: ");
				nomeProd = ler.nextLine();
				
				// CHECA SE O PRODUTO INFORMADO ESTÁ ENTRE OS CADASTRADOS
				for (int i = 0; i < produtos.size(); i++) {
					if (nomeProd.equals(produtos.get(i).get(0))) {
						check = true;
						pos = i;
						break;
					}else {
						if(i == produtos.size()-1) {
							sleep(1500);
							System.out.println("\nProduto não encontrado!");
							check = false;
						}
					}
				}
				sleep(1000);
				
				if (check) {
					do {
						System.out.println("\n<< INFORMAÇÕES DO PRODUTO >>");
						System.out.println("- Nome do produto: " + produtos.get(pos).get(0));
						System.out.println("- Descrição do produto: " + produtos.get(pos).get(1));
						System.out.println("- Preço do produto: R$ " + produtos.get(pos).get(2));
						System.out.printf("- Porcentagem de lucro: %s%%", produtos.get(pos).get(3));
						System.out.println("\n- Quantidade em estoque: " + produtos.get(pos).get(4));
						linhas('-');
						System.out.print("Deseja alterar alguma informação? [1-SIM | 2-NÃO]: ");
						son = ler.nextInt();
						
						if(son == 2) {
							sleep(1000);
						}
						else if (son == 1) {
							System.out.println("\n<< ALTERAR INFORMAÇÕES DO PRODUTO >>");
							System.out.println("1- Nome do produto"
									+ "\n2- Descrição do produto"
									+ "\n3- Preço do produto"
									+ "\n4- Porcentagem de lucro"
									+ "\n5- Quantidade em estoque");
							System.out.print("\n>> Informe qual opção deseja alterar: ");
							opc = ler.nextInt();
							ler.nextLine();
							
							if(opc == 1) {
								linhas('-');
								System.out.print("Novo nome do produto: ");
								alteraNomeProd = ler.nextLine();
								
								produtos.get(pos).set(0, toTitleCase(alteraNomeProd));
								
								linhas('-');
								System.out.println("Atualizando...");
								sleep(1000);
							}
							else if(opc == 2) {
								linhas('-');
								System.out.print("Nova descrição do produto: ");
								alteraDescricao = ler.nextLine();
			
								produtos.get(pos).set(1, toTitleCase(alteraDescricao));
								
								linhas('-');
								System.out.println("Atualizando...");
								sleep(1000);
							}
							else if(opc == 3) {
								linhas('-');
								System.out.print("Novo preço do produto (centavos separados por vírgula): R$ ");
								alteraPreco = ler.nextLine();
								
								produtos.get(pos).set(2, alteraPreco);
								
								linhas('-');
								System.out.println("Atualizando...");
								sleep(1000);
							}
							else if (opc == 4){
								linhas('-');
								System.out.print("Novo valor da porcentagem de lucro (apenas números): ");
								alteraPorcent = ler.nextLine();
								
								produtos.get(pos).set(3, alteraPorcent);
								
								linhas('-');
								System.out.println("Atualizando...");
								sleep(1000);
							}
							else if (opc == 5) {
								linhas('-');
								System.out.print("Novo valor da quantidade em estoque: ");
								alteraEstoque = ler.nextLine();
								
								produtos.get(pos).set(4, alteraEstoque);
								
								linhas('-');
								System.out.println("Atualizando...");
								sleep(1000);
							}
							else {
								linhas('~');
								System.out.println("Opção inválida! Tente novamente.");
								linhas('~');
								sleep(1000);
							}
						}
						else {
							son = 1;
							linhas('~');
							System.out.println("Opção não identificada! Informe novamente.");
							linhas('~');
						}
					}while(son == 1);
				}
				System.out.println("Voltando ao menu principal...");
				sleep(1500);
				break;
			}
			case 5: {
				titulo("Cadastro de Venda");
				int son, novoCadastro, qtdVendida, indexCliente, indexProduto;
				int qtdEstoque = 1;
				int valorEstoqueConvertido, novoEstoque;
				
				while (true) {
					// PERGUNTA SE DESEJA CADASTRAR UMA NOVA VENDA ATÉ O USUÁRIO INFORMAR QUE NÃO
					System.out.print("Deseja cadastrar alguma venda para um cliente?\n[1-SIM | 2-NÃO]: ");
					novoCadastro = ler.nextInt();
					ler.nextLine();
					
					if(novoCadastro == 1) {
						// SE O USUÁRIO QUISER CADASTRAR UMA VENDA A LISTA DE CLIENTES É IMPRIMIDA
						linhas('=');
						System.out.println("Clientes cadastrados:");
						
						for(int i = 0; i < clientes.size(); i++) {
							System.out.printf("%d- %s\n", (i+1), clientes.get(i).get(0));
						}
						
						linhas('-');
						do {
							
//							 * PEDE PARA SELECIONAR UM CLIENTE ENQUANTO
//							 * A ESCOLHA INFORMADA FOR INVÁLIDA
							 
							System.out.print("Selecione um cliente\n>> ");
							
							indexCliente = ler.nextInt();
							ler.nextLine();
							
							if (indexCliente < 1 || indexCliente > clientes.size()) {
								linhas('~');
								System.out.println("Opção inválida! Informe novamente.");
								linhas('~');
							} else {						
								sleep(1000);
							}
						} while(indexCliente < 1 || indexCliente > clientes.size());
						linhas('=');
						
						do {
							System.out.println("Produtos cadastrados:");
							
							for(int i = 0; i < produtos.size(); i++) {
								System.out.printf("%d- %s\n", (i+1), produtos.get(i).get(0));
							}
							
							linhas('-');
							do {
								
//								 * PEDE PARA SELECIONAR UM PRODUTO ENQUANTO
//								 * A ESCOLHA INFORMADA FOR INVÁLIDA
								 
								System.out.print("Selecione um produto\n>> ");
								
								indexProduto = ler.nextInt();
								ler.nextLine();
								
								if (indexProduto < 1 || indexProduto > produtos.size()) {
									linhas('~');
									System.out.println("Opção inválida! Informe novamente.");
									linhas('~');
								} else {
									if("0".equals(produtos.get((indexProduto-1)).get(4))) {
										
//										 * CASO O PRODUTO ESTEJA CADASTRADO MAS
//										 * INDISPONÍVEL NO ESTOQUE A VENDA NÃO É PERMITIDA
//										 
										linhas('~');
										System.out.print("Este produto não está mais em estoque.");
										System.out.println("\nNão é possível realizar esta venda!");
										linhas('~');
										qtdEstoque = 0;
									} else {
										
//										 * O PRODUTO ESTÁ CADASTRADO E HÁ ESTOQUE
//										 *
										qtdEstoque = 1;
										sleep(1000);										
									}
								}
								
							} while((indexProduto < 1 || indexProduto > produtos.size()) || qtdEstoque == 0);
							
							
							if(qtdEstoque != 0) {
								linhas('-');
								do {
									System.out.printf("Quantos produtos '%s' foram vendidos para '%s'?",
											produtos.get((indexProduto-1)).get(0), clientes.get((indexCliente-1)).get(0));
									System.out.print("\n>> ");
									qtdVendida = ler.nextInt();
									ler.nextLine();
									
									
//									 * O VALOR DA QUANTIDADE EM ESTOQUE É UMA STRING
//									 * PORTANTO PARA ALTERAR ESSA QUANTIDADE APÓS UM
//									 * O VALOR É CONVERTIDO PARA INTEIRO
									 
									valorEstoqueConvertido = Integer.parseInt(produtos.get((indexProduto-1)).get(4));
									
									if(qtdVendida > valorEstoqueConvertido) {
										
//										 * IMPEDE QUE O CADASTRO OCORRA CASO
//										 * A QUANTIDADE VENDIDA INFORMADA SEJA
//										 * MAIOR QUE A QUANTIDADE EM ESTOQUE
										 
										linhas('~');
										System.out.println("A quantidade informada excede o total disponível em estoque.");
										System.out.printf("(Total disponível: %d)", valorEstoqueConvertido);
										System.out.println("\nNão é possível realizar esta venda!");
										linhas('~');
									}
								} while(qtdVendida > valorEstoqueConvertido);
								
								// A QUANTIDADE EM ESTOQUE É ATUALIZADA E VOLTA A SER UMA STRING
								novoEstoque = valorEstoqueConvertido - qtdVendida;
								String novoEstoqueString = Integer.toString(novoEstoque);
								
								produtos.get((indexProduto-1)).set(4, novoEstoqueString);
								
							}
							
							linhas('-');
							do {
								System.out.printf("Deseja cadastrar alguma outra venda para '%s'?"
										+ "\n[1-SIM | 2-NÃO]: ", clientes.get((indexCliente-1)).get(0));
								son = ler.nextInt();
								
								if(son == 2) {
									sleep(1000);
									break;
								} else {
									if(son != 1) {
										linhas('~');
										System.out.println("Opção não identificada! Informe novamente.");
										linhas('~');
										son = 1;
									} else {
										linhas('=');
										break;
									}
								}
							}while(son == 1);
							
						} while(son == 1);
						System.out.println("\nVoltando para o menu de Cadastro de Vendas...");
						sleep(1500);
						titulo("Cadastro de Vendas");
						
					} else if (novoCadastro == 2){
						System.out.println("\nVoltando ao menu principal...");
						sleep(1500);
						break;
					} else {
						linhas('~');
						System.out.println("Opção não identificada! Informe novamente.");
						linhas('~');
					}
				}
				
				break;
			}
			case 6: {
				titulo("Produtos em Estoque");
				System.out.println("Produtos cadastrados:\n");
				sleep(1000);
				
				for(int i = 0; i < produtos.size(); i++) {
					System.out.printf("%d- %s\n", (i+1), produtos.get(i).get(0));
					System.out.println("   > Quantidade no estoque: " + produtos.get(i).get(4) + "\n");
				}
				
				sleep(1500);
				linhas('-');
				System.out.println("Voltando ao menu principal...");
				sleep(1500);
				
				break;
			}
			case 7:{
				titulo("Clientes Cadastrados");
				System.out.println("\nLista de clientes:");
				linhas('-');
				for(int i = 0; i < clientes.size(); i++) {
					System.out.printf("%d- %s\n", (i+1), clientes.get(i).get(0));
				}
				linhas('-');
				sleep(2000);
				System.out.println("\nVoltando ao menu principal...");
				sleep(1000);
				break;
			}
			case 8: {
				titulo("Produtos Cadastrados");
				System.out.println("\nLista de produtos:");
				linhas('-');
				for(int i = 0; i < produtos.size(); i++) {
					System.out.printf("%d- %s\n", (i+1), produtos.get(i).get(0));
				}
				linhas('-');
				sleep(2000);
				System.out.println("\nVoltando ao menu principal...");
				sleep(1000);
				break;
			}
			*/
			default: {
				linhas('~');
				System.out.println("Opção inválida! Voltando ao menu principal...");
				linhas('~');
				sleep(1000);
				break;
			}
			
			}
			
		}while(opc != 6);
		
	
	}




}
