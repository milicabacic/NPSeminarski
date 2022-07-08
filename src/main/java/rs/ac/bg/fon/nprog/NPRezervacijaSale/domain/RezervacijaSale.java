package rs.ac.bg.fon.nprog.NPRezervacijaSale.domain;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.util.Rok;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.util.TipIspita;

@Entity
@Table (name = "rezervacijaSale")
public class RezervacijaSale {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Rok rok;
	
	private Date datumVremeOd;
	
	private Date datumVremeDo;
	
	private int brojStudenata;
	
	private TipIspita tipIspita;
	
	@ManyToOne
	@JoinColumn (name = "salaId")
	private Sala sala;
	
	@ManyToOne
	@JoinColumn (name = "asistentId")
	private Asistent asistent;
	
	@ManyToOne
	@JoinColumn (name = "profesorId")
	private Profesor profesor;
	
	@ManyToOne
	@JoinColumn (name = "predmetId")
	private Predmet predmet;
	
	@ManyToOne
	@JoinColumn (name = "rasporedId")
	private RasporedIspita raspored;

	public RezervacijaSale() {
		super();
	}

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if (id == null) {
			throw new NullPointerException("Id ne sme biti null!");
		}
		if(id<0) {
			throw new IllegalArgumentException("Id ne sme biti manji od 0");
		}
		this.id = id;
	}

	public Rok getRok() {
		return rok;
	}

	public void setRok(Rok rok) {
		if(rok == null) {
			throw new NullPointerException();
		}
		this.rok = rok;
	}

	public Date getDatumVremeOd() {
		return datumVremeOd;
	}

	public void setDatumVremeOd(Date datumVremeOd) {
		if (datumVremeOd == null || datumVremeOd.getTime() < new Date().getTime()) {
			throw new IllegalArgumentException("Ispit se ne moze odrzati u proslosti!");
		}
		this.datumVremeOd = datumVremeOd;
	}

	public Date getDatumVremeDo() {
		return datumVremeDo;
	}

	public void setDatumVremeDo(Date datumVremeDo) {
		if (datumVremeDo == null || datumVremeDo.getTime() < new Date().getTime()) {
			throw new IllegalArgumentException("Ispit se ne moze zavrsiti u proslosti!");
		}
		if(datumVremeDo.after(datumVremeOd)) {
			throw new IllegalArgumentException("Ispit se ne moze zavrsiti pre nego sto je poceo");
		}
		this.datumVremeDo = datumVremeDo;
	}

	public int getBrojStudenata() {
		return brojStudenata;
	}

	public void setBrojStudenata(int brojStudenata) {
		if(brojStudenata <1) {
			throw new IllegalArgumentException("Broj studenata na ispitu ne moze biti manji od 1");
		}
		if(brojStudenata > this.getSala().getKapacitet()) {
			throw new IllegalArgumentException("Broj studenata ne sme biti veci od kapaciteta sale");
		}
		this.brojStudenata = brojStudenata;
	}

	public TipIspita getTipIspita() {
		return tipIspita;
	}

	public void setTipIspita(TipIspita tipIspita) {
		if(tipIspita == null) {
			throw new NullPointerException();
		}
		this.tipIspita = tipIspita;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		if(sala == null) {
			throw new NullPointerException("Sala ne sme biti null");
		}
		this.sala = sala;
	}

	public Asistent getAsistent() {
		return asistent;
	}

	public void setAsistent(Asistent asistent) {
		if(asistent == null) {
			throw new NullPointerException("Asistent ne sme biti null");
		}
		this.asistent = asistent;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		if(profesor == null) {
			throw new NullPointerException("Profesor ne sme biti null");
		}
		this.profesor = profesor;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		if(predmet == null) {
			throw new NullPointerException("Predmet ne sme biti null");
		}
		this.predmet = predmet;
	}

	public RasporedIspita getRaspored() {
		return raspored;
	}

	public void setRaspored(RasporedIspita raspored) {
		if(raspored == null) {
			throw new NullPointerException("Raspored ne sme biti null");
		}
		this.raspored = raspored;
	}

	@Override
	public int hashCode() {
		return Objects.hash(asistent, brojStudenata, datumVremeDo, datumVremeOd, id, predmet, profesor, raspored, rok,
				sala, tipIspita);
	}

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

	@Override
	public String toString() {
		return "RezervacijaSale [id=" + id + ", rok=" + rok + ", datumVremeOd=" + datumVremeOd + ", datumVremeDo="
				+ datumVremeDo + ", brojStudenata=" + brojStudenata + ", tipIspita=" + tipIspita + ", sala=" + sala
				+ ", asistent=" + asistent + ", profesor=" + profesor + ", predmet=" + predmet + ", raspored="
				+ raspored + "]";
	}
	
	
}
