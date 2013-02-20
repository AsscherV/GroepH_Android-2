package com.webcomrades.demo.controllers;

import java.io.IOException;
import java.io.InputStream;

import com.webcomrades.demo.Globals;
import com.webcomrades.demo.model.TripUser;
import org.apache.commons.io.IOUtils;

import com.webcomrades.demo.controllers.DataFetcher.ResponseHandler;
import com.webcomrades.demo.model.Currency;



public class NetworkController {
	
	private DataFetcher dataFetcher;
	private DataParser dataParser;
	
	public NetworkController() {
		this.dataParser = new DataParser();
		this.dataFetcher = new DataFetcher();
	}
	
	public TripUser getDataFromServer(String path) throws IOException {
		return dataParser.parseData(dataFetcher.getFromServer(new ResponseHandler() {
			@Override
			public String handleResponse(InputStream input) throws IOException {
				return IOUtils.toString(input);
			}
		}, path, Globals.connectTimeout, Globals.readTimeout));
	}
	
}
