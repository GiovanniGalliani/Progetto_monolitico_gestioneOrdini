package test.com.mitota.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import com.mitota.architecture.dao.DAOException;
import com.mitota.architecture.dao.OrdineDAO;
import com.mitota.architecture.dao.UtenteDAO;
import com.mitota.architecture.dbaccess.DBAccess;
import com.mitota.businesscomponent.model.Ordine;
import com.mitota.businesscomponent.model.Utente;
import com.mitota.security.AlgoritmoMD5;

@TestMethodOrder(OrderAnnotation.class)
class OrdineDAOTest {
	private static Ordine ordine;
	private static Utente utente;
	private static Connection conn;

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		utente = new Utente();
		utente.setNome("Max");
		utente.setCognome("Rossi");
		utente.setIndirizzo("Via Enna, 3");
		utente.setCap("20100");
		utente.setNascita(new GregorianCalendar(1990, 10, 1).getTime());
		utente.setUsername("max");
		utente.setPassword(AlgoritmoMD5.convertiMD5("Pass01$"));
		utente.setEmail("max@email.com");
		
		ordine = new Ordine();
		ordine.setIdOrdine(1);
		ordine.setTotale(20000);
		ordine.setData(new Date());
		ordine.setUsername("max");
	}

	@Test
	@Order(1)
	void testCreate()  {
		try {
			UtenteDAO.getFactory().create(conn, utente);
			OrdineDAO.getFactory().create(conn,  ordine);
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Eccezione dovuta al create: " +exc.getMessage());
		}
	}
	
	@Test
	@Order(2)
	void testUpdateGetByID() {
		try {
			ordine = new Ordine();
			ordine.setIdOrdine(1);
			ordine.setTotale(300);
			ordine.setData(new Date());
			ordine.setUsername("max");
			OrdineDAO.getFactory().update(conn, ordine);
			System.out.println("Aggiornato ordine");
			Ordine ord = OrdineDAO.getFactory().getById(conn, 1);
			System.out.println(ord.toString());
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("GetByID / update fallito: " +exc.getMessage());
		}
		
		
	}
	
	@Test
	@Order(3)
	void testGetAll() {
		try {
			Ordine[] ordini = OrdineDAO.getFactory().getAll(conn);
			assertNotNull(ordini);
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Get All fallito: " +exc.getMessage());
		}
		
	}
 	
	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		try {	
		OrdineDAO.getFactory().delete(conn,1);
		UtenteDAO.getFactory().delete(conn, "max");
		System.out.println("Ordine eliminato");
		conn.commit();
		DBAccess.closeConnection();
	} catch (DAOException exc) {
		exc.printStackTrace();
		fail("Metodo di pulizia fallito: " +exc.getMessage());
	}
	
}

}
