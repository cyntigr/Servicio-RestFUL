package com.clases;

public class Stock {
	private int idalmacen;
	private int codarticulo;
	private int stock;
	
	public Stock() {
		
	}
	
	public Stock(int codarticulo,int idalmacen,int stock) {
		this.codarticulo = codarticulo;
		this.idalmacen = idalmacen;
		this.stock = stock;
	}
	public int getcodarticulo() {
		return codarticulo;
	}

	public void setcodarticulo(int codarticulo) {
		this.codarticulo = codarticulo;
	}
	public int getidalmacen() {
		return idalmacen;
	}

	public void setidalmacen(int idalmacen) {
		this.idalmacen = idalmacen;
	}
	public int getstock() {
		return stock;
	}

	public void setstock(int stock) {
		this.stock = stock;
	}
}