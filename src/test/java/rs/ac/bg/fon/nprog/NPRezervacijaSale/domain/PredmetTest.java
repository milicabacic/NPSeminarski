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

class PredmetTest {

	Predmet predmet;
	
	@BeforeEach
	void setUp() throws Exception {
		predmet = new Predmet();
	}

	@AfterEach
	void tearDown() throws Exception {
		predmet = null;
	}

	@Test
	void testPredmet() {
		predmet = new Predmet();
		
		assertNotNull(predmet);
	}

	@Test
	void testPredmetLongStringIntListOfRezervacijaSale() {
		List<RezervacijaSale> ispiti = new LinkedList<RezervacijaSale>();
		ispiti.add(new RezervacijaSale());
		
		predmet = new Predmet(Long.valueOf(1), "Programiranje 1", 4, ispiti);
		
		assertNotNull(predmet);
		assertEquals(predmet.getId(), Long.valueOf(1));
		assertEquals(predmet.getNaziv(), "Programiranje 1");
		assertEquals(predmet.getEspb(), 4);
		assertEquals(predmet.getIspiti(), ispiti);
	}

	@ParameterizedTest
	@DisplayName("Testira postavljanje id-ja na unetu vrednost")
	@CsvSource({
		"5",
		"14"
	})
	void testSetId(Long id) {
		predmet.setId(Long.valueOf(id));
		assertEquals(predmet.getId(), id);
	}
	
	@Test
	@DisplayName("Testira bacanje izuzetka za id koji je null")
	void testSetIdIfNull() {
		assertThrows(java.lang.NullPointerException.class, () -> predmet.setId(null));
	}
	
	@ParameterizedTest
	@DisplayName("Testira bacanje izuzetka za id koji je manji ili jendak 0")
	@CsvSource ({
		"0",
		"-4",
		"-119"
	})
	void testSetIdIfIdIsNegative(Long id) {
		assertThrows(java.lang.IllegalArgumentException.class, () -> predmet.setId(Long.valueOf(id)));
	}

	@Test
	@DisplayName("Testira postavljanje naziva predmeta na unetu vrednost")
	void testSetNaziv() {
		predmet.setNaziv("Matematika 2");
		
		assertEquals(predmet.getNaziv(), "Matematika 2");
	}
	
	@Test
	@DisplayName("Testira postavljanje naziva predmeta na null vrednost")
	void testSetNazivNull() {
		assertThrows(java.lang.NullPointerException.class, ()->predmet.setNaziv(null));
	}
	
	@Test
	@DisplayName("Testira postavljanje naziva predmeta na prazan string")
	void testSetNazivEmptyString() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->predmet.setNaziv(""));
	}

	@Test
	@DisplayName("Testira postavljanje espb bodova na unetu vrednost")
	void testSetEspb() {
		predmet.setEspb(5);
		
		assertEquals(predmet.getEspb(), 5);
	}
	
	@ParameterizedTest
	@DisplayName("Testira postavljanje espb bodova na vrednost manju od 1")
	@CsvSource({
		"0",
		"-5"
	})
	void testSetEspbNegative(int espb) {
		assertThrows(java.lang.IllegalArgumentException.class, ()->predmet.setEspb(espb));
	}

	@Test
	void testSetIspiti() {
		RezervacijaSale rezervacija = new RezervacijaSale();
		
		List<RezervacijaSale> ispiti = new LinkedList<RezervacijaSale>();
		
		ispiti.add(rezervacija);
		
		predmet.setIspiti(ispiti);
		
		assertEquals(predmet.getIspiti(), ispiti);
	}
	
	@Test
	@DisplayName("Testira postavljanje ispita na null vrednost")
	void testSetDezurstvaIsNull() {
		
		List<RezervacijaSale> ispiti = null;
		
		assertThrows(java.lang.NullPointerException.class, ()->predmet.setIspiti(ispiti));
	}

	@ParameterizedTest
	@CsvSource({
		"1, Biostatistika, 6, 1, Biostatistika, 6, true",
		"2, Napredno programiranje, 6, 2, Napredno programiranje, 4, false"
	})
	void testEqualsObject(Long id1, String naziv1, int espb1, Long id2, String naziv2, int espb2, boolean equals) {
		predmet.setId(id1);
		predmet.setNaziv(naziv1);
		predmet.setEspb(espb1);
		Predmet predmet2 = new Predmet();
		predmet2.setId(id2);
		predmet2.setNaziv(naziv2);
		predmet2.setEspb(espb2);
		
		assertEquals(predmet.equals(predmet2), equals);
	}

	@Test
	void testToString() {
		predmet.setId(Long.valueOf(1));
		predmet.setNaziv("Napredno programiranje");
		predmet.setEspb(6);
		predmet.setIspiti(new LinkedList<RezervacijaSale>());
		
		assertEquals(predmet.toString(), "Predmet [id=" + "1" + ", naziv=" + "Napredno programiranje" + ", espb=" + "6" + ", ispiti=" + "[]" + "]");
	}

}
