package rs.ac.bg.fon.nprog.NPRezervacijaSale.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.converter.AsistentConverter;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.converter.PredmetConverter;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.converter.ProfesorConverter;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.converter.RasporedIspitaConverter;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.converter.RezervacijaSaleConverter;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.converter.SalaConverter;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.RezervacijaSale;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.AsistentDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.PredmetDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.ProfesorDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.RasporedIspitaDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.RezervacijaSaleDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.SalaDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.repository.RezervacijaSaleRepository;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.service.RezervacijaSaleService;

@Service
public class RezervacijaSaleServiceImpl implements RezervacijaSaleService {
	
	private final RezervacijaSaleRepository rezervacijaSaleRepository;
	
	private final SalaServiceImpl salaService;
	private final ProfesorServiceImpl profesorService;
	private final PredmetServiceImpl predmetService;
	private final AsistentServiceImpl asistentService;
	private final RasporedIspitaServiceImpl rasporedService;

	
	@Autowired
	public RezervacijaSaleServiceImpl(RezervacijaSaleRepository rezervacijaSaleRepository, SalaServiceImpl salaService,
			ProfesorServiceImpl profesorService, PredmetServiceImpl predmetService, AsistentServiceImpl asistentService,
			RasporedIspitaServiceImpl rasporedService, RezervacijaSaleConverter rezervacijaSaleConverter) {
		super();
		this.rezervacijaSaleRepository = rezervacijaSaleRepository;
		this.salaService = salaService;
		this.profesorService = profesorService;
		this.predmetService = predmetService;
		this.asistentService = asistentService;
		this.rasporedService = rasporedService;
		this.rezervacijaSaleConverter = rezervacijaSaleConverter;
	}

	@Autowired
	RezervacijaSaleConverter rezervacijaSaleConverter;
	
	@Autowired
	SalaConverter salaConverter;
	
	@Autowired
	AsistentConverter asistentConverter;
	
	@Autowired
	PredmetConverter predmetConverter;
	
	@Autowired
	ProfesorConverter profesorConverter;
	
	@Autowired
	RasporedIspitaConverter rasporedIspitaConverter;

	@Override
	public RezervacijaSaleDto getRezervacijaSale(Long rezervacijaSaleId) {
		try {
			Optional<RezervacijaSale> rezervacija = this.rezervacijaSaleRepository.findById(rezervacijaSaleId);
			if (rezervacija.get() == null) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rezervacija sale sa datim id-jem ne postoji!");
			}
			return this.rezervacijaSaleConverter.toDto(rezervacija.get());
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public RezervacijaSaleDto saveRezervacijaSale(RezervacijaSaleDto rezervacijaDto) {
		try {
			RezervacijaSale rezervacijaSale = this.rezervacijaSaleConverter.toEntity(rezervacijaDto);
			RezervacijaSale savedRezervacijaSale = this.rezervacijaSaleRepository.save(rezervacijaSale);
			if (savedRezervacijaSale == null) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Problem da se sacuva rezervacija sale!");
			}
			return this.rezervacijaSaleConverter.toDto(savedRezervacijaSale);
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		}
	}

	@Override
	public List<RezervacijaSaleDto> getAllRezervacijaSales() {
		try {
			List<RezervacijaSale> rezervacije = this.rezervacijaSaleRepository.findAll();
			List<RezervacijaSaleDto> rezervacijeDtos = new LinkedList<>();
			rezervacije.forEach((rezervacija) -> {
				RezervacijaSaleDto convertedRezervacija = this.rezervacijaSaleConverter.toDto(rezervacija);
				rezervacijeDtos.add(convertedRezervacija);
			});
			return rezervacijeDtos;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public boolean deleteRezervacijaSale(Long rezervacijaSaleId) {
		try {
			RezervacijaSale rezervacija = this.rezervacijaSaleRepository.findById(rezervacijaSaleId).get();
			if(rezervacija == null) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rezervacija sa datim id-jem ne postoji!");
			}
			this.rezervacijaSaleRepository.delete(rezervacija);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public RezervacijaSaleDto updateRezervacijaSale(RezervacijaSaleDto rezervacijaDto) {
		try {
			RezervacijaSale updatedRezervacijaSale = this.rezervacijaSaleRepository.findById(rezervacijaDto.getId()).get();
			if(updatedRezervacijaSale == null) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ne postoji rezervacija sa datim id-jem!");
			}
			updatedRezervacijaSale.setId(rezervacijaDto.getId());
			updatedRezervacijaSale.setRok(rezervacijaDto.getRok());
			updatedRezervacijaSale.setDatumVremeOd(rezervacijaDto.getDatumVremeOd());
			updatedRezervacijaSale.setDatumVremeDo(rezervacijaDto.getDatumVremeDo());
			updatedRezervacijaSale.setBrojStudenata(rezervacijaDto.getBrojStudenata());
			updatedRezervacijaSale.setTipIspita(rezervacijaDto.getTipIspita());
			
			SalaDto salaDto = salaService.getSala(rezervacijaDto.getSalaId());
			updatedRezervacijaSale.setSala(salaConverter.toEntity(salaDto));
			
			AsistentDto asistentDto = asistentService.getAsistent(rezervacijaDto.getAsistentId());
			updatedRezervacijaSale.setAsistent(asistentConverter.toEntity(asistentDto));
			
			ProfesorDto profesorDto = profesorService.getProfesor(rezervacijaDto.getProfesorId());
			updatedRezervacijaSale.setProfesor(profesorConverter.toEntity(profesorDto));
			
			PredmetDto predmetDto = predmetService.getPredmet(rezervacijaDto.getPredmetId());
			updatedRezervacijaSale.setPredmet(predmetConverter.toEntity(predmetDto));
			
			RasporedIspitaDto rasporedDto = rasporedService.getRaspored(rezervacijaDto.getRasporedId());
			updatedRezervacijaSale.setRaspored(rasporedIspitaConverter.toEntity(rasporedDto));
			
			
			RezervacijaSale savedRezervacija =this.rezervacijaSaleRepository.save(updatedRezervacijaSale);
			return this.rezervacijaSaleConverter.toDto(savedRezervacija);
		} catch (Exception e) {
			throw e;
		}
	}

}
