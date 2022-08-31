package rs.ac.bg.fon.nprog.NPRezervacijaSale.converter;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.Sala;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.SalaDto;
/**
 * Klasa koja sluzi da omoguci konverzije izmedju objekata klasa Sala i SalaDto
 * 
 * Klasa sadrzi metodu koja dto objekat prevodi u domenski objekat, kao i metodu za prevodjenje domenskog objekta u dto objekat.
 * 
 * @author Milica Bacic
 *
 */
@Component
public class SalaConverter implements Converter<SalaDto, Sala>{
	
	/**
	 * Metoda koja objekat domenske klase Sala prevodi u dto objekat klase SalaDto.
	 * 
	 * @param e Domenski objekat klase Sala 
	 */
	@Override
	public SalaDto toDto(Sala e) {
		return new SalaDto(e.getId(), e.getNaziv(), e.getKapacitet(), e.getTipSale());
	}
	/**
	 * Metoda koja objekat dto klase SalaDto prevodi u domenski objekat klase Sala.
	 * 
	 * @param d Dto objekat klase SalaDto
	 */
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
