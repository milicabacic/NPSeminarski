package rs.ac.bg.fon.nprog.NPRezervacijaSale.converter;

import org.springframework.stereotype.Component;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.Profesor;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.ProfesorDto;

@Component
public class ProfesorConverter implements Converter<ProfesorDto, Profesor>{

	@Override
	public ProfesorDto toDto(Profesor e) {
		return new ProfesorDto(e.getId(), e.getIme(), e.getPrezime());
	}

	@Override
	public Profesor toEntity(ProfesorDto d) {
		Profesor profesor = new Profesor();
		
		profesor.setId(d.getId());
		profesor.setIme(d.getIme());
		profesor.setPrezime(d.getPrezime());
		
		return profesor;
	}

}
