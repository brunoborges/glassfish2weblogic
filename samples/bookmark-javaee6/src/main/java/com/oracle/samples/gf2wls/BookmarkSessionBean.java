package com.oracle.samples.gf2wls;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author bruno
 */
@Stateless
@Path("bookmark")
public class BookmarkSessionBean {

    @PersistenceContext
    private EntityManager em;

    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(Bookmark entity) {
        em.persist(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Long id, Bookmark entity) {
        em.merge(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        em.remove(find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Bookmark find(@PathParam("id") Long id) {
        return em.find(Bookmark.class, id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<Bookmark> findAll() {
        return em.createNamedQuery("Bookmark.findAll", Bookmark.class).getResultList();
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public int count() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<Bookmark> rt = cq.from(Bookmark.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        javax.persistence.Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
