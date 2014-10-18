package Modelos;

import java.util.Date;
import java.util.List;

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
@Table(name="historial",schema="public")
@PrimaryKeyJoinColumn(name="codhistorial")
public class Historial {
	
	@Id
	@Column(name="codhistorial")
	private String CodHistorial;
	@Column(name="monto")
	private float Monto;
	@Column(name="fecha")
	private Date Fecha;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="codingre")
	//List<Ingresos> ingresos;
	private Ingresos ingresos;
	
	
	public String getCodHistorial() {
		return CodHistorial;
	}

	public void setCodHistorial(String codHistorial) {
		CodHistorial = codHistorial;
	}

	public float getMonto() {
		return Monto;
	}

	public void setMonto(float monto) {
		Monto = monto;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
/*
public List<Ingresos> getIngresos() {
		return ingresos;
	}

	public void setIngresos(List<Ingresos> ingresos) {
		this.ingresos = ingresos;
	}*/

	public Ingresos getIngresos() {
		return ingresos;
	}

	public void setIngresos(Ingresos ingresos) {
		this.ingresos = ingresos;
	}
	
	
	
	
}
