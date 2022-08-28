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
/**
 * Klasa koja predstavlja predmet na fakultetu.
 * 
 * Predmet ima id, naziv predmeta i broj espb bodova koje nosi.
 * 
 * @author Milica Bacic
 *
 */
@Entity
@Table (name = "predmet")
public class Predmet {
	/**
	 * Id predmeta kao long vrednost koja je oznacena kao id i generise se samostalno.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * Naziv predmeta kao String vrednost.
	 */
	private String naziv;
	/**
	 * Broj espb bodova koje predmet nosi kao int vrednost.
	 */
	private int espb;
	/**
	 * Lista rezervacija sale u kojima se predmet polaze.
	 */
	@OneToMany(mappedBy = "predmet" , fetch = FetchType.LAZY)
	private List<RezervacijaSale> ispiti;
	/**
	 * Konstruktor koji inicijalizuje objekat klase Predmet bez parametara.
	 */
	public Predmet() {
		super();
	}
	/**
	 * Konstruktor koji inicijalizuje objekat klase Predmet sa zadatim vrednostima za id, naziv i espb
	 * 
	 * @param id Id predmeta kao Long vrednost.
	 * @param naziv Naziv predmeta kao String vrednost.
	 * @param espb Broj espb bodova predmeta kao int vrednost.
	 * @param ispiti Lista rezervacija sala u kojima se dat predmet polaze.
	 */
	public Predmet(Long id, String naziv, int espb, List<RezervacijaSale> ispiti) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.espb = espb;
		this.ispiti = ispiti;
	}
	/**
	 * 
	 * @return Vraca id predmeta kao Long vrednost.
	 */
	public Long getId() {
		return id;
	}
	/**
	 * Postavlja vrednost za id predmeta na zadatu vrednost.
	 * 
	 * @param id Id vrednost predmeta kao Long vrednost.
	 * 
	 * @throws java.lang.NullPointerException ako je id null
	 * @throws java.lang.IllegalArgumentException ako je zadat id manji ili jednak 0.
	 */
	public void setId(Long id) {
		if(id == null) {
			throw new NullPointerException("Id ne sme biti null!");
		}
		if(id <= 0) {
			throw new IllegalArgumentException("Id ne sme biti manji od 0");
		}
		this.id = id;
	}

	/**
	 * 
	 * @return Vraca naziv predmeta kao String vrednost.
	 */
	public String getNaziv() {
		return naziv;
	}
	/**
	 * Postavlja vrednost naziva predmeta na zadatu vrednost.
	 * 
	 * @param naziv Naziv predmeta kao String vrednost.
	 * 
	 * @throws java.lang.NullPointerException ako je zadat naziv null
	 * @throws java.lang.IllegalArgumentException ako je zadat naziv prazan string
	 */
	public void setNaziv(String naziv) {
		if(naziv == null) {
			throw new NullPointerException("Naziv ne sme biti null!");
		}
		if(naziv == "" ) {
			throw new IllegalArgumentException("Naziv ne sme biti prazan string");
		}
		this.naziv = naziv;
	}
	/**
	 * 
	 * @return Vraca broj espb bodova predmeta kao int vrednost.
	 */
	public int getEspb() {
		return espb;
	}
	/**
	 * Postavlja broj espb bodova predmeta na zadatu vrednost.
	 * 
	 * @param espb Broj espb bodova predmeta kao int vrednost.
	 * 
	 * @throws java.lang.IllegalArgumentException ako je broj espb bodova manji od 1
	 */
	public void setEspb(int espb) {
		if(espb<1) {
			throw new IllegalArgumentException("Broj ESPB bodova ne sme biti manji od 0");
		}
		this.espb = espb;
	}

	/**
	 * 
	 * @return Vraca listu rezervacija sale u kojima se predmet polaze.
	 */
	public List<RezervacijaSale> getIspiti() {
		return ispiti;
	}

	/**
	 * Postavlja listu rezervacija sale u kojima se predmet polaze na zadatu vrednost.
	 * 
	 * @param ispiti Lista rezervacija sale u kojima se predmet polaze.
	 * 
	 * @throws java.lang.NullPointerException ako je zadata lista null
	 */
	public void setIspiti(List<RezervacijaSale> ispiti) {
		if(ispiti == null) {
			throw new NullPointerException("Ispiti ne smeju biti null!");
		}
		this.ispiti = ispiti;
	}

	/**
	 * Vraca hash-iran objekat klase Predmet.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(espb, id, ispiti, naziv);
	}

	/**
	 * Poredi dva predmeta i vraca true ako su isti, a false ako nisu.
	 * 
	 * Predmeti se porede po referenci ukoliko je isti objekat, a ako nije onda po id-u, nazivu, espb-u i ispitima.
	 * 
	 * @return true ako su oba objekta klase Predmet i imaju iste vrednosti za id, naziv, espb i ispiti.
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
		Predmet other = (Predmet) obj;
		return espb == other.espb && Objects.equals(id, other.id) && Objects.equals(ispiti, other.ispiti)
				&& Objects.equals(naziv, other.naziv);
	}

	/**
	 * @return String sa svim podacima o predmetu.
	 */
	@Override
	public String toString() {
		return "Predmet [id=" + id + ", naziv=" + naziv + ", espb=" + espb + ", ispiti=" + ispiti + "]";
	}
	
	
	
}
