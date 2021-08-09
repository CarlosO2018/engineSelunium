package com.prueba.engine.setPruebas;

import com.prueba.engine.dto.IncidenciaDTO;
import com.prueba.engine.dto.QueryDTO;
import com.prueba.engine.utils.Utils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class SetLogin implements ISet {

    List<IncidenciaDTO> incidencias = new ArrayList<>();

    @Override
    public List<IncidenciaDTO> runSet(QueryDTO queryDTO, WebDriver driver) {
        String pattern = "yyyyMMddHHmmssSS";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String path = simpleDateFormat.format(new Date()) + driver.getClass().getName();
//        String path = new Date().toString();
        driver.manage().window().maximize();
        driver.get("https://emailservice.vinkel.co/");

        driver.findElement(By.className("hcmqpW")).click();

        Utils.screenShot(driver, "evidencias/" + path + "/sinCamposObrigatorios.png");

        List<WebElement> mensajesError = driver.findElements(By.className("invalid-feedback"));

        if (mensajesError != null && !mensajesError.isEmpty()) {
            for (WebElement message : mensajesError) {
                if (!message.getText().equals("Este es un campo obligatorio.")) {
                    IncidenciaDTO incidenciaDTO = new IncidenciaDTO();
                    incidenciaDTO.setMensaje("El mensaje del campo obligatorio no se muestra correctamente.");
                    incidencias.add(incidenciaDTO);
                    Utils.screenShot(driver, "evidencias/" + path + "/mensajeErrorCamposObligatorios.png");
                }
            }
        } else {
            IncidenciaDTO incidenciaDTO = new IncidenciaDTO();
            incidenciaDTO.setMensaje("Problemas en la visualización de los mensajes de los campos obligatorios.");
            incidencias.add(incidenciaDTO);
            Utils.screenShot(driver, "evidencias/" + path + "/mensajeErrorvisualizacion.png");
        }

        driver.navigate().refresh();
        driver.findElement(By.id("username")).sendKeys("soporte@grupodigital.co");

        driver.findElement(By.className("hcmqpW")).click();

        Utils.screenShot(driver, "evidencias/" + path + "/sinContrasena.png");

        mensajesError = driver.findElements(By.className("invalid-feedback"));
        if (mensajesError != null && !mensajesError.isEmpty()) {
            if (mensajesError.size() == 1) {
                if (!mensajesError.get(0).getText().equals("Este es un campo obligatorio.")) {
                    IncidenciaDTO incidenciaDTO = new IncidenciaDTO();
                    incidenciaDTO.setMensaje("El mensaje del campo obligatorio no se muestra correctamente.");
                    incidencias.add(incidenciaDTO);
                    Utils.screenShot(driver, "evidencias/" + path + "/mensajeErrorPassword.png");
                }
            } else {
                IncidenciaDTO incidenciaDTO = new IncidenciaDTO();
                incidenciaDTO.setMensaje("El mensaje del campo obligatorio no se muestra correctamente.");
                incidencias.add(incidenciaDTO);
                Utils.screenShot(driver, "evidencias/" + path + "/mensajeErrorVisualizacionPasswd.png");
            }
        } else {
            IncidenciaDTO incidenciaDTO = new IncidenciaDTO();
            incidenciaDTO.setMensaje("Problemas en la visualización de los mensajes de los campos obligatorios.");
            incidencias.add(incidenciaDTO);
            Utils.screenShot(driver, "evidencias/" + path + "/mensajeErrorVisualizacion.png");
        }

        driver.navigate().refresh();

        driver.findElement(By.id("username")).sendKeys("soporte@grupodigital.co");
        driver.findElement(By.id("password")).sendKeys("Qwerty2021");
        driver.findElement(By.className("hcmqpW")).click();

        Utils.sleep(2000);

        WebElement mensajePwdIncorrecto = driver.findElement(By.className("eVQcHf"));
         String mensaje = "";
        if(mensajePwdIncorrecto != null){
            mensaje = driver.findElement(By.className("eVQcHf")).getText();
        }else{
            Utils.screenShot(driver, "evidencias/" + path + "/MensajePwdIncorrectaNoVisible.png");
        }
        

        if (mensaje.equals("Contraseña incorrecta.")) {
            Utils.screenShot(driver, "evidencias/" + path + "/MensajeNoLoginOK.png");
        } else {
            Utils.screenShot(driver, "evidencias/" + path + "/MensajeNoLoginError.png");
        }

        driver.navigate().refresh();

        driver.findElement(By.id("username")).sendKeys("soporte@grupodigital.co");
        driver.findElement(By.id("password")).sendKeys("Pruebas123@");
        driver.findElement(By.className("hcmqpW")).click();
        Utils.sleep(1000);
        Utils.screenShot(driver, "evidencias/" + path + "/loginOK.png");

        driver.close();
        return incidencias;
    }

}
