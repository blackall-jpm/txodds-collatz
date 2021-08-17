package collatztests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.io.InputStreamReader;

public class TestMethods {

	public int getOrpost (String strURL, String strGetOrPost) throws IOException {
		URL url = new URL(strURL);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod(strGetOrPost);
		int http_status = con.getResponseCode();
		String strStatus = con.getResponseMessage();
		System.out.println("Status=" + http_status + " " + strStatus);
		con.disconnect();
		return http_status;
	}

	public int getOrpostPerformance (String strURL, String strGetOrPost) throws IOException {
		URL url = new URL(strURL);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod(strGetOrPost);
		int http_status = con.getResponseCode();
		//String strStatus = con.getResponseMessage();
		//System.out.println("Status=" + http_status + " " + strStatus);
		con.disconnect();
		return http_status;
	}

}
