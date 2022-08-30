package rs.ac.bg.fon.nprog.NPRezervacijaSale.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

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
import org.springframework.beans.factory.annotation.Autowired;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.converter.AsistentConverter;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.Asistent;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.AsistentDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.repository.AsistentRepository;

@ExtendWith(MockitoExtension.class)
class AsistentServiceImplTest {

	@InjectMocks
	@Autowired
	AsistentServiceImpl asistentService;
	
	@Mock
	@Autowired
	AsistentRepository repository;
	
	
	AsistentConverter converter;
	
	
	@BeforeEach
	void setUp() throws Exception {
		converter = new AsistentConverter();
	}

	@AfterEach
	void tearDown() throws Exception {
		asistentService = null;
	}

	@Test
	void testGetAsistent() {
		Asistent a = new Asistent(Long.valueOf(1), "Milca", "Bacic", null);
		
		Mockito.when(repository.findById(Long.valueOf(1))).thenReturn(Optional.of(a));
		
		AsistentDto ad = converter.toDto(a);
		
		assertEquals(asistentService.getAsistent(Long.valueOf(1)), ad);
		assertDoesNotThrow(()->asistentService.getAsistent(Long.valueOf(1)));
	}
	
	@Test
	void testGetAsistentNull() {
		
		Mockito.when(repository.findById(Long.valueOf(2))).thenReturn(Optional.empty());
		
		assertThrows(Exception.class, ()->asistentService.getAsistent(Long.valueOf(2)));
	}

	@Test
	void testSaveAsistent() {
		Asistent a = new Asistent(Long.valueOf(1), "Pera", "Peric", null);
		
		Mockito.when(repository.save(a)).thenReturn(a);
		
		AsistentDto ad = converter.toDto(a);
		
		assertEquals(asistentService.saveAsistent(ad), ad);
		assertDoesNotThrow(()->asistentService.saveAsistent(ad));
		
	}
	
	@Test
	void testSaveAsistentNull() {
		Asistent a = new Asistent(Long.valueOf(1), "Pera", "Peric", null);
		
		AsistentDto ad = converter.toDto(a);
		
		Mockito.when(repository.save(a)).thenReturn(null);

		assertThrows(org.springframework.web.server.ResponseStatusException.class, ()->asistentService.saveAsistent(ad));
		
	}

	@Test
	void testGetAllAsistents() {
		Asistent a1 = new Asistent(Long.valueOf(1), "Pera", "Peric", null);
		Asistent a2 = new Asistent(Long.valueOf(2), "Mika", "Mikic", null);
		Mockito.when(repository.findAll()).thenReturn(List.of(a1,a2));
		
		AsistentDto ad1 = converter.toDto(a1);
		AsistentDto ad2 = converter.toDto(a2);
		
		List<AsistentDto> asistentsDto = List.of(ad1, ad2);
		
		assertEquals(asistentService.getAllAsistents(), asistentsDto);
		assertDoesNotThrow(()->asistentService.getAllAsistents());
	}

}
