package com.servicio;

//Por Cintia García Ruiz 2018

import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import com.clases.Stock;
import com.metodos.StockMe;

@Path("/stock")
public class ServicioStock {

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Stock> getStocks() {
		return StockMe.getStocks();
	}
	// Con PathParam recojo el parámetro a modificar , 
	// para luego enviarselo al método y realizar su función.
	@GET
	@Path("/{idalmacen}/{codarticulo}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Stock> getConcreto(@PathParam("idalmacen") int idalmacen,@PathParam("codarticulo") int codarticulo) {
		return StockMe.getStock(idalmacen,codarticulo);
	}
	// Aquí como no vamos a devolver ningun dato he utilizado response,
	// el cual te manda una número de estado para saber si se ha realizado correctamente,
	// hay diversos números de estado, "201" significa creado.
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	public Response addStk(Stock stk) throws JSONException {
		StockMe.addStock(stk);
		return Response.status(201).build();
	}
	// Aqui el servicio recibe un objeto el cual envia a la tabla y modifica el anterior,
	// como el anterior te devuelve un estado, este es "202" significa aceptado.
	@PUT
	@Produces({ MediaType.APPLICATION_JSON })
	public Response updateStk(Stock stk) throws JSONException {
		StockMe.updateStock(stk);
		return Response.status(202).build();
	}
	// Con PathParam recogemos la clave primaria para borrar el registro de la tabla,
	// aquí devolvemos un estado "200" que significa ok!
	@DELETE
	@Path("/{idalmacen}/{codarticulo}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteStk(@PathParam("idalmacen") int idalmacen,@PathParam("codarticulo") int codarticulo) {
		StockMe.deleteStock(idalmacen,codarticulo);
		return Response.status(200).build();
	}
}