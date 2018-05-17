package com.clases;

//Por Cintia García Ruiz 2018

public class Articulos {
	private int codarticulo;
	private String nombrearticulo;
	private double pcoste;
	private double pventa;
	
	public Articulos(){
		
	}

	public Articulos(int codarticulo, String nombrearticulo, double pcoste,double pventa) {
		this.codarticulo = codarticulo;
		this.nombrearticulo = nombrearticulo;
		this.pcoste = pcoste;
		this.pventa = pventa;
	}
	
	public int getcodarticulo() {
		return codarticulo;
	}

	public void setcodarticulo(int codarticulo) {
		this.codarticulo = codarticulo;
	}
	public String getnombrearticulo() {
		return nombrearticulo;
	}

	public void setnombrearticulo(String nombrearticulo) {
		this.nombrearticulo = nombrearticulo;
	}
	public Double getpcoste() {
		return pcoste;
	}

	public void setpcoste(Double pcoste) {
		this.pcoste = pcoste;
	}
	public Double getpventa() {
		return pventa;
	}

	public void setpventa(Double pventa) {
		this.pventa = pventa;
	}
}
