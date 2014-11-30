package Modelos;



import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="detallefactura",schema="public")
@PrimaryKeyJoinColumn(name="coddetalle")
public class DetalleFactura {
	
	@Id
	@Column(name="coddetalle")
	private String coddetalle;
	
	/*@OneToOne
	@JoinColumn(name="codegreso")
	private Egresos egreso;*/
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="codegreso")
	List<Egresos> egresos;
	
	/*@OneToOne
	@JoinColumn(name="codingreso")
	private Ingresos ingreso;*/
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="codingreso")
	List<Ingresos> ingresos;
	
	@OneToOne
	@JoinColumn(name="codfactura")
	private Factura codFactura = new Factura();



/*	public List<Ingresos> getIngresos() {
		return Ingresos;
	}

	public void setIngresos(List<Ingresos> ingresos) {
		Ingresos = ingresos;
	}*/


	public String getCoddetalle() {
		return coddetalle;
	}

	public void setCoddetalle(String coddetalle) {
		this.coddetalle = coddetalle;
	}

	public Factura getCodFactura() {
		return codFactura;
	}

	public List<Egresos> getEgresos() {
		return egresos;
	}

	public void setEgresos(List<Egresos> egresos) {
		this.egresos = egresos;
	}

	public List<Ingresos> getIngresos() {
		return ingresos;
	}

	public void setIngresos(List<Ingresos> ingresos) {
		this.ingresos = ingresos;
	}

	public void setCodFactura(Factura codFactura) {
		this.codFactura = codFactura;
	}
	

}
