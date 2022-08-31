package rs.ac.bg.fon.nprog.NPRezervacijaSale.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.util.Rok;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.util.TipIspita;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.util.TipSale;

class RezervacijaSaleTest {
	
	RezervacijaSale rezervacija;

	@BeforeEach
	void setUp() throws Exception {
		rezervacija = new RezervacijaSale();
	}

	@AfterEach
	void tearDown() throws Exception {
		rezervacija = null;
	}

	@Test
	void testRezervacijaSaleNonParameterizedConstructor() {
		rezervacija = new RezervacijaSale();
		
		assertNotNull(rezervacija);
	}

	
	@SuppressWarnings("deprecation")
	@Test
	void testRezervacijaSaleLongRokDateDateIntTipIspitaSalaAsistentProfesorPredmetRasporedIspita() {
		
	    Date datumVremeOdDate = new Date(2023,8,30,14,0,0);
	    Date datumVremeDoDate = new Date(2023,8,30,16,0,0);
	    Sala sala = new Sala();
	    Asistent asistent = new Asistent();
	    Profesor profesor = new Profesor();
	    Predmet predmet = new Predmet();
	    RasporedIspita raspored = new RasporedIspita();
		
		rezervacija = new RezervacijaSale(Long.valueOf(1), Rok.JanuarskiRok, datumVremeOdDate, datumVremeDoDate, 50, TipIspita.UsmeniIspit, sala, asistent, profesor, predmet, raspored);
		
		assertNotNull(rezervacija);
		assertEquals(rezervacija.getId(), Long.valueOf(1));
		assertEquals(rezervacija.getRok(), Rok.JanuarskiRok);
		assertEquals(rezervacija.getDatumVremeOd(), datumVremeOdDate);
		assertEquals(rezervacija.getDatumVremeDo(), datumVremeDoDate);
		assertEquals(rezervacija.getBrojStudenata(), 50);
		assertEquals(rezervacija.getTipIspita(), TipIspita.UsmeniIspit);
		assertEquals(rezervacija.getSala(), sala);
		assertEquals(rezervacija.getAsistent(), asistent);
		assertEquals(rezervacija.getProfesor(), profesor);
		assertEquals(rezervacija.getPredmet(), predmet);
		assertEquals(rezervacija.getRaspored(), raspored);
	}

	@ParameterizedTest
	@DisplayName("Testira postavljanje id-ja na unetu vrednost")
	@CsvSource({
		"1",
		"12"
	})
	void testSetId(Long id) {
		rezervacija.setId(Long.valueOf(id));
		assertEquals(rezervacija.getId(), id);
	}
	
	@Test
	@DisplayName("Testira bacanje izuzetka za id koji je null")
	void testSetIdIfNull() {
		assertThrows(java.lang.NullPointerException.class, () -> rezervacija.setId(null));
	}
	
	@ParameterizedTest
	@DisplayName("Testira bacanje izuzetka za id koji je manji ili jendak 0")
	@CsvSource ({
		"0",
		"-4",
		"-11"
	})
	void testSetIdIfIdIsNegative(Long id) {
		assertThrows(java.lang.IllegalArgumentException.class, () -> rezervacija.setId(Long.valueOf(id)));
	}

	@Test
	void testSetRok() {
		rezervacija.setRok(Rok.JanuarskiRok);
		
		assertEquals(rezervacija.getRok(), Rok.JanuarskiRok);
	}
	
	@Test
	@DisplayName("Testira postavljanje roka na null vrednost")
	void testSetRokIsNull() {
		assertThrows(java.lang.NullPointerException.class, ()->rezervacija.setRok(null)); 
		}
	

	@Test
	void testSetDatumVremeOd() {
		rezervacija.setDatumVremeOd(new Date());
		
		assertEquals(rezervacija.getDatumVremeOd(), new Date());
	}
	
