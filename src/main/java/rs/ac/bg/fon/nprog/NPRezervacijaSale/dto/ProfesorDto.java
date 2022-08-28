package rs.ac.bg.fon.nprog.NPRezervacijaSale.dto;

import java.util.Objects;
/**
 * Klasa ProfesorDto predstavlja Dto (Domain Transfer Object) klasu za klasu Profesor.
 * 
 * Klasa ProfesorDto sadrzi polja id kao long vrednost, ime i prezime kao string vrednosti.
 * 
 * @author Milica Bacic
 *
 */
public class ProfesorDto {
	/**
	 * Id profesorDto objekta kao Long vrednost.
	 */
	private Long id;
	/**
	 * Ime profesorDto objekta kao String vrednost.
	 */
	private String ime;
	/**
	 * Prezime profesorDto objekta kao String vrednost.
	 */
	private String prezime;

	/**
	 * Konstruktor koji inicijalizuje objekat klase ProfesorDto bez parametara.
	 */
	public ProfesorDto() {
		super();
	}
	/**
	 * Konstruktor koji inicijalizuje objekat klase ProfesorDto za dat id, ime i prezime.
	 */
	public ProfesorDto(Long id, String ime, String prezime) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
	}

	/**
	 * 
	 * @return Vraca id objekta ProfesorDto kao Long vrednost.
	 */
	public Long getId() {
		return id;
	}
	/**
	 * Postavlja id objekta ProfesorDto na zadatu vrednost
	 * 
	 * @param id Id profesorDto kao Long vrednost.
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 
	 * @return Vraca ime objekta ProfesorDto kao String vrednost.
	 */
	public String getIme() {
		return ime;
	}
	/**
	 * Postavlja ime objekta ProfesorDto na zadatu vrednost
	 * 
	 * @param ime Ime profesorDto kao String vrednost.
	 */
	public void setIme(String ime) {
		this.ime = ime;
	}
	/**
	 * 
	 * @return Vraca prezime objekta ProfesorDto kao String vrednost.
	 */
	public String getPrezime() {
		return prezime;
	}
	/**
	 * Postavlja prezime objekta ProfesorDto na zadatu vrednost
	 * 
	 * @param prezime Prezime profesorDto kao String vrednost.
	 */
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	/**
	 * Vraca hash-iran objekat klase ProfesorDto
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id, ime, prezime);
	}

	/**
	 * Poredi dva prefesora i vraca true ako su isti, a false ako nisu.
	 * 
	 * Profesori se porede po referenci ukoliko je isti objekat, a ako nije onda po id-u, imenu, prezimenu i sva polja moraju biti ista.
	 * 
	 * @return true ako su oba objekta klase ProfesorDto i imaju iste vrednosti za id, ime, prezime.
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
		ProfesorDto other = (ProfesorDto) obj;
		return Objects.equals(id, other.id) && Objects.equals(ime, other.ime) && Objects.equals(prezime, other.prezime);
	}

	/**
	 * @return Vraca string sa svim podacima o objektu ProfesorDto
	 */
	@Override
	public String toString() {
		return "ProfessorDto [id=" + id + ", ime=" + ime + ", prezime=" + prezime + "]";
	}
	
	
	
}
