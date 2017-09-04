package controlers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Conexion;
import entity.Persona;
import entity.TipoElemento;

public class CtrlTipoElem {
	
	private ArrayList<TipoElemento> tipos;
	
	public void add(TipoElemento te) {
		this.tipos.add(te);
	}
	
	public void delete(TipoElemento te){
		this.tipos.remove(te);
	}
	
	public void update(TipoElemento te){
		this.delete(te);
		this.add(te);
	}
	
	public ArrayList<TipoElemento> mostrarTipos(){
		
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<TipoElemento> tipos= new ArrayList<TipoElemento>();
		try {
			stmt = Conexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from tipos");
			if(rs!=null){
				while(rs.next()){
					TipoElemento te =new TipoElemento();
					te.setIdTipo(rs.getInt("idtipo"));
					te.setCantMaxRes(rs.getInt("cantMaxRes"));
					te.setNombreTipo(rs.getString("nombre"));
					tipos.add(te);
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
		return tipos;

}
	
}
