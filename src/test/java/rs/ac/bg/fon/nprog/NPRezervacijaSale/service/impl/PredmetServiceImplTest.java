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

import rs.ac.bg.fon.nprog.NPRezervacijaSale.converter.PredmetConverter;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.Predmet;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.PredmetDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.repository.PredmetRepository;

@ExtendWith(MockitoExtension.class)
class PredmetServiceImplTest {
	
	@InjectMocks
	@Autowired
	PredmetServiceImpl predmetService;
	
	@Mock
	@Autowired
	PredmetRepository repository;
	
	PredmetConverter converter;

	@BeforeEach
	void setUp() throws Exception {
		converter = new PredmetConverter();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetPredmet() {
		Predmet p = new Predmet(Long.valueOf(1), "Napredno programiranje", 6, null);
		
		Mockito.when(repository.findById(Long.valueOf(1))).thenReturn(Optional.of(p));
		
		PredmetDto pd = converter.toDto(p);
		
		assertEquals(predmetService.getPredmet(Long.valueOf(1)), pd);
		assertDoesNotThrow(()->predmetService.getPredmet(Long.valueOf(1)));
	}
	
	@Test
	void testGetProfesorNull() {
		
		Mockito.when(repository.findById(Long.valueOf(2))).thenReturn(Optional.empty());
		
		assertThrows(Exception.class, ()->predmetService.getPredmet(Long.valueOf(2)));
	}

	@Test
	void testSavePredmet() {
		Predmet p = new Predmet(Long.valueOf(1), "Napredno programiranje", 6, null);
		
		PredmetDto pd = converter.toDto(p);
		
		Mockito.when(repository.save(p)).thenReturn(p);
		
		assertEquals(predmetService.savePredmet(pd), pd);
		assertDoesNotThrow(()->predmetService.savePredmet(pd));
	}
	
	@Test
	void testSavePredmetNull() {
		Predmet p = new Predmet(Long.valueOf(1), "Napredno programiranje", 6, null);
		
		PredmetDto pd = converter.toDto(p);
		
		Mockito.when(repository.save(p)).thenReturn(null);
		
		assertThrows(org.springframework.web.server.ResponseStatusException.class, ()->predmetService.savePredmet(pd));
	}

	@Test
	void testGetAllPredmets() {
		Predmet p1 = new Predmet(Long.valueOf(1), "Napredno programiranje", 6, null);
		Predmet p2 = new Predmet(Long.valueOf(2), "Matematika 1", 6, null);
		
		Mockito.when(repository.findAll()).thenReturn(List.of(p1,p2));
		
		PredmetDto pd1 = converter.toDto(p1);
		PredmetDto pd2 = converter.toDto(p2);
		
		assertEquals(predmetService.getAllPredmets(), List.of(pd1,pd2));
		assertDoesNotThrow(()->predmetService.getAllPredmets());
	}

}
