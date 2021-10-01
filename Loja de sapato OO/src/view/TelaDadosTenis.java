package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.*;

public class TelaDadosTenis implements ActionListener {

	private JFrame janela;
	private JLabel labelMarca = new JLabel("Marca:");
	private JTextField valorMarca;
	private JLabel labelPreco = new JLabel("Preço (R$):");
	private JTextField valorPreco;
	private JLabel labelQtd = new JLabel("Quantidade em estoque:");
	private JTextField valorQtd;
	private JLabel labelCor = new JLabel("Cor:");
	private JTextField valorCor;
	private JLabel labelTipo = new JLabel("Tipo do tênis:");
	private JTextField valorTipo;
	
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private JButton botaoVoltar = new JButton("Voltar");
	private static Tenis tenis = new Tenis();
	
	private int posicao;
	private int opcao;
	private String s;

	public void cadastrarEditar(int op, Tenis t, TelaSapatos p, int pos) {

		opcao = op;
		posicao = pos;
		tenis = t;
		
		if (op == 1) s = "Cadastro de Tênis";
		if (op == 2) s = "Dados do Produto";

		janela = new JFrame(s);

		if (op == 1) { //Não preenche com dados
			
			valorMarca = new JTextField(200);
			valorPreco = new JTextField(200);
			valorQtd = new JTextField(200);
			valorCor = new JTextField(100);
			valorTipo = new JTextField(200);

			botaoSalvar.setBounds(265, 230, 115, 30);
		}
		//Preenche com dados do Tenis clicada
		if (op == 2) {
			
			valorMarca = new JTextField(tenis.retornaDado(pos, 1), 200);
			valorPreco = new JTextField(tenis.retornaDado(pos, 2), 200);
			valorQtd = new JTextField(tenis.retornaDado(pos, 3), 200);
			valorCor = new JTextField(tenis.retornaDado(pos, 4), 200);
			valorTipo = new JTextField(tenis.retornaDado(pos, 5), 200);
			
			
			botaoSalvar.setBounds(145, 210, 115, 30);
			botaoExcluir.setBounds(265, 210, 115, 30);
			botaoVoltar.setBounds(30, 210, 100, 30);
			this.janela.add(botaoExcluir);
			this.janela.add(botaoVoltar);

		}

		labelMarca.setBounds(30, 20, 150, 25);
		valorMarca.setBounds(220, 20, 160, 25);
		
		labelPreco.setBounds(30, 50, 150, 25);
		valorPreco.setBounds(220, 50, 160, 25);
		
		labelQtd.setBounds(30, 80, 180, 25);
		valorQtd.setBounds(350, 80, 30, 25);
		
		labelCor.setBounds(30, 110, 80, 25);
		valorCor.setBounds(220, 110, 160, 25);
		
		labelTipo.setBounds(30, 140, 150, 25);
		valorTipo.setBounds(220, 140, 160, 25);
		

		this.janela.add(labelMarca);
		this.janela.add(valorMarca);
		this.janela.add(labelPreco);
		this.janela.add(valorPreco);
		this.janela.add(labelQtd);
		this.janela.add(valorQtd);
		this.janela.add(labelCor);
		this.janela.add(valorCor);
		this.janela.add(labelTipo);
		this.janela.add(valorTipo);
		this.janela.add(botaoSalvar);

		this.janela.setLayout(null);

		this.janela.setSize(400, 350);
		janela.setLocationRelativeTo(null);
		this.janela.setVisible(true);

		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
		botaoVoltar.addActionListener(this);
	}


	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == botaoSalvar) {
			
			String marca, preco, qtd, cor, tipo;
			
			try {
				boolean res=true;
				
				marca = valorMarca.getText();
				preco = valorPreco.getText();
				qtd = valorQtd.getText();
				cor = valorCor.getText();
				tipo = valorTipo.getText();
				
				String[] dados = {marca, preco, qtd, cor, tipo};
				
				// verifica se há algum campo vazio
				if ("".equals(marca) || "".equals(preco) || "".equals(qtd) || "".equals(cor) ||
						"".equals(tipo)) {
					res = false;
				}
				
				if(opcao == 1) { //cadastro de novo Tenis
					
					if(res) {
						Tenis novoTenis = new Tenis(marca, Double.parseDouble(preco), Integer.parseInt(qtd), cor, tipo);
						tenis.cadastrar(novoTenis);
						mensagemSucessoCadastro();
					}
					else {
						mensagemErroCadastro();
					}
				}
				else if (opcao == 2) {
					// edição dados Tenis
					if(res){
						for (int i=1; i< 6; i++) {
							tenis.editar(posicao, dados[i-1], i);							
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

			tenis.deletar(posicao);
			if (!res) mensagemSucessoExclusao();
	
		}
		
		if(src == botaoVoltar)
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
		JOptionPane.showMessageDialog(null,"ERRO AO BUSCAR TÊNIS!\n\n"
				+ "Produto não econtrado!", null, 
				JOptionPane.ERROR_MESSAGE);
	}

	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n "
				+ "Pode ter ocorrido um dos dois erros a seguir:  \n"
				+ "1. Nem todos os campos foram preenchidos \n"
				+ "2. Preço ou Quantidade em estoque não contém apenas números", null, 
				JOptionPane.ERROR_MESSAGE);
	}

}