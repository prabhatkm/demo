/**
 * 
 */
package com.example.demo.api;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.Services;

/**
 * @author prabhatkumar.mishra
 *
 */
@Path("/")
@RestController
@Produces(MediaType.APPLICATION_JSON)
public class Api {

	@Autowired
	private Services service; 
	
	@GET
	@Path("/simple")
	public Response simple() {
	
		return Response.ok().entity(service.simple()).build();
	}
	
	@GET
	@Path("/ioop")
	public Response ioOperation() throws IOException {
	
		return Response.ok().entity(service.iooperation()).build();
	}
	
	@GET
	@Path("/cpuop")
	public Response cpuOperation() {
	
		return Response.ok().entity(service.cpuoperation()).build();
	}
}