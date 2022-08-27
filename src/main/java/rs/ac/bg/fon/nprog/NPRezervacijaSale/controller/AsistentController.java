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

@RestController
@RequestMapping("/api/asistent")
public class AsistentController {

	@Autowired
	private AsistentServiceImpl asistentServiceImpl;
	
	
	@GetMapping("all")
	List<AsistentDto> getAllAsistents(){
		return this.asistentServiceImpl.getAllAsistents();
	}
	
	@GetMapping("get/{id}")
	AsistentDto getAsistent(@PathVariable("id") String id) {
		return this.asistentServiceImpl.getAsistent(Long.valueOf(id));
	}
	
	@PostMapping("add")
	AsistentDto saveAsistent(@RequestBody AsistentDto asistentDto){
		return this.asistentServiceImpl.saveAsistent(asistentDto);
	}
}
