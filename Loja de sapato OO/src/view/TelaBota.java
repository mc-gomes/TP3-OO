package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import modelo.*;


public class TelaBota implements ActionListener, ListSelectionListener package view;
        import java.awt.*;
        import java.awt.event.*;
        import javax.swing.*;
        import javax.swing.event.*;
        import modelo.*;


public class TelaBota implements ActionListener, ListSelectionListener {
    private JFrame janela;
    private JLabel titulo;
    private JButton cadastroBota;
    private JButton atualizaBota;
    private JList<String> listaBotaCadastrados;
    private String[] listaNomes = new String[50];
    Bota b = new Bota();

    public void listaBota() {
        listaNomes = b.listaNomesBota();
    }

    public void mostrarDados(){
        b.preCadastrosBota();
        listaBota();// listaNomes = b.listaNomesBota();

        listaBotaCadastrados = new JList<String>(listaNomes);
        janela = new JFrame("Loja de Sapatos - Bota");
        titulo = new JLabel("Bota Cadastrados");
        cadastroBota = new JButton("Cadastrar");
        atualizaBota = new JButton("Atualizar");

        titulo.setFont(new Font("Arial", Font.BOLD, 15));
        titulo.setBounds(90, 10, 250, 30);
        listaBotaCadastrados.setBounds(20, 50, 350, 120);
        listaBotaCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaBotaCadastrados.setVisibleRowCount(10);

        cadastroBota.setBounds(70, 177, 120, 30);
        atualizaBota.setBounds(200, 177, 100, 30);

        janela.setLayout(null);

        janela.add(titulo);
        janela.add(listaBotaCadastrados);
        janela.add(cadastroBota);
        janela.add(atualizaBota);

        janela.setSize(400, 250);
        janela.setVisible(true);

        cadastroBota.addActionListener(this);
        atualizaBota.addActionListener(this);
        listaBotaCadastrados.addListSelectionListener(this);

//		JOptionPane.showMessageDialog(null,"Opção não encontrada!", null, 
//					JOptionPane.ERROR_MESSAGE);

    }


    //Captura eventos relacionados aos botões da interface
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        //Cadastro de novo aluno
        if(src == cadastroBota)
            new TelaDadosBota().cadastrarEditar(1, c, this, 0);
        //System.out.println("cadastro Bota clicado");

        // Atualiza a lista de nomes de alunos mostrada no JList
        if(src == atualizaBota) {
            listaBota();
            listaBotaCadastrados.setListData(listaNomes);
            listaBotaCadastrados.updateUI();
//			System.out.println("botao atualizar clicado");
        }
    }

    //Captura eventos relacionados ao JList
    public void valueChanged(ListSelectionEvent e) {
        Object src = e.getSource();

        try {
            if(e.getValueIsAdjusting() && src == listaBotaCadastrados) {
                new TelaDadosBota().cadastrarEditar(2, c, this,
                        listaBotaCadastrados.getSelectedIndex());
            }
        }catch (NullPointerException exc) {
            JOptionPane.showMessageDialog(null,"ERRO!\n\n"
                            + "Bota não econtrado!", null,
                    JOptionPane.ERROR_MESSAGE);
        }catch (IndexOutOfBoundsException exc) {
            JOptionPane.showMessageDialog(null,"ERRO!\n\n"
                            + "Bota não econtrado!", null,
                    JOptionPane.ERROR_MESSAGE);
        }

    }

}