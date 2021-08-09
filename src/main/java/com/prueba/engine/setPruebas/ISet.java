package com.prueba.engine.setPruebas;

import com.prueba.engine.dto.IncidenciaDTO;
import com.prueba.engine.dto.QueryDTO;
import java.util.List;
import org.openqa.selenium.WebDriver;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carlos Andres Ortiz <teccarlosandres@gmail.co>
 */
public interface ISet {
    
    public abstract List<IncidenciaDTO> runSet(QueryDTO queryDTO, WebDriver driver);
    
}
