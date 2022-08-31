package rs.ac.bg.fon.nprog.NPRezervacijaSale.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.converter.RasporedIspitaConverter;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.RasporedIspita;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.RasporedIspitaDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.repository.RasporedIspitaRepository;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.repository.RezervacijaSaleRepository;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.service.RasporedIspitaService;
/**
 * Implementacija interfejsa RasporedIspitaService koja sadrzi logiku za rad sa domenskom klasom Sala (CRUD operacije).
 * 
 * @author Milica Bacic
 *
 */
@Service
public class RasporedIspitaServiceImpl implements RasporedIspitaService {
	/**
	 * Interfejs koji se odnosi na repozitorijum i sluzi za rad sa bazom podataka.
	 */
	private final RasporedIspitaRepository rasporedRepository;
	private final RezervacijaSaleRepository rezervacijaRepository;
	/**
	 * Konstruktor koji inicijalizuje objekat klase RasporedIspitaServiceImpl i postavlja vrednosti atributa na zadate vrednosti.
	 * 
	 * @param rasporedRepository Repozitorijum koji se odnosi na domenski objekat RasporedIspita
	 */
	public RasporedIspitaServiceImpl(RasporedIspitaRepository rasporedRepository,
			RezervacijaSaleRepository rezervacijaRepository) {
		super();
		this.rasporedRepository = rasporedRepository;
		this.rezervacijaRepository = rezervacijaRepository;
		rasporedConverter = new RasporedIspitaConverter();
	}
	/**
	 * Instanca klase RasporedIspitaConverter koja sluzi za konverziju izmedju RasporedIspita i RasporedIspitaDto klasa
	 */
	@Autowired
	RasporedIspitaConverter rasporedConverter;
	
	/**
	 * Metoda koja za zadati id vraca objekat klase RasporedIspitaDto koji ima dati id.
	 * 
	 * @param rasporedId Id rasporeda koji treba da bude vracen
	 * @return Vraca objekat klase RasporedIspitaDto sa zadatim id-jem.
	 */
	@Override
	public RasporedIspitaDto getRaspored(Long rasporedId) {
		try {
			Optional<RasporedIspita> raspored = this.rasporedRepository.findById(rasporedId);
			if (raspored.get() == null) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Raspored ispita sa datim id-jem ne postoji!");
			}
			return this.rasporedConverter.toDto(raspored.get());
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 * Metoda koja cuva datu instancu klase RasporedIspitaDto
	 * 
	 * @param rasporedDto Raspored koji treba da bude sacuvan
	 * @return Vraca objekat klase RasporedIspitaDto koji predstavlja sacuvan raspored
	 * 
	 * @throws java.lang.ResponseStatusException ukoliko dodje do greske prilikom cuvanja rasporeda
	 */
	@Override
	public RasporedIspitaDto saveRaspored(RasporedIspitaDto rasporedDto) {
		try {
			System.out.println(rasporedDto.toString());
			RasporedIspita raspored = this.rasporedConverter.toEntity(rasporedDto);
			RasporedIspita savedRaspored = this.rasporedRepository.save(raspored);
			if (savedRaspored == null) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Problem da se sacuva raspored ispita");
			}
			return this.rasporedConverter.toDto(savedRaspored);
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		}
	}
	/**
	 * Metoda koja vraca sve sacuvane rasporede ispita
	 * 
	 * @return Vraca listu objekata klase RasporedIspitaDto koja predstavlja sve sacuvane rasporede ispita
	 */
	@Override
	public List<RasporedIspitaDto> getAllRasporeds() {
		try {
			List<RasporedIspita> rasporedi = this.rasporedRepository.findAll();
			List<RasporedIspitaDto> rasporediDtos = new LinkedList<>();
			rasporedi.forEach((raspored) -> {
				RasporedIspitaDto convertedRaspored = this.rasporedConverter.toDto(raspored);
				rasporediDtos.add(convertedRaspored);
			});
			return rasporediDtos;
		} catch (Exception e) {
			throw e;
		}
	}

}
