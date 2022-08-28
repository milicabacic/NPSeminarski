package rs.ac.bg.fon.nprog.NPRezervacijaSale.service;

import java.util.List;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.ProfesorDto;
/**
 * Interfejs koji specificira CRUD metode nad klasom ProfesorDto
 * 
 * @author Milica Bacic
 *
 */
public interface ProfesorService {
	/**
	 * Metoda koja vraca objekat klase ProfesorDto sa zadatim id-jem
	 * 
	 * @param profesorId Id profesora koji treba da bude vracen
	 * @return Vraca profesora kao objekat klase ProfesorDto koji ima dati id
	 */
	ProfesorDto getProfesor(Long profesorId);
	/**
	 * Metoda koja cuva zadati ProfesorDto i vraca ga
	 * 
	 * @param profesorDto Objekat klase ProfesorDto koji treba da bude sacuvan
	 * @return Vraca savucan objekat klase ProfesorDto
	 */
	ProfesorDto saveProfesor(ProfesorDto profesorDto);
	/**
	 * 
	 * @return Vraca listu svih objekata klase ProfesorDto koji su sacuvani
	 */
	List<ProfesorDto> getAllProfesors();
	
}
