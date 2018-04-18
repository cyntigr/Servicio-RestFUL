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
import com.clases.Articulos;
import com.metodos.ArticuloMe;


@Path("/articulo")
public class ServicioArticulo {

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Articulos> getArt() {
		return ArticuloMe.getArticulos();
	}

	@GET
	@Path("/{codarticulo}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Articulos getConcreto(@PathParam("codarticulo") int codarticulo) {
		return ArticuloMe.getArticulo(codarticulo);
	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	public Response addAlmacen(Articulos art) throws JSONException {
		ArticuloMe.addArticulo(art);
		return Response.status(200).build();
	}

	@PUT
	@Produces({ MediaType.APPLICATION_JSON })
	public Response updateAlmacen(Articulos art) throws JSONException {
		ArticuloMe.updateArticulo(art);
		return Response.status(200).build();
	}

	@DELETE
	@Path("/{codarticulo}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteAlmacen(@PathParam("codarticulo") int codarticulo) {
		ArticuloMe.deleteArticulo(codarticulo);
		return Response.status(200).build();
	}
}
