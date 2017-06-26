package recursos;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rodrigo
 */
public class Http {

    private final String USER_AGENT = "Mozilla/5.0";

    public String SendGet(String urlString, String method) throws Exception {

        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        // meu metodo pode ser GET ou DELETE
        con.setRequestMethod(method);

        //add request Header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending '"+method+"' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in
                = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //IMPRIMINDO O RESULTADO
        return response.toString();

    }
    
    public String sendPost(String urlString, String json, String method) throws Exception {
        
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        
        // meu metodo pode ser POST ou PUT
        con.setRequestMethod(method);
        
       //add request Header
        con.setRequestProperty("User-Agent", USER_AGENT);
        //definindo o modo de web service json
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(json);
        wr.flush();
        wr.close();
        
        int responseCode = con.getResponseCode();
        System.out.println("\nSending '"+method+"' request to URL : " + url);
         System.out.println("POST Parametros : " + json);
        System.out.println("Response Code : " + responseCode);
        
        // parte de leitura do metodo
        BufferedReader in
                = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //IMPRIMINDO O RESULTADO
        return response.toString();
    }
}
