/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.wsclient.test;

import com.oracle.wsclient.BookmarkWebService;
import com.oracle.wsclient.BookmarkWebService_Service;
import java.net.MalformedURLException;
import java.net.URL;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author bruno
 */
public class WSClientWebLogicTest {

    @Test
    public void testWSClient_WebLogic() throws MalformedURLException {
        URL glassFish = new URL("http://localhost:7001/bookmark-javaee6/BookmarkWebService?WSDL");
        BookmarkWebService bws = new BookmarkWebService_Service(glassFish).getBookmarkWebServicePort();
        assertTrue(bws.count() > 0);
    }

}
