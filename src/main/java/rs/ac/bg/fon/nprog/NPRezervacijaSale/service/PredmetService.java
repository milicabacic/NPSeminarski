package rs.ac.bg.fon.nprog.NPRezervacijaSale.service;

import java.util.List;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.PredmetDto;

public interface PredmetService {

	PredmetDto getPredmet (Long predmetId);
	
	PredmetDto savePredmet(PredmetDto predmetDto);
	
	List<PredmetDto> getAllPredmets();
	
}
