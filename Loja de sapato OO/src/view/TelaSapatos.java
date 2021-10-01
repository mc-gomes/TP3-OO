package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import modelo.*;


public class TelaSapatos implements ActionListener, ListSelectionListener {		
	private JFrame janelaMenu = new JFrame("Loja de Sapatos - Menu Sapatos");
	private JLabel tituloMenu = new JLabel("Tipos de Sapatos");
	private JFrame janela;
	private JLabel titulo;
    private JButton bota = new JButton("Bota");
    private JButton chinelo = new JButton("Chinelo");
    private JButton chuteira = new JButton("Chuteira");
    private JButton tenis = new JButton("Tênis");
    private JButton salto = new JButton("Salto");
    private JButton sair = new JButton("Sair");
    
	private JButton cadastroBota;
	private JButton atualizaBota;
	private JButton cadastroChinelo;
	private JButton atualizaChinelo;
	private JButton cadastroChuteria;
	private JButton atualizaChuteria;
	private JButton cadastroSalto;
	private JButton atualizaSalto;
	private JButton cadastroTenis;
	private JButton atualizaTenis;
	private JList<String> listaBotasCadastradas;
	private JList<String> listaChinelosCadastrados;
	private JList<String> listaChuteirasCadastradas;
	private JList<String> listaSaltosCadastrados;
	private JList<String> listaTenisCadastrados;
	
	private JPanel panel = new JPanel(new BorderLayout());
	private JScrollPane barraScroll = new JScrollPane();
	Bota b = new Bota();
	Chinelo c = new Chinelo();
	Chuteira ch = new Chuteira();
	Salto s = new Salto();
	Tenis t = new Tenis();
	
	private String[] listaNomes = new String[50];
	
	public void listaSapatos(int op) {
		if(op == 1) {
			listaNomes = b.listaNomesSapatos();
		}
	}
	
	public void menuDeOpcoes() {

        tituloMenu.setFont(new Font("Arial", Font.BOLD, 15));
        tituloMenu.setBounds(122, 10, 150, 30);
        bota.setBounds(135, 50, 100, 30);
        chinelo.setBounds(135, 100, 100, 30);
        chuteira.setBounds(135, 150, 100, 30);
        tenis.setBounds(135, 200, 100, 30);
        salto.setBounds(135, 250, 100, 30);
        sair.setBounds(135, 300, 100, 30);

        janelaMenu.setLayout(null);

        janelaMenu.add(tituloMenu);
        janelaMenu.add(bota);
        janelaMenu.add(chinelo);
        janelaMenu.add(chuteira);
        janelaMenu.add(tenis);
        janelaMenu.add(salto);
        janelaMenu.add(sair);


        bota.addActionListener(this);
		chinelo.addActionListener(this);
		chuteira.addActionListener(this);
		tenis.addActionListener(this);
		salto.addActionListener(this);
		sair.addActionListener(this);
		
        janelaMenu.setSize(400, 400);
        //janelaMenu.pack();
        janelaMenu.setLocationRelativeTo(null);
        janelaMenu.setVisible(true);
    }

