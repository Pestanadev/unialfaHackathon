package unialfa.hackathon.gui;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

import unialfa.hackathon.model.Evento;
import unialfa.hackathon.service.EventoService;

public class EventoGui extends JFrame implements GuiUtil {

    private final EventoService eventoService;


    private JLabel jlCod;
    private JTextField tfCod;

    private JLabel jlNome;
    private JTextField tfNome;

    private JLabel jlValor;
    private JTextField tfValor;

    private JLabel jlUrlImg;
    private JTextField tfUrlImg;

    private JLabel jlEndereco;
    private JTextField tfEndereco;

    private JLabel jlDescricao;
    private JTextField tfDescricao;

    private JLabel jlPalestrante;
    private JTextField tfPalestrante;

    private JLabel jlOrganizacao;
    private JTextField tfOrganizacao;

    private JLabel jlPatrocinador;
    private JTextField tfPatrocinador;

    private JLabel jlModalidade;
    private JTextField tfModalidade;

    private JLabel jlData;
    private JTextField tfData;

    private JButton btConfirmacao;
    private JButton btListar;
    private JButton btDeletar;
    private JButton btAtualizar;

    private JTable tabela;

    public EventoGui(EventoService eventoService) {
        this.eventoService = eventoService;

        jlCod = new JLabel("Código:");
        tfCod = new JTextField(15);

        jlNome = new JLabel("Nome:");
        tfNome = new JTextField(15);

        jlValor = new JLabel("Valor:");
        tfValor = new JTextField(15);

        jlUrlImg = new JLabel("Url da Imagem:");
        tfUrlImg = new JTextField(15);

        jlEndereco = new JLabel("Endereço:");
        tfEndereco = new JTextField(15);

        jlDescricao = new JLabel("Descrição:");
        tfDescricao = new JTextField(15);

        jlPalestrante = new JLabel("Palestrante:");
        tfPalestrante = new JTextField(15);

        jlOrganizacao = new JLabel("Organização:");
        tfOrganizacao = new JTextField(15);

        jlPatrocinador = new JLabel("Patrocinador:");
        tfPatrocinador = new JTextField(15);

        jlModalidade = new JLabel("Modalidade:");
        tfModalidade = new JTextField(15);

        jlData = new JLabel("Data:");
        tfData = new JTextField(15);

        btConfirmacao = new JButton("Salvar");
        btConfirmacao.addActionListener(this::salvarEvento);

        btListar = new JButton("Listar");
        btListar.addActionListener(this::listarEventos);

        btDeletar = new JButton("Deletar");
        btDeletar.addActionListener(this::deletarEvento);

        btAtualizar = new JButton("Atualizar");
        btAtualizar.addActionListener(this::atualizarEvento);

        setTitle("Cadastro de Evento");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        getContentPane().add(montarPainelEntrada(), BorderLayout.NORTH);
        getContentPane().add(montarPainelSaida(), BorderLayout.CENTER);

        setLocationRelativeTo(null);
    }

    private JPanel montarPainelEntrada() {
        var jPanel = new JPanel(new GridBagLayout());

        jPanel.add(jlCod, montarGrid(0, 0));
        jPanel.add(tfCod, montarGrid(1, 0));
        jPanel.add(jlNome, montarGrid(0, 1));
        jPanel.add(tfNome, montarGrid(1, 1));
        jPanel.add(jlValor, montarGrid(0, 2));
        jPanel.add(tfValor, montarGrid(1, 2));
        jPanel.add(jlUrlImg, montarGrid(0, 3));
        jPanel.add(tfUrlImg, montarGrid(1, 3));
        jPanel.add(jlEndereco, montarGrid(0, 4));
        jPanel.add(tfEndereco, montarGrid(1, 4));
        jPanel.add(jlDescricao, montarGrid(0, 5));
        jPanel.add(tfDescricao, montarGrid(1, 5));
        jPanel.add(jlPalestrante, montarGrid(0, 6));
        jPanel.add(tfPalestrante, montarGrid(1, 6));
        jPanel.add(jlOrganizacao, montarGrid(0, 7));
        jPanel.add(tfOrganizacao, montarGrid(1, 7));
        jPanel.add(jlPatrocinador, montarGrid(0, 8));
        jPanel.add(tfPatrocinador, montarGrid(1, 8));
        jPanel.add(jlModalidade, montarGrid(0, 9));
        jPanel.add(tfModalidade, montarGrid(1, 9));
        jPanel.add(jlData, montarGrid(0, 10));
        jPanel.add(tfData, montarGrid(1, 10));
        jPanel.add(btConfirmacao, montarGrid(0, 11));
        jPanel.add(btListar, montarGrid(1, 11));
        jPanel.add(btDeletar, montarGrid(0, 12));
        jPanel.add(btAtualizar, montarGrid(1, 12));

        return jPanel;
    }

    private JPanel montarPainelSaida() {
        var jPanel = new JPanel(new BorderLayout());

        tabela = new JTable();
        tabela.setDefaultEditor(Object.class, null);
        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.setModel(carregarEventos());
        tabela.getSelectionModel().addListSelectionListener(this::selecionarEvento);

        var scrollPanel = new JScrollPane(tabela);
        jPanel.add(scrollPanel, BorderLayout.CENTER);

        return jPanel;
    }

