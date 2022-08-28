package rs.ac.bg.fon.nprog.NPRezervacijaSale.service;

import java.util.List;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.SalaDto;
/**
 * Interfejs koji specificira CRUD metode nad klasom SalaDto
 * 
 * @author Milica Bacic
 *
 */
public interface SalaService {
	/**
	 * Metoda koja vraca objekat klase SalaDto sa zadatim id-jem
	 * 
	 * @param salaId Id sale koja treba da bude vracena
	 * @return Vraca salu kao objekat klase SalaDto koji ima dati id
	 */
	SalaDto getSala(Long salaId);
	/**
	 * Metoda koja cuva zadati SalaDto objekat i vraca ga
	 * 
	 * @param salaDto Objekat klase SalaDto koja treba da bude sacuvana
	 * @return Vraca savucan objekat klase SalaDto
	 */
	SalaDto saveSala(SalaDto salaDto);
	/**
	 * 
	 * @return Vraca listu svih objekata klase SalaDto koji su sacuvani
	 */
	List<SalaDto> getAllSalas();
}
