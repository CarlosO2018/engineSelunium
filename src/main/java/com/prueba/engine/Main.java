/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.engine;

import com.prueba.engine.controller.WebController;
import com.prueba.engine.dto.QueryDTO;
import com.prueba.engine.utils.Parameters;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos Andres Ortiz <teccarlosandres@gmail.co>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        QueryDTO dTO = dummyDto();
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
//        ExecutorService ex ecutorService = Executors.newFixedThreadPool(1);
//        for (int i = 0; i < 1; i++) {
//            executorService.execute(new TestRunable(dTO));
//        }
//
//        executorService.shutdown();
//        try {
//            if (!executorService.awaitTermination(99999999L, TimeUnit.MILLISECONDS)) {
//                executorService.shutdownNow();
//            }else{
//                executorService.shutdownNow();
//            }    
//        } catch (InterruptedException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public static QueryDTO dummyDto() {
        QueryDTO dTO = new QueryDTO();
        List<String> ids = new ArrayList<>();
        dTO.setIdSet("5201");
        List<String> browsers = new ArrayList<>();
        browsers.add(Parameters.BROWSER_CHROME);
//        browsers.add(Parameters.BROWSER_FIREFOX);
//        browsers.add(Parameters.BROWSER_OPERA);
        dTO.setBrowsersTest(browsers);
        return dTO;
    }

}
