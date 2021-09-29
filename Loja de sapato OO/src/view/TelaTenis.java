package view;
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
    Tenis t = new Tenis;

    public void mostrarDados(){

        for(int i=0; i< t.listaDeTenis.size(); i++) {
            listaNomes[i] = t.listaDeTenis.get(i).getNome();
        }

        //listaNomes = t.listaDeTenis.get(0).getNome();
        listaTenisCadastrados = new JList<String>(listaNomes);
        janela = new JFrame("Loja de Sapatos - Tenis");
        titulo = new JLabel("Teniss Cadastrados");
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
            new TelaDadosTenis().cadastrarEditar(2, s, this, 0);
        //System.out.println("cadastro Tenis clicado");

        // Atualiza a lista de nomes de alunos mostrada no JList*******
        if(src == atualizaTenis) {
            //listaTenisCadastrados.setListData(new ControleAluno(dados).getNomeAluno());*********
            //listaTenisCadastrados.updateUI();
            System.out.println("botao atualizar clicado");
        }


    }

    //Captura eventos relacionados ao JList
    public void valueChanged(ListSelectionEvent e) {
        Object src = e.getSource();

        if(e.getValueIsAdjusting() && src == listaTenisCadastrados) {
            new TelaDadosTenis().cadastrarEditar(2, dados, this,
                    listaTenisCadastrados.getSelectedIndex());
        }

    }

}