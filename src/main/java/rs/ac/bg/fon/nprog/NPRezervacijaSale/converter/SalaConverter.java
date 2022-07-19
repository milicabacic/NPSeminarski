package rs.ac.bg.fon.nprog.NPRezervacijaSale.converter;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.Sala;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.SalaDto;

public class SalaConverter implements Converter<SalaDto, Sala>{

	@Override
	public SalaDto toDto(Sala e) {
		return new SalaDto(e.getId(), e.getNaziv(), e.getKapacitet(), e.getTipSale());
	}

	@Override
	public Sala toEntity(SalaDto d) {
		Sala sala = new Sala();
		
		sala.setId(d.getId());
		sala.setNaziv(d.getNaziv());
		sala.setKapacitet(d.getKapacitet());
		sala.setTipSale(d.getTipSale());
		
		
		return sala;
	}

}
