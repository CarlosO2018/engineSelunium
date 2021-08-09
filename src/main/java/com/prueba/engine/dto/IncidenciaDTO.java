/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.engine.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos Andres Ortiz <teccarlosandres@gmail.co>
 */
public class IncidenciaDTO {
    
    private List<IncidenciaDTO> incidencias = new ArrayList<>();
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<IncidenciaDTO> getIncidencias() {
        return incidencias;
    }
    
}
