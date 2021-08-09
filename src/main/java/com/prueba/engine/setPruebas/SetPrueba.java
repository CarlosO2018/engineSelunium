package com.prueba.engine.setPruebas;

import com.prueba.engine.browsers.BrowserAbstract;
import com.prueba.engine.dto.IncidenciaDTO;
import com.prueba.engine.dto.QueryDTO;
import com.prueba.engine.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Carlos Andres Ortiz <teccarlosandres@gmail.co>
 */
public class SetPrueba extends SetAbstract {

    public SetPrueba(BrowserAbstract browser) {
        super(browser);
    }
    
    @Override
    public List<IncidenciaDTO> runSet() {
      //TODO: Code del set
      return null;
    }

}
