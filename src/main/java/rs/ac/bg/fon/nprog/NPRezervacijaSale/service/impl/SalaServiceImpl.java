package rs.ac.bg.fon.nprog.NPRezervacijaSale.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.converter.SalaConverter;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.Sala;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.SalaDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.repository.SalaRepository;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.service.SalaService;
/**
 * Implementacija interfejsa SalaService koja sadrzi logiku za rad sa domenskom klasom Sala (CRUD operacije).
 * 
 * @author Milica Bacic
 *
 */
@Service
public class SalaServiceImpl implements SalaService {
	/**
	 * Interfejs koji se odnosi na repozitorijum i sluzi za rad sa bazom podataka.
	 */
	@Autowired
	SalaRepository salaRepository;
	
	/**
	 * Konstruktor koji inicijalizuje objekat klase SalaServiceImpl i postavlja vrednosti atributa na zadate vrednosti.
	 * 
	 */
	public SalaServiceImpl() {
		super();
		salaConverter = new SalaConverter();
	}
	/**
	 * Instanca klase SalaConverter koja sluzi za konverziju izmedju Sala i SalaDto klasa
	 */
	@Autowired
	private SalaConverter salaConverter;
	/**
	 * Metoda koja za zadati id vraca objekat klase SalaDto koji ima dati id.
	 * 
	 * @param salaId Id sale koja treba da bude vracena
	 * @return Vraca objekat klase SalaDto sa zadatim id-jem.
	 */
	@Override
	public SalaDto getSala(Long salaId) {
		try {
			Optional<Sala> sala = this.salaRepository.findById(salaId);
			if (sala.get() == null) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sala sa datim id-jem ne postoji!");
			}
			return this.salaConverter.toDto(sala.get());
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * Metoda koja cuva datu instancu klase SalaDto
	 * 
	 * @param salaDto Sala koja treba da bude sacuvana
	 * @return Vraca objekat klase SalaDto koji predstavlja sacuvanu salu
	 * 
	 * @throws org.springframework.web.server.ResponseStatusException ukoliko dodje do greske prilikom cuvanja sale
	 */
	@Override
	public SalaDto saveSala(SalaDto salaDto) {
		try {
			Sala sala = this.salaConverter.toEntity(salaDto);
			Sala savedSala = this.salaRepository.save(sala);
			if (savedSala == null) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Problem da se sacuva sala");
			}
			return this.salaConverter.toDto(savedSala);
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		}
	}
	
	@Autowired
	SaveSaleToFile salaSave;

	/**
	 * Metoda koja vraca sve sacuvane sale
	 * 
	 * @return Vraca listu objekata klase SalaDto koja predstavlja sve sacuvane sale
	 */
	@Override
	public List<SalaDto> getAllSalas() {
		try {
			List<Sala> sale = this.salaRepository.findAll();
			List<SalaDto> salaDtos = new LinkedList<>();
			sale.forEach((sala) -> {
				SalaDto convertedSala = this.salaConverter.toDto(sala);
				salaDtos.add(convertedSala);
			});
			this.salaSave.saveSaleToFile(salaDtos);
			return salaDtos;
		} catch (Exception e) {
			throw e;
		}
	}

}
