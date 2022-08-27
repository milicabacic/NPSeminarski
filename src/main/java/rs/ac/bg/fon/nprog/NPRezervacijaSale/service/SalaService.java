package rs.ac.bg.fon.nprog.NPRezervacijaSale.service;

import java.util.List;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.SalaDto;

public interface SalaService {

	SalaDto getSala(Long salaId);
	SalaDto saveSala(SalaDto salaDto);
	List<SalaDto> getAllSalas();
}
