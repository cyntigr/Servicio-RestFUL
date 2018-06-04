package com.clase.almacen.model;

//Por Cintia García Ruiz 2018

public class Stock {
	private int idAlmacen;
	private int codArticulo;
	private int stock;
	
	public Stock() {
		
	}
	
	public Stock(int idAlmacen,int codArticulo,int stock) {
		this.codArticulo = codArticulo;
		this.idAlmacen = idAlmacen;
		this.stock = stock;
	}
	public int getcodArticulo() {
		return codArticulo;
	}

	public void setcodArticulo(int codArticulo) {
		this.codArticulo = codArticulo;
	}
	public int getidAlmacen() {
		return idAlmacen;
	}

	public void setidAlmacen(int idAlmacen) {
		this.idAlmacen = idAlmacen;
	}
	public int getstock() {
		return stock;
	}

	public void setstock(int stock) {
		this.stock = stock;
	}
}