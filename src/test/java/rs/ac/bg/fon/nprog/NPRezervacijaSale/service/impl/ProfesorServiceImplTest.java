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

import rs.ac.bg.fon.nprog.NPRezervacijaSale.converter.ProfesorConverter;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.Profesor;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.ProfesorDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.repository.ProfesorRepository;

@ExtendWith(MockitoExtension.class)
class ProfesorServiceImplTest {

	@InjectMocks
	@Autowired
	ProfesorServiceImpl profesorService;
	
	@Mock
	@Autowired
	ProfesorRepository repository;
	
	
	ProfesorConverter converter;
	
	@BeforeEach
	void setUp() throws Exception {
		converter = new ProfesorConverter();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetProfesor() {
		Profesor p = new Profesor(Long.valueOf(1), "Laza", "Lazic", null);
		
		Mockito.when(repository.findById(Long.valueOf(1))).thenReturn(Optional.of(p));
		
		ProfesorDto pd = converter.toDto(p);
		
		assertEquals(profesorService.getProfesor(Long.valueOf(1)), pd);
		assertDoesNotThrow(()->profesorService.getProfesor(Long.valueOf(1)));
	}
	
	@Test
	void testGetProfesorNull() {
		
		Mockito.when(repository.findById(Long.valueOf(2))).thenReturn(Optional.empty());
		
		assertThrows(Exception.class, ()->profesorService.getProfesor(Long.valueOf(2)));
	}

	@Test
	void testSaveProfesor() {
		Profesor p = new Profesor(Long.valueOf(1), "Pera", "Peric", null);
		
		Mockito.when(repository.save(p)).thenReturn(p);
		
		ProfesorDto pd = converter.toDto(p);
		
		assertEquals(profesorService.saveProfesor(pd), pd);
		assertDoesNotThrow(()->profesorService.saveProfesor(pd));
	}
	
	@Test
	void testSaveAsistentNull() {
		Profesor p = new Profesor(Long.valueOf(1), "Pera", "Peric", null);
		
		ProfesorDto pd = converter.toDto(p);
		
		Mockito.when(repository.save(p)).thenReturn(null);

		assertThrows(org.springframework.web.server.ResponseStatusException.class, ()->profesorService.saveProfesor(pd));
		
	}

	@Test
	void testGetAllProfesors() {
		Profesor p1 = new Profesor(Long.valueOf(1), "Pera", "Peric", null);
		Profesor p2 = new Profesor(Long.valueOf(2), "Mika", "Mikic", null);
		Mockito.when(repository.findAll()).thenReturn(List.of(p1,p2));
		
		ProfesorDto pd1 = converter.toDto(p1);
		ProfesorDto pd2 = converter.toDto(p2);
		
		List<ProfesorDto> profesoriDto = List.of(pd1,pd2);
		
		assertEquals(profesorService.getAllProfesors(), profesoriDto);
		assertDoesNotThrow(()->profesorService.getAllProfesors());
	}

}
