package com.poortoys.resources;

import java.util.List;

import com.poortoys.model.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;

//generar la conexion para CRUD
@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)


public class UsuarioResource {
	@PersistenceContext(unitName="CRUD_PU")
	private EntityManager em;
	 @GET
	 public List <Usuario> listar(){
		 return em.createQuery("SELECT u FROM Usuario u",Usuario.class).getResultList();
	 }
	
	// get list por id
	 @GET
	 @Path("/{id}")
	 public Response obtener(@PathParam("id" )Long id) {
		 Usuario usuario=em.find(Usuario.class, id);
		 if(usuario==null) {
			 return Response.status(Response.Status.NOT_FOUND).build();
		 }
		 
		 
		 return Response.ok(usuario).build(); 
	 }
	 //post-crear un nuevo
	 @POST
	 @Transactional
	 public Response crear(Usuario usuario, @Context UriInfo uriInfo) {
		 em.persist(usuario);
		 UriBuilder builder =uriInfo.getAbsolutePathBuilder().path(usuario.getId().toString());
		 return Response.created(builder.build()).entity(usuario).build();
	 }

}
