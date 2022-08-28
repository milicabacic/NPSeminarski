package rs.ac.bg.fon.nprog.NPRezervacijaSale.dto;

import java.util.Objects;
/**
 * Klasa AsistentDto predstavlja Dto (Domain Transfer Object) klasu za klasu Asistent.
 * 
 * Klasa AsistentDto sadrzi polja id kao long vrednost, ime i prezime kao string vrednosti.
 * 
 * @author Milica Bacic
 *
 */
public class AsistentDto {
	/**
	 * Id asistentDto objekta kao Long vrednost.
	 */
	private Long id;
	/**
	 * Ime asistentDto objekta kao String vrednost.
	 */
	private String ime;
	/**
	 * Prezime asistentDto objekta kao String vrednost.
	 */
	private String prezime;

	/**
	 * Konstruktor koji inicijalizuje objekat klase AsistentDto bez parametara.
	 */
	public AsistentDto() {
		super();
	}
	/**
	 * Konstruktor koji inicijalizuje objekat klase AsistentDto za dat id, ime i prezime.
	 */
	public AsistentDto(Long id, String ime, String prezime) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
	}

	/**
	 * 
	 * @return Vraca id objekta AsistentDto kao Long vrednost.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Postavlja id objekta AsistentDto na zadatu vrednost
	 * 
	 * @param id Id asistentDto kao Long vrednost.
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 
	 * @return Vraca ime objekta AsistentDto kao String vrednost.
	 */
	public String getIme() {
		return ime;
	}
	/**
	 * Postavlja ime objekta AsistentDto na zadatu vrednost
	 * 
	 * @param ime Ime asistentDto kao String vrednost.
	 */
	public void setIme(String ime) {
		this.ime = ime;
	}

	/**
	 * 
	 * @return Vraca prezime objekta AsistentDto kao String vrednost.
	 */
	public String getPrezime() {
		return prezime;
	}
	/**
	 * Postavlja prezime objekta AsistentDto na zadatu vrednost
	 * 
	 * @param prezime Prezime asistentDto kao String vrednost.
	 */
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	/**
	 * Vraca hash-iran objekat klase AsistentDto
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id, ime, prezime);
	}

	/**
	 * Poredi dva asistenta i vraca true ako su isti, a false ako nisu.
	 * 
	 * Asistenti se porede po referenci ukoliko je isti objekat, a ako nije onda po id-u, imenu, prezimenu i sva polja moraju biti ista.
	 * 
	 * @return true ako su oba objekta klase AsistentDto i imaju iste vrednosti za id, ime, prezime.
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
		AsistentDto other = (AsistentDto) obj;
		return Objects.equals(id, other.id) && Objects.equals(ime, other.ime) && Objects.equals(prezime, other.prezime);
	}

	/**
	 * @return Vraca string sa svim podacima o objektu AsistentDto
	 */
	@Override
	public String toString() {
		return "AssistaintDto [id=" + id + ", ime=" + ime + ", prezime=" + prezime + "]";
	}
	
	

}
