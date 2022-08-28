package rs.ac.bg.fon.nprog.NPRezervacijaSale.converter;

import org.springframework.stereotype.Component;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.Asistent;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.AsistentDto;
/**
 * Klasa koja sluzi da omoguci konverzije izmedju objekata klasa Asistent i AsistentDto
 * 
 * Klasa sadrzi metodu koja dto objekat prevodi u domenski objekat, kao i metodu za prevodjenje domenskog objekta u dto objekat.
 * 
 * @author Milica Bacic
 *
 */
@Component
public class AsistentConverter implements Converter<AsistentDto, Asistent>{
	/**
	 * Metoda koja objekat domenske klase Asistent prevodi u dto objekat klase AsistentDto.
	 */
	@Override
	public AsistentDto toDto(Asistent e) {
		return new AsistentDto(e.getId(), e.getIme(), e.getPrezime());
	}
	/**
	 * Metoda koja objekat dto klase AsistentDto prevodi u domenski objekat klase Asistent.
	 */
	@Override
	public Asistent toEntity(AsistentDto d) {
		
		Asistent asistent = new Asistent();
		asistent.setId(d.getId());
		asistent.setIme(d.getIme());
		asistent.setPrezime(d.getPrezime());
		
		return asistent;
	}


}
