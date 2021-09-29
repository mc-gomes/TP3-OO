package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import modelo.*;


public class TelaChuteira implements ActionListener, ListSelectionListener package view;
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
    Chuteira c = new Chuteira();

    public void listaChuteira() {
        listaNomes = c.listaNomesChuteira();
    }

    public void mostrarDados(){
        c.preCadastrosChuteira();
        listaChuteira();// listaNomes = c.listaNomesChuteira();

        listaChuteiraCadastrados = new JList<String>(listaNomes);
        janela = new JFrame("Loja de Sapatos - Chuteira");
        titulo = new JLabel("Chuteira Cadastrados");
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
            new TelaDadosChuteira().cadastrarEditar(1, c, this, 0);
        //System.out.println("cadastro Chuteira clicado");

        // Atualiza a lista de nomes de alunos mostrada no JList
        if(src == atualizaChuteira) {
            listaChuteira();
            listaChuteiraCadastrados.setListData(listaNomes);
            listaChuteiraCadastrados.updateUI();
//			System.out.println("botao atualizar clicado");
        }
    }

    //Captura eventos relacionados ao JList
    public void valueChanged(ListSelectionEvent e) {
        Object src = e.getSource();

        try {
            if(e.getValueIsAdjusting() && src == listaChuteiraCadastrados) {
                new TelaDadosChuteira().cadastrarEditar(2, c, this,
                        listaChuteiraCadastrados.getSelectedIndex());
            }
        }catch (NullPointerException exc) {
            JOptionPane.showMessageDialog(null,"ERRO!\n\n"
                            + "Chuteira não econtrado!", null,
                    JOptionPane.ERROR_MESSAGE);
        }catch (IndexOutOfBoundsException exc) {
            JOptionPane.showMessageDialog(null,"ERRO!\n\n"
                            + "Chuteira não econtrado!", null,
                    JOptionPane.ERROR_MESSAGE);
        }

    }

}