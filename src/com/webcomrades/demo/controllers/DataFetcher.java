package com.webcomrades.demo.controllers;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.webcomrades.demo.Globals;
import org.apache.http.client.HttpResponseException;



public class DataFetcher {

	public interface ResponseHandler {
		public String handleResponse(InputStream input) throws IOException;
	}
	
	public DataFetcher() {
		
	}
	
	public String getFromServer(ResponseHandler responseHandler, String urlPath, int connectTimeout, int readTimeout) throws IOException {
		
		URL url = new URL(Globals.baseUrl + urlPath);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setConnectTimeout(connectTimeout);
		conn.setReadTimeout(readTimeout);
				
		try {
				
			InputStream stream = conn.getInputStream();
			
			if(conn.getResponseCode() >= 400) {
				throw new HttpResponseException(conn.getResponseCode(), conn.getResponseMessage());
			}

			return responseHandler.handleResponse(new BufferedInputStream(stream));
		} catch (IOException e) {
			 // TODO: do something !
		} finally {
			conn.disconnect();
		}
		
		return null;
	}
}
