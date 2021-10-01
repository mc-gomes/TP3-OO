package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import modelo.*;


public class TelaDadosSalto implements ActionListener, ListSelectionListener package view;
        import java.awt.*;
        import java.awt.event.*;
        import javax.swing.*;
        import javax.swing.event.*;
        import modelo.*;

public class TelaDadosSalto implements ActionListener, ListSelectionListener {
    private JFrame janela;
    private JLabel titulo;
    private JLabel labelMarca = new JLabel("Marca:");
    private JTextField valorMarca;
    private JLabel labelPreco = new JLabel("Preco:");
    private JTextField valorPreco;
    private JLabel labelQtd = new JLabel("Quantidade:");
    private JTextField valorQtd;
    private JLabel labelCor = new JLabel("Cor:");
    private JTextField valorCor;
    private JLabel labelTam  = new JLabel("Tamanho do salto (cm):");
    private JTextField valorTam;
    private JLabel labelTipo = new JLabel("Tipo:");
    private JTextField valorTipo;
    private JButton botaoExcluir = new JButton("Excluir");
    private JButton botaoSalvar = new JButton("Salvar");
    private int posicao;
    private int opcao;
    private String s;

    public void cadastrarEditar(int op, salto c,
                                TelaDadosSalto p, int pos) {

        opcao = op;
        posicao = pos;
        salto= c;

        if (op == 1) s = "Cadastro de salto";
        if (op == 2) s = "Dados do salto";

        janela = new JFrame(s);

        if (op == 1) { //Não preenche com dados

            valorMarca = new JTextField(200);
            valorPreco = new JTextField(200);
            valorQtd = new JTextField(200);
            valorCor = new JTextField(100);
            valorTam = new JTextField(100);
            valorTipo = new JTextField(100);
            botaoSalvar.setBounds(265, 210, 115, 30);
        }
        //Preenche com dados do bota clicado
        if (op == 2) {

            valorMarca = new JTextField(salto.retornaDado(pos, 1), 200);
            valorPreco = new JTextField(salto.retornaDado(pos, 2), 200);
            valorQtd = new JTextField(salto.retornaDado(pos, 3), 200);
            valorCor = new JTextField(salto.retornaDado(pos, 4), 200);
            valorTam = new JTextField(salto.retornaDado(pos, 5), 200);
            valorTipo = new JTextField(salto.retornaDado(pos, 6), 200);

            botaoSalvar.setBounds(130, 210, 115, 30);
            botaoExcluir.setBounds(265, 210, 115, 30);
            this.janela.add(botaoExcluir);

        }


        labelMarca.setBounds(30, 20, 150, 25);
        valorMarca.setBounds(200, 20, 180, 25);

        labelPreco.setBounds(30, 50, 150, 25);
        valorPreco.setBounds(200, 50, 180, 25);

        labelQtd.setBounds(30, 80, 150, 25);
        valorQtd.setBounds(200, 80, 180, 25);

        labelEnd.setBounds(30, 110, 80, 25);
        valorCor.setBounds(30, 140, 155, 25);

        labelTam.setBounds(200, 110, 78, 25);
        valorTam.setBounds(200, 140, 140, 25);

        labelTipo.setBounds(200, 110, 78, 25);
        valorTipo.setBounds(200, 140, 140, 25);


        this.janela.add(labelMarca);
        this.janela.add(valorMarca);
        this.janela.add(labelPreco);
        this.janela.add(valorPreco);
        this.janela.add(labelQtd);
        this.janela.add(valorQtd);
        this.janela.add(labelCor);
        this.janela.add(valorCor);
        this.janela.add(labelTam);
        this.janela.add(valorTam);
        this.janela.add(labelTipo);
        this.janela.add(valorTipo);
        this.janela.add(botaoSalvar);

        this.janela.setLayout(null);

        this.janela.setSize(400, 300);
        janela.setLocationRelativeTo(null);
        this.janela.setVisible(true);

        botaoSalvar.addActionListener(this);
        botaoExcluir.addActionListener(this);
    }


    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if(src == botaoSalvar) {

            String marca, preco, quantidade, cor, tipo;

            try {
                boolean res=true;

                marca = valorMarca.getText();
                preco = valorPreco.getText();
                quantidade = valorQtd.getText();
                cor = valorCor.getText();
                tam = valorTam.getText();
                tipo = valorTipo.getText();


                String[] dados = {marca, preco, quantidade, cor,tam,tipo};

                // verifica se há algum campo vazio
                if ("".equals(marca) || "".equals(preco) || "".equals(quantidade)|| "".equals(cor) || "".equals(tam) || "".equals(tipo)) {
                    res = false;
                }

                if(opcao == 1) { //cadastro de novo salto

                    if(res) {
                        Salto novosalto = new Salto(marca, preco, quantidade, cor,tam,tipo);
                        salto.cadastrar(novosalto);
                        mensagemSucessoCadastro();
                    }
                    else {
                        mensagemErroCadastro();
                    }
                }
                else if (opcao == 2) {
                    // edição dados salto
                    if(res){
                        for (int i=1; i< 9; i++) {
                            salto.editar(posicao, dados[i-1], i);
                        }
                        mensagemSucessoCadastro();
                    }
                    else mensagemErroCadastro();
                }

            } catch (NullPointerException exc1) {
                mensagemErroCadastro();
            } catch (NumberFormatException exc2) {
                mensagemErroCadastro();
            }
        }

        if(src == botaoExcluir) {
            boolean res = false;

            salto.deletar(posicao);
            if (!res) mensagemSucessoExclusao();
            else mensagemErroExclusaoBota();

        }
    }

    public void mensagemSucessoExclusao() {
        JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!\n"
                        + "Lembre-se de atualizar a lista de cadastro!", null,
                JOptionPane.INFORMATION_MESSAGE);
        janela.dispose();
    }

    public void mensagemSucessoCadastro() {
        JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!\n"
                        + "Lembre-se de atualizar a lista de cadastro!", null,
                JOptionPane.INFORMATION_MESSAGE);
        janela.dispose();
    }

    public void mensagemErroDeAcesso() {
        JOptionPane.showMessageDialog(null,"ERRO AO BUSCAR SALTO!\n\n"
                        + "salto não encontrado!", null,
                JOptionPane.ERROR_MESSAGE);
    }

    public void mensagemErroCadastro() {
        JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n "
                        + "Pode ter ocorrido um dos dois erros a seguir:  \n"
                        + "1. Nem todos os campos foram preenchidos \n"
                        + "2. Quantidade registrada não são números", null,
                JOptionPane.ERROR_MESSAGE);
    }

    public void mensagemErroExclusaoSalto() {
        JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n "
                        + "Verifique se o salto está cadastrado\n"
                        + " e tente novamente.", null,
                JOptionPane.ERROR_MESSAGE);
    }
}
