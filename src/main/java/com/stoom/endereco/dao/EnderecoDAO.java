package com.stoom.endereco.dao;
import org.springframework.jdbc.core.JdbcTemplate;
import com.stoom.endereco.model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("enderecoDAO")
public class EnderecoDAO implements IEnderecoDAO{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EnderecoDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int inserirEndereco(Endereco endereco) {

        final String sql = "INSERT INTO endereco (id, logradouro, numero, complemento, bairro, cidade, estado, pais, cep, latitude, longitude)" +
                " VALUES (?,?,?,?,?,?,?,?,?,?,?)" ;

        int result = jdbcTemplate.update(sql, new Object[]{
                endereco.getId(),
                endereco.getLogradouro(),
                endereco.getNumero(),
                endereco.getComplemento(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getEstado(),
                endereco.getPais(),
                endereco.getCep(),
                endereco.getLatitude(),
                endereco.getLongitude()
        });

        return result;
    }


    @Override
    public List<Endereco> buscarEnderecos() {
        final String sql = "SELECT id, logradouro, numero, complemento, bairro, cidade, estado, pais, cep, latitude, longitude FROM endereco";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            return new Endereco(
            UUID.fromString(resultSet.getString("id")),
            resultSet.getString("logradouro"),
            resultSet.getInt("numero"),
            resultSet.getString("complemento"),
            resultSet.getString("bairro"),
            resultSet.getString("cidade"),
            resultSet.getString("estado"),
            resultSet.getString("pais"),
            resultSet.getString("cep"),
            resultSet.getDouble("latitude"),
            resultSet.getDouble("longitude"));
        });
    }

    @Override
    public Endereco buscarEnderecosId(UUID id) {

        final String sql = "SELECT id, logradouro, numero, complemento, bairro, cidade, estado, pais, cep, latitude, longitude FROM endereco WHERE id = ?";

        Endereco endereco = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
            return new Endereco(
                    UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("logradouro"),
                    resultSet.getInt("numero"),
                    resultSet.getString("complemento"),
                    resultSet.getString("bairro"),
                    resultSet.getString("cidade"),
                    resultSet.getString("estado"),
                    resultSet.getString("pais"),
                    resultSet.getString("cep"),
                    resultSet.getDouble("latitude"),
                    resultSet.getDouble("longitude"));

        });
        return endereco;
    }

    @Override
    public int deletarEndereco(UUID id) {

        Endereco existente = buscarEnderecosId(id);
        int result = 0;

        if(existente!=null){
            final String sql = "DELETE FROM endereco WHERE id = ?";
            result = jdbcTemplate.update(sql,id);
        }
        return result;
    }

    @Override
    public int atualizarEndereco(UUID id, Endereco endereco) {

        Endereco existente = buscarEnderecosId(id);
        int result = 0;

        if(existente!=null){
            final String sql = "UPDATE endereco set logradouro = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, estado = ?, pais = ?, cep = ?, latitude = ?, longitude = ?" +
                    " WHERE id = ?" ;
            result = jdbcTemplate.update(sql, new Object[]{
                    endereco.getLogradouro(),
                    endereco.getNumero(),
                    endereco.getComplemento(),
                    endereco.getBairro(),
                    endereco.getCidade(),
                    endereco.getEstado(),
                    endereco.getPais(),
                    endereco.getCep(),
                    endereco.getLatitude(),
                    endereco.getLongitude(),
                    id
            });

        }
        return result;
    }


}
