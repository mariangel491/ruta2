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
	
	@OneToOne
	@JoinColumn(name="codegreso")
	private Egresos egreso;
	
	@OneToOne
	@JoinColumn(name="codingreso")
	private Ingresos ingreso;
	
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


	public Egresos getEgreso() {
		return egreso;
	}

	public void setEgresos(Egresos egreso) {
		this.egreso = egreso;
	}

	public void setCodFactura(Factura codFactura) {
		this.codFactura = codFactura;
	}
	
	
	public Ingresos getIngreso() {
		return ingreso;
	}

	public void setIngreso(Ingresos ingreso) {
		this.ingreso = ingreso;
	}

}
