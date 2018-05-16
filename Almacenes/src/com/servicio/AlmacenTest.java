package com.servicio;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;
import com.clases.Almacen;
import org.glassfish.jersey.test.JerseyTest;


public class AlmacenTest extends JerseyTest {

	@Override
    public Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
        return new ResourceConfig(ServicioAlmacen.class);
    }

    @Test
    public void testGetAlm(){
        Response output = target("/almacen").request().get();
        assertEquals("should return status 200", 200, output.getStatus());
        assertNotNull("Should return list", output.getEntity());
    }

    @Test
    public void testGetConcreto(){
        Response output = target("/almacen/2").request().get();
        assertEquals("Should return status 200", 200, output.getStatus());
        assertNotNull("Should return notification", output.getEntity());
    }

    @Test
    public void testAddAlmacen(){
        Almacen notification = new Almacen(15, "Samoy");
        Response output = target("/almacen")
                .request()
                .post(Entity.entity(notification, MediaType.APPLICATION_JSON));

        assertEquals("Should return status 201", 201, output.getStatus());
        assertNotNull("1", output.getEntity());
    }

    @Test
    public void testUpdateAlmacen(){
    	Almacen notification = new Almacen(2, "Super Sol");
        Response output = target("/almacen")
                .request()
                .put(Entity.entity(notification, MediaType.APPLICATION_JSON));
        assertEquals("Should return status 202", 202, output.getStatus());
    }

    @Test
    public void testDeleteAlmacen(){
        Response output = target("/almacen/1").request().delete();
        assertEquals("Should return status 200", 200, output.getStatus());
    }
}
