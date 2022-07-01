package test.com.mitota.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mitota.architecture.dao.DAOException;
import com.mitota.architecture.dao.OrdineArticoloDAO;
import com.mitota.architecture.dao.OrdineDAO;
import com.mitota.architecture.dao.UtenteDAO;
import com.mitota.architecture.dbaccess.DBAccess;
import com.mitota.businesscomponent.model.Ordine;
import com.mitota.businesscomponent.model.OrdineArticolo;
import com.mitota.businesscomponent.model.Utente;
import com.mitota.security.AlgoritmoMD5;

class OrdineArticoloDAOTest {
	private Ordine ordine;
	private Utente utente;
	private OrdineArticolo oa;
	private Connection conn;

	@BeforeEach
	void setUp() throws Exception {
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
		
		oa = new OrdineArticolo();
		oa.setIdOrdine(1);
		oa.setIdArticolo(5);
		oa.setQuantita(3);
	}

	@Test
	void testCreate() throws Exception  {
		try {
			UtenteDAO.getFactory().create(DBAccess.getConnection(), utente);
			OrdineDAO.getFactory().create(DBAccess.getConnection(),  ordine);
			OrdineArticoloDAO.getFactory().create(DBAccess.getConnection(), oa);
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Eccezione dovuta al create: " +exc.getMessage());
		}
	}

	@AfterEach
	void tearDown() throws Exception {
		try {	
		conn = DBAccess.getConnection();
		OrdineDAO.getFactory().delete(DBAccess.getConnection(),1);
		Statement stmt = conn.createStatement();
		stmt.executeQuery("Delete from utente where username = 'max'");
		conn.commit();
		stmt.close();
		Statement stmt2 = conn.createStatement();
		stmt2.executeQuery("Delete from ordine_articolo where id_articolo = 5 and id_ordine=1");
		conn.commit();
		DBAccess.closeConnection();
	} catch (DAOException exc) {
		exc.printStackTrace();
		fail("Metodo di pulizia fallito: " +exc.getMessage());
	}
	
}

}
