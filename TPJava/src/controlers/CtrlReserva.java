package controlers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import data.Conexion;
import entity.Elemento;
import entity.Reserva;
import entity.TipoElemento;

public class CtrlReserva {
	
	
	private ArrayList<Reserva> res;

	
	
	
	public ArrayList<Reserva> mostrarReservas(){
		
		
		
		
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Reserva> tipos= new ArrayList<Reserva>();
		try {
			stmt = Conexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from reservas");
			if(rs!=null){
				while(rs.next()){
					Reserva r =new Reserva();
					r.setId(rs.getInt("idreservas"));

					r.setDetalle(rs.getString("detalle"));
					tipos.add(r);
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
		
		

		
		
		
		return res;

}
	
	public void nuevaReserva(){

	
/*		Reserva r = new Reserva(); 
		
		
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try {
			stmt=Conexion.getInstancia().getConn()
					.prepareStatement(
					"insert into Reserva( , , , ,) values (?,?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			stmt.setString(1, r.get());
			stmt.setString(2, r.get());
			stmt.setString(3, r.get());
			stmt.setBoolean(4, r.());
			stmt.setString(5, r.get());
			stmt.setString(6, r.get());
			stmt.setString(7, r.get());
			stmt.executeUpdate();
			keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()){
				p.setId(keyResultSet.getInt(1));
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


*/	
    
     

}


}