	public void mostrarSapatos(int op){

		switch (op) {
		case 1:// Mostrar dados de botas cadastradas (JList)
			String[] listaBota = new String[50];
//			Bota bota = new Bota();
			b.preCadastrosBota();
			
			listaBota = b.listaNomesSapatos();
			listaBotasCadastradas = new JList<String>(listaBota);
			janela = new JFrame("Loja de Sapatos - Botas");
			titulo = new JLabel("Botas Cadastradas");
			cadastroBota = new JButton("Cadastrar bota");
			cadastroBota.setFont(new Font("Arial", Font.PLAIN, 11));
			atualizaBota = new JButton("Atualizar lista");
			atualizaBota.setFont(new Font("Arial", Font.PLAIN, 11));

			titulo.setFont(new Font("Arial", Font.BOLD, 15));
			titulo.setBounds(125, 10, 250, 30);
			//listaBotasCadastradas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			//listaBotasCadastradas.setVisibleRowCount(5);
			panel.setBounds(25, 50, 350, 120);
			barraScroll.getViewport().add(listaBotasCadastradas);
			//listaBotasCadastradas.setBounds(25, 50, 350, 120);
			panel.add(barraScroll);

			cadastroBota.setBounds(130, 177, 120, 30);
			atualizaBota.setBounds(255, 177, 120, 30);

			janela.setLayout(null);

			janela.add(titulo);
			//janela.add(listaBotasCadastradas);
			janela.add(panel);
			janela.add(cadastroBota);
			janela.add(atualizaBota);
			

			janela.setSize(400, 250);
			janela.setVisible(true);

			cadastroBota.addActionListener(this);
			atualizaBota.addActionListener(this);
			listaBotasCadastradas.addListSelectionListener(this);

			break;

		case 2:// Mostrar dados de chinelos cadastradas (JList)
			String[] listaChinelo = new String[50];
			Chinelo chinelo = new Chinelo();
			chinelo.preCadastrosChinelo();
			
			listaChinelo = chinelo.listaNomesSapatos();
			listaChinelosCadastrados = new JList<String>(listaChinelo);
			janela = new JFrame("Loja de Sapatos - Chinelos");
			titulo = new JLabel("Chinelos Cadastrados");
			cadastroChinelo = new JButton("Cadastrar chinelo");
			cadastroChinelo.setFont(new Font("Arial", Font.PLAIN, 10));
			atualizaChinelo = new JButton("Atualizar lista");
			atualizaChinelo.setFont(new Font("Arial", Font.PLAIN, 11));

			titulo.setFont(new Font("Arial", Font.BOLD, 15));
			titulo.setBounds(125, 10, 250, 30);
			panel.setBounds(25, 50, 350, 120);
			barraScroll.getViewport().add(listaChinelosCadastrados);
			panel.add(barraScroll);
			
			//listaChinelosCadastrados.setBounds(25, 50, 350, 120);
//			listaChinelosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
//			listaChinelosCadastrados.setVisibleRowCount(10);

			cadastroChinelo.setBounds(130, 177, 120, 30);
			atualizaChinelo.setBounds(255, 177, 120, 30);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(panel);
			janela.add(cadastroChinelo);
			janela.add(atualizaChinelo);

			janela.setSize(400, 250);
			janela.setVisible(true);

			cadastroChinelo.addActionListener(this);
			atualizaChinelo.addActionListener(this);
			listaChinelosCadastrados.addListSelectionListener(this);

			break;
			
		case 3:
			String[] listaChuteira = new String[50];
//			Bota bota = new Bota();
			ch.preCadastrosChuteira();
			
			listaChuteira = ch.listaNomesSapatos();
			listaChuteirasCadastradas = new JList<String>(listaChuteira);
			janela = new JFrame("Loja de Sapatos - Chuteiras");
			titulo = new JLabel("Chuteiras Cadastradas");
			cadastroChuteria = new JButton("Cadastrar chuteira");
			cadastroChuteria.setFont(new Font("Arial", Font.PLAIN, 10));
			atualizaChuteria = new JButton("Atualizar lista");
			atualizaChuteria.setFont(new Font("Arial", Font.PLAIN, 11));

			titulo.setFont(new Font("Arial", Font.BOLD, 15));
			titulo.setBounds(125, 10, 250, 30);
			panel.setBounds(25, 50, 350, 120);
			barraScroll.getViewport().add(listaChuteirasCadastradas);
			panel.add(barraScroll);
			
//			listaChuteirasCadastradas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
//			listaChuteirasCadastradas.setVisibleRowCount(10);

			cadastroChuteria.setBounds(120, 177, 130, 30);
			atualizaChuteria.setBounds(255, 177, 120, 30);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(panel);
			janela.add(cadastroChuteria);
			janela.add(atualizaChuteria);

			janela.setSize(400, 250);
			janela.setVisible(true);

			cadastroChuteria.addActionListener(this);
			atualizaChuteria.addActionListener(this);
			listaChuteirasCadastradas.addListSelectionListener(this);

			break;
		
		/*case 1:// Mostrar dados de alunos cadastrados (JList)
			listaNomes = new ControleAluno(dados).getNomeAluno();
			listaAlunosCadastrados = new JList<String>(listaNomes);
			janela = new JFrame("Alunos");
			titulo = new JLabel("Alunos Cadastrados");
			cadastroBota = new JButton("Cadastrar");
			atualizaBota = new JButton("Refresh");

			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaAlunosCadastrados.setBounds(20, 50, 350, 120);
			listaAlunosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaAlunosCadastrados.setVisibleRowCount(10);

			cadastroBota.setBounds(70, 177, 100, 30);
			atualizaBota.setBounds(200, 177, 100, 30);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(listaAlunosCadastrados);
			janela.add(cadastroBota);
			janela.add(atualizaBota);

			janela.setSize(400, 250);
			janela.setVisible(true);

			cadastroBota.addActionListener(this);
			atualizaBota.addActionListener(this);
			listaAlunosCadastrados.addListSelectionListener(this);

			break;
		
		case 1:// Mostrar dados de alunos cadastrados (JList)
			listaNomes = new ControleAluno(dados).getNomeAluno();
			listaAlunosCadastrados = new JList<String>(listaNomes);
			janela = new JFrame("Alunos");
			titulo = new JLabel("Alunos Cadastrados");
			cadastroBota = new JButton("Cadastrar");
			atualizaBota = new JButton("Refresh");

			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaAlunosCadastrados.setBounds(20, 50, 350, 120);
			listaAlunosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaAlunosCadastrados.setVisibleRowCount(10);

			cadastroBota.setBounds(70, 177, 100, 30);
			atualizaBota.setBounds(200, 177, 100, 30);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(listaAlunosCadastrados);
			janela.add(cadastroBota);
			janela.add(atualizaBota);

			janela.setSize(400, 250);
			janela.setVisible(true);

			cadastroBota.addActionListener(this);
			atualizaBota.addActionListener(this);
			listaAlunosCadastrados.addListSelectionListener(this);

			break;
			
		case 1:// Mostrar dados de alunos cadastrados (JList)
			listaNomes = new ControleAluno(dados).getNomeAluno();
			listaAlunosCadastrados = new JList<String>(listaNomes);
			janela = new JFrame("Alunos");
			titulo = new JLabel("Alunos Cadastrados");
			cadastroBota = new JButton("Cadastrar");
			atualizaBota = new JButton("Refresh");

			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaAlunosCadastrados.setBounds(20, 50, 350, 120);
			listaAlunosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaAlunosCadastrados.setVisibleRowCount(10);

			cadastroBota.setBounds(70, 177, 100, 30);
			atualizaBota.setBounds(200, 177, 100, 30);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(listaAlunosCadastrados);
			janela.add(cadastroBota);
			janela.add(atualizaBota);

			janela.setSize(400, 250);
			janela.setVisible(true);

			cadastroBota.addActionListener(this);
			atualizaBota.addActionListener(this);
			listaAlunosCadastrados.addListSelectionListener(this);

			break;*/
			
		default:
			JOptionPane.showMessageDialog(null,"Opção não encontrada!", null, 
					JOptionPane.ERROR_MESSAGE);
		}
	}

