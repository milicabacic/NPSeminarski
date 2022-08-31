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

class AsistentTest {

	Asistent asistent;
	
	@BeforeEach
	void setUp() throws Exception {
		asistent = new Asistent();
	}

	@AfterEach
	void tearDown() throws Exception {
		asistent = null;
	}

	@Test
	void testAsistentNonParameterizedConstructor() {
		asistent = new Asistent();
		
		assertNotNull(asistent);
	}

	@Test
	void testAsistentLongStringStringListOfRezervacijaSale() {
		List<RezervacijaSale> dezurstva = new LinkedList<RezervacijaSale>();
		dezurstva.add(new RezervacijaSale());
		
		asistent = new Asistent(Long.valueOf(1), "Pera", "Peric", dezurstva);
		
		assertNotNull(asistent);
		assertEquals(asistent.getId(), Long.valueOf(1));
		assertEquals(asistent.getIme(), "Pera");
		assertEquals(asistent.getPrezime(), "Peric");
		assertEquals(asistent.getDezurstva(), dezurstva);
	}

	@ParameterizedTest
	@DisplayName("Testira postavljanje id-ja na unetu vrednost")
	@CsvSource({
		"1",
		"4"
	})
	void testSetId(Long id) {
		asistent.setId(Long.valueOf(id));
		assertEquals(asistent.getId(), id);
	}
	
	
	@Test
	@DisplayName("Testira bacanje izuzetka za id koji je null")
	void testSetIdIfNull() {
		assertThrows(java.lang.NullPointerException.class, () -> asistent.setId(null));
	}
	
	@ParameterizedTest
	@DisplayName("Testira bacanje izuzetka za id koji je manji ili jendak 0")
	@CsvSource ({
		"0",
		"-1",
		"-111"
	})
	void testSetIdIfIdIsNegative(Long id) {
		assertThrows(java.lang.IllegalArgumentException.class, () -> asistent.setId(Long.valueOf(id)));
	}

	@Test
	@DisplayName("Testira postavljanje imena na unetu vrednost")
	void testSetIme() {
		asistent.setIme("Pera");
		assertEquals(asistent.getIme(), "Pera");
	}
	
	@Test
	@DisplayName("Testira postavljanje imena na null vrednost")
	void testSetImeNull() {
		assertThrows(java.lang.NullPointerException.class, ()->asistent.setIme(null));
	}
	
	@Test
	@DisplayName("Testira postavljanje imena na prazan string")
	void testSetImeEmptyString() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->asistent.setIme(""));
	}

	@Test
	@DisplayName("Testira postavljanje prezimena na unetu vrednost")
	void testSetPrezime() {
		asistent.setIme("Peric");
		assertEquals(asistent.getIme(), "Peric");
	}
	
	@Test
	@DisplayName("Testira postavljanje prezimena na null vrednost")
	void testSetPrezimeNull() {
		assertThrows(java.lang.NullPointerException.class, ()->asistent.setPrezime(null));
	}
	
	@Test
	@DisplayName("Testira postavljanje prezimena na prazan string")
	void testSetPrezimeEmptyString() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->asistent.setPrezime(""));
	}

	@Test
	@DisplayName("Testira postavljanje dezurstva na unetu vrednost")
	void testSetDezurstva() {
		RezervacijaSale rezervacija = new RezervacijaSale();
		
		List<RezervacijaSale> dezurstva = new LinkedList<RezervacijaSale>();
		
		dezurstva.add(rezervacija);
		
		asistent.setDezurstva(dezurstva);
		
		assertEquals(asistent.getDezurstva(), dezurstva);
	}
	
	@Test
	@DisplayName("Testira postavljanje dezurstva na null vrednost")
	void testSetDezurstvaIsNull() {
		
		List<RezervacijaSale> dezurstva = null;
		
		assertThrows(java.lang.NullPointerException.class, ()->asistent.setDezurstva(dezurstva));
	}

	@ParameterizedTest
	@CsvSource({
		"1, Pera, Peric, 1, Pera, Peric, true",
		"2, Zika, Zikic, 2, Zika, Zika, false"
	})
	void testEqualsObject(Long id1, String ime1, String prezime1, Long id2, String ime2, String prezime2, boolean equals) {
		asistent.setId(Long.valueOf(id1));
		asistent.setIme(ime1);
		asistent.setPrezime(prezime1);
		Asistent asistent2 = new Asistent();
		asistent2.setId(Long.valueOf(id2));
		asistent2.setIme(ime2);
		asistent2.setPrezime(prezime2);
			
		assertEquals(asistent.equals(asistent2), equals);
	}

	@Test
	void testToString() {
		asistent.setIme("Pera");
		asistent.setPrezime("Peric");
		asistent.setId(Long.valueOf(1));
		
		assertEquals(asistent.toString(), "Asistent [id=" + "1" + ", ime=" + "Pera" + ", prezime=" + "Peric" + ", dezurstva=" + "null" + "]");
	}

}
