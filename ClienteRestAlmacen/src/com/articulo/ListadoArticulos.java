package com.articulo;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.ClientResponse;


public class ListadoArticulos {

	public static void main(String[] args) {

		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/Almacenes/rest/articulo/");
		String s = webResource.accept("application/json").get(String.class);
		System.out.println(s);
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);  
		int status = response.getStatus();
		System.out.print(status);
	}
}
