package Modelos;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="historialdeuda",schema="public")
@PrimaryKeyJoinColumn(name="codhistorial")
public class HistorialDeuda {

	@Id
	@Column(name="codhistorial")
	private String CodHistorial;
	@Column(name="fechaAlquiler")
	private Date FechaAlq;
	@Column(name="fechaSocio")
	private Date FechaSocio;
	
	public String getCodHistorial() {
		return CodHistorial;
	}
	public void setCodHistorial(String codHistorial) {
		CodHistorial = codHistorial;
	}
	public Date getFechaAlq() {
		return FechaAlq;
	}
	public void setFechaAlq(Date fechaAlq) {
		FechaAlq = fechaAlq;
	}
	public Date getFechaSocio() {
		return FechaSocio;
	}
	public void setFechaSocio(Date fechaSocio) {
		FechaSocio = fechaSocio;
	}
	
	/*@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="coddeudasoc")
	private Deuda deuda;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="coddeudalq")
	private DeudaAlquiler deudaAlq;*/
	
	
	
	
}
