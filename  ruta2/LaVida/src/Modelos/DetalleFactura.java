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
	@JoinColumn(name="codfactura")
	private Factura codFactura = new Factura();
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="coddetfact")
	List<IEDetalleFactura> det;



	public String getCoddetalle() {
		return coddetalle;
	}

	public void setCoddetalle(String coddetalle) {
		this.coddetalle = coddetalle;
	}

	public Factura getCodFactura() {
		return codFactura;
	}
	
	public void setCodFactura(Factura codFactura) {
		this.codFactura = codFactura;
	}
	

}
