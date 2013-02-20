package com.webcomrades.demo.activities;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.webcomrades.demo.concurrency.R;
import com.webcomrades.demo.controllers.NetworkController;

import com.webcomrades.demo.model.TripUser;



public class MainActivity extends Activity {

	private final String path = "/rest/login?Username=test&Password=test"; // url path: value for 1EUR in USD.
	
	private TextView resultTextView;
	private ProgressBar progressbar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		Button requestButton = (Button) findViewById(R.id.Button_doRequest);
		requestButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				getData(path);
			}
		});
				
		initViews();
	}
	
	private void initViews() {
		resultTextView = (TextView) findViewById(R.id.TextView_Result);
		progressbar = (ProgressBar) findViewById(R.id.ProgressBar);
		
		resultTextView.setText("");
		resultTextView.setVisibility(View.VISIBLE);
		progressbar.setVisibility(View.GONE);
	}

	private void getData(final String path) {
		new AsyncTask<Void, Void, TripUser>() {
			
			private Exception exception = null;
			
			@Override
			protected void onPreExecute() {
				resultTextView.setVisibility(View.GONE);
				progressbar.setVisibility(View.VISIBLE);
				super.onPreExecute();
			}
			
			@Override
			protected TripUser doInBackground(Void... params) {
                TripUser tripUser = null;
				
				try {
                    tripUser = new NetworkController().getDataFromServer(path);
				} catch (Exception e) {
					exception = e;
				}
				
				return tripUser;
			}

			@Override
			protected void onPostExecute(TripUser result) {
				if(exception == null && result != null) {
					resultTextView.setText(result.toString());
				} else {
					Toast.makeText(getApplicationContext(), "Oops. Something went wrong!", Toast.LENGTH_SHORT).show();
				}
				
				resultTextView.setVisibility(View.VISIBLE);
				progressbar.setVisibility(View.GONE);
			}

		}.execute();
	}

}
