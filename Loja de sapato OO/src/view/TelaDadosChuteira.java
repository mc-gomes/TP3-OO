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
 * visualizar os dados de uma chuteira já cadastrada ou preencher os
 * dados de uma nova chuteira que será cadastrada
 * @author Matheus Costa e Laura Pinos
 *
 */
public class TelaDadosChuteira implements ActionListener {

	private JFrame janela;
	private JLabel labelNome = new JLabel("Nome:");
	private JTextField valorNome;
	private JLabel labelMarca = new JLabel("Marca:");
	private JTextField valorMarca;
	private JLabel labelPreco = new JLabel("Preço (R$):");
	private JTextField valorPreco;
	private JLabel labelQtd = new JLabel("Quantidade em estoque:");
	private JTextField valorQtd;
	private JLabel labelCor = new JLabel("Cor:");
	private JTextField valorCor;
	private JLabel labelTipo = new JLabel("Tipo:");
	private JTextField valorTipo;	
	private JLabel labelCano = new JLabel("Altura do cano:");
	private JTextField valorCano;
	
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private JButton botaoVoltar = new JButton("Voltar");
	private JButton botaoCancelar = new JButton("Cancelar");
	private static Chuteira chuteira = new Chuteira();
	
	private int posicao;
	private int opcao;
	private String s;
	
	/**
	 * Método que abre uma janela seja ou para cadastrar uma nova
	 * chuteira ou para exibir os dados de uma chuteira já cadastrada
	 * @param op : variável do tipo int que indica se será uma janela para cadastro ou para exibição de dados
	 * @param ch : o objeto Chuteira que será visualizado na opção de exibir dados
	 * @param pos : a posição da chuteira dentro da lista de chuteiras cadastradas
	 */
	public void cadastrarEditar(int op, Chuteira ch, int pos) {

		opcao = op;
		posicao = pos;
		chuteira = ch;
		
		if (op == 1) s = "Cadastro de Chuteira";
		if (op == 2) s = "Dados do Produto";

		janela = new JFrame(s);

		if (op == 1) { //Não preenche com dados
			
			valorNome = new JTextField(200);
			valorMarca = new JTextField(200);
			valorPreco = new JTextField(200);
			valorQtd = new JTextField(200);
			valorCor = new JTextField(100);
			valorCano = new JTextField(200);
			valorTipo = new JTextField(200);

			botaoSalvar.setBounds(145, 250, 110, 30);
			botaoCancelar.setBounds(265, 250, 115, 30);
			this.janela.add(botaoCancelar);
		}
		//Preenche com dados da Chuteira clicada
		if (op == 2) {
			
			valorNome = new JTextField(chuteira.retornaDado(pos, 1), 200);
			valorMarca = new JTextField(chuteira.retornaDado(pos, 2), 200);
			valorPreco = new JTextField(chuteira.retornaDado(pos, 3), 200);
			valorQtd = new JTextField(chuteira.retornaDado(pos, 4), 200);
			valorCor = new JTextField(chuteira.retornaDado(pos, 5), 200);
			valorCano = new JTextField(chuteira.retornaDado(pos, 6), 200);
			valorTipo = new JTextField(chuteira.retornaDado(pos, 7), 200);
			
			botaoSalvar.setBounds(145, 250, 115, 30);
			botaoExcluir.setBounds(265, 250, 115, 30);
			botaoVoltar.setBounds(30, 250, 100, 30);
			this.janela.add(botaoExcluir);
			this.janela.add(botaoVoltar);

		}

		labelNome.setBounds(30, 20, 150, 25);
		valorNome.setBounds(220, 20, 160, 25);
		
		labelMarca.setBounds(30, 50, 150, 25);
		valorMarca.setBounds(220, 50, 160, 25);
		
		labelPreco.setBounds(30, 80, 150, 25);
		valorPreco.setBounds(220, 80, 160, 25);
		
		labelQtd.setBounds(30, 110, 180, 25);
		valorQtd.setBounds(350, 110, 30, 25);
		
		labelCor.setBounds(30, 140, 80, 25);
		valorCor.setBounds(220, 140, 160, 25);
		
		labelCano.setBounds(30, 170, 150, 25);
		valorCano.setBounds(220, 170, 160, 25);
		
		labelTipo.setBounds(30, 200, 80, 25);
		valorTipo.setBounds(220, 200, 160, 25);

		this.janela.add(labelNome);
		this.janela.add(valorNome);
		this.janela.add(labelMarca);
		this.janela.add(valorMarca);
		this.janela.add(labelPreco);
		this.janela.add(valorPreco);
		this.janela.add(labelQtd);
		this.janela.add(valorQtd);
		this.janela.add(labelCor);
		this.janela.add(valorCor);
		this.janela.add(labelCano);
		this.janela.add(valorCano);
		this.janela.add(labelTipo);
		this.janela.add(valorTipo);
		this.janela.add(botaoSalvar);

		this.janela.setLayout(null);

		this.janela.setSize(400, 340);
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
	 * dos dados de uma chuteira
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == botaoSalvar) {
			// Varáveis para armazenar os valores dos campos de texto
			String nome, marca, preco, qtd, cor, cano, tipo;
			
			try {
				boolean check=true;
				
				nome = valorNome.getText();
				marca = valorMarca.getText();
				preco = valorPreco.getText();
				qtd = valorQtd.getText();
				cor = valorCor.getText();
				cano = valorCano.getText();
				tipo = valorTipo.getText();
				
				String[] dados = {nome, marca, preco, qtd, cor, cano, tipo};
				
				// verifica se há algum campo vazio
				if ("".equals(marca) || "".equals(preco) || "".equals(qtd) || "".equals(cor) ||
						"".equals(cano) || "".equals(tipo)) {
					check = false;
				}
				
				if(opcao == 1) { //cadastro de nova Chuteira
					
					if(check) {
						Chuteira novoChuteira = new Chuteira(nome, marca, Double.parseDouble(preco), Integer.parseInt(qtd), cor, cano, tipo);
						chuteira.cadastrar(novoChuteira);
						mensagemSucessoCadastro();
					}
					else {
						mensagemErroCadastro();
					}
				}
				else if (opcao == 2) {
					// edição dados Chuteira
					if(check){
						for (int i=1; i< 8; i++) {
							chuteira.editar(posicao, dados[i-1], i);							
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
			chuteira.deletar(posicao);
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
	
	public void mensagemErroDeAcesso() {
		JOptionPane.showMessageDialog(null,"ERRO AO BUSCAR Chuteira!\n\n"
				+ "Produto não econtrado!", null, 
				JOptionPane.ERROR_MESSAGE);
	}

	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n "
                + "Pode ter ocorrido um dos erros a seguir:  \n"
                + "1. Nem todos os campos foram preenchidos\n"
                + "2. Preço ou Quantidade em estoque não são\n"
                + " apenas números\n"
                + "3. Quantidade em estoque não é um valor inteiro\n"
                + "4. Valor decimal de Preço preenchido com\n"
                + " vírgula ao invés de ponto", null,
        JOptionPane.ERROR_MESSAGE);
	}

}