package rs.ac.bg.fon.nprog.NPRezervacijaSale.service;

import java.util.List;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.RasporedIspitaDto;
/**
 * Interfejs koji specificira CRUD metode nad klasom RasporedIspitaDto
 * 
 * @author Milica Bacic
 *
 */
public interface RasporedIspitaService {
	/**
	 * Metoda koja vraca objekat klase RasporedIspitaDto sa zadatim id-jem
	 * 
	 * @param rasporedId Id rasporeda koji treba da bude vracen
	 * @return Vraca raspored kao objekat klase RasporedIspitaDto koji ima dati id
	 */
	RasporedIspitaDto getRaspored(Long rasporedId);
	/**
	 * Metoda koja cuva zadati RasporedIspitaDto i vraca ga
	 * 
	 * @param raspored Objekat klase RasporedIspitaDto koji treba da bude sacuvan
	 * @return Vraca savucan objekat klase RasporedIspitaDto
	 */
	RasporedIspitaDto saveRaspored(RasporedIspitaDto raspored);
	/**
	 * 
	 * @return Vraca listu svih objekata klase RasporedIspitaDto koji su sacuvani
	 */
	List<RasporedIspitaDto> getAllRasporeds();
	
}
