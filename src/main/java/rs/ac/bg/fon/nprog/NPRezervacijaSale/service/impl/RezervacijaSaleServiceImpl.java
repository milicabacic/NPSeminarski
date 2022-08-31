package rs.ac.bg.fon.nprog.NPRezervacijaSale.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;import java.util.function.Function;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
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
import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.Sala;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.AsistentDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.PredmetDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.ProfesorDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.RasporedIspitaDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.RezervacijaSaleDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.SalaDto;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.repository.RezervacijaSaleRepository;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.repository.SalaRepository;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.service.RezervacijaSaleService;
/**
 * Implementacija interfejsa RezervacijaSaleService koja sadrzi logiku za rad sa domenskom klasom RezervacijaSale (CRUD operacije).
 * 
 * @author Milica Bacic
 *
 */
@Service
public class RezervacijaSaleServiceImpl implements RezervacijaSaleService {
	/**
	 * Interfejs koji se odnosi na repozitorijum i sluzi za rad sa bazom podataka.
	 */
	@Autowired
	private  RezervacijaSaleRepository rezervacijaSaleRepository;
	/**
	 * Instanca klase SalaServiceImpl koja sluzi za rad sa entitetima klase SalaDto
	 */
	@Autowired
	private  SalaServiceImpl salaService;
	/**
	 * Instanca klase ProfesorServiceImpl koja sluzi za rad sa entitetima klase ProfesorDto
	 */
	@Autowired
	private  ProfesorServiceImpl profesorService;
	/**
	 * Instanca klase PredmetServiceImpl koja sluzi za rad sa entitetima klase PredmetDto
	 */
	@Autowired
	private  PredmetServiceImpl predmetService;
	/**
	 * Instanca klase AsistentServiceImpl koja sluzi za rad sa entitetima klase AsistentDto
	 */
	@Autowired
	private  AsistentServiceImpl asistentService;
	/**
	 * Instanca klase RasporedIspitaServiceImpl koja sluzi za rad sa entitetima klase RasporedIspitaDto
	 */
	@Autowired
	private  RasporedIspitaServiceImpl rasporedService;

	/**
	 * Konstruktor koji inicijalizuje objekat klase RezervacijaSaleServiceImpl i postavlja vrednosti atributa na zadate vrednosti.
	 * 
	 * @param rezervacijaSaleRepository Repozitorijum za rad sa bazom podataka klase RezervacijaSale
	 * @param salaService Objekat klase SalaServiceImpl
	 * @param profesorService Objekat klase ProfesorServiceImpl
	 * @param predmetService Objekat klase PredmetServiceImpl
	 * @param asistentService Objekat klase AsistentServiceImpl
	 * @param rasporedService Objekat klase RasporedIspitaServiceImpl
	 * @param rezervacijaSaleConverter Objekat klase RezervacijaSaleConverter
	 */
	@Autowired
	public RezervacijaSaleServiceImpl(RezervacijaSaleRepository rezervacijaSaleRepository, SalaServiceImpl salaService,
			ProfesorServiceImpl profesorService, PredmetServiceImpl predmetService, AsistentServiceImpl asistentService,
			RasporedIspitaServiceImpl rasporedService, RezervacijaSaleConverter rezervacijaSaleConverter,
			SalaConverter salaConverter, AsistentConverter asistentConverter, PredmetConverter predmetConverter,
			ProfesorConverter profesorConverter, RasporedIspitaConverter rasporedIspitaConverter) {
		super();
		this.rezervacijaSaleRepository = rezervacijaSaleRepository;
		this.salaService = salaService;
		this.profesorService = profesorService;
		this.predmetService = predmetService;
		this.asistentService = asistentService;
		this.rasporedService = rasporedService;
		this.rezervacijaSaleConverter = rezervacijaSaleConverter;
		this.salaConverter = salaConverter;
		this.asistentConverter = asistentConverter;
		this.predmetConverter = predmetConverter;
		this.profesorConverter = profesorConverter;
		this.rasporedIspitaConverter = rasporedIspitaConverter;
	}

	/**
	 * Objekat klase RezervacijaSaleConverter koji sluzi za konverzije izmedju objekata klasa RezervacijaSale i RezervacijaSaleDto
	 */
	@Autowired
	RezervacijaSaleConverter rezervacijaSaleConverter;
	

	/**
	 * Objekat klase SalaConverter koji sluzi za konverzije izmedju objekata klasa Sala i SalaDto
	 */
	@Autowired
	SalaConverter salaConverter;
	/**
	 * Objekat klase AsistentConverter koji sluzi za konverzije izmedju objekata klasa Asistent i AsistentDto
	 */
	@Autowired
	AsistentConverter asistentConverter;
	/**
	 * Objekat klase PredmetConverter koji sluzi za konverzije izmedju objekata klasa Predmet i PredmetDto
	 */
	@Autowired
	PredmetConverter predmetConverter;
	/**
	 * Objekat klase ProfesorConverter koji sluzi za konverzije izmedju objekata klasa Profesor i ProfesorDto
	 */
	@Autowired
	ProfesorConverter profesorConverter;
	/**
	 * Objekat klase RasporedIspitaConverter koji sluzi za konverzije izmedju objekata klasa RasporedIspita i RasporedIspitaDto
	 */
	@Autowired
	RasporedIspitaConverter rasporedIspitaConverter;

	/**
	 * Metoda koja za zadati id vraca objekat klase RezervacijaSaleDto koji ima dati id.
	 * 
	 * @param rezervacijaSaleId Id rezervacije sale koja treba da bude vracena
	 * @return Vraca objekat klase RezervacijaSaleDto sa zadatim id-jem.
	 */
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

	/**
	 * Metoda koja cuva datu instancu klase RezervacijaSaleDto
	 * 
	 * @param rezervacijaDto Rezervacija sale koja treba da bude sacuvana
	 * @return Vraca objekat klase RezervacijaSaleDto koji predstavlja sacuvanu rezervaciju sale
	 * 
	 * @throws org.springframework.web.server.ResponseStatusException ukoliko dodje do greske prilikom cuvanja rezervacije sale
	 */
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

	/**
	 * Metoda koja vraca sve sacuvane rezervacije sala
	 * 
	 * @return Vraca listu objekata klase RezervacijaSaleDto koja predstavlja sve sacuvane rezervacije sala
	 */
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

	/**
	 * Metoda koja brise rezervaciju sale sa datim id-jem.
	 * 
	 * @param rezervacijaSaleId Id rezervacije sale koja treba da bude obrisana
	 * 
	 * @return true ukoliko je brisanje uspesno
	 * @return false ukoliko je brisanje neuspesno
	 * 
	 * @throws org.springframework.web.server.ResponseStatusException ukoliko dodje do greske prilikom brisanja rezervacije sale
	 */
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

	/**
	 * Metoda koja azurira rezervaciju sale zadatom rezervacijom
	 * 
	 * @param rezervacijaDto Rezervacij sale kojom stara treba da bude azurirana
	 * 
	 * @return Vraca objekat klase RezervacijaSaleDto koji predstavlja novu rezervaciju sale nakon azuriranja
	 * 
	 * @throws org.springframework.web.server.ResponseStatusException ukoliko dodje do greske prilikom azuriranja rezervacije sale
	 */
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
