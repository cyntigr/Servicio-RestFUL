package com;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

/**
 * @author Crunchify.com
 * 
 */

public class GetPrueba {
	public static void main(String[] args) {
		
		System.out.println(
				"\n============Output:============ \n" + callURL("http://localhost:8080/Almacenes/rest/almacen"));
	}

	public static String callURL(String myURL) {
		System.out.println("Requested URL: " + myURL);
		StringBuilder stringb = new StringBuilder();
		URLConnection urlConn = null;
		InputStreamReader input = null;
		try {
			URL url = new URL(myURL);
			urlConn = url.openConnection();
			if (urlConn != null)
				urlConn.setReadTimeout(60 * 1000);
			if (urlConn != null && urlConn.getInputStream() != null) {
				input = new InputStreamReader(urlConn.getInputStream(), Charset.defaultCharset());
				BufferedReader bufferedReader = new BufferedReader(input);
				if (bufferedReader != null) {
					int aux;
					while ((aux = bufferedReader.read()) != -1) {
						stringb.append((char) aux);
					}
					bufferedReader.close();
				}
			}
			input.close();
		} catch (Exception e) {
			throw new RuntimeException("Exception while calling URL:" + myURL, e);
		}

		return stringb.toString();

	}
}
