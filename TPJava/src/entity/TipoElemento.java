package entity;

public class TipoElemento{
	
	private String nombreTipo;
	private int cantMaxRes;
	private int idTipo;
	
	public TipoElemento(int idTipo, String nombreTipo, int cantMaxRes) {
		setIdTipo(idTipo);
		setCantMaxRes(cantMaxRes);
		setNombreTipo(nombreTipo);
		
	}

	public TipoElemento() {	}

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

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	

}
