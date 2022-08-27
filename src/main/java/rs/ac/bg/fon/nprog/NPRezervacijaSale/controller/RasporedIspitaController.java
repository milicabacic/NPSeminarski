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

@RestController
@RequestMapping("/api/raspored")
public class RasporedIspitaController {
	
	@Autowired
	RasporedIspitaServiceImpl rasporedIspitaServiceImpl;
	
	@GetMapping("all")
	List<RasporedIspitaDto> getAllRasporeds(){
		return this.rasporedIspitaServiceImpl.getAllRasporeds();
	}
	
	@GetMapping("get/{id}")
	RasporedIspitaDto getRaspored(@PathVariable("id") String id) {
		return this.rasporedIspitaServiceImpl.getRaspored(Long.valueOf(id));
	}
	
	@PostMapping("add")
	RasporedIspitaDto saveRaspored(@RequestBody RasporedIspitaDto rasporedIspitaDto){
		return this.rasporedIspitaServiceImpl.saveRaspored(rasporedIspitaDto);
	}

}
