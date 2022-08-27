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

@RestController
@RequestMapping("/api/predmet")
public class PredmetController {

	@Autowired
	private PredmetServiceImpl predmetServiceImpl;
	
	@GetMapping("all")
	List<PredmetDto> getAllPredmets(){
		return this.predmetServiceImpl.getAllPredmets();
	}
	
	@GetMapping("get/{id}")
	PredmetDto getPredmet(@PathVariable("id") String id) {
		return this.predmetServiceImpl.getPredmet(Long.valueOf(id));
	}
	
	@PostMapping("add")
	PredmetDto savePredmet(@RequestBody PredmetDto predmetDto){
		return this.predmetServiceImpl.savePredmet(predmetDto);
	}
	
}
