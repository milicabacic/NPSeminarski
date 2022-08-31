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

import rs.ac.bg.fon.nprog.NPRezervacijaSale.util.TipSale;

class SalaTest {
	
	Sala sala;

	@BeforeEach
	void setUp() throws Exception {
		sala = new Sala();
	}

	@AfterEach
	void tearDown() throws Exception {
		sala = null;
	}

	@Test
	void testSalaNonParameterizedConstructor() {
		sala = new Sala();
		
		assertNotNull(sala);
	}

	@Test
	void testSalaLongStringIntTipSaleListOfRezervacijaSale() {
		List<RezervacijaSale> rezervacije = new LinkedList<RezervacijaSale>();
		rezervacije.add(new RezervacijaSale());
		
		sala = new Sala(Long.valueOf(1), "B103", 100, TipSale.Amfiteatar, rezervacije);
		
		assertNotNull(sala);
		assertEquals(sala.getId(), Long.valueOf(1));
		assertEquals(sala.getNaziv(), "B103");
		assertEquals(sala.getKapacitet(), 100);
		assertEquals(sala.getTipSale(), TipSale.Amfiteatar);
		assertEquals(sala.getRezervacije(), rezervacije);
	}

	@ParameterizedTest
	@DisplayName("Testira postavljanje id-ja na unetu vrednost")
	@CsvSource({
		"2",
		"6"
	})
	void testSetId(Long id) {
		sala.setId(Long.valueOf(id));
		assertEquals(sala.getId(), id);
	}
	
	@Test
	@DisplayName("Testira bacanje izuzetka za id koji je null")
	void testSetIdIfNull() {
		assertThrows(java.lang.NullPointerException.class, () -> sala.setId(null));
	}
	
	@ParameterizedTest
	@DisplayName("Testira bacanje izuzetka za id koji je manji ili jendak 0")
	@CsvSource ({
		"0",
		"-3",
		"-11"
	})
	void testSetIdIfIdIsNegative(Long id) {
		assertThrows(java.lang.IllegalArgumentException.class, () -> sala.setId(Long.valueOf(id)));
	}

	@Test
	@DisplayName("Testira postavljanje naziva sale na unetu vrednost")
	void testSetNaziv() {
		sala.setNaziv("111");
		
		assertEquals(sala.getNaziv(), "111");
	}
	
	@Test
	@DisplayName("Testira postavljanje naziva sale na null vrednost")
	void testSetNazivNull() {
		assertThrows(java.lang.NullPointerException.class, ()->sala.setNaziv(null));
	}
	
	@Test
	@DisplayName("Testira postavljanje naziva sale na prazan string")
	void testSetNazivEmptyString() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->sala.setNaziv(""));
	}

	@Test
	@DisplayName("Testira postavljanje kapaciteta sale na unetu vrednost")
	void testSetKapacitet() {
		sala.setKapacitet(10);
		
		assertEquals(sala.getKapacitet(), 10);
	}
	
	@ParameterizedTest
	@DisplayName("Testira postavljanje kapaciteta sale na kapacitet manji od 1")
	@CsvSource({
		"0", 
		"-5"
	})
	void testSetKapacitetLessThanOne(int kapacitet) {
		assertThrows(java.lang.IllegalArgumentException.class, ()->sala.setKapacitet(kapacitet));
	}

	@Test
	void testSetTipSale() {
		sala.setTipSale(TipSale.Amfiteatar);
		
		assertEquals(sala.getTipSale(), TipSale.Amfiteatar);
	}
	
	@Test
	void testSetTipSaleNull() {
		assertThrows(java.lang.NullPointerException.class, ()->sala.setTipSale(null));
	}

	@Test
	void testSetRezervacije() {
		RezervacijaSale rezervacija = new RezervacijaSale();
		
		List<RezervacijaSale> rezervacije = new LinkedList<RezervacijaSale>();
		
		rezervacije.add(rezervacija);
		
		sala.setRezervacije(rezervacije);
		
		assertEquals(sala.getRezervacije(), rezervacije);
	}
	
	@Test
	@DisplayName("Testira postavljanje rezervacija na null vrednost")
	void testSetRezervacijeIsNull() {
		
		List<RezervacijaSale> rezervacije = null;
		
		assertThrows(java.lang.NullPointerException.class, ()->sala.setRezervacije(rezervacije));
	}

	@ParameterizedTest
	@CsvSource({
		"1, 111, 60, Amfiteatar, 1, 111, 60, Amfiteatar, true",
		"2, B103, 100, Amfiteatar, 2, B103, 90, Amfiteatar, false"
	})
	void testEqualsObject(Long id1, String naziv1, int kapacitet1, TipSale tip1, Long id2, String naziv2, int kapacitet2, TipSale tip2, boolean equals) {
		sala.setId(id1);
		sala.setNaziv(naziv1);
		sala.setKapacitet(kapacitet1);
		sala.setTipSale(tip1);
		Sala sala2 = new Sala();
		sala2.setId(id2);
		sala2.setNaziv(naziv2);
		sala2.setKapacitet(kapacitet2);
		sala2.setTipSale(tip2);
		
		assertEquals(sala.equals(sala2), equals);
	}

	@Test
	void testToString() {
		sala.setId(Long.valueOf(1));
		sala.setNaziv("B103");
		sala.setKapacitet(130);
		sala.setTipSale(TipSale.Amfiteatar);
		sala.setRezervacije(new LinkedList<RezervacijaSale>());
		
		assertEquals(sala.toString(), "Sala [id=" + "1" + ", naziv=" + "B103" + ", kapacitet=" + "130" + ", tipSale=" + "Amfiteatar"
				+ ", rezervacije=" + "[]" + "]");
	}

}
