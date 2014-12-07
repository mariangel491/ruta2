package Modelos;

import java.io.Serializable;
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
@Table(name="egresos",schema="public")
@PrimaryKeyJoinColumn(name="codegreso")
public class Egresos implements Serializable{
	
	static public String TIPO_EGRESO_PRESTAMO_FONDO_DE_CHOQUE = "Prestamos Fondo De Choque";
	static public String TIPO_EGRESO_OTROS_PRESTAMO = "Otros prestamos";
	static public String CLASIFICACION_EGRESO_RUTA = "Ruta";
	static public String CLASIFICACION_EGRESO_FONDO_DE_CHOQUE = "Fondo de Choque";
	static public String CLASIFICACION_EGRESO_ALQUILER = "Alquiler";
	
	@Id
	@Column(name="codegreso")
	private String codEgreso;
	@Column(name="descripcion")
	private String descripcion;
	//private Date fechaEgre;
	//private float montoEgre;
	@Column(name="clasificacion")
	private String clasificacion; 
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="codigoruta")
	private Ruta ruta; 
	
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="codegreso")
	private DetalleFactura detalle;

	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="codegreso")
	List<IEDetalleFactura> det;

	public Egresos() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Egresos(String codigo, String desc,String clasif) {
		
		super();
		this.codEgreso = codigo;
		this.descripcion = desc;
		//this.fechaEgre=fecha;
		//this.montoEgre=monto;
		this.clasificacion=clasif;
	}
	
	public String getCodEgreso() {
		return codEgreso;
	}
	public void setCodEgreso(String codEgreso) {
		this.codEgreso = codEgreso;
	}
	
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String desc) {
		this.descripcion = desc;
	}
	
	
	/*public Date getFechaEgre() {
		return fechaEgre;
	}
	public void setFechaEgre(Date fechaEgre) {
		this.fechaEgre = fechaEgre;
	}
	
	
	public float getMontoEgre() {
		return montoEgre;
	}
	public void setMontoEgre(float montoEgre) {
		this.montoEgre = montoEgre;
	}*/
	
	
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasif) {
		this.clasificacion = clasif;
	}


	public Ruta getRuta() {
		return ruta;
	}
	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	
}
