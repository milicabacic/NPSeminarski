package rs.ac.bg.fon.nprog.NPRezervacijaSale.domain;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.util.Rok;
/**
 * Klasa koja predstavlja raspored ispita na fakultetu za odrednjeni rok.
 * 
 * Raspored ispita ima id, rok i listu ispita za dati rok.
 * 
 * @author Milica Bacic
 *
 */
@Entity
@Table (name = "rasporedIspita")
public class RasporedIspita {
	/**
	 * Id rasporeda ispita kao long vrednost koja je oznacena kao id i generise se samostalno.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * Rok u kome su ispiti dat kao Enum vrednost.
	 */
	private Rok rok;
	/**
	 * Lista rezervacija sala za dati rok i raspored.
	 */
	@OneToMany(mappedBy = "raspored", fetch = FetchType.EAGER)
	List<RezervacijaSale> ispiti;

	/**
	 * Konstruktor koji inicijalizuje objekat klase RasporedIspita bez parametara
	 */
	public RasporedIspita() {
		super();
	}

	/**
	 * Konstruktor koji inicijalizuje objekat klase RasporedIspita sa datim vrednostima za id,rok i ispite.
	 * 
	 * @param id Id vrednost rasporeda kao Long vrednost.
	 * @param rok Rok raspored kao enum vrednost Rok.
	 * @param ispiti Ispiti rasporeda kao lista rezervacija sala.
	 */
	public RasporedIspita(Long id, Rok rok, List<RezervacijaSale> ispiti) {
		super();
		this.id = id;
		this.rok = rok;
		this.ispiti = ispiti;
	}

	/**
	 * 
	 * @return Vraca id rasporeda kao Long vrednost.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Postavlja id rasporeda ispita na zadatu vrednost.
	 * 
	 * @param id Id rasporeda kao Long vrednost.
	 * 
	 * @throws java.lang.NullPointerException ako je id null
	 * @throws java.lang.IllegalArgumentException ako je id manji ili jednak 0
	 */
	public void setId(Long id) {
		if (id == null) {
			throw new NullPointerException("Id ne sme biti null!");
		}
		if(id<=0) {
			throw new IllegalArgumentException("Id ne sme biti manji od 0");
		}
		this.id = id;
	}

	/**
	 * 
	 * @return Vraca rok rasporeda ispita kao enum vrednost Rok.
	 */
	public Rok getRok() {
		return rok;
	}

	/**
	 * Postavlja vrednost roka rasporeda ispita na zadatu vrednost.
	 * 
	 * @param rok Rok rasporeda ispita kao enum vrednost Rok.
	 * 
	 * @throws java.lang.NullPointerException ako je rok null
	 */
	public void setRok(Rok rok) {
		if(rok == null) {
			throw new NullPointerException();
		}
		this.rok = rok;
	}

	/**
	 * 
	 * @return Vraca listu rezervacija sala za ispite u datom rasporedu.
	 */
	public List<RezervacijaSale> getIspiti() {
		return ispiti;
	}

	/**
	 * Postavlja listu rezervacija sala ispita datog rasporeda na zadatu vrednost.
	 * 
	 * @param ispiti Lista rezervacija sala za ispite u datom rasporedu.
	 * 
	 * @throws java.lang.NullPointerException ako su ispiti null
	 */
	public void setIspiti(List<RezervacijaSale> ispiti) {
		this.ispiti = ispiti;
	}

	/**
	 * Vraca hash-iran objekat za klasu RasporedIspita
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id, ispiti, rok);
	}

	/**
	 * Poredi dva rasporeda ispita i vraca true ako su isti, a false ako nisu.
	 * 
	 * Rasporedi se porede po referenci ukoliko je isti objekat, a ako nije onda po id-u, roku i ispitima i sva polja moraju biti ista.
	 * 
	 * @return true ako su oba objekta klase RasporedIspita i imaju iste vrednosti za id, rok i ispite.
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
		RasporedIspita other = (RasporedIspita) obj;
		return Objects.equals(id, other.id) && Objects.equals(ispiti, other.ispiti) && rok == other.rok;
	}

	/**
	 * @return Vraca string sa svim podacima o rasporedu ispita
	 */
	@Override
	public String toString() {
		return "RasporedIspita [id=" + id + ", rok=" + rok + ", ispiti=" + ispiti + "]";
	}
	
	
	
}
