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
 * Klasa koja predstavlja profesora na fakultetu.
 * 
 * Profesor ima id, ime i prezime. U okviru njega cuva se i lista rezervacija sala u kojima je dezuran.
 * 
 * @author Milica Bacic
 *
 */
@Entity
@Table (name = "profesor")
public class Profesor {
	/**
	 * Id profesora kao long vrednost koja je oznacena kao id i generise se samostalno.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * Ime profesora kao String vrednost.
	 */
	private String ime;
	/**
	 * Prezime profesora kao String vrendost.
	 */
	private String prezime;
	/**
	 * Lista rezervacija sala u kojima je profesor dezuran.
	 */
	@OneToMany(mappedBy = "profesor", fetch = FetchType.LAZY)
	private List<RezervacijaSale> dezurstva;

	/**
	 * Konstruktor koji inicijalizuje objekat klase Profesor bez parametara.
	 */
	public Profesor() {
		super();
	}
	/**
	 * Konstruktor koji inicijalizuje objekat klase Profesor i postavlja vrednosti za id,ime,prezime i dezurstva.
	 * 
	 * @param id Id profesora kao Long vrednost.
	 * @param ime Ime profesora kao String vrednost.
	 * @param prezime Prezime profesora kao String vrednost.
	 * @param dezurstva Dezurstva profesora kao lista rezervacija sala.
	 */
	public Profesor(Long id, String ime, String prezime, List<RezervacijaSale> dezurstva) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.dezurstva = dezurstva;
	}
	
	/**
	 * @return Vraca id profesora kao Long vrednost.
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Postavlja id profesora na zadatu id vrednost.
	 * 
	 * @param id Id profesora kao long vrednost.
	 * 
	 * @throws java.lang.NullPointerException ako je zadata id vrednost null
	 * @throws java.lang.IllegalArgumentException ako je zadata id vrednot manja ili jednaka 0.
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
	 * @return Vraca ime profesora kao String vrednost.
	 */
	public String getIme() {
		return ime;
	}
	/**
	 * Postavlja ime profesora na zadatu vrednost.
	 * 
	 * @param ime Ime profesora kao string vrednost.
	 * 
	 * @throws java.lang.NullPointerException ako je zadato ime null
	 * @throws java.lang.IllegalArgumentException ako je zadato ime prazan string
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
	 * 
	 * @return Vraca prezime profesora kao String vrednost.
	 */
	public String getPrezime() {
		return prezime;
	}

	/**
	 * Postavlja prezime profesora na zadatu vrednost.
	 * 
	 * @param prezime Prezme profesora kao string vrednost.
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
	 * 
	 * @return Vraca listu rezervacija sale u kojima je profesor dezuran.
	 */
	public List<RezervacijaSale> getDezurstva() {
		return dezurstva;
	}

	/**
	 * Postavlja dezurstva profesora na zadatu vrednost.
	 * 
	 * @param dezurstva Lista rezervacija sale u kojima je profesor dezuran.
	 * 
	 * @throws java.lang.NullPointerException ako je lista dezurstava null
	 */
	public void setDezurstva(List<RezervacijaSale> dezurstva) {
		if(dezurstva == null) {
			throw new NullPointerException("Dezurstva ne smeju biti null!");
		}
		this.dezurstva = dezurstva;
	}

	/**
	 * Vraca hash-iran objekat klase Profesor.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(dezurstva, id, ime, prezime);
	}

	/**
	 * Poredi dva profesora i vraca true ako su isti, a false ako nisu.
	 * 
	 * Profesori se porede po referenci ukoliko je isti objekat, a ako nije onda po id-u, imenu, prezimenu i dezurstvima i sva polja moraju biti ista.
	 * 
	 * @return true ako su oba objekta klase Profesor i imaju iste vrednosti za id, ime, prezime i dezurstva.
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
		Profesor other = (Profesor) obj;
		return Objects.equals(dezurstva, other.dezurstva) && Objects.equals(id, other.id)
				&& Objects.equals(ime, other.ime) && Objects.equals(prezime, other.prezime);
	}

	/**
	 * @return String sa svim podacima o profesoru.
	 */
	@Override
	public String toString() {
		return "Profesor [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", dezurstva=" + dezurstva + "]";
	}
	
	
	
}
