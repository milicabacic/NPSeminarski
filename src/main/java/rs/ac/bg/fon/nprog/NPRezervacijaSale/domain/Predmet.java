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

@Entity
@Table (name = "predmet")
public class Predmet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String naziv;
	
	private int espb;
	
	@OneToMany(mappedBy = "predmet" , fetch = FetchType.LAZY)
	private List<RezervacijaSale> ispiti;

	public Predmet() {
		super();
	}

	public Predmet(Long id, String naziv, int espb, List<RezervacijaSale> ispiti) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.espb = espb;
		this.ispiti = ispiti;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if(id == null) {
			throw new NullPointerException("Id ne sme biti null!");
		}
		if(id < 0) {
			throw new IllegalArgumentException("Id ne sme biti manji od 0");
		}
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		if(naziv == null) {
			throw new NullPointerException("Naziv ne sme biti null!");
		}
		if(naziv == "" ) {
			throw new IllegalArgumentException("Naziv ne sme biti prazan string");
		}
		this.naziv = naziv;
	}

	public int getEspb() {
		return espb;
	}

	public void setEspb(int espb) {
		if(espb<1) {
			throw new IllegalArgumentException("Broj ESPB bodova ne sme biti manji od 0");
		}
		this.espb = espb;
	}

	public List<RezervacijaSale> getIspiti() {
		return ispiti;
	}

	public void setIspiti(List<RezervacijaSale> ispiti) {
		if(ispiti == null) {
			throw new NullPointerException("Ispiti ne smeju biti null!");
		}
		this.ispiti = ispiti;
	}

	@Override
	public int hashCode() {
		return Objects.hash(espb, id, ispiti, naziv);
	}

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

	@Override
	public String toString() {
		return "Predmet [id=" + id + ", naziv=" + naziv + ", espb=" + espb + ", ispiti=" + ispiti + "]";
	}
	
	
	
}
