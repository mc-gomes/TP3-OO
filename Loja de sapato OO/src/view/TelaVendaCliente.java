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

public class TelaVendaCliente implements ActionListener, ListSelectionListener {		
	private JFrame janela;
	private JLabel titulo;
	private JLabel subTit;
	private JLabel msg = new JLabel("Selecione um cliente para cadastrar uma venda");
	private JButton cancelar;
	private JPanel panel = new JPanel(new BorderLayout());
	private JScrollPane barraScroll = new JScrollPane();
	private JList<String> listaClientesCadastrados;
	private String[] listaNomes = new String[50];
	Cliente c = new Cliente();
	Bota b = new Bota();
	Chinelo chi = new Chinelo();
	Chuteira ch = new Chuteira();
	Salto s = new Salto();
	Tenis t = new Tenis();
	
	/**
	 * Método que exibe uma tela com lista de 
	 * clientes cadastrados s
	 */
	
	public void listaClientes() {
		listaNomes = c.listaNomesClientes();
	}

	public void mostraClientes(Cliente cli, Bota b1,Chinelo c1,Chuteira ch1,Salto s1,Tenis t1){
		c=cli;
		b=b1;
		chi=c1;
		ch=ch1;
		s=s1;
		t=t1;
		
		listaClientes();

		listaClientesCadastrados = new JList<String>(listaNomes);
		janela = new JFrame("Loja de Sapatos - Venda");
		titulo = new JLabel("Cadastro de Venda");
		subTit = new JLabel("Lista de clientes:");
		cancelar = new JButton("Cancelar");
		
		titulo.setFont(new Font("Arial", Font.BOLD, 15));
		titulo.setBounds(120, 10, 250, 30);
		subTit.setBounds(25, 45, 200, 20);
		msg.setFont(new Font("Arial", Font.PLAIN, 10));
		msg.setBounds(25, 195, 300, 10);
		panel.setBounds(25, 70, 350, 120);
		barraScroll.getViewport().add(listaClientesCadastrados);
		panel.add(barraScroll);
		
		cancelar.setBounds(260, 220, 115, 30); 
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(subTit);
		janela.add(panel);
		janela.add(msg);
		janela.add(cancelar);
		
		janela.setSize(400, 300);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		
		cancelar.addActionListener(this);
		listaClientesCadastrados.addListSelectionListener(this);

	}	
	

	//Captura eventos relacionados aos botÃµes da interface
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == cancelar)
			janela.dispose();

	}

	//Captura eventos relacionados ao JList
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		try {
			if(e.getValueIsAdjusting() && src == listaClientesCadastrados) {
				new TelaVendaSapato().menuDeEscolha(c.retornaCliente(listaClientesCadastrados.getSelectedIndex()),
						b,chi,ch,s,t);
			}
			
		}catch (IndexOutOfBoundsException exc) {
			JOptionPane.showMessageDialog(null,"ERRO!\n\n"
					+ "Cliente nÃ£o econtrado!", null, 
					JOptionPane.ERROR_MESSAGE);
	    }

	}

}