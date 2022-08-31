package rs.ac.bg.fon.nprog.NPRezervacijaSale.converter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.RasporedIspita;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.RezervacijaSale;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.RasporedIspitaDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.RezervacijaSaleDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.repository.RezervacijaSaleRepository;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.service.RezervacijaSaleService;
/**
 * Klasa koja sluzi da omoguci konverzije izmedju objekata klasa RasporedIspita i RasporedIspitaDto
 * 
 * Klasa sadrzi metodu koja dto objekat prevodi u domenski objekat, kao i metodu za prevodjenje domenskog objekta u dto objekat.
 * 
 * @author Milica Bacic
 *
 */
@Component
public class RasporedIspitaConverter implements Converter<RasporedIspitaDto, RasporedIspita>{
	/**
	 * Metoda koja objekat domenske klase RasporedIspita prevodi u dto objekat klase RasporedIspitaDto.
	 * 
	 * @param e Domenski objekat klase RasporedIspita
	 */
	@Override
	public RasporedIspitaDto toDto(RasporedIspita e) {
		
		return new RasporedIspitaDto(e.getId(), e.getRok());
	}
	/**
	 * Interfejs za rad sa repozitorijumom vezanim za domensku klasu RezervacijaSale
	 */
	@Autowired
	RezervacijaSaleRepository rezervacijaRepository;

	
	/**
	 * Konstruktor koji inicijalizuje instancu klase RasporedIspitaConverter.
	 * 
	 */
	@Autowired
	public RasporedIspitaConverter() {
		super();
	}
	

	/**
	 * Metoda koja objekat dto klase RasporedIspitaDto prevodi u domenski objekat klase RasporedIspita.
	 * 
	 * @param d Dto objekat klase RasporedIspitaDto
	 */

	@Override
	public RasporedIspita toEntity(RasporedIspitaDto d) {
		
		RasporedIspita raspored = new RasporedIspita();
		raspored.setId(d.getId());
		raspored.setRok(d.getRok());

		
		return raspored;
	}


}
