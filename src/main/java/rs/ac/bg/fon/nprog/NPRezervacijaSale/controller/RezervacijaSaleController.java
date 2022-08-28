package rs.ac.bg.fon.nprog.NPRezervacijaSale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.RezervacijaSaleDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.service.impl.RezervacijaSaleServiceImpl;

/**
 * Klasa koja se odnosi na prihvatanje zahteva vezanih za domensku klasu RezervacijaSale
 * 
 * @author Milica Bacic
 *
 */
@RestController
@RequestMapping("/api/rezervacija")
public class RezervacijaSaleController {
	
	/**
	 * Instanca klase RezervacijaSaleServiceImpl koja sluzi za pozivanje crud operacija nad domenskom klasom RezervacijaSale
	 */
	@Autowired
	RezervacijaSaleServiceImpl rezervacijaSaleServiceImpl;
	
	/**
	 * 
	 * @return Vraca listu objekata klase RezervacijaSaleDto koja predstavlja sve sacuvane rezervacije sala
	 */
	@GetMapping("all")
	List<RezervacijaSaleDto> getAllRezervacijas(){
		return this.rezervacijaSaleServiceImpl.getAllRezervacijaSales();
	}
	
	/**
	 * Metoda koja vraca rezervaciju sale sa zadatim id-jem
	 * 
	 * @param id Id rezervacije sale koja treba da bude vracena
	 * @return Vraca objekat klase RezervacijaSaleDto koji ima zadati id
	 */
	@GetMapping("get/{id}")
	RezervacijaSaleDto getRezervacija(@PathVariable("id") String id) {
		return this.rezervacijaSaleServiceImpl.getRezervacijaSale(Long.valueOf(id));
	}
	
	/**
	 * Post metoda koja sluzi za cuvanje objekta klase RezervacijaSaleDto
	 * 
	 * @param rezervacijaSaleDto Rezervacija sale koja treba da bude sacuvana
	 * @return Vraca objekat klase RezervacijaSaleDto koji predstavlja sacuvanu rezervaciju sale
	 */
	@PostMapping("add")
	RezervacijaSaleDto saveRezervacija(@RequestBody RezervacijaSaleDto rezervacijaSaleDto){
		return this.rezervacijaSaleServiceImpl.saveRezervacijaSale(rezervacijaSaleDto);
		
	} 
	
	/**
	 * Patch metoda koja sluzi za azuriranje postojeceg objekta klase RezervacijaSaleDto
	 * 
	 * @param rezervacijaSaleDto Rezervacija sale kojom postojeca treba da bude azurirana
	 * @return Vraca objekat klase RezervacijaSaleDto koji predstavlja novi objekat nakon azuriranja
	 */
	@PatchMapping("update")
	RezervacijaSaleDto updateRezervacija(@RequestBody RezervacijaSaleDto rezervacijaSaleDto) {
		System.out.println(rezervacijaSaleDto);
		return this.rezervacijaSaleServiceImpl.updateRezervacijaSale(rezervacijaSaleDto);
	}
	
	/**
	 * Delete metoda koja brise objekat klase RezervacijaSaleDto sa zadatim id-jem
	 * 
	 * @param id Id rezervacije sale koja treba da bude obrisana
	 * @return true ukoliko je brisanje uspesno
	 * @return false ukoliko je brisanje neuspesno
	 */
	@DeleteMapping("delete/{id}")
	boolean deleteGroup(@PathVariable("id") String id) {
		return this.rezervacijaSaleServiceImpl.deleteRezervacijaSale(Long.valueOf(id));
	}

}
