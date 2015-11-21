/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restclient;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.net.HttpURLConnection;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;



/**
 *
 * @author erick
 */
public class OdysseyRestClient{
	protected final String USER_AGENT = "Mozilla/5.0";
	protected String url;
	protected String charset;
	protected int uid;

	public OdysseyRestClient(){
		this.url = "http://52.88.91.22/Odyssey/";
		this.charset = "UTF-8";
	}
	public void disconnect (int pUid) throws MalformedURLException, IOException, ParseException{

		URL obj = new URL(this.url + "disconnect.php");
		HttpURLConnection con =  (HttpURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		String urlParameters = String.format("uid=%s", 
				URLEncoder.encode(Integer.toString(pUid), this.charset));

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

		JSONParser parser = new JSONParser();


		try{
			Object o = parser.parse(response.toString());
			JSONObject j = (JSONObject) o;
			this.uid = Integer.parseInt(j.get("ID").toString());

		}catch(ParseException e){

			//print result
			System.out.println(e.getMessage());
		}
	}

	public void Login (String pUsername , String pPassword) throws MalformedURLException, IOException, ParseException{

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

		JSONParser parser = new JSONParser();


		try{
			Object o = parser.parse(response.toString());
			JSONObject j = (JSONObject) o;
			this.uid = Integer.parseInt(j.get("ID").toString());

		}catch(ParseException e){

			//print result
			System.out.println(e.getMessage());
		}
	}

	public void Unfriend (int pUid , int pFid) throws IOException{

		String urlParameters = String.format("uf&uid=%s&fid=%s", 
				URLEncoder.encode(Integer.toString(pUid), this.charset), 
				URLEncoder.encode(Integer.toString(pFid), this.charset));

		URL obj = new URL(this.url + "social.php?" + urlParameters);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();


		JSONParser parser = new JSONParser();


		try{
			Object o = parser.parse(response.toString());
			JSONObject j = (JSONObject) o;
			this.uid = Integer.parseInt(j.get("ID").toString());

		}catch(ParseException e){

			//print result
			System.out.println(e.getMessage());
		}
	}

	public void Befriend (int pUid , int pFid) throws IOException{

		String urlParameters = String.format("bf&uid=%s&fid=%s", 
				URLEncoder.encode(Integer.toString(pUid), this.charset), 
				URLEncoder.encode(Integer.toString(pFid), this.charset));

		URL obj = new URL(this.url + "social.php?" + urlParameters);

		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();


		JSONParser parser = new JSONParser();


		try{
			Object o = parser.parse(response.toString());
			JSONObject j = (JSONObject) o;
			this.uid = Integer.parseInt(j.get("ID").toString());

		}catch(ParseException e){

			//print result
			System.out.println(e.getMessage());
		}
	}

	public void Comment(int pUid , int pSid, String pComment) throws IOException{
		URL obj = new URL(this.url + "social.php");
		HttpURLConnection con =  (HttpURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		String urlParameters = String.format("c=c&uid=%s&sid=%s&comm=%s", 
				URLEncoder.encode(Integer.toString(pUid), this.charset),
				URLEncoder.encode(Integer.toString(pSid), this.charset),
				URLEncoder.encode(pComment, this.charset));

		// Send post request
		con.setDoOutput(true);
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);
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

		JSONParser parser = new JSONParser();
	
		if (!response.toString().isEmpty()){
			try{
				Object o = parser.parse(response.toString());
				JSONObject j = (JSONObject) o;
				this.uid = Integer.parseInt(j.get("ID").toString());

			}catch(ParseException e){

				//print result
				e.printStackTrace();

			}
	
		}
	}
	public void ChangeSongMetadata(int pSid, String pName , String pArtist, String pAlbum, String pLyrics , String pGenre, String pYear) throws IOException{
		URL obj = new URL(this.url + "song.php");
		HttpURLConnection con =  (HttpURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		String urlParameters = String.format("csmd=c&sid=%s&", pSid);
		boolean multiple = false;

		if (!pName.isEmpty()) {
			if (multiple == true)
				urlParameters =  urlParameters + "&";
			urlParameters = urlParameters + "name="+ pName;
			multiple = true;
		}
		if (!pYear.isEmpty()) {
			if (multiple == true)
				urlParameters =  urlParameters + "&";
			urlParameters = urlParameters + "year="+ pYear;
			multiple = true;
		}
		if (!pArtist.isEmpty()) {			
			
			if (multiple == true)
				urlParameters =  urlParameters + "&";
			urlParameters = urlParameters + "artist="+ pArtist;
			multiple = true;
		}
		if (!pGenre.isEmpty()) {
			
			if (multiple == true)
				urlParameters =  urlParameters + "&";
			urlParameters = urlParameters + "genre="+ pGenre;
			multiple = true;
		}
		if (!pLyrics.isEmpty()) {
			if (multiple == true)
				urlParameters =  urlParameters + "&";
			urlParameters = urlParameters + "lyrics="+ pLyrics;
			multiple = true;
		}
		
		if (!pAlbum.isEmpty()) {
			
			if (multiple == true)
				urlParameters =  urlParameters + "&";
			urlParameters = urlParameters + "album="+ pAlbum;
			multiple = true;
		}

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

		JSONParser parser = new JSONParser();
		
		
		if (!response.toString().isEmpty()){
			System.out.println(response);
	
		}
	}

	public void uploadSong(int pUid, String pSongPath) throws IOException{
		File f = new File (pSongPath);
//		String attachmentName = "file";
//		String attachmentFileName = f.getName();
		String crlf = "\r\n";
		//String twoHyphens = "--";
		String boundary =  "*****";
		
		HttpURLConnection httpUrlConnection = null;
		URL url = new URL("http://52.88.91.22/Odyssey/song.php?ups&uid=" + Integer.toString(pUid));
		httpUrlConnection = (HttpURLConnection) url.openConnection();
		httpUrlConnection.setUseCaches(false);
		httpUrlConnection.setDoOutput(true);

		httpUrlConnection.setRequestMethod("POST");
		httpUrlConnection.setRequestProperty("Connection", "Keep-Alive");
		httpUrlConnection.setRequestProperty("Cache-Control", "no-cache");
		httpUrlConnection.setRequestProperty(
				"Content-Type", "multipart/form-data;boundary=" + boundary);

		try (
				OutputStream output = httpUrlConnection.getOutputStream();
				PrintWriter writer = new PrintWriter(new OutputStreamWriter(output, charset), true);
				) {

			// Send binary file.
			writer.append("--" + boundary).append(crlf);
			writer.append("Content-Disposition: form-data; file=\"f\"; filename=\"" + f.getName() + "\"").append(crlf);
			writer.append("Content-Type: audio").append(crlf);
			writer.append("Content-Transfer-Encoding: binary").append(crlf);
			writer.append(crlf).flush();
			Files.copy(f.toPath(), output);
			output.flush(); // Important before continuing with writer!
			writer.append(crlf).flush(); // CRLF is important! It indicates end of boundary.

			// End of multipart/form-data.
			writer.append("--" + boundary + "--").append(crlf).flush();
			writer.close();
		}
		InputStream responseStream = new 
				BufferedInputStream(httpUrlConnection.getInputStream());

		BufferedReader responseStreamReader = 
				new BufferedReader(new InputStreamReader(responseStream));

		String line = "";
		StringBuilder stringBuilder = new StringBuilder();

		while ((line = responseStreamReader.readLine()) != null) {
			stringBuilder.append(line).append("\n");
		}
		responseStreamReader.close();

		String response = stringBuilder.toString();
		responseStream.close();
		httpUrlConnection.disconnect();
		
		System.out.println(response);
		
	}

	public void like (int pUid, int pSid) throws IOException{

		String urlParameters = String.format("Like&uid=%s&sid=%s", 
				URLEncoder.encode(Integer.toString(pUid), this.charset), 
				URLEncoder.encode(Integer.toString(pSid), this.charset));

		URL obj = new URL(this.url + "social.php?" + urlParameters);

		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();


		JSONParser parser = new JSONParser();


		try{
			Object o = parser.parse(response.toString());
			JSONObject j = (JSONObject) o;
			this.uid = Integer.parseInt(j.get("ID").toString());

		}catch(ParseException e){

			//print result
			System.out.println(e.getMessage());
		}
	}
	public void dislike (int pUid, int pSid) throws IOException{

		String urlParameters = String.format("Dislike&uid=%s&sid=%s", 
				URLEncoder.encode(Integer.toString(pUid), this.charset), 
				URLEncoder.encode(Integer.toString(pSid), this.charset));

		URL obj = new URL(this.url + "social.php?" + urlParameters);

		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();


		JSONParser parser = new JSONParser();


		try{
			Object o = parser.parse(response.toString());
			JSONObject j = (JSONObject) o;
			this.uid = Integer.parseInt(j.get("ID").toString());

		}catch(ParseException e){

			//print result
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args) throws Exception {

		OdysseyRestClient http = new OdysseyRestClient();

		//		System.out.println("Testing 1 - Send Http GET request");
		//		http.sendGet();
		//		
		System.out.println("\nTesting 1 - Send Http POST request");
		//http.Login("root", "1234");
		//http.disconnect(3);
		//http.Befriend(3, 7);
//		http.Unfriend(3, 7);
//		http.uploadSong(3, "/home/zyoruk/AUD-20150402-WA0001.mp3");
//		http.Comment(3, 35, "MeGusta");
//		http.ChangeSongMetadata(35, "Test", "", "", "", "Metal", "");
		http.like(3, 35);
		http.dislike(3, 35);

	}

}
