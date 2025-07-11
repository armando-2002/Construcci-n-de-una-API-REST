package com.poortoys.resources;

import java.util.List;

import com.poortoys.model.Author;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class AuthorResource {
	@PersistenceContext(unitName="CRUD_PU")
    private EntityManager em;

	@GET
    public List<Author> findAll() {
        return em.createQuery("SELECT a FROM Author a", Author.class).getResultList();
    }

    @GET
    @Path("/{id}")
    public Response find(@PathParam("id") Long id) {
        Author author = em.find(Author.class, id);
        if (author == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(author).build();
    }

    @POST
    @Transactional
    public Response create(Author author) {
        em.persist(author);
        return Response.status(Response.Status.CREATED).entity(author).build();
    }

    @PUT
    @Transactional
    public Response update(Author author) {
        em.merge(author);
        return Response.ok(author).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        Author author = em.find(Author.class, id);
        if (author != null) {
            em.remove(author);
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
