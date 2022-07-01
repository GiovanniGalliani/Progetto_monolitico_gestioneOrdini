package test.com.mitota.architecture.dbaccess;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;


import org.junit.jupiter.api.Test;

import com.mitota.architecture.dao.DAOException;
import com.mitota.architecture.dbaccess.DBAccess;


class DBAccessTest {

	@Test
	void testConnection() {
		try {
			DBAccess.getConnection();
		} catch(DAOException | ClassNotFoundException | IOException exc) {
			exc.printStackTrace();
			fail("Errore nel tentativo di connessione: " + exc.getMessage());
		} finally {
			try {
				DBAccess.closeConnection();
			}catch(DAOException exc) {
				exc.printStackTrace();
				fail("Errore nel tentativo di chiusura della connessione: " + exc.getMessage());
			}
		}
		
	}

}
