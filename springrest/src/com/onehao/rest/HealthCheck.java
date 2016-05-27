package com.onehao.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.jboss.resteasy.annotations.providers.jackson.Formatted;

import com.onehao.context.SpringApplicationContext;
import com.onehao.health.IHealth;
import com.onehao.health.impl.Health;


@Path("/health")
public class HealthCheck {
	@GET
	@Produces("application/json")
	@Path("/aaa")
	@Formatted
	public Health getFormattedProduct() {
		return new Health();
	}
	
	@XmlRootElement(name = "health")
	public static class HealthXML {
		String message = "up and runnings";
		@XmlElement
		public String getMessage() {
			return message;
		}
		@XmlElement
		public String getStatus() {
			return status;
		}
		String status = "OK";
		
		public HealthXML(){}
		public HealthXML(String message, String status){
			this.message = message;
			this.status = status;
		}
	}
	
	@GET
	@Produces("application/json")
	@Path("/check")
	@Formatted
	public Health getHealthCheck() {
		return new Health("hello michael", "OK");
	}
	
	@GET
	@Produces("application/json")
	@Path("/check/{message}")
	@Formatted
	public Response getHealthCheck2(@PathParam("message") String message) {
		IHealth health = (IHealth) SpringApplicationContext.getBean("health");
		health.setMessage(message);
		return Response.status(200).entity(health).type(MediaType.APPLICATION_JSON).build();

	}
	
	@GET
	@Produces("application/xml")
	@Path("/checkxml")
	public Response getHealthCheckXML() {
		HealthXML hx = new HealthXML("hello michael", "OK");
		GenericEntity<HealthXML> entity = new GenericEntity<HealthXML>(hx){};      
	    return Response.status(200).entity(entity).type(MediaType.APPLICATION_XML).build();
	}
	
	@GET
	@Path("/print")
	@Produces("application/json")
	@Formatted
	public Response printMessage() {

		String result = "OK";

		return Response.status(200).entity(result).build();

	}
}
