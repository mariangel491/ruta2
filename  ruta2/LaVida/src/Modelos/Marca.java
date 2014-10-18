package Modelos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="marcavehiculo",schema="public")
@PrimaryKeyJoinColumn(name="codigo")
public class Marca implements Serializable {
	
		
		@Id
		@Column(name="codigo")
		private String codMarca;
		@Column(name="descripcion")
		private String descripcion;
		
		@OneToMany(cascade= CascadeType.ALL)
		@JoinColumn(name="marca")
		List<Vehiculo> vehiculos;
		
		@OneToMany(cascade= CascadeType.ALL)
		@JoinColumn(name="marca")
		List<VehiculoArrendatario> vehiculoArren;
		
		

		public Marca() {
			super();
			// TODO Auto-generated constructor stub
		}

	
		
		public String getCodMarca() {
			return codMarca;
		}

		public void setCodMarca(String codMarca) {
			this.codMarca = codMarca;
		}





		public String getDescripcion() {
			return descripcion;
		}

		public List<Vehiculo> getVehiculos() {
			return vehiculos;
		}


		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public void setVehiculos(List<Vehiculo> vehiculos) {
			this.vehiculos = vehiculos;
		}

		
		
}
