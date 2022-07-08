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

@Entity
@Table (name = "sala")
public class Sala {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String naziv;
	
	private int kapacitet;
	
	private TipSale tipSale;
	
	@OneToMany(mappedBy = "sala", fetch = FetchType.LAZY)
	private List<RezervacijaSale> rezervacije;

	public Sala() {
		super();
	}

	public Sala(Long id, String naziv, int kapacitet, TipSale tipSale, List<RezervacijaSale> rezervacije) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.kapacitet = kapacitet;
		this.tipSale = tipSale;
		this.rezervacije = rezervacije;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if(id == null) {
			throw new NullPointerException("Id ne sme biti null!");
		}
		if(id <0) {
			throw new IllegalArgumentException("Id ne sme biti manji od 0");
		}
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		if(naziv == null) {
			throw new NullPointerException("Naziv ne sme biti null");
		}
		if(naziv == "" ) {
			throw new IllegalArgumentException("Naziv ne sme biti prazan string");
		}
		this.naziv = naziv;
	}

	public int getKapacitet() {
		return kapacitet;
	}

	public void setKapacitet(int kapacitet) {
		if(kapacitet<1) {
			throw new IllegalArgumentException("Kapacitet ne moze biti manji od jedne osobe");
		}
		this.kapacitet = kapacitet;
	}

	public TipSale getTipSale() {
		return tipSale;
	}

	public void setTipSale(TipSale tipSale) {
		if(tipSale == null) {
			throw new NullPointerException();
		}
		this.tipSale = tipSale;
	}

	public List<RezervacijaSale> getRezervacije() {
		return rezervacije;
	}

	public void setRezervacije(List<RezervacijaSale> rezervacije) {
		if(rezervacije == null) {
			throw new NullPointerException("Ispiti ne smeju biti null");
		}
		this.rezervacije = rezervacije;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, kapacitet, naziv, rezervacije, tipSale);
	}

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

	@Override
	public String toString() {
		return "Sala [id=" + id + ", naziv=" + naziv + ", kapacitet=" + kapacitet + ", tipSale=" + tipSale
				+ ", rezervacije=" + rezervacije + "]";
	}
	
	
	
	
}
