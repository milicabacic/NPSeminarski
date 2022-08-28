package rs.ac.bg.fon.nprog.NPRezervacijaSale.converter;

import org.springframework.stereotype.Component;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.Predmet;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.PredmetDto;
/**
 * Klasa koja sluzi da omoguci konverzije izmedju objekata klasa Predmet i PredmetDto
 * 
 * Klasa sadrzi metodu koja dto objekat prevodi u domenski objekat, kao i metodu za prevodjenje domenskog objekta u dto objekat.
 * 
 * @author Milica Bacic
 *
 */
@Component
public class PredmetConverter implements Converter<PredmetDto, Predmet>{
	/**
	 * Metoda koja objekat domenske klase Predmet prevodi u dto objekat klase PredmetDto.
	 * 
	 * @param e Domenski objekat klase Predmet
	 */
	@Override
	public PredmetDto toDto(Predmet e) {

		return new PredmetDto(e.getId(), e.getNaziv(), e.getEspb());
	}
	/**
	 * Metoda koja objekat dto klase PredmetDto prevodi u domenski objekat klase Predmet.
	 * 
	 * @param d Dto objekat klase PredmetDto
	 */
	@Override
	public Predmet toEntity(PredmetDto d) {
		
		Predmet predmet = new Predmet();
		predmet.setId(d.getId());
		predmet.setNaziv(d.getNaziv());
		predmet.setEspb(d.getEspb());
	
		
		return predmet;
	}

}
