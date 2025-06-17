package uniAlfa.hackathon.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

import uniAlfa.hackathon.model.Evento;
import uniAlfa.hackathon.service.EventoService;

public class EventoGui extends JFrame implements GuiUtil {

    private final EventoService eventoService;

    private JTextField tfCod, tfNome, tfValor, tfUrlImg, tfEndereco, tfDescricao, tfPalestrante, tfOrganizacao, tfPatrocinador, tfModalidade, tfData;
    private JButton btConfirmacao, btListar, btDeletar, btAtualizar, btLimpar, btGerarRelatorio;
    private JTable tabela;
    private JLabel statusLabel;
    private JScrollPane scrollPane;

    public EventoGui(EventoService eventoService) { // Construtor da classe EventoGui que inicializa a interface gráfica
        this.eventoService = eventoService;
        setTitle("Cadastro de Evento");
        setLayout(new BorderLayout());
        java.awt.Image icon = new javax.swing.ImageIcon(getClass().getResource("/icone.png")).getImage(); // Carrega o ícone da janela a partir do recurso "icone.png"
        setIconImage(icon); // Define o ícone da janela
        setSize(800, 600); // Define o tamanho da janela
        setResizable(false); // Define que a janela não pode ser redimensionada
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane(); // Cria um painel de abas para organizar a interface gráfica
        tabbedPane.addTab("Cadastro", montarPainelEntrada()); // Adiciona o painel de entrada de dados na primeira aba
        tabbedPane.addTab("Eventos", montarPainelSaida()); // Adiciona o painel de saída (tabela de eventos) na segunda aba

        statusLabel = new JLabel(" "); // Cria um rótulo para exibir mensagens de status
        statusLabel.setForeground(Color.BLUE); // Define a cor do texto do rótulo de status como azul
        statusLabel.setHorizontalAlignment(JLabel.CENTER); // Centraliza o texto do rótulo de status
        statusLabel.setOpaque(true); // Permite que o rótulo tenha um fundo colorido
        statusLabel.setBackground(Color.LIGHT_GRAY); // Define o fundo do rótulo de status como cinza claro
        statusLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Adiciona uma margem ao redor do rótulo de status
        statusLabel.setPreferredSize(new java.awt.Dimension(0, 30)); // Define uma altura preferencial para o rótulo de status
        statusLabel.setText("Bem-vindo ao sistema de cadastro de eventos!"); // Mensagem inicial no rótulo de status
        statusLabel.setFont(statusLabel.getFont().deriveFont(14f)); // Define o tamanho da fonte do rótulo de status

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(tabbedPane, BorderLayout.CENTER); // Adiciona o painel de abas ao centro da janela
        getContentPane().add(statusLabel, BorderLayout.SOUTH); // Adiciona o rótulo de status na parte inferior da janela
    }

