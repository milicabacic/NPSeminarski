package rs.ac.bg.fon.nprog.NPRezervacijaSale.converter;



import java.util.Date;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.Asistent;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.Predmet;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.Profesor;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.RasporedIspita;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.RezervacijaSale;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.Sala;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.RezervacijaSaleDto;

public class RezervacijaSaleConverter implements Converter<RezervacijaSaleDto, RezervacijaSale>{

	@Override
	public RezervacijaSaleDto toDto(RezervacijaSale e) {	
		return new RezervacijaSaleDto(e.getId(), e.getRok(), e.getDatumVremeOd(), e.getDatumVremeDo(), e.getBrojStudenata(), e.getTipIspita(), e.getSala().getId(), e.getAsistent().getId(), e.getProfesor().getId(), e.getPredmet().getId(), e.getRaspored().getId());
	}

	@Override
	public RezervacijaSale toEntity(RezervacijaSaleDto d) {
		RezervacijaSale rezervacijaSale = new RezervacijaSale();
		rezervacijaSale.setId(d.getId());
		rezervacijaSale.setBrojStudenata(d.getBrojStudenata());
		rezervacijaSale.setRok(d.getRok());
		rezervacijaSale.setDatumVremeOd(new Date(d.getDatumVremeOd().getTime()));
		rezervacijaSale.setDatumVremeDo(new Date(d.getDatumVremeDo().getTime()));
		rezervacijaSale.setTipIspita(d.getTipIspita());
		Sala sala = new Sala();
		sala.setId(d.getSalaId());
		rezervacijaSale.setSala(sala);
		Profesor profesor = new Profesor();
		profesor.setId(d.getProfesorId());
		rezervacijaSale.setProfesor(profesor);
		Asistent asistent = new Asistent();
		asistent.setId(d.getAsistentId());
		rezervacijaSale.setAsistent(asistent);
		Predmet predmet = new Predmet();
		predmet.setId(d.getPredmetId());
		rezervacijaSale.setPredmet(predmet);
		RasporedIspita raspored = new RasporedIspita();
		raspored.setId(d.getRasporedId());
		rezervacijaSale.setRaspored(raspored);
		return rezervacijaSale;
	}

}
