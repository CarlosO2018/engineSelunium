/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.engine.utils;

import com.prueba.engine.setPruebas.SetLogin;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Carlos Andres Ortiz <teccarlosandres@gmail.co>
 */
public class Utils {

    public static void screenShot(WebDriver driver, String path) {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(Parameters.USER_DIR + File.separator + path);
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public static void sleep(int mili) {
        try {
            Thread.sleep(mili);
        } catch (InterruptedException ex) {
            Logger.getLogger(SetLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
