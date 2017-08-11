package controlers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Conexion;
import entity.Persona;

public class CtrlPersona {
	
	private ArrayList<Persona> pers;
	
//	public CtrlPersona(){
//		pers= new ArrayList<Persona>();
//		pers.add(new Persona("12121212","Juan", "Perez",true, "jperez", "jperez", "usuario"));
//		pers.add(new Persona("13131313","Carlos", "Gomez",true, "cgomez", "cgomez", "usuario"));
//		pers.add(new Persona("14141414","Hernan", "Caparros",true, "hcaparros", "hcaparros", "admin"));
//		pers.add(new Persona("15151515","Walter", "Dominguez",true, "wdominguez", "wdominguez", "usuario"));
		
//	}
	
	public void add(Persona p) {
		this.pers.add(p);
	}
	
	public void delete(Persona p){
		this.pers.remove(p);
	}
	
	public void update(Persona p){
		this.delete(p);
		this.add(p);
	}
	
	public static void mostrarPersona(){
		
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Persona> pers= new ArrayList<Persona>();
		try {
			stmt = Conexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from persona");
			if(rs!=null){
				while(rs.next()){
					Persona p=new Persona();
					p.setId(rs.getInt("idpersona"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.setDni(rs.getString("dni"));
					p.setHabilitado(rs.getBoolean("habilitado"));
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
		
		
		
	    
		for(int x=0;x<pers.size();x++) {
			
			Persona pe = pers.get(x);
			 System.out.println(pe.getNombre() + pe.getApellido());
			}
	}
	

}
