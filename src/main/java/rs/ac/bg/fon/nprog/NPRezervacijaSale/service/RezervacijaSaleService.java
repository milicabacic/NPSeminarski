package rs.ac.bg.fon.nprog.NPRezervacijaSale.service;

import java.util.List;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.RezervacijaSaleDto;

public interface RezervacijaSaleService {

	RezervacijaSaleDto getRezervacijaSale(Long rezervacijaSaleId);
	
	RezervacijaSaleDto saveRezervacijaSale(RezervacijaSaleDto rezervacijaDto);
	
	List<RezervacijaSaleDto> getAllRezervacijaSales();
	
	boolean deleteRezervacijaSale(Long rezervacijaSaleId);
	
	RezervacijaSaleDto updateRezervacijaSale(RezervacijaSaleDto rezervacijaDto);
}
