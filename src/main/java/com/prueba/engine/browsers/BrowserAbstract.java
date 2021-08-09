/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.engine.browsers;

import com.prueba.engine.dto.QueryDTO;
import com.prueba.engine.setPruebas.SetAbstract;
import com.prueba.engine.utils.Parameters;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Carlos Andres Ortiz <teccarlosandres@gmail.co>
 */
public abstract class BrowserAbstract {

    protected WebDriver driver;
    private QueryDTO queryDTO;
    private SetAbstract setAbstract;

    public BrowserAbstract(QueryDTO dTO) {
        this.queryDTO = dTO;
        loadSet();
    }

    public void runSet() {
        setAbstract.runSet();
    }

    private void loadSet() {
        try {
            String nameClass = Parameters.getValue(queryDTO.getIdSet());
            ClassLoader classLoader = BrowserAbstract.class.getClassLoader();
            Class aClass = classLoader.loadClass(nameClass);
            Constructor<?> ctor = aClass.getConstructor(BrowserAbstract.class);
            setAbstract = (SetAbstract) ctor.newInstance(this);
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(BrowserAbstract.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void openPage(String url){
        driver.get(url);
    }
    
    public void close(){
        driver.close();
    }
    
    public WebElement getElement(By by){
        return driver.findElement(by);
    }
    
    public void maximixar(){
        driver.manage().window().maximize();
    }

    public QueryDTO getQueryDTO() {
        return queryDTO;
    }

    public void setQueryDTO(QueryDTO queryDTO) {
        this.queryDTO = queryDTO;
    }

}
