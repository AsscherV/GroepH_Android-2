package be.kdg.groeph.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import be.kdg.groeph.controllers.NetworkController;
import be.kdg.groeph.model.TripUser;
import com.webcomrades.demo.concurrency.R;

/**
 * Created with IntelliJ IDEA.
 * <p/>
 * Date: 8/03/13
 * Time: 13:13
 */
public class MenuActivity extends Activity {







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.menu);

        Button requestLogoutButton = (Button) findViewById(R.id.btn_Logout);
        requestLogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO: invalidate the sesison
                Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

        Button publicTripsButton = (Button) findViewById(R.id.btn_Trips);
        publicTripsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO: invalidate the sesison
                Intent i = new Intent(getApplicationContext(),PublicTripsActivity.class);
                startActivity(i);
                finish();
            }
        });

        initViews();
    }

    private void initViews() {

    }

    private void getData(final String path) {
        new AsyncTask<Void, Void, TripUser>() {

            private Exception exception = null;

            @Override
            protected void onPreExecute() {

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
                if(result != null) {

                    Intent i = new Intent(getApplicationContext(),MenuActivity.class);
                    startActivity(i);
                    finish();
                    //TODO: Add the cookie to a session I guess


                } else{
                    Toast.makeText(getApplicationContext(), "Sorry wrong credentials", Toast.LENGTH_SHORT).show();
                }





            }

        }.execute();
    }
}