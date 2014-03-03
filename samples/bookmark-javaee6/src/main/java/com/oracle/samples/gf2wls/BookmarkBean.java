/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.samples.gf2wls;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author bruno
 */
@ManagedBean(name = "bookmarkBean")
@RequestScoped
public class BookmarkBean implements Serializable {

    private Bookmark bookmark;

    @Inject
    private BookmarkSessionBean bookmarkSessionBean;

    @PostConstruct
    public void initialize() {
        String bookmarkId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");

        if (bookmarkId == null || bookmarkId.trim().length() == 0) {
            bookmark = new Bookmark();
        } else {
            Long pk = Long.parseLong(bookmarkId);
            bookmark = bookmarkSessionBean.find(pk);
        }
    }

    public String save() {
        if (bookmark.getId() == null) {
            bookmarkSessionBean.create(bookmark);
        } else {
            bookmarkSessionBean.edit(bookmark.getId(), bookmark);
        }
        return "list?faces-redirect=true";
    }

    public Bookmark getBookmark() {
        return bookmark;
    }

    public void setBookmark(Bookmark bookmark) {
        this.bookmark = bookmark;
    }

}
