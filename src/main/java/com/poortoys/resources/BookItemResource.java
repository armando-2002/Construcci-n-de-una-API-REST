package com.poortoys.resources;

import java.util.List;

import com.poortoys.model.BookItem;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/book-items")

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class BookItemResource {
	@PersistenceContext(unitName="CRUD_PU")
    private EntityManager em;

    @POST
    public void create(BookItem item) {
        em.persist(item);
    }

    @GET
    public List<BookItem> findAll() {
        return em.createQuery("SELECT b FROM BookItem b", BookItem.class).getResultList();
    }
}
