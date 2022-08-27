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

@Service
public class PredmetServiceImpl implements PredmetService {

	private final PredmetRepository predmetRepository;
	
	
	@Autowired
	public PredmetServiceImpl(PredmetRepository predmetRepository) {
		super();
		this.predmetRepository = predmetRepository;
	}
	
	@Autowired
	private PredmetConverter predmetConverter;

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
