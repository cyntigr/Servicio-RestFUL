package com;

import java.util.Scanner;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class GetEspecifico {

	public static void main(String[] args) {
		String input = new Scanner(System.in).nextLine();
		Client client = Client.create();
		WebResource webResource = client.resource("http://192.168.0.99:8080/Almacen/rest/almacen/" + input);
		String s = webResource.accept("application/json").get(String.class);
		System.out.println(s);
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);  
		int status = response.getStatus();
		System.out.print(status);

	}

}
