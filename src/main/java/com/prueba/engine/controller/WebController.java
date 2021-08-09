/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.engine.controller;

import com.prueba.engine.browsers.BrowserAbstract;
import com.prueba.engine.browsers.BrowserChrome;
import com.prueba.engine.browsers.BrowserFirefox;
import com.prueba.engine.browsers.BrowserOpera;
import com.prueba.engine.dto.QueryDTO;
import com.prueba.engine.utils.Parameters;

/**
 *
 * @author Carlos Andres Ortiz <teccarlosandres@gmail.co>
 */
public class WebController {

    private String browserType;
    private BrowserAbstract browser;
    private QueryDTO queryDTO;

    private WebController(String browserType, QueryDTO queryDTO) {
        this.queryDTO = queryDTO;
        this.browserType = browserType;
        createBrowser();
    }

    public static WebController InstanceChrome(QueryDTO queryDTO) {
        return new WebController(Parameters.BROWSER_CHROME, queryDTO);
    }

    public static WebController InstanceFirefox(QueryDTO queryDTO) {
        return new WebController(Parameters.BROWSER_FIREFOX, queryDTO);
    }
    
    public static WebController InstanceOpera(QueryDTO queryDTO) {
        return new WebController(Parameters.BROWSER_OPERA, queryDTO);
    }

    private void createBrowser() {
        switch (browserType) {
            case Parameters.BROWSER_CHROME:
                browser = new BrowserChrome(queryDTO);
                break;
            case Parameters.BROWSER_FIREFOX:
                browser = new BrowserFirefox(queryDTO);
                break;
            case Parameters.BROWSER_OPERA:
                browser = new BrowserOpera(queryDTO);
                break;
            default:
                browser = new BrowserChrome(queryDTO);
                break;
        }
    }

    public void runSet() {
        browser.runSet();
    }

    
    
}
