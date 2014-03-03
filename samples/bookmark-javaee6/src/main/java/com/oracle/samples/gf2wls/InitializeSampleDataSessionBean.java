/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.samples.gf2wls;

import javax.annotation.PostConstruct;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author bruno
 */
@DataSourceDefinition(
        name = "java:app/jdbc/gf2wls",
        className = "com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource",
        url = "jdbc:mysql://localhost:3306/gf2wls?zeroDateTimeBehavior=convertToNull",
        user = "gf2wls",
        password = "gf2wls")
@Singleton
@Startup
public class InitializeSampleDataSessionBean {

    @Inject
    private BookmarkSessionBean bookmarkSessionBean;

    @PostConstruct
    public void initialize() {
        Bookmark b = new Bookmark();
        b.setName("Oracle");
        b.setUrl("http://www.oracle.com");
        bookmarkSessionBean.create(b);
    }

}
