package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import modelo.*;


public class TelaSalto implements ActionListener, ListSelectionListener package view;
        import java.awt.*;
        import java.awt.event.*;
        import javax.swing.*;
        import javax.swing.event.*;
        import modelo.*;


public class TelaSalto implements ActionListener, ListSelectionListener {
    private JFrame janela;
    private JLabel titulo;
    private JButton cadastroSalto;
    private JButton atualizaSalto;
    private JList<String> listaSaltoCadastrados;
    private String[] listaNomes = new String[50];
    Salto s = new Salto();

    public void listaSalto() {
        listaNomes = s.listaNomesSalto();
    }

    public void mostrarDados(){
        s.preCadastrosSalto();
        listaSalto();// listaNomes = s.listaNomesSalto();

        listaSaltoCadastrados = new JList<String>(listaNomes);
        janela = new JFrame("Loja de Sapatos - Salto");
        titulo = new JLabel("Salto Cadastrados");
        cadastroSalto = new JButton("Cadastrar");
        atualizaSalto = new JButton("Atualizar");

        titulo.setFont(new Font("Arial", Font.BOLD, 15));
        titulo.setBounds(90, 10, 250, 30);
        listaSaltoCadastrados.setBounds(20, 50, 350, 120);
        listaSaltoCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaSaltoCadastrados.setVisibleRowCount(10);

        cadastroSalto.setBounds(70, 177, 120, 30);
        atualizaSalto.setBounds(200, 177, 100, 30);

        janela.setLayout(null);

        janela.add(titulo);
        janela.add(listaSaltoCadastrados);
        janela.add(cadastroSalto);
        janela.add(atualizaSalto);

        janela.setSize(400, 250);
        janela.setVisible(true);

        cadastroSalto.addActionListener(this);
        atualizaSalto.addActionListener(this);
        listaSaltoCadastrados.addListSelectionListener(this);

//		JOptionPane.showMessageDialog(null,"Opção não encontrada!", null, 
//					JOptionPane.ERROR_MESSAGE);

    }


    //Captura eventos relacionados aos botões da interface
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        //Cadastro de novo aluno
        if(src == cadastroSalto)
            new TelaDadosSalto().cadastrarEditar(1, c, this, 0);
        //System.out.println("cadastro Salto clicado");

        // Atualiza a lista de nomes de alunos mostrada no JList
        if(src == atualizaSalto) {
            listaSalto();
            listaSaltoCadastrados.setListData(listaNomes);
            listaSaltoCadastrados.updateUI();
//			System.out.println("botao atualizar clicado");
        }
    }

    //Captura eventos relacionados ao JList
    public void valueChanged(ListSelectionEvent e) {
        Object src = e.getSource();

        try {
            if(e.getValueIsAdjusting() && src == listaSaltoCadastrados) {
                new TelaDadosSalto().cadastrarEditar(2, c, this,
                        listaSaltoCadastrados.getSelectedIndex());
            }
        }catch (NullPointerException exc) {
            JOptionPane.showMessageDialog(null,"ERRO!\n\n"
                            + "Salto não econtrado!", null,
                    JOptionPane.ERROR_MESSAGE);
        }catch (IndexOutOfBoundsException exc) {
            JOptionPane.showMessageDialog(null,"ERRO!\n\n"
                            + "Salto não econtrado!", null,
                    JOptionPane.ERROR_MESSAGE);
        }

    }

}