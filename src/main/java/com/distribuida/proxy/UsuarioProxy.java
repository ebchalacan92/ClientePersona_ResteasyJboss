package com.distribuida.proxy;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.distribuida.dto.Usuario;

public interface UsuarioProxy {
	
	@GET
	@Consumes(value = MediaType.APPLICATION_JSON)
	List<Usuario> findall();
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario crear(Usuario p);
	
	@DELETE
	@Path("/eliminar/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String delete(@PathParam ("id") Integer id);
	
	@PUT
	@Path("/actualizar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Usuario editar(Usuario usuario);
	
	@GET @Path("/buscar/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Usuario buscar(@PathParam ("id") Integer id);
	
	
	

}
