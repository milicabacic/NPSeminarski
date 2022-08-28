package rs.ac.bg.fon.nprog.NPRezervacijaSale.dto;

import java.util.Objects;
/**
 * Klasa PredmetDto predstavlja Dto (Domain Transfer Object) klasu za klasu Predmet.
 * 
 * Klasa ProfesorDto sadrzi polja id kao long vrednost, naziv i espb bodove.
 * 
 * @author Milica Bacic
 *
 */
public class PredmetDto {
	/**
	 * Id PredmetDto objekta kao Long vrednost.
	 */
	private Long id;
	/**
	 * Naziv predmeta PredmetDto objekta kao String vrednost.
	 */
	private String naziv;
	/**
	 * Broj espb bodova koje predmet nosi kao int vrednost.
	 */
	private int espb;
	/**
	 * Konstruktor koji inicijalizuje objekat klase PredmetDto bez parametara.
	 */
	public PredmetDto() {
		super();
	}
	/**
	 * Konstruktor koji inicijalizuje objekat klase PredmetDto za dat id, naziv i espb.
	 */
	public PredmetDto(Long id, String naziv, int espb) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.espb = espb;
	}
	/**
	 * 
	 * @return Vraca id objekta PredmetDto kao Long vrednost.
	 */
	public Long getId() {
		return id;
	}
	/**
	 * Postavlja id objekta PredmetDto na zadatu vrednost
	 * 
	 * @param id Id PredmetDto objekta kao Long vrednost.
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 
	 * @return Vraca naziv predmeta objekta PredmetDto kao String vrednost.
	 */
	public String getNaziv() {
		return naziv;
	}
	/**
	 * Postavlja naziv predmeta objekta PredmetDto na zadatu vrednost
	 * 
	 * @param naziv Naziv predmeta kao String vrednost.
	 */
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	/**
	 * 
	 * @return Vraca broj espb bodova objekta PredmetDto kao int vrednost.
	 */
	public int getEspb() {
		return espb;
	}
	/**
	 * Postavlja broj espb bodova objekta PredmetDto na zadatu vrednost
	 * 
	 * @param espb Broj espb bodova kao String vrednost.
	 */
	public void setEspb(int espb) {
		this.espb = espb;
	}
	/**
	 * Vraca hash-iran objekat klase PredmetDto
	 */
	@Override
	public int hashCode() {
		return Objects.hash(espb, id, naziv);
	}
	/**
	 * Poredi dva predmeta i vraca true ako su isti, a false ako nisu.
	 * 
	 * Predmeti se porede po referenci ukoliko je isti objekat, a ako nije onda po id-u, nazivu i espb bodovima i sva polja moraju biti ista.
	 * 
	 * @return true ako su oba objekta klase PredmetDto i imaju iste vrednosti za id, naziv, espb.
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
		PredmetDto other = (PredmetDto) obj;
		return espb == other.espb && Objects.equals(id, other.id) && Objects.equals(naziv, other.naziv);
	}
	/**
	 * @return Vraca string sa svim podacima o objektu PredmetDto
	 */
	@Override
	public String toString() {
		return "PredmetDto [id=" + id + ", naziv=" + naziv + ", espb=" + espb + "]";
	}
	
	
	
}
