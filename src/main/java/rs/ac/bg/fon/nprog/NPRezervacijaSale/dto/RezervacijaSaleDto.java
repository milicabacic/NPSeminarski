package rs.ac.bg.fon.nprog.NPRezervacijaSale.dto;

import java.util.Date;
import java.util.Objects;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.util.Rok;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.util.TipIspita;
/**
 * Klasa RezervacijaSaleDto predstavlja Dto (Domain Transfer Object) klasu za klasu RezervacijaSale.
 * 
 * Klasa RezervacijaSaleDto sadrzi polja id, rok, datumVremeOd, datumVremeDo, brojStudenata, tipIspita, salaId, asistentId, profesorId, predmetId, rasporedId.
 * 
 * @author Milica Bacic
 *
 */
public class RezervacijaSaleDto {
	/**
	 * Id RezervacijaSaleDto objekta kao Long vrednost.
	 */
	private Long id;
	/**
	 * Rok u kome se rezervise sala kao enum vrednost.
	 */
	private Rok rok;
	/**
	 * Datum i vreme od kada vazi rezervacija sale kao Date vrednost.
	 */
	private Date datumVremeOd;
	/**
	 * Datum i vreme do kada vazi rezervacija sale kao Date vrednost.
	 */
	private Date datumVremeDo;
	/**
	 * Broj studenata koji polaze ispit za datu rezervaciju sale kao int vrednost.
	 */
	private int brojStudenata;
	/**
	 * Tip ispita koji se polaze u rezervaciji sale kao enum vrednost.
	 */
	private TipIspita tipIspita;
	/**
	 * Id sale koja se rezervise kao Long vrednost.
	 */
	private Long salaId;
	/**
	 * Id asistenta koji dezura u rezervisanoj sali kao Long vrednost.
	 */
	private Long asistentId;
	/**
	 * Id profesora koji dezura u rezervisanoj sali kao Long vrednost.
	 */
	private Long profesorId;
	/**
	 * Id predmeta ciji ispit se odrzava u sali kao Long vrednost.
	 */
	private Long predmetId;
	/**
	 * Id rasporeda ispita kome data rezervacija pripada kao Long vrednost.
	 */
	private Long rasporedId;
	/**
	 * Konstruktor koji inicijalizuje objekat klase RezervacijaSaleDto bez parametara.
	 */
	public RezervacijaSaleDto() {
		super();
	}
	/**
	 * Konstruktor koji inicijalizuje objekat klase RezervacijaSaleDto za dat id, rok, datumVremeOd, datumVremeDo, brojStudenata, tipIspita, salaId, asistentId, profesorId, predmetId i rasporedIspitaId.
	 */
	public RezervacijaSaleDto(Long id, Rok rok, Date datumVremeOd, Date datumVremeDo, int brojStudenata,
			TipIspita tipIspita, Long salaId, Long asistentId, Long profesorId, Long predmetId, Long rasporedId) {
		super();
		this.id = id;
		this.rok = rok;
		this.datumVremeOd = datumVremeOd;
		this.datumVremeDo = datumVremeDo;
		this.brojStudenata = brojStudenata;
		this.tipIspita = tipIspita;
		this.salaId = salaId;
		this.asistentId = asistentId;
		this.profesorId = profesorId;
		this.predmetId = predmetId;
		this.rasporedId = rasporedId;
	}
	/**
	 * 
	 * @return Vraca id objekta RezervacijaSaleDto kao Long vrednost.
	 */
	public Long getId() {
		return id;
	}
	/**
	 * Postavlja id objekta RezervacijaSaleDto na zadatu vrednost
	 * 
	 * @param id Id RezevacijaSaleDto objekta kao Long vrednost.
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 
	 * @return Vraca rok za koji se sala rezervise kao enum vrednost.
	 */
	public Rok getRok() {
		return rok;
	}
	/**
	 * Postavlja rok za koji se sala rezervise na zadatu vrednost.
	 * 
	 * @param rok Rok za koji se sala rezervise kao enum vrednost.
	 */
	public void setRok(Rok rok) {
		this.rok = rok;
	}
	/**
	 * 
	 * @return Vraca datum i vreme od kada vazi rezervacija sale kao Date vrednost.
	 */
	public Date getDatumVremeOd() {
		return datumVremeOd;
	}
	/**
	 * Postavlja datum i vreme od kada vazi rezervacija sale na zadatu vrednost.
	 * 
	 * @param datumVremeOd Datum i vreme od kada vazi rezervacija sale
	 */
	public void setDatumVremeOd(Date datumVremeOd) {
		this.datumVremeOd = datumVremeOd;
	}
	/**
	 * 
	 * @return Vraca datum i vreme do kada vazi rezervacija sale kao Date vrednost.
	 */
	public Date getDatumVremeDo() {
		return datumVremeDo;
	}
	/**
	 * Postavlja datum i vreme do kada vazi rezervacija sale na zadatu vrednost.
	 * 
	 * @param datumVremeDo Datum i vreme do kada vazi rezervacija sale
	 */
	public void setDatumVremeDo(Date datumVremeDo) {
		this.datumVremeDo = datumVremeDo;
	}
	/**
	 * 
	 * @return Vraca broj studenata koji polaze ispit za datu rezervaciju sale kao int vrednost.
	 */
	public int getBrojStudenata() {
		return brojStudenata;
	}
	/**
	 * Postavlja broj studenata za rezervaciju sale na zadatu vrednost.
	 * 
	 * @param brojStudenata Broj studenata koji polaze ispit za datu rezervaciju sale kao int vrednost
	 */
	public void setBrojStudenata(int brojStudenata) {
		this.brojStudenata = brojStudenata;
	}
	/**
	 * 
	 * @return Vraca tip ispita koji se polaze kod rezervacije sale kao enum vrednost.
	 */
	public TipIspita getTipIspita() {
		return tipIspita;
	}
	/**
	 * Postavlja tip ispita koji se polaze na zadatu vrednost
	 * 
	 * @param tipIspita Tip ispita koji se polaze za datu rezervaciju sale kao enum vrednost
	 */
	public void setTipIspita(TipIspita tipIspita) {
		this.tipIspita = tipIspita;
	}
	/**
	 * 
	 * @return Vraca id sale za koju se vrsi rezervacija kao Long vrednost.
	 */
	public Long getSalaId() {
		return salaId;
	}
	/**
	 * Postavlja id sale za koju se vrsi rezervacija na zadatu vrednost
	 * 
	 * @param salaId Id sale za koju se vrsi rezervacija kao Long vrednost
	 */
	public void setSalaId(Long salaId) {
		this.salaId = salaId;
	}
	/**
	 * 
	 * @return Vraca id dezurnog asistenta za rezervaciju sale kao Long vrednost
	 */
	public Long getAsistentId() {
		return asistentId;
	}
	/**
	 * Postavlja id dezurnog asistenta za rezervaciju sale na zadatu vrednost
	 * 
	 * @param asistentId Id dezurnog asistenta kao Long vrednost
	 */
	public void setAsistentId(Long asistentId) {
		this.asistentId = asistentId;
	}
	/**
	 * 
	 * @return Vraca id dezurnog profesora za rezervaciju sale kao Long vrednost
	 */
	public Long getProfesorId() {
		return profesorId;
	}
	/**
	 * Postavlja id dezurnog profesora na zadatu vrednost
	 * 
	 * @param profesorId Id dezurnog profesora kao Long vrednost
	 */
	public void setProfesorId(Long profesorId) {
		this.profesorId = profesorId;
	}
	/**
	 * 
	 * @return Vraca id predmeta ciji ispit se odrzava u rezervaciji sale kao Long vrednost.
	 */
	public Long getPredmetId() {
		return predmetId;
	}
	/**
	 * Postavlja id predmeta ciji ispit se odrzava na zadatu vrednost
	 * 
	 * @param predmetId Id predmeta ciji ispit se odrzava kao Long vrednost
	 */
	public void setPredmetId(Long predmetId) {
		this.predmetId = predmetId;
	}
	/**
	 * 
	 * @return Vraca id rasporeda ispita kome rezervacija sale pripada kao Long vrednost
	 */
	public Long getRasporedId() {
		return rasporedId;
	}
	/**
	 * Postavlja id rasporeda ispita kome rezervacija pripada na zadatu vrednost
	 * 
	 * @param rasporedId Id rasporeda ispita kao Long vrednost
	 */
	public void setRasporedId(Long rasporedId) {
		this.rasporedId = rasporedId;
	}
	/**
	 * Vraca hash-iran objekat klase RezervacijaSaleDto
	 */
	@Override
	public int hashCode() {
		return Objects.hash(asistentId, brojStudenata, datumVremeDo, datumVremeOd, id, predmetId, profesorId,
				rasporedId, rok, salaId, tipIspita);
	}
	/**
	 * Poredi dve rezervacije sale i vraca true ako su iste, a false ako nisu.
	 * 
	 * Rezervacije sale se porede po referenci ukoliko je isti objekat, a ako nije onda po svim ulaznim parametrima
	 * 
	 * @return true ako su oba objekta klase RezervacijaSaleDto i imaju iste vrednosti za ulazne parametre.
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
		RezervacijaSaleDto other = (RezervacijaSaleDto) obj;
		return Objects.equals(asistentId, other.asistentId) && brojStudenata == other.brojStudenata
				&& Objects.equals(datumVremeDo, other.datumVremeDo) && Objects.equals(datumVremeOd, other.datumVremeOd)
				&& Objects.equals(id, other.id) && Objects.equals(predmetId, other.predmetId)
				&& Objects.equals(profesorId, other.profesorId) && Objects.equals(rasporedId, other.rasporedId)
				&& rok == other.rok && Objects.equals(salaId, other.salaId) && tipIspita == other.tipIspita;
	}
	/**
	 * @return Vraca string sa svim podacima o objektu RezervacijaSaleDto
	 */
	@Override
	public String toString() {
		return "RezervacijaSaleDto [id=" + id + ", rok=" + rok + ", datumVremeOd=" + datumVremeOd + ", datumVremeDo="
				+ datumVremeDo + ", brojStudenata=" + brojStudenata + ", tipIspita=" + tipIspita + ", salaId=" + salaId
				+ ", asistentId=" + asistentId + ", profesorId=" + profesorId + ", predmetId=" + predmetId
				+ ", rasporedId=" + rasporedId + "]";
	}


}
