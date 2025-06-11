package uniAlfa.hackathon.dao;

import uniAlfa.hackathon.model.Evento;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class EventoDao extends Dao implements DaoInterface {

    @Override
    public boolean salvar(Object entity) {
        try {
            var evento = (Evento) entity;

            String sqlInsert = "INSERT INTO evento (nome, valor, urlImg, endereco, descricao, palestrante, organizacao, patrocinador, modalidade, data) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = getConnection().prepareStatement(sqlInsert);
            ps.setString(1, evento.getNome());
            ps.setString(2, evento.getValor());
            ps.setString(3, evento.getUrlImg());
            ps.setString(4, evento.getEndereco());
            ps.setString(5, evento.getDescricao());
            ps.setString(6, evento.getPalestrante());
            ps.setString(7, evento.getOrganizacao());
            ps.setString(8, evento.getPatrocinador());
            ps.setString(9, evento.getModalidade());
            ps.setDate(10, new java.sql.Date(evento.getData().getTime()));

            ps.execute();
            ps.close();

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean atualizar(Object entity) {
        // Aqui você pode implementar o UPDATE depois, se quiser.
        return false;
    }

    @Override
    public List<Object> listar() {
        List<Object> eventos = new ArrayList<>();

        try {
            String sql = "SELECT * FROM evento";
            ResultSet resultSet = getConnection().prepareStatement(sql).executeQuery();

            while (resultSet.next()) {
                Evento evento = new Evento(
                        resultSet.getLong("ra"),
                        resultSet.getString("nome"),
                        resultSet.getString("valor"),
                        resultSet.getString("urlImg"),
                        resultSet.getString("endereco"),
                        resultSet.getString("descricao"),
                        resultSet.getString("palestrante"),
                        resultSet.getString("organizacao"),
                        resultSet.getString("patrocinador"),
                        resultSet.getString("modalidade"),
                        resultSet.getDate("data")
                );

                eventos.add(evento);
            }

            resultSet.close();

        } catch (Exception e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }

        return eventos;
    }

    @Override
    public Object buscarPorId(Long id) {
        return null;
    }

    @Override
    public boolean deletar(Long id) {
        return false;
    }
}
