package test.com.mitota.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.mitota.architecture.dao.DAOException;
import com.mitota.architecture.dao.UtenteDAO;
import com.mitota.architecture.dbaccess.DBAccess;
import com.mitota.businesscomponent.model.Utente;
import com.mitota.security.AlgoritmoMD5;

@TestMethodOrder(OrderAnnotation.class)
class UtenteDAOTest {
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
	}

	@Test
	@Order(1)
	void testCreate()  {
		try {
			UtenteDAO.getFactory().create(conn, utente);
            System.out.println("Utente creato.");			
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Eccezione dovuta al create: " +exc.getMessage());
		}
	}
	
	@Test
	@Order(2)
	void testUpdate() {
		try {
			utente = new Utente();
			utente.setNome("Valentina");
			utente.setCognome("Neri");
			utente.setIndirizzo("Corso Italia, 53");
			utente.setCap("74121");
			utente.setNascita(new GregorianCalendar(1992, 10, 6).getTime());
			utente.setUsername("max");
			utente.setPassword(AlgoritmoMD5.convertiMD5("Pass065$"));
			utente.setEmail("valentina@email.com");
			UtenteDAO.getFactory().update(conn, utente);
			System.out.println("Aggiornato utente: " + utente.toString());
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Update fallito: " +exc.getMessage());
		}
		
	}
	
	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		try {	
			UtenteDAO.getFactory().delete(conn, "max");
			System.out.println("Utente eliminato");
			conn.commit();
			DBAccess.closeConnection();
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Metodo di pulizia fallito: " +exc.getMessage());
		}
	}

}
