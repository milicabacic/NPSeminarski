package rs.ac.bg.fon.nprog.NPRezervacijaSale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.PredmetDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.service.impl.PredmetServiceImpl;
/**
 * Klasa koja se odnosi na prihvatanje zahteva vezanih za domensku klasu Predmet
 * 
 * @author Milica Bacic
 *
 */
@RestController
@RequestMapping("/api/predmet")
public class PredmetController {

	/**
	 * Instanca klase PredmetServiceImpl koja sluzi za pozivanje crud operacija nad domenskom klasom Predmet
	 */
	@Autowired
	private PredmetServiceImpl predmetServiceImpl;
	
	/**
	 * 
	 * @return Vraca listu objekata klase PredmetDto koja predstavlja sve sacuvane predmete
	 */
	@GetMapping("all")
	List<PredmetDto> getAllPredmets(){
		return this.predmetServiceImpl.getAllPredmets();
	}
	
	/**
	 * Metoda koja vraca predmet sa zadatim id-jem
	 * 
	 * @param id Id predmeta koji treba da bude vracen
	 * @return Vraca objekat klase PredmetDto koji ima zadati id
	 */
	@GetMapping("get/{id}")
	PredmetDto getPredmet(@PathVariable("id") String id) {
		return this.predmetServiceImpl.getPredmet(Long.valueOf(id));
	}
	
	/**
	 * Post metoda koja sluzi za cuvanje objekta klase PredmetDto
	 * 
	 * @param predmetDto Predmet koji treba da bude sacuvan
	 * @return Vraca objekat klase predmetDto koji predstavlja sacuvani predmet
	 */
	@PostMapping("add")
	PredmetDto savePredmet(@RequestBody PredmetDto predmetDto){
		return this.predmetServiceImpl.savePredmet(predmetDto);
	}
	
}
