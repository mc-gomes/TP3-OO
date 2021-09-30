package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import javax.swing.event.*;
import modelo.*;


public class TelaCliente implements ActionListener, ListSelectionListener {		
	private JFrame janela;
	private JLabel titulo;
	private JButton cadastroCliente;
	private JButton atualizaClientes;
	private JButton voltar;
	private JPanel panel = new JPanel(new BorderLayout());
	private JScrollPane ScrollPane_1 = new JScrollPane();
	private JList<String> listaClientesCadastrados;
	private String[] listaNomes = new String[50];
	Cliente c = new Cliente();
	
	public void listaClientes() {
		listaNomes = c.listaNomesClientes();
	}

	/*public BuscaCliente {

	    JFrame frame = new JFrame("");
	    AutoCompleteDecorator decorator;
	    JComboBox combobox;

	    public BuscaCliente() {
	        combobox = new JComboBox(new listaClientesCadastrados[]{});
	        AutoCompleteDecorator.decorate(combobox);
	        frame.setSize(400,400);
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setLayout(new FlowLayout());

	        frame.add(combobox);
	        frame.setVisible(true);
	    }

	    public static void main(String[] args) {
	       BuscaCliente bc = new BuscaCliente();
	    }
	}*/
	
	
	public void mostrarDados(){
		c.preCadastrosCliente();
		listaClientes();

		listaClientesCadastrados = new JList<String>(listaNomes);
		janela = new JFrame("Loja de Sapatos - Clientes");
		titulo = new JLabel("Clientes Cadastrados");
		cadastroCliente = new JButton("Cadastrar");
		cadastroCliente.setFont(new Font("Arial", Font.PLAIN, 11));
		atualizaClientes = new JButton("Atualizar lista");
		atualizaClientes.setFont(new Font("Arial", Font.PLAIN, 11));
		
		titulo.setFont(new Font("Arial", Font.BOLD, 15));
		titulo.setBounds(125, 10, 250, 30);
		//listaClientesCadastrados.setBounds(25, 50, 350, 120);
		//listaClientesCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		//listaClientesCadastrados.setVisibleRowCount(10);
		panel.setBounds(25, 50, 350, 120);
		//ScrollPane_1.setSize(25, 50);
		ScrollPane_1.getViewport().add(listaClientesCadastrados);
		//ScrollPane_1.setViewportView(listaClientesCadastrados);
		listaClientesCadastrados.setLayoutOrientation(JList.VERTICAL);
        panel.add(ScrollPane_1);
		
		cadastroCliente.setBounds(150, 177, 100, 30);
		atualizaClientes.setBounds(255, 177, 120, 30);
		
		janela.setLayout(null);
		
		janela.add(titulo);
//		janela.add(ScrollPane_1);
//		janela.add(listaClientesCadastrados);
		janela.add(cadastroCliente);
		janela.add(atualizaClientes);
		

		
		janela.add(panel);
//		janela.pack();
		janela.setSize(400, 260);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		
		cadastroCliente.addActionListener(this);
		atualizaClientes.addActionListener(this);
		listaClientesCadastrados.addListSelectionListener(this);
		
	}
//	javax.swing.JScrollPane ScrollPane_1 = new javax.swing.JScrollPane();
//	javax.swing.JList lista = new javax.swing.JList();
//
//	ScrollPane_1.setSize(40,60);
//	ScrollPane_1.add(lista);

	//Captura eventos relacionados aos botões da interface
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		//Cadastro de novo cliente
		if(src == cadastroCliente)
			new TelaDadosCliente().cadastrarEditar(1, c, this, 0);
			//System.out.println("cadastro cliente clicado");

		// Atualiza a lista de nomes de clientes mostrada no JList
		if(src == atualizaClientes) {
			listaClientes();
			listaClientesCadastrados.setListData(listaNomes);			
			listaClientesCadastrados.updateUI();
		}
	}

	//Captura eventos relacionados ao JList
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		try {
			if(e.getValueIsAdjusting() && src == listaClientesCadastrados) {
				new TelaDadosCliente().cadastrarEditar(2, c, this, 
						listaClientesCadastrados.getSelectedIndex());
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