package controlers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Conexion;
import entity.Persona;

public class CtrlPersona {
	
	private ArrayList<Persona> pers;
	
	public CtrlPersona(){
		pers= new ArrayList<Persona>();
	}
	
	public CtrlPersona(String a){}

	
	public void add(Persona p) {
		
		this.pers.add(p);
		System.out.println(pers.get(0).getNombre());
		System.out.println(pers.get(0).getNombre());

	}
	
	public void delete(Persona p){
		this.pers.remove(p);
	}
	
	public void update(Persona p){
		this.delete(p);
		this.add(p);
	}
	


	
	
	public ArrayList<Persona> mostrarPersona(){
		
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Persona> pers= new ArrayList<Persona>();
		try {
			stmt = Conexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from personas");
			if(rs!=null){
				while(rs.next()){
					Persona p=new Persona();
					p.setId(rs.getInt("idpersona"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.setDni(rs.getString("dni"));
					p.setHabilitado(rs.getInt("habilitado"));
					pers.add(p);
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		

		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			Conexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			
			e.printStackTrace();
}
		
		
		

		return pers;
	}
	

	

}