	@Test
	@DisplayName("Testira datum i vreme od za unetu null vrednost")
	void testSetDatumVremeOdNull() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->rezervacija.setDatumVremeOd(null));
	}
	
	@Test
	@DisplayName("Testira datum i vreme od za unetu proslu vrednost")
	void testSetDatumVremeOdBeforeNow() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->rezervacija.setDatumVremeOd(new Date(2020)));
	}

	@Test
	void testSetDatumVremeDo() {
		rezervacija.setDatumVremeOd(new Date(2023,8,25,14,0,0));
		rezervacija.setDatumVremeDo(new Date(2023,8,25,16,0,0));
		
		assertEquals(rezervacija.getDatumVremeDo(), new Date(2023,8,25,16,0,0));
	}
	
	@Test
	@DisplayName("Testira datum i vreme do za unetu null vrednost")
	void testSetDatumVremeDoNull() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->rezervacija.setDatumVremeDo(null));
	}
	
	@Test
	@DisplayName("Testira datum i vreme do za unetu proslu vrednost")
	void testSetDatumVremeDoBeforeNow() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->rezervacija.setDatumVremeDo(new Date(2020)));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	@DisplayName("Testira datum i vreme do u odnosu na datum i vreme od")
	void testSetDatumVremeDoBeforeDatumVremeOd() {
		rezervacija.setDatumVremeOd(new Date(2023,8,30));
		assertThrows(java.lang.IllegalArgumentException.class, ()->rezervacija.setDatumVremeDo(new Date(2023,8,25)));
	}

	@Test
	void testSetBrojStudenata() {
		Sala sala = new Sala();
		sala.setKapacitet(50);
		rezervacija.setSala(sala);
		
		rezervacija.setBrojStudenata(5);
		
		assertEquals(rezervacija.getBrojStudenata(), 5);
	}
	
	@ParameterizedTest
	@CsvSource({
		"0",
		"-1"
	})
	void testSetBrojStudenataLessThanOne(int br) {
		assertThrows(java.lang.IllegalArgumentException.class, ()-> rezervacija.setBrojStudenata(br));
	}
	
	@Test
	void testSetBrojStudenataLessThanKapacitetSale() {
		Sala sala = new Sala(Long.valueOf(1), "111", 60, TipSale.Ucionica, new LinkedList<RezervacijaSale>());
		
		rezervacija.setSala(sala);
		
		assertThrows(java.lang.IllegalArgumentException.class, ()-> rezervacija.setBrojStudenata(80));
	}

	@Test
	void testSetTipIspita() {
		rezervacija.setTipIspita(TipIspita.PismeniIspit);
		
		assertEquals(rezervacija.getTipIspita(), TipIspita.PismeniIspit);
	}
	
	@Test
	void testSetTipIspitaNull() {
		assertThrows(java.lang.NullPointerException.class, ()->rezervacija.setTipIspita(null));
	}

	@Test
	void testSetSala() {
		Sala sala = new Sala();
		rezervacija.setSala(sala);
		
		assertEquals(rezervacija.getSala(), sala);
		
	}
	
	@Test
	void testSetSalaNull() {
		assertThrows(java.lang.NullPointerException.class, ()->rezervacija.setSala(null));
		
	}

	@Test
	void testSetAsistent() {
		Asistent asistent = new Asistent();
		rezervacija.setAsistent(asistent);
		
		assertEquals(rezervacija.getAsistent(), asistent);
	}
	
	@Test
	void testSetAsistentNull() {
		assertThrows(java.lang.NullPointerException.class, ()->rezervacija.setAsistent(null));
	}

	@Test
	void testSetProfesor() {
		Profesor profesor = new Profesor();
		rezervacija.setProfesor(profesor);
		
		assertEquals(rezervacija.getProfesor(), profesor);
	}
	
	@Test
	void testSetProfesorNull() {
		assertThrows(java.lang.NullPointerException.class, ()->rezervacija.setProfesor(null));
	}

	@Test
	void testSetPredmet() {
		Predmet predmet = new Predmet();
		rezervacija.setPredmet(predmet);
		
		assertEquals(rezervacija.getPredmet(), predmet);
	}
	
	@Test
	void testSetPredmetNull() {
		assertThrows(java.lang.NullPointerException.class, ()->rezervacija.setPredmet(null));
	}

	@Test
	void testSetRaspored() {
		RasporedIspita raspored = new RasporedIspita();
		rezervacija.setRaspored(raspored);
		
		assertEquals(rezervacija.getRaspored(), raspored);
	}
	@Test
	void testSetRasporedNull() {
		assertThrows(java.lang.NullPointerException.class, ()->rezervacija.setRaspored(null));
	}

	@SuppressWarnings("deprecation")
	@Test
	void testEqualsObjectTrue() {
		rezervacija.setId(Long.valueOf(1));
		rezervacija.setRok(Rok.JanuarskiRok);
		rezervacija.setDatumVremeOd(new Date(2023,8,25,14,0,0));
		rezervacija.setDatumVremeDo(new Date(2023,8,25,16,0,0));
		rezervacija.setTipIspita(TipIspita.PismeniIspit);
		Sala sala = new Sala();
		sala.setKapacitet(100);
		rezervacija.setSala(sala);
		rezervacija.setBrojStudenata(60);
		Asistent asistent = new Asistent();
		rezervacija.setAsistent(asistent);
		Profesor profesor = new Profesor();
		rezervacija.setProfesor(profesor);
		Predmet predmet = new Predmet();
		rezervacija.setPredmet(predmet);
		RasporedIspita raspored = new RasporedIspita();
		rezervacija.setRaspored(raspored);
		
		RezervacijaSale rezervacija2 = new RezervacijaSale();
		rezervacija2.setId(Long.valueOf(1));
		rezervacija2.setId(Long.valueOf(1));
		rezervacija2.setRok(Rok.JanuarskiRok);
		rezervacija2.setDatumVremeOd(new Date(2023,8,25,14,0,0));
		rezervacija2.setDatumVremeDo(new Date(2023,8,25,16,0,0));
		rezervacija2.setTipIspita(TipIspita.PismeniIspit);
		rezervacija2.setSala(sala);
		rezervacija2.setBrojStudenata(60);
		rezervacija2.setAsistent(asistent);
		rezervacija2.setProfesor(profesor);
		rezervacija2.setPredmet(predmet);
		rezervacija2.setRaspored(raspored);
		
		assertEquals(rezervacija.equals(rezervacija2), true);
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testEqualsObjectFalse() {
		rezervacija.setId(Long.valueOf(1));
		rezervacija.setRok(Rok.JanuarskiRok);
		rezervacija.setDatumVremeOd(new Date(2023,8,25,14,0,0));
		rezervacija.setDatumVremeDo(new Date(2023,8,25,16,0,0));
		rezervacija.setTipIspita(TipIspita.PismeniIspit);
		Sala sala = new Sala();
		sala.setKapacitet(100);
		rezervacija.setSala(sala);
		rezervacija.setBrojStudenata(60);
		Asistent asistent = new Asistent();
		rezervacija.setAsistent(asistent);
		Profesor profesor = new Profesor();
		rezervacija.setProfesor(profesor);
		Predmet predmet = new Predmet();
		rezervacija.setPredmet(predmet);
		RasporedIspita raspored = new RasporedIspita();
		rezervacija.setRaspored(raspored);
		
		RezervacijaSale rezervacija2 = new RezervacijaSale();
		rezervacija2.setId(Long.valueOf(1));
		rezervacija2.setId(Long.valueOf(1));
		rezervacija2.setRok(Rok.JulskiRok);
		rezervacija2.setDatumVremeOd(new Date(2023,8,25,14,0,0));
		rezervacija2.setDatumVremeDo(new Date(2023,8,25,16,0,0));
		rezervacija2.setTipIspita(TipIspita.UsmeniIspit);
		rezervacija2.setSala(sala);
		rezervacija2.setBrojStudenata(60);
		rezervacija2.setAsistent(asistent);
		rezervacija2.setProfesor(profesor);
		rezervacija2.setPredmet(predmet);
		rezervacija2.setRaspored(raspored);
		
		assertEquals(rezervacija.equals(rezervacija2), false);
		
	}

	@Test
	void testToString() {
		rezervacija.setId(Long.valueOf(2));
		rezervacija.setRok(Rok.SeptembarskiRok);
		rezervacija.setTipIspita(TipIspita.PismeniIspit);
		
		assertEquals(rezervacija.toString(), "RezervacijaSale [id=" + "2" + ", rok=" + "SeptembarskiRok" + ", datumVremeOd=" + "null" + ", datumVremeDo="
				+ "null" + ", brojStudenata=" + "0" + ", tipIspita=" + "PismeniIspit" + ", sala=" + "null"
				+ ", asistent=" + "null" + ", profesor=" + "null" + ", predmet=" + "null" + ", raspored="
				+ "null" + "]");
	}

}
