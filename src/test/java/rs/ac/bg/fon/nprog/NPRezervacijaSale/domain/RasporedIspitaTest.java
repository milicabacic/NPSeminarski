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

import rs.ac.bg.fon.nprog.NPRezervacijaSale.util.Rok;

class RasporedIspitaTest {

	RasporedIspita raspored;
	
	@BeforeEach
	void setUp() throws Exception {
		raspored = new RasporedIspita();
	}

	@AfterEach
	void tearDown() throws Exception {
		raspored = null;
	}

	@Test
	void testRasporedIspitaNonParameterizedConstructor() {
		raspored = new RasporedIspita();
		
		assertNotNull(raspored);
	}

	@Test
	void testRasporedIspitaLongRokListOfRezervacijaSale() {
		List<RezervacijaSale> ispiti = new LinkedList<RezervacijaSale>();
		ispiti.add(new RezervacijaSale());
		
		raspored = new RasporedIspita(Long.valueOf(1), Rok.SeptembarskiRok, ispiti);
		
		assertNotNull(raspored);
		assertEquals(raspored.getId(), Long.valueOf(1));
		assertEquals(raspored.getRok(), Rok.SeptembarskiRok);
		assertEquals(raspored.getIspiti(), ispiti);
	}

	@ParameterizedTest
	@DisplayName("Testira postavljanje id-ja na unetu vrednost")
	@CsvSource({
		"2",
		"10"
	})
	void testSetId(Long id) {
		raspored.setId(Long.valueOf(id));
		assertEquals(raspored.getId(), id);
	}
	
	@Test
	@DisplayName("Testira bacanje izuzetka za id koji je null")
	void testSetIdIfNull() {
		assertThrows(java.lang.NullPointerException.class, () -> raspored.setId(null));
	}
	
	@ParameterizedTest
	@DisplayName("Testira bacanje izuzetka za id koji je manji ili jendak 0")
	@CsvSource ({
		"0",
		"-1",
		"-11"
	})
	void testSetIdIfIdIsNegative(Long id) {
		assertThrows(java.lang.IllegalArgumentException.class, () -> raspored.setId(Long.valueOf(id)));
	}

	@Test
	void testSetRok() {
		raspored.setRok(Rok.JanuarskiRok);
		
		assertEquals(raspored.getRok(), Rok.JanuarskiRok);
	}
	
	@Test
	@DisplayName("Testira postavljanje roka na null vrednost")
	void testSetRokIsNull() {
		assertThrows(java.lang.NullPointerException.class, ()->raspored.setRok(null));
	}

	@Test
	@DisplayName("Testira postavljanje ispita u rasporedu na unetu vrednost")
	void testSetIspiti() {
		RezervacijaSale rezervacija = new RezervacijaSale();
		
		List<RezervacijaSale> ispiti = new LinkedList<RezervacijaSale>();
		
		ispiti.add(rezervacija);
		
		raspored.setIspiti(ispiti);
		
		assertEquals(raspored.getIspiti(), ispiti);
	}

	@ParameterizedTest
	@CsvSource({
		"1, JanuarskiRok, 1, JanuarskiRok, true",
		"1, FebruarskiRok, 2, JanuarskiRok, false"
	})
	void testEqualsObject(Long id1, String rok1, Long id2, String rok2, boolean equals) {
		raspored.setId(id1);
		raspored.setRok(Rok.valueOf(rok1));
		RasporedIspita raspored2 = new RasporedIspita();
		raspored2.setId(id2);
		raspored2.setRok(Rok.valueOf(rok2));
		
		assertEquals(raspored.equals(raspored2), equals);
	}

	@Test
	void testToString() {
		raspored.setId(Long.valueOf(2));
		raspored.setRok(Rok.OktobarskiRok);
		raspored.setIspiti(new LinkedList<RezervacijaSale>());
		
		assertEquals(raspored.toString(), "RasporedIspita [id=" + "2" + ", rok=" + "OktobarskiRok" + ", ispiti=" + "[]" + "]");
	}

}
