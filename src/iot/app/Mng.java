/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iot.app;

import gnu.io.CommPortIdentifier;
import java.util.LinkedList;
import java.util.List;
import iot.util.RXTXUtil;
import modelos.CasaCliente;

/**
 *
 * @author Vinicius
 */
public class Mng {
    RXTXUtil rxtxUtil;
    List <CommPortIdentifier> portas;
    
    public Mng () throws Exception {
        rxtxUtil = new RXTXUtil();
        portas = new LinkedList<>();
        conectar();
    }
    
    // conectar a porta serial
    public void conectar () throws Exception {
        portas = rxtxUtil.listarPortasSeriais();
        System.out.println(portas.get(0).getName());
        rxtxUtil.conectar(portas.get(0));
    }
    
    // desconectar a porta serial
    public void desconectar () throws Exception {
        rxtxUtil.desconectar();
    }
    
    // public void enviar dados
    public void enviarDados(String dados) throws Exception {
        rxtxUtil.enviarDados(dados);
    }
    
    // ligar e desligar aparelhos
    public void ligarAparelhos (CasaCliente casa) throws Exception {
        if (casa.getVentilador()) {
            enviarDados("1");
            System.out.println("Ligou Ventilador");
        } 
        if(!casa.getVentilador()) {
            enviarDados("2");
            System.out.println("Desligou Ventilador");
        }
        if(casa.getLuz_sala()) {
            enviarDados("3");
            System.out.println("Ligou sala");
        }
        if(!casa.getLuz_sala()) {
            enviarDados("4");
            System.out.println("Desligou sala");
        }
        if(casa.getTv()) {
            enviarDados("5");
            System.out.println("Ligou tv");
        }
        if(!casa.getTv()) {
            enviarDados("6");
            System.out.println("Desligou tv");
        }
        if(casa.getLuz_quarto()) {
            enviarDados("7");
            System.out.println("Ligou quarto");
        }
        if(!casa.getLuz_quarto()) {
            enviarDados("8");
            System.out.println("Desligou quarto");
        }
    }
}
