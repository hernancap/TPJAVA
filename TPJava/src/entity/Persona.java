package entity;

public class Persona {
	
	private int id;
	private String dni;
	private String nombre;
	private String apellido;
	private String usuario;
	private String contraseña;
	private boolean habilitado;
	private String categoria;
	
	public Persona (int id,String dni, String nombre, String apellido, boolean habilitado, String usuario, String contraseña, String categoria){
		this.setId(id);
		this.setDni(dni);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setHabilitado(habilitado);
		this.setUsuario(usuario);
		this.setContraseña(contraseña);
		this.setCategoria(categoria);
	}
	
	public Persona (){};
	
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public boolean isHabilitado() {
		return habilitado;
	}
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}
	


}
