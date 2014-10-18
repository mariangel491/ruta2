package Utilidades;

public class Utilidades {
	
	public static String completar(String pTexto, String pCaracter, int pLongitud, boolean pInsertarAntes) {
		String nuevoTexto = "";
		String relleno    = "";
		
		if (null == pTexto){
			pTexto = "";
		}
		nuevoTexto = pTexto.toString();
		
		if (pTexto.length() < pLongitud) {
			for (int i = 1; i <= pLongitud - pTexto.length(); i++) {
				relleno = relleno + pCaracter;
			}
		} else {
			nuevoTexto = pTexto.substring(0, pLongitud);
		}
		
		if (pInsertarAntes){
			nuevoTexto = relleno + nuevoTexto;
		} else {
			nuevoTexto = nuevoTexto + relleno;
		}
		return nuevoTexto; 
	}

}