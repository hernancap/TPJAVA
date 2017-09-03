package entity;

public class Elemento extends TipoElemento {
	
	private String nombre;
	private int IdElem;
	
	public Elemento(int IdElem, int idTipos, String nombre, String nombreTipo, int cantMaxRes){		
		super(idTipos, nombreTipo, cantMaxRes);
		setNombre(nombre);
		setIdElem(IdElem);
		
	}
	
	public Elemento(String nombre){
		
		setNombre(nombre);

		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdElem() {
		return IdElem;
	}

	public void setIdElem(int idElem) {
		IdElem = idElem;
	}
	
	

}
