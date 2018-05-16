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
import com.clases.Stock;

import org.glassfish.jersey.test.JerseyTest;

public class StockTest extends JerseyTest {

	@Override
	public Application configure() {
		enable(TestProperties.LOG_TRAFFIC);
		enable(TestProperties.DUMP_ENTITY);
		return new ResourceConfig(ServicioStock.class);
	}
	
	@Test
	public void testGetStocks() {
		Response output = target("/stock").request().get();
		assertEquals("should return status 200", 200, output.getStatus());
		assertNotNull("Should return list", output.getEntity());
	}

	@Test
	public void testGetConcreto() {
		Response output = target("/stock/1/2").request().get();
		assertEquals("Should return status 200", 200, output.getStatus());
		assertNotNull("Should return notification", output.getEntity());
	}

	@Test
	public void testAddStk() {
		Stock stck = new Stock(2,2,10);
        Response output = target("/stock")
                .request()
                .post(Entity.entity(stck, MediaType.APPLICATION_JSON));

        assertEquals("Should return status 201", 201, output.getStatus());
        assertNotNull("1", output.getEntity());
	}

	@Test
	public void testUpdateStk() {
		Stock stock = new Stock(2,2,15);
        Response output = target("/stock")
                .request()
                .put(Entity.entity(stock, MediaType.APPLICATION_JSON));
        assertEquals("Should return status 202", 202, output.getStatus());
	}

	@Test
	public void testDeleteStk() {
		Response output = target("/stock/2/2").request().delete();
        assertEquals("Should return status 200", 200, output.getStatus());
	}

}
