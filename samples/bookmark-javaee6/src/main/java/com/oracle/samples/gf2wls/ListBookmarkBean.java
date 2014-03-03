/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.samples.gf2wls;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author bruno
 */
@ManagedBean(name = "listBookmarkBean")
@RequestScoped
public class ListBookmarkBean {

    @Inject
    private BookmarkSessionBean bookmarkSessionBean;

    private List<Bookmark> listBookmarks;

    @PostConstruct
    public void initialize() {
        listBookmarks = bookmarkSessionBean.findAll();
    }

    public List<Bookmark> getListBookmarks() {
        return listBookmarks;
    }

    public String delete(Long id) {
        bookmarkSessionBean.remove(id);
        return "list?faces-redirect=true";
    }

}
