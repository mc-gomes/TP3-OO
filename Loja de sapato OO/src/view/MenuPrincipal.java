package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import modelo.*;

public class MenuPrincipal implements ActionListener {
	
	private static JFrame janela = new JFrame("Loja de Sapato");
	private static JLabel titulo = new JLabel("Menu Principal");
	private static JButton cliente = new JButton("Cliente");
	private static JButton sapato = new JButton("Sapato");
	private static JButton venda = new JButton("Venda");
	private static JButton sair = new JButton("Sair");
	
	
	public MenuPrincipal() {
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		titulo.setFont(new Font("Arial", Font.BOLD, 15));
		titulo.setBounds(125, 10, 150, 30);
		cliente.setBounds(135, 50, 100, 30);
		venda.setBounds(135, 150, 100, 30);
		sapato.setBounds(135, 100, 100, 30);
		sair.setBounds(135, 200, 100, 30);
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(cliente);
		janela.add(sapato);
		janela.add(venda);
		janela.add(sair);
		
		
		janela.setSize(400, 300);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
	}

	public static void main(String[] args) {
		MenuPrincipal menu = new MenuPrincipal();
		
		cliente.addActionListener(menu);
		sapato.addActionListener(menu);
		venda.addActionListener(menu);
		sair.addActionListener(menu);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == cliente)
			new TelaCliente().mostrarDados();
		
		if(src == sapato)
			new TelaSapatos().menuDeOpcoes();
		
		if(src == venda)
			new TelaVendaCliente().mostraClientes();
		
		if (src == sair) {
			janela.dispose();
			
		}
	}

}
