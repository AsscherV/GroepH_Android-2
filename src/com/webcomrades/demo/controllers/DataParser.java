package com.webcomrades.demo.controllers;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.webcomrades.demo.model.Currency;
import com.webcomrades.demo.model.TripUser;

/**
 * @company WebComrades
 * @author Jo Somers - jo@webcomrades.be
 * @year 2013
 * @version 1.0
 */

public class DataParser {

	public DataParser() {
		
	}
	
	public TripUser parseData(String data) {
		Gson gson = new GsonBuilder().create();
		Type rootType = new TypeToken<TripUser>(){}.getType();
		
		TripUser object = gson.fromJson(data, rootType);
		if(object == null) {
			throw new JsonSyntaxException("Error while parsing data from JSON: " + data);
		}
		
		return object;
	}
	
}
