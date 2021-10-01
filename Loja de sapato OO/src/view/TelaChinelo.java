package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import modelo.*;


public class TelaChinelo implements ActionListener, ListSelectionListener {
    private JFrame janela;
    private JLabel titulo;
    private JButton cadastroChinelo;
    private JButton atualizaChinelo;
    private JList<String> listaChineloCadastrados;
    private String[] listaNomes = new String[50];
    Chinelo c = new Chinelo();

    public void listaChinelo() {
        listaNomes = c.listaNomesChinelo();
    }

    public void mostrarDados(){
        c.preCadastrosChinelo();
        listaChinelo();// listaNomes = c.listaNomesChinelo();

        listaChineloCadastrados = new JList<String>(listaNomes);
        janela = new JFrame("Loja de Sapatos - Chinelo");
        titulo = new JLabel("Chinelo Cadastrados");
        cadastroChinelo = new JButton("Cadastrar");
        atualizaChinelo = new JButton("Atualizar");

        titulo.setFont(new Font("Arial", Font.BOLD, 15));
        titulo.setBounds(90, 10, 250, 30);
        listaChineloCadastrados.setBounds(20, 50, 350, 120);
        listaChineloCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaChineloCadastrados.setVisibleRowCount(10);

        cadastroChinelo.setBounds(70, 177, 120, 30);
        atualizaChinelo.setBounds(200, 177, 100, 30);

        janela.setLayout(null);

        janela.add(titulo);
        janela.add(listaChineloCadastrados);
        janela.add(cadastroChinelo);
        janela.add(atualizaChinelo);

        janela.setSize(400, 250);
        janela.setVisible(true);

        cadastroChinelo.addActionListener(this);
        atualizaChinelo.addActionListener(this);
        listaChineloCadastrados.addListSelectionListener(this);

//		JOptionPane.showMessageDialog(null,"Opção não encontrada!", null, 
//					JOptionPane.ERROR_MESSAGE);

    }


    //Captura eventos relacionados aos botões da interface
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        //Cadastro de novo aluno
        if(src == cadastroChinelo)
            new TelaDadosChinelo().cadastrarEditar(1, c, this, 0);
        //System.out.println("cadastro Chinelo clicado");

        // Atualiza a lista de nomes de alunos mostrada no JList
        if(src == atualizaChinelo) {
            listaChinelo();
            listaChineloCadastrados.setListData(listaNomes);
            listaChineloCadastrados.updateUI();
//			System.out.println("botao atualizar clicado");
        }
    }

    //Captura eventos relacionados ao JList
    public void valueChanged(ListSelectionEvent e) {
        Object src = e.getSource();

        try {
            if(e.getValueIsAdjusting() && src == listaChineloCadastrados) {
                new TelaDadosChinelo().cadastrarEditar(2, c, this,
                        listaChineloCadastrados.getSelectedIndex());
            }
        }catch (NullPointerException exc) {
            JOptionPane.showMessageDialog(null,"ERRO!\n\n"
                            + "Chinelo não econtrado!", null,
                    JOptionPane.ERROR_MESSAGE);
        }catch (IndexOutOfBoundsException exc) {
            JOptionPane.showMessageDialog(null,"ERRO!\n\n"
            JOptionPane.showMessageDialog(null,"ERRO!\n\n"
                            + "Chinelo não econtrado!", null,
                    JOptionPane.ERROR_MESSAGE);
        }

    }

}