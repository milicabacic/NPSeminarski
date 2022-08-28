package rs.ac.bg.fon.nprog.NPRezervacijaSale.service;

import java.util.List;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.PredmetDto;
/**
 * Interfejs koji specificira CRUD metode nad klasom PredmetDto
 * 
 * @author Milica Bacic
 *
 */
public interface PredmetService {
	/**
	 * Metoda koja vraca objekat klase PredmetDto sa zadatim id-jem
	 * 
	 * @param predmetId Id predmeta koji treba da bude vracen
	 * @return Vraca predmet kao objekat klase PredmetDto koji ima dati id
	 */
	PredmetDto getPredmet (Long predmetId);
	/**
	 * Metoda koja cuva zadati PredmetDto i vraca ga
	 * 
	 * @param predmetDto Objekat klase PredmetDto koji treba da bude sacuvan
	 * @return Vraca savucan objekat klase PredmetDto
	 */
	PredmetDto savePredmet(PredmetDto predmetDto);
	/**
	 * 
	 * @return Vraca listu svih objekata klase PredmetDto koji su sacuvani
	 */
	List<PredmetDto> getAllPredmets();
	
}
