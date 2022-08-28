package rs.ac.bg.fon.nprog.NPRezervacijaSale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.ProfesorDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.service.impl.ProfesorServiceImpl;
/**
 * Klasa koja se odnosi na prihvatanje zahteva vezanih za domensku klasu Profesor
 * 
 * @author Milica Bacic
 *
 */
@RestController
@RequestMapping("/api/profesor")
public class ProfesorController {

	/**
	 * Instanca klase ProfesorServiceImpl koja sluzi za pozivanje crud operacija nad domenskom klasom Profesor
	 */
	@Autowired
	private ProfesorServiceImpl profesorServiceImpl;
	
	/**
	 * Post metoda koja sluzi za cuvanje objekta klase ProfesorDto
	 * 
	 * @param profesorDto Profesor koji treba da bude sacuvan
	 * @return Vraca objekat klase profesorDto koji predstavlja sacuvanog profesora
	 */
	@PostMapping("add")
	ProfesorDto saveProfesor(@RequestBody ProfesorDto profesorDto){
		return this.profesorServiceImpl.saveProfesor(profesorDto);
	}
	
	/**
	 * 
	 * @return Vraca listu objekata klase ProfesorDto koja predstavlja sve sacuvane profesore
	 */
	@GetMapping("all")
	List<ProfesorDto> getAllProfesors(){
		return this.profesorServiceImpl.getAllProfesors();
	}
	
	/**
	 * Metoda koja vraca profesora sa zadatim id-jem
	 * 
	 * @param id Id profesora koji treba da bude vracen
	 * @return Vraca objekat klase ProfesorDto koji ima zadati id
	 */
	@GetMapping("get/{id}")
	ProfesorDto getProfesor(@PathVariable("id") String id) {
		return this.profesorServiceImpl.getProfesor(Long.valueOf(id));
	}
	
	
	
}
