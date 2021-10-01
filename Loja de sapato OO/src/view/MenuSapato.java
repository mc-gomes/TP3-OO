package view;
        import java.awt.*;
        import java.awt.event.*;
        import javax.swing.*;
        import modelo.*;

public class MenuPrincipal implements ActionListener {

    private static JFrame janela = new JFrame("Loja de Sapato");
    //private static JPanel fundo = new JPanel();
    private static JLabel titulo = new JLabel("Escolha");
    private static JButton bota = new JButton("Bota");
    private static JButton chinelo = new JButton("Chinelo");
    private static JButton chuteira = new JButton("Chuteira");
    private static JButton tenis = new JButton("Tenis");
    private static JButton salto = new JButton("Salto");
    private static JButton sair = new JButton("Sair");


    public MenuPrincipal() {
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int width = 400, height = 300;
        titulo.setFont(new Font("Arial", Font.BOLD, 15));
        titulo.setBounds(120, 10, 150, 30);
        bota.setBounds(135, 50, 100, 30);
        chinelo.setBounds(135, 150, 100, 30);
        chuteira.setBounds(135, 100, 100, 30);
        tenis.setBounds(135, 150, 100, 30);
        salto.setBounds(135, 100, 100, 30);
        sair.setBounds(135, 200, 100, 30);

        //fundo.setPreferredSize(new Dimension(600,400));
        janela.setLayout(null); //new BorderLayout()

        janela.add(titulo);
        janela.add(bota);
        janela.add(chinelo);
        janela.add(chuteira);
        janela.add(tenis);
        janela.add(salto);
        janela.add(sair);

        //janela.add(fundo);

        janela.setSize(width, height);
        //janela.pack();
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
    }

    public static void main(String[] args) {
        MenuSapato menuS = new MenuSapato();

        bota.addActionListener(menuS);
        chinelo.addActionListener(menuS);
        chuteira.addActionListener(menuS);
        tenis.addActionListener(menuS);
        salto.addActionListener(menuS);
        sair.addActionListener(menuS);
    }

    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if(src == bota)
            System.out.println("botao bota clicado");
             new TelaBota().mostrarDados();

        if(src == chinelo)
            System.out.println("botao chinelo clicado");
        //new TelaChinelo().mostrarDados(dados, 2);

        if(src == chuteira)
            System.out.println("botao chuteira clicado");
        //new TelaChuteira().mostrarDados();

        if(src == tenis)
            //System.out.println("botao tenis clicado");
            new TelaTenis().mostrarDados();

        if(src == salto)
            System.out.println("botao sapato clicado");
        //new TelaSalto().mostrarDados(dados, 2);

        if (src == sair)
            janela.dispose();
    }

}
