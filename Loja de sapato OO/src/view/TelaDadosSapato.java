package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.*;

public class TelaDadosSapato implements ActionListener {

	private JFrame janela;
	private JLabel labelMarca = new JLabel("Marca:");
	private JTextField valorMarca;
	private JLabel labelPreco = new JLabel("Preço (R$):");
	private JTextField valorPreco;
	private JLabel labelQtd = new JLabel("Quantidade em estoque:");
	private JTextField valorQtd;
	private JLabel labelCor = new JLabel("Cor:");
	private JTextField valorCor;
	private JLabel labelCano = new JLabel("Altura do cano:");
	private JTextField valorCano;
	private JLabel labelGenero = new JLabel("Gênero:");
	private JTextField valorGenero;
	private JLabel labelEstilo = new JLabel("Estilo da tira:");
	private JTextField valorEstilo;
	
	// CRIAR JLabels E JText PRA CADA TIPO DE SAPATO NO SEU SWITCH
	
	private JLabel labelCidade = new JLabel("Cidade:");
	private JTextField valorCidade;
	private JLabel labelUF = new JLabel("Estado (UF):");
	private JTextField valorUF;
	private JLabel labelTelefone = new JLabel("Telefone:");
	private JTextField valorDDD;
	private JTextField valorTelefone;
	
	
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private static Cliente cliente = new Cliente();
	
	private int posicao;
	private int opcao;
	private String s = "Dados do Produto";

