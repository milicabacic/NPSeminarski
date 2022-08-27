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

@RestController
@RequestMapping("/api/rezervacija")
public class RezervacijaSaleController {
	
	@Autowired
	RezervacijaSaleServiceImpl rezervacijaSaleServiceImpl;
	
	
	@GetMapping("all")
	List<RezervacijaSaleDto> getAllRezervacijas(){
		return this.rezervacijaSaleServiceImpl.getAllRezervacijaSales();
	}
	
	@GetMapping("get/{id}")
	RezervacijaSaleDto getRezervacija(@PathVariable("id") String id) {
		return this.rezervacijaSaleServiceImpl.getRezervacijaSale(Long.valueOf(id));
	}
	
	@PostMapping("add")
	RezervacijaSaleDto saveRezervacija(@RequestBody RezervacijaSaleDto rezervacijaSaleDto){
		return this.rezervacijaSaleServiceImpl.saveRezervacijaSale(rezervacijaSaleDto);
		
	} 
	
	@PatchMapping("update")
	RezervacijaSaleDto updateRezervacija(@RequestBody RezervacijaSaleDto rezervacijaSaleDto) {
		System.out.println(rezervacijaSaleDto);
		return this.rezervacijaSaleServiceImpl.updateRezervacijaSale(rezervacijaSaleDto);
	}
	
	@DeleteMapping("delete/{id}")
	boolean deleteGroup(@PathVariable("id") String id) {
		return this.rezervacijaSaleServiceImpl.deleteRezervacijaSale(Long.valueOf(id));
	}

}
