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

@RestController
@RequestMapping("/api/sala")
public class SalaController {

	@Autowired
	SalaServiceImpl salaServiceImpl;
	
	@GetMapping("all")
	List<SalaDto> getAllSalas(){
		return this.salaServiceImpl.getAllSalas();
	}
	
	@GetMapping("get/{id}")
	SalaDto getSala(@PathVariable("id") String id) {
		return this.salaServiceImpl.getSala(Long.valueOf(id));
	}
	
	@PostMapping("add")
	SalaDto saveSala(@RequestBody SalaDto salaDto){
		return this.salaServiceImpl.saveSala(salaDto);
	}
	
	
}
