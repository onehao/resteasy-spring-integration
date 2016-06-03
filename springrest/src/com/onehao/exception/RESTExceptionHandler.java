package com.onehao.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.onehao.entity.Result;;

@Provider
public class RESTExceptionHandler implements ExceptionMapper<Exception> {

	@Override
	public Response toResponse(Exception e) {
		if (e instanceof UnrecognizedPropertyException || e instanceof JsonParseException) {
			return Response.status(415).entity(new Result(e.getMessage(), "failed")).tye(MediaType.APPLICATION_JSON)
					.build();
		} else {
			return Response.serverError().entity(new Result(e.getMessage(), "failed")).type(MediaType.APPLICATION_JSON)
					.build();
		}
		// return
		// Response.serverError().entity(response.toString()).type(MediaType.APPLICATION_XML).build();
	}

	public Response toResponse(UnrecognizedPropertyException e) {
		// For simplicity I am preparing error xml by hand.
		// Ideally we should create an ErrorResponse class to hold the error
		// info.
		StringBuilder response = new StringBuilder("<response>");
		response.append("<status>ERROR</status>");
		response.append("<message>" + e.getMessage() + "</message>");
		response.append("</response>");

		return Response.serverError().entity(response.toString()).type(MediaType.APPLICATION_XML).build();
	}
}
