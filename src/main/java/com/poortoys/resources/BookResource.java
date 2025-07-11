package com.poortoys.resources;
import com.poortoys.model.Book;
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
@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped

public class BookResource {
	@PersistenceContext(unitName="CRUD_PU")
    private EntityManager em;

	@GET
	@Path("/{id}")
	public Response findById(@PathParam("id") Long id) {
	    Book b = em.find(Book.class, id);
	    if (b == null) return Response.status(Response.Status.NOT_FOUND).build();
	    return Response.ok(b).build();
	}

	    @POST
	    @Transactional
	    public Response create(Book book) {
	        em.persist(book);
	        return Response.status(Response.Status.CREATED).entity(book).build();
	    }

	    @PUT
	    @Transactional
	    public Response update(Book book) {
	        em.merge(book);
	        return Response.ok(book).build();
	    }

	    @DELETE
	    @Path("/{id}")
	    @Transactional
	    public Response delete(@PathParam("id") Long id) {
	        Book b = em.find(Book.class, id);
	        if (b != null) {
	            em.remove(b);
	            return Response.noContent().build();
	        }
	        return Response.status(Response.Status.NOT_FOUND).build();
	    }

	    @POST
	    @Path("/{id}/publish")
	    @Transactional
	    public Response publish(@PathParam("id") Long id) {
	        Book b = em.find(Book.class, id);
	        if (b != null) {
	            b.publish();
	            return Response.ok("Book published: " + b.getTitle()).build();
	        }
	        return Response.status(Response.Status.NOT_FOUND).build();
	    }

}
