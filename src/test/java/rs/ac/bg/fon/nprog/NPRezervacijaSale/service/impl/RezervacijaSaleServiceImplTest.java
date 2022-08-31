package rs.ac.bg.fon.nprog.NPRezervacijaSale.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockitoSession;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.annotation.security.RunAs;

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
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import antlr.Parser;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.NpRezervacijaSaleApplication;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.converter.AsistentConverter;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.converter.PredmetConverter;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.converter.ProfesorConverter;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.converter.RasporedIspitaConverter;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.converter.RezervacijaSaleConverter;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.converter.SalaConverter;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.Asistent;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.Predmet;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.Profesor;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.RasporedIspita;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.RezervacijaSale;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.Sala;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.AsistentDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.PredmetDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.ProfesorDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.RasporedIspitaDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.RezervacijaSaleDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.SalaDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.repository.AsistentRepository;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.repository.PredmetRepository;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.repository.ProfesorRepository;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.repository.RasporedIspitaRepository;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.repository.RezervacijaSaleRepository;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.repository.SalaRepository;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.service.AsistentService;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.service.PredmetService;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.service.ProfesorService;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.service.RasporedIspitaService;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.service.SalaService;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.util.Rok;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.util.TipIspita;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.util.TipSale;

@ContextConfiguration(classes = NpRezervacijaSaleApplication.class)
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
	@Autowired
	SalaServiceImpl salaService;
	
	@Mock
	@Autowired
	AsistentServiceImpl asistentService;
	
	@Mock
	@Autowired
	ProfesorServiceImpl profesorService;
	
	@Mock
	@Autowired
	PredmetServiceImpl predmetService;
	
	@Mock
	@Autowired
	RasporedIspitaServiceImpl rasporedService;
	
	@Mock
	@Autowired
	RezervacijaSaleConverter converter;
	
	@Mock
	@Autowired
	SalaConverter salaConverter;
	
	@Mock
	@Autowired
	AsistentConverter asistentConverter;
	
	@Mock
	@Autowired
	ProfesorConverter profesorConverter;
	
	@Mock
	@Autowired
	PredmetConverter predmetConverter;
	
	@Mock
	@Autowired
	RasporedIspitaConverter rasporedConverter;
	
	
	@BeforeEach
	void setUp() throws Exception {
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
	    RasporedIspita raspored = new RasporedIspita(Long.valueOf(1), Rok.SeptembarskiRok, null);
		
		RezervacijaSale rezervacija = new RezervacijaSale(Long.valueOf(1), Rok.JanuarskiRok, datumVremeOdDate, datumVremeDoDate, 50, TipIspita.UsmeniIspit, sala, asistent, profesor, predmet, raspored);
		
		RezervacijaSaleDto rezDto = new RezervacijaSaleDto(Long.valueOf(1), Rok.JanuarskiRok, datumVremeOdDate, datumVremeDoDate, 50, TipIspita.UsmeniIspit, sala.getId(), asistent.getId(), profesor.getId(), predmet.getId(), raspored.getId());
		
		Mockito.when(converter.toEntity(rezDto)).thenReturn(rezervacija);

		Mockito.when(repository.save(rezervacija)).thenReturn(rezervacija);
		
		Mockito.when(converter.toDto(rezervacija)).thenReturn(rezDto);
		
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
	    RasporedIspita raspored = new RasporedIspita(Long.valueOf(1), Rok.SeptembarskiRok, null);
		
		RezervacijaSale rezervacija = new RezervacijaSale(Long.valueOf(1), Rok.JanuarskiRok, datumVremeOdDate, datumVremeDoDate, 50, TipIspita.UsmeniIspit, sala, asistent, profesor, predmet, raspored);
		
		RezervacijaSaleDto rezDto = new RezervacijaSaleDto(Long.valueOf(1), Rok.JanuarskiRok, datumVremeOdDate, datumVremeDoDate, 50, TipIspita.UsmeniIspit, sala.getId(), asistent.getId(), profesor.getId(), predmet.getId(), raspored.getId());

		
		Mockito.when(repository.findAll()).thenReturn(List.of(rezervacija));
	
		Mockito.when(converter.toDto(rezervacija)).thenReturn(rezDto);
		
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
	void testUpdateRezervacijaSale() {
		Date datumVremeOdDate = new Date(2023,8,30,14,0,0);
	    Date datumVremeDoDate = new Date(2023,8,30,16,0,0);
	    Sala sala = new Sala(Long.valueOf(1), "B103", 100, TipSale.Amfiteatar, null);
	    Asistent asistent = new Asistent(Long.valueOf(3), "Milica", "Bacic", null);
	    Profesor profesor = new Profesor(Long.valueOf(3), "Milica", "Bacic", null);
	    Predmet predmet = new Predmet(Long.valueOf(1), "Napredno programiranje", 6, null);
	    RasporedIspita raspored = new RasporedIspita(Long.valueOf(1), Rok.SeptembarskiRok, null);
	    
	    SalaDto salaDto = new SalaDto(Long.valueOf(1), "B103", 100, TipSale.Amfiteatar);
	    AsistentDto asistentDto = new AsistentDto(Long.valueOf(3), "Milica", "Bacic");
	    ProfesorDto profesorDto = new ProfesorDto(Long.valueOf(3), "Milica", "Bacic");
	    PredmetDto predmetDto = new PredmetDto(Long.valueOf(1), "Napredno programiranje", 6);
	    RasporedIspitaDto rasporedDto = new RasporedIspitaDto(Long.valueOf(1), Rok.SeptembarskiRok);
		
		RezervacijaSale rezervacija = new RezervacijaSale(Long.valueOf(1), Rok.JanuarskiRok, datumVremeOdDate, datumVremeDoDate, 50, TipIspita.UsmeniIspit, sala, asistent, profesor, predmet, raspored);
		
		RezervacijaSaleDto rezDto = new RezervacijaSaleDto(Long.valueOf(1), Rok.JanuarskiRok, datumVremeOdDate, datumVremeDoDate, 50, TipIspita.UsmeniIspit, sala.getId(), asistent.getId(), profesor.getId(), predmet.getId(), raspored.getId());
		
		
		Mockito.when(repository.findById(rezDto.getId())).thenReturn(Optional.of(rezervacija));	
		
		Mockito.when(salaConverter.toEntity(salaService.getSala(rezDto.getSalaId()))).thenReturn(sala);
		
		Mockito.when(asistentConverter.toEntity(asistentService.getAsistent(rezDto.getAsistentId()))).thenReturn(asistent);
		
		Mockito.when(profesorConverter.toEntity(profesorService.getProfesor(rezDto.getProfesorId()))).thenReturn(profesor);
		
		Mockito.when(predmetConverter.toEntity(predmetService.getPredmet(rezDto.getPredmetId()))).thenReturn(predmet);
		
		Mockito.when(rasporedConverter.toEntity(rasporedService.getRaspored(rezDto.getRasporedId()))).thenReturn(raspored);
		
		Mockito.when(repository.save(rezervacija)).thenReturn(rezervacija);
		Mockito.when(converter.toDto(rezervacija)).thenReturn(rezDto);
		
		assertEquals(rezService.updateRezervacijaSale(rezDto), rezDto);
		assertDoesNotThrow(()->rezService.updateRezervacijaSale(rezDto));
		
	}
	
	@Test
	void updateRepositoryTurnsNull() {
		Date datumVremeOdDate = new Date(2023,8,30,14,0,0);
	    Date datumVremeDoDate = new Date(2023,8,30,16,0,0);
	    Sala sala = new Sala(Long.valueOf(1), "B103", 100, TipSale.Amfiteatar, null);
	    Asistent asistent = new Asistent(Long.valueOf(3), "Milica", "Bacic", null);
	    Profesor profesor = new Profesor(Long.valueOf(3), "Milica", "Bacic", null);
	    Predmet predmet = new Predmet(Long.valueOf(1), "Napredno programiranje", 6, null);
	    RasporedIspita raspored = new RasporedIspita(Long.valueOf(1), Rok.SeptembarskiRok, null);
	    
	    SalaDto salaDto = new SalaDto(Long.valueOf(1), "B103", 100, TipSale.Amfiteatar);
	    AsistentDto asistentDto = new AsistentDto(Long.valueOf(3), "Milica", "Bacic");
	    ProfesorDto profesorDto = new ProfesorDto(Long.valueOf(3), "Milica", "Bacic");
	    PredmetDto predmetDto = new PredmetDto(Long.valueOf(1), "Napredno programiranje", 6);
	    RasporedIspitaDto rasporedDto = new RasporedIspitaDto(Long.valueOf(1), Rok.SeptembarskiRok);
		
		RezervacijaSale rezervacija = new RezervacijaSale(Long.valueOf(1), Rok.JanuarskiRok, datumVremeOdDate, datumVremeDoDate, 50, TipIspita.UsmeniIspit, sala, asistent, profesor, predmet, raspored);
		
		RezervacijaSaleDto rezDto = new RezervacijaSaleDto(Long.valueOf(1), Rok.JanuarskiRok, datumVremeOdDate, datumVremeDoDate, 50, TipIspita.UsmeniIspit, sala.getId(), asistent.getId(), profesor.getId(), predmet.getId(), raspored.getId());
		
		
		Mockito.when(repository.findById(rezDto.getId())).thenReturn(Optional.empty());	
		
		assertThrows(java.util.NoSuchElementException.class, ()->rezService.updateRezervacijaSale(rezDto));
	}

}
