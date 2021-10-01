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
	private JButton cadastroChuteira;
	private JButton atualizaChuteira;
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
			
		case 3:// Mostrar dados de chuteiras cadastradas (JList)
			String[] listaChuteira = new String[50];
//			Bota bota = new Bota();
			ch.preCadastrosChuteira();
			
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
			
//			listaChuteirasCadastradas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
//			listaChuteirasCadastradas.setVisibleRowCount(10);

			cadastroChuteira.setBounds(120, 177, 130, 30);
			atualizaChuteira.setBounds(255, 177, 120, 30);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(panel);
			janela.add(cadastroChuteira);
			janela.add(atualizaChuteira);

			janela.setSize(400, 250);
			janela.setVisible(true);

			cadastroChuteira.addActionListener(this);
			atualizaChuteira.addActionListener(this);
			listaChuteirasCadastradas.addListSelectionListener(this);

			break;

			case 4:// Mostrar dados de tenis cadastrados (JList)
				String[] listaTenis = new String[50];
//			Bota bota = new Bota();
				t.preCadastrosTenis();

				listaTenis = t.listaNomesSapatos();
				listaTenisCadastradas = new JList<String>(listaTenis);
				janela = new JFrame("Loja de Sapatos - Tenis");
				titulo = new JLabel("Botas Cadastradas");
				cadastroTenis = new JButton("Cadastrar tenis");
				cadastroTenis.setFont(new Font("Arial", Font.PLAIN, 11));
				atualizaTenis = new JButton("Atualizar lista");
				atualizaTenis.setFont(new Font("Arial", Font.PLAIN, 11));

				titulo.setFont(new Font("Arial", Font.BOLD, 15));
				titulo.setBounds(125, 10, 250, 30);
				//listaTenisCadastradas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
				//listaTenisCadastradas.setVisibleRowCount(5);
				panel.setBounds(25, 50, 350, 120);
				barraScroll.getViewport().add(listaTenisCadastradas);
				//listaTenisCadastradas.setBounds(25, 50, 350, 120);
				panel.add(barraScroll);

				cadastroTenis.setBounds(130, 177, 120, 30);
				atualizaTenis.setBounds(255, 177, 120, 30);

				janela.setLayout(null);

				janela.add(titulo);
				//janela.add(listaTenisCadastradas);
				janela.add(panel);
				janela.add(cadastroTenis);
				janela.add(atualizaTenis);


				janela.setSize(400, 250);
				janela.setVisible(true);

				cadastroTenis.addActionListener(this);
				atualizaTenis.addActionListener(this);
				listaTenisCadastradas.addListSelectionListener(this);

				break;

			case 5:// Mostrar dados de saltos cadastrados (JList)
				String[] listaSalto = new String[50];
