package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.*;

public class TelaDadosSalto implements ActionListener {
    
	private JFrame janela;
    private JLabel labelMarca = new JLabel("Marca:");
	private JTextField valorMarca;
	private JLabel labelPreco = new JLabel("Preço (R$):");
	private JTextField valorPreco;
	private JLabel labelQtd = new JLabel("Quantidade em estoque:");
	private JTextField valorQtd;
	private JLabel labelCor = new JLabel("Cor:");
    private JTextField valorCor;
    private JLabel labelTam = new JLabel("Tamanho do salto (cm):");
    private JTextField valorTam;
    private JLabel labelTipo = new JLabel("Tipo do salto:");
    private JTextField valorTipo;
    
    private JButton botaoExcluir = new JButton("Excluir");
    private JButton botaoSalvar = new JButton("Salvar");
    private JButton botaoVoltar = new JButton("Voltar");
	private JButton botaoCancelar = new JButton("Cancelar");
    private static Salto salto = new Salto();
    
    private int posicao;
    private int opcao;
    private String s;

    public void cadastrarEditar(int op, Salto st,
                                TelaSapatos p, int pos) {

        opcao = op;
        posicao = pos;
        salto = st;

        if (op == 1) s = "Cadastro de Salto";
        if (op == 2) s = "Dados do Produto";

        janela = new JFrame(s);

        if (op == 1) { //Não preenche com dados

            valorMarca = new JTextField(200);
            valorPreco = new JTextField(200);
            valorQtd = new JTextField(200);
            valorCor = new JTextField(100);
            valorTam = new JTextField(100);
            valorTipo = new JTextField(100);

            botaoSalvar.setBounds(145, 210, 110, 30);
			botaoCancelar.setBounds(265, 210, 115, 30);
			this.janela.add(botaoCancelar);
        }
        //Preenche com dados do bota clicado
        if (op == 2) {

            valorMarca = new JTextField(salto.retornaDado(pos, 1), 200);
            valorPreco = new JTextField(salto.retornaDado(pos, 2), 200);
            valorQtd = new JTextField(salto.retornaDado(pos, 3), 200);
            valorCor = new JTextField(salto.retornaDado(pos, 4), 200);
            valorTam = new JTextField(salto.retornaDado(pos, 5), 200);
            valorTipo = new JTextField(salto.retornaDado(pos, 6), 200);

            botaoSalvar.setBounds(150, 210, 110, 30);
            botaoExcluir.setBounds(265, 210, 115, 30);
            botaoVoltar.setBounds(30, 210, 100, 30);
            this.janela.add(botaoExcluir);
			this.janela.add(botaoVoltar);

        }


        labelMarca.setBounds(30, 20, 150, 25);
		valorMarca.setBounds(220, 20, 160, 25);
		
		labelPreco.setBounds(30, 50, 150, 25);
		valorPreco.setBounds(220, 50, 160, 25);
		
		labelQtd.setBounds(30, 80, 180, 25);
		valorQtd.setBounds(350, 80, 30, 25);
		
		labelCor.setBounds(30, 110, 80, 25);
		valorCor.setBounds(220, 110, 160, 25);

        labelTam.setBounds(30, 140, 170, 25);
        valorTam.setBounds(220, 140, 160, 25);
        
        labelTipo.setBounds(30, 170, 170, 25);
        valorTipo.setBounds(220, 170, 160, 25);


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
        botaoVoltar.addActionListener(this);
		botaoCancelar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if(src == botaoSalvar) {

            String marca, preco, quantidade, cor, tipo, tam;

            try {
                boolean res=true;

                marca = valorMarca.getText();
                preco = valorPreco.getText();
                quantidade = valorQtd.getText();
                cor = valorCor.getText();
                tam = valorTam.getText();
                tipo = valorTam.getText();


                String[] dados = {marca, preco, quantidade, cor, tam, tipo};

                // verifica se há algum campo vazio
                if ("".equals(marca) || "".equals(preco) || "".equals(quantidade)|| "".equals(cor) || "".equals(tam) || "".equals(tipo)) {
                    res = false;
                }

                if(opcao == 1) { //cadastro de novo salto

                    if(res) {
                        Salto novosalto = new Salto(marca, Double.parseDouble(preco), Integer.parseInt(quantidade), cor, Integer.parseInt(tam), tipo);
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
                        for (int i=1; i< 7; i++) {
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

            salto.deletar(posicao);
            mensagemSucessoExclusao();
        }
        
        if(src == botaoVoltar || src == botaoCancelar)
			this.janela.dispose();
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
        JOptionPane.showMessageDialog(null,"ERRO AO BUSCAR salto!\n\n"
                        + "Produto não encontrado!", null,
                JOptionPane.ERROR_MESSAGE);
    }

    public void mensagemErroCadastro() {
        JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n "
                        + "Pode ter ocorrido um dos erros a seguir:  \n"
                        + "1. Nem todos os campos foram preenchidos\n"
                        + "2. Preço, Quantidade em estoque ou Tamanho do salto\n"
                        + "  não são apenas números\n"
                        + "3. Quantidade em estoque ou Tamanho do salto\n"
                        + "  não são valores inteiros\n"
                        + "4. Valor decimal de Preço preenchido com\n"
                        + " vírgula ao invés de ponto", null,
                JOptionPane.ERROR_MESSAGE);
    }

}


