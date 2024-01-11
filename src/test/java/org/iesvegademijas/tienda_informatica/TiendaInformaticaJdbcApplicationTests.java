package org.iesvegademijas.tienda_informatica;

import org.iesvegademijas.tienda_informatica.dao.ClienteDAOImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class TiendaInformaticaJdbcApplicationTests {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	ClienteDAOImpl clienteDAOImpl;
	@Test
	void testIDIncremental_SimpleClienteJDBC() {

	}

}
