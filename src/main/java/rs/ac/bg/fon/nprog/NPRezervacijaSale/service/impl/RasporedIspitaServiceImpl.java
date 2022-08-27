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
import rs.ac.bg.fon.nprog.NPRezervacijaSale.service.RasporedIspitaService;

@Service
public class RasporedIspitaServiceImpl implements RasporedIspitaService {

	private final RasporedIspitaRepository rasporedRepository;
	
	@Autowired
	public RasporedIspitaServiceImpl(RasporedIspitaRepository rasporedRepository) {
		super();
		this.rasporedRepository = rasporedRepository;
	}

	@Autowired
	RasporedIspitaConverter rasporedConverter;
	
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

	@Override
	public RasporedIspitaDto saveRaspored(RasporedIspitaDto rasporedDto) {
		try {
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
