package com.metodos;
// * Aqui recogemos los métodos que luego utilizaremos para hacer el servicio

// * estan Get , put , post , delete y get especial para acceder a un dato concreto.
// * He necesitado varias librerías como postgresql-42.2.2 , gson-2.2.4 , genson-1.4 para pasar a 
// * Json y hacer los accesos a la base de datos con jdbc.

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.clases.Stock;

public class StockMe {

	// * Con este método accedemos a la lista de todo el stock
	// * recogiendo los datos en un array list de objetos.
	public static List<Stock> getStocks() {

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

	// * Con este método mostramos un stock concreto, mediante pathparam recogemos las claves
	// * primarias necesarias para hacer el select, lo meto dentro de una lista porque me da error al 
	// * guardar en objeto, de esta forma me lo devuelve sin problema.
	public static List<Stock> getStock(int idalmacen, int codarticulo) {

		try {
			Class.forName("org.postgresql.Driver");
			Connection conexion = Conexion.crearConexion();
			Statement sentencia = conexion.createStatement();
			ResultSet resultado = sentencia.executeQuery(
					"SELECT * FROM stock where codarticulo = " + codarticulo + " and idalmacen = " + idalmacen + " ");
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

	// * Con este método añadimos un nuevo stock,
	// * recogemos en un objeto los parámetros y después los cogemos con get para
	// hacer el insert.
	public static Stock addStock(Stock stk) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conexion = Conexion.crearConexion();
			Statement sentencia = conexion.createStatement();
			sentencia.executeUpdate("INSERT INTO stock " + "VALUES (" + stk.getidalmacen() + ", " + stk.getcodarticulo() + ", " + stk.getstock() + " )");
			sentencia.close();
			conexion.close();
			return stk;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Stock updateStock(Stock stk) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conexion = Conexion.crearConexion();
			Statement sentencia = conexion.createStatement();
			sentencia.executeUpdate("UPDATE stock SET stock = " + stk.getstock() + " WHERE idalmacen = "
					+ stk.getidalmacen() + " and codarticulo = " + stk.getcodarticulo() + " ");
			sentencia.close();
			conexion.close();
			return stk;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void deleteStock(int idalmacen, int codarticulo) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conexion = Conexion.crearConexion();
			Statement sentencia = conexion.createStatement();
			sentencia.executeUpdate("DELETE  FROM stock WHERE idalmacen = " + idalmacen + " and codarticulo = " + codarticulo + "");
			sentencia.close();
			conexion.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}