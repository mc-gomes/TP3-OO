package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import modelo.*;

/**
 * Classe principal que implementa o método main
 * @author Matheus Costa
 *
 */
public class MenuPrincipal implements ActionListener {
	
	private static JFrame janela = new JFrame("Loja de Sapato");
	private static JLabel titulo = new JLabel("Menu Principal");
	private static JButton botaoCliente = new JButton("Cliente");
	private static JButton botaoSapato = new JButton("Sapato");
	private static JButton botaoVenda = new JButton("Venda");
	private static JButton sair = new JButton("Sair");
	
	/**
	 * Construtor que cria um objeto JFrame e apresenta uma tela de menu
	 */
	public MenuPrincipal() {
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		titulo.setFont(new Font("Arial", Font.BOLD, 15));
		titulo.setBounds(125, 10, 150, 30);
		botaoCliente.setBounds(135, 50, 100, 30);
		botaoSapato.setBounds(135, 100, 100, 30);
		botaoVenda.setBounds(135, 150, 100, 30);
		sair.setBounds(135, 200, 100, 30);
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(botaoCliente);
		janela.add(botaoSapato);
		janela.add(botaoVenda);
		janela.add(sair);
		
		
		janela.setSize(400, 300);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
	}
	
	public static void main(String[] args) {
		MenuPrincipal menu = new MenuPrincipal();
		
		botaoCliente.addActionListener(menu);
		botaoSapato.addActionListener(menu);
		botaoVenda.addActionListener(menu);
		sair.addActionListener(menu);
	}
	
	/**
	 * Método que analisa qual dos botões que aparecem na tela de menu
	 * foi clicado e redireciona para uma outra tela específica 
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == botaoCliente)
			new TelaCliente().mostrarDados();
		
		if(src == botaoSapato)
			new TelaSapatos().menuDeOpcoes();
		
		if(src == botaoVenda)
			new TelaVendaCliente().mostraClientes();
		
		if (src == sair)
			janela.dispose();
	}

}
