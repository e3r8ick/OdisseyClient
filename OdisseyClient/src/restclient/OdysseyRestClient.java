/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restclient;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.HttpURLConnection;

/**
 *
 * @author erick
 */
public class OdysseyRestClient{
    private final String USER_AGENT = "Mozilla/5.0";
    private String url;
    private String charset;
    
    public OdysseyRestClient(){
    	this.url = "http://52.88.91.22/Odyssey/";
    	this.charset = "UTF-8";
    }
    
    public void Login (String pUsername , String pPassword) throws MalformedURLException, IOException{
    	
		URL obj = new URL(this.url + "login_user.php");
		HttpURLConnection con =  (HttpURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		String urlParameters = String.format("username=%s&password=%s", 
			     URLEncoder.encode(pUsername, this.charset), 
			     URLEncoder.encode(pPassword, this.charset));
		
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//print result
		System.out.println(response.toString());

	}
	public static void main(String[] args) throws Exception {

		OdysseyRestClient http = new OdysseyRestClient();

//		System.out.println("Testing 1 - Send Http GET request");
//		http.sendGet();
//		
		System.out.println("\nTesting 1 - Send Http POST request");
		try{
			http.Login("root", "1234");
		}catch(ConnectException  e){
			System.out.println(e.getMessage());
		}

	}
    
}