    private void selecionarEvento(ListSelectionEvent ignored) {
        int selectedRow = tabela.getSelectedRow();
        if (selectedRow != -1) {
            tfCod.setText(tabela.getValueAt(selectedRow, 0).toString());
            tfNome.setText(tabela.getValueAt(selectedRow, 1).toString());
            tfValor.setText(tabela.getValueAt(selectedRow, 2).toString());
            tfUrlImg.setText(tabela.getValueAt(selectedRow, 3).toString());
            tfEndereco.setText(tabela.getValueAt(selectedRow, 4).toString());
            tfDescricao.setText(tabela.getValueAt(selectedRow, 5).toString());
            tfPalestrante.setText(tabela.getValueAt(selectedRow, 6).toString());
            tfOrganizacao.setText(tabela.getValueAt(selectedRow, 7).toString());
            tfPatrocinador.setText(tabela.getValueAt(selectedRow, 8).toString());
            tfModalidade.setText(tabela.getValueAt(selectedRow, 9).toString());
            tfData.setText(tabela.getValueAt(selectedRow, 10).toString());
        }
    }

    private DefaultTableModel carregarEventos() {
        var model = new DefaultTableModel();
        model.addColumn("Codigo");
        model.addColumn("Nome");
        model.addColumn("Valor");
        model.addColumn("UrlImg");
        model.addColumn("Endereço");
        model.addColumn("Descrição");
        model.addColumn("Palestrante");
        model.addColumn("Organização");
        model.addColumn("Patrocinador");
        model.addColumn("Modalidade");
        model.addColumn("Data");

        eventoService.listarBD().forEach(evento -> {
            model.addRow(new Object[]{
                    evento.getCod(),
                    evento.getNome(),
                    evento.getValor(),
                    evento.getUrlImg(),
                    evento.getEndereco(),
                    evento.getDescricao(),
                    evento.getPalestrante(),
                    evento.getOrganizacao(),
                    evento.getPatrocinador(),
                    evento.getModalidade(),
                    formatarData(evento.getData())
            });
        });

        return model;
    }

    private void listarEventos(ActionEvent event) {
        JOptionPane.showMessageDialog(this, eventoService.listar());
    }

    private void salvarEvento(ActionEvent event) {
        try {
            Long cod = tfCod.getText().isBlank() ? 0L : Long.parseLong(tfCod.getText());
            Date dataFormatada = new SimpleDateFormat("dd/MM/yyyy").parse(tfData.getText());

            var evento = new Evento(
                    cod,
                    tfNome.getText(),
                    tfValor.getText(),
                    tfUrlImg.getText(),
                    tfEndereco.getText(),
                    tfDescricao.getText(),
                    tfPalestrante.getText(),
                    tfOrganizacao.getText(),
                    tfPatrocinador.getText(),
                    tfModalidade.getText(),
                    dataFormatada
            );

            eventoService.salvarBD(evento);
            limparCampos();
            JOptionPane.showMessageDialog(this, "Sucesso!");
            tabela.setModel(carregarEventos());
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Data inválida. Use o formato dd/MM/yyyy");
        }
    }

    private void limparCampos() {
        tfCod.setText("");
        tfNome.setText("");
        tfValor.setText("");
        tfUrlImg.setText("");
        tfEndereco.setText("");
        tfDescricao.setText("");
        tfPalestrante.setText("");
        tfOrganizacao.setText("");
        tfPatrocinador.setText("");
        tfModalidade.setText("");
        tfData.setText("");
    }

    private void deletarEvento(ActionEvent event) {
        try {
            Long cod = tfCod.getText().isBlank() ? null : Long.parseLong(tfCod.getText());
            if (cod == null) {
                JOptionPane.showMessageDialog(this, "Selecione um evento para deletar.");
                return;
            }
            int confirm = JOptionPane.showConfirmDialog(this, "Deseja realmente deletar este evento?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                boolean sucesso = eventoService.deletarBD(cod);
                if (sucesso) {
                    JOptionPane.showMessageDialog(this, "Evento deletado com sucesso!");
                    limparCampos();
                    tabela.setModel(carregarEventos());
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao deletar evento.");
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Código inválido.");
        }
    }

    private void atualizarEvento(ActionEvent event) {
        try {
            Long cod = tfCod.getText().isBlank() ? null : Long.parseLong(tfCod.getText());
            if (cod == null) {
                JOptionPane.showMessageDialog(this, "Selecione um evento para atualizar.");
                return;
            }
            Date dataFormatada = new SimpleDateFormat("dd/MM/yyyy").parse(tfData.getText());

            var evento = new Evento(
                    cod,
                    tfNome.getText(),
                    tfValor.getText(),
                    tfUrlImg.getText(),
                    tfEndereco.getText(),
                    tfDescricao.getText(),
                    tfPalestrante.getText(),
                    tfOrganizacao.getText(),
                    tfPatrocinador.getText(),
                    tfModalidade.getText(),
                    dataFormatada
            );

            // Supondo que o EventoDao.jar fornece um método atualizarEvento(Evento evento)
            boolean sucesso = false;
            try {
                // Exemplo: EventoDao dao = new EventoDao();
                // sucesso = dao.atualizarEvento(evento);
                sucesso = eventoService.atualizar(evento); // Mantenha se o service já usa o DAO do jar
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao acessar o banco de dados: " + ex.getMessage());
                return;
            }

            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Evento atualizado com sucesso!");
                limparCampos();
                tabela.setModel(carregarEventos());
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao atualizar evento.");
            }
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Data inválida. Use o formato dd/MM/yyyy");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Código inválido.");
        }
    }

    private String formatarData(Date data) {
        return new SimpleDateFormat("dd/MM/yyyy").format(data);
    }
}
