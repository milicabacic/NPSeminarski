package rs.ac.bg.fon.nprog.NPRezervacijaSale.service;

import java.util.List;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.RasporedIspitaDto;

public interface RasporedIspitaService {

	RasporedIspitaDto getRaspored(Long rasporedId);
	
	RasporedIspitaDto saveRaspored(RasporedIspitaDto raspored);
	
	List<RasporedIspitaDto> getAllRasporeds();
	
}
