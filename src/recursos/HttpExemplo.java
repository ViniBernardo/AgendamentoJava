package recursos;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.LinkedList;
import java.util.List;
import modelos.CasaCliente;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vinicius
 */
public class HttpExemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Http http = new Http();
        String url = "http://localhost:8080/anduino/casa_service"; // inserir url
        
        String method = "/tempoCerto"; // inserir metodo
        try {
            // chamada para os metodos get e delete
            //String chamadaJson = http.SendGet(url, method);
            
            CasaCliente casa = new CasaCliente();
            Gson casaJSON = new Gson();
            
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
