package controlers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import data.Conexion;
import entity.Elemento;
import entity.Persona;
import entity.Reserva;
import entity.TipoElemento;

public class CtrlElemento {
	
private ArrayList<Elemento> elem;

	
	public ArrayList<Elemento>  buscarElemento(String fechaSelec, String teSelec, int tiempoRes){
		
		ArrayList<Elemento> elemDisp = new ArrayList<Elemento>();

		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=Conexion.getInstancia().getConn().prepareStatement("Select ele.idelemento, ele.nombre from elementos ele "
					+ "inner Join tipos tip on ele.tipoElem = tip.nombre "
					+ "left join reservas res on res.idElementos = ele.idelemento"
					+ " and (? Between res.fechayhora and Date_Add(res.fechayhora, INTERVAL res.tiempoUso HOUR)"
					+ "or Date_Add(?, INTERVAL ? HOUR) between res.fechayhora And Date_Add(res.fechayhora, INTERVAL res.tiempoUso HOUR))"
							+ "where res.idreservas is null and tip.nombre = ?");

			stmt.setString(1, fechaSelec);
			stmt.setString(2, fechaSelec);
			stmt.setInt(3, tiempoRes);
			stmt.setString(4, teSelec);
			rs = stmt.executeQuery();

		
			if(rs != null){
				while(rs.next()){
					Elemento e = new Elemento();
					e.setTipo(new TipoElemento());
					e.getTipo().setNombreTipo(teSelec);
					e.setIdElem(rs.getInt("ele.idelemento"));
					e.setNombre(rs.getString("ele.nombre"));					
					elemDisp.add(e);

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
		
	return elemDisp;

}
	
	public void add(Elemento el) {
		this.elem.add(el);
	}
	
	public void delete(Elemento el){
		this.elem.remove(el);
	}
	
	public void update(Elemento el){
		this.delete(el);
		this.add(el);
	}

}