    private JPanel montarPainelEntrada() { // Método para montar o painel de entrada de dados
        JPanel panel = new JPanel(new GridBagLayout()); // Usa GridBagLayout para organizar os componentes
        GridBagConstraints gbc = new GridBagConstraints(); // Cria um objeto GridBagConstraints para definir as restrições de layout
        gbc.insets = new Insets(4, 4, 4, 4); // Define o espaçamento entre os componentes
        gbc.fill = GridBagConstraints.HORIZONTAL; // Preenche o espaço horizontalmente

        String[] labels = {"Código:", "Nome*:", "Valor:", "Url da Imagem:", "Endereço*:", "Descrição:", "Palestrante:",
            "Organização:", "Patrocinador:", "Modalidade:", "Data* (dd/MM/yyyy):"};
        JTextField[] fields = {
            tfCod = new JTextField(15),
            tfNome = new JTextField(15),
            tfValor = new JTextField(15),
            tfUrlImg = new JTextField(15),
            tfEndereco = new JTextField(15),
            tfDescricao = new JTextField(15),
            tfPalestrante = new JTextField(15),
            tfOrganizacao = new JTextField(15),
            tfPatrocinador = new JTextField(15),
            tfModalidade = new JTextField(15),
            tfData = new JTextField(15)
        };

        for (int i = 0; i < labels.length; i++) { // Loop para adicionar os rótulos e campos de texto
            gbc.gridx = 0;
            gbc.gridy = i; // Define a posição do rótulo
            panel.add(new JLabel(labels[i]), gbc); // Adiciona o rótulo ao painel
            gbc.gridx = 1; // Move para a coluna seguinte
            panel.add(fields[i], gbc); // Adiciona o campo de texto ao painel
        }

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        btConfirmacao = new JButton("Salvar");
        btConfirmacao.addActionListener(this::salvarEvento);
        btAtualizar = new JButton("Atualizar");
        btAtualizar.addActionListener(this::atualizarEvento);
        btDeletar = new JButton("Deletar");
        btDeletar.addActionListener(this::deletarEvento);
        btListar = new JButton("Listar");
        btListar.addActionListener(this::listarEventos);
        btLimpar = new JButton("Limpar");
        btLimpar.addActionListener(e -> limparCampos());
        btGerarRelatorio = new JButton("Gerar Relatório");
        btGerarRelatorio.addActionListener(this::gerarRelatorio);

        buttonPanel.add(btConfirmacao);
        buttonPanel.add(btAtualizar);
        buttonPanel.add(btDeletar);
        buttonPanel.add(btListar);
        buttonPanel.add(btLimpar);
        buttonPanel.add(btGerarRelatorio);

        gbc.gridx = 0; // Define a posição do painel de botões
        gbc.gridy = labels.length; // Coloca o painel de botões abaixo dos campos de entrada
        gbc.gridwidth = 2; // O painel de botões ocupa duas colunas
        panel.add(buttonPanel, gbc); // Adiciona o painel de botões ao painel principal

        return panel;
    }

    private JPanel montarPainelSaida() { // Método para montar o painel de saída que exibe a tabela de eventos
        JPanel panel = new JPanel(new BorderLayout());
        tabela = new JTable();
        tabela.setDefaultEditor(Object.class, null);
        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.setModel(carregarEventos());
        tabela.getSelectionModel().addListSelectionListener(this::selecionarEvento);

        // Armazena o JScrollPane como atributo para acesso posterior
        scrollPane = new JScrollPane(tabela);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Botão para descer o scroll da tabela
        JButton btnDescer = new JButton("Descer");
        btnDescer.addActionListener(e -> descerScroll());
        panel.add(btnDescer, BorderLayout.SOUTH);

        return panel;
        }

    private void descerScroll() {
        JScrollBar vertical = scrollPane.getVerticalScrollBar();
        int increment = vertical.getBlockIncrement(1); // desce um bloco por vez
        vertical.setValue(Math.min(vertical.getMaximum(), vertical.getValue() + increment));
        }

    private void selecionarEvento(ListSelectionEvent ignored) { // Método para selecionar um evento na tabela e
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
        statusLabel.setText("Evento selecionado: " + tfNome.getText()); // Atualiza o rótulo de status com o nome do evento selecionado
    }

