package com.almacen;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.ClientResponse;

public class ListadoAlmacenes {

	public static void main(String[] args) {

		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/Almacenes/rest/almacen/");
		String s = webResource.accept("application/json").get(String.class);
		System.out.println(s);
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);  
		int status = response.getStatus();
		System.out.print(status);
	}
}
