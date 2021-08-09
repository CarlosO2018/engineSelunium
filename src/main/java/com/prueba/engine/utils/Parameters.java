/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.engine.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos Andres Ortiz <teccarlosandres@gmail.co>
 */
public class Parameters {

    public final static String BROWSER_CHROME = "CHROME";
    public final static String BROWSER_FIREFOX = "FIREFOX";
    public final static String BROWSER_OPERA = "OPERA";
    public final static String WEB = "FIREFOX";
    public static String USER_DIR;
    private static Properties properties = new Properties();

    static {
        try {
            USER_DIR = System.getProperty("user.dir");
            properties.load(new FileInputStream(new File(USER_DIR + File.separator + "engine.properties")));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Parameters.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Parameters.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static String getValue(String key){
        return properties.getProperty(key, "");
    }
    
}
