package com.poortoys.resources;
import com.poortoys.model.Author;
import com.poortoys.model.BookItem;

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

@Path("/book-items")

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class BookItemResource {
	@PersistenceContext(unitName="CRUD_PU")
    private EntityManager em;

	@POST
	@Transactional
	public Response create(BookItem item) {
	    if (item.getAuthor() != null && item.getAuthor().getId() != null) {
	        Author authorManaged = em.find(Author.class, item.getAuthor().getId());
	        if (authorManaged == null) {
	            return Response.status(Response.Status.BAD_REQUEST)
	                           .entity("Author with id " + item.getAuthor().getId() + " not found").build();
	        }
	        item.setAuthor(authorManaged);
	    } else {
	        return Response.status(Response.Status.BAD_REQUEST)
	                       .entity("Author is required").build();
	    }
	    em.persist(item);
	    return Response.status(Response.Status.CREATED).entity(item).build();
	}


	@GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        BookItem item = em.find(BookItem.class, id);
        if (item == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(item).build();
    }
	 @PUT
	    @Transactional
	    public Response update(BookItem item) {
	        if (item.getAuthor() != null && item.getAuthor().getId() != null) {
	            Author author = em.find(Author.class, item.getAuthor().getId());
	            if (author == null)
	                return Response.status(Response.Status.BAD_REQUEST)
	                               .entity("Author not found").build();
	            item.setAuthor(author);
	        }
	        em.merge(item);
	        return Response.ok(item).build();
	    }

	    // ───────────────────────────────────────
	    // DELETE /book-items/{id}       (borrar)
	    @DELETE
	    @Path("/{id}")
	    @Transactional
	    public Response delete(@PathParam("id") Long id) {
	        BookItem item = em.find(BookItem.class, id);
	        if (item != null) {
	            em.remove(item);
	            return Response.noContent().build();
	        }
	        return Response.status(Response.Status.NOT_FOUND).build();
	    }
}
