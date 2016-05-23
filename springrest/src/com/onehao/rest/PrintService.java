package com.onehao.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.onehao.context.SpringApplicationContext;
import com.onehao.customer.CustomerBo;


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
