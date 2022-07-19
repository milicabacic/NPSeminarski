package rs.ac.bg.fon.nprog.NPRezervacijaSale.dto;

import java.util.Objects;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.util.Rok;

public class RasporedIspitaDto {

	private Long id;
	
	private Rok rok;

	public RasporedIspitaDto() {
		super();
	}

	public RasporedIspitaDto(Long id, Rok rok) {
		super();
		this.id = id;
		this.rok = rok;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Rok getRok() {
		return rok;
	}

	public void setRok(Rok rok) {
		this.rok = rok;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, rok);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RasporedIspitaDto other = (RasporedIspitaDto) obj;
		return Objects.equals(id, other.id) && rok == other.rok;
	}

	@Override
	public String toString() {
		return "RasporedIspitaDto [id=" + id + ", rok=" + rok + "]";
	}
	
	
	
}
