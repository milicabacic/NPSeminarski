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

@Service
public class SalaServiceImpl implements SalaService {
	
	private final SalaRepository salaRepository;
	
	
	@Autowired
	public SalaServiceImpl(SalaRepository salaRepository) {
		super();
		this.salaRepository = salaRepository;
	}

	@Autowired
	private SalaConverter salaConverter;
	
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

	@Override
	public List<SalaDto> getAllSalas() {
		try {
			List<Sala> sale = this.salaRepository.findAll();
			List<SalaDto> salaDtos = new LinkedList<>();
			sale.forEach((sala) -> {
				SalaDto convertedSala = this.salaConverter.toDto(sala);
				salaDtos.add(convertedSala);
			});
			return salaDtos;
		} catch (Exception e) {
			throw e;
		}
	}

}
