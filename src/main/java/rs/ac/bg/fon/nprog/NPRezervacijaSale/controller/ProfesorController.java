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

@RestController
@RequestMapping("/api/profesor")
public class ProfesorController {

	@Autowired
	private ProfesorServiceImpl profesorServiceImpl;
	
	@PostMapping("add")
	ProfesorDto saveProfesor(@RequestBody ProfesorDto profesorDto){
		return this.profesorServiceImpl.saveProfesor(profesorDto);
	}
	
	@GetMapping("all")
	List<ProfesorDto> getAllProfesors(){
		return this.profesorServiceImpl.getAllProfesors();
	}
	
	@GetMapping("get/{id}")
	ProfesorDto getProfesor(@PathVariable("id") String id) {
		return this.profesorServiceImpl.getProfesor(Long.valueOf(id));
	}
	
	
	
}
