package test.com.mitota.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.mitota.architecture.dao.ArticoloDAO;
import com.mitota.architecture.dao.DAOException;
import com.mitota.architecture.dbaccess.DBAccess;
import com.mitota.businesscomponent.model.Articolo;


@TestMethodOrder(OrderAnnotation.class)
class ArticoloDAOTest {
	private static Articolo articolo;
	private static Connection conn;

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		articolo = new Articolo();
		articolo.setIdArticolo(6);
		articolo.setMarca("Sony");
		articolo.setModello("Vaio");
		articolo.setPrezzo(1500);
	}

	@Test
	@Order(1)
	void testCreate()  {
		try {
			ArticoloDAO.getFactory().create(conn, articolo);
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Eccezione dovuta al create: " +exc.getMessage());
		}
	}
	
	@Test
	@Order(2)
	void testUpdateGetByID() {
		try {
			articolo = new Articolo();
			articolo.setIdArticolo(6);
			articolo.setMarca("Lenovo");
			articolo.setModello("152A");
			articolo.setPrezzo(1200);
			ArticoloDAO.getFactory().update(conn, articolo);
			System.out.println("Aggiornato articolo");
			Articolo art = ArticoloDAO.getFactory().getById(conn, 6);
			System.out.println(art.toString());
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("GetByID / update fallito: " +exc.getMessage());
		}
		
	}
	
	@Test
	@Order(3)
	void testGetAll() {
		try { 
		Articolo[] articoli = ArticoloDAO.getFactory().getAll(conn);
		assertNotNull(articoli);
	} catch (DAOException exc) {
		exc.printStackTrace();
		fail("Get All fallito: " +exc.getMessage());
	}
	}
 	
	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		try {	
		ArticoloDAO.getFactory().delete(conn,6);
		System.out.println("Articolo eliminato");
		conn.commit();
		DBAccess.closeConnection();
	} catch (DAOException exc) {
		exc.printStackTrace();
		fail("Metodo di pulizia fallito: " +exc.getMessage());
	}
	
}	

}
