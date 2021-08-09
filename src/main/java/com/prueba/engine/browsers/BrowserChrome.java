/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.engine.browsers;

import com.prueba.engine.dto.QueryDTO;
import com.prueba.engine.utils.Parameters;
import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Carlos Andres Ortiz <teccarlosandres@gmail.co>
 */
public class BrowserChrome extends BrowserAbstract{
       
    public BrowserChrome(QueryDTO dTO) {
        super(dTO);
        System.setProperty("webdriver.chrome.driver", Parameters.USER_DIR + File.separator + "/drivers/chrome/chromedriver");
        driver = new ChromeDriver();
    }   
    
}
