/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.engine.dto;

import java.util.List;

/**
 *
 * @author Carlos Andres Ortiz <teccarlosandres@gmail.co>
 */
public class QueryDTO {
    
    private String idSet;
    private List<String> browsersTest;

    public String getIdSet() {
        return idSet;
    }

    public void setIdSet(String idSet) {
        this.idSet = idSet;
    }

    public List<String> getBrowsersTest() {
        return browsersTest;
    }

    public void setBrowsersTest(List<String> browsersTest) {
        this.browsersTest = browsersTest;
    }
    
}
