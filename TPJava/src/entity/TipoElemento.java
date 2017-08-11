package entity;

public class TipoElemento{
	
	private String nombreTipo;
	private int cantMaxRes;
	
	public TipoElemento(String nombreTipo, int cantMaxRes) {
		setCantMaxRes(cantMaxRes);
		setNombreTipo(nombreTipo);
		
		
	}

	public int getCantMaxRes() {
		return cantMaxRes;
	}

	public void setCantMaxRes(int cantMaxRes) {
		this.cantMaxRes = cantMaxRes;
	}

	public String getNombreTipo() {
		return nombreTipo;
	}

	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}
	

}
