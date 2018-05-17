package com.metodos;

//Por Cintia García Ruiz 2018

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.clases.Articulos;

public class ArticuloMe {
	public static List<Articulos> getArticulos() {

		try {
			Class.forName("org.postgresql.Driver");
			Connection conexion = Conexion.crearConexion();
			Statement sentencia = conexion.createStatement();
			ResultSet resultado = sentencia.executeQuery("SELECT * FROM articulos");
			ArrayList<Articulos> art = new ArrayList<Articulos>();

			while (resultado.next()) {
				art.add(new Articulos(resultado.getInt("codarticulo"), resultado.getString("nombrearticulo"), resultado.getDouble("pcoste"), resultado.getDouble("pventa")));

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

	public static Articulos getArticulo(int codarticulo) {

		try {
			Class.forName("org.postgresql.Driver");
			Connection conexion = Conexion.crearConexion();
			Statement sentencia = conexion.createStatement();
			ResultSet resultado = sentencia.executeQuery("SELECT * FROM articulos where codarticulo = " + codarticulo + " ");

			while (resultado.next()) {
				Articulos art = new Articulos(resultado.getInt("codarticulo"), resultado.getString("nombrearticulo"), resultado.getDouble("pcoste"), resultado.getDouble("pventa"));
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

	public static void addArticulo(Articulos art) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conexion = Conexion.crearConexion();
			Statement sentencia = conexion.createStatement();
			sentencia.executeUpdate("INSERT INTO articulos " + "VALUES (" + art.getcodarticulo() + ", '" + art.getnombrearticulo() + "'," + art.getpcoste() + "," + art.getpventa() + " )");
			sentencia.close();
			conexion.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void updateArticulo(Articulos art) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conexion = Conexion.crearConexion();
			Statement sentencia = conexion.createStatement();
			sentencia.executeUpdate("UPDATE articulos SET nombrearticulo = '"+ art.getnombrearticulo() +"' , pcoste = "+ art.getpcoste() +" , pventa = "+ art.getpventa() +"  WHERE codarticulo = " + art.getcodarticulo() + "");
			sentencia.close();
			conexion.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteArticulo(int codarticulo) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conexion = Conexion.crearConexion();
			Statement sentencia = conexion.createStatement();
			sentencia.executeUpdate("DELETE  FROM articulos WHERE codarticulo = " + codarticulo + "");
			sentencia.close();
			conexion.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
