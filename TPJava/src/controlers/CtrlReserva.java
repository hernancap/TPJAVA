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

	
	public ArrayList<Reserva> buscarReserva(String fechaSelec, String textDet, String teSelec){
		
		
		
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		ArrayList<Reserva> tipos= new ArrayList<Reserva>();
		try {
			stmt=Conexion.getInstancia().getConn().prepareStatement("select tiempoUso, fechayhora, nomElem from reservas "
					+ "where nomTipo = ?");
			stmt.setString(1, teSelec);
			rs = stmt.executeQuery();
		
			if(rs != null){
				while(rs.next()){
					ArrayList<Elemento> lista = new ArrayList<Elemento>();
					Elemento e = new Elemento();
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
					r.setNomElem(rs.getString("nomElem"));
					r.setNomTipo(rs.getString("nomTipo"));
					r.setFechayhora(rs.getString("fechayhora"));
					r.setTiempoUso(rs.getInt("tiempoUso"));
					r.setIdUsuario(rs.getInt("idUsuario"));
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
	
	 public Date sumarRestarHorasFecha(Date fecha, int horas){


		       Calendar calendar = Calendar.getInstance();



		       calendar.setTime(fecha); // Configuramos la fecha que se recibe



		       calendar.add(Calendar.HOUR, horas);  // numero de horas a añadir, o restar en caso de horas<0


		       return calendar.getTime(); // Devuelve el objeto Date con las nuevas horas añadidas


		  }


}
