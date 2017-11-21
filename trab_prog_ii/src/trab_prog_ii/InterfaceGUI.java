/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab_prog_ii;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author illgner
 */
public class InterfaceGUI extends JFrame implements ActionListener{
    private JMenuBar barraDeMenu;
    private JMenu barraMenuu, Listando;
    private JMenuItem CdstUsuarioEnderecoMn, CdstPerfilMn;
    private JMenuItem lstdUsuario, listarEnderecosJmn, lstrPerfilJMn, lstr2PerfilJMn;
    private JButton salvarBnkPerfil, edtdUsuario, rmvUsuario, rmvEndereco, edtdEndereco, edtdPerfil, rmvPerfil;
    private JButton salvarBank;
    private JTextField nomeUsuario, sobrenomeUsuario, logradouro, complemento, bairro, numero, cep, nomePerfil, descricaoDoSeuPerfil;
    private JLabel Seikō, nomeDoUsuarioLbl, sobrenomeDoUsuarioLbl, LogradouroLbl, ComplementoLbl, BairroLbl, NumeroLbl, CepLbl;//seikõ sucesso
    private JLabel nomePerfilLbl, descricaoPerfilLbl, alertSalvarLbl, perfilAlertLbl, SentakuSuruPerfilLbl;//SentakuSuru=selecionar
    private JFrame CdtUsuarioEnderecoJfm, CdtPerfilJfrm;
    private JFrame LstdEnderecoJfm, LstdoUsuarioJfm, LstdPerfilJfm, Lstd2PerfilJframe;
    private JTable tblUser, tblFim, tblPerfill, tbl2Perfill;
    private JPanel pnlEdtrRmvUsuario, pnlEditrRmvEndereco, pnlEdtrRmvPerfil;
    private static JComboBox perfilOptions;
    DefaultTableModel tabelaUsuario = new DefaultTableModel() {
        public boolean isCellEditable(int row, int column) {
            return column == 1 || column == 2 ? true : false;
            //column == 1=nome
            //column == 2= sobrenome
        }
    };
    DefaultTableModel tblEndereco = new DefaultTableModel() {
        public boolean isCellEditable(int row, int column) {
            return column == 1 || column == 2 || column == 3 || column == 4 || column == 5 ? true : false;
            //column == 1=logradouro
            //column == 2= complemento
            //column == 3=bairro
            //column == 4=numero
            //column == 5=cep
           }
    };
    DefaultTableModel tblPerfil2 = new DefaultTableModel() {
        public boolean isCellEditable(int row, int column) {
            return column == 1 || column == 2 ? true : false;
            //column == 1=nome
            //column == 2=descricap
        }
    };

