/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.samples.gf2wls;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bruno
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Bookmark.findAll", query = "select b from Bookmark b")
})
@XmlRootElement
public class Bookmark implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Basic(optional = false)
    @NotNull
    private String name;

    @Basic(optional = false)
    @NotNull
    private String url;

    @Basic
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.name);
        hash = 41 * hash + Objects.hashCode(this.url);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final Bookmark other = (Bookmark) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        } else if (!Objects.equals(this.url, other.url)) {
            return false;
        }

        return true;
    }

}
