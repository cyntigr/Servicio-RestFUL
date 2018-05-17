package com.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;
import com.clases.Articulos;
import com.servicio.ServicioArticulo;

import org.glassfish.jersey.test.JerseyTest;

public class ArticuloTest extends JerseyTest {

	@Override
	public Application configure() {
		enable(TestProperties.LOG_TRAFFIC);
		enable(TestProperties.DUMP_ENTITY);
		return new ResourceConfig(ServicioArticulo.class);
	}

	@Test
	public void testGetArt() {
		Response output = target("/articulo").request().get();
		assertEquals("should return status 200", 200, output.getStatus());
		assertNotNull("Should return list", output.getEntity());
	}

	@Test
	public void testGetConcreto() {
		Response output = target("/articulo/2").request().get();
		assertEquals("Should return status 200", 200, output.getStatus());
		assertNotNull("Should return notification", output.getEntity());
	}

	@Test
	public void testAddArt() {
		Articulos art = new Articulos(15, "Hilo",2.20,3.95);
        Response output = target("/articulo")
                .request()
                .post(Entity.entity(art, MediaType.APPLICATION_JSON));

        assertEquals("Should return status 201", 201, output.getStatus());
        assertNotNull("1", output.getEntity());
	}

	@Test
	public void testUpdateArt() {
		Articulos art = new Articulos(15, "Seda",2.20,3.95);
        Response output = target("/articulo")
                .request()
                .put(Entity.entity(art, MediaType.APPLICATION_JSON));
        assertEquals("Should return status 202", 202, output.getStatus());
	}

	@Test
	public void testDeleteArt() {
		Response output = target("/articulo/15").request().delete();
        assertEquals("Should return status 200", 200, output.getStatus());
	}

}
