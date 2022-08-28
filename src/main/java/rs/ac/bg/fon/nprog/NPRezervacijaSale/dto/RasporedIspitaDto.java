package rs.ac.bg.fon.nprog.NPRezervacijaSale.dto;

import java.util.List;
import java.util.Objects;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.RezervacijaSale;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.util.Rok;
/**
 * Klasa RasporedIspitaDto predstavlja Dto (Domain Transfer Object) klasu za klasu RasporedIspita.
 * 
 * Klasa RasporedIspitaDto sadrzi polja id kao long vrednost i rok kao enum vrednost.
 * 
 * @author Milica Bacic
 *
 */
public class RasporedIspitaDto {
	/**
	 * Id RasporedIspitaDto objekta kao Long vrednost.
	 */
	private Long id;
	/**
	 * Rok za koji vazi raspored ispita kao enum vrednost Rok.
	 */
	private Rok rok;
	/**
	 * Konstruktor koji inicijalizuje objekat klase RasporedIspitaDto bez parametara.
	 */
	public RasporedIspitaDto() {
		super();
	}
	/**
	 * Konstruktor koji inicijalizuje objekat klase RasporedIspitaDto za dat id i rok.
	 */
	public RasporedIspitaDto(Long id, Rok rok) {
		super();
		this.id = id;
		this.rok = rok;
	}
	/**
	 * 
	 * @return Vraca id objekta RasporedIspitaDto kao Long vrednost.
	 */
	public Long getId() {
		return id;
	}
	/**
	 * Postavlja id objekta RasporedIspitaDto na zadatu vrednost
	 * 
	 * @param id Id RasporedIspitaDto objekta kao Long vrednost.
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 
	 * @return Vraca rok objekta RasporedIspitaDto kao enum vrednost.
	 */
	public Rok getRok() {
		return rok;
	}
	/**
	 * Postavlja rok objekta RasporedIspitaDto na zadatu vrednost
	 * 
	 * @param rok Rok RasporedIspitaDto objekta kao enum vrednost.
	 */
	public void setRok(Rok rok) {
		this.rok = rok;
	}
	/**
	 * Vraca hash-iran objekat klase RasporedIspitaDto
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id, rok);
	}
	/**
	 * Poredi dva rasporeda ispita i vraca true ako su isti, a false ako nisu.
	 * 
	 * Rasporedi se porede po referenci ukoliko je isti objekat, a ako nije onda po id-u i roku
	 * 
	 * @return true ako su oba objekta klase RasporedIspitaDto i imaju iste vrednosti za id i rok.
	 * @return false u svim ostalim slucajevima.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RasporedIspitaDto other = (RasporedIspitaDto) obj;
		return Objects.equals(id, other.id) && rok == other.rok;
	}
	/**
	 * @return Vraca string sa svim podacima o objektu RasporedIspitaDto
	 */
	@Override
	public String toString() {
		return "RasporedIspitaDto [id=" + id + ", rok=" + rok + "]";
	}
	

	
	
	
}
