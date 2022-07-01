package test.com.mitota.businesscomponent.idgenerator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.mitota.architecture.dao.DAOException;
import com.mitota.businesscomponent.ArticoloBC;
import com.mitota.businesscomponent.model.Articolo;

@TestMethodOrder(OrderAnnotation.class)
class ArticoloBCTest {
	private static ArticoloBC aBC;
	private static Articolo articolo1;
	private static Articolo articolo2;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		aBC = new ArticoloBC();
		
		articolo1 = new Articolo();
		articolo1.setIdArticolo(6);
		articolo1.setMarca("Realme");
		articolo1.setModello("X50 Pro");
		articolo1.setPrezzo(750);
		
		articolo2 = new Articolo();
		articolo2.setIdArticolo(6);
		articolo2.setMarca("Samsung");
		articolo2.setModello("Galaxy Book");
		articolo2.setPrezzo(1100);
	}

	@Test
	@Order(1)
	void testCreateOrUpdate() {
		try {
			System.out.println("------------------------------------");
			aBC.createOrUpdate(articolo1);
			System.out.println("Articolo creato correttamente: " + articolo1.toString());
			System.out.println("------------------------------------");
			aBC.createOrUpdate(articolo2);
			System.out.println("Articolo aggiornato correttamente: " + articolo2.toString());
		} catch (DAOException | ClassNotFoundException | IOException exc) {
			exc.printStackTrace();
			fail("Eccezione dovuta a creazione/aggiornamento di nuovi dati: " + exc.getMessage());
		}
		
	}

	@Test
	@Order(2)
	void testGetArticoli() {
		try {
			System.out.println("------------------------------------");
			Articolo[] articoliArray = aBC.getArticoli();
			System.out.println("Articoli ritornati correttamente: ");
			for(Articolo a : articoliArray) {
				System.out.println(a.toString());
			}		
			} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Eccezione dovuta a getArticoli: " + exc.getMessage());
		}
	}

	@Test
	@Order(3)
	void testGetById() {
		try {
			System.out.println("------------------------------------");
			Articolo articoloById = aBC.getByID(4);
			System.out.println("Articolo con id=4 ritornato correttamente: " + articoloById.toString());
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Eccezione dovuta a getById: " + exc.getMessage());
		}
	}

	@Test
	@Order(4)
	void testSearchArticolo() {
		try {
			System.out.println("------------------------------------");
			Articolo[] articoliSearch = aBC.searchArticolo("Apple");
			System.out.println("Ricerca articoli andata a buon fine: ");
			for(Articolo a : articoliSearch) {
				System.out.println(a.toString());
			}
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Eccezione dovuta a searchArticolo: " + exc.getMessage());
		}
	}


	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			System.out.println("------------------------------------");
			aBC.delete(6);
			System.out.println("Articolo eliminato correttamente.");
			articolo1 = null;
			articolo2 = null;
			aBC = null;
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Eccezione dovuta al metodo di pulizia: " + exc.getMessage());
		}	
	}
}