package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import modelo.*;


public class TelaDadosChuteira implements ActionListener, ListSelectionListener package view;
        import java.awt.*;
        import java.awt.event.*;
        import javax.swing.*;
        import javax.swing.event.*;
        import modelo.*;

public class TelaDadosChuteira implements ActionListener, ListSelectionListener {
    private JFrame janela;
    private JLabel titulo;
    private JLabel labelNome = new JLabel("Nome:");
    private JTextField valorNome;
    private JLabel labelMarca = new JLabel("Marca:");
    private JTextField valorMarca;
    private JLabel labelPreco = new JLabel("Preco:");
    private JTextField valorPreco;
    private JLabel labelQtd = new JLabel("Quantidade:");
    private JTextField valorQtd;
    private JLabel labelCor = new JLabel("Cor:");
    private JTextField valorCor;
    private JLabel labelTipo = new JLabel("Tipo:");
    private JTextField valorTipo;
    private JLabel labelCa = new JLabel("Altura do cano:");
    private JTextField valorCa;
    private JButton botaoExcluir = new JButton("Excluir");
    private JButton botaoSalvar = new JButton("Salvar");
    private int posicao;
    private int opcao;
    private String s;

    public void cadastrarEditar(int op, chuteira c,
                                TelaDadosChuteira p, int pos) {

        opcao = op;
        posicao = pos;
        chuteira= c;

        if (op == 1) s = "Cadastro de chuteira";
        if (op == 2) s = "Dados do chuteira";

        janela = new JFrame(s);

        if (op == 1) { //Não preenche com dados

            valorNome = new JTextField(100);
            valorMarca = new JTextField(200);
            valorPreco = new JTextField(200);
            valorQtd = new JTextField(200);
            valorCor = new JTextField(100);
            valorTipo = new JTextField(100);
            valorCa = new JTextField(100);

            botaoSalvar.setBounds(265, 210, 115, 30);
        }
        //Preenche com dados do bota clicado
        if (op == 2) {

            valorNome = new JTextField(chuteira.retornaDado(pos, 1), 200);
            valorMarca = new JTextField(chuteira.retornaDado(pos, 2), 200);
            valorPreco = new JTextField(chuteira.retornaDado(pos, 3), 200);
            valorQtd = new JTextField(chuteira.retornaDado(pos, 4), 200);
            valorCor = new JTextField(chuteira.retornaDado(pos, 5), 200);
            valorTipo = new JTextField(chuteira.retornaDado(pos, 6), 200);
            valorCa = new JTextField(chuteira.retornaDado(pos, 7), 200);

            botaoSalvar.setBounds(130, 210, 115, 30);
            botaoExcluir.setBounds(265, 210, 115, 30);
            this.janela.add(botaoExcluir);

        }

        labeNome.setBounds(200, 110, 78, 25);
        valorNome.setBounds(200, 140, 140, 25);

        labelMarca.setBounds(30, 20, 150, 25);
        valorMarca.setBounds(200, 20, 180, 25);

        labelPreco.setBounds(30, 50, 150, 25);
        valorPreco.setBounds(200, 50, 180, 25);

        labelQtd.setBounds(30, 80, 150, 25);
        valorQtd.setBounds(200, 80, 180, 25);

        labelEnd.setBounds(30, 110, 80, 25);
        valorCor.setBounds(30, 140, 155, 25);

        labelTipo.setBounds(200, 110, 78, 25);
        valorTipo.setBounds(200, 140, 140, 25);

        labelCa.setBounds(200, 110, 78, 25);
        valorCa.setBounds(200, 140, 140, 25);


        this.janela.add(labelNome);
        this.janela.add(valorNome);
        this.janela.add(labelMarca);
        this.janela.add(valorMarca);
        this.janela.add(labelPreco);
        this.janela.add(valorPreco);
        this.janela.add(labelQtd);
        this.janela.add(valorQtd);
        this.janela.add(labelCor);
        this.janela.add(valorCor);
        this.janela.add(labelTipo);
        this.janela.add(valorTipo);
        this.janela.add(labelCa);
        this.janela.add(valorCa);
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

            String nome,marca, preco, quantidade, cor, tipo,cano;

            try {
                boolean res=true;

                nome = valorNome.getText();
                marca = valorMarca.getText();
                preco = valorPreco.getText();
                quantidade = valorQtd.getText();
                cor = valorCor.getText();
                tipo = valorTipo.getText();
                cano = valorCa.getText();


                String[] dados = {nome,marca, preco, quantidade, cor,tipo,cano};

                // verifica se há algum campo vazio
                if ("".equals(nome) || "".equals(marca) || "".equals(preco) || "".equals(quantidade)|| "".equals(cor) || "".equals(tipo)"".equals(cano) ||) {
                    res = false;
                }

                if(opcao == 1) { //cadastro de novo chuteira

                    if(res) {
                        Chuteira novochuteira = new Chuteira(nome,marca, preco, quantidade, cor,tipo,cano);
                        chuteira.cadastrar(novochuteira);
                        mensagemSucessoCadastro();
                    }
                    else {
                        mensagemErroCadastro();
                    }
                }
                else if (opcao == 2) {
                    // edição dados chuteira
                    if(res){
                        for (int i=1; i< 9; i++) {
                            chuteira.editar(posicao, dados[i-1], i);
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

            chuteira.deletar(posicao);
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
        JOptionPane.showMessageDialog(null,"ERRO AO BUSCAR CHUTEIRA!\n\n"
                        + "chuteira não encontrada!", null,
                JOptionPane.ERROR_MESSAGE);
    }

    public void mensagemErroCadastro() {
        JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n "
                        + "Pode ter ocorrido um dos dois erros a seguir:  \n"
                        + "1. Nem todos os campos foram preenchidos \n"
                        + "2. Quantidade registrada não são números", null,
                JOptionPane.ERROR_MESSAGE);
    }

    public void mensagemErroExclusaoChuteira() {
        JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n "
                        + "Verifique se a chuteira está cadastrada\n"
                        + " e tente novamente.", null,
                JOptionPane.ERROR_MESSAGE);
    }
}
    
    