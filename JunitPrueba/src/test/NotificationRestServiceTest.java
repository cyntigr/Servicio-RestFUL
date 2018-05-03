package com.test;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.jupiter.api.Test;
import com.clases.Almacen;
import com.servicio.ServicioAlmacen;

public class NotificationRestServiceTest extends JerseyTest {

	@Override
	public Application configure() {
		enable(TestProperties.LOG_TRAFFIC);
		enable(TestProperties.DUMP_ENTITY);
		return new ResourceConfig(ServicioAlmacen.class);
	}

	@Test
	public void testAll() {
		Response output = target("/almacen").request().get();
		assertEquals("should return status 200", 200, output.getStatus());
		assertNotNull("Should return list", output.getEntity());
	}

	@Test
	public void testBy() {
		Response output = target("/almacen/2").request().get();
		assertEquals("Should return status 200", 200, output.getStatus());
		assertNotNull("Should return notification", output.getEntity());
	}

	@Test
	public void testFetchByFail_DoesNotHaveDigit() {
		Response output = target("/almacen/no-id-digit").request().get();
		assertEquals("Should return status 404", 404, output.getStatus());
	}

	@Test
	public void testCreate() {
		Almacen alm = new Almacen(10, "Invoice was deleted");
		Response output = target("/almacen").request()
				.post(Entity.entity(alm, MediaType.APPLICATION_JSON));

		assertEquals("Should return status 202", 202, output.getStatus());
		assertNotNull("Should return notification", output.getEntity());
	}

	@Test
	public void testUpdate() {
		Almacen alm = new Almacen(2, "New user created at Antwerp");
		Response output = target("/almacen").request()
				.put(Entity.entity(alm, MediaType.APPLICATION_JSON));
		assertEquals("Should return status 204", 204, output.getStatus());
	}

	@Test
	public void testDelete() {
		Response output = target("/almacen/2").request().delete();
		assertEquals("Should return status 204", 204, output.getStatus());
	}

}