	//Captura eventos relacionados aos botões da interface
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		//Cadastro de novo aluno
		if(src == cadastroBota)
			new TelaDadosBota().cadastrarEditar(1, b, this, 0);
			//System.out.println("cadastro sapato clicado");

		// Atualiza a lista de nomes de alunos mostrada no JList
		if(src == atualizaBota) {
			listaBotasCadastradas.setListData(b.listaNomesSapatos());			
			listaBotasCadastradas.updateUI();
			//System.out.println("atualiza sapato clicado");
		}
		
		
		if(src == cadastroChinelo)
			//new TelaDadosSapato().cadastrarEditar(2, this, 0);
			System.out.println("cadastro sapato clicado");

		// Atualiza a lista de nomes de alunos mostrada no JList
		if(src == atualizaChinelo) {
			listaBotasCadastradas.setListData(c.listaNomesSapatos());			
			listaBotasCadastradas.updateUI();
			//System.out.println("atualiza sapato clicado");
		}
		
		
		/*if(src == cadastroChuteira)
			//new TelaDadosSapatos().cadastrarEditar(1, dados, this, 0);
			System.out.println("cadastro sapato clicado");

		// Atualiza a lista de nomes de alunos mostrada no JList
		if(src == atualizaBota) {
//			listaAlunosCadastrados.setListData(new ControleAluno(dados).getNomeAluno());			
//			listaAlunosCadastrados.updateUI();
			System.out.println("atualiza sapato clicado");
		}
		
		if(src == cadastroSalto)
			//new TelaDadosSapatos().cadastrarEditar(1, dados, this, 0);
			System.out.println("cadastro sapato clicado");

		// Atualiza a lista de nomes de alunos mostrada no JList
		if(src == atualizaBota) {
//			listaAlunosCadastrados.setListData(new ControleAluno(dados).getNomeAluno());			
//			listaAlunosCadastrados.updateUI();
			System.out.println("atualiza sapato clicado");
		}
		
		
		if(src == cadastroTenis)
			//new TelaDadosSapatos().cadastrarEditar(1, dados, this, 0);
			System.out.println("cadastro sapato clicado");

		// Atualiza a lista de nomes de alunos mostrada no JList
		if(src == atualizaBota) {
//			listaAlunosCadastrados.setListData(new ControleAluno(dados).getNomeAluno());			
//			listaAlunosCadastrados.updateUI();
			System.out.println("atualiza sapato clicado");
		}*/

		// Atualiza a lista de nomes de professores mostrada no JList
		if(src == bota) {
			mostrarSapatos(1);
			//System.out.println("botao bota clicado");
		}
			
		if(src == chinelo) {
			mostrarSapatos(2);
			//System.out.println("botao chinelo clicado");
		}
		if(src == chuteira) {
			mostrarSapatos(3);
			//System.out.println("botao chuteira clicado");
		}
		if(src == tenis) {
//			mostrarSapatos(4);
			System.out.println("botao tenis clicado");
		}
		if(src == salto) {
//			mostrarSapatos(5);
			System.out.println("botao salto clicado");
		}
		if(src == sair) {
			janelaMenu.dispose();
		}

	}

	//Captura eventos relacionados ao JList
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		try {
			if(e.getValueIsAdjusting() && src == listaBotasCadastradas) {
				new TelaDadosBota().cadastrarEditar(2, b, this, 
						listaBotasCadastradas.getSelectedIndex());
			}	
		}catch (NullPointerException exc) {
			JOptionPane.showMessageDialog(null,"ERRO!\n\n"
					+ "Produto não econtrado!", null, 
					JOptionPane.ERROR_MESSAGE);
		}catch (IndexOutOfBoundsException exc) {
			JOptionPane.showMessageDialog(null,"ERRO!\n\n"
					+ "Produto não econtrado!", null, 
					JOptionPane.ERROR_MESSAGE);
	    }

		/*if(e.getValueIsAdjusting() && src == listaProfsCadastrados) {
			new TelaDetalhePessoa().inserirEditar(4, dados, this, 
					listaProfsCadastrados.getSelectedIndex());
		}*/
	}

}