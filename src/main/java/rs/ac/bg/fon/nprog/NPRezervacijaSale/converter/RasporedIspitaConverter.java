package rs.ac.bg.fon.nprog.NPRezervacijaSale.converter;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.RasporedIspita;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.RasporedIspitaDto;

public class RasporedIspitaConverter implements Converter<RasporedIspitaDto, RasporedIspita>{

	@Override
	public RasporedIspitaDto toDto(RasporedIspita e) {
		
		return new RasporedIspitaDto(e.getId(), e.getRok());
	}

	@Override
	public RasporedIspita toEntity(RasporedIspitaDto d) {
		RasporedIspita raspored = new RasporedIspita();
		raspored.setId(d.getId());
		raspored.setRok(d.getRok());
		return raspored;
	}

}
