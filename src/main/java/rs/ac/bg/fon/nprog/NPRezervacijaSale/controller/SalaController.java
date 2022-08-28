package rs.ac.bg.fon.nprog.NPRezervacijaSale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.SalaDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.service.impl.SalaServiceImpl;
/**
 * Klasa koja se odnosi na prihvatanje zahteva vezanih za domensku klasu Sala
 * 
 * @author Milica Bacic
 *
 */
@RestController
@RequestMapping("/api/sala")
public class SalaController {

	/**
	 * Instanca klase SalaServiceImpl koja sluzi za pozivanje crud operacija nad domenskom klasom Sala
	 */
	@Autowired
	SalaServiceImpl salaServiceImpl;
	
	/**
	 * 
	 * @return Vraca listu objekata klase SalaDto koja predstavlja sve sacuvane sale
	 */
	@GetMapping("all")
	List<SalaDto> getAllSalas(){
		return this.salaServiceImpl.getAllSalas();
	}
	
	/**
	 * Metoda koja vraca salu sa zadatim id-jem
	 * 
	 * @param id Id sale koja treba da bude vracena
	 * @return Vraca objekat klase SalaDto koji ima zadati id
	 */
	@GetMapping("get/{id}")
	SalaDto getSala(@PathVariable("id") String id) {
		return this.salaServiceImpl.getSala(Long.valueOf(id));
	}
	
	/**
	 * Post metoda koja sluzi za cuvanje objekta klase SalaDto
	 * 
	 * @param salaDto Sala koja treba da bude sacuvana
	 * @return Vraca objekat klase SalaDto koji predstavlja sacuvanu salu
	 */
	@PostMapping("add")
	SalaDto saveSala(@RequestBody SalaDto salaDto){
		return this.salaServiceImpl.saveSala(salaDto);
	}
	
	
}
