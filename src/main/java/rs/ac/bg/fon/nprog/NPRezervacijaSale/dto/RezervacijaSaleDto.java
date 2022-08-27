package rs.ac.bg.fon.nprog.NPRezervacijaSale.dto;

import java.util.Date;
import java.util.Objects;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.util.Rok;
import rs.ac.bg.fon.nprog.NPRezervacijaSale.util.TipIspita;

public class RezervacijaSaleDto {

	private Long id;
	
	private Rok rok;
	
	private Date datumVremeOd;
	
	private Date datumVremeDo;
	
	private int brojStudenata;
	
	private TipIspita tipIspita;
	
	private Long salaId;
	
	private Long asistentId;
	
	private Long profesorId;
	
	private Long predmetId;
	
	private Long rasporedId;

	public RezervacijaSaleDto() {
		super();
	}

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

	public Date getDatumVremeOd() {
		return datumVremeOd;
	}

	public void setDatumVremeOd(Date datumVremeOd) {
		this.datumVremeOd = datumVremeOd;
	}

	public Date getDatumVremeDo() {
		return datumVremeDo;
	}

	public void setDatumVremeDo(Date datumVremeDo) {
		this.datumVremeDo = datumVremeDo;
	}

	public int getBrojStudenata() {
		return brojStudenata;
	}

	public void setBrojStudenata(int brojStudenata) {
		this.brojStudenata = brojStudenata;
	}

	public TipIspita getTipIspita() {
		return tipIspita;
	}

	public void setTipIspita(TipIspita tipIspita) {
		this.tipIspita = tipIspita;
	}

	public Long getSalaId() {
		return salaId;
	}

	public void setSalaId(Long salaId) {
		this.salaId = salaId;
	}

	public Long getAsistentId() {
		return asistentId;
	}

	public void setAsistentId(Long asistentId) {
		this.asistentId = asistentId;
	}

	public Long getProfesorId() {
		return profesorId;
	}

	public void setProfesorId(Long profesorId) {
		this.profesorId = profesorId;
	}

	public Long getPredmetId() {
		return predmetId;
	}

	public void setPredmetId(Long predmetId) {
		this.predmetId = predmetId;
	}

	public Long getRasporedId() {
		return rasporedId;
	}

	public void setRasporedId(Long rasporedId) {
		this.rasporedId = rasporedId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(asistentId, brojStudenata, datumVremeDo, datumVremeOd, id, predmetId, profesorId,
				rasporedId, rok, salaId, tipIspita);
	}

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

	@Override
	public String toString() {
		return "RezervacijaSaleDto [id=" + id + ", rok=" + rok + ", datumVremeOd=" + datumVremeOd + ", datumVremeDo="
				+ datumVremeDo + ", brojStudenata=" + brojStudenata + ", tipIspita=" + tipIspita + ", salaId=" + salaId
				+ ", asistentId=" + asistentId + ", profesorId=" + profesorId + ", predmetId=" + predmetId
				+ ", rasporedId=" + rasporedId + "]";
	}


}
