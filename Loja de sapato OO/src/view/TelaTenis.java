package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import modelo.*;


public class TelaTenis implements ActionListener, ListSelectionListener package view;
        import java.awt.*;
        import java.awt.event.*;
        import javax.swing.*;
        import javax.swing.event.*;
        import modelo.*;


public class TelaTenis implements ActionListener, ListSelectionListener {
    private JFrame janela;
    private JLabel titulo;
    private JButton cadastroTenis;
    private JButton atualizaTenis;
    private JList<String> listaTenisCadastrados;
    private String[] listaNomes = new String[50];
    Tenis t = new Tenis();

    public void listaTenis() {
        listaNomes = t.listaNomesTenis();
    }

    public void mostrarDados(){
        t.preCadastrosTenis();
        listaTenis();// listaNomes = t.listaNomesTenis();

        listaTenisCadastrados = new JList<String>(listaNomes);
        janela = new JFrame("Loja de Sapatos - Tenis");
        titulo = new JLabel("Tenis Cadastrados");
        cadastroTenis = new JButton("Cadastrar");
        atualizaTenis = new JButton("Atualizar");

        titulo.setFont(new Font("Arial", Font.BOLD, 15));
        titulo.setBounds(90, 10, 250, 30);
        listaTenisCadastrados.setBounds(20, 50, 350, 120);
        listaTenisCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaTenisCadastrados.setVisibleRowCount(10);

        cadastroTenis.setBounds(70, 177, 120, 30);
        atualizaTenis.setBounds(200, 177, 100, 30);

        janela.setLayout(null);

        janela.add(titulo);
        janela.add(listaTenisCadastrados);
        janela.add(cadastroTenis);
        janela.add(atualizaTenis);

        janela.setSize(400, 250);
        janela.setVisible(true);

        cadastroTenis.addActionListener(this);
        atualizaTenis.addActionListener(this);
        listaTenisCadastrados.addListSelectionListener(this);

//		JOptionPane.showMessageDialog(null,"Opção não encontrada!", null, 
//					JOptionPane.ERROR_MESSAGE);

    }


    //Captura eventos relacionados aos botões da interface
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        //Cadastro de novo aluno
        if(src == cadastroTenis)
            new TelaDadosTenis().cadastrarEditar(1, c, this, 0);
        //System.out.println("cadastro Tenis clicado");

        // Atualiza a lista de nomes de alunos mostrada no JList
        if(src == atualizaTenis) {
            listaTenis();
            listaTenisCadastrados.setListData(listaNomes);
            listaTenisCadastrados.updateUI();
//			System.out.println("botao atualizar clicado");
        }
    }

    //Captura eventos relacionados ao JList
    public void valueChanged(ListSelectionEvent e) {
        Object src = e.getSource();

        try {
            if(e.getValueIsAdjusting() && src == listaTenisCadastrados) {
                new TelaDadosTenis().cadastrarEditar(2, c, this,
                        listaTenisCadastrados.getSelectedIndex());
            }
        }catch (NullPointerException exc) {
            JOptionPane.showMessageDialog(null,"ERRO!\n\n"
                            + "Tenis não econtrado!", null,
                    JOptionPane.ERROR_MESSAGE);
        }catch (IndexOutOfBoundsException exc) {
            JOptionPane.showMessageDialog(null,"ERRO!\n\n"
                            + "Tenis não econtrado!", null,
                    JOptionPane.ERROR_MESSAGE);
        }

    }

}