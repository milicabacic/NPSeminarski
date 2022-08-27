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

@Service
public class ProfesorServiceImpl implements ProfesorService {
	
	private final ProfesorRepository profesorRepository;
	
	@Autowired
	public ProfesorServiceImpl(ProfesorRepository profesorRepository) {
		super();
		this.profesorRepository = profesorRepository;
	}
	
	@Autowired
	ProfesorConverter profesorConverter;

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
