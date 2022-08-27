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

@Service
public class AsistentServiceImpl implements AsistentService {
	
	private final AsistentRepository asistentRepository;
	
	
	@Autowired
	public AsistentServiceImpl(AsistentRepository asistentRepository) {
		super();
		this.asistentRepository = asistentRepository;
	}
	
	@Autowired
	AsistentConverter asistentConverter;
	
	

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
