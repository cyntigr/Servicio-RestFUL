package com.almacen.dao;

//Por Cintia García Ruiz 2018

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.clase.almacen.model.Almacen;
import com.clase.almacen.model.Conexion;


public class AlmacenMe {
	
	public AlmacenMe() {
	}
	public static List<Almacen> getListaAlmacen() {

		try {
			Class.forName("org.postgresql.Driver");
			Connection conexion = Conexion.crearConexion();
			Statement sentencia = conexion.createStatement();
			ResultSet resultado = sentencia.executeQuery("SELECT * FROM almacenes");
			List<Almacen> listaAlmacen = new ArrayList<Almacen>();

			while (resultado.next()) {
				listaAlmacen.add(new Almacen(resultado.getInt("idalmacen"), resultado.getString("nombrealmacen")));
			}
			resultado.close();
			sentencia.close();
			conexion.close();
			return listaAlmacen;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

	public static List<Almacen> obtenerAlmacenes(){
		List<Almacen> listaAlmacenes = getListaAlmacen();
		return listaAlmacenes;
	}

	public static List<Almacen> buscarPorNombre(String nombreAlmacen) {


			try {
				Class.forName("org.postgresql.Driver");
				Connection conexion = Conexion.crearConexion();
				Statement sentencia = conexion.createStatement();
				ResultSet resultado = sentencia
						.executeQuery("SELECT * FROM almacenes where nombrealmacen = '"  + nombreAlmacen +  "' ");	
				List<Almacen> lista = new ArrayList<Almacen>();
				while (resultado.next()) {
					lista.add(new Almacen(resultado.getInt("idalmacen"), resultado.getString("nombrealmacen")));
					
				}

				resultado.close();
				sentencia.close();
				conexion.close();
				return lista;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	
	
	public static Almacen obtenerAlmacen(int idAlmacen){

		try {
			Class.forName("org.postgresql.Driver");
			Connection conexion = Conexion.crearConexion();
			Statement sentencia = conexion.createStatement();
			ResultSet resultado = sentencia
					.executeQuery("SELECT * FROM almacenes where idalmacen = " + idAlmacen + " ");

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
	
	public static int guardarAlmacen(Almacen almacen) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conexion = Conexion.crearConexion();
			Statement sentencia = conexion.createStatement();
			sentencia.executeUpdate("INSERT INTO almacenes " + "VALUES (" + almacen.getidAlmacen() + ", '"
					+ almacen.getnombreAlmacen() + "' )");
			sentencia.close();
			conexion.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return almacen.getidAlmacen();
	}
	
	public static boolean actualizarAlmacen(Almacen alm) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conexion = Conexion.crearConexion();
			Statement sentencia = conexion.createStatement();
			sentencia.executeUpdate("UPDATE almacenes SET nombrealmacen = '" + alm.getnombreAlmacen()
					+ "'  WHERE idalmacen = " + alm.getidAlmacen() + " ");
			sentencia.close();
			conexion.close();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean eliminarAlmacen(int idAlmacen) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conexion = Conexion.crearConexion();
			Statement sentencia = conexion.createStatement();
			sentencia.executeUpdate("DELETE  FROM almacenes WHERE idalmacen = " + idAlmacen + "");
			sentencia.close();
			conexion.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
