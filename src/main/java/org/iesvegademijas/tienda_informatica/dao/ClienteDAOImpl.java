package org.iesvegademijas.tienda_informatica.dao;

import org.iesvegademijas.tienda_informatica.modelo.Cliente;

import java.util.List;
import java.util.Optional;

import org.iesvegademijas.tienda_informatica.modelo.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteDAOImpl implements  ClienteDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create_CON_RECARGA_SIMPLEJDBC(Cliente cliente){
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert
                .withTableName()
                .usingGeneratedKeyColumns();
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue()
                .addValue()
                .addValue()
                .addValue()
                .addValue();
    }
    @Override
    public synchronized void create(Cliente cliente) {

        jdbcTemplate.update("INSERT INTO ventas.cliente (nombre) VALUES (?)",cliente.getNombre());

    }

    @Override
    public List<Cliente> getAll() {

        List<Cliente> listCli = jdbcTemplate.query(
                "SELECT * FROM ventas.cliente",
                (rs, rowNum) -> new Cliente(rs.getInt("id"),rs.getString("nombre"),
                        rs.getString("apellido1"),rs.getString("apellido2"),rs.getString("ciudad")
                        ,rs.getInt("categoria"))
        );

        return listCli;

    }

    @Override
    public Optional<Cliente> find(int id) {

        Cliente cli =  jdbcTemplate
                .queryForObject("SELECT * FROM ventas.cliente WHERE id = ?"
                        , (rs, rowNum) -> new Cliente(rs.getInt("id"),rs.getString("nombre"),
                                rs.getString("apellido1"),rs.getString("apellido2"),rs.getString("ciudad")
                                ,rs.getInt("categoria"))
                        , id);

        if (cli != null) return Optional.of(cli);
        else return Optional.empty();

    }

    @Override
    public void update(Cliente cliente) {

        int rows = jdbcTemplate.update("UPDATE ventas.cliente SET nombre = ?  WHERE id = ?", cliente.getNombre(), cliente.getId());
        if (rows == 0) System.out.println("Update de cliente con 0 registros actualizados.");

    }

    @Override
    public void delete(int id) {
        int rows = jdbcTemplate.update("DELETE FROM ventas.cliente WHERE id = ?", id);

        if (rows == 0) System.out.println("Update de cliente con 0 registros actualizados.");

    }
}
