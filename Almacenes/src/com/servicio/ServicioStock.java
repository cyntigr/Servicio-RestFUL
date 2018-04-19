package com.servicio;

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

	@GET
	@Path("/{idalmacen}/{codarticulo}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Stock> getConcreto(@PathParam("idalmacen") int idalmacen,@PathParam("codarticulo") int codarticulo) {
		return StockMe.getStock(idalmacen,codarticulo);
	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	public Response addAlmacen(Stock stk) throws JSONException {
		StockMe.addStock(stk);
		return Response.status(201).build();
	}

	@PUT
	@Produces({ MediaType.APPLICATION_JSON })
	public Response updateAlmacen(Stock stk) throws JSONException {
		StockMe.updateStock(stk);
		return Response.status(202).build();
	}

	@DELETE
	@Path("/{idalmacen}/{codarticulo}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteAlmacen(@PathParam("idalmacen") int idalmacen,@PathParam("codarticulo") int codarticulo) {
		StockMe.deleteStock(idalmacen,codarticulo);
		return Response.status(200).build();
	}
}