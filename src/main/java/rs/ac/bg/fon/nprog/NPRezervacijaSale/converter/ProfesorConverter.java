package rs.ac.bg.fon.nprog.NPRezervacijaSale.converter;

import org.springframework.stereotype.Component;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.Profesor;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.ProfesorDto;
/**
 * Klasa koja sluzi da omoguci konverzije izmedju objekata klasa Profesor i ProfesorDto
 * 
 * Klasa sadrzi metodu koja dto objekat prevodi u domenski objekat, kao i metodu za prevodjenje domenskog objekta u dto objekat.
 * 
 * @author Milica Bacic
 *
 */
@Component
public class ProfesorConverter implements Converter<ProfesorDto, Profesor>{
	/**
	 * Metoda koja objekat domenske klase Profesor prevodi u dto objekat klase ProfesorDto.
	 * 
	 * @param e Domenski objekat klase Profesor
	 */
	@Override
	public ProfesorDto toDto(Profesor e) {
		return new ProfesorDto(e.getId(), e.getIme(), e.getPrezime());
	}
	/**
	 * Metoda koja objekat dto klase ProfesorDto prevodi u domenski objekat klase Profesor.
	 * 
	 * @param d Dto objekat klase ProfesorDto
	 */
	@Override
	public Profesor toEntity(ProfesorDto d) {
		Profesor profesor = new Profesor();
		
		profesor.setId(d.getId());
		profesor.setIme(d.getIme());
		profesor.setPrezime(d.getPrezime());
		
		return profesor;
	}

}
