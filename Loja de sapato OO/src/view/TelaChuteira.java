package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import modelo.*;


public class TelaChuteira implements ActionListener, ListSelectionListener {
    private JFrame janela;
    private JLabel titulo;
    private JButton cadastroChuteira;
    private JButton atualizaChuteira;
    private JList<String> listaChuteiraCadastrados;
    private String[] listaNomes = new String[50];
    Chuteira ch = new Chuteira;

    public void mostrarDados(){

        for(int i=0; i< ch.listaDeChuteira.size(); i++) {
            listaNomes[i] = ch.listaDeChuteira.get(i).getNome();
        }

        //listaNomes = ch.listaDeChuteira.get(0).getNome();
        listaChuteiraCadastrados = new JList<String>(listaNomes);
        janela = new JFrame("Loja de Sapatos - Chuteira");
        titulo = new JLabel("Chuteiras Cadastradas");
        cadastroChuteira = new JButton("Cadastrar");
        atualizaChuteira = new JButton("Atualizar");

        titulo.setFont(new Font("Arial", Font.BOLD, 15));
        titulo.setBounds(90, 10, 250, 30);
        listaChuteiraCadastrados.setBounds(20, 50, 350, 120);
        listaChuteiraCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaChuteiraCadastrados.setVisibleRowCount(10);

        cadastroChuteira.setBounds(70, 177, 120, 30);
        atualizaChuteira.setBounds(200, 177, 100, 30);

        janela.setLayout(null);

        janela.add(titulo);
        janela.add(listaChuteiraCadastrados);
        janela.add(cadastroChuteira);
        janela.add(atualizaChuteira);

        janela.setSize(400, 250);
        janela.setVisible(true);

        cadastroChuteira.addActionListener(this);
        atualizaChuteira.addActionListener(this);
        listaChuteiraCadastrados.addListSelectionListener(this);

//		JOptionPane.showMessageDialog(null,"Opção não encontrada!", null,
//					JOptionPane.ERROR_MESSAGE);

    }


    //Captura eventos relacionados aos botões da interface
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        //Cadastro de novo aluno
        if(src == cadastroChuteira)
            new TelaDadosChuteira().cadastrarEditar(2, s, this, 0);
        //System.out.println("cadastro Chuteira clicado");

        // Atualiza a lista de nomes de alunos mostrada no JList*******
        if(src == atualizaChuteira) {
            //listaChuteiraCadastrados.setListData(new ControleAluno(dados).getNomeAluno());*********
            //listaChuteiraCadastrados.updateUI();
            System.out.println("Chuteirao atualizar clicado");
        }


    }

    //Captura eventos relacionados ao JList
    public void valueChanged(ListSelectionEvent e) {
        Object src = e.getSource();

        if(e.getValueIsAdjusting() && src == listaChuteiraCadastrados) {
            new TelaDadosChuteira().cadastrarEditar(2, dados, this,
                    listaChuteiraCadastrados.getSelectedIndex());
        }

    }

}