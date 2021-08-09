/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.engine.setPruebas;

import com.prueba.engine.browsers.BrowserAbstract;
import com.prueba.engine.dto.IncidenciaDTO;
import com.prueba.engine.dto.QueryDTO;
import com.prueba.engine.utils.Utils;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Carlos Andres Ortiz <carlos.ortiz@venko.co>
 */
public abstract class SetAbstract {

    private BrowserAbstract browser;

    public SetAbstract(BrowserAbstract browser) {
        this.browser = browser;
    }

    public abstract List<IncidenciaDTO> runSet();

    public BrowserAbstract getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserAbstract browser) {
        this.browser = browser;
    }

    public void sendKeys(WebElement element, String cadena) {
        char[] caracteres = cadena.toCharArray();
        for (int i = 0; i < caracteres.length; i++) {
            Utils.sleep(300);
            char valor = caracteres[i];
            element.sendKeys(String.valueOf(valor));
        }
    }

}