//			Bota bota = new Bota();
				s.preCadastrosSalto();

				listaSalto = s.listaNomesSapatos();
				listaSaltoCadastradas = new JList<String>(listaSalto);
				janela = new JFrame("Loja de Sapatos - Saltos");
				titulo = new JLabel("Saltos Cadastrados");
				cadastroSalto = new JButton("Cadastrar salto");
				cadastroSalto.setFont(new Font("Arial", Font.PLAIN, 11));
				atualizaSalto = new JButton("Atualizar lista");
				atualizaSalto.setFont(new Font("Arial", Font.PLAIN, 11));

				titulo.setFont(new Font("Arial", Font.BOLD, 15));
				titulo.setBounds(125, 10, 250, 30);
				//listaSaltoCadastradas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
				//listaSaltoCadastradas.setVisibleRowCount(5);
				panel.setBounds(25, 50, 350, 120);
				barraScroll.getViewport().add(listaBotasCadastradas);
				//listaSaltoCadastradas.setBounds(25, 50, 350, 120);
				panel.add(barraScroll);

				cadastroSalto.setBounds(130, 177, 120, 30);
				atualizaSalto.setBounds(255, 177, 120, 30);

				janela.setLayout(null);

				janela.add(titulo);
				//janela.add(listaBotasCadastradas);
				janela.add(panel);
				janela.add(cadastroSalto);
				janela.add(atualizaSalto);


				janela.setSize(400, 250);
				janela.setVisible(true);

				cadastroSalto.addActionListener(this);
				atualizaSalto.addActionListener(this);
				listaSaltoCadastradas.addListSelectionListener(this);

				break;
			
		default:
			JOptionPane.showMessageDialog(null,"Opção não encontrada!", null, 
					JOptionPane.ERROR_MESSAGE);
		}
	}

	//Captura eventos relacionados aos botões da interface
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		//Cadastro de nova bota
		if(src == cadastroBota)
			new TelaDadosBota().cadastrarEditar(1, b, this, 0);
			System.out.println("cadastro bota clicado");

		// Atualiza a lista
		if(src == atualizaBota) {
			listaBotasCadastradas.setListData(b.listaNomesSapatos());			
			listaBotasCadastradas.updateUI();
			//System.out.println("atualiza bota clicado");
		}
		
		
		if(src == cadastroChinelo) 
			new TelaDadosChinelo().cadastrarEditar(2,c, this, 0);
			System.out.println("cadastro chinelo clicado");

		if(src == atualizaChinelo) {
			listaChinelosCadastradas.setListData(c.listaNomesSapatos());			
			listaChinelosCadastradas.updateUI();
			//System.out.println("atualiza chinelo clicado");
		}
		
		if(src == cadastroChuteira)
			new TelaDadosChuteira().cadastrarEditar(3, ch, this, 0);
			System.out.println("cadastro chuteira clicado");

		if(src == atualizaChuteira) {
			listaChuteirasCadastrados.setListData(ch.listaNomesSapatos());
			listaChuteirasCadastradas.updateUI();
			System.out.println("atualiza sapato clicado");
		}

		if(src == cadastroSalto)
			new TelaDadosSalto().cadastrarEditar(4, s, this, 0);
			System.out.println("cadastro salto clicado");
			d
		if(src == atualizaSalto) {
			listaSaltosCadastrados.setListData(s.listaNomesSapatos());
			listaSaltosCadastrados.updateUI();
			System.out.println("atualiza salto clicado");
		}
		
		
		if(src == cadastroTenis)
			new TelaDadosTenis().cadastrarEditar(5,t, this, 0);
			System.out.println("cadastro tenis clicado");

		if(src == atualizaTenis) {
			listaTenisCadastrados.setListData(t.listaNomesSapatos());
			listaTenisCadastrados.updateUI();
			System.out.println("atualiza tenis clicado");
		}

		// Atualiza a lista
		if(src == bota) {
			mostrarSapatos(1);
			System.out.println("botao bota clicado");
		}
			
		if(src == chinelo) {
			mostrarSapatos(2);
			System.out.println("botao chinelo clicado");
		}
		if(src == chuteira) {
			mostrarSapatos(3);
			System.out.println("botao chuteira clicado");
		}
		if(src == tenis) {
			mostrarSapatos(4);
			System.out.println("botao tenis clicado");
		}
		if(src == salto) {
			mostrarSapatos(5);
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
				new TelaDadosBota().cadastrarEditar(1, b, this,
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

	*********************************************************************

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


			try {
				if(e.getValueIsAdjusting() && src == listaChinelosCadastradas) {
					new TelaDadosChinelo().cadastrarEditar(3, c, this,
							listaChinelosCadastradas.getSelectedIndex());
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

		try {
			if(e.getValueIsAdjusting() && src == listaChuteirasCadastradas) {
				new TelaDadosChuteira().cadastrarEditar(4, ch, this,
						listaChuteirasCadastradas.getSelectedIndex());
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

		try {
			if(e.getValueIsAdjusting() && src == listaTenisCadastradas) {
				new TelaDadosTenis().cadastrarEditar(5, t , this,
						listaTenisCadastradas.getSelectedIndex());
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

		try {
			if(e.getValueIsAdjusting() && src == listaSaltosCadastradas) {
				new TelaDadosSalto().cadastrarEditar(2, s, this,
						listaSaltosCadastradas.getSelectedIndex());
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
			**********************************************************

	}

}