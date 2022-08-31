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

import rs.ac.bg.fon.nprog.NPRezervacijaSale.util.TipSale;
/**
 * Klasa koja predstavlja salu na fakultetu.
 * 
 * Sala ima id, naziv, kapacitet, tip sale i listu rezervacija sale za ispite.
 * 
 * @author Milica Bacic
 *
 */
@Entity
@Table (name = "sala")
public class Sala {

	/**
	 * Id sale kao long vrednost koja je oznacena kao id i generise se samostalno.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * Naziv sale kao String vrednost.
	 */
	private String naziv;
	/**
	 * Kapacitet sale kao int vrednost.
	 */
	private int kapacitet;
	/**
	 * Tip sale kao enum vrednost TipSale.
	 */
	private TipSale tipSale;
	
	/**
	 * Lista rezervacija sale za ispite.
	 */
	@OneToMany(mappedBy = "sala", fetch = FetchType.LAZY)
	private List<RezervacijaSale> rezervacije;

	/**
	 * Konstruktor koji inicijalizuje objekat klase Sala bez parametara.
	 */
	public Sala() {
		super();
	}

	/**
	 * Konstruktor koji inicijalizuje objekat klase Sala sa zadatim vrednostima za id, naziv, kapacitet, tip sale i rezervaicje.
	 * 
	 * @param id Id sale kao Long vrednost.
	 * @param naziv Naziv sale kao String vrednost.
	 * @param kapacitet Kapacitet sale kao int vrednost.
	 * @param tipSale Tip sale kao enum vrednost.
	 * @param rezervacije Rezervacije sale kao lista rezervacija sala.
	 */
	public Sala(Long id, String naziv, int kapacitet, TipSale tipSale, List<RezervacijaSale> rezervacije) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.kapacitet = kapacitet;
		this.tipSale = tipSale;
		this.rezervacije = rezervacije;
	}

	/**
	 * 
	 * @return Vraca id sale kao Long vrednost.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Postavlja id sale na zadatu vrednost id-ja
	 * 
	 * @param id Id sale kao Long vrednost
	 * 
	 * @throws java.lang.NullPointerException ako je id null
	 * @throws java.lang.IllegalArgumentException ako je id manji ili jednak 0
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
	 * @return Vraca naziv sale kao String vrednost.
	 */
	public String getNaziv() {
		return naziv;
	}

	/**
	 * Postavlja vrednost naziva sale na zadatu vrednost.
	 * 
	 * @param naziv Naziv sale kao String vrednost.
	 * 
	 * @throws java.lang.NullPointerException ako je naziv null
	 * @throws java.lang.IllegalArgumentException ako je naziv prazan string
	 */
	public void setNaziv(String naziv) {
		if(naziv == null) {
			throw new NullPointerException("Naziv ne sme biti null");
		}
		if(naziv == "" ) {
			throw new IllegalArgumentException("Naziv ne sme biti prazan string");
		}
		this.naziv = naziv;
	}

	/**
	 * 
	 * @return Vraca kapacitet sale kao int vrednost.
	 */
	public int getKapacitet() {
		return kapacitet;
	}

	/**
	 * Postavlja kapacitet sale na zadatu vrednost.
	 * 
	 * @param kapacitet Kapacitet sale kao int vrednost
	 * 
	 * @throws java.lang.IllegalArgumentException ako je zadat kapacitet manji od 1
	 */
	public void setKapacitet(int kapacitet) {
		if(kapacitet<1) {
			throw new IllegalArgumentException("Kapacitet ne moze biti manji od jedne osobe");
		}
		this.kapacitet = kapacitet;
	}

	/**
	 * 
	 * @return Vraca tip sale kao enum vrednost TipSale.
	 */
	public TipSale getTipSale() {
		return tipSale;
	}
	/**
	 * Postavlja tip sale na zadatu vrednost.
	 * 
	 * @param tipSale TipSale kao enum vrednost TipSale
	 * 
	 * @throws java.lang.NullPointerException ako je zadat tip sale null
	 */
	public void setTipSale(TipSale tipSale) {
		if(tipSale == null) {
			throw new NullPointerException();
		}
		this.tipSale = tipSale;
	}

	/**
	 * 
	 * @return Vraca listu rezervacija sale za polaganje ispita.
	 */
	public List<RezervacijaSale> getRezervacije() {
		return rezervacije;
	}

	/**
	 * Postavlja rezervacije na zadatu vrednost.
	 * 
	 * @param rezervacije Lista Rezervacija sale za datu salu
	 * 
	 * @throws java.lang.NullPointerException ako je lista rezervacija null
	 */
	public void setRezervacije(List<RezervacijaSale> rezervacije) {
		if(rezervacije == null) {
			throw new NullPointerException("Ispiti ne smeju biti null");
		}
		this.rezervacije = rezervacije;
	}

	/**
	 * Vraca hash-iran objekat klase Sala.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id, kapacitet, naziv, rezervacije, tipSale);
	}

	/**
	 * Poredi dve sale i vraca true ako su iste, a false ako nisu.
	 * 
	 * Sale se porede po referenci ukoliko je isti objekat, a ako nije onda po id-u, nazivu, kapacitetu, tipu sale i rezervacijama.
	 * 
	 * @return true ako su oba objekta klase Sala i imaju iste vrednosti za id, naziv, kapacitet, tip sale i rezervacije.
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
		Sala other = (Sala) obj;
		return Objects.equals(id, other.id) && kapacitet == other.kapacitet && Objects.equals(naziv, other.naziv)
				&& Objects.equals(rezervacije, other.rezervacije) && tipSale == other.tipSale;
	}

	/**
	 * @return Vraca string sa svim podacima o sali.
	 */
	@Override
	public String toString() {
		return "Sala [id=" + id + ", naziv=" + naziv + ", kapacitet=" + kapacitet + ", tipSale=" + tipSale
				+ ", rezervacije=" + rezervacije + "]";
	}
	
	
	
	
}
