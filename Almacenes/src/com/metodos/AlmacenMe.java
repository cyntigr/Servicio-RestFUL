package com.metodos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.clases.Almacen;

public class AlmacenMe {

	public static List<Almacen> getAlmacenes() {

		try {
			Class.forName("org.postgresql.Driver");
			Connection conexion = Conexion.crearConexion();
			Statement sentencia = conexion.createStatement();
			ResultSet resultado = sentencia.executeQuery("SELECT * FROM almacenes");
			ArrayList<Almacen> alm = new ArrayList<Almacen>();

			while (resultado.next()) {
				alm.add(new Almacen(resultado.getInt("idalmacen"), resultado.getString("nombrealmacen")));
			}
			resultado.close();
			sentencia.close();
			conexion.close();
			return alm;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Almacen getAlmacen(int idalmacen) {

		try {
			Class.forName("org.postgresql.Driver");
			Connection conexion = Conexion.crearConexion();
			Statement sentencia = conexion.createStatement();
			ResultSet resultado = sentencia.executeQuery("SELECT * FROM almacenes where idalmacen = " + idalmacen + " ");

			while (resultado.next()) {

				Almacen alm = new Almacen(resultado.getInt("idalmacen"), resultado.getString("nombrealmacen"));
				return alm;
			}

			resultado.close();
			sentencia.close();
			conexion.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Almacen addAlmacen(Almacen alm) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conexion = Conexion.crearConexion();
			Statement sentencia = conexion.createStatement();
			sentencia.executeUpdate("INSERT INTO almacenes " + "VALUES (" + alm.getidalmacen() + ", '" + alm.getnombrealmacen() + "' )");
			sentencia.close();
			conexion.close();
			return alm;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Almacen updateAlmacen(Almacen alm) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conexion = Conexion.crearConexion();
			Statement sentencia = conexion.createStatement();
			sentencia.executeUpdate("UPDATE almacenes SET nombrealmacen = '" + alm.getnombrealmacen() + "'  WHERE idalmacen = " + alm.getidalmacen() + " ");
			sentencia.close();
			conexion.close();
			return alm;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void deleteAlmacen(int idalmacen) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conexion = Conexion.crearConexion();
			Statement sentencia = conexion.createStatement();
			sentencia.executeUpdate("DELETE  FROM almacenes WHERE idalmacen = " + idalmacen + "");
			sentencia.close();
			conexion.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
