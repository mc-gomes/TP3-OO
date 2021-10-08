package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import javax.swing.event.*;
import modelo.*;

/**
 * Classe responsável por mostrar uma janela com as possíveis ações
 * relacionadas aos clientes
 * @author Matheus Costa
 *
 */
public class TelaCliente implements ActionListener, ListSelectionListener{		
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
	
	/**
	 * Método que armazena os nomes dos clientes cadastrados
	 * em um Array do tipo String para serem exibidos na tela
	 */
	public void listaClientes() {
		listaNomes = c.listaNomesClientes();
	}
	
	/**
	 * Método que cria e mostra uma janela onde, a partir da mesma, é
	 * possível realizar o CRUD de Cliente e realizar uma
	 * operação de busca por um cliente pelo seu CPF
	 */
	public void mostrarDados(){
		c.preCadastrosCliente();
		listaNomes = c.listaNomesClientes();
		
		listaClientesCadastrados = new JList<String>(listaNomes);
		janela = new JFrame("Loja de Sapatos - Clientes");
		titulo = new JLabel("Clientes Cadastrados");
		titulo.setFont(new Font("Arial", Font.BOLD, 15));
		titulo.setBounds(125, 10, 250, 30);
		
		labelBuscar.setFont(new Font("Arial", Font.PLAIN, 11));
		labelBuscar.setBounds(26, 40, 100, 35);
		campoBuscaCPF = new JTextField(200);
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

	/**
	 * Método que identifica e analisa as ações dos botões
	 * apresentados na tela de clientes
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		//Cadastro de novo cliente
		if(src == cadastroCliente)
			new TelaDadosCliente().cadastrarEditar(1, c, 0);

		// Atualiza a lista de nomes de clientes mostrada no JList
		if(src == atualizaClientes) {
			listaClientes();
			listaClientesCadastrados.setListData(listaNomes);			
			listaClientesCadastrados.updateUI();
		}
		
		//Busca um cliente pelo CPF
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
		                + "Pode ter ocorrido um dos erros a seguir:	\n"
		                + "1. Campo de busca com valor vazio\n"
		                + "2. Não há nenhum cliente cadastrado com esse CPF", null,
		        JOptionPane.ERROR_MESSAGE);
			}
		}

		if(src == botaoVoltar)
			janela.dispose();
	
	}

	//Captura eventos relacionados ao JList
	/**
	 * Método que analisa se houve um clique na seção onde aparecem
	 * os clientes. Caso haja um clique no nome de um cliente, ele
	 * redireciona para uma tela que vai mostrar seus dados
	 */
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		try {
			if(e.getValueIsAdjusting() && src == listaClientesCadastrados) {
				new TelaDadosCliente().cadastrarEditar(2, c,
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
