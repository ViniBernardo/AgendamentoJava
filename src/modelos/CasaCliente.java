/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Time;
import java.sql.Timestamp;

/**
 *
 * @author Vinicius
 */
public class CasaCliente {
    
    private Integer id_cadastro;
    private Boolean ventilador;
    private Boolean luz_sala;
    private Boolean tv;
    private Boolean luz_quarto;
    private Timestamp data;
    private Time hora;
    private Boolean status;

    public CasaCliente(Boolean ventilador, Boolean luz_sala, Boolean tv, Boolean luz_quarto, Timestamp data, Time hora) {
        this.ventilador = ventilador;
        this.luz_sala = luz_sala;
        this.tv = tv;
        this.luz_quarto = luz_quarto;
        this.data = data;
        this.hora = hora;
    }
    
    public CasaCliente () {
        
    }

    public Integer getId_cadastro() {
        return id_cadastro;
    }

    public void setId_cadastro(Integer id_cadastro) {
        this.id_cadastro = id_cadastro;
    }

    public Boolean getVentilador() {
        return ventilador;
    }

    public void setVentilador(Boolean ventilador) {
        this.ventilador = ventilador;
    }

    public Boolean getLuz_sala() {
        return luz_sala;
    }

    public void setLuz_sala(Boolean luz_sala) {
        this.luz_sala = luz_sala;
    }

    public Boolean getTv() {
        return tv;
    }

    public void setTv(Boolean tv) {
        this.tv = tv;
    }

    public Boolean getLuz_quarto() {
        return luz_quarto;
    }

    public void setLuz_quarto(Boolean luz_quarto) {
        this.luz_quarto = luz_quarto;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
