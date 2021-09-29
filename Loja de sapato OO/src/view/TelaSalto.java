package view;
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
    Salto s = new Salto;

    public void mostrarDados(){

        for(int i=0; i< s.listaDeSalto.size(); i++) {
            listaNomes[i] = s.listaDeSalto.get(i).getNome();
        }

        //listaNomes = s.listaDeSalto.get(0).getNome();
        listaSaltoCadastrados = new JList<String>(listaNomes);
        janela = new JFrame("Loja de Sapatos - Salto");
        titulo = new JLabel("Saltos Cadastrados");
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
            new TelaDadosSalto().cadastrarEditar(2, s, this, 0);
        //System.out.println("cadastro Salto clicado");

        // Atualiza a lista de nomes de alunos mostrada no JList*******
        if(src == atualizaSalto) {
            //listaSaltoCadastrados.setListData(new ControleAluno(dados).getNomeAluno());*********
            //listaSaltoCadastrados.updateUI();
            System.out.println("botao atualizar clicado");
        }


    }

    //Captura eventos relacionados ao JList
    public void valueChanged(ListSelectionEvent e) {
        Object src = e.getSource();

        if(e.getValueIsAdjusting() && src == listaSaltoCadastrados) {
            new TelaDadosSalto().cadastrarEditar(2, dados, this,
                    listaSaltoCadastrados.getSelectedIndex());
        }

    }

}