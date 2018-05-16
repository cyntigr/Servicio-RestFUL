package com;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.ClientResponse;

/**
 * @author Crunchify.com
 * 
 */

public class GetPrueba {

	public static void main(String[] args) {

		Client client = Client.create();
		WebResource webResource = client.resource("http://192.168.0.99:8080/Almacen/rest/almacen/");
		String s = webResource.accept("application/json").get(String.class);
		System.out.println(s);
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);  
		int status = response.getStatus();
		System.out.print(status);
	}
}
