package rs.ac.bg.fon.nprog.NPRezervacijaSale.service;

import java.util.List;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.ProfesorDto;

public interface ProfesorService {

	ProfesorDto getProfesor(Long profesorId);
	
	ProfesorDto saveProfesor(ProfesorDto profesorDto);
	
	List<ProfesorDto> getAllProfesors();
	
}
