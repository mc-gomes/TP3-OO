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
	private JButton botaoVoltar;
	private JLabel labelBuscar = new JLabel("Buscar por CPF :");
	private JTextField campoBuscaCPF = new JTextField();
	private JButton botaoBuscar = new JButton("Buscar");
	private JPanel panel = new JPanel(new BorderLayout());
	private JScrollPane barraScroll = new JScrollPane();
	private JList<String> listaClientesCadastrados;
	private String[] listaNomes = new String[50];
	Cliente c = new Cliente();
	
	public void listaClientes() {
		listaNomes = c.listaNomesClientes();
	}
	
	public void mostrarDados(){
		c.preCadastrosCliente();
		listaClientes();

		listaClientesCadastrados = new JList<String>(listaNomes);
		janela = new JFrame("Loja de Sapatos - Clientes");
		titulo = new JLabel("Clientes Cadastrados");
		titulo.setFont(new Font("Arial", Font.BOLD, 15));
		titulo.setBounds(125, 10, 250, 30);
		
//		listaClientesCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
//		listaClientesCadastrados.setVisibleRowCount(4);
		labelBuscar.setFont(new Font("Arial", Font.PLAIN, 11));
		labelBuscar.setBounds(26, 40, 100, 35);
		//campoBuscaCPF = new JTextField(200);
		campoBuscaCPF.setBounds(135, 46, 130, 25);
		botaoBuscar.setFont(new Font("Arial", Font.PLAIN, 12));
		botaoBuscar.setBounds(275, 45, 100, 25);
		
		panel.setBounds(25, 80, 350, 120);
		listaClientesCadastrados.setLayoutOrientation(JList.VERTICAL);
		barraScroll.getViewport().add(listaClientesCadastrados);
        panel.add(barraScroll);

        cadastroCliente = new JButton("Cadastrar cliente");
        cadastroCliente.setFont(new Font("Arial", Font.PLAIN, 10));
        atualizaClientes = new JButton("Atualizar lista");
        atualizaClientes.setFont(new Font("Arial", Font.PLAIN, 11));
        botaoVoltar = new JButton("Voltar");
		
		cadastroCliente.setBounds(130, 215, 120, 30);
		atualizaClientes.setBounds(255, 215, 120, 30);
		botaoVoltar.setBounds(25, 215, 80, 30);
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(labelBuscar);
		janela.add(campoBuscaCPF);
		janela.add(panel);

		janela.add(cadastroCliente);
		janela.add(atualizaClientes);
		janela.add(botaoVoltar);
		janela.add(botaoBuscar);
	
		janela.pack();
		janela.setSize(400, 300);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		
		cadastroCliente.addActionListener(this);
		atualizaClientes.addActionListener(this);
		botaoVoltar.addActionListener(this);
		botaoBuscar.addActionListener(this);
		listaClientesCadastrados.addListSelectionListener(this);
		
	}

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
		
		if(src == botaoVoltar)
			janela.dispose();
		
		if (src == botaoBuscar) {
			try {
				String cpf = campoBuscaCPF.getText().replaceAll("[\\D]", "");
				int p = c.posicaoClienteCPF(cpf);
				if (p == -1) {
					c.clienteNaoEncontrado();
					listaClientesCadastrados.setListData(c.listaNomesClientes());
					listaClientesCadastrados.updateUI();
				}
				else {
					listaNomes = c.buscarClienteCPF(p);
					listaClientesCadastrados.setListData(listaNomes);
					listaClientesCadastrados.updateUI();
				}
			}catch (NullPointerException exc1) {
				JOptionPane.showMessageDialog(null,"ERRO!\n "
		                + "Campo de busca com valor vazio", null,
		        JOptionPane.ERROR_MESSAGE);
			}
			
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
					+ "Cliente não encontrado!", null, 
					JOptionPane.ERROR_MESSAGE);
		}catch (IndexOutOfBoundsException exc) {
			JOptionPane.showMessageDialog(null,"ERRO!\n\n"
					+ "Cliente não encontrado!", null, 
					JOptionPane.ERROR_MESSAGE);
	    }

	}

}