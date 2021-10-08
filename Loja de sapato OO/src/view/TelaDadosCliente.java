package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.*;

/**
 * Classe responsável por mostrar uma janela em que é possível
 * visualizar os dados de um cliente já cadastrado ou preencher os
 * dados de um novo cliente que será cadastrado
 * @author Matheus Costa
 *
 */
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
	private JButton botaoVoltar = new JButton("Voltar");
	private JButton botaoCancelar = new JButton("Cancelar");
	private static Cliente cliente = new Cliente();
	
	private int posicao;
	private int opcao;
	private String s;
	
	/**
	 * Método que abre uma janela seja ou para cadastrar um novo cliente
	 * ou para exibir os dados de um cliente já cadastrado
	 * @param op : variável do tipo int que indica se será uma janela para cadastro ou para exibição de dados
	 * @param c : o objeto Cliente que será visualizado na opção de exibir dados
	 * @param pos : a posição do cliente dentro da lista de clientes cadastrados
	 */
	public void cadastrarEditar(int op, Cliente c, int pos) {

		opcao = op;
		posicao = pos;
		cliente = c;
		
		if (op == 1) s = "Cadastro de Cliente";
		if (op == 2) s = "Dados do Cliente";

		janela = new JFrame(s);

		if (op == 1) { //Não preenche com dados
			
			valorNome = new JTextField(200);
			valorCPF = new JTextField(200);
			valorData = new JTextField(200);
			valorEnd = new JTextField(100);
			valorCidade = new JTextField(100);
			valorUF = new JTextField(50);
			valorDDD = new JTextField(3);
			valorTelefone = new JTextField(10);
			
			botaoSalvar.setBounds(145, 210, 110, 30);
			botaoCancelar.setBounds(265, 210, 115, 30);
			this.janela.add(botaoCancelar);
		}
		//Preenche com dados do cliente clicado
		if (op == 2) {
			
			valorNome = new JTextField(cliente.retornaDado(pos, 1), 200);
			valorCPF = new JTextField(cliente.retornaDado(pos, 2), 200);
			valorData = new JTextField(cliente.retornaDado(pos, 3), 200);
			valorEnd = new JTextField(cliente.retornaDado(pos, 4), 200);
			valorCidade = new JTextField(cliente.retornaDado(pos, 5), 200);
			valorUF = new JTextField(cliente.retornaDado(pos, 6), 200);
			valorDDD = new JTextField(cliente.retornaDado(pos, 7), 200);
			valorTelefone = new JTextField(cliente.retornaDado(pos, 8), 200);
			
			botaoSalvar.setBounds(145, 210, 115, 30);
			botaoExcluir.setBounds(265, 210, 115, 30);
			botaoVoltar.setBounds(30, 210, 100, 30);
			this.janela.add(botaoExcluir);
			this.janela.add(botaoVoltar);

		}

		labelNome.setBounds(30, 20, 150, 25);
		valorNome.setBounds(200, 20, 180, 25);
		
		labelCPF.setBounds(30, 50, 150, 25);
		valorCPF.setBounds(200, 50, 180, 25);
		
		labelData.setBounds(30, 80, 150, 25);
		valorData.setBounds(200, 80, 180, 25);
		
		labelEnd.setBounds(30, 110, 80, 25);
		valorEnd.setBounds(30, 140, 155, 25);

		labelCidade.setBounds(200, 110, 78, 25);
		valorCidade.setBounds(200, 140, 140, 25);
		
		labelUF.setBounds(280, 110, 100, 25);
		valorUF.setBounds(350, 140, 30, 25);
		
		labelTelefone.setBounds(30, 170, 150, 25);
		valorDDD.setBounds(200, 170, 28, 25);
		valorTelefone.setBounds(235, 170, 145, 25);
		

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

		this.janela.setSize(400, 300);
		janela.setLocationRelativeTo(null);
		this.janela.setVisible(true);

		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
		botaoVoltar.addActionListener(this);
		botaoCancelar.addActionListener(this);
	}
	
	/**
	 * Método que identifica e analisa as ações dos botões
	 * apresentados na tela de cadastro ou de exibição
	 * dos dados de um cliente
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == botaoSalvar) {
			// Varáveis para armazenar os valores dos campos de texto
			String nome, dtNasc, cpf, end, cid, est, ddd, num;
			Endereco nvEnd = new Endereco();
			Telefone nvTel = new Telefone();
			int CPF;
			
			try {
				boolean check = true;
				
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
				nvTel.setdDD(Integer.parseInt(ddd));
				num = valorTelefone.getText();
				nvTel.setNumero(Integer.parseInt(num));
				
				String[] dados = {nome, cpf, dtNasc, end, cid, est, ddd, num};
				
				// verifica se há algum campo vazio
				if ("".equals(nome) || "".equals(cpf) || "".equals(dtNasc) || "".equals(end) ||
						"".equals(cid) || "".equals(est) ||"".equals(ddd) || "".equals(num)) {
					check = false;
				}
				
				try {
					CPF = Integer.parseInt(cpf);		
				} catch (NumberFormatException exc2) {
					check = false;
				}
				
				if(opcao == 1) { //cadastro de novo cliente
					
					if(check) {
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
					if(check){
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
			cliente.deletar(posicao);
			mensagemSucessoExclusao();
		}
		
		if(src == botaoVoltar || src == botaoCancelar)
			this.janela.dispose();
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

	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n "
				+ "Pode ter ocorrido um dos dois erros a seguir:  \n"
				+ "1. Nem todos os campos foram preenchidos \n"
				+ "2. CPF, DDD ou telefone não contém apenas números", null, 
				JOptionPane.ERROR_MESSAGE);
	}

}