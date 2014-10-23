package Modelos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="formapago",schema="public")
@PrimaryKeyJoinColumn(name="codigo")
public class FormaPago implements Serializable{
	
	@Id
	@Column(name="codigo")
	private String codForma;
	@Column(name="descripcion")
	private String nombre;
	
	@ManyToMany(cascade = {CascadeType.ALL},mappedBy="formas")
	private Set<Factura> facturas=new HashSet();
	
	public FormaPago(String codForma, String nombre) {
		super();
		this.codForma = codForma;
		this.nombre = nombre;
	}
	
	
		
	public FormaPago() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getCodForma() {
		return codForma;
	}
	public void setCodForma(String codForma) {
		this.codForma = codForma;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
