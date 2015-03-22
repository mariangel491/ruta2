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
@Table(name="vehiculo",schema="public")
@PrimaryKeyJoinColumn(name="placa")
public class Vehiculo implements Serializable{
	
	@Id
	@Column(name="placa")
	private String placa;
	@Column(name="serial")
	private String serialCarroceria;
	/*@Column(name="marca")
	private String marca;*/
	@Column(name="anno")
	private Integer anno;
	@Column(name="nropuestos")
	private Integer nropuestos;
	@Column(name="avance")
	private String avance;
	
	/*@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "codigoavance")
	private Avance avance;*/
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="nrosocio")
	private Socio socio;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="marca")
	private Marca Marca;
	
	
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getSerialCarroceria() {
		return serialCarroceria;
	}
	public void setSerialCarroceria(String serialCarroceria) {
		this.serialCarroceria = serialCarroceria;
	}
	

	
	
	/*public Avance getAvance() {
		return avance;
	}
	public void setAvance(Avance avance) {
		this.avance = avance;
	}*/
	
	public void setSocio(Socio socio) {
		this.socio = socio;
	}
	public Socio getSocio() {
		return socio;
	}
	
	/*public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}*/
	
	
	public Integer getAnno() {
		return anno;
	}
	public void setAnno(Integer anno) {
		this.anno = anno;
	}
	
	
	public Integer getNropuestos() {
		return nropuestos;
	}
	public void setNropuestos(Integer nropuestos) {
		this.nropuestos = nropuestos;
	}
	
	
	public Marca getMarca() {
		return Marca;
	}
	public void setMarca(Marca marca) {
		Marca = marca;
	}
	
	public String getAvance() {
		return avance;
	}
	public void setAvance(String avance) {
		this.avance = avance;
	}
	
	
	
}
