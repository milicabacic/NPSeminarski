package rs.ac.bg.fon.nprog.NPRezervacijaSale.dto;

import java.util.Objects;

public class ProfesorDto {

	private Long id;
	
	private String ime;
	
	private String prezime;

	public ProfesorDto() {
		super();
	}

	public ProfesorDto(Long id, String ime, String prezime) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, ime, prezime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfesorDto other = (ProfesorDto) obj;
		return Objects.equals(id, other.id) && Objects.equals(ime, other.ime) && Objects.equals(prezime, other.prezime);
	}

	@Override
	public String toString() {
		return "ProfessorDto [id=" + id + ", ime=" + ime + ", prezime=" + prezime + "]";
	}
	
	
	
}
