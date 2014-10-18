package Vistas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Modelos.Avance;


public class vTablaAvance extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static String[] titulos = { "Cód.", "Nombre", "Apellido", "Cédula", "Dirección", "Teléfono", "Fecha Ingreso" };
	private List<Avance> avances;
	
	public vTablaAvance(List<Avance> avances) {
		super();
		this.avances= avances;
	}
	

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return titulos.length;
	}
	
	@Override
	public String getColumnName(int column) {
		return titulos[column];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return avances.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
				
		Avance av = avances.get(rowIndex);
		switch (columnIndex){
		case 0:return av.getCodAvance();
		case 1:return av.getNombre();
		case 2:return av.getApellido();
		case 3:return av.getCedula();
		case 4:return av.getDireccion();
		case 5:return av.getTelefono();
		case 6:return av.getFechaIngreso();
		}
		return null;
	}

}
