package test.com.mitota.businesscomponent.utilies;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.Statement;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mitota.architecture.dao.DAOException;
import com.mitota.architecture.dbaccess.DBAccess;
import com.mitota.businesscomponent.facade.ClientFacade;
import com.mitota.businesscomponent.model.Articolo;
import com.mitota.businesscomponent.model.Ordine;
import com.mitota.businesscomponent.model.OrdineArticolo;
import com.mitota.businesscomponent.model.Utente;
import com.mitota.businesscomponent.utilies.ReportUtility;
import com.mitota.security.AlgoritmoMD5;

class ReportUtilityTest {
	private ClientFacade cF;
	private ReportUtility rU;
	
	@BeforeEach
	void setUp() throws Exception {
		cF = ClientFacade.getInstance();
		
		Utente utente = new Utente();
		utente.setNome("Simone");
		utente.setCognome("Mazzarrino");
		utente.setIndirizzo("Via Re David, 21");
		utente.setCap("70125");
		utente.setNascita(new GregorianCalendar(2000,03,15).getTime());
		utente.setUsername("user01");
		utente.setPassword(AlgoritmoMD5.convertiMD5("Pass01$"));
		utente.setEmail("mazo@email.com");
		
		Ordine ordine = new Ordine();
		ordine.setIdOrdine(1);
		ordine.setTotale(20000);
		ordine.setData(new Date());
		ordine.setUsername("user01");
		
		Articolo articolo = new Articolo();
		articolo.setIdArticolo(6);
		articolo.setMarca("Sony");
		articolo.setModello("Di Maio");
		articolo.setPrezzo(5000);
		
		OrdineArticolo oa = new OrdineArticolo();
		oa.setIdOrdine(1);
		oa.setIdArticolo(6);
		oa.setQuantita(4);
		
		cF.createUtente(utente);
		cF.createOrdine(ordine);
		cF.createOrdineArticolo(oa);
	}

	@Test
	void testGetReport() {
		try {
			rU = new ReportUtility();
			Vector<String[]> report = rU.getReport();
			rU.getReport(); 
			
		} catch (ClassNotFoundException | DAOException | IOException exc){
			exc.printStackTrace();
			fail("Eccezione dovuta al getReport: " + exc.getMessage());
			
		}
	}

	@AfterEach
	void tearDown() throws Exception {
		try {
			Statement stmt =DBAccess.getConnection().createStatement();
			stmt.executeQuery("Delete from ordine_articolo where id_articolo = 6 and id_ordine=1");
			DBAccess.closeConnection();
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Eccezione dovuta al metodo di pulizia: " + exc.getMessage());
		}	
	}

}