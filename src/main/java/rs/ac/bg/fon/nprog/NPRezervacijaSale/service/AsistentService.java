package rs.ac.bg.fon.nprog.NPRezervacijaSale.service;

import java.util.List;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.AsistentDto;
/**
 * Interfejs koji specificira CRUD metode nad klasom AsistentDto
 * 
 * @author Milica Bacic
 *
 */
public interface AsistentService {
	/**
	 * Metoda koja vraca objekat klase AsistentDto sa zadatim id-jem
	 * 
	 * @param asistentId Id asistenta koji treba da bude vracen
	 * @return Vraca asistenta kao objekat klase AsistentDto koji ima dati id
	 */
	AsistentDto getAsistent(Long asistentId);
	/**
	 * Cuva asistenta na osnovu zadatog objekta klase AsistentDto
	 * 
	 * @param asistentDto Asistent koji treba da bude sacuvan
	 * @return Vraca dto objekat koji je sacuvan
	 */
	AsistentDto saveAsistent(AsistentDto asistentDto);
	/**
	 * 
	 * @return Vraca listu svih dto objekata koji su sacuvani
	 */
	List<AsistentDto> getAllAsistents();
	
}
