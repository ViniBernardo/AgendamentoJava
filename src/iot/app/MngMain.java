/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iot.app;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;
import modelos.CasaCliente;
import recursos.Http;

/**
 *
 * @author Vinicius
 */
public class MngMain {
    static CasaCliente casa;
    static Mng manager;
           
    public static void main(String[] args) {
        int delay = 5000;
        int interval = 1000;
        Timer timer = new Timer();
        try {
            manager = new Mng();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                  try {
                // verificando a hora do sistema
                Calendar time = new GregorianCalendar();
                String hora = time.get(Calendar.HOUR_OF_DAY)+":"+time.get(Calendar.MINUTE);
                String data = time.get(Calendar.YEAR)+"-"+(1+time.get(Calendar.MONTH))+"-"+time.get(Calendar.DAY_OF_MONTH);
 
                
                    
                    // iniciando meu objeto JSON
                    
                    System.out.println(new Date().getTime());
                    Timestamp d;
                    System.out.println("Data");
                    //System.out.println(d = new Timestamp(new Date().getTime()));
                    Http http = new Http();
                    Gson casaJSON = new Gson();
                    casa = new CasaCliente();
                    String url = "http://localhost:8080/anduino/casa_service/tempoCerto/"+new Date().getTime()+"/"+hora;
                    String chamadaJson = http.SendGet(url, "GET");
                    java.lang.reflect.Type casaJson = new TypeToken<CasaCliente>() {}.getType();
                    casa = casaJSON.fromJson(chamadaJson, casaJson);
                    System.out.println(hora);
                    if (casa.getId_cadastro() != null) {
                        System.out.println(casa.getId_cadastro());
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    System.out.println("Entrou "+casa.getId_cadastro());
                                    System.out.println("ventilador "+casa.getVentilador());
                                    System.out.println("Luz Sala "+casa.getLuz_sala());
                                    System.out.println("Tv "+casa.getTv());
                                    System.out.println("Luz Quarto "+casa.getLuz_quarto());
                                    manager.ligarAparelhos(casa);
                                    System.out.println(hora);
                                } catch (Exception ex) {
                                    System.out.println(ex.getMessage());
                                }
                                
                            }
                        });
                        thread.start();
                        
                    }
                    System.out.println(url);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        },delay,interval);
    }
}
