package rs.ac.bg.fon.nprog.NPRezervacijaSale.domain;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.util.Rok;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.util.TipIspita;
/**
 * Klasa koja predstavlja rezervaciju sale ispita na fakultetu za odrednjeni rok.
 * 
 * Rezervacija sale za ispit ima id, datum i vreme od, datum i vreme do, broj studenata, tip ispita, salu, dezurnog asistenta, dezurnog profesora, predmet i raspored ispita kom pripada.
 * 
 * @author Milica Bacic
 *
 */
@Entity
@Table (name = "rezervacijaSale")
public class RezervacijaSale {

	/**
	 * Id rezervacije sale ispita kao long vrednost koja je oznacena kao id i generise se samostalno.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * Rok u kom se rezervise sala kao enum vrednost Rok.
	 */
	private Rok rok;
	
	/**
	 * Datum i vreme od kog je sala rezervisana.
	 */
	private Date datumVremeOd;
	
	/**
	 * Datum i vreme do kada je sala rezervisana.
	 */
	private Date datumVremeDo;
	/**
	 * Broj studenata koji polaze ispit za datu rezervaciju sale.
	 */
	private int brojStudenata;
	
	/**
	 * Tip ispita koji se polaze kao enum vrednost TipIspita.
	 */
	private TipIspita tipIspita;
	/**
	 * Sala za koju se vrsi rezervacija sale.
	 */
	@ManyToOne(fetch = FetchType.EAGER, optional =  false)
	@JoinColumn (name = "salaId")
	private Sala sala;
	/**
	 * Asistent koji dezura za datu rezervaciju sale za ispit.
	 */
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn (name = "asistentId")
	private Asistent asistent;
	/**
	 * Profesor koji dezura za datu rezervaciju sale za ispit.
	 */
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn (name = "profesorId")
	private Profesor profesor;
	/**
	 * Predmet koji se polaze za datu rezervaciju sale za ispit.
	 */
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn (name = "predmetId")
	private Predmet predmet;
	/**
	 * Raspored ispita kome pripada data rezervacija sale.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name = "rasporedId")
	private RasporedIspita raspored;

	/**
	 * Konstruktor koji inicijalizuje objekat klase RezervacijaSale bez parametara.
	 */
	public RezervacijaSale() {
		super();
	}

	/**
	 * Konstruktor koji inicijalizuje objekat klase RezervacijaSale sa datim vrednostima za id,rok,datumVremeOd, datumVremeDo, brojStudenata, tipIspita, salu, asistenta, profesora, predmet i raspored ispita.
	 */
	public RezervacijaSale(Long id, Rok rok, Date datumVremeOd, Date datumVremeDo, int brojStudenata,
			TipIspita tipIspita, Sala sala, Asistent asistent, Profesor profesor, Predmet predmet,
			RasporedIspita raspored) {
		super();
		this.id = id;
		this.rok = rok;
		this.datumVremeOd = datumVremeOd;
		this.datumVremeDo = datumVremeDo;
		this.brojStudenata = brojStudenata;
		this.tipIspita = tipIspita;
		this.sala = sala;
		this.asistent = asistent;
		this.profesor = profesor;
		this.predmet = predmet;
		this.raspored = raspored;
	}

	/**
	 * 
	 * @return Vraca vrednost id rezervacijse sale kao Long vrednost.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Postavlja id rezervacije sale na zadatu vrednost.
	 * 
	 * @param id Id rezervacije kao Long vrednost.
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
	 * @return Vraca rok u kom se rezervise sala kao enum vrednost Rok.
	 */
	public Rok getRok() {
		return rok;
	}

	/**
	 * Postavlja vrednost roka rezervacije sale na zadatu vrednost.
	 * 
	 * @param rok Rok rezervacije sale kao enum vrednost Rok.
	 */
	public void setRok(Rok rok) {
		if(rok == null) {
			throw new NullPointerException();
		}
		this.rok = rok;
	}

	/**
	 * 
	 * @return Vraca datum i vreme od kada je sala rezervisana.
	 */
	public Date getDatumVremeOd() {
		return datumVremeOd;
	}

