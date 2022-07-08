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
@Table (name = "asistent")
public class Asistent {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String ime;
	
	private String prezime;

	@OneToMany(mappedBy = "asistent" , fetch = FetchType.LAZY)
	private List<RezervacijaSale> dezurstva;

	
	public Asistent() {
		super();
	}


	public Asistent(Long id, String ime, String prezime, List<RezervacijaSale> dezurstva) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.dezurstva = dezurstva;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		if(id == null) {
			throw new NullPointerException("Id ne sme biti null!");
		}
		if(id<0) {
			throw new IllegalArgumentException("Id ne sme biti manji od 0");
		}
		this.id = id;
	}


	public String getIme() {
		return ime;
	}


	public void setIme(String ime) {
		if(ime == null) {
			throw new NullPointerException("Ime ne sme biti null");
		}
		if(ime == "" ) {
			throw new IllegalArgumentException("Ime ne sme biti prazan string");
		}
		this.ime = ime;
	}


	public String getPrezime() {
		return prezime;
	}


	public void setPrezime(String prezime) {
		if(prezime == null) {
			throw new NullPointerException("Prezime ne sme biti null");
		}
		if(prezime == "" ) {
			throw new IllegalArgumentException("Prezime ne sme biti prazan string");
		}
		this.prezime = prezime;
	}


	public List<RezervacijaSale> getDezurstva() {
		return dezurstva;
	}


	public void setDezurstva(List<RezervacijaSale> dezurstva) {
		if(dezurstva == null) {
			throw new NullPointerException("Dezurstva ne smeju biti null");
		}
		this.dezurstva = dezurstva;
	}


	@Override
	public int hashCode() {
		return Objects.hash(dezurstva, id, ime, prezime);
	}


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


	@Override
	public String toString() {
		return "Asistent [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", dezurstva=" + dezurstva + "]";
	}

	
	
	
}
