package rs.ac.bg.fon.nprog.NPRezervacijaSale.service;

import java.util.List;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.AsistentDto;

public interface AsistentService {

	AsistentDto getAsistent(Long asistentId);
	AsistentDto saveAsistent(AsistentDto asistentDto);
	List<AsistentDto> getAllAsistents();
	
}