	/**
	 * Postavlja vrednost za datum i vreme od kada je sala rezervisana na zadatu vrednost.
	 * 
	 * @param datumVremeOd Datum i vreme od kada je sala rezervisana kao Date vrednost.
	 * 
	 * @throws java.lang.IllegalArgumentException ako je datum i vreme null ili ako je zadat datum i vreme u proslosti
	 */
	public void setDatumVremeOd(Date datumVremeOd) {
		if (datumVremeOd == null || datumVremeOd.getTime() < new Date().getTime()) {
			throw new IllegalArgumentException("Ispit se ne moze odrzati u proslosti!");
		}
		this.datumVremeOd = datumVremeOd;
	}

	/**
	 * 
	 * @return Vraca datum i vreme do kada je sala rezervisana.
	 */
	public Date getDatumVremeDo() {
		return datumVremeDo;
	}

	/**
	 * Postavlja vrednost za datum i vreme do kada je sala rezervisana na zadatu vrednost.
	 * 
	 * @param datumVremeDo Datum i vreme do kada je sala rezervisana kao Date vrednost.
	 * 
	 * @throws java.lang.IllegalArgumentException ako je datum i vreme null ili ako je zadat datum i vreme u proslosti 
	 * @throws java.lang.IllegalArgumentException ako je datum i vreme do pre datuma i vremena od
	 */
	public void setDatumVremeDo(Date datumVremeDo) {
		if (datumVremeDo == null || datumVremeDo.getTime() < new Date().getTime()) {
			throw new IllegalArgumentException("Ispit se ne moze zavrsiti u proslosti!");
		}
		if(datumVremeDo.before(datumVremeOd)) {
			throw new IllegalArgumentException("Ispit se ne moze zavrsiti pre nego sto je poceo");
		}
		this.datumVremeDo = datumVremeDo;
	}

	/**
	 * 
	 * @return Vraca broj studenata za rezervaciju sale kao int vrednost.
	 */
	public int getBrojStudenata() {
		return brojStudenata;
	}

	/**
	 * Postavlja broj studenata za rezervaciju sale na zadatu vrednost.
	 * 
	 * @param brojStudenata Broj studenata kao int vrednost
	 * 
	 * @throws java.lang.IllegalArgumentException ako je broj studenata manji od 1 ili ako je broj studenata veci od kapaciteta sale
	 */
	public void setBrojStudenata(int brojStudenata) {
		if(brojStudenata <1) {
			throw new IllegalArgumentException("Broj studenata na ispitu ne moze biti manji od 1");
		}
		if(brojStudenata > this.getSala().getKapacitet()) {
			throw new IllegalArgumentException("Broj studenata ne sme biti veci od kapaciteta sale");
		}
		this.brojStudenata = brojStudenata;
	}

	/**
	 * 
	 * @return Vraca tip ispita kao enum vrednost TipIspita.
	 */
	public TipIspita getTipIspita() {
		return tipIspita;
	}

	/**
	 * Postavlja tip ispita na zadatu vrednost.
	 * 
	 * @param tipIspita Tip ispita kao enum vrednost TipIspita.
	 * 
	 * @throws java.lang.NullPointerException ako je tip ispita null
	 */
	public void setTipIspita(TipIspita tipIspita) {
		if(tipIspita == null) {
			throw new NullPointerException();
		}
		this.tipIspita = tipIspita;
	}

	/**
	 * 
	 * @return Vraca salu kao objekat klase Sala.
	 */
	public Sala getSala() {
		return sala;
	}

	/**
	 * Postavlja salu na zadatu vrednost.
	 * 
	 * @param sala Sala rezervacije sale kao objekat klase Sala.
	 * 
	 * @throws java.lang.NullPointerException ako je sala null
	 */
	public void setSala(Sala sala) {
		if(sala == null) {
			throw new NullPointerException("Sala ne sme biti null");
		}
		this.sala = sala;
	}

	/**
	 * 
	 * @return Vraca dezurnog asistenta kao objekat klase Asistent.
	 */
	public Asistent getAsistent() {
		return asistent;
	}

