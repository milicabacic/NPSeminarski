package rs.ac.bg.fon.nprog.NPRezervacijaSale.converter;

import org.springframework.stereotype.Component;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.Predmet;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.PredmetDto;

@Component
public class PredmetConverter implements Converter<PredmetDto, Predmet>{

	@Override
	public PredmetDto toDto(Predmet e) {

		return new PredmetDto(e.getId(), e.getNaziv(), e.getEspb());
	}

	@Override
	public Predmet toEntity(PredmetDto d) {
		
		Predmet predmet = new Predmet();
		predmet.setId(d.getId());
		predmet.setNaziv(d.getNaziv());
		predmet.setEspb(d.getEspb());
	
		
		return predmet;
	}

}
