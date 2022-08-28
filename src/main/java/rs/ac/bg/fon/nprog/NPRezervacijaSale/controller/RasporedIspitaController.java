package rs.ac.bg.fon.nprog.NPRezervacijaSale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.RasporedIspitaDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.service.impl.RasporedIspitaServiceImpl;

/**
 * Klasa koja se odnosi na prihvatanje zahteva vezanih za domensku klasu RasporedIspita
 * 
 * @author Milica Bacic
 *
 */
@RestController
@RequestMapping("/api/raspored")
public class RasporedIspitaController {
	
	/**
	 * Instanca klase RasporedIspitaServiceImpl koja sluzi za pozivanje crud operacija nad domenskom klasom RasporedIspita
	 */
	@Autowired
	RasporedIspitaServiceImpl rasporedIspitaServiceImpl;
	
	/**
	 * 
	 * @return Vraca listu objekata klase RasporedIspitaDto koja predstavlja sve sacuvane rasporede ispita
	 */
	@GetMapping("all")
	List<RasporedIspitaDto> getAllRasporeds(){
		return this.rasporedIspitaServiceImpl.getAllRasporeds();
	}
	
	/**
	 * Metoda koja vraca raspored ispita sa zadatim id-jem
	 * 
	 * @param id Id rasporeda ispita koji treba da bude vracen
	 * @return Vraca objekat klase RasporedIspitaDto koji ima zadati id
	 */
	@GetMapping("get/{id}")
	RasporedIspitaDto getRaspored(@PathVariable("id") String id) {
		return this.rasporedIspitaServiceImpl.getRaspored(Long.valueOf(id));
	}
	
	/**
	 * Post metoda koja sluzi za cuvanje objekta klase RasporedIspitaDto
	 * 
	 * @param rasporedIspitaDto Raspored ispita koji treba da bude sacuvan
	 * @return Vraca objekat klase rasporedIspitaDto koji predstavlja sacuvani raspored ispita
	 */
	@PostMapping("add")
	RasporedIspitaDto saveRaspored(@RequestBody RasporedIspitaDto rasporedIspitaDto){
		return this.rasporedIspitaServiceImpl.saveRaspored(rasporedIspitaDto);
	}

}
