package unialfa.hackathon.service;

import java.io.BufferedReader; // é um pacote que contém classes para manipulação de entrada e saída de dados, como leitura e escrita em arquivos.
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import unialfa.hackathon.dao.EventoDao;
import unialfa.hackathon.model.Evento;

public class EventoService {

    public void salvarBD(Evento evento){
        var dao = new EventoDao();
        dao.salvar(evento);
    }

    public List<Evento> listarBD(){
        List<Evento> eventos = new ArrayList<>();
        var dao = new EventoDao();

        dao.listar().forEach(object -> eventos.add((Evento) object));
        return eventos;
    }

    public void salvar(Evento evento) {
        var arquivo = new File(System.getProperty("user.dir"), "\\relatorio_eventos.txt");
        writerFile(evento.toString(), arquivo.toString());
    }

    public String listar() {
        var dao = new EventoDao();
        var eventos = dao.listar();

        if (eventos.isEmpty()) {
            return "Nenhum evento cadastrado.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Relatório de Eventos:\n");
        sb.append(String.format("%-5s %-20s %-10s %-20s %-15s %-15s %-15s %-15s %-15s %-15s %-12s\n",
                "Cod", "Nome", "Valor", "UrlImg", "Endereço", "Descrição", "Palestrante", "Organização", "Patrocinador", "Modalidade", "Data"));
        sb.append("-------------------------------------------------------------------------------------------------------------------------------\n");

        for (Object obj : eventos) {
            Evento evento = (Evento) obj;
            sb.append(String.format("%-5d %-20s %-10s %-20s %-15s %-15s %-15s %-15s %-15s %-15s %-12s\n",
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
                    new java.text.SimpleDateFormat("dd/MM/yyyy").format(evento.getData())
            ));
        }

        return sb.toString();
    }

    private List<String> readerFile(String nomeArquivo) {
        List<String> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            reader.lines().forEach(result::add);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    private void writerFile(String conteudo, String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            writer.newLine();
            writer.write(conteudo);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean deletarBD(Long cod) {
        var dao = new EventoDao();
        return dao.deletar(cod);
    }

    public boolean atualizar(Evento evento) {
        var dao = new EventoDao();
        return dao.atualizar(evento);
    }
}
