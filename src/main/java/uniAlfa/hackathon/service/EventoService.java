package uniAlfa.hackathon.service;

import java.io.BufferedWriter; // é um pacote que contém classes para manipulação de entrada e saída de dados, como leitura e escrita em arquivos.
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import uniAlfa.hackathon.dao.EventoDao;
import uniAlfa.hackathon.model.Evento;

public class EventoService { // Classe de serviço para gerenciar eventos, incluindo operações de CRUD

    public void salvarBD(Evento evento) { // Método para salvar um evento no banco de dados
        var dao = new EventoDao();
        dao.salvar(evento);
    }

    public List<Evento> listarBD() { // Método para listar todos os eventos do banco de dados
        // Cria uma lista de eventos e instancia o EventoDao para acessar os dados
        List<Evento> eventos = new ArrayList<>();
        var dao = new EventoDao();

        dao.listar().forEach(object -> eventos.add((Evento) object));
        return eventos;
    }

    public boolean deletarBD(Long cod) { // Método para deletar um evento do banco de dados pelo código
        var dao = new EventoDao();
        return dao.deletar(cod);
    }

    public boolean atualizar(Evento evento) { // Método para atualizar um evento no banco de dados
        var dao = new EventoDao();
        return dao.atualizar(evento);
    }

    public void salvar(Evento evento) { // Método para salvar um evento em um arquivo de texto
        var arquivo = new File(System.getProperty("user.dir"), "relatorio_eventos.txt");
        writerFile(evento.toString(), arquivo.toString());
    }

    public String listar() { // Método para listar todos os eventos em um formato de relatório

        var dao = new EventoDao();
        var eventos = dao.listar();

        if (eventos.isEmpty()) {
            return "Nenhum evento cadastrado.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Relatório de Eventos:\n");
        sb.append(
                "------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        sb.append(String.format("%-5s %-30s %-10s %-50s %-40s %-80s %-20s %-20s %-20s %-12s\n",
                "Cod", "Nome", "Valor", "UrlImg", "Endereço", "Palestrante", "Organização", "Patrocinador",
                "Modalidade", "Data"));
        sb.append(
                "------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");

        for (Object obj : eventos) {
            Evento evento = (Evento) obj;

            String descricaoQuebrada = quebrarTexto(evento.getDescricao(), 60);

            sb.append(String.format("%-5d %-30s %-10s %-50s %-40s %-20s %-20s %-20s %-20s %-12s\n",
                    evento.getCod(),
                    limitarTexto(evento.getNome(), 30),
                    limitarTexto(evento.getValor(), 10),
                    limitarTexto(evento.getUrlImg(), 50),
                    limitarTexto(evento.getEndereco(), 40),
                    limitarTexto(evento.getPalestrante(), 20),
                    limitarTexto(evento.getOrganizacao(), 20),
                    limitarTexto(evento.getPatrocinador(), 20),
                    limitarTexto(evento.getModalidade(), 20),
                    new java.text.SimpleDateFormat("dd/MM/yyyy").format(evento.getData())));

            // Coloca a descrição logo abaixo, quebrada em várias linhas
            sb.append("Descrição:\n").append(descricaoQuebrada);
            sb.append(
                    "------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        }

        return sb.toString();
    }

    private String quebrarTexto(String texto, int larguraMaxima) { // Método para quebrar um texto em várias linhas com largura máxima especificada
        StringBuilder resultado = new StringBuilder();
        int index = 0;
        while (index < texto.length()) {
            int fim = Math.min(index + larguraMaxima, texto.length());
            resultado.append(texto.substring(index, fim)).append("\n");
            index = fim;
        }
        return resultado.toString();
    }

    private void writerFile(String conteudo, String nomeArquivo) { // Método para escrever conteúdo em um arquivo de
                                                                   // texto
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            writer.newLine();
            writer.write(conteudo);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private String limitarTexto(String texto, int limite) { // Método para limitar o tamanho de um texto
        if (texto == null) {
            return "";
        }
        return texto.length() > limite ? texto.substring(0, limite) : texto;
    }

    public void gerarRelatorioEventos() { // Método para gerar um arquivo .txt com o relatório de eventos
        String relatorio = listar();
        File arquivo = new File(System.getProperty("user.dir"), "relatorio_eventos.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            writer.write(relatorio);
        } catch (IOException e) {
            System.out.println("Erro ao gerar relatório de eventos: " + e.getMessage());
        }
    }
}
