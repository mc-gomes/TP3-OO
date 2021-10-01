package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.*;

public class TelaDadosBota implements ActionListener {

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
	
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private JButton botaoVoltar = new JButton("Voltar");
	private static Bota bota = new Bota();
	
	private int posicao;
	private int opcao;
	private String s;

	public void cadastrarEditar(int op, Bota b,	TelaSapatos p, int pos) {

		opcao = op;
		posicao = pos;
		bota = b;
		
		if (op == 1) s = "Cadastro de Bota";
		if (op == 2) s = "Dados do Produto";

		janela = new JFrame(s);

		if (op == 1) { //Não preenche com dados
			
			valorMarca = new JTextField(200);
			valorPreco = new JTextField(200);
			valorQtd = new JTextField(200);
			valorCor = new JTextField(100);
			valorCano = new JTextField(200);
			valorGenero = new JTextField(200);

			botaoSalvar.setBounds(265, 230, 115, 30);
		}
		//Preenche com dados do Bota clicado
		if (op == 2) {
			
			valorMarca = new JTextField(bota.retornaDado(pos, 1), 200);
			valorPreco = new JTextField(bota.retornaDado(pos, 2), 200);
			valorQtd = new JTextField(bota.retornaDado(pos, 3), 200);
			valorCor = new JTextField(bota.retornaDado(pos, 4), 200);
			valorCano = new JTextField(bota.retornaDado(pos, 5), 200);
			valorGenero = new JTextField(bota.retornaDado(pos, 6), 200);
			
			botaoSalvar.setBounds(145, 210, 115, 30);
			botaoExcluir.setBounds(265, 210, 115, 30);
			botaoVoltar.setBounds(30, 210, 100, 30);
			this.janela.add(botaoExcluir);
			this.janela.add(botaoVoltar);

		}	
	
		opcao = op;
		posicao = pos;
		
		/*if (op == 1) s = "Cadastro de Bota";
		else if (op == 2) s = "Cadastro de Chinelo";
		else if (op == 3) s = "Cadastro de Chuteira";
		else if (op == 4) s = "Cadastro de Tênis";
		else if (op == 5) s = "Cadastro de Salto";
		
		janela = new JFrame(s);

		
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
		}*/
		
		//Preenche com dados do Bota clicado
	

		labelMarca.setBounds(30, 20, 150, 25);
		valorMarca.setBounds(220, 20, 160, 25);
		
		labelPreco.setBounds(30, 50, 150, 25);
		valorPreco.setBounds(220, 50, 160, 25);
		
		labelQtd.setBounds(30, 80, 180, 25);
		valorQtd.setBounds(350, 80, 30, 25);
		
		labelCor.setBounds(30, 110, 80, 25);
		valorCor.setBounds(220, 110, 160, 25);
		
		labelCano.setBounds(30, 140, 150, 25);
		valorCano.setBounds(220, 140, 160, 25);
		
		labelGenero.setBounds(30, 170, 80, 25);
		valorGenero.setBounds(220, 170, 160, 25);

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
		this.janela.add(labelGenero);
		this.janela.add(valorGenero);
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
			
			String marca, preco, qtd, cor, cano, genero;
			
			try {
				boolean res=true;
				
				marca = valorMarca.getText();
				preco = valorPreco.getText();
				qtd = valorQtd.getText();
				cor = valorCor.getText();
				cano = valorCano.getText();
				genero = valorGenero.getText();
				
				String[] dados = {marca, preco, qtd, cor, cano, genero};
				
				// verifica se há algum campo vazio
				if ("".equals(marca) || "".equals(preco) || "".equals(qtd) || "".equals(cor) ||
						"".equals(cano) || "".equals(genero)) {
					res = false;
				}
				
				if(opcao == 1) { //cadastro de novo Bota
					
					if(res) {
						Bota novoBota = new Bota(marca, Double.parseDouble(preco), Integer.parseInt(qtd), cor, cano, genero);
						bota.cadastrar(novoBota);
						mensagemSucessoCadastro();
					}
					else {
						mensagemErroCadastro();
					}
				}
				else if (opcao == 2) {
					// edição dados Bota
					if(res){
						for (int i=1; i< 7; i++) {
							bota.editar(posicao, dados[i-1], i);							
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

			bota.deletar(posicao);
			if (!res) mensagemSucessoExclusao();
	
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
		JOptionPane.showMessageDialog(null,"ERRO AO BUSCAR Bota!\n\n"
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