	/**
	 * Postavlja vrednost dezurnog asistenta na zadatu vrednost.
	 * 
	 * @param asistent Dezurni asistent kao objekat klase Asistent.
	 * 
	 * @throws java.lang.NullPointerException ako je asistent null
	 */
	public void setAsistent(Asistent asistent) {
		if(asistent == null) {
			throw new NullPointerException("Asistent ne sme biti null");
		}
		this.asistent = asistent;
	}

	/**
	 * 
	 * @return Vraca dezurnog profesora kao objekat klase Profesor.
	 */
	public Profesor getProfesor() {
		return profesor;
	}

	/**
	 * Postavlja vrednost dezurnog profesora na zadatu vrednost.
	 * 
	 * @param profesor Dezurni profesor kao objekat klase Profesor.
	 * 
	 * @throws java.lang.NullPointerException ako je profesor null
	 */
	public void setProfesor(Profesor profesor) {
		if(profesor == null) {
			throw new NullPointerException("Profesor ne sme biti null");
		}
		this.profesor = profesor;
	}

	/**
	 * 
	 * @return Vraca predmet koji se polaze kao objekat klase Predmet.
	 */
	public Predmet getPredmet() {
		return predmet;
	}

	/**
	 * Postavlja vrednost predmeta na zadatu vrednost.
	 * 
	 * @param predmet Predmet koji se polaze kao objekat klase Predmet.
	 * 
	 * @throws java.lang.NullPointerException ako je predmet null
	 */
	public void setPredmet(Predmet predmet) {
		if(predmet == null) {
			throw new NullPointerException("Predmet ne sme biti null");
		}
		this.predmet = predmet;
	}

	/**
	 * 
	 * @return Vraca raspored ispita kome pripada rezervacija sale kao objekat klase RasporedIspita.
	 */
	public RasporedIspita getRaspored() {
		return raspored;
	}

	/**
	 * Postavlja vrednost rasporeda ispita kome pripada rezervacija sale na zadatu vrednost.
	 * 
	 * @param raspored Raspored ispita kome pripada rezervacija sale kao objekat klase RasporedIspita.
	 * 
	 * @throws java.lang.NullPointerException ako je raspored null
	 */
	public void setRaspored(RasporedIspita raspored) {
		if(raspored == null) {
			throw new NullPointerException("Raspored ne sme biti null");
		}
		this.raspored = raspored;
	}

	/**
	 * Vraca hash-iran objekat klase RezervacijaSale
	 */
	@Override
	public int hashCode() {
		return Objects.hash(asistent, brojStudenata, datumVremeDo, datumVremeOd, id, predmet, profesor, raspored, rok,
				sala, tipIspita);
	}

	/**
	 * Poredi dve rezervacije sale i vraca true ako su iste, a false ako nisu.
	 * 
	 * Rezervacije sale se porede po referenci ukoliko je isti objekat, a ako nije onda po id-u, roku, datum i vremenu od, datumu i vremenu do, broju studenata, tipu ispita, sali, asistentu, profesoru, predmetu i rasporedu ispita.
	 * @return true ako su oba objekta klase RasporedIspita i imaju iste vrednosti za sve ulazne parametre.
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
		RezervacijaSale other = (RezervacijaSale) obj;
		return Objects.equals(asistent, other.asistent) && brojStudenata == other.brojStudenata
				&& Objects.equals(datumVremeDo, other.datumVremeDo) && Objects.equals(datumVremeOd, other.datumVremeOd)
				&& Objects.equals(id, other.id) && Objects.equals(predmet, other.predmet)
				&& Objects.equals(profesor, other.profesor) && Objects.equals(raspored, other.raspored)
				&& rok == other.rok && Objects.equals(sala, other.sala) && tipIspita == other.tipIspita;
	}

	/**
	 * @return Vraca string sa svim podacima o rezervaciji sale.
 	 */
	@Override
	public String toString() {
		return "RezervacijaSale [id=" + id + ", rok=" + rok + ", datumVremeOd=" + datumVremeOd + ", datumVremeDo="
				+ datumVremeDo + ", brojStudenata=" + brojStudenata + ", tipIspita=" + tipIspita + ", sala=" + sala
				+ ", asistent=" + asistent + ", profesor=" + profesor + ", predmet=" + predmet + ", raspored="
				+ raspored + "]";
	}
	
	
}
