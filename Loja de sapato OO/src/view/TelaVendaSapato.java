package view;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.*;

public class TelaVendaSapato implements ActionListener, ListSelectionListener  {

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
    private JButton finalizar= new JButton("Finalizar");
    private JButton cancelar = new JButton("Cancelar");
  
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
	Cliente cli= new Cliente();
	
	/**
	 * Método que exibe uma tela com botões relativos
	 * aos tipos de sapatos: botas, chinelos, chuteiras,
	 * saltos e tênis
	 */
	public void menuDeEscolha(Cliente cliente,Bota b1,Chinelo c1,Chuteira ch1,Salto s1,Tenis t1) {
		cli=cliente ;
		b=b1;
		c=c1;
		ch=ch1;
		s=s1;
		t=t1;
		
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

			titulo.setFont(new Font("Arial", Font.BOLD, 15));
			titulo.setBounds(125, 10, 250, 30);
			panel.setBounds(25, 50, 350, 120);
			barraScroll.getViewport().add(listaBotasCadastradas);
			panel.add(barraScroll);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(panel);

			janela.setSize(400, 250);
			janela.setVisible(true);

			listaBotasCadastradas.addListSelectionListener(this);

			break;

		case 2:// Mostra lista de chinelos cadastrados
			String[] listaChinelo = new String[50];
			
			listaChinelo = c.listaNomesSapatos();
			listaChinelosCadastrados = new JList<String>(listaChinelo);
			janela = new JFrame("Loja de Sapatos - Chinelos");
			titulo = new JLabel("Chinelos Cadastrados");
		
			titulo.setFont(new Font("Arial", Font.BOLD, 15));
			titulo.setBounds(125, 10, 250, 30);
			panel.setBounds(25, 50, 350, 120);
			barraScroll.getViewport().add(listaChinelosCadastrados);
			panel.add(barraScroll);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(panel);
			
			janela.setSize(400, 250);
			janela.setVisible(true);

			listaChinelosCadastrados.addListSelectionListener(this);

			break;
			
		case 3: //Mostra lista de chuteiras cadastradas
			String[] listaChuteira = new String[50];
			
			listaChuteira = ch.listaNomesSapatos();
			listaChuteirasCadastradas = new JList<String>(listaChuteira);
			janela = new JFrame("Loja de Sapatos - Chuteiras");
			titulo = new JLabel("Chuteiras Cadastradas");
			
			titulo.setFont(new Font("Arial", Font.BOLD, 15));
			titulo.setBounds(125, 10, 250, 30);
			panel.setBounds(25, 50, 350, 120);
			barraScroll.getViewport().add(listaChuteirasCadastradas);
			panel.add(barraScroll);
			
			janela.setLayout(null);

			janela.add(titulo);
			janela.add(panel);
			
			janela.setSize(400, 250);
			janela.setVisible(true);

			listaChuteirasCadastradas.addListSelectionListener(this);

			break;
		
		case 4:// Mostra lista de saltos cadastrados
			String[] listaSalto = new String[50];
			
			listaSalto = s.listaNomesSapatos();
			listaSaltosCadastrados = new JList<String>(listaSalto);
			janela = new JFrame("Loja de Sapatos - Saltos");
			titulo = new JLabel("Saltos Cadastrados");
			
			titulo.setFont(new Font("Arial", Font.BOLD, 15));
			titulo.setBounds(125, 10, 250, 30);
			panel.setBounds(25, 50, 350, 120);
			barraScroll.getViewport().add(listaSaltosCadastrados);
			panel.add(barraScroll);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(panel);

			janela.setSize(400, 250);
			janela.setVisible(true);
			
			listaSaltosCadastrados.addListSelectionListener(this);

			break;
		
		case 5:// Mostra lista de tênis cadastrados
			String[] listaTenis = new String[50];
			
			listaTenis = t.listaNomesSapatos();
			listaTenisCadastrados = new JList<String>(listaTenis);
			janela = new JFrame("Loja de Sapatos - Tênis");
			titulo = new JLabel("Tênis Cadastrados");
			
			titulo.setFont(new Font("Arial", Font.BOLD, 15));
			titulo.setBounds(125, 10, 250, 30);
			panel.setBounds(25, 50, 350, 120);
			barraScroll.getViewport().add(listaTenisCadastrados);
			panel.add(barraScroll);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(panel);
			
			janela.setSize(400, 250);
			janela.setVisible(true);

			listaTenisCadastrados.addListSelectionListener(this);

			break;
			
		default:
			JOptionPane.showMessageDialog(null,"OPÇÃO NÃO ENCONTRADA!\n"
					+ "Erro na passagem de parâmetro em:\n "
					+ "Classe 'TelaSapatos.java' ", null, 
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void finalizaVenda(Cliente c1, int pos,int op) {
		String produto="";
		if(op==1) {
			produto = b.retornaBota(pos).getMarca();					
		}
		if(op==2) {
			produto = c.retornaChinelo(pos).getMarca();					
		}if(op==3) {
			produto = ch.retornaChuteira(pos).getMarca();					
		}if(op==4) {
			produto = s.retornaSalto(pos).getMarca();					
		}if(op==5) {
			produto = t.retornaTenis(pos).getMarca();					
		}
		
		String cl = c1.getNome();
		JLabel mensagemCliente = new JLabel("Cliente: "+ cl);
		JLabel mensagemProduto = new JLabel("Produto: "+ produto);
		JLabel mensagem = new JLabel("Cadastro de venda");
		mensagem.setFont(new Font("Arial", Font.BOLD, 15));
		mensagem.setBounds(125, 10, 150, 30);
		mensagemCliente.setBounds(30, 40, 200, 30);
		mensagemProduto.setBounds(30, 70, 200, 30);
		janela = new JFrame("Venda");
		
		finalizar.setFont(new Font("Arial", Font.PLAIN, 11));
		finalizar.setBounds(130, 215, 120, 30);
		cancelar.setFont(new Font("Arial", Font.PLAIN, 11));
		cancelar.setBounds(255, 215, 120, 30);
		
		
		
		janela.setLayout(null);
		janela.add(finalizar);
		janela.add(cancelar);
		janela.add(mensagem);
		janela.add(mensagemCliente);
		janela.add(mensagemProduto);
		
		finalizar.addActionListener(this);
		cancelar.addActionListener(this);
		janela.setSize(400, 300);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		cancelar.addActionListener(this);
		
		listaBotasCadastradas.addListSelectionListener(this);
	}
	
	//Captura eventos relacionados aos botões da interface
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
	
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
		if(src == cancelar) {
				janela.dispose();
		}
		if(src == finalizar) {
			JOptionPane.showMessageDialog(null,"Venda concluída\n"
					, null, 
					JOptionPane.INFORMATION_MESSAGE);
			janela.dispose();
	}
	}

	//Captura eventos relacionados ao JList
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		if(e.getValueIsAdjusting() && src == listaBotasCadastradas) {
			finalizaVenda(cli, listaBotasCadastradas.getSelectedIndex(), 1);
		}
		if(e.getValueIsAdjusting() && src == listaChinelosCadastrados) {
			finalizaVenda(cli, listaChinelosCadastrados.getSelectedIndex(), 2);
		}
		if(e.getValueIsAdjusting() && src == listaChuteirasCadastradas) {
			finalizaVenda(cli, listaChuteirasCadastradas.getSelectedIndex(), 3);
		}
		if(e.getValueIsAdjusting() && src == listaSaltosCadastrados) {
			finalizaVenda(cli, listaSaltosCadastrados.getSelectedIndex(), 4);
		}
		if(e.getValueIsAdjusting() && src == listaTenisCadastrados) {
			finalizaVenda(cli, listaTenisCadastrados.getSelectedIndex(), 5);
		}
		/*try {	

		}catch (NullPointerException exc) {
			JOptionPane.showMessageDialog(null,"Erro ao finalizar venda", null, 
				JOptionPane.INFORMATION_MESSAGE);
		
	    }
*/
	}
}
