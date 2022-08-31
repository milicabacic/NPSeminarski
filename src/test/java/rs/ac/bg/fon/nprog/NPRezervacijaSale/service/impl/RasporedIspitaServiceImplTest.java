package rs.ac.bg.fon.nprog.NPRezervacijaSale.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;

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
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.converter.RasporedIspitaConverter;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.RasporedIspita;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.RezervacijaSale;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.RasporedIspitaDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.repository.RasporedIspitaRepository;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.repository.RezervacijaSaleRepository;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.util.Rok;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class RasporedIspitaServiceImplTest {
	
	@InjectMocks
	@Autowired
	RasporedIspitaServiceImpl rasporedService;
	
	@Mock
	@Autowired
	RasporedIspitaRepository repository;
	
	@Mock
	@Autowired
	RezervacijaSaleRepository rezRepository;
	
	@Mock
	RasporedIspitaConverter converter;
	

	@BeforeEach
	void setUp() throws Exception {
		converter = new RasporedIspitaConverter();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetRaspored() {
		RasporedIspita raspored = new RasporedIspita(Long.valueOf(1), Rok.SeptembarskiRok, null);
		
		Mockito.when(repository.findById(Long.valueOf(1))).thenReturn(Optional.of(raspored));
		
		RasporedIspitaDto rasporedDto = converter.toDto(raspored);
		
		assertEquals(rasporedDto, rasporedService.getRaspored(Long.valueOf(1)));
		assertDoesNotThrow(()->rasporedService.getRaspored(Long.valueOf(1)));
	}
	
	
	@Test
	void testGetRasporedNull() {
		
		Mockito.when(repository.findById(Long.valueOf(2))).thenReturn(Optional.empty());
	
		
		assertThrows(Exception.class, ()->rasporedService.getRaspored(Long.valueOf(2)));
	}

	@Test
	void testSaveRaspored() {
		RasporedIspita raspored = new RasporedIspita(Long.valueOf(1), Rok.SeptembarskiRok, null);
		
		RasporedIspitaDto rasporedDto = converter.toDto(raspored);
		
		Mockito.when(repository.save(raspored)).thenReturn(raspored);
		
		assertEquals(rasporedService.saveRaspored(rasporedDto), rasporedDto);
		assertDoesNotThrow(()->rasporedService.saveRaspored(rasporedDto));
	}
	
	@Test
	void testSaveRasporedNull() {

		RasporedIspita raspored = new RasporedIspita(Long.valueOf(1), Rok.SeptembarskiRok, null);
		
		RasporedIspitaDto rasporedDto = converter.toDto(raspored);
		
		Mockito.when(repository.save(raspored)).thenReturn(null);

		
		assertThrows(org.springframework.web.server.ResponseStatusException.class, ()->rasporedService.saveRaspored(rasporedDto));
	}

	@Test
	void testGetAllRasporeds() {
		RasporedIspita raspored = new RasporedIspita(Long.valueOf(1), Rok.SeptembarskiRok, null);
		RasporedIspita raspored2 = new RasporedIspita(Long.valueOf(2), Rok.OktobarskiRok, null);
		
		RasporedIspitaDto rasporedDto = converter.toDto(raspored);
		RasporedIspitaDto rasporedDto2 = converter.toDto(raspored2);
		
		Mockito.when(repository.findAll()).thenReturn(List.of(raspored,raspored2));
		
		Mockito.when(rezRepository.findByRaspored(Long.valueOf(1))).thenReturn(null);
		
		assertEquals(rasporedService.getAllRasporeds(), List.of(rasporedDto, rasporedDto2));
		assertDoesNotThrow(()->rasporedService.getAllRasporeds());
	}

}
