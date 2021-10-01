package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import modelo.*;


public class TelaVendaCliente implements ActionListener, ListSelectionListener {		
	private JFrame janela;
	private JLabel titulo;
	private JLabel subTit;
	private JLabel msg = new JLabel("Selecione um cliente para cadastrar uma venda");
	private JButton cancelar;
	private JList<String> listaClientesCadastrados;
	private String[] listaNomes = new String[50];
	Cliente c = new Cliente();
	
	public void listaClientes() {
		listaNomes = c.listaNomesClientes();
	}

	public void mostraClientes(){
		c.preCadastrosCliente();
		listaClientes();// listaNomes = c.listaNomesClientes();

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
		listaClientesCadastrados.setBounds(25, 70, 350, 120);
		listaClientesCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaClientesCadastrados.setVisibleRowCount(10);
		
		cancelar.setBounds(260, 220, 115, 30); // 265, 210, 115, 30
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(subTit);
		janela.add(msg);
		janela.add(listaClientesCadastrados);
		janela.add(cancelar);
		
		janela.setSize(400, 300);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		
		cancelar.addActionListener(this);
		listaClientesCadastrados.addListSelectionListener(this);

	}	
	

	//Captura eventos relacionados aos botões da interface
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
//				new TelaVendaSapato().cadastrarVenda(2, c, this, 
//						listaClientesCadastrados.getSelectedIndex());
				System.out.println("algum cliente foi clicado");
			}
		}catch (NullPointerException exc) {
			JOptionPane.showMessageDialog(null,"ERRO!\n\n"
					+ "Cliente não econtrado!", null, 
					JOptionPane.ERROR_MESSAGE);
		}catch (IndexOutOfBoundsException exc) {
			JOptionPane.showMessageDialog(null,"ERRO!\n\n"
					+ "Cliente não econtrado!", null, 
					JOptionPane.ERROR_MESSAGE);
	    }

	}

}