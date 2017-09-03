package entity;

public class Reserva {
	
	private int id;
	private String nomElem;
	private String nomTipo;
	private String fechayhora;
	private int tiempoUso;
	private int idUsuario;
	private String detalle;
	
	public Reserva (int id,String nomElem, String nomTipo, String fechayhora, int tiempoUso, int idUsuario, String detalle){
		
		this.setId(id);
		this.setNomElem(nomElem);
		this.setNomTipo(nomTipo);
		this.setFechayhora(fechayhora);
		this.setTiempoUso(tiempoUso);
		this.setIdUsuario(idUsuario);
		this.setDetalle(detalle);
		

	}
	
	public Reserva(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomElem() {
		return nomElem;
	}

	public void setNomElem(String nomElem) {
		this.nomElem = nomElem;
	}

	public String getNomTipo() {
		return nomTipo;
	}

	public void setNomTipo(String nomTipo) {
		this.nomTipo = nomTipo;
	}

	public String getFechayhora() {
		return fechayhora;
	}

	public void setFechayhora(String fechayhora) {
		this.fechayhora = fechayhora;
	}

	public int getTiempoUso() {
		return tiempoUso;
	}

	public void setTiempoUso(int tiempoUso) {
		this.tiempoUso = tiempoUso;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	};

}
