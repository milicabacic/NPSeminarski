package rs.ac.bg.fon.nprog.NPRezervacijaSale.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.converter.PredmetConverter;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.Predmet;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.PredmetDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.repository.PredmetRepository;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.service.PredmetService;
/**
 * Implementacija interfejsa PredmetService koja sadrzi logiku za rad sa domenskom klasom Predmet (CRUD operacije).
 * 
 * @author Milica Bacic
 *
 */
@Service
public class PredmetServiceImpl implements PredmetService {
	/**
	 * Interfejs koji se odnosi na repozitorijum i sluzi za rad sa bazom podataka.
	 */
	private final PredmetRepository predmetRepository;
	
	/**
	 * Konstruktor koji inicijalizuje objekat klase PredmetServiceImpl i postavlja vrednosti atributa na zadate vrednosti.
	 * 
	 * @param predmetRepository Repozitorijum koji se odnosi na domenski objekat Predmet
	 */
	@Autowired
	public PredmetServiceImpl(PredmetRepository predmetRepository) {
		super();
		this.predmetRepository = predmetRepository;
	}
	/**
	 * Instanca klase PredmetConverter koja sluzi za konverziju izmedju Predmet i PredmetDto klasa
	 */
	@Autowired
	private PredmetConverter predmetConverter;

	/**
	 * Metoda koja za zadati id vraca objekat klase PredmetDto koji ima dati id.
	 * 
	 * @param predmetId Id predmeta koji treba da bude vracen
	 * @return Vraca objekat klase PredmetDto sa zadatim id-jem.
	 */
	@Override
	public PredmetDto getPredmet(Long predmetId) {
		try {
			Optional<Predmet> predmet = this.predmetRepository.findById(predmetId);
			if (predmet.get() == null) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Predmet sa datim id-jem ne postoji!");
			}
			return this.predmetConverter.toDto(predmet.get());
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 * Metoda koja cuva datu instancu klase PredmetDto
	 * 
	 * @param predmetDto Predmet koji treba da bude sacuvan
	 * @return Vraca objekat klase PredmetDto koji predstavlja sacuvani predmet
	 * 
	 * @throws java.lang.ResponseStatusException ukoliko dodje do greske prilikom cuvanja predmeta
	 */
	@Override
	public PredmetDto savePredmet(PredmetDto predmetDto) {
		try {
			Predmet predmet= this.predmetConverter.toEntity(predmetDto);
			Predmet savedPredmet = this.predmetRepository.save(predmet);
			if (savedPredmet == null) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Problem da se sacuva predmet");
			}
			return this.predmetConverter.toDto(savedPredmet);
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		}
	}
	/**
	 * Metoda koja vraca sve sacuvane predmete
	 * 
	 * @return Vraca listu objekata klase PredmetDto koja predstavlja sve sacuvane predmete
	 */
	@Override
	public List<PredmetDto> getAllPredmets() {
		try {
			List<Predmet> predmeti = this.predmetRepository.findAll();
			List<PredmetDto> predmetDtos = new LinkedList<>();
			predmeti.forEach((predmet) -> {
				PredmetDto convertedPredmet = this.predmetConverter.toDto(predmet);
				predmetDtos.add(convertedPredmet);
			});
			return predmetDtos;
		} catch (Exception e) {
			throw e;
		}
	}

}
