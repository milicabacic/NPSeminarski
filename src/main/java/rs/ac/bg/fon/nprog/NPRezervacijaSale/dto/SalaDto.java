package rs.ac.bg.fon.nprog.NPRezervacijaSale.dto;

import java.util.Objects;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.util.TipSale;

public class SalaDto {

	private Long id;
	
	private String naziv;
	
	private int kapacitet;
	
	private TipSale tipSale;

	public SalaDto() {
		super();
	}

	public SalaDto(Long id, String naziv, int kapacitet, TipSale tipSale) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.kapacitet = kapacitet;
		this.tipSale = tipSale;
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

	public int getKapacitet() {
		return kapacitet;
	}

	public void setKapacitet(int kapacitet) {
		this.kapacitet = kapacitet;
	}

	public TipSale getTipSale() {
		return tipSale;
	}

	public void setTipSale(TipSale tipSale) {
		this.tipSale = tipSale;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, kapacitet, naziv, tipSale);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalaDto other = (SalaDto) obj;
		return Objects.equals(id, other.id) && kapacitet == other.kapacitet && Objects.equals(naziv, other.naziv)
				&& tipSale == other.tipSale;
	}

	@Override
	public String toString() {
		return "SalaDto [id=" + id + ", naziv=" + naziv + ", kapacitet=" + kapacitet + ", tipSale=" + tipSale + "]";
	}
	
	
	
}
