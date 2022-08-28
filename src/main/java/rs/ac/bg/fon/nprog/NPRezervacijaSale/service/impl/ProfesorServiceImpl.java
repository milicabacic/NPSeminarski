package rs.ac.bg.fon.nprog.NPRezervacijaSale.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.converter.ProfesorConverter;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.Profesor;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.ProfesorDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.repository.ProfesorRepository;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.service.ProfesorService;
/**
 * Implementacija interfejsa ProfesorService koja sadrzi logiku za rad sa domenskom klasom Profesor (CRUD operacije).
 * 
 * @author Milica Bacic
 *
 */
@Service
public class ProfesorServiceImpl implements ProfesorService {
	/**
	 * Interfejs koji se odnosi na repozitorijum i sluzi za rad sa bazom podataka.
	 */
	private final ProfesorRepository profesorRepository;
	/**
	 * Konstruktor koji inicijalizuje objekat klase ProfesorServiceImpl i postavlja vrednosti atributa na zadate vrednosti.
	 * 
	 * @param profesorRepository Repozitorijum koji se odnosi na domenski objekat Profesor
	 */
	@Autowired
	public ProfesorServiceImpl(ProfesorRepository profesorRepository) {
		super();
		this.profesorRepository = profesorRepository;
	}
	/**
	 * Instanca klase ProfesorConverter koja sluzi za konverziju izmedju Profesor i ProfesorDto klasa
	 */
	@Autowired
	ProfesorConverter profesorConverter;
	/**
	 * Metoda koja za zadati id vraca objekat klase ProfesorDto koji ima dati id.
	 * 
	 * @param profesorId Id profesora koji treba da bude vracen
	 * @return Vraca objekat klase ProfesorDto sa zadatim id-jem.
	 */
	@Override
	public ProfesorDto getProfesor(Long profesorId) {
		try {
			Optional<Profesor> profesor = this.profesorRepository.findById(profesorId);
			if (profesor.get() == null) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profesor sa datim id-jem ne postoji!");
			}
			return this.profesorConverter.toDto(profesor.get());
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 * Metoda koja cuva datu instancu klase ProfesorDto
	 * 
	 * @param profesorDto Profesor koji treba da bude sacuvan
	 * @return Vraca objekat klase ProfesorDto koji predstavlja sacuvanog profesora
	 * 
	 * @throws java.lang.ResponseStatusException ukoliko dodje do greske prilikom cuvanja profesora
	 */
	@Override
	public ProfesorDto saveProfesor(ProfesorDto profesorDto) {
		try {
			Profesor profesor = this.profesorConverter.toEntity(profesorDto);
			Profesor savedProfesor = this.profesorRepository.save(profesor);
			if (savedProfesor == null) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Problem da se sacuva profesor");
			}
			return this.profesorConverter.toDto(savedProfesor);
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		}
	}
	/**
	 * Metoda koja vraca sve sacuvane profesore
	 * 
	 * @return Vraca listu objekata klase ProfesorDto koja predstavlja sve sacuvane profesore
	 */
	@Override
	public List<ProfesorDto> getAllProfesors() {
		try {
			List<Profesor> profesori = this.profesorRepository.findAll();
			List<ProfesorDto> profesorDtos = new LinkedList<>();
			profesori.forEach((profesor) -> {
				ProfesorDto convertedProfesor = this.profesorConverter.toDto(profesor);
				profesorDtos.add(convertedProfesor);
			});
			return profesorDtos;
		} catch (Exception e) {
			throw e;
		}
	}

}
