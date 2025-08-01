package uniAlfa.hackathon.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import uniAlfa.hackathon.model.Evento;

public class EventoDao extends Dao implements DaoInterface {

    @Override
    public boolean salvar(Object entity) { // Método para salvar um evento no banco de dados
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
    public boolean atualizar(Object entity) { // Método para atualizar um evento no banco de dados
        try {
            var evento = (Evento) entity;

            String sqlUpdate = "UPDATE evento SET nome = ?, valor = ?, urlImg = ?, endereco = ?, descricao = ?, palestrante = ?, organizacao = ?, patrocinador = ?, modalidade = ?, data = ? WHERE cod = ?";

            PreparedStatement ps = getConnection().prepareStatement(sqlUpdate);
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
            ps.setLong(11, evento.getCod());

            ps.execute();
            ps.close();

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
        return false;
    }

    @Override
    public List<Object> listar() { // Método para listar todos os eventos do banco de dados
        List<Object> eventos = new ArrayList<>();

        try {
            String sql = "SELECT * FROM evento";
            ResultSet resultSet = getConnection().prepareStatement(sql).executeQuery();

            while (resultSet.next()) {
                Evento evento = new Evento(
                        resultSet.getLong("cod"),
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
    public Object buscarPorId(Long id) { // Método para buscar um evento pelo ID no banco de dados
        try {
            String sql = "SELECT * FROM evento WHERE cod = ?";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                Evento evento = new Evento(
                        resultSet.getLong("cod"),
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
                resultSet.close();
                ps.close();
                return evento;
            }
            resultSet.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Erro ao buscar por id: " + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean deletar(Long id) { // Método para deletar um evento pelo ID no banco de dados
        try {
            String sql = "DELETE FROM evento WHERE cod = ?";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setLong(1, id);
            int rowsAffected = ps.executeUpdate();
            ps.close();
            return rowsAffected > 0;
        } catch (Exception e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
            return false;
        }
    }
}
