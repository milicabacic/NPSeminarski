package rs.ac.bg.fon.nprog.NPRezervacijaSale.dto;

import java.util.Objects;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.util.TipSale;
/**
 * Klasa SalaDto predstavlja Dto (Domain Transfer Object) klasu za klasu Sala.
 * 
 * Klasa SalaDto sadrzi polja id kao long vrednost, naziv, kapacitet i tip sale.
 * 
 * @author Milica Bacic
 *
 */
public class SalaDto {
	/**
	 * Id SalaDto objekta kao Long vrednost.
	 */
	private Long id;
	/**
	 * Naziv sale SalaDto objekta kao String vrednost.
	 */
	private String naziv;
	/**
	 * Kapacitet sale kao int vrednost.
	 */
	private int kapacitet;
	/**
	 * Tip sale kao enum vrednost TipSale.
	 */
	private TipSale tipSale;
	/**
	 * Konstruktor koji inicijalizuje objekat klase SalaDto bez parametara.
	 */
	public SalaDto() {
		super();
	}
	/**
	 * Konstruktor koji inicijalizuje objekat klase SalaDto za dat id, naziv, kapacitet i tip sale.
	 */
	public SalaDto(Long id, String naziv, int kapacitet, TipSale tipSale) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.kapacitet = kapacitet;
		this.tipSale = tipSale;
	}
	/**
	 * 
	 * @return Vraca id objekta SalaDto kao Long vrednost.
	 */
	public Long getId() {
		return id;
	}
	/**
	 * Postavlja id objekta SalaDto na zadatu vrednost
	 * 
	 * @param id Id SalaDto objekta kao Long vrednost.
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 
	 * @return Vraca naziv sale objekta SalaDto kao String vrednost.
	 */
	public String getNaziv() {
		return naziv;
	}
	/**
	 * Postavlja naziv sale objekta SalaDto na zadatu vrednost
	 * 
	 * @param naziv Naziv sale kao String vrednost.
	 */
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	/**
	 * 
	 * @return Vraca kapacitet sale objekta SalaDto kao int vrednost.
	 */
	public int getKapacitet() {
		return kapacitet;
	}
	/**
	 * Postavlja kapacitet sale objekta SalaDto na zadatu vrednost
	 * 
	 * @param kapacitet Kapacitet sale kao int vrednost.
	 */
	public void setKapacitet(int kapacitet) {
		this.kapacitet = kapacitet;
	}
	/**
	 * 
	 * @return Vraca tip sale kao enum vrednost TipSale.
	 */
	public TipSale getTipSale() {
		return tipSale;
	}
	/**
	 * Postavlja tip sale na zadatu vrednost.
	 * 
	 * @param tipSale Tip sale kao enum vrendost TipSale.
	 */
	public void setTipSale(TipSale tipSale) {
		this.tipSale = tipSale;
	}
	/**
	 * Vraca hash-iran objekat klase SalaDto
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id, kapacitet, naziv, tipSale);
	}
	/**
	 * Poredi dve sale i vraca true ako su iste, a false ako nisu.
	 * 
	 * Sale se porede po referenci ukoliko je isti objekat, a ako nije onda po id-u, nazivu, kapacitetu i tipu sale i sva polja moraju biti ista.
	 * 
	 * @return true ako su oba objekta klase SalaDto i imaju iste vrednosti za id, naziv, kapacitet i tip sale.
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
		SalaDto other = (SalaDto) obj;
		return Objects.equals(id, other.id) && kapacitet == other.kapacitet && Objects.equals(naziv, other.naziv)
				&& tipSale == other.tipSale;
	}

	/**
	 * @return Vraca string sa svim podacima o objektu SalaDto
	 */
	@Override
	public String toString() {
		return "SalaDto [id=" + id + ", naziv=" + naziv + ", kapacitet=" + kapacitet + ", tipSale=" + tipSale + "]";
	}
	
	
	
}
