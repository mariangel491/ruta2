package Modelos;

import java.io.Serializable;
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
@Table(name="ingresos",schema="public")
@PrimaryKeyJoinColumn(name="codingreso")
public class Ingresos implements Serializable{
	
	static public String TIPO_INGRESO_RUTA="Ruta";
	static public String TIPO_INGRESO_FONDO_DE_CHOQUE="Fondo de Choque";
	static public String TIPO_INGRESO_ALQUILER="Alquiler";
	
	@Id
	@Column(name="codingreso", nullable=false)
	private String codIngreso;
	@Column(name="descripcion")
	private String descripcion;
	//private Date fechaIng;
	//private float montoIng;
	@Column(name="clasificacion")
	private String clasifIngreso;
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="codigoruta")
	private Ruta ruta;
	@Column(name="fechaingreso")
	private Date fechaIng;
	@Column(name="monto", nullable=false)
	private float monto;
	
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Historial historial;
	
	/*@OneToOne
	@JoinColumn(name="codingreso")
	private DetalleFactura detalle;*/
	
	public Ingresos() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ingresos(String codigo, String desc, String clasif) {
		
		super();
		this.codIngreso = codigo;
		this.descripcion = desc;
		//this.fechaIng=fec;
		//this.montoIng=monto;
		this.clasifIngreso=clasif;
	}
	
	
	public String getCodIngreso() {
		return codIngreso;
	}
	public void setCodIngreso(String codigo) {
		this.codIngreso = codigo;
	}
	
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String desc) {
		this.descripcion = desc;
	}
	
	public Date getFechaIng() {
		return fechaIng;
	}
	public void setFechaIng(Date fechaIng) {
		this.fechaIng = fechaIng;
	}
	public String getClasifIngreso() {
		return clasifIngreso;
	}
	public void setClasifIngreso(String clasifIngreso) {
		this.clasifIngreso = clasifIngreso;
	}
	
	
	public Ruta getRuta() {
		return ruta;
	}
	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}
	/*public Historial getCodHistorial() {
		return CodHistorial;
	}
	public void setCodHistorial(Historial codHistorial) {
		CodHistorial = codHistorial;
	}*/
/*	public DetalleFactura getDetalle() {
		return detalle;
	}
	public void setDetalle(DetalleFactura detalle) {
		this.detalle = detalle;
	}*/
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
/*	public List<Historial> getCodHistorial() {
		return CodHistorial;
	}
	public void setCodHistorial(List<Historial> codHistorial) {
		CodHistorial = codHistorial;
	}*/
	public Historial getHistorial() {
		return historial;
	}
	public void setHistorial(Historial historial) {
		this.historial = historial;
	}
	
	
	
	
	
	
	
	
	
	
}
