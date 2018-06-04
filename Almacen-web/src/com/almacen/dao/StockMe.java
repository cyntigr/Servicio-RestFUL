package com.almacen.dao;

// * Por Cintia García Ruiz 2018
// * Aqui recogemos los métodos que luego utilizaremos para hacer el servicio

// * estan Get , put , post , delete y get especial para acceder a un dato concreto.
// * He necesitado varias librerías como postgresql-42.2.2 , gson-2.2.4 , genson-1.4 para pasar a 
// * Json y hacer los accesos a la base de datos con jdbc.

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.clase.almacen.model.Conexion;
import com.clase.almacen.model.Stock;

public class StockMe {

	public StockMe() {
	}

	public static List<Stock> getListaStock() {

		try {
			Class.forName("org.postgresql.Driver");
			Connection conexion = Conexion.crearConexion();
			Statement sentencia = conexion.createStatement();
			ResultSet resultado = sentencia.executeQuery("SELECT * FROM stock");
			ArrayList<Stock> stk = new ArrayList<Stock>();

			while (resultado.next()) {
				stk.add(new Stock(resultado.getInt("idalmacen"), resultado.getInt("codarticulo"),
						resultado.getInt("stock")));
			}
			resultado.close();
			sentencia.close();
			conexion.close();
			return stk;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<Stock> obtenerStocks() {
		List<Stock> listaStocks = getListaStock();
		return listaStocks;
	}

	public static List<Stock> buscarPorNombre(int idalmacen) {

		try {
			Class.forName("org.postgresql.Driver");
			Connection conexion = Conexion.crearConexion();
			Statement sentencia = conexion.createStatement();
			ResultSet resultado = sentencia.executeQuery("SELECT * FROM stock where idalmacen = " + idalmacen + " ");
			List<Stock> lista = new ArrayList<Stock>();
			while (resultado.next()) {
				lista.add(new Stock(resultado.getInt("idalmacen"), resultado.getInt("codarticulo"),
						resultado.getInt("stock")));

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

	public static boolean existeId(int idalmacen) {

		try {
			Class.forName("org.postgresql.Driver");
			Connection conexion = Conexion.crearConexion();
			Statement sentencia = conexion.createStatement();
			ResultSet resultado = sentencia
					.executeQuery("SELECT idalmacen FROM stock where idalmacen = " + idalmacen + " ");
			int id = resultado.getInt("idalmacen");

			resultado.close();
			sentencia.close();
			conexion.close();
			if (id > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public static boolean existeCod(int codarticulo) {

		try {
			Class.forName("org.postgresql.Driver");
			Connection conexion = Conexion.crearConexion();
			Statement sentencia = conexion.createStatement();
			ResultSet resultado = sentencia
					.executeQuery("SELECT codarticulo FROM stock where codarticulo = " + codarticulo + " ");
			int cod = resultado.getInt("codarticulo");

			resultado.close();
			sentencia.close();
			conexion.close();
			if (cod > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public static Stock obtenerStock(int idAlmacen, int codArticulo) {

		try {
			Class.forName("org.postgresql.Driver");
			Connection conexion = Conexion.crearConexion();
			Statement sentencia = conexion.createStatement();
			ResultSet resultado = sentencia.executeQuery(
					"SELECT * FROM stock where codArticulo = " + codArticulo + " and idalmacen = " + idAlmacen + " ");

			while (resultado.next()) {

				Stock alm = new Stock(resultado.getInt("idalmacen"), resultado.getInt("codarticulo"),
						resultado.getInt("stock"));
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

	public static int guardarStock(Stock stk) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conexion = Conexion.crearConexion();
			Statement sentencia = conexion.createStatement();
			sentencia.executeUpdate("INSERT INTO stock " + "VALUES (" + stk.getidAlmacen() + ", " + stk.getcodArticulo()
					+ ", " + stk.getstock() + " )");
			sentencia.close();
			conexion.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return stk.getidAlmacen();
	}

	public static boolean actualizarStock(Stock stk) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conexion = Conexion.crearConexion();
			Statement sentencia = conexion.createStatement();
			sentencia.executeUpdate("UPDATE stock SET stock = " + stk.getstock() + " WHERE codarticulo = "
					+ stk.getcodArticulo() + " and idAlmacen = " + stk.getidAlmacen() + " ");
			sentencia.close();
			conexion.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean eliminarStock(int idAlmacen, int codArticulo) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conexion = Conexion.crearConexion();
			Statement sentencia = conexion.createStatement();
			sentencia.executeUpdate(
					"DELETE  FROM stock WHERE idalmacen = " + idAlmacen + " and codArticulo = " + codArticulo + "");
			sentencia.close();
			conexion.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}