    DefaultTableModel tblLst2Perfil = new DefaultTableModel() {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    InterfaceGUI() {
        super("Programação 2 Poo ");
        barraDeMenu = new JMenuBar();
        this.setJMenuBar(barraDeMenu);
        
        
        
        
        
       //Menu Cadastrar
        barraMenuu = new JMenu("Cadastrar");
        CdstUsuarioEnderecoMn = new JMenuItem("Perfil");
        CdstPerfilMn = new JMenuItem("Usuario");
        barraDeMenu.add(barraMenuu);
        barraMenuu.add(CdstPerfilMn);
        barraMenuu.add(CdstUsuarioEnderecoMn);
        CdtUsuarioEnderecoJfm = new JFrame("Cadastror Usuário e endereço");
        CdtPerfilJfrm = new JFrame("Cadastrando perfil");
        //Menu Listando
        Listando = new JMenu("Listar");
        lstdUsuario= new JMenuItem("Listar usuários");
        listarEnderecosJmn = new JMenuItem("Listar endereços");
        lstrPerfilJMn = new JMenuItem("Listar Perfil");
        barraDeMenu.add(Listando);
        Listando.add(lstdUsuario);
        Listando.add(listarEnderecosJmn);
        Listando.add(lstrPerfilJMn);
        
        
        
        
        
        
        //Usuário Cadastro(Cadastro)
        TitledBorder tituloUsuario = new TitledBorder("Usuário");
        salvarBank = new JButton("Cadastrar");
        JPanel usuarioJpane = new JPanel();
        usuarioJpane.setBorder(tituloUsuario);
        CdtUsuarioEnderecoJfm.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        CdtUsuarioEnderecoJfm.add(usuarioJpane);
        nomeUsuario = new JTextField(5);
        nomeDoUsuarioLbl = new JLabel("Nome:");
        sobrenomeUsuario = new JTextField(20);
        sobrenomeDoUsuarioLbl = new JLabel("Sobrenome:");
        usuarioJpane.add(nomeDoUsuarioLbl);
        usuarioJpane.add(nomeUsuario);
        usuarioJpane.add(sobrenomeDoUsuarioLbl);
        usuarioJpane.add(sobrenomeUsuario);
        perfilOptions = new JComboBox();
        SentakuSuruPerfilLbl = new JLabel("Selecione o perfil");
        usuarioJpane.add(SentakuSuruPerfilLbl);
        usuarioJpane.add(perfilOptions);  
        
        
        
        
        
        
        //Endereço cadastrando )
        TitledBorder tituloEndereco = new TitledBorder("Endereço");
        JPanel enderecoJpane = new JPanel(new GridLayout(3, 1));
        enderecoJpane.setBorder(tituloEndereco);
        CdtUsuarioEnderecoJfm.add(enderecoJpane);
        LogradouroLbl = new JLabel("Logradouro");
        ComplementoLbl = new JLabel("Complemento");
        BairroLbl = new JLabel("Bairro: ");
        NumeroLbl = new JLabel("Numero: ");
        CepLbl= new JLabel("Cep:");
        logradouro = new JTextField(31);
        complemento = new JTextField(32);
        bairro = new JTextField(33);
        numero = new JTextField(8);
        cep = new JTextField(9);
        JPanel logradouroNumero = new JPanel();
        JPanel bairroCep = new JPanel();
        JPanel complement = new JPanel();
        enderecoJpane.add(logradouroNumero);
        enderecoJpane.add(bairroCep);
        enderecoJpane.add(complement);
        logradouroNumero.add(LogradouroLbl, BorderLayout.NORTH);
        logradouroNumero.add(logradouro, BorderLayout.NORTH);
        logradouroNumero.add(NumeroLbl, BorderLayout.NORTH);
        logradouroNumero.add(numero, BorderLayout.NORTH);
        bairroCep.add(BairroLbl, BorderLayout.CENTER);
        bairroCep.add(bairro, BorderLayout.CENTER);
        bairroCep.add(CepLbl, BorderLayout.CENTER);
        bairroCep.add(cep, BorderLayout.CENTER);
        complement.add(ComplementoLbl, BorderLayout.SOUTH);
        complement.add(complemento, BorderLayout.SOUTH);
        CdtUsuarioEnderecoJfm.add(salvarBank);
        
        
        
        
        //Cadastrando Perfil 
        TitledBorder tituloPerfil = new TitledBorder("Perfil");
        JPanel perfilJpane = new JPanel();
        perfilJpane.setBorder(tituloPerfil);
        CdtPerfilJfrm.add(perfilJpane);
        nomePerfil = new JTextField(15);
        nomePerfilLbl = new JLabel("Nome:");
        descricaoDoSeuPerfil = new JTextField(25);
        descricaoPerfilLbl = new JLabel("Descrição:");
        perfilJpane.add(nomePerfilLbl);
        perfilJpane.add(nomePerfil);
        perfilJpane.add(descricaoPerfilLbl);
        perfilJpane.add(descricaoDoSeuPerfil);
        salvarBnkPerfil = new JButton("Cadastrar");
        perfilJpane.add(salvarBnkPerfil);
        //perfilAlertLbl = new JLabel("Exemplo: Nome [] Descrição []");
        perfilAlertLbl.setForeground(Color.lightGray);
        perfilJpane.add(perfilAlertLbl);
        
        
        
        
        //Usuarios no perfil (Consultar)
        Lstd2PerfilJframe = new JFrame("Usuarios relacionados por perfil");
        tbl2Perfill = new JTable(tblLst2Perfil);
        tbl2Perfill.setGridColor(Color.white);
        tbl2Perfill.setShowVerticalLines(false);
        tblLst2Perfil.addColumn("Nome");
        tblLst2Perfil.addColumn("Sobrenome");
        tblLst2Perfil.addColumn("Perfil");
        tbl2Perfill.getColumnModel().getColumn(0).setPreferredWidth(7);
        tbl2Perfill.getColumnModel().getColumn(1).setPreferredWidth(90);
        tbl2Perfill.getColumnModel().getColumn(2).setPreferredWidth(90);
        Lstd2PerfilJframe.setLayout(new BorderLayout());
        JScrollPane barraRolagemPorPerfil = new JScrollPane(tblPerfill);
        Lstd2PerfilJframe.add(BorderLayout.CENTER, barraRolagemPorPerfil);
        
        
        
        
        
        
        //Tabela Usuário
        LstdoUsuarioJfm = new JFrame("Consultar usuários");
        tblUser = new JTable(tabelaUsuario);
        tblUser.setGridColor(Color.white);
        tblUser.setShowVerticalLines(false);
        tabelaUsuario.addColumn("ID");
        tabelaUsuario.addColumn("NOME");
        tabelaUsuario.addColumn("SOBRENOME");
        tblUser.getColumnModel().getColumn(0).setPreferredWidth(5);
        tblUser.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblUser.getColumnModel().getColumn(2).setPreferredWidth(250);
        rmvUsuario = new JButton("REMOVER");
        edtdUsuario = new JButton("Editar");
        pnlEdtrRmvUsuario = new JPanel();
        alertSalvarLbl = new JLabel("Dê duplo clique na célula que deseja alterar. Para salvar, selecione a linha que foi alterada e clique no botão 'Editar'.");
        alertSalvarLbl.setForeground(Color.orange);
        pnlEdtrRmvUsuario.add(edtdUsuario);
        pnlEdtrRmvUsuario.add(rmvUsuario);
        LstdoUsuarioJfm(new BorderLayout());
        LstdoUsuarioJfm.add(BorderLayout.SOUTH, pnlEdtrRmvUsuario);
        JScrollPane barraRolagem = new JScrollPane(tblUser);
        LstdoUsuarioJfm.add(BorderLayout.CENTER, barraRolagem);
        LstdoUsuarioJfm.add(alertSalvarLbl, BorderLayout.NORTH);
        
        //Tabela Endereço
        LstdEnderecoJfm = new JFrame("Consultar Endereços");
        tblFim = new JTable(tblEndereco);
        tblFim.setGridColor(Color.white);
        tblFim.setShowVerticalLines(false);
        tblEndereco.addColumn("ID");
        tblEndereco.addColumn("LOGRADOURO");
        tblEndereco.addColumn("COMPLEMENTO");
        tblEndereco.addColumn("BAIRRO");
        tblEndereco.addColumn("NUMERO");
        tblEndereco.addColumn("CEP");
        tblFim.getColumnModel().getColumn(0).setPreferredWidth(7);
        tblFim.getColumnModel().getColumn(1).setPreferredWidth(90);
        tblFim.getColumnModel().getColumn(2).setPreferredWidth(90);
        tblFim.getColumnModel().getColumn(3).setPreferredWidth(40);
        tblFim.getColumnModel().getColumn(4).setPreferredWidth(9);
        rmvEndereco = new JButton("Excluir");
        edtdEndereco = new JButton("Editar");
        pnlEditrRmvEndereco = new JPanel();
        alertSalvarLbl = new JLabel("Dê 2 click na célula que deseja alterar. Para salvar, selecione a linha que foi alterada e clique no botão 'Editar'.");
        alertSalvarLbl.setForeground(Color.orange);
        pnlEditrRmvEndereco.add(rmvEndereco);
        pnlEditrRmvEndereco.add(rmvEndereco);
        LstdEnderecoJfm.setLayout(new BorderLayout());
        LstdEnderecoJfm.add(BorderLayout.SOUTH, pnlEditrRmvEndereco);
        JScrollPane barraRolagemEndereco = new JScrollPane(tblFim);
        LstdEnderecoJfm.add(BorderLayout.CENTER, barraRolagemEndereco);
        LstdEnderecoJfm.add(alertSalvarLbl, BorderLayout.NORTH);
        

        
        
        
        //Tabela Perfil
        LstdPerfilJfm = new JFrame("Consultar Endereços");
        tblPerfill = new JTable(tblPerfil2);
        tblPerfill.setGridColor(Color.white);
        tblPerfill.setShowVerticalLines(false);
        tblPerfil2.addColumn("ID");
        tblPerfil2.addColumn("Nome");
        tblPerfil2.addColumn("Descrição");
        tblPerfill.getColumnModel().getColumn(0).setPreferredWidth(5);
        tblPerfill.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblPerfill.getColumnModel().getColumn(2).setPreferredWidth(100);
        rmvPerfil = new JButton("Excluir");
        edtdPerfil= new JButton("Editar");
        pnlEdtrRmvPerfil = new JPanel();
        alertSalvarLbl = new JLabel("Dê duplo clique na célula que deseja alterar. Para salvar, selecione a linha que foi alterada e clique no botão 'Editar'.");
        alertSalvarLbl.setForeground(Color.orange);
        pnlEdtrRmvPerfil.add(edtdPerfil);
        pnlEdtrRmvPerfil.add(rmvPerfil);
        LstdPerfilJfm.setLayout(new BorderLayout());
        LstdPerfilJfm.add(BorderLayout.SOUTH, pnlEdtrRmvPerfil);
        JScrollPane barraRolagemPerfil = new JScrollPane(tblPerfill);
        LstdPerfilJfm.add(BorderLayout.CENTER, barraRolagemPerfil);
        LstdPerfilJfm.add(alertSalvarLbl, BorderLayout.NORTH);
        LstdPerfilJfm.add(tbl2Perfill);
        
        
      
        //Listerners
        CdstUsuarioEnderecoMn.addActionListener(this);
        CdstPerfilMn.addActionListener(this);
        lstrPerfilJMn.addActionListener(this);
        lstdUsuario.addActionListener(this);
        lstr2PerfilJMn.addActionListener(this);
        salvarBank.addActionListener(this);
        salvarBnkPerfil.addActionListener(this);
        listarEnderecosJmn.addActionListener(this);
        edtdUsuario.addActionListener(this);
        rmvUsuario.addActionListener(this);
        edtdEndereco.addActionListener(this);
        rmvEndereco.addActionListener(this);
        edtdPerfil.addActionListener(this);
        rmvPerfil.addActionListener(this);
    }

    
    public static void adicionaPerfilJcombo() {
        PerfilDAO perfildao = new PerfilDAO();
        for (Perfil perfil : perfildao.listarPerfil()) {
            perfilOptions.removeItem(perfil.getNome());
            perfilOptions.addItem(perfil.getNome());
        }
    }

    
    public static int perfilJcomboListar() {
        String nome;
        int idPerfil = 0;
        PerfilDAO perfildao = new PerfilDAO();
        nome = (String) perfilOptions.getSelectedItem();

        for (Perfil perfil : perfildao.listarPerfil()) {
            if (nome.equals(perfil.getNome())) {
                return (int) perfil.getIdPerfil();
            }
        }

        return idPerfil;
    }

    
    public static void pesquisarUsuario(DefaultTableModel tabelaModelo) {
        tabelaModelo.setNumRows(0);
        UsuarioDAO usuariodao = new UsuarioDAO();
        for (Usuario usuario : usuariodao.listarUsuarios()) {
            tabelaModelo.addRow(new Object[]{usuario.getidUsuario(), usuario.getNome(), usuario.getSobrenome()});
        }
    }

    public static void consultarPorPerfil(DefaultTableModel tabelaModeloPorPerfil) {
        tabelaModeloPorPerfil.setNumRows(0);
        PerfilDAO perfildao = new PerfilDAO();
        Usuario usuario = new Usuario();
        for (Perfil perfil : perfildao.listarPerfilUsuario()) {
            tabelaModeloPorPerfil.addRow(new Object[]{usuario.getNome(), usuario.getSobrenome(), perfil.getNome()});
        }
    }

    //Lista todos os enderecos e adiciona linhas a cada endereco
    public static void pesquisarEndereco(DefaultTableModel tabelaModeloEndereco) {
        tabelaModeloEndereco.setNumRows(0);
        EnderecoDAO Enderecodao = new EnderecoDAO();
        for (Endereco endereco : Enderecodao.listarEnderecos()) {
            tabelaModeloEndereco.addRow(new Object[]{endereco.getIdEndereco(), endereco.getLogradouro(), endereco.getComplemento()
                    , endereco.getBairro(), endereco.getNumero(), endereco.getCep()});
        }
    }

    //Lista todos os perfils e adiciona linhas a cada perfil
    public static void pesquisarPerfil(DefaultTableModel tabelaModeloPerfil) {
        tabelaModeloPerfil.setNumRows(0);
        PerfilDAO Perfildao = new PerfilDAO();
        for (Perfil perfil : Perfildao.listarPerfil()) {
            tabelaModeloPerfil.addRow(new Object[]{perfil.getIdPerfil(), perfil.getNome(), perfil.getDescricao()});
        }
    }
    
    
    
    public void actionPerformed(ActionEvent evento) {
        //Botão Cadastrar
        if (evento.getSource() == salvarBank) {
            Usuario usuario = new Usuario();
            Endereco endereco = new Endereco();
            UsuarioDAO usuariodao = new UsuarioDAO();
            EnderecoDAO enderecodao = new EnderecoDAO();
            
            

            String nome, usuarioSobrenome;
            String enderecoLogradouro, enderecoComplemento, enderecoBairro, enderecoNumero, enderecoCep;
            nome = nomeUsuario.getText();
            enderecoLogradouro = logradouro.getText();
            enderecoComplemento = complemento.getText();
            enderecoBairro = bairro.getText();
            enderecoNumero = numero.getText();
            enderecoCep = cep.getText();
            usuarioSobrenome = sobrenomeUsuario.getText();
            
            

            if (usuarioSobrenome.isEmpty() || nome.isEmpty() || enderecoLogradouro.isEmpty() || enderecoBairro.isEmpty() ||
                    enderecoNumero.isEmpty() || enderecoCep.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Favor, preencha todos os campos!!", "" +
                        "Não foi possível salvar", JOptionPane.PLAIN_MESSAGE);
            } else {
                usuario.setId_Usuario(perfilJcomboListar());
                usuario.setNome(nome);
                usuario.setSobrenome(usuarioSobrenome);
                usuariodao.salvarUsuario(usuario);
                endereco.setLogradouro(enderecoLogradouro);
                endereco.setBairro(enderecoBairro);
                endereco.setNumero(enderecoNumero);
                endereco.setComplemento(enderecoComplemento);
                endereco.setCep(enderecoCep);
                try {
                    enderecodao.salvarEndereco(endereco);
                } catch (SQLException ex) {
                    Logger.getLogger(InterfaceGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(this, "Usuário\n" + nome + " " +
                        usuarioSobrenome + " incluído com sucesso!", "Cadastrado!", JOptionPane.PLAIN_MESSAGE);
            }
        } else if (evento.getSource() == salvarBnkPerfil) {
            Perfil perfil = new Perfil();
            PerfilDAO perfildao = new PerfilDAO();
            String perfilNome, perfilDescricao;
            perfilNome = nomePerfil.getText();
            perfilDescricao = descricaoDoSeuPerfil.getText();
            if (perfilDescricao.isEmpty() || perfilNome.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha os campos de PERFIL!", "" + "ERRO AO SALVAR", JOptionPane.PLAIN_MESSAGE);
            } else {
                perfil.setNome(perfilNome);
                perfil.setDescricao(perfilDescricao);
                try {
                    perfildao.salvarPerfil(perfil);
                } catch (SQLException ex) {
                    Logger.getLogger(InterfaceGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(this, "Perfil\n" + perfilNome + "  FOI INSERIDO COM SUCESSO!", "CADASTRADO!!!", JOptionPane.PLAIN_MESSAGE);
            }
            //Submenu 
        }else if (evento.getSource() == CdstPerfilMn) {
            CdtPerfilJfrm.setVisible(true);
            CdtPerfilJfrm.setSize(620, 450);
            CdtPerfilJfrm.setLocationRelativeTo(null);
            CdtPerfilJfrm.setResizable(false);
            CdtPerfilJfrm.setVisible(true);

            //submenu List usuários
        } else if (evento.getSource() == lstdUsuario) {
            pesquisarUsuario(tabelaUsuario);
            LstdoUsuarioJfm.setVisible(true);
            LstdoUsuarioJfm.setSize(600, 368);
            LstdoUsuarioJfm.setLocationRelativeTo(null);
            LstdoUsuarioJfm.setResizable(true);
            LstdoUsuarioJfm.setVisible(true);

            //Submenu List Enderecos
        } else if (evento.getSource() == listarEnderecosJmn) {
            pesquisarEndereco(tblEndereco);
            LstdEnderecoJfm.setVisible(true);
            LstdEnderecoJfm.setSize(720, 480);
            LstdEnderecoJfm.setLocationRelativeTo(null);
            LstdEnderecoJfm.setResizable(false);
            LstdEnderecoJfm.setVisible(true);

        } else if (evento.getSource() == lstrPerfilJMn) {
            pesquisandoPerfil(tblPerfill);
            LstdPerfilJfm.setVisible(true);
            LstdPerfilJfm.setSize(720, 480);
            LstdPerfilJfm.setLocationRelativeTo(null);
            LstdPerfilJfm.setResizable(false);
            LstdPerfilJfm.setVisible(true);

        } else if (evento.getSource() == lstrPerfilJMn) {
            consultarPorPerfil(tblLst2Perfil);
            Lstd2PerfilJframe.setVisible(true);
            Lstd2PerfilJframe.setSize(720, 480);
            Lstd2PerfilJframe.setLocationRelativeTo(null);
            Lstd2PerfilJframe.setResizable(false);
            Lstd2PerfilJframe.setVisible(true);

        } else if (evento.getSource() == edtdUsuario) {
            Usuario usuario = new Usuario();
            UsuarioDAO usuariodao = new UsuarioDAO();
            Object linha;
            Object nomeModificado;
            Object sobrenomeModificado;
            int linhaSelecionada;
            linhaSelecionada = tblUser.getSelectedRow();
            if (linhaSelecionada >= 0) {
                linha = tblUser.getValueAt(linhaSelecionada, 0);
                nomeModificado = tblUser.getValueAt(linhaSelecionada, 1);
                sobrenomeModificado = tblUser.getValueAt(linhaSelecionada, 2);
                usuario.setId_Usuario((Integer) linha);
                usuario.setNome((String) nomeModificado);
                usuario.setSobrenome((String) sobrenomeModificado);
                usuariodao.editarUsuario(usuario);
                JOptionPane.showMessageDialog(null, nomeModificado);

            } else {
                JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
            }
        } else if (evento.getSource() == rmvUsuario) {
            int reply = JOptionPane.showConfirmDialog(null, "Tem deseja excluir usuário?" +
                    "", "Atenção!", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                Usuario usuario = new Usuario();
                UsuarioDAO usuariodao = new UsuarioDAO();
                Object linha;
                int linhaSelecionada;
                linhaSelecionada = tblUser.getSelectedRow();
                if (linhaSelecionada >= 0) {
                    linha = tblUser.getValueAt(linhaSelecionada, 0);
                    usuario.setId_Usuario((Integer) linha);
                    usuariodao.rmvUsuario(usuario);
                    pesquisarUsuario(tabelaUsuario);
                } else {
                    JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
                }
            }

        } else if (evento.getSource() == edtdEndereco) {
            Endereco endereco = new Endereco();
            EnderecoDAO Enderecodao = new EnderecoDAO();
            Object linha;
            Object logradouro, complemento, bairro, numero, cep;
            int linhaSelecionada;
            linhaSelecionada = tblFim.getSelectedRow();
            if (linhaSelecionada >= 0) {
                linha = tblFim.getValueAt(linhaSelecionada, 0);
                logradouro = tblFim.getValueAt(linhaSelecionada, 1);
                complemento = tblFim.getValueAt(linhaSelecionada, 2);
                bairro = tblFim.getValueAt(linhaSelecionada, 3);
                numero = tblFim.getValueAt(linhaSelecionada, 4);
                cep = tblFim.getValueAt(linhaSelecionada, 5);
                endereco.setIdEndereco((Integer) linha);
                endereco.setLogradouro((String) logradouro);
                endereco.setComplemento((String) complemento);
                endereco.setBairro((String) bairro);
                endereco.setNumero((String) numero);
                endereco.setCep((String) cep);
                Enderecodao.editarEndereco(endereco);
            } else {
                JOptionPane.showMessageDialog(null, "É necesário selecionar a linha desejada.");
            }
        } else if (evento.getSource() == rmvEndereco) {
            int reply = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover seu endereço?" +
                    "", "Atenção ao fazer isso voce estara removendo seu Endereço !", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                Endereco endereco = new Endereco();
                EnderecoDAO Enderecodao = new EnderecoDAO();
                Object linha;
                int linhaSelecionada;
                linhaSelecionada = tblFim.getSelectedRow();
                if (linhaSelecionada >= 0) {
                    linha = tblFim.getValueAt(linhaSelecionada, 0);
                    endereco.setIdEndereco((Integer) linha);
                    Enderecodao.rmvEndereco(endereco);
                    pesquisarEndereco(tblEndereco);
                } else {
                    JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
                }
            }
        } else if (evento.getSource() == edtdPerfil) {
            Perfil perfil = new Perfil();
            PerfilDAO perfildao = new PerfilDAO();
            Object linha;
            Object nome, descricao;
            int linhaSelecionada;
            linhaSelecionada = tblPerfill.getSelectedRow();
            if (linhaSelecionada >= 0) {
                linha =tblPerfill .getValueAt(linhaSelecionada, 0);
                nome = tblPerfill.getValueAt(linhaSelecionada, 1);
                descricao = tblPerfill.getValueAt(linhaSelecionada, 2);
                perfil.setIdPerfil((Integer) linha);
                perfil.setNome((String) nome);
                perfil.setDescricao((String) descricao);
                perfildao.editarPerfil(perfil);
            } else {
                JOptionPane.showMessageDialog(null, "É necesário selecionar a linha desejada.");
            }
        } else if (evento.getSource() == rmvPerfil) {
            int reply = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o Perfil?" +
                    "", "Atenção!", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                Perfil perfil = new Perfil();
                PerfilDAO perfildao = new PerfilDAO();
                Object linha;
                int linhaSelecionada;
                linhaSelecionada = tblPerfill.getSelectedRow();
                if (linhaSelecionada >= 0) {
                    linha = tblPerfill.getValueAt(linhaSelecionada, 0);
                    perfil.setIdPerfil((Integer) linha);
                    perfildao.rmvPerfil(perfil);
                    pesquisandoPerfil(tblPerfill);
                } else {
                    JOptionPane.showMessageDialog(null, "É necesário selecionar a linha desejada.");
                }
            }
        }

   

          
    
}

    private void pesquisandoPerfil(JTable tblPerfill) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void LstdoUsuarioJfm(BorderLayout borderLayout) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

        
}