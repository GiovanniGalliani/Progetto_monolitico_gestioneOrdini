package test.com.mitota.businesscomponent.idgenerator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.mitota.architecture.dao.DAOException;
import com.mitota.businesscomponent.idgenerator.ArticoloIdGenerator;


class ArticoloIdGeneratorTest {

	@Test
	void test() {
		
		  try {
			   ArticoloIdGenerator idGen=  ArticoloIdGenerator.getInstance();
			   assertNotNull(idGen, "Istanza del generatore creata correttamente");
			   long valore = idGen.getNextId();
			   assertEquals(valore, idGen.getNextId() -1);
			  }  catch (DAOException | ClassNotFoundException | IOException exc) {
			exc.printStackTrace();
			System.out.println("Eccezione idGenerator: " + exc.getMessage());
		}
	}

}