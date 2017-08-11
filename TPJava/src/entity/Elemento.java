package entity;

public class Elemento extends TipoElemento {
	
	private String nombre;
	
	public Elemento(String nombre, String nombreTipo, int cantMaxRes){		
		super(nombreTipo, cantMaxRes);
		setNombre(nombre);
		
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
