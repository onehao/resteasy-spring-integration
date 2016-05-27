package com.onehao.rest;

import java.rmi.AccessException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.onehao.context.SpringApplicationContext;
import com.onehao.customer.CustomerBo;
import com.onehao.docker.impl.Image;


@Path("/customer")
public class PrintService {

	CustomerBo customerBo;

	@GET
	@Path("/print/{username}")
	public Response printMessage(@PathParam("username") String username) {

		customerBo = (CustomerBo) SpringApplicationContext.getBean("customerBo");
		
		String result = customerBo.getMsg(username);

		return Response.status(200).entity(result).build();

	}
	
	@GET
	@Path("/print2")
	public Response printMessage2(@QueryParam("username") String username) {

		customerBo = (CustomerBo) SpringApplicationContext.getBean("customerBo");
		
		String result = customerBo.getMsg(username);

		return Response.status(200).entity(result).build();

	}
	
	@POST
	@Path("/new")
	@Consumes("application/json")
	@Produces("application/json")
	public Response newCustomer(Image image) {

		String result = image.getName();
		
		image.setResult(String.format("%s-create",result));

		return Response.status(201).entity(image).type(MediaType.APPLICATION_JSON).build();

	}
	
	
	@POST
	@Path("/newerror")
	@Consumes("application/json")
	@Produces("application/json")
	public Response newCustomerError(Image image) throws Exception {
		
		String result = image.getName();
		
		image.setResult(String.format("%s-create",result));
		throw new AccessException("demo error");
		//return Response.status(201).entity(image).type(MediaType.APPLICATION_JSON).build();

	}

}

//@Path("/customer")
//public class PrintService {
//
//	CustomerBo customerBo;
//
//	@GET
//	@Path("/print")
//	public Response printMessage(@Context ServletContext servletContext) {
//
//		// get Spring application context
//		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
//		customerBo = ctx.getBean("customerBo", CustomerBo.class);
//
//		String result = customerBo.getMsg();
//
//		return Response.status(200).entity(result).build();
//
//	}
//
//}
