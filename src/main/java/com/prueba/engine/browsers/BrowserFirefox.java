/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.engine.browsers;

import com.prueba.engine.dto.QueryDTO;
import com.prueba.engine.utils.Parameters;
import java.io.File;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Carlos Andres Ortiz <teccarlosandres@gmail.co>
 */
public class BrowserFirefox extends BrowserAbstract {

    public BrowserFirefox(QueryDTO dTO) {
        super(dTO);
        System.setProperty("webdriver.gecko.driver", Parameters.USER_DIR + File.separator + "/drivers/firefox/geckodriver");
        driver = new FirefoxDriver();

    }
//
//    @Override
//    public void runSet() {
//        WebDriver driver = new FirefoxDriver();
//        getSet().runSet(getQueryDTO(), driver);
//    }

}
