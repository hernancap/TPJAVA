package ui;

import java.util.ArrayList;
import java.util.Scanner;

import controlers.CtrlPersona;
import data.Conexion;
import entity.Persona;
import java.sql.*;

public class Principal {
	
/*	private static Scanner scan;

	public static void main(String[] args) {
				
		scan = new Scanner(System.in);
		
		
		//CtrlPersona.mostrarPersona();


		 int vid = 10; 
		 boolean vhab = false;
		 String vcat = "Nuevo";
		
		 String vdni;
		 System.out.print("dni: ");
		 vdni = scan.nextLine();
		 		 
		 String vnombre;
		 System.out.print("vnombre: ");
		 vnombre = scan.nextLine();
		 
		 String vapellido;
		 System.out.print("vapellido: ");
		 vapellido = scan.nextLine();
				 
		 String vusuario;
		 System.out.print("vusuario: ");
		 vusuario = scan.nextLine();
		 
		 String vcontraseña;
		 System.out.print("vcontraseña: ");
		 vcontraseña = scan.nextLine();
		 
		 Persona p = new Persona(vid, vdni, vnombre, vapellido, vhab, vusuario, vcontraseña, vcat);
		
		
			PreparedStatement stmt=null;
			ResultSet keyResultSet=null;
			try {
				stmt=Conexion.getInstancia().getConn()
						.prepareStatement(
						"insert into persona(dni, nombre, apellido, habilitado, usuario, contraseña, categoria) values (?,?,?,?,?,?,?)",
						PreparedStatement.RETURN_GENERATED_KEYS
						);
				stmt.setString(1, p.getDni());
				stmt.setString(2, p.getNombre());
				stmt.setString(3, p.getApellido());
				stmt.setBoolean(4, p.isHabilitado());
				stmt.setString(5, p.getUsuario());
				stmt.setString(6, p.getContraseña());
				stmt.setString(7, p.getCategoria());
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
	

		scan.close();	
	     
	      

	}
*/

}