	public void cadastrarEditar(int op,	TelaSapatos p, int pos) {

		opcao = op;
		posicao = pos;
		
		if (op == 1) s = "Cadastro de Bota";
		else if (op == 2) s = "Cadastro de Chinelo";
		else if (op == 3) s = "Cadastro de Chuteira";
		else if (op == 4) s = "Cadastro de Tênis";
		else if (op == 5) s = "Cadastro de Salto";
		
		janela = new JFrame(s);

		if (op == 1) { //Não preenche com dados
			// Cadastra bota
			valorMarca = new JTextField(200);
			valorPreco = new JTextField(200);
			valorQtd = new JTextField(200);
			valorCor = new JTextField(100);
			
			valorCano = new JTextField(200);
			labelCano.setBounds(30, 140, 150, 25);
			valorCano.setBounds(220, 140, 160, 25);
			
			valorGenero = new JTextField(200);
			labelGenero.setBounds(30, 170, 80, 25);
			valorGenero.setBounds(220, 170, 160, 25);
			
			this.janela.add(labelCano);
			this.janela.add(valorCano);
			this.janela.add(labelGenero);
			this.janela.add(valorGenero);

			
			botaoSalvar.setBounds(265, 230, 115, 30);
		}
		if (op == 2) { //Não preenche com dados
			// Cadastra chinelo
			valorMarca = new JTextField(200);
			valorPreco = new JTextField(200);
			valorQtd = new JTextField(200);
			valorCor = new JTextField(100);
			
			valorEstilo = new JTextField(200);
			labelEstilo.setBounds(30, 140, 150, 25);
			valorEstilo.setBounds(220, 140, 160, 25);
			
			this.janela.add(labelEstilo);
			this.janela.add(valorEstilo);
			
			botaoSalvar.setBounds(265, 230, 115, 30);
		}
		
		//Preenche com dados do cliente clicado
		if (op == 50) {
			
			valorMarca = new JTextField(cliente.retornaDado(pos, 1), 200);
			valorPreco = new JTextField(cliente.retornaDado(pos, 2), 200);
			valorQtd = new JTextField(cliente.retornaDado(pos, 3), 200);
			valorCor = new JTextField(cliente.retornaDado(pos, 4), 200);
			valorCidade = new JTextField(cliente.retornaDado(pos, 5), 200);
			valorUF = new JTextField(cliente.retornaDado(pos, 6), 200);
			valorDDD = new JTextField(cliente.retornaDado(pos, 7), 200);
			valorTelefone = new JTextField(cliente.retornaDado(pos, 8), 200);
			
			botaoSalvar.setBounds(130, 210, 115, 30);
			botaoExcluir.setBounds(265, 210, 115, 30);
			this.janela.add(botaoExcluir);

		}
	

		labelMarca.setBounds(30, 20, 150, 25);
		valorMarca.setBounds(220, 20, 160, 25);
		
		labelPreco.setBounds(30, 50, 150, 25);
		valorPreco.setBounds(220, 50, 160, 25);
		
		labelQtd.setBounds(30, 80, 180, 25);
		valorQtd.setBounds(350, 80, 30, 25);
		
		labelCor.setBounds(30, 110, 80, 25);
		valorCor.setBounds(220, 110, 160, 25);
		

		this.janela.add(labelMarca);
		this.janela.add(valorMarca);
		this.janela.add(labelPreco);
		this.janela.add(valorPreco);
		this.janela.add(labelQtd);
		this.janela.add(valorQtd);
		this.janela.add(labelCor);
		this.janela.add(valorCor);
		this.janela.add(botaoSalvar);

		this.janela.setLayout(null);

		this.janela.setSize(400, 350);
		janela.setLocationRelativeTo(null);
		this.janela.setVisible(true);

		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
	}


	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == botaoSalvar) {
			
			String nome, dtNasc, cpf, end, cid, est, ddd, num;
			Endereco nvEnd = new Endereco();
			Telefone nvTel = new Telefone();
			
			try {
				boolean res=true;
				
				nome = valorMarca.getText();
				cpf = valorPreco.getText();
				dtNasc = valorQtd.getText();
				end = valorCor.getText();
				nvEnd.setEndereco(end);
				cid = valorCidade.getText();
				nvEnd.setCidade(cid);
				est = valorUF.getText();
				nvEnd.setEstado(est);
				ddd = valorDDD.getText();
				nvTel.setdDD(ddd);
				num = valorTelefone.getText();
				nvTel.setNumero(num);
				
				String[] dados = {nome, cpf, dtNasc, end, cid, est, ddd, num};
				
				// verifica se há algum campo vazio
				if ("".equals(nome) || "".equals(cpf) || "".equals(dtNasc) || "".equals(end) ||
						"".equals(cid) || "".equals(est) ||"".equals(ddd) || "".equals(num)) {
					res = false;
				}
				
				if(opcao == 1) { //cadastro de novo cliente
					
					if(res) {
						Cliente novoCliente = new Cliente(nome, cpf, dtNasc, nvEnd, nvTel);
						cliente.cadastrar(novoCliente);
						mensagemSucessoCadastro();
					}
					else {
						mensagemErroCadastro();
					}
				}
				else if (opcao == 2) {
					// edição dados cliente
					if(res){
						for (int i=1; i< 9; i++) {
							cliente.editar(posicao, dados[i-1], i);							
						}
						mensagemSucessoCadastro();
					}
					else mensagemErroCadastro();
				}

			} catch (NullPointerException exc1) {
				mensagemErroCadastro();
			} catch (NumberFormatException exc2) {
				mensagemErroCadastro();
			}
		}

		if(src == botaoExcluir) {
			boolean res = false;

			cliente.deletar(posicao);
			if (!res) mensagemSucessoExclusao(); 
			else mensagemErroExclusaoAluno(); 
	
		}
	}

	public void mensagemSucessoExclusao() {
		JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!\n"
				+ "Lembre-se de atualizar a lista de cadastro!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}

	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!\n"
				+ "Lembre-se de atualizar a lista de cadastro!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
	
	public void mensagemErroDeAcesso() {
		JOptionPane.showMessageDialog(null,"ERRO AO BUSCAR CLIENTE!\n\n"
				+ "Cliente não econtrado!", null, 
				JOptionPane.ERROR_MESSAGE);
	}

	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n "
				+ "Pode ter ocorrido um dos dois erros a seguir:  \n"
				+ "1. Nem todos os campos foram preenchidos \n"
				+ "2. CPF, DDD ou telefone não contém apenas números", null, 
				JOptionPane.ERROR_MESSAGE);
	}

	public void mensagemErroExclusaoAluno() {
		JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n "
				+ "Verifique se o aluno está matriculado\n"
				+ "em alguma disciplina. Se sim, cancele\n "
				+ "a matricula e tente novamente.", null, 
				JOptionPane.ERROR_MESSAGE);
	}

}