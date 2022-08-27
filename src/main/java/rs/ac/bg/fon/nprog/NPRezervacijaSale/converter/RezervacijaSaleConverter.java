package rs.ac.bg.fon.nprog.NPRezervacijaSale.converter;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.Asistent;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.Predmet;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.Profesor;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.RasporedIspita;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.RezervacijaSale;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.Sala;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.AsistentDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.PredmetDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.ProfesorDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.RasporedIspitaDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.RezervacijaSaleDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.SalaDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.service.AsistentService;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.service.PredmetService;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.service.ProfesorService;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.service.RasporedIspitaService;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.service.SalaService;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.service.impl.SalaServiceImpl;

@Component
public class RezervacijaSaleConverter implements Converter<RezervacijaSaleDto, RezervacijaSale>{
	
	
	@Override
	public RezervacijaSaleDto toDto(RezervacijaSale e) {	
		return new RezervacijaSaleDto(e.getId(), e.getRok(), e.getDatumVremeOd(), e.getDatumVremeDo(), e.getBrojStudenata(), e.getTipIspita(), e.getSala().getId(), e.getAsistent().getId(), e.getProfesor().getId(), e.getPredmet().getId(), e.getRaspored().getId());
	}
	
	@Autowired
	SalaService salaService;
	
	@Autowired
	SalaConverter salaConverter;
	
	@Autowired
	AsistentService asistentService;
	
	@Autowired
	AsistentConverter asistentConverter;
	
	@Autowired
	ProfesorService profesorService;
	
	@Autowired
	ProfesorConverter profesorConverter;
	
	@Autowired
	PredmetService predmetService;
	
	@Autowired
	PredmetConverter predmetConverter;
	
	@Autowired
	RasporedIspitaService rasporedIspitaService;
	
	@Autowired
	RasporedIspitaConverter rasporedIspitaConverter;
	
	@Override
	public RezervacijaSale toEntity(RezervacijaSaleDto d) {
		RezervacijaSale rezervacijaSale = new RezervacijaSale();
		SalaDto s = this.salaService.getSala(d.getSalaId());
		Sala sala = this.salaConverter.toEntity(s);
		rezervacijaSale.setSala(sala);
		
		ProfesorDto p = this.profesorService.getProfesor(d.getProfesorId());
		Profesor profesor = this.profesorConverter.toEntity(p);
		rezervacijaSale.setProfesor(profesor);
		
		AsistentDto a = this.asistentService.getAsistent(d.getAsistentId());
		Asistent asistent = this.asistentConverter.toEntity(a);
		rezervacijaSale.setAsistent(asistent);
		
		PredmetDto pr = this.predmetService.getPredmet(d.getPredmetId());
		Predmet predmet = this.predmetConverter.toEntity(pr);
		rezervacijaSale.setPredmet(predmet);
		
		RasporedIspitaDto ri = this.rasporedIspitaService.getRaspored(d.getRasporedId());
		RasporedIspita raspored = this.rasporedIspitaConverter.toEntity(ri);
		rezervacijaSale.setRaspored(raspored);
		rezervacijaSale.setId(d.getId());
		rezervacijaSale.setBrojStudenata(d.getBrojStudenata());
		rezervacijaSale.setRok(d.getRok());
		rezervacijaSale.setDatumVremeOd(new Date(d.getDatumVremeOd().getTime()));
		rezervacijaSale.setDatumVremeDo(new Date(d.getDatumVremeDo().getTime()));
		rezervacijaSale.setTipIspita(d.getTipIspita());
		return rezervacijaSale;
	}

}
