package rs.ac.bg.fon.nprog.NPRezervacijaSale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.AsistentDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.service.impl.AsistentServiceImpl;
/**
 * Klasa koja se odnosi na prihvatanje zahteva vezanih za domensku klasu Asistent
 * 
 * @author Milica Bacic
 *
 */
@RestController
@RequestMapping("/api/asistent")
public class AsistentController {

	/**
	 * Instanca klase AsistentServiceImpl koja sluzi za pozivanje crud operacija nad domenskom klasom Asistent
	 */
	@Autowired
	private AsistentServiceImpl asistentServiceImpl;
	
	/**
	 * 
	 * @return Vraca listu objekata klase AsistentDto koja predstavlja sve sacuvane asistente
	 */
	@GetMapping("all")
	List<AsistentDto> getAllAsistents(){
		return this.asistentServiceImpl.getAllAsistents();
	}
	
	/**
	 * Metoda koja vraca asistenta sa zadatim id-jem
	 * 
	 * @param id Id asistenta koji treba da bude vracen
	 * @return Vraca objekat klase AsistentDto koji ima zadati id
	 */
	@GetMapping("get/{id}")
	AsistentDto getAsistent(@PathVariable("id") String id) {
		return this.asistentServiceImpl.getAsistent(Long.valueOf(id));
	}
	/**
	 * Post metoda koja sluzi za cuvanje objekat klase AsistentDto
	 * 
	 * @param asistentDto Asistent koji treba da bude sacuvan
	 * @return Vraca objekat klase AsistentDto koji predstavlja sacuvanog asistenta
	 */
	@PostMapping("add")
	AsistentDto saveAsistent(@RequestBody AsistentDto asistentDto){
		return this.asistentServiceImpl.saveAsistent(asistentDto);
	}
}
