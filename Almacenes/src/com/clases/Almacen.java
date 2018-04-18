package com.clases;

import org.json.JSONException;
import org.json.JSONObject;

public class Almacen {
	private int idalmacen;
	private String nombrealmacen;
	
	public Almacen() {
		
	}
	
	public Almacen(int idalmacen,String nombrealmacen) {
		this.idalmacen = idalmacen;
		this.nombrealmacen = nombrealmacen;
	}
	
	public int getidalmacen() {
		return idalmacen;
	}

	public void setidalmacen(int idalmacen) {
		this.idalmacen = idalmacen;
	}

	public String getnombrealmacen() {
		return nombrealmacen;
	}

	public void setnombrealmacen(String nombrealmacen) {
		this.nombrealmacen = nombrealmacen;
	}
	
	@Override
    public String toString() {
            try {
                    return new JSONObject().put("id", idalmacen).put("NombreAlmacen", nombrealmacen).toString();
            } catch (JSONException e) {
                    return null;
            }
    }
}
