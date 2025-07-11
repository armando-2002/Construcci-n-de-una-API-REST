package com.poortoys.resources;
import com.poortoys.model.Multimedia;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
@Path("/multimedia")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class MultimediaResource {
	@PersistenceContext(unitName="CRUD_PU")
	    private EntityManager em;

	@GET
	@Path("/{id}")
	public Response findById(@PathParam("id") Long id) {
	    Multimedia m = em.find(Multimedia.class, id);
	    if (m == null) return Response.status(Response.Status.NOT_FOUND).build();
	    return Response.ok(m).build();
	}

    @POST
    @Transactional
    public Response create(Multimedia multimedia) {
        em.persist(multimedia);
        return Response.status(Response.Status.CREATED).entity(multimedia).build();
    }

    @PUT
    @Transactional
    public Response update(Multimedia multimedia) {
        em.merge(multimedia);
        return Response.ok(multimedia).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        Multimedia m = em.find(Multimedia.class, id);
        if (m != null) {
            em.remove(m);
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
