package controlers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Conexion;
import entity.Persona;
import entity.Reserva;

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
					p.setUsuario(rs.getString("usuario"));
					p.setContraseña(rs.getString("contraseña"));
					p.setCategoria(rs.getString("categoria"));
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
	
	public void eliminarPer(Persona usuario){

	
		
		
		PreparedStatement stmt=null;

			try {
				stmt=Conexion.getInstancia().getConn()
						.prepareStatement(
						"delete from personas where idpersona = ?"

						);
			stmt.setInt(1, usuario.getId());
			stmt.executeUpdate();				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(stmt!=null)stmt.close();
				Conexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		
	}
	
	public void nuevaPersona(Persona per, boolean editar){
		
		if (editar == false){
		
		
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try {
			stmt=Conexion.getInstancia().getConn()
					.prepareStatement(
					"insert into personas(dni, nombre , apellido, habilitado, usuario, contraseña, categoria)"
					+ " values (?,?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			stmt.setString(1, per.getDni());
			stmt.setString(2, per.getNombre());
			stmt.setString(3, per.getApellido());
			stmt.setInt(4, per.getHabilitado());
			stmt.setString(5, per.getUsuario());
			stmt.setString(6, per.getContraseña());
			stmt.setString(7, per.getCategoria());
			stmt.executeUpdate();
			keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()){
				per.setId(keyResultSet.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(keyResultSet!=null)keyResultSet.close();
			if(stmt!=null)stmt.close();
			Conexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		} else{
			
			
			PreparedStatement stmt=null;

				try {
					stmt=Conexion.getInstancia().getConn()
							.prepareStatement(
							"update personas set  dni =?, nombre= ?,apellido =?, habilitado=?, usuario=?,"
							+ "contraseña=?,categoria=? where idpersona = ?;"


							);
				
				stmt.setString(1, per.getDni());
				stmt.setString(2, per.getNombre());
				stmt.setString(3, per.getApellido());
				stmt.setInt(4, per.getHabilitado());
				stmt.setString(5, per.getUsuario());
				stmt.setString(6, per.getContraseña());
				stmt.setString(7, per.getCategoria());
				stmt.setInt(8, per.getId());

				stmt.executeUpdate();

				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					if(stmt!=null)stmt.close();
					Conexion.getInstancia().releaseConn();
				} catch (SQLException e) {
					e.printStackTrace();
				}


			
		}
	
    
	}  

}

	


