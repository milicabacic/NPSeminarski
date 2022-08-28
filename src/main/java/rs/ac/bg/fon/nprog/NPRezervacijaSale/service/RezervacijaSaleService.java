package rs.ac.bg.fon.nprog.NPRezervacijaSale.service;

import java.util.List;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.RezervacijaSaleDto;
/**
 * Interfejs koji specificira CRUD metode nad klasom RezervacijaSaleDto
 * 
 * @author Milica Bacic
 *
 */
public interface RezervacijaSaleService {
	/**
	 * Metoda koja vraca objekat klase RezervacijaSaleDto sa zadatim id-jem
	 * 
	 * @param rezervacijaSaleId Id rezervacije koja treba da bude vracena
	 * @return Vraca rezervaciju sale kao objekat klase RezervacijaSaleDto koji ima dati id
	 */
	RezervacijaSaleDto getRezervacijaSale(Long rezervacijaSaleId);
	/**
	 * Metoda koja cuva zadatu RezervacijaSaleDto i vraca je
	 * 
	 * @param rezervacijaDto Objekat klase RezervacijaSaleDto koji treba da bude sacuvan
	 * @return Vraca savucan objekat klase RezervacijaSaleDto
	 */
	RezervacijaSaleDto saveRezervacijaSale(RezervacijaSaleDto rezervacijaDto);
	/**
	 * 
	 * @return Vraca listu svih objekata klase RezervacijaSaleDto koji su sacuvani
	 */
	List<RezervacijaSaleDto> getAllRezervacijaSales();
	/**
	 * Brise rezervaciju sale koja ima zadati id.
	 * 
	 * @param rezervacijaSaleId Id rezervacije sale koja treba da bude obrisana
	 * @return true ako je brisanje bilo uspesno
	 * @return false ukoliko je brisanje neuspesno
	 */
	boolean deleteRezervacijaSale(Long rezervacijaSaleId);
	/**
	 * Azurira postoji objekat klase RezervacijaSaleDto koji je sacuvan
	 * 
	 * @param rezervacijaDto Novi objekat klase RezervacijaSaleDto kojim treba da se azurira stari
	 * @return Vraca novi objekat klase RezervacijaSaleDto koji je sacuvan nakon azuriranja
	 */
	RezervacijaSaleDto updateRezervacijaSale(RezervacijaSaleDto rezervacijaDto);
}
