package rs.ac.bg.fon.nprog.NPRezervacijaSale.domain;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.util.Rok;

@Entity
@Table (name = "rasporedIspita")
public class RasporedIspita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Rok rok;
	
	@OneToMany()
	List<RezervacijaSale> ispiti;

	public RasporedIspita() {
		super();
	}

	public RasporedIspita(Long id, Rok rok, List<RezervacijaSale> ispiti) {
		super();
		this.id = id;
		this.rok = rok;
		this.ispiti = ispiti;
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

	public List<RezervacijaSale> getIspiti() {
		return ispiti;
	}

	public void setIspiti(List<RezervacijaSale> ispiti) {
		if(ispiti == null) {
			throw new NullPointerException("Ispiti ne smeju biti null");
		}
		this.ispiti = ispiti;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, ispiti, rok);
	}

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

	@Override
	public String toString() {
		return "RasporedIspita [id=" + id + ", rok=" + rok + ", ispiti=" + ispiti + "]";
	}
	
	
	
}
