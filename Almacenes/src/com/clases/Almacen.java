package com.clases;

import org.json.JSONException;
import org.json.JSONObject;

public class Almacen {
	private int idAlmacen;
	private String nombreAlmacen;
	
	public Almacen() {
		
	}
	
	public Almacen(int idAlmacen,String nombreAlmacen) {
		this.idAlmacen = idAlmacen;
		this.nombreAlmacen = nombreAlmacen;
	}
	
	public int getidAlmacen() {
		return idAlmacen;
	}

	public void setidAlmacen(int idAlmacen) {
		this.idAlmacen = idAlmacen;
	}

	public String getnombreAlmacen() {
		return nombreAlmacen;
	}

	public void setnombreAlmacen(String nombreAlmacen) {
		this.nombreAlmacen = nombreAlmacen;
	}
	
	@Override
    public String toString() {
            try {
                    return new JSONObject().put("id", idAlmacen).put("NombreAlmacen", nombreAlmacen).toString();
            } catch (JSONException e) {
                    return null;
            }
    }
}
