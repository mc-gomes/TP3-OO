package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import modelo.*;

/**
 * Classe responsável por exibir uma tela com botões, onde
 * será possível filtrar o tipo de sapato que será analisado
 * @author Matheus Costa e Laura Pinos
 *
 */
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
	private JButton cadastroChuteira;
	private JButton atualizaChuteira;
	private JButton cadastroSalto;
	private JButton atualizaSalto;
	private JButton cadastroTenis;
	private JButton atualizaTenis;
	
	private JButton botaoVoltar = new JButton("Voltar");
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
	
	/**
	 * Método que exibe uma tela com botões relativos
	 * aos tipos de sapatos: botas, chinelos, chuteiras,
	 * saltos e tênis
	 */
	public void menuDeOpcoes(Bota bt, Chinelo chi, Chuteira chu, Salto st, Tenis te) {
		
		// Puxa somente uma vez os dados cadastrados
		// iniciais de cada tipo de sapato
		b = bt;
		c = chi;
		ch = chu;
		s = st;
		t = te;
		
		
        tituloMenu.setFont(new Font("Arial", Font.BOLD, 15));
        tituloMenu.setBounds(122, 10, 150, 30);
        bota.setBounds(135, 50, 100, 30);
        chinelo.setBounds(135, 100, 100, 30);
        chuteira.setBounds(135, 150, 100, 30);
        salto.setBounds(135, 200, 100, 30);
        tenis.setBounds(135, 250, 100, 30);
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
        janelaMenu.setLocationRelativeTo(null);
        janelaMenu.setVisible(true);
    }
	
	/**
	 * Método que cria e exibe uma janela onde, a partir da mesma, é
	 * possível realizar o CRUD de um determinado tipo de sapato,
	 * a depender da escolha do usuário
	 * @param op indica qual foi o tipo de sapato filtrado
	 */
	public void mostrarSapatos(int op){

		switch (op) {
		case 1:// Mostra lista de botas cadastradas
			String[] listaBota = new String[50];
			
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
			panel.setBounds(25, 50, 350, 120);
			barraScroll.getViewport().add(listaBotasCadastradas);
			panel.add(barraScroll);

			cadastroBota.setBounds(130, 177, 120, 30);
			atualizaBota.setBounds(255, 177, 120, 30);
			botaoVoltar.setBounds(25, 177, 100, 30);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(panel);
			janela.add(cadastroBota);
			janela.add(atualizaBota);
			janela.add(botaoVoltar);
			

			janela.setSize(400, 250);
			janela.setVisible(true);

			cadastroBota.addActionListener(this);
			atualizaBota.addActionListener(this);
			botaoVoltar.addActionListener(this);
			listaBotasCadastradas.addListSelectionListener(this);

			break;

		case 2:// Mostra lista de chinelos cadastrados
			String[] listaChinelo = new String[50];
			
			listaChinelo = c.listaNomesSapatos();
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

			cadastroChinelo.setBounds(130, 177, 120, 30);
			atualizaChinelo.setBounds(255, 177, 120, 30);
			botaoVoltar.setBounds(25, 177, 100, 30);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(panel);
			janela.add(cadastroChinelo);
			janela.add(atualizaChinelo);
			janela.add(botaoVoltar);

			janela.setSize(400, 250);
			janela.setVisible(true);

			cadastroChinelo.addActionListener(this);
			atualizaChinelo.addActionListener(this);
			botaoVoltar.addActionListener(this);
			listaChinelosCadastrados.addListSelectionListener(this);

			break;
			
		case 3: //Mostra lista de chuteiras cadastradas
			String[] listaChuteira = new String[50];
			
			listaChuteira = ch.listaNomesSapatos();
			listaChuteirasCadastradas = new JList<String>(listaChuteira);
			janela = new JFrame("Loja de Sapatos - Chuteiras");
			titulo = new JLabel("Chuteiras Cadastradas");
			cadastroChuteira = new JButton("Cadastrar chuteira");
			cadastroChuteira.setFont(new Font("Arial", Font.PLAIN, 10));
			atualizaChuteira = new JButton("Atualizar lista");
			atualizaChuteira.setFont(new Font("Arial", Font.PLAIN, 11));

			titulo.setFont(new Font("Arial", Font.BOLD, 15));
			titulo.setBounds(125, 10, 250, 30);
			panel.setBounds(25, 50, 350, 120);
			barraScroll.getViewport().add(listaChuteirasCadastradas);
			panel.add(barraScroll);
			
			cadastroChuteira.setBounds(120, 177, 130, 30);
			atualizaChuteira.setBounds(255, 177, 120, 30);
			botaoVoltar.setBounds(25, 177, 80, 30);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(panel);
			janela.add(cadastroChuteira);
			janela.add(atualizaChuteira);
			janela.add(botaoVoltar);

			janela.setSize(400, 250);
			janela.setVisible(true);

			cadastroChuteira.addActionListener(this);
			atualizaChuteira.addActionListener(this);
			botaoVoltar.addActionListener(this);
			listaChuteirasCadastradas.addListSelectionListener(this);

			break;
		
		case 4:// Mostra lista de saltos cadastrados
			String[] listaSalto = new String[50];

			listaSalto = s.listaNomesSapatos();
			listaSaltosCadastrados = new JList<String>(listaSalto);
			janela = new JFrame("Loja de Sapatos - Saltos");
			titulo = new JLabel("Saltos Cadastrados");
			cadastroSalto = new JButton("Cadastrar salto");
			cadastroSalto.setFont(new Font("Arial", Font.PLAIN, 11));
			atualizaSalto = new JButton("Atualizar lista");
			atualizaSalto.setFont(new Font("Arial", Font.PLAIN, 11));

			titulo.setFont(new Font("Arial", Font.BOLD, 15));
			titulo.setBounds(125, 10, 250, 30);
			panel.setBounds(25, 50, 350, 120);
			barraScroll.getViewport().add(listaSaltosCadastrados);
			panel.add(barraScroll);

			cadastroSalto.setBounds(130, 177, 130, 30);
			atualizaSalto.setBounds(265, 177, 110, 30);
			botaoVoltar.setBounds(25, 177, 100, 30);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(panel);
			janela.add(cadastroSalto);
			janela.add(atualizaSalto);
			janela.add(botaoVoltar);


			janela.setSize(400, 250);
			janela.setVisible(true);

			cadastroSalto.addActionListener(this);
			atualizaSalto.addActionListener(this);
			botaoVoltar.addActionListener(this);
			listaSaltosCadastrados.addListSelectionListener(this);

			break;
		
		case 5:// Mostra lista de tênis cadastrados
			String[] listaTenis = new String[50];

			listaTenis = t.listaNomesSapatos();
			listaTenisCadastrados = new JList<String>(listaTenis);
			janela = new JFrame("Loja de Sapatos - Tênis");
			titulo = new JLabel("Tênis Cadastrados");
			cadastroTenis = new JButton("Cadastrar tênis");
			cadastroTenis.setFont(new Font("Arial", Font.PLAIN, 11));
			atualizaTenis = new JButton("Atualizar lista");
			atualizaTenis.setFont(new Font("Arial", Font.PLAIN, 11));

			titulo.setFont(new Font("Arial", Font.BOLD, 15));
			titulo.setBounds(125, 10, 250, 30);
			panel.setBounds(25, 50, 350, 120);
			barraScroll.getViewport().add(listaTenisCadastrados);
			panel.add(barraScroll);

			cadastroTenis.setBounds(130, 177, 130, 30);
			atualizaTenis.setBounds(265, 177, 110, 30);
			botaoVoltar.setBounds(25, 177, 100, 30);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(panel);
			janela.add(cadastroTenis);
			janela.add(atualizaTenis);
			janela.add(botaoVoltar);


			janela.setSize(400, 250);
			janela.setVisible(true);

			cadastroTenis.addActionListener(this);
			atualizaTenis.addActionListener(this);
			botaoVoltar.addActionListener(this);
			listaTenisCadastrados.addListSelectionListener(this);

			break;
			
		default:
			JOptionPane.showMessageDialog(null,"OPÇÃO NÃO ENCONTRADA!\n"
					+ "Erro na passagem de parâmetro em:\n "
					+ "Classe 'TelaSapatos.java' ", null, 
					JOptionPane.ERROR_MESSAGE);
		}
	}

	//Captura eventos relacionados aos botões da interface
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		//Botas
		if(src == cadastroBota)
			new TelaDadosBota().cadastrarEditar(1, b, 0);

		if(src == atualizaBota) {
			listaBotasCadastradas.setListData(b.listaNomesSapatos());			
			listaBotasCadastradas.updateUI();
		}
		
		//Chinelos
		if(src == cadastroChinelo)
			new TelaDadosChinelo().cadastrarEditar(1, c, 0);

		if(src == atualizaChinelo) {
			listaBotasCadastradas.setListData(c.listaNomesSapatos());			
			listaBotasCadastradas.updateUI();
		}
		
		//Chuteiras
		if(src == cadastroChuteira)
			new TelaDadosChuteira().cadastrarEditar(1, ch, 0);

		if(src == atualizaChuteira) {
			listaChuteirasCadastradas.setListData(ch.listaNomesSapatos());			
			listaChuteirasCadastradas.updateUI();
		}
		
		//Saltos
		if(src == cadastroSalto)
			new TelaDadosSalto().cadastrarEditar(1, s, 0);

		if(src == atualizaSalto) {
			listaSaltosCadastrados.setListData(s.listaNomesSapatos());			
			listaSaltosCadastrados.updateUI();
		}
		
		// Tenis
		if(src == cadastroTenis)
			new TelaDadosTenis().cadastrarEditar(1, t, 0);

		if(src == atualizaTenis) {
			listaTenisCadastrados.setListData(t.listaNomesSapatos());			
			listaTenisCadastrados.updateUI();
		}
		
		if(src == botaoVoltar)
			this.janela.dispose();
		
		
		// Mostra uma tela com a lista do tipo de sapato escolhido
		if(src == bota) {
			mostrarSapatos(1);
		}
		if(src == chinelo) {
			mostrarSapatos(2);
		}
		if(src == chuteira) {
			mostrarSapatos(3);
		}
		if(src == salto) {
			mostrarSapatos(4);
		}
		if(src == tenis) {
			mostrarSapatos(5);
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
				new TelaDadosBota().cadastrarEditar(2, b,
						listaBotasCadastradas.getSelectedIndex());
			}
			if(e.getValueIsAdjusting() && src == listaChinelosCadastrados) {
				new TelaDadosChinelo().cadastrarEditar(2, c,
						listaChinelosCadastrados.getSelectedIndex());
			}
			if(e.getValueIsAdjusting() && src == listaChuteirasCadastradas) {
				new TelaDadosChuteira().cadastrarEditar(2, ch,
						listaChuteirasCadastradas.getSelectedIndex());
			}
			if(e.getValueIsAdjusting() && src == listaSaltosCadastrados) {
				new TelaDadosSalto().cadastrarEditar(2, s,
						listaSaltosCadastrados.getSelectedIndex());
			}
			if(e.getValueIsAdjusting() && src == listaTenisCadastrados) {
				new TelaDadosTenis().cadastrarEditar(2, t,
						listaTenisCadastrados.getSelectedIndex());
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

	}

}