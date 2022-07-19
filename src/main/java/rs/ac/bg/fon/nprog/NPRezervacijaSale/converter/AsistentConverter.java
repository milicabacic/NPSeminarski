package rs.ac.bg.fon.nprog.NPRezervacijaSale.converter;

import org.springframework.stereotype.Component;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.Asistent;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.AsistentDto;

@Component
public class AsistentConverter implements Converter<AsistentDto, Asistent>{

	@Override
	public AsistentDto toDto(Asistent e) {
		return new AsistentDto(e.getId(), e.getIme(), e.getPrezime());
	}

	@Override
	public Asistent toEntity(AsistentDto d) {
		
		Asistent asistent = new Asistent();
		asistent.setId(d.getId());
		asistent.setIme(d.getIme());
		asistent.setPrezime(d.getPrezime());
		
		return asistent;
	}


}
