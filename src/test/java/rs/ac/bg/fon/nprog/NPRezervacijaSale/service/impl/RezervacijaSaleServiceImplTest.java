package rs.ac.bg.fon.nprog.NPRezervacijaSale.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.converter.AsistentConverter;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.converter.RezervacijaSaleConverter;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.converter.SalaConverter;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.Asistent;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.Predmet;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.Profesor;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.RasporedIspita;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.RezervacijaSale;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.Sala;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.RasporedIspitaDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.RezervacijaSaleDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.repository.AsistentRepository;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.repository.PredmetRepository;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.repository.ProfesorRepository;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.repository.RasporedIspitaRepository;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.repository.RezervacijaSaleRepository;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.repository.SalaRepository;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.util.Rok;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.util.TipIspita;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.util.TipSale;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class RezervacijaSaleServiceImplTest {

	@Autowired
	@InjectMocks
	RezervacijaSaleServiceImpl rezService;
	
	@Mock
	@Autowired
	RezervacijaSaleRepository repository;
	
	@Mock
	@Autowired
	SalaRepository salaRepo;
	
	@Mock
	@Autowired
	AsistentRepository asistentRepo;
	
	@Mock
	@Autowired
	ProfesorRepository profesorRepo;
	
	@Mock 
	@Autowired
	PredmetRepository predmetRepo;
	
	@Mock
	@Autowired
	RasporedIspitaRepository rasporedRepo;
	
	@Mock
	SalaServiceImpl salaService;
	
	@Mock
	AsistentServiceImpl asistentService;
	
	@Mock
	ProfesorServiceImpl profesorService;
	
	@Mock
	PredmetServiceImpl predmetService;
	
	@Mock
	RasporedIspitaServiceImpl rasporedService;
	
	RezervacijaSaleConverter converter;
	
	
	@BeforeEach
	void setUp() throws Exception {
		converter = new RezervacijaSaleConverter();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetRezervacijaSale() {
		Date datumVremeOdDate = new Date(2023,8,30,14,0,0);
	    Date datumVremeDoDate = new Date(2023,8,30,16,0,0);
	    Sala sala = new Sala();
	    Asistent asistent = new Asistent();
	    Profesor profesor = new Profesor();
	    Predmet predmet = new Predmet();
	    RasporedIspita raspored = new RasporedIspita();
		
		RezervacijaSale rezervacija = new RezervacijaSale(Long.valueOf(1), Rok.JanuarskiRok, datumVremeOdDate, datumVremeDoDate, 50, TipIspita.UsmeniIspit, sala, asistent, profesor, predmet, raspored);
		
		Mockito.when(repository.findById(rezervacija.getId())).thenReturn(Optional.of(rezervacija));
		
		Mockito.when(salaRepo.findById(rezervacija.getSala().getId())).thenReturn(Optional.of(sala));
		Mockito.when(profesorRepo.findById(rezervacija.getProfesor().getId())).thenReturn(Optional.of(profesor));
		Mockito.when(asistentRepo.findById(rezervacija.getAsistent().getId())).thenReturn(Optional.of(asistent));
		Mockito.when(predmetRepo.findById(rezervacija.getPredmet().getId())).thenReturn(Optional.of(predmet));
		Mockito.when(rasporedRepo.findById(rezervacija.getRaspored().getId())).thenReturn(Optional.of(raspored));
		
		RezervacijaSaleDto rezDto = converter.toDto(rezervacija);
		
		assertEquals(rezService.getRezervacijaSale(rezervacija.getId()), rezDto);
		assertDoesNotThrow(()->rezService.getRezervacijaSale(rezervacija.getId()));
	}
	
	@Test
	void testGetRezervacijaSaleNull() {
		
		Mockito.when(repository.findById(Long.valueOf(2))).thenReturn(Optional.empty());
		
		assertThrows(Exception.class, ()->rezService.getRezervacijaSale(Long.valueOf(2)));
	}

	@Test
	void testSaveRezervacijaSale() {
		Date datumVremeOdDate = new Date(2023,8,30,14,0,0);
	    Date datumVremeDoDate = new Date(2023,8,30,16,0,0);
	    Sala sala = new Sala(Long.valueOf(1), "B103", 100, TipSale.Amfiteatar, null);
	    Asistent asistent = new Asistent(Long.valueOf(3), "Milica", "Bacic", null);
	    Profesor profesor = new Profesor(Long.valueOf(3), "Milica", "Bacic", null);
	    Predmet predmet = new Predmet(Long.valueOf(1), "Napredno programiranje", 6, null);
	    RasporedIspita raspored = new RasporedIspita();
		
		RezervacijaSale rezervacija = new RezervacijaSale(Long.valueOf(1), Rok.JanuarskiRok, datumVremeOdDate, datumVremeDoDate, 50, TipIspita.UsmeniIspit, sala, asistent, profesor, predmet, raspored);
		
		RezervacijaSaleDto rezDto = converter.toDto(rezervacija);
		
		Mockito.when(rezService.saveRezervacijaSale(rezDto)).thenReturn(rezDto);
		
		assertEquals(rezDto, rezService.saveRezervacijaSale(rezDto));
		
	}

	@Test
	void testGetAllRezervacijaSales() {
		Date datumVremeOdDate = new Date(2023,8,30,14,0,0);
	    Date datumVremeDoDate = new Date(2023,8,30,16,0,0);
	    Sala sala = new Sala(Long.valueOf(1), "B103", 100, TipSale.Amfiteatar, null);
	    Asistent asistent = new Asistent(Long.valueOf(3), "Milica", "Bacic", null);
	    Profesor profesor = new Profesor(Long.valueOf(3), "Milica", "Bacic", null);
	    Predmet predmet = new Predmet(Long.valueOf(1), "Napredno programiranje", 6, null);
	    RasporedIspita raspored = new RasporedIspita();
		
		RezervacijaSale rezervacija = new RezervacijaSale(Long.valueOf(1), Rok.JanuarskiRok, datumVremeOdDate, datumVremeDoDate, 50, TipIspita.UsmeniIspit, sala, asistent, profesor, predmet, raspored);
		
		RezervacijaSaleDto rezDto = converter.toDto(rezervacija);
		
		Mockito.when(repository.findAll()).thenReturn(List.of(rezervacija));
	
		
		assertEquals(rezService.getAllRezervacijaSales(), List.of(rezDto));
		assertDoesNotThrow(()->rasporedService.getAllRasporeds());
	}

	@Test
	void testDeleteRezervacijaSale() {
		Date datumVremeOdDate = new Date(2023,8,30,14,0,0);
	    Date datumVremeDoDate = new Date(2023,8,30,16,0,0);
	    Sala sala = new Sala(Long.valueOf(1), "B103", 100, TipSale.Amfiteatar, null);
	    Asistent asistent = new Asistent(Long.valueOf(3), "Milica", "Bacic", null);
	    Profesor profesor = new Profesor(Long.valueOf(3), "Milica", "Bacic", null);
	    Predmet predmet = new Predmet(Long.valueOf(1), "Napredno programiranje", 6, null);
	    RasporedIspita raspored = new RasporedIspita();
		
		RezervacijaSale rezervacija = new RezervacijaSale(Long.valueOf(1), Rok.JanuarskiRok, datumVremeOdDate, datumVremeDoDate, 50, TipIspita.UsmeniIspit, sala, asistent, profesor, predmet, raspored);
		
		Mockito.when(repository.findById(rezervacija.getId())).thenReturn(Optional.of(rezervacija));
		
		Mockito.doNothing().when(repository).delete(rezervacija);
		
		assertTrue(rezService.deleteRezervacijaSale(rezervacija.getId()));
		assertDoesNotThrow(()->rezService.deleteRezervacijaSale(rezervacija.getId()));
	}

	@Test
	void testDeleteRezervacijaSaleDoesntExist() {
		Date datumVremeOdDate = new Date(2023,8,30,14,0,0);
	    Date datumVremeDoDate = new Date(2023,8,30,16,0,0);
	    Sala sala = new Sala(Long.valueOf(1), "B103", 100, TipSale.Amfiteatar, null);
	    Asistent asistent = new Asistent(Long.valueOf(3), "Milica", "Bacic", null);
	    Profesor profesor = new Profesor(Long.valueOf(3), "Milica", "Bacic", null);
	    Predmet predmet = new Predmet(Long.valueOf(1), "Napredno programiranje", 6, null);
	    RasporedIspita raspored = new RasporedIspita();
		
		RezervacijaSale rezervacija = new RezervacijaSale(Long.valueOf(1), Rok.JanuarskiRok, datumVremeOdDate, datumVremeDoDate, 50, TipIspita.UsmeniIspit, sala, asistent, profesor, predmet, raspored);
		
		Mockito.when(repository.findById(rezervacija.getId())).thenReturn(Optional.empty());
		
		assertThrows(org.springframework.web.server.ResponseStatusException.class, ()->rezService.deleteRezervacijaSale(rezervacija.getId()));
	}
	
	@Test
	void testUpdateRezervacijaSale() {
		Date datumVremeOdDate = new Date(2023,8,30,14,0,0);
	    Date datumVremeDoDate = new Date(2023,8,30,16,0,0);
	    Sala sala = new Sala(Long.valueOf(1), "B103", 100, TipSale.Amfiteatar, null);
	    Asistent asistent = new Asistent(Long.valueOf(3), "Milica", "Bacic", null);
	    Profesor profesor = new Profesor(Long.valueOf(3), "Milica", "Bacic", null);
	    Predmet predmet = new Predmet(Long.valueOf(1), "Napredno programiranje", 6, null);
	    RasporedIspita raspored = new RasporedIspita();
		
		RezervacijaSale rezervacija = new RezervacijaSale(Long.valueOf(1), Rok.JanuarskiRok, datumVremeOdDate, datumVremeDoDate, 50, TipIspita.UsmeniIspit, sala, asistent, profesor, predmet, raspored);
		
		RezervacijaSaleDto rezDto = converter.toDto(rezervacija);
		
		Mockito.when(repository.findById(rezDto.getId())).thenReturn(Optional.of(rezervacija));	
	}

}
