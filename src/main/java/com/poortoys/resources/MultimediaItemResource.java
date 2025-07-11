package com.poortoys.resources;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import java.util.List;

import com.poortoys.model.MultimediaItem;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
@Path("/multimedia-items")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class MultimediaItemResource {
	@PersistenceContext(unitName="CRUD_PU")
    private EntityManager em;

	@GET
    public List<MultimediaItem> findAll() {
        return em.createQuery("SELECT mi FROM MultimediaItem mi", MultimediaItem.class).getResultList();
    }
	

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        MultimediaItem item = em.find(MultimediaItem.class, id);
        if (item == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(item).build();
    }

    @POST
    @Transactional
    public Response create(MultimediaItem item) {
        em.persist(item);
        return Response.status(Response.Status.CREATED).entity(item).build();
    }
    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, MultimediaItem mi) {
        MultimediaItem ex = em.find(MultimediaItem.class, id);
        if (ex == null) return Response.status(Response.Status.NOT_FOUND).build();
        ex.setTitle(mi.getTitle());
        ex.setFormat(mi.getFormat());
        ex.setResolution(mi.getResolution());
        em.merge(ex);
        return Response.ok(ex).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        MultimediaItem mi = em.find(MultimediaItem.class, id);
        if (mi != null) {
            em.remove(mi);
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

}
