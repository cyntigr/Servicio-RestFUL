package com.almacen.dao;

//Por Cintia García Ruiz 2018

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.clase.almacen.model.Articulo;
import com.clase.almacen.model.Conexion;

public class ArticuloMe {
	public static List<Articulo> getListaArticulo() {

		try {
			Class.forName("org.postgresql.Driver");
			Connection conexion = Conexion.crearConexion();
			Statement sentencia = conexion.createStatement();
			ResultSet resultado = sentencia.executeQuery("SELECT * FROM articulos");
			ArrayList<Articulo> art = new ArrayList<Articulo>();

			while (resultado.next()) {
				art.add(new Articulo(resultado.getInt("codarticulo"), resultado.getString("nombrearticulo"), resultado.getDouble("pcoste"), resultado.getDouble("pventa")));

			}
			resultado.close();
			sentencia.close();
			conexion.close();
			return art;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<Articulo> obtenerArticulos(){
		List<Articulo> listaArticulos = getListaArticulo();
		return listaArticulos;
	}
	public static List<Articulo> buscarPorNombre(String nombreArticulo) {

		try {
			Class.forName("org.postgresql.Driver");
			Connection conexion = Conexion.crearConexion();
			Statement sentencia = conexion.createStatement();
			ResultSet resultado = sentencia.executeQuery("SELECT * FROM articulos where nombrearticulo = '" + nombreArticulo + "' ");
			List<Articulo> lista = new ArrayList<Articulo>();
			while (resultado.next()) {
				lista.add(new Articulo(resultado.getInt("codarticulo"), resultado.getString("nombrearticulo"), resultado.getDouble("pcoste"), resultado.getDouble("pventa")));
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
	public static Articulo obtenerArticulo(int codarticulo) {

		try {
			Class.forName("org.postgresql.Driver");
			Connection conexion = Conexion.crearConexion();
			Statement sentencia = conexion.createStatement();
			ResultSet resultado = sentencia.executeQuery("SELECT * FROM articulos where codarticulo = " + codarticulo + " ");

			while (resultado.next()) {
				Articulo art = new Articulo(resultado.getInt("codarticulo"), resultado.getString("nombrearticulo"), resultado.getDouble("pcoste"), resultado.getDouble("pventa"));
				return art;
			}
			resultado.close();
			sentencia.close();
			conexion.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int guardarArticulo(Articulo art) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conexion = Conexion.crearConexion();
			Statement sentencia = conexion.createStatement();
			sentencia.executeUpdate("INSERT INTO articulos " + "VALUES (" + art.getcodArticulo() + ", '" + art.getnombreArticulo() + "'," + art.getpCoste() + "," + art.getpVenta() + " )");
			sentencia.close();
			conexion.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return art.getcodArticulo();
	}

	public static boolean actualizarArticulo(Articulo art) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conexion = Conexion.crearConexion();
			Statement sentencia = conexion.createStatement();
			sentencia.executeUpdate("UPDATE articulos SET nombrearticulo = '"+ art.getnombreArticulo() +"' , pcoste = "+ art.getpCoste() +" , pventa = "+ art.getpVenta() +"  WHERE codarticulo = " + art.getcodArticulo() + "");
			sentencia.close();
			conexion.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean eliminarArticulo(int codarticulo) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conexion = Conexion.crearConexion();
			Statement sentencia = conexion.createStatement();
			sentencia.executeUpdate("DELETE  FROM articulos WHERE codarticulo = " + codarticulo + "");
			sentencia.close();
			conexion.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
