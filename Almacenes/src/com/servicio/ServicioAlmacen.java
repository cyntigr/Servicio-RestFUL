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
import com.clases.Almacen;
import com.metodos.AlmacenMe;

//Por Cintia García Ruiz 2018

@Path("/almacen")
public class ServicioAlmacen {

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Almacen> getAlm() {
		return AlmacenMe.getAlmacenes();
	}

	@GET
	@Path("/{idalmacen}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Almacen getConcreto(@PathParam("idalmacen") int idalmacen) {
		return AlmacenMe.getAlmacen(idalmacen);
	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	public Response addAlmacen(Almacen alm)
			throws JSONException {
		AlmacenMe.addAlmacen(alm);
		return Response.status(201).build();
	}

	@PUT
	@Produces({ MediaType.APPLICATION_JSON })
	public Response updateAlmacen(Almacen alm) throws JSONException {
		AlmacenMe.updateAlmacen(alm);
		return Response.status(202).build();
	}

	@DELETE
	@Path("/{idalmacen}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteAlmacen(@PathParam("idalmacen") int idalmacen) {
		AlmacenMe.deleteAlmacen(idalmacen);
		return Response.status(200).build();
	}
}
