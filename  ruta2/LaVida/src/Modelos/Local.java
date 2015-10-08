package Modelos;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="local",schema="public")
@PrimaryKeyJoinColumn(name="codigoLocal")
public class Local implements Serializable{

	@Id
	@Column(name="codigolocal")
	private String codLocal;
	@Column(name="nombre")
	private String nombre;
	@Column(name="status")
	private String status;
	@Column(name="tipo")
	private String tipo;
	@Column(name="canon")
	private float canon;
	@Column(name="nrolocal")
	private String nrolocal;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="codruta")
	private Ruta ruta;
	
	@OneToOne(cascade= CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Alquiler alquiler;
	
	public Local() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Local(String codLocal, String nombre, String status, String tipo, float canon) {
		super();
		this.codLocal = codLocal;
		this.nombre = nombre;
		this.status = status;
		this.tipo = tipo;
		this.canon = canon;
	}


	public String getCodLocal() {
		return codLocal;
	}
	public void setCodLocal(String codigo) {
		this.codLocal = codigo;
	}
	

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Ruta getRuta() {
		return ruta;
	}
	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getCanon() {
		return canon;
	}

	public void setCanon(float canon) {
		this.canon = canon;
	}

	public String getNrolocal() {
		return nrolocal;
	}

	public void setNrolocal(String nrolocal) {
		this.nrolocal = nrolocal;
	}

	
	
}
