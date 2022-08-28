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
 * Klasa koja predstavlja asistenta na fakultetu.
 * 
 * Asistent ima id, ime i prezime. U okviru njega cuva se i lista rezervacija sala u kojima je dezuran.
 * 
 * @author Milica Bacic
 *
 */
@Entity
@Table (name = "asistent")
public class Asistent {
	/**
	 * Id asistenta kao long vrednost koja je oznacena kao id i generise se samostalno.
	 */
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * Ime asistenta kao string vrednost.
	 */
	private String ime;
	/**
	 * Prezime asistenta kao string vrednost.
	 */
	private String prezime;
	/**
	 * Lista rezervacija sala u kojima je dati asistent dezuran.
	 */
	@OneToMany(mappedBy = "asistent" , fetch = FetchType.LAZY)
	private List<RezervacijaSale> dezurstva;

	/**
	 * Konstruktor koji inicijalizuje objekat bez parametara.
	 */
	public Asistent() {
		super();
	}

	/**
	 * Konstruktor koji inicijalizuje objekat klase Asistent i postavlja vrednosti za id, ime, prezime i dezurstva asistenta.
	 * 
	 * @param id Id asistenta kao long vrednost
	 * @param ime Ime asistenta kao string vrednost
	 * @param prezime Prezime asistenta kao string vrednost
	 * @param dezurstva Lista rezervacija sala u kojima asisent dezura
	 */
	public Asistent(Long id, String ime, String prezime, List<RezervacijaSale> dezurstva) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.dezurstva = dezurstva;
	}

	/**
	 * Metoda koja vraca id asistenta.
	 * 
	 * @return Id asistenta kao long vrednost.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Postavlja vrednost parametra id na zadatu vrednost.
	 * 
	 * @param id Id asistenta kao long vrednost.
	 * 
	 * @throws java.lang.NullPointerException ako je unet id null
	 * @throws java.lang.IllegalArgumentException ako je unet id manji ili jednak 0
	 */
	public void setId(Long id) {
		if(id == null) {
			throw new NullPointerException("Id ne sme biti null!");
		}
		if(id<=0) {
			throw new IllegalArgumentException("Id ne sme biti manji od 0");
		}
		this.id = id;
	}

	/**
	 * Vraca ime asistenta.
	 * 
	 * @return ime asistenta kao string vrednost.
	 */
	public String getIme() {
		return ime;
	}

	/**
	 * Postavlja vrednost atributa ime na zadatu vrednost.
	 * 
	 * @param ime Ime asistenta kao string vrednost
	 * 
	 * @throws java.lang.NullPointerException ako je zadato ime null
	 * @throw java.lang.IlleagalArgumentException ako je zadato ime prazan string
	 */
	public void setIme(String ime) {
		if(ime == null) {
			throw new NullPointerException("Ime ne sme biti null");
		}
		if(ime == "" ) {
			throw new IllegalArgumentException("Ime ne sme biti prazan string");
		}
		this.ime = ime;
	}

	/**
	 * Vraca prezime asistenta.
	 * 
	 * @return prezime asistenta kao string vrednost.
	 */
	public String getPrezime() {
		return prezime;
	}

	/**
	 * Postavlja vrednost atributa prezime na zadatu vrednost.
	 * 
	 * @param prezime Prezime asistenta kao string vrednost.
	 * 
	 * @throws java.lang.NullPointerException ako je zadato prezime null
	 * @throws java.lang.IllegalArgumentException ako je zadato prezime prazan string
	 */
	public void setPrezime(String prezime) {
		if(prezime == null) {
			throw new NullPointerException("Prezime ne sme biti null");
		}
		if(prezime == "" ) {
			throw new IllegalArgumentException("Prezime ne sme biti prazan string");
		}
		this.prezime = prezime;
	}

	/**
	 * Vraca listu rezervacija sala u kojima je asistent dezuran.
	 * 
	 * @return lista rezervacija sala u kojima asistent dezura.
	 */
	public List<RezervacijaSale> getDezurstva() {
		return dezurstva;
	}

	/**
	 * Postavlja vrednost dezurstava na zadatu listu rezervacija sala.
	 * 
	 * @param dezurstva lista rezervacija sala
	 * 
	 * @throws java.lang.NullPointerException ako je lista dezurstava null
	 */
	public void setDezurstva(List<RezervacijaSale> dezurstva) {
		if(dezurstva == null) {
			throw new NullPointerException("Dezurstva ne smeju biti null");
		}
		this.dezurstva = dezurstva;
	}

	/**
	 * @return Vraca hashcode objekat za Asistenta.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(dezurstva, id, ime, prezime);
	}

	/**
	 * Poredi dva asistenta i vraca true ako su isti, a false ako nisu.
	 * 
	 * Autori se porede po referenci ukoliko je isti objekat, a ako nije onda po id-u, imenu, prezimenu i dezurstvima i sva polja moraju biti ista.
	 * 
	 * @return true ako su oba objekta klase Asistent i imaju iste vrednosti za id, ime, prezime i dezurstva.
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
		Asistent other = (Asistent) obj;
		return Objects.equals(dezurstva, other.dezurstva) && Objects.equals(id, other.id)
				&& Objects.equals(ime, other.ime) && Objects.equals(prezime, other.prezime);
	}

	/**
	 * @return Vraca string sa svim podacima o Asistentu.
	 */
	@Override
	public String toString() {
		return "Asistent [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", dezurstva=" + dezurstva + "]";
	}

	
	
	
}
