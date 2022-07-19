package rs.ac.bg.fon.nprog.NPRezervacijaSale.dto;

import java.util.Objects;

public class PredmetDto {

	private Long id;
	
	private String naziv;
	
	private int espb;

	public PredmetDto() {
		super();
	}

	public PredmetDto(Long id, String naziv, int espb) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.espb = espb;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getEspb() {
		return espb;
	}

	public void setEspb(int espb) {
		this.espb = espb;
	}

	@Override
	public int hashCode() {
		return Objects.hash(espb, id, naziv);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PredmetDto other = (PredmetDto) obj;
		return espb == other.espb && Objects.equals(id, other.id) && Objects.equals(naziv, other.naziv);
	}

	@Override
	public String toString() {
		return "PredmetDto [id=" + id + ", naziv=" + naziv + ", espb=" + espb + "]";
	}
	
	
	
}
