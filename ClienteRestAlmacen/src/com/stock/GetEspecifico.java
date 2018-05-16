package com.stock;

import java.util.Scanner;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class GetEspecifico {

	public static void main(String[] args) {
		String input = new Scanner(System.in).nextLine();
		String inputD = new Scanner(System.in).nextLine();
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/Almacenes/rest/stock/" + input
		+ "/" + inputD );
		String s = webResource.accept("application/json").get(String.class);
		System.out.println(s);
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);  
		int status = response.getStatus();
	}

}
