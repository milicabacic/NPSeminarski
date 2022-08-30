package rs.ac.bg.fon.nprog.NPRezervacijaSale.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.converter.AsistentConverter;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.Asistent;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.AsistentDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.repository.AsistentRepository;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.service.AsistentService;
/**
 * Implementacija interfejsa AsistentService koja sadrzi logiku za rad sa domenskom klasom Asistent (CRUD operacije).
 * 
 * @author Milica Bacic
 *
 */
@Service
public class AsistentServiceImpl implements AsistentService {
	
	/**
	 * Interfejs koji se odnosi na repozitorijum i sluzi za rad sa bazom podataka.
	 */
	private final AsistentRepository asistentRepository;
	
	/**
	 * Konstruktor koji inicijalizuje objekat klase AsistentServiceImpl i postavlja vrednosti atributa na zadate vrednosti.
	 * 
	 * @param asistentRepository Repozitorijum koji se odnosi na domenski objekat Asistent
	 */
	@Autowired
	public AsistentServiceImpl(AsistentRepository asistentRepository) {
		super();
		this.asistentRepository = asistentRepository;
		asistentConverter = new AsistentConverter();
	}
	
	/**
	 * Instanca klase AsistentConverter koja sluzi za konverziju izmedju Asistent i AsistentDto klasa
	 */
	@Autowired
	AsistentConverter asistentConverter;
	
	
	/**
	 * Metoda koja za zadati id vraca objekat klase AsistentDto koji ima dati id.
	 * 
	 * @param asistentId Id asistenta koji treba da bude vracen
	 * @return Vraca objekat klase AsistentDto sa zadatim id-jem.
	 */
	@Override
	public AsistentDto getAsistent(Long asistentId) {
		try {
			Optional<Asistent> asistent = this.asistentRepository.findById(asistentId);
			if (asistent.get() == null) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Asistent sa datim id-jem ne postoji!");
			}
			return this.asistentConverter.toDto(asistent.get());
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 * Metoda koja cuva datu instancu klase AsistentDto
	 * 
	 * @param asistentDto Asistent koji treba da bude sacuvan
	 * @return Vraca objekat klase AsistentDto koji predstavlja sacuvanog asistenta
	 * 
	 * @throws java.lang.ResponseStatusException ukoliko dodje do greske prilikom cuvanja asistenta
	 */
	@Override
	public AsistentDto saveAsistent(AsistentDto asistentDto) {
		try {
			Asistent asistent = this.asistentConverter.toEntity(asistentDto);
			Asistent savedAsistent = this.asistentRepository.save(asistent);
			if (savedAsistent == null) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Problem da se sacuva asistent");
			}
			return this.asistentConverter.toDto(savedAsistent);
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		}
	}

	/**
	 * Metoda koja vraca sve sacuvane asistente
	 * 
	 * @return Vraca listu objekata klase AsistentDto koja predstavlja sve sacuvane asistente
	 */
	@Override
	public List<AsistentDto> getAllAsistents() {
		try {
			List<Asistent> asistents = this.asistentRepository.findAll();
			List<AsistentDto> asistentDtos = new LinkedList<>();
			asistents.forEach((asistent) -> {
				AsistentDto convertedAsistent = this.asistentConverter.toDto(asistent);
				asistentDtos.add(convertedAsistent);
			});
			return asistentDtos;
		} catch (Exception e) {
			throw e;
		}
	}

}
