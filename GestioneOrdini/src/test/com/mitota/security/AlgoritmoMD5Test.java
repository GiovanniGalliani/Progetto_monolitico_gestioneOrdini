package test.com.mitota.security;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.mitota.security.AlgoritmoMD5;

class AlgoritmoMD5Test {

	@Test
	void testConversione() {
		String pass = AlgoritmoMD5.convertiMD5("a");
		assertNotNull(pass);
		System.out.println(pass);
	}
 
}
