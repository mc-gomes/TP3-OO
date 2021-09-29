package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.*;

public class TelaDadosCliente implements ActionListener {

	private JFrame janela;
	private JLabel labelNome = new JLabel("Nome:");
	private JTextField valorNome;
	private JLabel labelCPF = new JLabel("CPF:");
	private JTextField valorCPF;
	private JLabel labelData = new JLabel("Data de nascimento:");
	private JTextField valorData;
	private JLabel labelEnd = new JLabel("Endereço:");
	private JTextField valorEnd;
	private JLabel labelCidade = new JLabel("Cidade:");
	private JTextField valorCidade;
	private JLabel labelUF = new JLabel("Estado (UF):");
	private JTextField valorUF;
	private JLabel labelTelefone = new JLabel("Telefone:");
	private JTextField valorDDD;
	private JTextField valorTelefone;
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private String[] novoDado = new String[9];
	private static Cliente cliente = new Cliente();
	
	private String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", 
			"Setembro", "Outubro", "Novembro", "Dezembro"};
	private int posicao;
	private int opcao;
	private String s;

	public void cadastrarEditar(int op, Cliente c, 
			TelaCliente p, int pos) {

		opcao = op;
		posicao = pos;
		cliente = c;

		if (op == 1) s = "Cadastro de Cliente";
		if (op == 2) s = "Dados do Cliente";

		janela = new JFrame(s);

		//Preenche com dados do cliente clicado
		/*if (op == 2) {
			valorNome = new JTextField(cliente.getAlunos()[pos].getNome(), 200);
			valorEnd = new JTextField(cliente.getAlunos()[pos].getEndereco(),200);
			valorData = new JTextField(200);
			valorCPF = new JTextField(String.valueOf(cliente.getAlunos()[pos].getCPF()), 200);
			valorDDD = new JTextField(String.valueOf(cliente.getAlunos()[pos].getNumTel().getDDD()), 3);
			valorTelefone = new JTextField(String.valueOf(cliente.getAlunos()[pos].getNumTel().getNumero()), 10);			
		}

		//} else { //Não preenche com dados*/

		valorNome = new JTextField(200);
		valorCPF = new JTextField(200);
		valorData = new JTextField(200);
		valorEnd = new JTextField(100);
		valorCidade = new JTextField(100);
		valorUF = new JTextField(50);
		valorDDD = new JTextField(3);
		valorTelefone = new JTextField(10);

		botaoSalvar.setBounds(245, 375, 115, 30);
		//}

		labelNome.setBounds(30, 20, 150, 25);
		valorNome.setBounds(200, 20, 180, 25);
		
		labelCPF.setBounds(30, 50, 150, 25);
		valorCPF.setBounds(200, 50, 180, 25);
		
		labelData.setBounds(30, 80, 150, 25);
		valorData.setBounds(200, 80, 180, 25);
		
		labelEnd.setBounds(30, 110, 80, 25);
		valorEnd.setBounds(30, 140, 155, 25);

		labelCidade.setBounds(200, 110, 78, 25);
		valorCidade.setBounds(200, 140, 70, 25);
		
		labelUF.setBounds(280, 110, 100, 25);
		valorUF.setBounds(280, 140, 30, 25);
		
		
		labelTelefone.setBounds(30, 170, 150, 25);
		valorDDD.setBounds(200, 170, 28, 25);
		valorTelefone.setBounds(230, 170, 65, 25);

		//Coloca os campos relacionados a endereco se aluno
//		if (op == 1 || op == 3 ) {
//			this.janela.add(labelEnd);
//			this.janela.add(valorEnd);
//
//		}

		//Coloca campos relacionados a valor hora/aula se professor
//		if (op == 2 || op == 4) {
//
//			this.janela.add(labelData);
//			this.janela.add(valorData);
//		}

		//Coloca botoes de excluir e salvar
		if (op == 2) {
			botaoSalvar.setBounds(120, 175, 115, 30);
			botaoExcluir.setBounds(245, 175, 115, 30);
			this.janela.add(botaoExcluir);
		}

		this.janela.add(labelNome);
		this.janela.add(valorNome);
		this.janela.add(labelCPF);
		this.janela.add(valorCPF);
		this.janela.add(labelData);
		this.janela.add(valorData);
		this.janela.add(labelEnd);
		this.janela.add(valorEnd);
		this.janela.add(labelCidade);
		this.janela.add(valorCidade);
		this.janela.add(labelUF);
		this.janela.add(valorUF);
		this.janela.add(labelTelefone);
		this.janela.add(valorDDD);
		this.janela.add(valorTelefone);
		this.janela.add(botaoSalvar);

		this.janela.setLayout(null);

		this.janela.setSize(400, 450);
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
				/*if(opcao == 1) //cadastro de novo aluno
					/*novoDado[0] = Integer.toString(cliente.getQtdAlunos());
				else if (opcao == 2) // cadastro de novo prof
					novoDado[0] = Integer.toString(cliente.getQtdProfs());
				else // edicao de dado existente
					novoDado[0] = Integer.toString(posicao);*/

				nome = valorNome.getText();
				cpf = valorCPF.getText();
				dtNasc = valorData.getText();
				end = valorEnd.getText();
				nvEnd.setEndereco(end);
				cid = valorCidade.getText();
				nvEnd.setCidade(cid);
				est = valorUF.getText();
				nvEnd.setEstado(est);
				ddd = valorDDD.getText();
				nvTel.setdDD(ddd);
				num = valorTelefone.getText();
				nvTel.setNumero(num);
				
//				if (nome == null || cpf == null || dtNasc == null || end == null ||
//						cid == null || est == null || ddd == null || num == null) {
//					//novoDado[2] =  valorEnd.getText();
//					res = false;
//				}

				if ("".equals(nome) || "".equals(cpf) || "".equals(dtNasc) || "".equals(end) || "".equals(cid) ||
						"".equals(est) ||"".equals(ddd) || "".equals(num)) {
					//novoDado[2] =  valorEnd.getText();
					res = false;
				} /*else {
					novoDado[2] =  valorData.getText();
					res = cliente.inserirEditarProf(novoDado);
				}*/

				if(res) {
					Cliente novoCliente = new Cliente(nome, cpf, dtNasc, nvEnd, nvTel);
					cliente.cadastrar(novoCliente);
//					cliente.selecionaCliente();
//					TelaCliente().listaClientes();
//					listaNomes = cliente.listaClientes();
					mensagemSucessoCadastro();
				}
				else {
					System.out.println("erro defrgdbbt");
					mensagemErroCadastro();
				}

			} catch (NullPointerException exc1) {
				System.out.println("erro 1");
				mensagemErroCadastro();
			} catch (NumberFormatException exc2) {
				mensagemErroCadastro();
				System.out.println("erro 2");
			}
		}

		/*if(src == botaoExcluir) {
			boolean res = false;

			if (opcao == 3) {//exclui aluno
				res = cliente.removerAluno(posicao);
				if (res) mensagemSucessoExclusao(); 
				else mensagemErroExclusaoAluno(); 
			}
				
			if (opcao == 4){ //exclui professor
				res = cliente.removerProfessor(posicao);
				if (res) mensagemSucessoExclusao(); 
				else mensagemErroExclusaoProf(); 
			}
		}*/
	}

	public void mensagemSucessoExclusao() {
		JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}

	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}

	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n "
				+ "Pode ter ocorrido um dos dois erros a seguir:  \n"
				+ "1. Nem todos os campos foram preenchidos \n"
				+ "2. CPF, DDD e telefone não contém apenas números", null, 
				JOptionPane.ERROR_MESSAGE);
	}

	public void mensagemErroExclusaoAluno() {
		JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n "
				+ "Verifique se o aluno está matriculado\n"
				+ "em alguma disciplina. Se sim, cancele\n "
				+ "a matricula e tente novamente.", null, 
				JOptionPane.ERROR_MESSAGE);
	}
	
	public void mensagemErroExclusaoProf() {
		JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n "
				+ "Verifique se o professor está responsável\n"
				+ "por alguma disciplina. Se sim, substitua\n "
				+ "o professor e tente novamente.", null, 
				JOptionPane.ERROR_MESSAGE);
	}

}