    private DefaultTableModel carregarEventos() { // Método para carregar os eventos do banco de dados e exibi-los na tabela
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

        eventoService.listarBD().forEach(evento -> { // Itera sobre a lista de eventos e adiciona cada um ao modelo da
            // tabela
            model.addRow(new Object[]{ // Cria uma nova linha com os dados do evento
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
    String relatorio = eventoService.listar();

    JTextArea textArea = new JTextArea(relatorio);
    textArea.setEditable(false);
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);

    JScrollPane scrollPane = new JScrollPane(textArea);
    scrollPane.setPreferredSize(new java.awt.Dimension(800, 600));

    // Agora criamos o JOptionPane manualmente
    JOptionPane optionPane = new JOptionPane(
            scrollPane,
            JOptionPane.INFORMATION_MESSAGE,
            JOptionPane.DEFAULT_OPTION
    );

    JDialog dialog = optionPane.createDialog(this, "Relatório de Eventos");
    dialog.setResizable(true); // agora você pode até permitir o redimensionamento
    dialog.setVisible(true);
}

    private void atualizarEvento(ActionEvent event) { // Método para atualizar um evento existente
        if (!validarCamposObrigatorios()) {
            return;
        }
        try {
            Long cod = tfCod.getText().isBlank() ? null : Long.parseLong(tfCod.getText());
            if (cod == null) {
                statusLabel.setText("Selecione um evento para atualizar.");
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
                    dataFormatada);

            boolean sucesso = eventoService.atualizar(evento);
            if (sucesso) {
                limparCampos();
                statusLabel.setText("Evento atualizado com sucesso!");
                tabela.setModel(carregarEventos());
            } else {
                statusLabel.setText("Erro ao atualizar evento.");
            }
        } catch (ParseException e) {
            statusLabel.setText("Data inválida. Use o formato dd/MM/yyyy");
        } catch (NumberFormatException e) {
            statusLabel.setText("Código inválido.");
        }
    }
    
    private void salvarEvento(ActionEvent event) { // Método para salvar um novo evento
        if (!validarCamposObrigatorios()) {
            return; // Verifica se os campos obrigatórios estão preenchidos

                }try { // Tenta converter o código do evento para Long e a data para o formato correto
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
                    dataFormatada);

            eventoService.salvarBD(evento); // Salva o evento no banco de dados
            limparCampos(); // Limpa os campos de entrada
            statusLabel.setText("Evento salvo com sucesso!"); // Exibe uma mensagem de sucesso
            tabela.setModel(carregarEventos()); // Atualiza a tabela com os eventos cadastrados
        } catch (ParseException e) { // Captura exceção de formatação de data
            statusLabel.setText("Data inválida. Use o formato dd/MM/yyyy"); // Exibe mensagem de erro
        }
    }

    private boolean validarCamposObrigatorios() { // Método para validar os campos obrigatórios antes de salvar ou atualizar um evento
        if (tfNome.getText().isBlank() || tfEndereco.getText().isBlank() || tfData.getText().isBlank()) {
            statusLabel.setText("Preencha os campos obrigatórios (*).");
            return false;
        }
        // Se o campo Valor for vazio ou igual a "0", define como "Gratuito"
        if (tfValor.getText().isBlank() || tfValor.getText().trim().equals("0")) {
            tfValor.setText("Gratuito");
        }
        return true;
    }

    private void limparCampos() { // Método para limpar todos os campos de entrada
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
        statusLabel.setText(" Campos limpos. Pronto para novo cadastro.");
    }

    private void deletarEvento(ActionEvent event) { // Método para deletar um evento selecionado
        try {
            Long cod = tfCod.getText().isBlank() ? null : Long.parseLong(tfCod.getText());
            if (cod == null) {
                statusLabel.setText("Selecione um evento para deletar.");
                return;
            }
            int confirm = JOptionPane.showConfirmDialog(this, "Deseja realmente deletar este evento?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                boolean sucesso = eventoService.deletarBD(cod);
                if (sucesso) {
                    statusLabel.setText("Evento deletado com sucesso!");
                    limparCampos();
                    tabela.setModel(carregarEventos());
                } else {
                    statusLabel.setText("Erro ao deletar evento.");
                }
            }
        } catch (NumberFormatException e) {
            statusLabel.setText("Código inválido.");
        }
    }

    private String formatarData(Date data) {
        return new SimpleDateFormat("dd/MM/yyyy").format(data);
    }

    private void gerarRelatorio(ActionEvent event) {
        eventoService.gerarRelatorioEventos();
        statusLabel.setText("Relatório de eventos gerado com sucesso!");
        JOptionPane.showMessageDialog(this, "Relatório gerado com sucesso em:\n"
                + System.getProperty("user.dir") + java.io.File.separator + "relatorio_eventos.txt");
    }
}
