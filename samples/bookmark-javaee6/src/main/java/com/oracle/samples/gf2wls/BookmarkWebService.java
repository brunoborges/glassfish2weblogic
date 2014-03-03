/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oracle.samples.gf2wls;

import java.util.List;
import javax.inject.Inject;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author bruno
 */
@WebService(serviceName = "BookmarkWebService")
public class BookmarkWebService {

    @Inject
    private BookmarkSessionBean ejbRef;

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "entity") Bookmark entity) {
        ejbRef.create(entity);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "id") Long id, @WebParam(name = "entity") Bookmark entity) {
        ejbRef.edit(id, entity);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "id") Long id) {
        ejbRef.remove(id);
    }

    @WebMethod(operationName = "find")
    public Bookmark find(@WebParam(name = "id") Long id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Bookmark> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }
    
}
