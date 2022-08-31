package rs.ac.bg.fon.nprog.NPRezervacijaSale.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ProfesorTest {

	Profesor profesor;
	
	@BeforeEach
	void setUp() throws Exception {
		profesor = new Profesor();
	}

	@AfterEach
	void tearDown() throws Exception {
		profesor = null;
	}

	@Test
	void testProfesorNonParameterizedConstructor() {
		profesor = new Profesor();
		
		assertNotNull(profesor);
	}

	@Test
	void testProfesorLongStringStringListOfRezervacijaSale() {
		List<RezervacijaSale> dezurstva = new LinkedList<RezervacijaSale>();
		dezurstva.add(new RezervacijaSale());
		
		profesor = new Profesor(Long.valueOf(1), "Pera", "Peric", dezurstva);
		
		assertNotNull(profesor);
		assertEquals(profesor.getId(), Long.valueOf(1));
		assertEquals(profesor.getIme(), "Pera");
		assertEquals(profesor.getPrezime(), "Peric");
		assertEquals(profesor.getDezurstva(), dezurstva);
	}

	@ParameterizedTest
	@DisplayName("Testira postavljanje id-ja na unetu vrednost")
	@CsvSource({
		"1",
		"4"
	})
	void testSetId(Long id) {
		profesor.setId(Long.valueOf(id));
		assertEquals(profesor.getId(), id);
	}
	
	@Test
	@DisplayName("Testira bacanje izuzetka za id koji je null")
	void testSetIdIfNull() {
		assertThrows(java.lang.NullPointerException.class, () -> profesor.setId(null));
	}
	
	@ParameterizedTest
	@DisplayName("Testira bacanje izuzetka za id koji je manji ili jendak 0")
	@CsvSource ({
		"0",
		"-5",
		"-11"
	})
	void testSetIdIfIdIsNegative(Long id) {
		assertThrows(java.lang.IllegalArgumentException.class, () -> profesor.setId(Long.valueOf(id)));
	}

	@Test
	@DisplayName("Testira postavljanje imena na unetu vrednost")
	void testSetIme() {
		profesor.setIme("Milica");
		assertEquals(profesor.getIme(), "Milica");
	}
	
	@Test
	@DisplayName("Testira postavljanje imena na null vrednost")
	void testSetImeNull() {
		assertThrows(java.lang.NullPointerException.class, ()->profesor.setIme(null));
	}
	
	@Test
	@DisplayName("Testira postavljanje imena na prazan string")
	void testSetImeEmptyString() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->profesor.setIme(""));
	}

	@Test
	@DisplayName("Testira postavljanje prezimena na unetu vrednost")
	void testSetPrezime() {
		profesor.setIme("Bacic");
		assertEquals(profesor.getIme(), "Bacic");
	}
	
	@Test
	@DisplayName("Testira postavljanje prezimena na null vrednost")
	void testSetPrezimeNull() {
		assertThrows(java.lang.NullPointerException.class, ()->profesor.setPrezime(null));
	}
	
	@Test
	@DisplayName("Testira postavljanje prezimena na prazan string")
	void testSetPrezimeEmptyString() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->profesor.setPrezime(""));
	}
	
	

	@Test
	@DisplayName("Testira postavljanje dezurstva na unetu vrednost")
	void testSetDezurstva() {
		RezervacijaSale rezervacija = new RezervacijaSale();
		
		List<RezervacijaSale> dezurstva = new LinkedList<RezervacijaSale>();
		
		dezurstva.add(rezervacija);
		
		profesor.setDezurstva(dezurstva);
		
		assertEquals(profesor.getDezurstva(), dezurstva);
	}
	
	@Test
	@DisplayName("Testira postavljanje dezurstva na null vrednost")
	void testSetDezurstvaIsNull() {
		
		List<RezervacijaSale> dezurstva = null;
		
		assertThrows(java.lang.NullPointerException.class, ()->profesor.setDezurstva(dezurstva));
	}

	@ParameterizedTest
	@CsvSource({
		"1, Mika, Mikic, 1, Zika, Peric, false",
		"2, Laza, Lazic, 2, Laza, Lazic, true"
	})
	void testEqualsObject(Long id1, String ime1, String prezime1, Long id2, String ime2, String prezime2, boolean equals) {
		profesor.setId(Long.valueOf(id1));
		profesor.setIme(ime1);
		profesor.setPrezime(prezime1);
		Profesor profesor2 = new Profesor();
		profesor2.setId(Long.valueOf(id2));
		profesor2.setIme(ime2);
		profesor2.setPrezime(prezime2);
			
		assertEquals(profesor.equals(profesor2), equals);
	}

	@Test
	void testToString() {
		profesor.setIme("Milica");
		profesor.setPrezime("Bacic");
		profesor.setId(Long.valueOf(1));
		
		assertEquals(profesor.toString(), "Profesor [id=" + "1" + ", ime=" + "Milica" + ", prezime=" + "Bacic" + ", dezurstva=" + "null" + "]");
	}

}
