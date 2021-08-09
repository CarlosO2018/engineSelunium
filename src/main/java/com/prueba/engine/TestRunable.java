/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.engine;

import com.prueba.engine.controller.WebController;
import com.prueba.engine.dto.QueryDTO;
import com.prueba.engine.utils.Parameters;

/**
 *
 * @author Carlos Andres Ortiz <teccarlosandres@gmail.co>
 */
public class TestRunable implements Runnable {

    QueryDTO dTO;

    public TestRunable(QueryDTO dTO) {
        this.dTO = dTO;
    }
    
    @Override
    public void run() {
        for (String browser : dTO.getBrowsersTest()) {
            WebController webController;
            switch (browser) {
                case Parameters.BROWSER_CHROME:
                    webController = WebController.InstanceChrome(dTO);
                    break;
                case Parameters.BROWSER_FIREFOX:
                    webController = WebController.InstanceFirefox(dTO);
                    break;
                case Parameters.BROWSER_OPERA:
                    webController = WebController.InstanceOpera(dTO);
                    break;
                default:
                    webController = WebController.InstanceChrome(dTO);
                    break;
            }
            webController.runSet();
        }

    }

}
