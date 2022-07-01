package test.com.mitota.businesscomponent.utilies;


import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.mitota.architecture.dao.DAOException;
import com.mitota.businesscomponent.UtenteBC;
import com.mitota.businesscomponent.model.Utente;
import com.mitota.businesscomponent.utilies.LoginUtility;
import com.mitota.security.AlgoritmoMD5;

@TestMethodOrder(OrderAnnotation.class)
class LoginUtilityTest {
	UtenteBC uBC; 
 	Utente utente;

	@BeforeEach
	void setUpBeforeClass() throws Exception {
		uBC = new UtenteBC();
	
		utente = new Utente();
		utente.setNome("Max");
		utente.setCognome("Rossi");
		utente.setIndirizzo("Via Enna, 3");
		utente.setCap("20100");
		utente.setNascita(new GregorianCalendar(1990, 10, 1).getTime());
		utente.setUsername("max");
		utente.setPassword(AlgoritmoMD5.convertiMD5("Pass01$"));
		utente.setEmail("max@email.com");
		uBC.create(utente);
	
	}

	
	@Test
	void testGetUserPass()
			throws ClassNotFoundException, DAOException, IOException {
		try {
			LoginUtility userP = new LoginUtility();
			userP.getUserPass("max");
			System.out.println(userP.getUserPass("max"));
		} catch (ClassNotFoundException | DAOException | IOException exc){
			exc.printStackTrace();
			fail("Eccezione dovuta al getReport: " + exc.getMessage());
			
		}
	}
	
	
	@AfterEach
	void tearDown() throws Exception {
		try {
			System.out.println("------------------------------------");
			uBC.delete("max");
			System.out.println("Utente eliminato correttamente.");
			utente = null;
			uBC = null;
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Eccezione dovuta al metodo di pulizia: " + exc.getMessage());
		}	
	}
	
	
	
}
