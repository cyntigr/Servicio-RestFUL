package com.clase.almacen.model;

//Por Cintia García Ruiz 2018

public class Articulo {
	private int codArticulo;
	private String nombreArticulo;
	private double pCoste;
	private double pVenta;
	
	public Articulo(){
		
	}

	public Articulo(int codArticulo, String nombreArticulo, double pCoste,double pVenta) {
		this.codArticulo = codArticulo;
		this.nombreArticulo = nombreArticulo;
		this.pCoste = pCoste;
		this.pVenta = pVenta;
	}
	
	public int getcodArticulo() {
		return codArticulo;
	}

	public void setcodArticulo(int codArticulo) {
		this.codArticulo = codArticulo;
	}
	public String getnombreArticulo() {
		return nombreArticulo;
	}

	public void setnombreArticulo(String nombreArticulo) {
		this.nombreArticulo = nombreArticulo;
	}
	public Double getpCoste() {
		return pCoste;
	}

	public void setpCoste(Double pCoste) {
		this.pCoste = pCoste;
	}
	public Double getpVenta() {
		return pVenta;
	}

	public void setpVenta(Double pVenta) {
		this.pVenta = pVenta;
	}
}
