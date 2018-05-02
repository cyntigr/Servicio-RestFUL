package com;

import java.util.Scanner;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class Delete {

	public static void main(String[] args) {
		String input = new Scanner(System.in).nextLine();
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/Almacenes/rest/almacen/" + input);
		String s = webResource.accept("application/json").delete(String.class);
		System.out.println(s);
		ClientResponse response = webResource.accept("application/json").delete(ClientResponse.class);  
		int status = response.getStatus();
	}
}
