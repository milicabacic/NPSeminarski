package rs.ac.bg.fon.nprog.NPRezervacijaSale.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.converter.SalaConverter;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.Sala;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.SalaDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.repository.SalaRepository;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.util.TipSale;

@ExtendWith(MockitoExtension.class)
class SalaServiceImplTest {

	@InjectMocks
	@Autowired
	SalaServiceImpl salaService;
	
	@Autowired
	@Mock
	SalaRepository repository;
	
	SalaConverter converter;
	
	@BeforeEach
	void setUp() throws Exception {
		converter = new SalaConverter();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetSala() {
		Sala s = new Sala(Long.valueOf(1), "B103", 100, TipSale.Amfiteatar, null);
		
		Mockito.when(repository.findById(s.getId())).thenReturn(Optional.of(s));
		
		SalaDto sd = converter.toDto(s);
		
		assertEquals(salaService.getSala(s.getId()), sd);
		assertDoesNotThrow(()->salaService.getSala(s.getId()));
	}
	
	@Test
	void testGetSalaNull() {
		Mockito.when(repository.findById(Long.valueOf(2))).thenReturn(Optional.empty());
		
		assertThrows(Exception.class, ()->salaService.getSala(Long.valueOf(2)));
	}

	@Test
	void testSaveSala() {
		Sala s = new Sala(Long.valueOf(1), "B103", 100, TipSale.Amfiteatar, null);
		
		Mockito.when(repository.save(s)).thenReturn(s);
		
		SalaDto sd = converter.toDto(s);
		
		assertEquals(sd, salaService.saveSala(sd));
	}
	
	@Test
	void testSaveSalaNull() {
		Sala s = new Sala(Long.valueOf(1), "B103", 100, TipSale.Amfiteatar, null);
		SalaDto sd = converter.toDto(s);
		
		Mockito.when(repository.save(s)).thenReturn(null);
		
		assertThrows(org.springframework.web.server.ResponseStatusException.class, ()->salaService.saveSala(sd));
	}

	@Test
	void testGetAllSalas() {
		Sala s1 = new Sala(Long.valueOf(1), "B103", 100, TipSale.Amfiteatar, null);
		Sala s2 = new Sala(Long.valueOf(1), "111", 60, TipSale.RacunskaSala, null);
		
		Mockito.when(repository.findAll()).thenReturn(List.of(s1,s2));
		
		SalaDto sd1 = converter.toDto(s1);
		SalaDto sd2 = converter.toDto(s2);
		
		assertEquals(salaService.getAllSalas(), List.of(sd1,sd2));
		assertDoesNotThrow(()->salaService.getAllSalas());
	}

}
